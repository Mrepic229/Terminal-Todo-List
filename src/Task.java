public class Task {
     String name;
     String description;

    public Task() {
        name = "nothing";
        description = "chill out, there is nothing to do";
    }

    public Task(String n, String d) {
        name = n;
        description = d;
    }

    public void displayTask() {
        System.out.println(name);
        System.out.println(description);
    }

    

}
