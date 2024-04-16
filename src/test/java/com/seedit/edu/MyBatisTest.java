package com.seedit.edu;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import org.apache.ibatis.session.SqlSessionFactory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/spring/context-datasource.xml" })
public class MyBatisTest {
	private static final Logger logger = LoggerFactory.getLogger(MyBatisTest.class);
	
	@Inject
	private SqlSessionFactory sessionFactory;
	
	@Test
	public void testSessionFactory() {
		logger.info("\n Session Factory : " + sessionFactory);
	}
	
	@Test
	public void testSqlSession() {
		try (SqlSession session = sessionFactory.openSession()) {
			logger.info("\n Sql Session : " + session);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
