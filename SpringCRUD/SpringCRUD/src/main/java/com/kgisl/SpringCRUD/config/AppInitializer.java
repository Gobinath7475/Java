package com.kgisl.SpringCRUD.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    {
        System.out.println("DEFAULT_SERVLET_NAME");
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { WebConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;

    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };

    }
}
