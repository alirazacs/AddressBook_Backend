package com.address.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;



//this frontcontroller class is our Web App initializer where our web starts...our main method...gets called behind the scenes..
public class FrontControllerConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {

        return new Class[] { MvcConfig.class };
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