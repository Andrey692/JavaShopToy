Задание
 
Программа – розыгрыша игрушек в магазине детских товаров.

Имеется список игрушек, из которого программа выбирает призовую игрушку (случайным образом) и добавляет ее в массив, формируя очередь призов на выдачу. Для наглядности создается файл list.txt, где записывается массив из призовых игрушек. 
В порядке очереди выдаются игрушки, обновляя список после каждой выдачи.

#### Использую паттерн MVP:
### model:
класс для управления игрушками в магазине. Включает методы для добавления новых игрушек, обновления веса игрушек и выбора призовой игрушки.
### view: 
класс для визуализации информации пользователю. Включает методы для отображения призовых игрушек и сообщений об ошибках.
### presenter:
класс для управления взаимодействием между моделью и представлением. Он получает запросы от представления, обрабатывает их и обновляет модель или представление в соответствии с этими запросами.

## Ключевые методы программы

#### Метод selectPrizeToy()
возвращает призовую игрушку (осуществляет выбор призовой игрушки); рандомно генерирует случайное число в диапазоне от 0 до общего веса игрушек, далее проходит по всем игрушкам и сравнивает случайное число с их весами, если случайное число меньше или равно текущему весу, выбирает эту игрушку. Потом создает новый объект призовой игрушки и возвращает его.

#### Метод readDisplayAndRemoveFirstToyFromFile()
выдача призовой игрушки; этот метод всегда выводит первый элемент из файла, удаляя его и перезаписывая файл, сдвигая все элементы на одну позицию назад




 