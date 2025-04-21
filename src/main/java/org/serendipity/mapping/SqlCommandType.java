package org.serendipity.mapping;

import org.omg.CORBA.UNKNOWN;

/**
 * @author Serendipity
 * @description sql 语句的类型，增删改查
 * @date 2025-04-21 19:44
 **/
public enum SqlCommandType {
    /**
     * 未知
     */
    UNKNOWN,
    /**
     * 插入
     */
    INSERT,
    /**
     * 更新
     */
    UPDATE,
    /**
     * 删除
     */
    DELETE,
    /**
     * 查找
     */
    SELECT;
}
