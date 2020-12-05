package com.mmall.service;

import com.mmall.common.ServerResponse;

import java.util.Map;

/**
 * @date 2020-12-5 - 16:09
 * Created by Salmon
 */

public interface IOrderService {

    ServerResponse pay(Long orderNo, Integer userId, String path);

    ServerResponse aliCallback(Map<String,String> params);

    ServerResponse queryOrderPayStatus(Integer userId,Long orderNo);

}
