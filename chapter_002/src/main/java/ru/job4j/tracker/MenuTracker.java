package ru.job4j.tracker;

/**
 * Реализация меню.
 *
 *Class MenuTracker решение задачи 1.002.5.1. Реализовать события на внутренних классах. [#787].
 *@autor Alexandr Korsyuk (Korsyuk@gmail.com)
 *@since 03.03.2018
 *@version 0.1
 */

public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[7];


    public int[] getAllKeyActionMenu() {
        int[] allKeyActionMenu = new int[actions.length];
        for (int indexMenu = 0; indexMenu < actions.length; indexMenu++) {
            allKeyActionMenu[indexMenu] = actions[indexMenu].key();
        }
        return allKeyActionMenu;
    }


    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void fillAction() {
        this.actions[0] = this.new AddNewItem(0, "Создание новой заявки.");
        this.actions[1] = new MenuTracker.ShowAllItem(1, "Вывод всех заявок на экран.");
        this.actions[2] = new EditItems(2, "Редоктирование заявки.");
        this.actions[3] = new DeleteItems(3, "Удаление заявки.");
        this.actions[4] = new FindItemById(4, "Поиск заявки по ID.");
        this.actions[5] = new MenuTracker.FindItemByName(5, "Поиск заявки по имени.");
        this.actions[6] = new Exit(6, "Выход из программы.");
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
    private class AddNewItem extends BaseAction {
        private AddNewItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой заявки --------------");
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
        }
    }

    //4. Поиск заявки по ID.
    private class FindItemById extends BaseAction {

        private FindItemById(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по ID --------------");
            String id = input.ask("Введите ID заявки:");
            Item item = tracker.findById(id);
            System.out.printf("Заявка: ID: %-15s Имя: %-20s Описание: %-20s%n", item.getId(), item.getName(), item.getDesc());
            System.out.println("------------ Поиск заявки по ID -----------");
        }
    }


    //1. Вывод всех заявок на экран.
    private static class ShowAllItem extends BaseAction {
        private ShowAllItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Вывод всех заявок --------------");
            for (Item item : tracker.getAll()) {
                System.out.printf("Заявка: ID: %-15s Имя: %-20s Описание: %-20s%n", item.getId(), item.getName(), item.getDesc());
            }
            System.out.println("------------ Вывод всех заявок --------------");

        }

    }


    //5. Поиск заявки по имени.
    private static class FindItemByName extends BaseAction {
        private FindItemByName(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по имени --------------");
            String name = input.ask("Введите имя заявки:");
            for (Item item : tracker.findByName(name)) {
                System.out.printf("Заявка: ID: %-15s Имя: %-20s Описание: %-20s%n", item.getId(), item.getName(), item.getDesc());
            }
            System.out.println("------------ Поиск заявки по имени -----------");
        }
    }
}
//2. Редоктирование заявки.
class EditItems extends BaseAction {
    EditItems(int key, String name) {
        super(key, name);
    }
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Введите ID редактируемой заявки :");
        String name = input.ask("Введите имя заявки :");
        String desc = input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        tracker.replace(id, item);
    }
}

//3. Удаление заявки.
class DeleteItems extends BaseAction {
    DeleteItems(int key, String name) {
        super(key, name);
    }
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Удаление заявки по ID --------------");
        String id = input.ask("Введите ID заявки:");
        tracker.delete(id);
        System.out.println("------------ Заявка удалена -----------");
    }
}

//6. Выход из программы.
class Exit extends BaseAction {
    Exit(int key, String name) {
        super(key, name);
    }
    public void execute(Input input, Tracker tracker) {
    }
}

