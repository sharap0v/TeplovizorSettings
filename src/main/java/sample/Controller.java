package sample;

import Camera.CameraInfo;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.json.simple.parser.ParseException;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    public TableView<CameraInfo> cameraList;
    public TextField outdoorTemperature;

    public void updateAll(ActionEvent event) {
    }

    public void update(ActionEvent event) {
    }

    public void autoUpdate(ActionEvent event) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TableColumn<CameraInfo,String> cameraIpInformation = new TableColumn<>("IP");
        cameraIpInformation .setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getIp()));
        cameraIpInformation .setPrefWidth(24);
        TableColumn<CameraInfo,String> cameraNameInformation = new TableColumn<>("Название");
        cameraNameInformation .setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getName()));
        cameraNameInformation .setPrefWidth(240);
        TableColumn<CameraInfo,String> cameraLastTimeUpdateInformation = new TableColumn<>("Время");
        cameraLastTimeUpdateInformation .setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getTimeUpdate()));
        cameraLastTimeUpdateInformation .setPrefWidth(240);
        cameraList.getColumns().add(cameraNameInformation);
        cameraList.getColumns().add(cameraIpInformation );
        cameraList.getColumns().add(cameraLastTimeUpdateInformation);
        updateCameraList();
    }
    public void updateCameraList(){
        cameraList.getItems().clear();
        try {
            ReadCameraInfo.readSettings();
        } catch (ParseException | NullPointerException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Не удалось обновить список камер", ButtonType.OK);
            alert.showAndWait();
        }
        cameraList.getItems().addAll(ReadCameraInfo.cameraInfoList);
        cameraList.sort();

    }


    public void mnemonicAutoUpdate(ActionEvent event) {
        System.out.print("11");
    }
}
