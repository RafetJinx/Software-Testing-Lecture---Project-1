/**
*
* @author Rafet ERSOY    rafet.ersoy@ogr.sakarya.edu.tr
* @since 21.04.2023
* <p>
* Manager sınıflarının ihtiyaç duyacağı getRegexService fonksiyonunun imzası
* bu arayüzde bulunuyor. Bu arayüzü manager sınıfları arayüzü implemente
* ederek kullanabilecektir.
* </p>
*/

package pkt.business.abstracts;

import pkt.business.abstracts.regex.RegexService;

public interface BaseService {
	RegexService getRegexService();
}
