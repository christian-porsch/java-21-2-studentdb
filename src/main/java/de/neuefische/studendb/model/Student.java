package de.neuefische.studendb.model;

import java.util.Objects;

public abstract class Student {

    protected String name;
    protected String id;
    protected String numOfModuls;

    public Student(String name, String id, String numOfModuls){
        this.name = name;
        this.id = id;
        this.numOfModuls = numOfModuls;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public abstract String anzahlModule(int numOfModuls);


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
