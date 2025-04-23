package org.serendipity.type;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Serendipity
 * @description JDBC类型枚举
 * @date 2025-04-23 20:07
 **/
public enum JdbcType {
    /**
     * 整型
     */
    INTEGER(Types.INTEGER),
    /**
     * 浮点
     */
    FLOAT(Types.FLOAT),
    /**
     * 双精度浮点
     */
    DOUBLE(Types.DOUBLE),
    /**
     * 十进制
     */
    DECIMAL(Types.DECIMAL),
    /**
     * 可变字符
     */
    VARCHAR(Types.VARCHAR),
    /**
     * 时间戳
     */
    TIMESTAMP(Types.TIMESTAMP);

    public final int TYPE_CODE;
    private static Map<Integer,JdbcType> codeLookup = new HashMap<>();

    // 就将数字对应的枚举型放入 HashMap
    static {
        for (JdbcType type : JdbcType.values()) {
            codeLookup.put(type.TYPE_CODE, type);
        }
    }

    JdbcType(int code) {
        this.TYPE_CODE = code;
    }

    public static JdbcType forCode(int code)  {
        return codeLookup.get(code);
    }
}
