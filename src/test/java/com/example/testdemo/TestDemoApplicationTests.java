package com.example.testdemo;


import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.core.io.watch.SimpleWatcher;
import cn.hutool.core.io.watch.WatchMonitor;
import cn.hutool.core.io.watch.Watcher;
import cn.hutool.core.io.watch.watchers.DelayWatcher;
import cn.hutool.core.lang.Console;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.tokenizer.Result;
import cn.hutool.extra.tokenizer.TokenizerEngine;
import cn.hutool.extra.tokenizer.TokenizerUtil;
import cn.hutool.extra.tokenizer.Word;
import com.example.testdemo.test.President;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.WatchEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


@SpringBootTest
class TestDemoApplicationTests {

    @Test
    void contextLoads() {
        List<President> list = new ArrayList<>();
        President zt1 = President.getInstance();
        zt1.setA("a");
        President zt2 = President.getInstance();
        zt2.setA("b");
        list.add(zt1);
        list.add(zt2);
        for (President president : list) {
            System.out.println(president);
        }


    }

    //分词
    @Test
    void test() {
        TokenizerEngine engine = TokenizerUtil.createEngine();
        //解析文本
        String text = "这两个方法的区别在于返回值";
        Result result = engine.parse(text);
        //输出：这 两个 方法 的 区别 在于 返回 值
        String resultStr = CollUtil.join((Iterator<Word>) result, " ");
        System.out.println(resultStr);
    }


    //验证码
    @Test
    void test1() {
        //定义图形验证码的长和宽
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100);

        //图形验证码写出，可以写出到文件，也可以写出到流
        lineCaptcha.write("d:/line.png");
        //输出code
        Console.log(lineCaptcha.getCode());
        //验证图形验证码的有效性，返回boolean值
        System.out.println(lineCaptcha.verify("1234"));

        //重新生成验证码
        lineCaptcha.createCode();
        lineCaptcha.write("d:/line.png");
        //新的验证码
        Console.log(lineCaptcha.getCode());
        //验证图形验证码的有效性，返回boolean值
        System.out.println(lineCaptcha.verify("1234"));

    }

    @Test
    void test2() {
       /* String str = "三房一厅";
        String strSub1 = StrUtil.sub(str, 2, 3); //strSub1 -> c
        String strSub2 = StrUtil.sub(str, 2, -3); //strSub2 -> cde
        String strSub3 = StrUtil.sub(str, 3, 2); //strSub2 -> c*/

        String hashpw = BCrypt.hashpw("secret", BCrypt.gensalt());
        System.out.println(hashpw); //校验原始密码和BCrypt密码是否一致
        boolean checkpw = BCrypt.checkpw("123", "$2a$10$NlBC84MVb7F95EXYTXwLneXgCca6/GipyWR5NHm8K0203bSQMLpvm");
        System.out.println(checkpw);
    }

    @Test
    void test3() {
        /*String str = ResourceUtil.readUtf8Str("D:\\usr\\local\\tobaccocasedoc\\checkrecordaudio\\1\\许可证照片.jpg");
        System.out.println(str.getBytes(StandardCharsets.UTF_8));*/
        FileUtil.copy("D:\\usr\\local\\tobaccocasedoc\\checkrecordaudio\\1\\许可证照片.jpg", System.getProperty("user.dir") + "/src/main/java/img/test.jpg", true);
        File file = FileUtil.file(System.getProperty("user.dir") + "/src/main/java/img");
        System.out.println(file.listFiles().length);
        Watcher watcher = new SimpleWatcher() {
            @Override
            public void onModify(WatchEvent<?> event, Path currentPath) {
                if (file.listFiles().length > 3)
                    FileUtil.del(currentPath);
                Console.log("EVENT modify");
            }
        };
        WatchMonitor monitor = WatchMonitor.createAll(file, new DelayWatcher(watcher, 500));
        monitor.start();
    }

    @Test
    void test4(){
        List<String> list=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(""+i);
        }
        String[] sg={"aaaa"};
        Arrays.stream(sg).spliterator();
        list.stream().map(Integer::valueOf).limit(5).forEach(s -> System.out.println(s));
    }

}


