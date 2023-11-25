package com.agmtopt.leetcode.zlib;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class CompressionUsingDeflator {

    public static void main(String[] args) throws Exception {
        String filePath = "C:\\Users\\agmto\\Desktop\\专利\\1.一种金融系统的日终数据传输方案\\zh_law_conversation.json";

        File file = new File(filePath);

        // 创建输入流
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader br = new BufferedReader(isr);

        // 逐行读取文件内容
        StringBuffer sbr = new StringBuffer();
        for ( String str: br.lines().toList()) {
            sbr.append(str);
        }

        // 关闭资源
        br.close();
        isr.close();
        fis.close();

        System.out.println("压缩前 " + sbr.toString().getBytes().length);
        byte[] def = CompressionUsingDeflator.compress(sbr.toString().getBytes());
        System.out.println("压缩后 " + def.length);
        byte[] inf = CompressionUsingDeflator.uncompress(def);
        System.out.println(new String(inf));
    }

    /**
     * 压缩
     */
    public static byte[] compress(byte[] input) {
        byte[] output = new byte[Integer.sum(input.length + 10,
                Double.valueOf(Math.ceil(input.length * 0.25f)).intValue())];
        Deflater compresser = new Deflater(9);//压缩级别
        compresser.setInput(input);
        compresser.finish();
        int compressedDataLength = compresser.deflate(output);
        compresser.end();
        return Arrays.copyOf(output, compressedDataLength);
    }

    /**
     * 解压缩
     */
    public static byte[] uncompress(byte[] barr) throws DataFormatException {
        byte[] result = new byte[2014];
        Inflater inf = new Inflater();
        inf.setInput(barr);
        int infLen = inf.inflate(result);
        inf.end();
        return Arrays.copyOf(result, infLen);
    }

}