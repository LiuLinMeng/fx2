package cn.fx2.account.config.database;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Configuration
@MapperScan(basePackages = DataSourceConfig.PACKAGE, sqlSessionFactoryRef = "sqlSessionFactory")
public class DataSourceConfig {
    private final Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);
    static final String PACKAGE = "fx2.database.dao.account.**";
    static final String MAPPER_LOCATION = "classpath:mapper/account/**/*Mapper.xml";

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.initialSize}")
    private int initialSize;

    @Value("${spring.datasource.minIdle}")
    private int minIdle;

    @Value("${spring.datasource.maxActive}")
    private int maxActive;

    @Value("${spring.datasource.maxWait}")
    private int maxWait;

    @Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;

    @Value("${spring.datasource.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;

    @Value("${spring.datasource.validationQuery}")
    private String validationQuery;

    @Value("${spring.datasource.testWhileIdle}")
    private boolean testWhileIdle;

    @Value("${spring.datasource.testOnBorrow}")
    private boolean testOnBorrow;

    @Value("${spring.datasource.testOnReturn}")
    private boolean testOnReturn;

    @Value("${spring.datasource.poolPreparedStatements}")
    private boolean poolPreparedStatements;

    @Value("${spring.datasource.maxPoolPreparedStatementPerConnectionSize}")
    private int maxPoolPreparedStatementPerConnectionSize;

    @Value("${spring.datasource.maxOpenPreparedStatements}")
    private int maxOpenPreparedStatements;

    @Value("${spring.datasource.filters}")
    private String filters;

    @Value("{spring.datasource.connectionProperties}")
    private String connectionProperties;

    @Bean(name = "dynamicDataSource")
    @Primary
    public DynamicDataSource dynamicDataSource() {
        DynamicDataSource dynamicDataSource = DynamicDataSource.getInstance();
        DruidDataSource datasource = new DruidDataSource();

        datasource.setUrl(this.dbUrl);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setDriverClassName(driverClassName);

        //configuration
        datasource.setInitialSize(initialSize);
        datasource.setMinIdle(minIdle);
        datasource.setMaxActive(maxActive);
        datasource.setMaxWait(maxWait);
        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        datasource.setValidationQuery(validationQuery);
        datasource.setTestWhileIdle(testWhileIdle);
        datasource.setTestOnBorrow(testOnBorrow);
        datasource.setTestOnReturn(testOnReturn);
        datasource.setPoolPreparedStatements(poolPreparedStatements);
        datasource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        datasource.setMaxOpenPreparedStatements(maxOpenPreparedStatements);
        try {
            datasource.setFilters(filters);
            logger.info("get datasource", datasource.toString());
        } catch (SQLException e) {
            logger.error("druid configuration initialization druidFilter ,errMsg = {}, stack information = {}", e.getMessage(), e);
        }
        try {
            datasource.init();
        } catch (SQLException e) {
            logger.error("create connection holder error ,errMsg = {}, stack info = {}", e.getMessage(), e);
        }
        //以后可以拆分成读写分离
        Map<Object, Object> map = new HashMap<>();
        map.put("def", datasource);

        dynamicDataSource.setTargetDataSources(map);
        dynamicDataSource.setDefaultTargetDataSource(datasource);

        return dynamicDataSource;
    }

    @Bean(name = "transactionManager")
    @Primary
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dynamicDataSource());
    }

    @Bean(name = "sqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dynamicDataSource") DataSource dynamicDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dynamicDataSource);
        //sessionFactory.setTypeAliasesPackage("cn.w959.exhibit.base.entity,cn.w959.exhibit.bus.entity");
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(DataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }




    /*
     * @Bean(name="transactionManager") public DataSourceTransactionManager
     * transactionManager(){ return new DataSourceTransactionManager(dataSource());
     * }
     */


}
