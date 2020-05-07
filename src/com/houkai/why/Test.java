package com.houkai.why;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("za=", 1, 80));
        list.add(new Student("houkai=", 45, 60));
        list.add(new Student("dak=", 4, 70));
        list.add(new Student("ere=", 67, 30));
        list.add(new Student("yhn=", 27, 56));
        //查找年龄大于14
        findByAge(list);
        //查找分数大于75
        findByScore(list);
    }
    public static  void findByAge(ArrayList<Student> students){
        ArrayList<Student> list = new ArrayList<>();
        for (Student student : students) {
            if (student.getAge()>14){
                System.out.println(student);
            }
        }
        System.out.println("----------");
    }
    public static  void findByScore(ArrayList<Student> students){
        ArrayList<Student> list = new ArrayList<>();
        for (Student student : students) {
            if (student.getScore()>75){
                System.out.println(student);
            }
        }
    }
}
