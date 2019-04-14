package com.listener;

import org.python.util.PythonInterpreter;

import java.io.*;

/**
 * com.listener
 * Created by ForMe
 * 2019/4/1
 * 16:48
 */
public class Test {
    public static void main(String[] args) throws IOException, InterruptedException {
        Process proc;
        try {
            proc = Runtime.getRuntime().exec("python D:\\123.py");// 执行py文件
            //用输入输出流来截取结果
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new FileWriter("F:/12300.txt"));
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
                writer.write(line);
                writer.flush();
            }
            in.close();
            writer.close();
            proc.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
