/**
*
* @author Rafet ERSOY    rafet.ersoy@ogr.sakarya.edu.tr
* @since 21.04.2023
* <p>
* RegexService'i kullanabilmek için BaseManager sınıfını kalıtım alan
* FunctionService'in fonksiyonlarını kullanabilmek için FunctionService'i
* implemente eden FunctionManager sınıfım.
* </p>
*/

package pkt.business.concretes.function;

import pkt.business.abstracts.function.FunctionService;
import pkt.business.abstracts.regex.RegexService;
import pkt.business.concretes.BaseManager;

public class FunctionManager extends BaseManager implements FunctionService{
	
	public FunctionManager(RegexService regexService) {
		super(regexService);
	}

	@Override
	public int calculate(String expression) {
		int count = super.getRegexService().calculateCount(expression);
		return count;
	}

}
