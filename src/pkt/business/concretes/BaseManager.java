/**
*
* @author Rafet ERSOY    rafet.ersoy@ogr.sakarya.edu.tr
* @since 21.04.2023
* <p>
* RegexService'i kullanabilmek için BaseService'i implemente eden
* BaseManager sınıfım. Bu sınıfı diğer manager sınıfları kalıtım
* olarak alacak.
* </p>
*/

package pkt.business.concretes;

import pkt.business.abstracts.BaseService;
import pkt.business.abstracts.regex.RegexService;

public class BaseManager implements BaseService{
	private RegexService regexService;

	public BaseManager(RegexService regexService) {
		this.regexService = regexService;
	}

	@Override
	public RegexService getRegexService() {
		return regexService;
	}
}
