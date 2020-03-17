package lab5;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;

public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InvalidCatalogException, URISyntaxException {
		Main app = new Main();
		app.testCreateSave();//am creat fisierul
		app.testLoadView();
	}
	private void testCreateSave() throws IOException {
		Catalog catalog =new Catalog("Java Resources", "F:\\FACULTATE\\An2\\JAVA\\Github_java\\Java-StefanIchim\\lab5\\lab5.ser"); 
		
		Document doc = new Document("java1", "Java Course 1",   "https://profs.info.uaic.ro/~acf/java/slides/en/intro_slide_en.pdf");
		doc.addTag("type", "Slides");
		catalog.add(doc); 
		CatalogUtil.save(catalog);
	}
	private void testLoadView() throws FileNotFoundException, ClassNotFoundException, InvalidCatalogException, IOException, URISyntaxException {
		Catalog catalog = CatalogUtil.load("F:\\FACULTATE\\An2\\JAVA\\Github_java\\Java-StefanIchim\\lab5\\lab5.ser");
		Document doc = catalog.findById("java1");
		System.out.println(doc.getName());
		CatalogUtil.view(doc);
	}
}
