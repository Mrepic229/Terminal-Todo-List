import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        TodoList todoList = new TodoList();

        while (true) {
            UserInteractor.whatUserWouldLikeToDo().doCurrentTask(todoList);
            
        }

    }
}