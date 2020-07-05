package sample;

import Camera.CameraInfo;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadCameraInfo {
        private static String json;
        private static JSONObject jo;
        public static ArrayList<CameraInfo> cameraInfoList = new ArrayList<CameraInfo>();

        private static String readFile(){
            try (FileReader fileReader = new FileReader("cameraList.json")){
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                json = bufferedReader.readLine();
                return json;
            } catch (IOException e) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Не удалось обновить список файлов", ButtonType.OK);
                alert.showAndWait();
                return json;
            }
        }
        public static void readSettings() throws ParseException {
            jo = (JSONObject) JSONValue.parseWithException(readFile());
            for (Object key :jo.keySet()){
                JSONObject camera = (JSONObject)JSONValue.parseWithException(jo.get(key).toString());
                cameraInfoList.add(new CameraInfo(camera.get("ip").toString(),camera.get("name").toString(), camera.get("login").toString(), camera.get("password").toString()));
            }
        }
}
