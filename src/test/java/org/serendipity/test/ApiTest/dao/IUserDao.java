package org.serendipity.test.ApiTest.dao;

import org.serendipity.test.ApiTest.po.User;

/**
 * @author Serendipity
 * @description
 * @date 2025-04-18 15:07
 **/
public interface IUserDao {

    String queryUserName(String uId);

    Integer queryUserAge(String uId);

    User  queryUserInfoById(Long uid);
}
