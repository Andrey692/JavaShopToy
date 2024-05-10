package model;

public class Toy {
    private int id;
    private String name;
    private int quantity;
    private double weight; // вес в % от 100

    public Toy(int id, String name, int quantity, double weight) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void decreaseQuantity() {
        if (quantity > 0) {
            quantity--;
        } else {
            System.out.println("Нет в наличии");
        }
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Название: " + name + ", Количество: " + quantity + ", Вес: " + weight;
    }
}
