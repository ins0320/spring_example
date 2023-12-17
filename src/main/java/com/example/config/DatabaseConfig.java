package com.example.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;


/*디비 연동전에 임시로 넣는 코드(DB를 사용하지 않겠다.)
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})*/

@MapperScan(basePackages = "com.example.*")  // mapper scan 추가!!!(db클래스 기본 패키지 경로 설정)
@Configuration // 설정용 Spring bean으로 등록
public class DatabaseConfig {

	@Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);

        Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mappers/*Mapper.xml"); //쿼리문 저장형식 지정 (~Mapper.xml)
        sessionFactory.setMapperLocations(res);

        return sessionFactory.getObject();
    }
}
