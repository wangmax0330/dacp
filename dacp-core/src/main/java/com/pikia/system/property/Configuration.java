package com.pikia.system.property;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;

public class Configuration {
	private static Configuration conf = new Configuration();
	private Properties prop = null;

	private static Logger LOG = LoggerFactory.getLogger(Configuration.class);

	private String propsPattern = "classpath*:config/dacp_*.properties";

	private String[] builtinProperties = { "dacp_core.properties", "dacp_web.properties", "dacp_kpi.properties" };

	private Configuration() {
		this.prop = new Properties();
		try {
			for (int i = 0; i < this.builtinProperties.length; i++) {
				String propName = this.builtinProperties[i];
				InputStream in = Configuration.class.getClassLoader().getResourceAsStream("config/" + propName);
				if (in != null) {
					this.prop.load(new InputStreamReader(in, "utf-8"));
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Configuration getInstance() {
		return conf;
	}

	public String getProperty(String key) {
		return this.prop.getProperty(key);
	}

	private boolean isBuildInProp(String propFilename) {
		for (int i = 0; i < this.builtinProperties.length; i++) {
			String buildInFilename = this.builtinProperties[i];
			if (buildInFilename.equalsIgnoreCase(propFilename)) {
				return true;
			}
		}
		return false;
	}

	public void loadClasspathProperties(ApplicationContext applicationContext) {
		LOG.info("加载{}配置文件", this.propsPattern);
		try {
			Resource[] resources = applicationContext.getResources(getInstance().propsPattern);
			Resource[] arrayOfResource1;
			int j = (arrayOfResource1 = resources).length;
			for (int i = 0; i < j; i++) {
				Resource resource = arrayOfResource1[i];
				if ((resource != null) && (resource.isReadable()) && (!isBuildInProp(resource.getFilename()))) {
					try {
						this.prop.load(new InputStreamReader(resource.getInputStream(), "utf-8"));
						LOG.info("{}加载成功", resource.getFilename());
					} catch (IOException e) {
						e.printStackTrace();
						LOG.warn("{}加载失败", resource.getFilename());
					}
				}
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}