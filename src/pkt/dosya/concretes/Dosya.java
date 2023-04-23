/**
*
* @author Rafet ERSOY    rafet.ersoy@ogr.sakarya.edu.tr
* @since 21.04.2023
* <p>
* IDosya sınıfını implemente edip Dosya ile ilgili işlemleri
* gerçekleştirecek sınıfım
* </p>
*/

package pkt.dosya.concretes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import pkt.dosya.abstracts.IDosya;

public class Dosya implements IDosya{
	
	private String fileContent;
	
	public Dosya(String filePath) throws IOException {
		readJavaFile(filePath);
	}
	
	public Dosya(File file) throws IOException {
		readJavaFile(file);
	}

	@Override
	public void readJavaFile(File file) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(file));
		
		String line = null;
		
		StringBuilder fileContent = new StringBuilder();
		
		while((line = reader.readLine()) != null) {
			fileContent.append(line);
			fileContent.append(System.lineSeparator());
		}
		reader.close();
		
		this.fileContent = fileContent.toString();
	}
	
	@Override
	public void readJavaFile(String filePath) throws IOException {
	    File file = new File(filePath);
	    readJavaFile(file);
	}

	@Override
	public String getFileContent() {
		return fileContent;
	}
}
