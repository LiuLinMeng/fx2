package cn.fx2.account.config.database;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.HashMap;
import java.util.Map;


public class DynamicDataSource extends AbstractRoutingDataSource {
    private static DynamicDataSource instance;
    private static final byte[] lock = new byte[0];
    private static final Map<Object, Object> dataSourceMap = new HashMap<>();

    @Override
    public void setTargetDataSources(Map<Object, Object> targetDataSources) {
        super.setTargetDataSources(targetDataSources);
        dataSourceMap.putAll(targetDataSources);
        super.afterPropertiesSet();// 必须添加该句，否则新添加数据源无法识别到
    }

    public Map<Object, Object> getDataSourceMap() {
        return dataSourceMap;
    }

    @Override
    protected Object determineCurrentLookupKey() {
        /*if (StringUtils.isBlank(dbKey)) {
			dbKey = "read";
		}*/
        return DatabaseContextHolder.getDBKey();
    }

    private DynamicDataSource() {
    }

    public static synchronized DynamicDataSource getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new DynamicDataSource();
                }
            }
        }
        return instance;
    }
}