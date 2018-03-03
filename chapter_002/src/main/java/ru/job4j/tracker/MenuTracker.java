package ru.job4j.tracker;

/**
 *Class MenuTracker решение задачи 1.002.5.1. Реализовать события на внутренних классах. [#787]
 *@autor Alexandr Korsyuk (Korsyuk@gmail.com)
 *@since 03.03.2018
 *@version 0.1
 */

public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[7];

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void fillAction() {
        this.actions[0] = this.new AddNewItem();
        this.actions[1] = new MenuTracker.ShowAllItem();
        this.actions[2] = new EditItems();
        this.actions[3] = new DeleteItems();
        this.actions[4] = new FindItemById();
        this.actions[5] = new MenuTracker.FindItemByName();
        this.actions[6] = new Exit();
    }

    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }
    //0. Создание новой заявки.
    private class AddNewItem implements UserAction {
        public int key() {
            return 0;
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой заявки --------------");
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Создание новой заявки.");
        }
    }

    //4. Поиск заявки по ID.
    private class FindItemById implements UserAction {
        public int key() {
            return 4;
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по ID --------------");
            String id = input.ask("Введите ID заявки:");
            Item item = tracker.findById(id);
            System.out.printf("Заявка: ID: %-15s Имя: %-20s Описание: %-20s%n", item.getId(), item.getName(), item.getDesc());
            System.out.println("------------ Поиск заявки по ID -----------");
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Поиск заявки по ID.");
        }
    }

    //1. Вывод всех заявок на экран.
    private static class ShowAllItem implements UserAction {
        public int key() {
            return 1;
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Вывод всех заявок --------------");
            for (Item item : tracker.getAll()) {
                System.out.printf("Заявка: ID: %-15s Имя: %-20s Описание: %-20s%n", item.getId(), item.getName(), item.getDesc());
            }
            System.out.println("------------ Вывод всех заявок --------------");

        }

        public String info() {
            return String.format("%s. %s", this.key(), "Вывод всех заявок на экран.");
        }
    }

    //5. Поиск заявки по имени.
    private static class FindItemByName implements UserAction {
        public int key() {
            return 5;
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по имени --------------");
            String name = input.ask("Введите имя заявки:");
            for (Item item : tracker.findByName(name)) {
                System.out.printf("Заявка: ID: %-15s Имя: %-20s Описание: %-20s%n", item.getId(), item.getName(), item.getDesc());
            }
            System.out.println("------------ Поиск заявки по имени -----------");
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Поиск заявки по имени.");
        }
    }
}
//2. Редоктирование заявки.
class EditItems implements UserAction {
    public int key() {
        return 2;
    }

    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Введите ID редактируемой заявки :");
        String name = input.ask("Введите имя заявки :");
        String desc = input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        tracker.replace(id, item);
    }

    public String info() {
        return String.format("%s. %s", this.key(), "Редоктирование заявки.");
    }

}

//3. Удаление заявки.
class DeleteItems implements UserAction {
    public int key() {
        return 3;
    }

    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Удаление заявки по ID --------------");
        String id = input.ask("Введите ID заявки:");
        tracker.delete(id);
        System.out.println("------------ Заявка удалена -----------");
    }

    public String info() {
        return String.format("%s. %s", this.key(), "Удаление заявки.");
    }

}

//6. Выход из программы.
class Exit implements UserAction {
    public int key() {
        return 6;
    }

    public void execute(Input input, Tracker tracker) {

    }

    public String info() {
        return String.format("%s. %s", this.key(), "Выход из программы.");
    }

}

