import org.json.JSONObject;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class _JavaJsonHandler {
    JSONObject myJson;

    public _JavaJsonHandler() {
        //myJson = new JSONObject();

        myJson.put("Full Name", "Ritu Sharma");
        myJson.put("Roll No.", 1704310046);
        myJson.put("Tuition Fees", 65400);
    }

    public void makeJson() {
        File myFile = new File("out/test.json");
        try {
            myFile.createNewFile();
            System.out.println("erm");
            FileWriter myWriter = new FileWriter("out/test.json");
            myWriter.write(myJson.toString());
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void makeJson(String pathname) {
        File myFile = new File(pathname);
        try {
            myFile.createNewFile();
            System.out.println("erm");
            FileWriter myWriter = new FileWriter(pathname);
            myWriter.write(myJson.toString());
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Task> decodeJson() {

        ArrayList<Task> Taskes = new ArrayList<Task>();

        JSONObject aaa = (JSONObject)myJson.get("tasks");

        for (int i=0; i<12; i++){
            Taskes.add(new Task((String)aaa.get("name"), (String)aaa.get("description")));
        }

        return Taskes;
    }
}