package main;

import view.*;

import java.util.List;

import model.*;
import presenter.*;

public class Main {
    public static void main(String[] args) {
        ToyModel model = new ToyModel();
        ToyView view = new ToyView();
        ToyPresenter presenter = new ToyPresenter(model, view);

        // Добавляем игрушки
        presenter.addNewToy(new Toy(1, "Кукла", 5, 10));
        presenter.addNewToy(new Toy(2, "Машинка", 8, 15));
        presenter.addNewToy(new Toy(3, "Мяч", 10, 20));
        presenter.addNewToy(new Toy(4, "Конструктор", 6, 12));
        presenter.addNewToy(new Toy(5, "Плюшевый медведь", 3, 8));
        presenter.addNewToy(new Toy(6, "Кубики", 7, 14));
        presenter.addNewToy(new Toy(7, "Игрушечный пистолет", 4, 10));
        presenter.addNewToy(new Toy(8, "Набор фигурок", 9, 18));
        presenter.addNewToy(new Toy(9, "Игровая кукла", 6, 12));
        presenter.addNewToy(new Toy(10, "Робот-трансформер", 2, 6));

        // Получаем список всех игрушек через презентер
        List<Toy> allToys = presenter.getAllToys();

        // Выводим список игрушек в терминал через представление
        view.displayAllToys(allToys);

        // Изменяем вес игрушки с определенным ID
        // presenter.updateToyWeight(1, 8.5);

        // Выбираем призовую игрушку
        // presenter.selectPrizeToy();

        // Выдаем призовую игрушку
        presenter.readDisplayAndRemoveFirstToyFromFile();

    }

}
