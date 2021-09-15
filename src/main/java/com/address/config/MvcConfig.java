package com.address.config;

import com.address.dao.AddressDao;
import com.address.dao.AddressDaoImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.address"})
public class MvcConfig {

    @Bean
    public InternalResourceViewResolver viewResolver() {

        InternalResourceViewResolver vr = new InternalResourceViewResolver();
        vr.setPrefix("/");
        vr.setSuffix(".jsp");

        return vr;
    }
    @Bean
    public DriverManagerDataSource getDataSource() {

        DriverManagerDataSource bds = new DriverManagerDataSource();
        bds.setDriverClassName("com.mysql.jdbc.Driver");
        bds.setUrl("jdbc:mysql://localhost:3306/ams");
        bds.setUsername("root");
        bds.setPassword("");

        return bds;
    }
    @Bean
    public AddressDao getAddressDao() {
        return new AddressDaoImp(getDataSource());
    }
}