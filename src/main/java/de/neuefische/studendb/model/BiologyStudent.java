package de.neuefische.studendb.model;

public class BiologyStudent extends Student {

    String equipment;

    public BiologyStudent(String name, String id, String numberofModuls, String equipment){
        super(name, id, numberofModuls);
        this.equipment = equipment;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String anzahlModule(int numOfModuls){
        return "Your number of moduls: " + numOfModuls;
    }

    @Override
    public String toString() {
        return "BiologyStudent{" +
                "equipment='" + equipment + '\'' +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
