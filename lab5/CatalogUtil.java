package com.la.test;

import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

public class CatalogUtil {
    public static void save(Catalog catalog)
            throws IOException {
        try (var oos = new ObjectOutputStream(
                new FileOutputStream(catalog.getPath()))) {
            oos.writeObject(catalog);
        }
    }
    public static Catalog load(String pathforfile)
            throws InvalidCatalogException {
        try {
            FileInputStream fileIn = new FileInputStream(pathforfile);
            ObjectInputStream objectNou = new ObjectInputStream(fileIn);

            return (Catalog) objectNou.readObject();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }


            return null;
    }
    public static void view(Document doc) throws URISyntaxException, IOException {
        Desktop desktop = Desktop.getDesktop();
        desktop.browse(new URI(doc.getLocation()));
    }



}
