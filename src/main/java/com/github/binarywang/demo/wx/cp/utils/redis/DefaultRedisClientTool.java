package com.github.binarywang.demo.wx.cp.utils.redis;

import java.io.Serializable;

/**
 * 使用默认redis的工具
 *
 * @author zhangyt
 */
public class DefaultRedisClientTool extends RedisClientTool {

    //=== 通用组 ===

    /**
     * 获取值
     * @param key 键
     */
    public static String get(String key) {
        return get(defaultDomain, key);
    }

    /**
     * set 值
     *
     * 注意没有设置过期时间
     * @param key 键
     * @param value 值
     */
    public static String set(String key, String value) {
        return set(defaultDomain, key, value);
    }

    /**
     * 设置 值
     *
     * 设置过期时间
     * @param key 键
     * @param value 值
     * @param expireSeconds 到期时间
     */
    public static String setex(String key, String value, int expireSeconds) {
        return setex(defaultDomain, key, value, expireSeconds);
    }

    /**
     * 删除 值
     *
     * 设置过期时间
     * @param key 键
     */
    public static Long del(String key) {
        return del(defaultDomain, key);
    }

    /**
     * 判断是否存在
     *
     * 设置过期时间
     * @param key 键
     */
    public static boolean exists(String key) {
        return exists(defaultDomain, key);
    }

    /**
     * 设置过期时间
     *
     * @param key 键
     */
    public static Long expire(String key, int expiredSeconds) {
        return expire(defaultDomain, key, expiredSeconds);
    }

    //====== hash 结构系列 =====
    /**
     * 获取值
     * @param key 键
     * @param field 域
     */
    public static String hget(String key, String field) {
        return hget(defaultDomain, key, field);
    }

    /**
     * 设置 值
     *
     * 注意没有设置过期时间
     * @param key 键
     * @param value 值
     */
    public static Long hset(String key, String field, String value) {
        return hset(defaultDomain, key, field, value);
    }

    /**
     * 删除 值
     *
     * 设置过期时间
     * @param key 键
     */
    public static Long hdel(String key, String field) {
        return hdel(defaultDomain, key, field);
    }

    //======  自动序列化方式  ==
    /**
     * 获取值
     * @param key 键
     */
    public static <T> T get(String key, Class<T> clazz) {
        return get(defaultDomain, key, clazz);
    }

    /**
     * 获取值
     *
     * @param key 键
     */
    public static <T> T getObject(String key, Class<T> clazz) {
        return getObject(defaultDomain, key, clazz);
    }

    /**
     * set 值
     *
     * 注意没有设置过期时间
     * @param key 键
     * @param value 值 必须是可序列化的
     */
    public static String set(String key, Serializable value) {
        return set(defaultDomain, key, value);
    }

    /**
     * set 值
     *
     * 注意没有设置过期时间
     * @param key 键
     * @param value 值 必须是可序列化的
     */
    public static String setObject(String key, Serializable value) {
        return setObject(defaultDomain, key, value);
    }

    /**
     * set 值
     *
     * 注意没有设置过期时间
     * @param key 键
     * @param value 值 必须是可序列化的
     * @param expiredSeconds 到期时间
     */
    public static String setex(String key, Serializable value, int expiredSeconds) {
        return setex(defaultDomain, key, value, expiredSeconds);
    }

    /**
     * set 值
     *
     * 注意没有设置过期时间
     * @param key 键
     * @param value 值 必须是可序列化的
     * @param expiredSeconds 到期时间
     */
    public static String setexObject(String key, Serializable value, int expiredSeconds) {
        return setexObject(defaultDomain, key, value, expiredSeconds);
    }

    /**
     * 获取值
     * @param key 键
     * @param field 域
     */
    public static <T> T hget(String key, String field, Class<T> clazz) {
        return hget(defaultDomain, key, field, clazz);
    }

    /**
     * 获取值
     * @param key 键
     * @param field 域
     */
    public static <T> T hgetObject(String key, String field, Class<T> clazz) {
        return hgetObject(defaultDomain, key, field, clazz);
    }

    /**
     * set 值
     *
     * 注意没有设置过期时间
     * @param key 键
     * @param field 域
     * @param value 值 必须是可序列化的
     */
    public static Long hset(String key, String field, Serializable value) {
        return hset(defaultDomain, key, field, value);
    }

    /**
     * set 值
     *
     * 注意没有设置过期时间
     * @param key 键
     * @param field 域
     * @param value 值 必须是可序列化的
     */
    public static Long hsetObject(String key, String field, Serializable value) {
        return hsetObject(defaultDomain, key, field, value);
    }

    /**
     * 通用命令
     * <pre>此工具类不支持的其它快捷命令</pre>
     * @param command 实现命令接口的对象
     * @return Object
     */
    public static Object execute(Command command) {
        return execute(defaultDomain, command);
    }

}
