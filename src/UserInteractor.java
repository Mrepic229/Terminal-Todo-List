import java.util.*;

public class UserInteractor {

    public static CurrentTask whatUserWouldLikeToDo() {
        printUserOptions();

        // System.out.println("Would you like to:");
        // System.out.println("    0. Close Program");
        // System.out.println("    1. Add to your todo list");
        // System.out.println("    2. See your Todo list");

        Scanner userInput = new Scanner(System.in);
        int userWants = userInput.nextInt();

        if (userWants >= CurrentTask.values().length) {
            System.out.println("Please enter a valid amount");
            return whatUserWouldLikeToDo();
        }

        return CurrentTask.values()[userWants];
    }

    public static void printUserOptions() {
        System.out.println("Would you like to:");
        for (int i = 0; i < CurrentTask.values().length; i++) {
            System.out.println("    " + i + ". " + CurrentTask.values()[i].menuDisplay());
        }
        

    }


}
