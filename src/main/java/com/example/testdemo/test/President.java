package com.example.testdemo.test;

import lombok.Data;

/**
 * 测试 单例模式
 *
 * @author ：ShiYI
 * @date ：Created in 2021/9/8
 */
@Data
public class President {
    private String a;

        private static volatile President instance = null;    //保证instance在所有线程中同步
        //private避免类在外部被实例化
        private President() {

        }

        public static synchronized President getInstance() {
            //在getInstance方法上加同步
            if (instance == null) {
                instance = new President();

            }
            return instance;

        }

}
