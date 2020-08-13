package com.dw.mybatisloginterceptor.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.jexl3.JexlEngine;
import org.apache.commons.jexl3.JexlException;
import org.apache.commons.jexl3.internal.Engine;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.springframework.stereotype.Component;

import java.sql.Statement;
import java.util.List;
import java.util.Properties;

@Intercepts({
        @Signature(type = StatementHandler.class, method = "update", args = { Statement.class }),
        @Signature(type = StatementHandler.class, method = "query", args = { Statement.class, ResultHandler.class})
})
@Slf4j
@Component
public class MybatisLogInterceptor implements Interceptor {
    private JexlEngine engine = new Engine();

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        final StatementHandler handler = (StatementHandler) invocation.getTarget();
        final BoundSql boundSql = handler.getBoundSql();
        final String sql = boundSql.getSql();
        final Object param = handler.getParameterHandler().getParameterObject();
        String sql2 = bindCustomObjectParam(boundSql, param, sql);
        Object o =invocation.proceed();
        log.debug("=======================================================================");
        log.debug("sql:\n{}", sql2);
        log.debug("=======================================================================");
        return o;
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
//        return null;
    }

    @Override
    public void setProperties(Properties properties) {

    }

    private String bindCustomObjectParam(final BoundSql boundSql, final Object param, final String sql) {
        String sql2 = sql;
        List<ParameterMapping> parameterMappingList = boundSql.getParameterMappings();
        for (ParameterMapping mapping : parameterMappingList) {
            // 获取Param值
            String propKey = mapping.getProperty();
            Object propValue = null;
            try {
                propValue = engine.getProperty(param, propKey);
            } catch (JexlException e) {
                String msg = String.format("SKIP PROPERTY - [%s]. (no such public getter or field on parameter object.).", propValue);
                log.warn(msg, e);
                continue;
            }
            // 格式化参数
            Class<?> javaType = mapping.getJavaType();
            if (String.class == javaType) {
                sql2 = sql2.replaceFirst("\\?", "'" + propValue + "'");
            } else {
                if(propValue == null){
                    sql2 = sql2.replaceFirst("\\?", "null");
                }else{
                    sql2 = sql2.replaceFirst("\\?", "'" + propValue + "'");
                }
            }
        }
        return sql2;
    }
}
