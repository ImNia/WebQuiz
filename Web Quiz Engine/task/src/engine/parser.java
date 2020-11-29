package engine;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;

public class parser {
    //TODO JSON формат
    public static QuestionStruct getQuestion(String page) {
        String json = "";
        String line;
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(page));
            while ((line = reader.readLine()) != null) {
                json += line + '\n';
            }
            //System.out.println(json);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        JSONObject object = new JSONObject(json);

        QuestionStruct tmp = new QuestionStruct();
        tmp.title = object.getString("title");
        tmp.text = object.getString("text");

        JSONArray forOption = (JSONArray) object.get("options");

        for (int i = 0; i < forOption.length(); i++) {
            try {
                tmp.options.add(forOption.getString(i));
            } catch (JSONException e) {
                System.out.println(e.getMessage());
            }
        }
        return tmp;
    }

    public static AnswerStruct rightAnswer(String page) {
        String json = "";
        String line;
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(page));
            while ((line = reader.readLine()) != null) {
                json += line + '\n';
            }
            //System.out.println(json);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        JSONObject object = new JSONObject(json);

        AnswerStruct tmp = new AnswerStruct();
        tmp.success = Boolean.parseBoolean(object.getString("success"));
        tmp.feedback = object.getString("feedback");
        return tmp;
    }
}
