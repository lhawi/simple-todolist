public class TodolistApp {

    public static String[] model = new String[15];

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        viewShowTodoList();
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

    public static String input(String info) {
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }

    public static void testInput() {
        var name = input("Name");
        System.out.println("Hello " + name);
    }

    public static void viewShowTodoList(){
        while (true) {
            showTodoList();

            System.out.println("MENU : ");
            System.out.println("1. Add");
            System.out.println("2. Delete");
            System.out.println("x. Exit");

            var input = input("Select");

            if (input.equals("1")) {
                viewAddTodoList();
            } else if(input.equals("2")) {
                viewDeleteTodoList();
            } else if(input.equals("x")){
                break;
            }else {
                System.out.println("Options are not understood");
            }
        }
    }

    private static void testViewShowTodoList() {
        addTodoList("Learn Java day 1");
        addTodoList("Learn Java day 2");
        addTodoList("Learn Java day 3");
        addTodoList("Learn Java day 4");
        addTodoList("Learn Java day 5");
        viewShowTodoList();
    }

    public static void viewAddTodoList(){
        System.out.println("ADD TODOLIST");

        var todo = input("Todo (x if cancel)");

        if (todo.equals("x")){
            // batal
        } else {
            addTodoList(todo);
        }
    }

    public static void testViewAddTodoList(){
        viewAddTodoList();

        showTodoList();
    }

    public static void viewDeleteTodoList() {
        System.out.println("DELETE TODOLIST");

        var number = input("The number to be deleted (x if cancel)");

        if (number.equals("x")){
            // batal
        } else {
            boolean success = deleteTodoList(Integer.valueOf(number));
            if (!success){
                System.out.println("Failed to delete todolist : " + number);
            }
        }
    }

    public static void testViewDeleteTodoList() {
        addTodoList("Learn Java day 1");
        addTodoList("Learn Java day 2");
        addTodoList("Learn Java day 3");

        showTodoList();

        viewDeleteTodoList();

        showTodoList();
    }
}
