package de.neuefische.studendb.db;

import de.neuefische.studendb.model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StudentDb {

    private Map<String, Student> mapOfStudents = new HashMap<>();

    public StudentDb(Map<String, Student> mapOfStudents) {
        this.mapOfStudents = mapOfStudents;
    }

    public Map<String, Student> list() {
        return mapOfStudents;
    }

    public Student findById(String id){
        for (Student currentStudent : mapOfStudents) {
            if (id.equals(currentStudent.getId())){
                return currentStudent;
            }

        }
        return null;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0 ; i < mapOfStudents.size(); i++) {
            result += mapOfStudents.get(i) + "\n";
        }
        return result;
    }



    public Student randomStudent() {
        int index = (int) Math.floor(Math.random() * mapOfStudents.size());
        return mapOfStudents.get(index);
    }


    public void add(Student student){
        this.mapOfStudents.put(student.getId(), student);
    }


    public void remove(Student student){
        this.mapOfStudents.remove(student);
    }

    private int findIndex(Student student) {
        for (int i = 0; i < mapOfStudents.size(); i++) {
            if(mapOfStudents.get(i).equals(student)){
                return i;
            }
        }
        return -1;
    }


}
