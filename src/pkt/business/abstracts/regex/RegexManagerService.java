/**
*
* @author Rafet ERSOY    rafet.ersoy@ogr.sakarya.edu.tr
* @since 21.04.2023
* <p>
* RegexManager sınıfının ihtiyaç duyacağı 
* removeComments,
* setFileContent
* getFileContent fonksiyonlarının imzası
* bu arayüzde bulunuyor. Manager sınıfı arayüzü implemente
* ederek kullanabilecektir.
* </p>
*/

package pkt.business.abstracts.regex;

public interface RegexManagerService extends RegexService{
	String removeComments(String input);
	void setFileContent(String fileContent);
	String getFileContent();
}
