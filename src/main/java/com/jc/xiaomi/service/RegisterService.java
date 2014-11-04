package com.jc.xiaomi.service;

import com.jc.xiaomi.util.HttpTools;

/**
 * 注册服务
 * Created by 冯晓东 on 2014/11/4 0004.
 */
public class RegisterService {

    private static final String register_url = "https://account.xiaomi.com/pass/register";
    private static final String getcode_url = "https://account.xiaomi.com/pass/getCode?icodeType=register&_=1415095871861";
    private static final String getphone_url = "https://account.xiaomi.com/pass/sendPhoneTicket";
//    phone:15383516854
//    icode:u7f6qq

    public static void register() {
        //打开注册页面
        HttpTools.get(register_url);
        //输入手机号

        //获取图片验证码

        //获取手机验证码

        //填充注册表单，提交
    }


    public static void main(String[] args) {
        register();

    }

}
