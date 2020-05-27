package com.example.demo;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@MapperScan(basePackages = {"com.example.demo.mapper1"},
    sqlSessionFactoryRef = "sqlSessionFactory1")
public class DataSource1Config {

	@Bean
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource.datasource1")
	public DataSourceProperties datasource1Properties() {
	    return new DataSourceProperties();
	}

	@Bean(name = {"datasource1"})
	@Primary
	public DataSource datasource1(
	    @Qualifier("datasource1Properties") DataSourceProperties properties) {
	    return properties.initializeDataSourceBuilder().build();
	}

	@Bean(name = {"txManager1"})
	@Primary
	public PlatformTransactionManager txManager1(@Qualifier("datasource1") DataSource dataSource1) {
	    return new DataSourceTransactionManager(dataSource1);
	}

	@Bean(name = {"sqlSessionFactory1"})
	@Primary
	public SqlSessionFactory sqlSessionFactory(@Qualifier("datasource1") DataSource datasource1)
	    throws Exception {
	    SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();

        // MyBatis のコンフィグレーションファイル
        ResourcePatternResolver resolver = ResourcePatternUtils.getResourcePatternResolver(
                new DefaultResourceLoader());
        sqlSessionFactory.setConfigLocation(resolver.getResource("classpath:mybatis-config.xml"));
	    sqlSessionFactory.setDataSource(datasource1);
	    sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:com/example/demo/mapper/*.xml"));
	    return (SqlSessionFactory) sqlSessionFactory.getObject();
	}

}
