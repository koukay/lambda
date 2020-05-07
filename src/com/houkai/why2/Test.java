package com.houkai.why2;

import com.houkai.why.Student;

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
        //查找分数大于75
        getByFilter(list,new AgeFilter());
        getByFilter(list,new ScoreFilter());
    }
    public static void  getByFilter(ArrayList<Student> students,StudentFilter studentFilter){
        ArrayList<Student> list= new ArrayList<>();
        for (Student student : students) {
            if (studentFilter.compare(student)){
                list.add(student);
            }
        }
        printStudents(list);
    }
    public static void printStudents(ArrayList<Student> students){
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
