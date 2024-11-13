package org.example.model;

public class RobotPart {
    public int id;
    public String name;
    public String description;
    public String supplier;
    public int weight;

    public RobotPart() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public RobotPart(int id, String name, String description, String supplier, int weight) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.supplier = supplier;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "\n RobotPart{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", supplier='" + supplier + '\'' +
                ", weight=" + weight + 'g' +
                '}';
    }


}
