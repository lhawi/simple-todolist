public class TodolistApp {

    public static String[] model = new String[15];

    public static void main(String[] args) {
        testDeleteTodoList();
    }

    public static void showTodoList() {
        for (var i = 0; i < model.length; i++) {
            var todo = model[i];
            int no = i + 1;

            if (todo != null) {
                System.out.println(no + "." + todo);
            }
        }
    }

    public static void testShowTodoList() {
        model[0] = "Learn Java Fundamental";
        model[1] = "Learn Java OOP";
        showTodoList();
    }

    public static void addTodoList(String todo) {
        var isFull = true;
        for (var i = 0; i < model.length; i++) {
            if (model[i] == null) {
                isFull = false;
                break;
            }
        }

        // Resize array 2x
        if (isFull) {
            var temp = model;
            model = new String[model.length * 2];

            for (int i = 0; i < temp.length; i++) {
                model[i] = temp[i];
            }
        }

        for (var i = 0; i < model.length; i++) {
            if (model[i] == null) {
                model[i] = todo;
                break;
            }
        }
    }

    public static void testAddTodoList() {
        for (int i = 0; i < 20; i++) {
            addTodoList("Learn Java day " + i);
        }

        showTodoList();
    }

    public static boolean deleteTodoList(Integer number) {
        if ((number - 1) >= model.length) {
            return false;
        } else if (model[number - 1] == null) {
            return false;
        } else {
            for (var i = (number - 1); i < model.length; i++) {
                if (i == (model.length - 1)) {
                    model[i] = null;
                } else {
                    model[i] = model[i + 1];
                }

            }
            return true;
        }
    }

    public static void testDeleteTodoList() {
        for (int i = 1; i < 5; i++) {
            addTodoList("Learn Java day " + i);
        }

        var result = deleteTodoList(20);
        System.out.println(result);

        result = deleteTodoList(7);
        System.out.println(result);

        result = deleteTodoList(2);
        System.out.println(result);

        showTodoList();
    }

    public static void viewShowTodoList() {

    }

    public static void viewAddTodoList() {

    }

    public static void viewDeleteTodoList() {

    }
}
