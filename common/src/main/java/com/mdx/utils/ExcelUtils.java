package com.mdx.utils;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.read.listener.ReadListener;

import java.io.InputStream;

public class ExcelUtils {

    public static ExcelReaderBuilder readExcel(String filePath, Class<?> clazz, ReadListener readListener) {
        InputStream inputStream = ExcelUtils.class.getClassLoader().getResourceAsStream(filePath);
        return EasyExcel.read(inputStream, clazz, readListener);
    }

    private ExcelUtils() {
        throw new UnsupportedOperationException();
    }

}
