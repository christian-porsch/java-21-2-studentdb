package de.neuefische.studendb.db;

import de.neuefische.studendb.model.Student;

import java.util.ArrayList;

public class StudentDb {

    /*private Student [] students;*/

    private ArrayList<Student> students = new ArrayList<Student>();

    public StudentDb(ArrayList<Student> students) {
        this.students = students;
    }


    /* public StudentDb(Student[] students) {
        this.students = students;
    }*/

    /*public Student[] list() {
        return students;
    }*/

    public ArrayList<Student> list() {
        return students;
    }

    public Student findById(String id){
        for (Student currentStudent : students) {
            if (id.equals(currentStudent.getId())){
                return currentStudent;
            }

        }
        return null;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0 ; i < students.size(); i++) {
            result += students.get(i) + "\n";
        }
        return result;
    }



    /*    @Override
    public String toString(){
        String result = "";
        for (int i = 0; i < students.length; i++) {
            result += students[i] + "\n";
        }
        return result;
    }*/

    public Student randomStudent() {
        int index = (int) Math.floor(Math.random() * students.size());
        return students.get(index);
    }

    /*public void add(Student student) {
        Student[] updatedStudents = new Student[students.length+1];

        for (int i = 0; i < students.length; i++) {
            updatedStudents[i] = students[i];
        }

        updatedStudents[updatedStudents.length-1] = student;

        students = updatedStudents;
    }*/

    public void add(Student student){
        this.students.add(student);
    }

    /*public void remove(Student student) {
        int foundIndex = findIndex(student);
        if(foundIndex < 0){
            return;
        }
        Student[] updatedStudents = new Student[students.length-1];

        for (int i = 0; i < students.length; i++) {
            if(i < foundIndex){
                updatedStudents[i] = students[i];
            }
            if(i > foundIndex){
                updatedStudents[i-1] = students[i];
            }
        }

        students = updatedStudents;
    }*/

    public void remove(Student student){
        this.students.remove(student);
    }

    private int findIndex(Student student) {
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).equals(student)){
                return i;
            }
        }
        return -1;
    }


}
