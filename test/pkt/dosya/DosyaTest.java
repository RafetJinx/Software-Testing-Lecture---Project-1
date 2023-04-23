/**
*
* @author Rafet ERSOY    rafet.ersoy@ogr.sakarya.edu.tr
* @since 21.04.2023
* <p>
* Dosya sınıfının test sınıfıdır
* </p>
*/

package pkt.dosya;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import pkt.dosya.concretes.Dosya;

@DisplayName("File Creation Test")
class DosyaTest {

	@Test
	@DisplayName("ReadJavaFile test with File parameter")
	public void testReadJavaFileWithFile() throws IOException {
		String expectedFileContent = "This is a sample file content." + System.lineSeparator();
		File file = createTempFile("sample_file.txt", expectedFileContent);
		
		Dosya dosya = new Dosya(file);
		
		assertEquals(expectedFileContent, dosya.getFileContent());
		
		file.delete();
	}

	
	@Test
	@DisplayName("ReadJavaFile test with FilePath parameter")
	public void testReadJavaFileWithFilePath() throws IOException {
		String expectedFileContent = "This is a sample file content." + System.lineSeparator();
		File file = createTempFile("sample_file.txt", expectedFileContent);
		
		Dosya dosya = new Dosya(file.getAbsolutePath());
		
		assertEquals(expectedFileContent, dosya.getFileContent());
		
		file.delete();
	}
	
	
	@Test
	@DisplayName("TestFileContent Test")
	public void testGetFileContent() throws IOException {
		String expectedFileContent = "This is a sample file content." + System.lineSeparator();
		File file = createTempFile("sample_file.txt", expectedFileContent);
		
		Dosya dosya = new Dosya(file);
		
		assertEquals(expectedFileContent, dosya.getFileContent());
		
		file.delete();
	}
	
	
	@Test
	@DisplayName("Test that creates TempFile")
	public void testCreateTempFile() throws IOException {
		String fileName = "sample_file.txt";
		String fileContent = "This is a sample file content.";
		
		File file = createTempFile(fileName, fileContent);
		
		assertTrue(file.exists());
		assertTrue(file.isFile());
		
		file.delete();
	}
	
	private File createTempFile(String fileName, String fileContent) throws IOException {
		File file = File.createTempFile(fileName, null);
		file.deleteOnExit();
		
		file.delete();
		file.createNewFile();
		
		FileWriter writer = new FileWriter(file);
		writer.write(fileContent);
		writer.close();
		
		return file;
	}
}
