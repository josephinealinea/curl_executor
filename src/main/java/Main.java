import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to Programming Diaries !");

        System.out.println("We will be executing a few cURL commands from this executor !");

        try {

            String curlXget = "curl -XGET http://localhost:9200/*sample*/_alias";

            System.out.println("First, Let's execute a process using Process and Runtime object");
            Process proc = Runtime.getRuntime().exec(curlXget);

            System.out.println("Set the response object to InputStream variable called xgetResponse.");
            InputStream xgetResponse = proc.getInputStream();

            System.out.println("Use JSONParser to parse the response.");
            JSONObject response = (JSONObject) new JSONParser().parse(new InputStreamReader(xgetResponse));

            System.out.println("Response : ");
            System.out.println(response.toJSONString());

        } catch (IOException | ParseException e) {
            System.out.println("Error executing cURL.");
        }

    }
}
