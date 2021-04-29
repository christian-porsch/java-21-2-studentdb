package de.neuefische.studendb.model;

public class ComputerScienceStudent extends Student{

    String firstProgrammingLanguage;

    public ComputerScienceStudent (String name, String id, String numOfModuls, String firstProgrammingLanguage){
        super(name, id, numOfModuls);
        this.firstProgrammingLanguage = firstProgrammingLanguage;
    }

    public String getFirstProgrammingLanguage() {
        return firstProgrammingLanguage;
    }

    public void setFirstProgrammingLanguage(String firstProgrammingLanguage) {
        this.firstProgrammingLanguage = firstProgrammingLanguage;
    }

    public String anzahlModule(int numOfModuls){
        return "Your number of moduls: " + numOfModuls;
    }

    @Override
    public String toString() {
        return "ComputerScienceStudent{" +
                "firstProgrammingLanguage='" + firstProgrammingLanguage + '\'' +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
