import java.util.Scanner;
import java.util.Arrays;
import java.util.InputMismatchException;


/**
 * Class representing the TodoApp application.
 * It is the main entry point for this program.
 */
public class App{

    public static TodoItem createItem() {

        String name = getName();
        TodoItem item = new TodoItem(name);

        return item;
    }

    public static String getName() {
        Scanner in = new Scanner(System.in);
        System.out.println("Add an item: ");
        String name = in.nextLine();

        return name;
    }

    public static Integer getItemToMark() {

        Scanner in = new Scanner(System.in);
        System.out.println("Which one you want to mark as completed: ");
        Integer index = in.nextInt();

        return index;
    }

    public static void printMenu() {
        System.out.println("Please specify a command [list, add, mark, archive]: ");
    }

    public static String chooseOption() {

        String option = "";

        while (!Arrays.asList("list", "add", "mark", "archive").contains(option)){

            Scanner in = new Scanner(System.in);
            option = in.next();
        }

        return option;
    }

    public static void addItems(TodoList todoList) {
        TodoItem item = createItem();
        todoList.addToList(item);
    }

    public static void markItems(TodoList todoList){
        todoList.listItems();
        try {
            Integer index = getItemToMark();
            if (index > 0 && index <= todoList.getListSize()) {
                todoList.markItem(index-1);
            }
        } catch (InputMismatchException e) {
            System.out.println("Wrong number!");
        }
    }

    public static void archiveItems(TodoList todoList) {
        todoList.archiveItems();
        System.out.println("Items archived!");
    }

    public static void main(String[] args) {
        TodoList todoList = new TodoList();

        while(true){
            printMenu();
            String option = chooseOption();

            if (option.equals("list")) {
                todoList.listItems();

            } else if (option.equals("add")) {
                addItems(todoList);

            } else if (option.equals("mark")) {
                markItems(todoList);

            } else if (option.equals("archive")) {
                archiveItems(todoList);
            }
        }


  }
}
