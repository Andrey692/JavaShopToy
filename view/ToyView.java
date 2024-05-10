package view;

import java.util.List;

import model.Toy;

public class ToyView {
    public void displayPrize(String prizeName) {
        System.out.println("Выиграли игрушку: " + prizeName);
    }

    // метод для вывода списка игрушек
    public void displayAllToys(List<Toy> toys) {
        System.out.println("Список всех игрушек:");
        for (Toy toy : toys) {
            System.out.println("ID: " + toy.getId() + ", Название: " + toy.getName() +
                    ", Количество: " + toy.getQuantity() + ", Вес: " + toy.getWeight());
        }
    }

    public void displayNoPrizeAvailable() {
        System.out.println("Нет доступных призовых игрушек");
    }

}
