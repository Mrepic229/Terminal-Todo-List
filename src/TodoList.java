import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.*;
//import org.json.JSONObject;

public class TodoList {
    private ArrayList<Task> todoList;

    public TodoList() {
        todoList = new ArrayList<Task>();
    }

    public void readJson() {
        try {
            File myObj = new File("tasksOut.json");
            Scanner myReader = new Scanner(myObj);
            String wholeData = "";
            while (myReader.hasNextLine()) {
                wholeData += myReader.nextLine();
            }
            JSONObject myJsonObject = new JSONObject(wholeData);
            myReader.close();
            JSONArray myJsonArray = myJsonObject.getJSONArray("Tasks");

            System.out.println("");
            System.out.println("Your Tasks:");

            todoList.clear();;
            for (int i = 0; i < myJsonArray.length(); i++) {
                JSONObject taskAsJson = myJsonArray.getJSONObject(i);
                todoList.add(
                    new Task(taskAsJson.getString("name"), taskAsJson.getString("description"))
                );
            
        }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public void writeJson() {
        //JSONArray myJsonArray = new JSONArray();
        JSONObject myJsonObject = new JSONObject();
        JSONArray jsonArrayOfTasks = new JSONArray();
        for (int i=0; i<todoList.size(); i++) {
            JSONObject taskAsJson = new JSONObject();
            taskAsJson.put("name", todoList.get(i).name);
            taskAsJson.put("description", todoList.get(i).description);

            jsonArrayOfTasks.put(taskAsJson);
        }
        myJsonObject.put("Tasks", jsonArrayOfTasks);

        File myFile = new File("tasksOut.json");
        try {
            myFile.createNewFile();
            System.out.println("erm");
            
            FileWriter myWriter = new FileWriter("tasksOut.json");
            myWriter.write(myJsonObject.toString());
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printTasks() {
        for (int i = 0; i<todoList.size(); i++) {
            System.out.print(""+i+". ");
            todoList.get(i).displayTask();
            System.out.println("");
        }
    }

    public void makeNewTask() {
        System.out.println("Enter name of todo task");
        Scanner nameScanner = new Scanner(System.in);
        String name = nameScanner.nextLine();
        System.out.println("Enter description of todo task");
        Scanner descriptionScanner = new Scanner(System.in);
        String description = descriptionScanner.nextLine();
        
        todoList.add(new Task(name, description));

        //myJsonObject.getJSONArray("tasks").put(newTask);
        writeJson();
    }

    public void removeTask() {
        printTasks();
        System.out.println("Which task would you like to remove: ");
        Scanner indexScanner = new Scanner(System.in);
        int index = indexScanner.nextInt();
        Task deletedTasked = todoList.get(index);

        todoList.remove(index);
        System.out.println("The following task has been deleted: ");
        deletedTasked.displayTask();

        writeJson();
    }
}
