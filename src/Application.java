import java.util.Scanner;

public class Application {
    private Array array;

    public Application() {
        this.array = new Array();
    }


    public void showMenu(){
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nМеню:");
            System.out.println("1. Ввести значения массива (Изначальный размер массива 10)");
            System.out.println("2. Рассчитать среднее и СКО");
            System.out.println("3. Отсортировать массив по возрастанию");
            System.out.println("4. Отсортировать массив по убыванию");
            System.out.println("5. Изменить размер массива");
            System.out.println("6. Изменить значение элемента массива");
            System.out.println("7. Вывести массив");
            System.out.println("8. Выход");
            System.out.print("Выберите команду: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println();
                    System.out.println("1. Ввести новый массив");
                    System.out.println("2. Добавить новые элементы в старый массив");
                    System.out.print("Выберите команду: ");
                    choice = scanner.nextInt();
                    array.input(choice);
                    break;
                case 2:
                    array.calculateMeanAndStandardDeviation();
                    break;
                case 3:
                    array.sortAscending();
                    break;
                case 4:
                    array.sortDescending();
                    break;
                case 5:
                    System.out.print("Введите новую длину массива: ");
                    int newSize = scanner.nextInt();
                    array.resize(newSize);
                    break;
                case 6:
                    System.out.print("Введите индекс: ");
                    int index = scanner.nextInt();
                    array.getElementByIndex(index);
                    break;

                case 7:
                    array.showArray();
                    break;

                case 8:
                    running = false;

            }
        }
    }
}
