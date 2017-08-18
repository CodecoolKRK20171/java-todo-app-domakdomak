import java.util.ArrayList;

/**
 * Class representing a todo list.
 * TodoList object should aggregate TodoItem objects.
 */
public class TodoList{

    private ArrayList<TodoItem> itemsList = new ArrayList<TodoItem>();

    public void addToList(TodoItem item) {
        itemsList.add(item);
    }

    public void removeFromList(TodoItem itemToRemove) {

        for(TodoItem item: itemsList) {
            if (itemToRemove == item) {
                itemsList.remove(item);
            }
        }
    }

    public void archiveItems() {
        ArrayList<TodoItem> itemsToRemove = new ArrayList<TodoItem>();

        for(TodoItem item: itemsList) {
            if (item.getIsDone()) {
                itemsToRemove.add(item);
            }
        }

        for(TodoItem item: itemsToRemove){
            itemsList.remove(item);
        }
    }

    public void listItems() {
        Integer counter = 1;

        System.out.println("You saved the following to-do items:");
        for(TodoItem item: itemsList) {
            System.out.println(Integer.toString(counter) + "." + item);
            counter ++;
        }
    }

    public void markItem(Integer index) {
        if (index <= itemsList.size()) {
            itemsList.get(index).markDone();
        }
    }

    public Integer getListSize() {
        return itemsList.size();
    }

}
