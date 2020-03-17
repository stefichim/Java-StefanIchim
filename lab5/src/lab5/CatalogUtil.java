package lab5;

import java.awt.Desktop;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URISyntaxException;



public class CatalogUtil {

	public static void save(Catalog catalog) throws IOException{
		try (var oos = new ObjectOutputStream(new FileOutputStream(catalog.getPath()))){
			oos.writeObject(catalog);
		}
	}
	public static Catalog load(String path) throws InvalidCatalogException, FileNotFoundException, IOException, ClassNotFoundException{
		//Legat de metoda load, trebuie sa utilizati un flux de tipul ObjectInputStream, 
		//combinat cu FileInputStream. Metoda readObject, va returna obiectul Catalog salvat de metoda save.
		
		try(ObjectInputStream in=new ObjectInputStream(new FileInputStream(path))){
			Catalog catalog=(Catalog)in.readObject();
			in.close();
			return catalog;
		}
		//am incercat sa incarc fisierul lab5.ser
		catch (IOException exception) {
			exception.printStackTrace();
		}
		return null;
	}
	
	public static void view(Document doc) throws IOException, URISyntaxException {
		Desktop.getDesktop().browse(new java.net.URI(doc.getLocation()));
		
		
	}
}
