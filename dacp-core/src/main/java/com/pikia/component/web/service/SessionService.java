package com.pikia.component.web.service;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.pikia.component.web.controller.SimpleController;

public abstract interface SessionService {
	public static final String LOCALE_SESSION_ATTRIBUTE_NAME = SimpleController.class.getName() + ".LOCALE";

	public abstract <T> T getCurrentUser(HttpServletRequest paramHttpServletRequest, Class<T> paramClass);

	public abstract void setCurrentUser(HttpServletRequest paramHttpServletRequest, Object paramObject);

	public abstract void setCurrentUserId(HttpServletRequest paramHttpServletRequest, Long paramLong);

	public abstract Long getCurrentUserId(HttpServletRequest paramHttpServletRequest);

	public abstract Locale getCurrentLocal(HttpServletRequest paramHttpServletRequest);

	public abstract void setCurrentLocal(HttpServletRequest paramHttpServletRequest, String paramString);

	public abstract void setAttr(HttpServletRequest paramHttpServletRequest, String paramString, Object paramObject);

	public abstract Object getAttr(HttpServletRequest paramHttpServletRequest, String paramString);

	public abstract <T> T getCurrentUser(HttpSession paramHttpSession, Class<T> paramClass);

	public abstract void setCurrentUser(HttpSession paramHttpSession, Object paramObject);

	public abstract void setCurrentUserId(HttpSession paramHttpSession, Long paramLong);

	public abstract Long getCurrentUserId(HttpSession paramHttpSession);

	public abstract Locale getCurrentLocal(HttpSession paramHttpSession);

	public abstract void setCurrentLocal(HttpSession paramHttpSession, String paramString);

	public abstract void setAttr(HttpSession paramHttpSession, String paramString, Object paramObject);

	public abstract Object getAttr(HttpSession paramHttpSession, String paramString);
}
