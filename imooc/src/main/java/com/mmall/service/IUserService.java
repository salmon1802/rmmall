package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;

/**
 * @date 2020-12-1 - 13:15
 * Created by Salmon
 */
public interface IUserService {

     ServerResponse<User> login(String username, String password);

     ServerResponse<String> register(User user);

     public ServerResponse<String> checkValid(String str,String type);

     public ServerResponse selectQuestion(String username);

     public ServerResponse<String> checkAnswer(String username,String question,String answer);

     public ServerResponse<String> forgetResetPassword(String username,String passwordNew,String forgetToken);

}
