package model;

import java.util.ArrayList;
import java.util.List;

public class ToyShop {
    private List<Toy> toys; // Список для хранения игрушек

    public ToyShop() {
        toys = new ArrayList<>(); // Создаем новый список игрушек при создании магазина
    }

    // Метод для добавления новой игрушки в магазин
    public void addToy(Toy toy) {
        toys.add(toy);
    }

    // метод для получения списка всех игрушек
    public List<Toy> getAllToys() {
        return toys;
    }

    // Метод для обновления веса игрушки по её ID
    public void updateToyWeight(int toyId, double newWeight) {
        // Проходим по всем игрушкам в магазине
        for (Toy toy : toys) {
            // Проверяем, совпадает ли ID текущей игрушки с заданным ID
            if (toy.getId() == toyId) {
                // Если ID совпадают, обновляем вес текущей игрушки
                toy.setWeight(newWeight);
                return; // Прекращаем выполнение метода после обновления веса
            }
        }
        // Если не было найдено игрушки с указанным ID, выводим сообщение об ошибке
        System.out.println("Игрушка с указанным ID не найдена");
    }

    // Метод для выбора призовой игрушки
    public Toy selectPrizeToy() {
        // Считаем общий вес всех игрушек в магазине
        double totalWeight = toys.stream().mapToDouble(Toy::getWeight).sum();
        // Генерируем случайное число в диапазоне от 0 до общего веса игрушек
        double randomNumber = Math.random() * totalWeight;

        double currentWeight = 0;
        // Проходим по всем игрушкам и сравниваем случайное число с их весами
        for (Toy toy : toys) {
            currentWeight += toy.getWeight();
            // Если случайное число меньше или равно текущему весу, выбираем эту игрушку
            if (randomNumber <= currentWeight) {
                // Создаем новый объект призовой игрушки
                Toy prizeToy = new Toy(toy.getId(), toy.getName(), 1, toy.getWeight());
                // Уменьшаем количество доступных игрушек
                toy.decreaseQuantity();
                return prizeToy; // Возвращаем призовую игрушку
            }
        }

        return null; // Возвращаем null в случае, если веса всех игрушек равны 0 или случайное число
        // превысило общий вес
    }
}
