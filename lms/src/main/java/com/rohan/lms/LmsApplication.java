package com.rohan.lms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.rohan.lms.config.JwtFilter;

@SpringBootApplication
public class LmsApplication extends SpringBootServletInitializer {  //SpringBootServletInitializer for war only

	 @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) { //for war
        return application.sources(LmsApplication.class);
    }
	 
	public static void main(String[] args) {
		SpringApplication.run(LmsApplication.class, args);
	}
	
	@Bean
    public FilterRegistrationBean jwtFilter() {
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new JwtFilter());
        registrationBean.addUrlPatterns("/*");

        return registrationBean;
    }
	
	@Bean
	public HibernateJpaSessionFactoryBean sessionFactory() {
	    return new HibernateJpaSessionFactoryBean();
	}
	
	/*@Bean
	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {  
	    ObjectMapper mapper = new ObjectMapper();
	    mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
	    MappingJackson2HttpMessageConverter converter =
	                new MappingJackson2HttpMessageConverter(mapper);
	    return converter;
	} */
}
