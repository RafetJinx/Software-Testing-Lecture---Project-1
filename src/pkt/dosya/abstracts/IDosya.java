/**
*
* @author Rafet ERSOY    rafet.ersoy@ogr.sakarya.edu.tr
* @since 21.04.2023
* <p>
* Dosya sınıfı IDosya arayüzünü implemente edecek
* ve kullanması gereken fonksiyonlara sahip olacak
* </p>
*/

package pkt.dosya.abstracts;

import java.io.File;
import java.io.IOException;

public interface IDosya {
	void readJavaFile(File file) throws IOException;
	
	void readJavaFile(String filePath) throws IOException;

	String getFileContent();
}
