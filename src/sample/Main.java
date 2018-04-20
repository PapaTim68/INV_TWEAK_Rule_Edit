package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.DItem;
import main.Parser;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

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


    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        String file = "C:\\Users\\Tim\\IdeaProjects\\INV_TWEAK_Rule_Edit\\InvTweaksTree.txt";
        Parser par = new Parser();
        xmlParserTest(file, par);
        String file2 = "C:\\Users\\Tim\\IdeaProjects\\INV_TWEAK_Rule_Edit\\item.csv";
        //csvParserTest(par, file2);
        launch(args);
    }

    private static void xmlParserTest(String file, Parser par) throws IOException, SAXException, ParserConfigurationException {
        NodeList NList = par.praseXMLTree(file);
        for (int temp = 0; temp < NList.getLength(); temp++){
            Node nNode = NList.item(temp);
            System.out.println("Current Elment:"+ nNode.getNodeName());
        }
    }

    private static void csvParserTest(Parser par, String file2) throws IOException {
        ArrayList<DItem> ItemList = par.parseItemDump(file2);
        for (DItem i: ItemList){
            System.out.println(i.toString());
        }
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
