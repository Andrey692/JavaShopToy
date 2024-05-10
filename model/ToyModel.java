package model;

import java.util.List;

/**
 * Класс ToyModel представляет модель для управления игрушками в магазине.
 * Он обеспечивает доступ к методам ToyShop для добавления новых игрушек,
 * обновления веса игрушек и выбора призовой игрушки.
 */
public class ToyModel {
    private ToyShop toyShop; // Ссылка на экземпляр ToyShop для работы с игрушками

    /**
     * Конструктор класса ToyModel.
     * Создает новый экземпляр ToyShop при создании объекта ToyModel.
     */
    public ToyModel() {
        toyShop = new ToyShop();
    }

    /**
     * Метод для добавления новой игрушки в магазин.
     * 
     * @param toy Новая игрушка для добавления.
     */
    public void addNewToy(Toy toy) {
        toyShop.addToy(toy);
    }

    // метод для получения списка всех игрушек из магазина
    public List<Toy> getAllToys() {
        return toyShop.getAllToys();
    }

    /**
     * Метод для обновления веса игрушки по ее ID.
     * 
     * @param toyId     ID игрушки, которой нужно обновить вес.
     * @param newWeight Новый вес для игрушки.
     */
    public void updateToyWeight(int toyId, double newWeight) {
        toyShop.updateToyWeight(toyId, newWeight);
    }

    /**
     * Метод для выбора призовой игрушки из магазина.
     * 
     * @return Призовая игрушка, выбранная из магазина, или null, если призовых
     *         игрушек нет.
     */
    public Toy selectPrizeToy() {
        return toyShop.selectPrizeToy();
    }
}
