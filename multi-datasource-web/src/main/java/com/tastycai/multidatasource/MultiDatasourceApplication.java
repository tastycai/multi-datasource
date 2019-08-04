package com.tastycai.multidatasource;

import com.tastycai.multidatasource.config.JswmsDatasourceConfig;
import com.tastycai.multidatasource.config.SmsDatasourceConfig;
import com.tastycai.multidatasource.config.WmsDatasourceConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScans(
        {@MapperScan(sqlSessionFactoryRef = "smsSqlsessionFactory", basePackages = SmsDatasourceConfig.PACKAGE),
                @MapperScan(sqlSessionFactoryRef = "wmsSqlsessionFactory", basePackages = WmsDatasourceConfig.PACKAGE),
                @MapperScan(sqlSessionFactoryRef = "jswmsSqlsessionFactory", basePackages = JswmsDatasourceConfig.PACKAGE)}
)
public class MultiDatasourceApplication {

    public static void main(String[] args){

        SpringApplication.run(MultiDatasourceApplication.class, args);
    }
}
