/**
*
* @author Rafet ERSOY    rafet.ersoy@ogr.sakarya.edu.tr
* @since 21.04.2023
* <p>
* Manager sınıflarının ihtiyaç duyacağı calculator fonksiyonunun imzası
* bu arayüzde bulunuyor. Bu arayüzü manager sınıfları arayüzü implemente
* ederek kullanabilecektir.
* </p>
*/

package pkt.business.abstracts;

public interface CalculateService {
	int calculate(String expression);
}
