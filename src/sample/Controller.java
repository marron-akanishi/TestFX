package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

public class Controller {
    // アノテーションは付けなくても動くとか
    @FXML
    private Label label1;
    @FXML
    private CheckBox checkBox1;

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
        if(checkBox1.isSelected()) label1.setText("チェックが入っています");
        else label1.setText("チェックが解除されました");
    }
}
