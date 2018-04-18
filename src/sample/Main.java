package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private String DumpSource;
    private String ItemTreeSource;
    private String SortingRulesSource;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }


    public String getDumpSource() {
        return DumpSource;
    }

    public void setDumpSource(String dumpSource) {
        DumpSource = dumpSource;
    }


    public String getItemTreeSource() {
        return ItemTreeSource;
    }

    public void setItemTreeSource(String itemTreeSource) {
        ItemTreeSource = itemTreeSource;
    }

    public String getSortingRulesSource() {
        return SortingRulesSource;
    }

    public void setSortingRulesSource(String sortingRulesSource) {
        SortingRulesSource = sortingRulesSource;
    }
}
