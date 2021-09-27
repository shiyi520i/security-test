package com.example.testdemo.excel;

import cn.hutool.core.io.FileUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * excel的读取
 *
 * @author ：ShiYI
 * @date ：Created in 2021/9/6
 */
@Service
public class ExcelReder {

    public void test(){
    ExcelReader reader = ExcelUtil.getReader(FileUtil.file("D:\\Resources\\楼盘房屋记表.xls"));
    List<DeriveHPC> all = reader.readAll(DeriveHPC.class);
        System.out.println(all);
    }
}
