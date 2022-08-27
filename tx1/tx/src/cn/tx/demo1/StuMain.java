package cn.tx.demo1;

import java.io.*;
import java.util.Scanner;

public class StuMain {
    public static void main(String[] args){
        System.out.println("--欢迎使用学生管理系统--");
        //学生成绩对象
        Student student = new Student();
        //默认值0
        //student.id = 0;
        //扫描器对象 获取数据
        Scanner s= new Scanner(System.in);
        System.out.println("请输入学生的学号：");
        int id = s.nextInt();
        student.id = id;
        System.out.println("请输入学生的姓名：");
        String name = s.next();
        student.username = name;
        System.out.println("请输入学生的性别：");
        String sex = s.next();
        student.sex = sex;
        System.out.println("请输入学生的数学成绩：");
        int math = s.nextInt();
        student.math = math;
        System.out.println("请输入学生的语文成绩：");
        int chinese = s.nextInt();
        student.chinese = chinese;
        System.out.println("请输入学生的英语成绩：");
        int english = s.nextInt();
        student.english = english;
        //把学生数据写入到txt文档中
        writeStudent(student);
    }
    public static void writeStudent(Student student){
        //使用IO知识
        //创建文件对象
        File file = new File("stu.txt");
        //创建输出流
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter((new FileWriter(file)));
            //写入内容
            bw.write("学号\t姓名\t性别\t数学\t语文\t英语");
            //换行
            bw.newLine();
            bw.write(student.id+"\t\t");
            bw.write(student.username+"\t\t");
            bw.write(student.sex+"\t\t");
            bw.write(student.math+"\t\t");
            bw.write(student.chinese+"\t\t");
            bw.write(student.english+"\t\t");
            //刷新
            bw.flush();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(bw != null){
                try {
                    bw.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
