package com.tastycai.multidatasource.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.tastycai.multidatasource.config.properties.WmsDatasourceProperty;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
@MapperScan(sqlSessionFactoryRef = "wmsSqlsessionFactory",basePackages = WmsDatasourceConfig.PACKAGE)
public class WmsDatasourceConfig {

    @Autowired
    private WmsDatasourceProperty datasourceProperty;

    public static final String PACKAGE = "com.tastycai.multidatasource.wms.dao";

    private static String MAPPER_LOCATION = "classpath:com/tastycai/multidatasource/wms/dao/*.xml";;

    // 数据源
    @Bean("wmsDatasource")
    public DataSource dataSource() throws Exception{

        DruidDataSource druid = new DruidDataSource();
        // 监控统计拦截的filters
        druid.setFilters(datasourceProperty.filter);

        // 配置基本属性
        druid.setDriverClassName(datasourceProperty.driverClassName);
        druid.setUsername(datasourceProperty.username);
        druid.setPassword(datasourceProperty.password);
        druid.setUrl(datasourceProperty.url);

        //初始化时建立物理连接的个数
        druid.setInitialSize(datasourceProperty.initialSize);
        //最大连接池数量
        druid.setMaxActive(datasourceProperty.maxActive);
        //最小连接池数量
        druid.setMinIdle(datasourceProperty.minIdle);
        //获取连接时最大等待时间，单位毫秒。
        druid.setMaxWait(datasourceProperty.maxWait);
        //间隔多久进行一次检测，检测需要关闭的空闲连接
        druid.setTimeBetweenEvictionRunsMillis(datasourceProperty.timeBetweenEvictionRunsMillis);
        //一个连接在池中最小生存的时间
        druid.setMinEvictableIdleTimeMillis(datasourceProperty.minEvictableIdleTimeMillis);
        //用来检测连接是否有效的sql
        druid.setValidationQuery(datasourceProperty.validationQuery);
        //建议配置为true，不影响性能，并且保证安全性。
        druid.setTestWhileIdle(datasourceProperty.testWhileIdle);
        //申请连接时执行validationQuery检测连接是否有效
        druid.setTestOnBorrow(datasourceProperty.testOnBorrow);
        druid.setTestOnReturn(datasourceProperty.testOnReturn);
        //是否缓存preparedStatement，也就是PSCache，oracle设为true，mysql设为false。分库分表较多推荐设置为false
        druid.setPoolPreparedStatements(datasourceProperty.poolPreparedStatements);
        // 打开PSCache时，指定每个连接上PSCache的大小
        druid.setMaxPoolPreparedStatementPerConnectionSize(datasourceProperty.maxPoolPreparedStatementPerConnectionSize);

        return druid;
    }

    // jdbcTemplate
    @Bean("wmsJdbcTemplate")
    JdbcTemplate jdbcTemplate(@Qualifier("wmsDatasource") DataSource dataSource){

        return new JdbcTemplate(dataSource);
    }

    // sqlSessionFactory
    @Bean("wmsSqlsessionFactory")
    SqlSessionFactory sqlSessionFactory(@Qualifier("wmsDatasource") DataSource dataSource) throws Exception {

        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATION));

        return factoryBean.getObject();
    }


}
