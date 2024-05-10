package presenter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.*;
import view.*;

/**
 * Класс ToyPresenter представляет презентер для управления взаимодействием
 * между моделью ToyModel и представлением ToyView.
 * Он принимает запросы от представления, обрабатывает их и обновляет модель
 * или представление в соответствии с этими запросами.
 */
public class ToyPresenter {
    private ToyModel model; // Ссылка на модель ToyModel для выполнения операций с игрушками
    private ToyView view; // Ссылка на представление ToyView для визуализации данных
    private List<Toy> listToys; // Массив для хранения выигранных игрушек

    /**
     * Конструктор класса ToyPresenter.
     * Инициализирует ссылки на модель и представление.
     * 
     * @param model Ссылка на экземпляр ToyModel.
     * @param view  Ссылка на экземпляр ToyView.
     */
    public ToyPresenter(ToyModel model, ToyView view) {
        this.model = model;
        this.view = view;
        listToys = new ArrayList<>(); // Инициализируем массив для хранения выигранных игрушек

    }

    /**
     * Метод для добавления новой игрушки.
     * Передает запрос на добавление новой игрушки модели.
     * 
     * @param toy Новая игрушка для добавления.
     */
    public void addNewToy(Toy toy) {
        model.addNewToy(toy);
    }

    // Добавление выигранной игрушки в массив
    public void addWonToy(Toy toy) {
        listToys.add(toy);
    }

    // Запись массива выигранных игрушек в файл
    public void writeWonToysToFile() {
        try {
            FileWriter writer = new FileWriter("list.txt", true);
            for (Toy toy : listToys) {
                writer.write(toy.toString() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }

    /**
     * Метод для обновления веса игрушки.
     * Передает запрос на обновление веса игрушки модели.
     * 
     * @param toyId     ID игрушки, которой нужно обновить вес.
     * @param newWeight Новый вес для игрушки.
     */
    public void updateToyWeight(int toyId, double newWeight) {
        model.updateToyWeight(toyId, newWeight);
    }

    // добавим метод для получения списка всех игрушек
    public List<Toy> getAllToys() {
        return model.getAllToys();
    }

    /**
     * Метод для выбора призовой игрушки и отображения ее в представлении.
     * Вызывает метод модели для выбора призовой игрушки,
     * а затем отображает результат в представлении.
     */
    public void selectPrizeToy() {
        // Выбор призовой игрушки из модели
        Toy prizeToy = model.selectPrizeToy();
        // Отображение призовой игрушки в представлении
        if (prizeToy != null) {
            view.displayPrize(prizeToy.getName());
            addWonToy(prizeToy); // Добавляем выигранную игрушку в массив
            writeWonToysToFile(); // Записываем массив в файл
        } else {
            view.displayNoPrizeAvailable();
        }
    }

    // Вывод массива выигранных игрушек в терминал
    public void displayWonToys() {
        System.out.println("Выигранные игрушки:");
        for (Toy toy : listToys) {
            System.out.println(toy.toString());
        }
    }

    // Метод для чтения первой игрушки из файла, ее отображения и удаления
    public void readDisplayAndRemoveFirstToyFromFile() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("list.txt"))) {
            String firstLine = bufferedReader.readLine();
            if (firstLine != null) {
                System.out.println("Призовая игрушка: " + firstLine);

                // Удаление первой игрушки из файла
                deleteFirstToyFromFile("list.txt");
            } else {
                System.out.println("Файл пуст");
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }

    // Метод для удаления первой игрушки из файла
    private void deleteFirstToyFromFile(String filename) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            // Читаем содержимое файла в список строк
            List<String> lines = new ArrayList<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }

            // Удаляем первую строку (если она есть)
            if (!lines.isEmpty()) {
                lines.remove(0);
            } else {
                System.out.println("Файл " + filename + " пуст");
                return;
            }

            // Перезаписываем содержимое файла
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename))) {
                for (String newLine : lines) {
                    bufferedWriter.write(newLine);
                    bufferedWriter.newLine();
                }
                System.out.println("успешно выдана ");
            } catch (IOException e) {
                System.out.println("Ошибка при перезаписи файла: " + e.getMessage());
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }

}
