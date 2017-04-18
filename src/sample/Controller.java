package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.controlsfx.control.StatusBar;

import java.io.File;

public class Controller {
    // アノテーションは付けなくても動くとか
    @FXML
    private Label label1;
    @FXML
    private CheckBox checkBox1;
    @FXML
    private ToggleButton toggle1;
    @FXML
    private ImageView image1;
    @FXML
    private StatusBar statusText;

    @FXML
    public void handleBtn(ActionEvent event) {
        // OKボタンがクリックされた時の動作
        // ダイアログの表示
        // Alertダイアログの利用
        Alert alert = new Alert( Alert.AlertType.INFORMATION , "" , ButtonType.OK);
        alert.setTitle( "ダイアログのテスト" );
        alert.getDialogPane().setHeaderText( "ダイアログ・ヘッダー" );
        alert.getDialogPane().setContentText( "ダイアログの内容\nボタンを押したよ" );
        ButtonType button = alert.showAndWait().orElse( ButtonType.CANCEL );
    }

    @FXML
    public void checkBoxChanged(ActionEvent event){
        if (checkBox1.isSelected()) label1.setText("チェックが入っています");
        else label1.setText("チェックが解除されました");
    }

    @FXML
    public void onExitMenu(ActionEvent event){
        Platform.exit();
    }

    @FXML
    public void toggleChanged(ActionEvent event){
        if (toggle1.isSelected()) toggle1.setText("オン");
        else toggle1.setText("オフ");
    }

    @FXML
    public void onOpenButton(ActionEvent event){
        Stage Parent = (Stage)((Node)event.getTarget()).getScene().getWindow();
        FileChooser fc = new FileChooser();
        fc.setTitle("ファイルを開く");
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("画像ファイル","*.png"));
        File importFile = fc.showOpenDialog(Parent);
        if (importFile != null) {
            statusText.setText(importFile.getName());
            image1.setImage(new Image(importFile.toURI().toString()));
            image1.setPreserveRatio(true);
            image1.setSmooth(true);
        }
    }
}
