package com.pikai.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisClientSingle implements JedisClient{
	
	private JedisPool jedisPool; 
	
	public JedisPool getJedisPool() {
		return jedisPool;
	}
	public void setJedisPool(JedisPool jedisPool) {
		this.jedisPool = jedisPool;
	}

	@Override
	public String get(String key) {
		Jedis jedis =null;
		String string ="";
		try {
			jedis = jedisPool.getResource();
			string = jedis.get(key);
			jedis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				jedisPool.returnResource(jedis);
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
		}
		return string;
		
	}

	@Override
	public String set(String key, String value) {
		Jedis jedis=null;
		try {
			jedis = jedisPool.getResource();
			String string = jedis.set(key, value);
			jedis.close();
			return string;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}finally{
			try {
				jedisPool.returnResource(jedis);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

	@Override
	public String hget(String hkey, String key) {
		String string ="";
		Jedis jedis =null;
		try {
			jedis = jedisPool.getResource();
			string = jedis.hget(hkey, key);
			jedis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				jedisPool.returnResource(jedis);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return string;
	}

	@Override
	public long hset(String hkey, String key, String value) {
		Jedis jedis=null;
		Long result=0L;
		try {
			jedis = jedisPool.getResource();
			result = jedis.hset(hkey, key, value);
			jedis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				jedisPool.returnResource(jedis);
			} catch (Exception e2) {
			}
		}
		return result;
	}

	@Override
	public long incr(String key) {
		Jedis jedis=null;
		Long result=0L;
		try {
			jedis = jedisPool.getResource();
			result = jedis.incr(key);
			jedis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				jedisPool.returnResource(jedis);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return result;
	}

	@Override
	public long expire(String key, int second) {
		Jedis jedis=null;
		Long result=0l;
		try {
			jedis = jedisPool.getResource();
			result = jedis.expire(key, second);
			jedis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				jedisPool.returnResource(jedis);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return result;
	}

	@Override
	public long ttl(String key) {
		Jedis jedis=null;
		Long result=0l;
		try {
			jedis = jedisPool.getResource();
			result = jedis.ttl(key);
			jedis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				jedisPool.returnResource(jedis);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		return result;
	}

	@Override
	public long del(String key) {
		Jedis jedis=null;
		Long result=0l;
		try {
			jedis = jedisPool.getResource();
			result = jedis.del(key);
			jedis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				jedisPool.returnResource(jedis);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return result;
	}

	@Override
	public long hdel(String hkey, String key) {
		Jedis jedis=null;
		Long result=0l;
		try {
			jedis = jedisPool.getResource();
			result = jedis.hdel(hkey, key);
			jedis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				jedisPool.returnResource(jedis);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return result;
	}
	@Override
	public long lpush(String lkey, String... strings) {
		Jedis jedis=null;
		Long result=0l;
		try {
			jedis = jedisPool.getResource();
			result = jedis.lpush(lkey, strings);
			jedis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				jedisPool.returnResource(jedis);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return result;
	}
	

	
	
}
