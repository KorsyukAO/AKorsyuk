package ru.job4j.traker;

public class StartUI {

    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADDNEWITEM = "0";
    /**
     * Константа меню для вывода всех заявок.
     */
    private static final String SHOWALLITEMS = "1";
    /**
     * Константа меню для редактирования заявки.
     */
    private static final String EDITITEM = "2";
    /**
     * Константа меню для удаление заявки.
     */
    private static final String DELETEITEMS = "3";
    /**
     * Константа меню для поиска заявки по ИД.
     */
    private static final String FINDITEMBYID = "4";
    /**
     * Константа меню для поиска заявки по имени.
     */
    private static final String FINDITEMBYNAME = "5";
    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";

    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADDNEWITEM.equals(answer)) {  //добавление заявки вынесено в отдельный метод.
                this.addNewItem();
            } else if (SHOWALLITEMS.equals(answer)) {  //Добавить остальные действия системы по меню.
                this.showAllItem();
            } else if (EDITITEM.equals(answer)) {
                this.editItems();
            } else if (DELETEITEMS.equals(answer)) {
                this.deleteItems();
            } else if (FINDITEMBYID.equals(answer)) {
                this.findItemById();
            } else if (FINDITEMBYNAME.equals(answer)) {
                this.findItemByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    private void showMenu() {
        System.out.printf("%s%n%s%n%s%n%s%n%s%n%s%n%s%n",
                "0. Создание новой заявки.",
                "1. Вывод всех заявок на экран.",
                "2. Редоктирование заявки.",
                "3. Удаление заявки.",
                "4. Поиск заявки по ID.",
                "5. Поиск заявки по имени.",
                "6. Выход из программы.");
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void addNewItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    /**
     * Метод реализует вывод всех заявок из хранилища.
     */
    private void showAllItem() {
        System.out.println("------------ Вывод всех заявок --------------");
        for (Item item : this.tracker.getAll()) {
            System.out.printf("Заявка: ID: %-15s Имя: %-20s Описание: %-20s%n", item.getId(), item.getName(), item.getDesc());
        }
        System.out.println("------------ Вывод всех заявок --------------");
    }

    /**
     * Метод реализует изменение заявки в хранилеще.
     */
    private void editItems() {
        System.out.println("------------ Изменение заявки в хранилище --------------");
        String id = this.input.ask("Введите ID редактируемой заявки :");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.replace(id, item);
        System.out.println("------------ В заявку с getId : " + item.getId() + "-----------");
    }

    /**
     * Метод реализует удаление заявки из хранилища.
     */
    private void deleteItems() {
        System.out.println("------------ Удаление заявки по ID --------------");
        String id = this.input.ask("Введите ID заявки:");
        this.tracker.delete(id);
        System.out.println("------------ Заявка удалена -----------");

    }

    /**
     * Метод реализует поиск заявки по ID в хранилище.
     */
    private void findItemById() {
        System.out.println("------------ Поиск заявки по ID --------------");
        String id = this.input.ask("Введите ID заявки:");
        Item item = this.tracker.findById(id);
        System.out.printf("Заявка: ID: %-15s Имя: %-20s Описание: %-20s%n", item.getId(), item.getName(), item.getDesc());
        System.out.println("------------ Поиск заявки по ID -----------");
    }

    /**
     * Мтед реализует поиск заявки по имени в хранилище.
     */
    private void findItemByName() {
        System.out.println("------------ Поиск заявки по имени --------------");
        String name = this.input.ask("Введите имя заявки:");
        for (Item item : this.tracker.findByName(name)) {
            System.out.printf("Заявка: ID: %-15s Имя: %-20s Описание: %-20s%n", item.getId(), item.getName(), item.getDesc());
        }
        System.out.println("------------ Поиск заявки по имени -----------");
    }

    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }

}
