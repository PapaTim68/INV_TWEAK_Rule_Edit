package main;
/*
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
*/

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Parser class containing all Parsers for Source Files
 */
public class Parser {

    public ArrayList < DItem > parseItemDump(String filePath) throws IOException {
        ArrayList < DItem > result = new ArrayList<>();
        Scanner scan = new Scanner(new File(filePath));
        String line = scan.nextLine();
        while (scan.hasNextLine()) {
            line = scan.nextLine();

            String[] lineArray = line.split(",");
                result.add(new DItem(lineArray[0], Integer.parseInt(lineArray[1]), Boolean.parseBoolean(lineArray[2])
                        , lineArray[3], lineArray[4]));

        }
        return result;
    }

    public NodeList praseXMLTree(String filePath) throws IOException, SAXException, ParserConfigurationException {
        File file = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(file);

        return doc.getLastChild().getChildNodes();
    }
/*
    public org.jdom2.Document parseXMLTree(String file) throws JDOMException, IOException {
        SAXBuilder builder = new SAXBuilder();
        return builder.build(file);
    }
    */
}

/*
Suche:
https://stackoverflow.com/questions/36089484/check-single-element-into-arraylist-with-multiple-column
Optional<Elem> elemOpt = list.parallelStream().filter(elem -> elem.getName().equals(name)).findAny();

if(elemOpt.isPresent()){
    //do some logic with element if exists
    Elem elem = elemOpt.get();
    System.out.println(elem.getName());
    System.out.println(elem.getA());
    System.out.println(elem.getB());
    ...
}
 */