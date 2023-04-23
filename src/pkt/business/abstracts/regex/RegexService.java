/**
*
* @author Rafet ERSOY    rafet.ersoy@ogr.sakarya.edu.tr
* @since 21.04.2023
* <p>
* Regex işlemleri gerçekleştirmek isteyen sınıfların ihtiyaç duyacağı 
* calculateCount fonksiyonlarının imzası bu arayüzde bulunuyor. 
* Manager sınıfı arayüzü implemente ederek kullanabilecektir.
* </p>
*/

package pkt.business.abstracts.regex;

public interface RegexService {
	int calculateCount(String expression);
}
