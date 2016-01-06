package com.kang.springboot_template;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
@Component
public class EnableSynchronizeOnSessionPostProcessor
    implements BeanPostProcessor {
    private static final Logger logger = LoggerFactory
            .getLogger(EnableSynchronizeOnSessionPostProcessor.class);

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		 if (bean instanceof RequestMappingHandlerAdapter) {
	            RequestMappingHandlerAdapter adapter =
	                (RequestMappingHandlerAdapter) bean;
	            logger.info("enable synchronizeOnSession => {}", adapter);
	            adapter.setSynchronizeOnSession(true); // (1)
	        }
	        return bean;
	    }


}