package main;

import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Parser Klass containing all Parsers for Source Files
 */
public class Parser {



    public ArrayList < DItem > parseItemDump(String filePath) throws IOException {
        ArrayList < DItem > result = new ArrayList<>();
        Scanner scan = new Scanner(new File(filePath));
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] lineArray = line.split(",");
            result.add(new DItem(lineArray[0], Integer.parseInt(lineArray[1]), Boolean.parseBoolean(lineArray[2])
                        , lineArray[3], lineArray[4]));
        }
        return result;
    }


    public org.jdom2.Document parseXMLTree(String file) throws JDOMException, IOException {
        SAXBuilder builder = new SAXBuilder();
        return builder.build(file);
    }
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