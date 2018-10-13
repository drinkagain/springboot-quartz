package com.jiuxian.configure;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DruidDBConfig {

	@Value("${spring.datasource.url}")
	private String dbUrl;

	@Value("${spring.datasource.username}")
	private String username;

	@Value("${spring.datasource.password}")
	private String password;

	@Value("${spring.datasource.driver-class-name}")
	private String driverClassName;

	@Value("${spring.datasource.dbcp2.initial-size}")
	private int initialSize;

	@Value("${spring.datasource.dbcp2.min-idle}")
	private int minIdle;

	@Value("${spring.datasource.dbcp2.validation-query}")
	private String validationQuery;

	@Value("${spring.datasource.dbcp2.test-while-idle}")
	private boolean testWhileIdle;

	@Value("${spring.datasource.dbcp2.test-on-borrow}")
	private boolean testOnBorrow;

	@Value("${spring.datasource.dbcp2.test-on-return}")
	private boolean testOnReturn;

	@Value("${spring.datasource.dbcp2.pool-prepared-statements}")
	private boolean poolPreparedStatements;

	@Bean(name="dataSource") // 声明其为Bean实例
	@Primary // 在同样的DataSource中，首先使用被标注的DataSource
	public DataSource dataSource() {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(this.dbUrl);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setDriverClassName(driverClassName);
        datasource.setInitialSize(initialSize);
        datasource.setMinIdle(minIdle);
        datasource.setValidationQuery(validationQuery);
        datasource.setTestWhileIdle(testWhileIdle);
        datasource.setTestOnBorrow(testOnBorrow);
        datasource.setTestOnReturn(testOnReturn);
        datasource.setPoolPreparedStatements(poolPreparedStatements);
		return datasource;
	}
}