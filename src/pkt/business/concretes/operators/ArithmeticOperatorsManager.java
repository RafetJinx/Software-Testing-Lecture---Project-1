/**
*
* @author Rafet ERSOY    rafet.ersoy@ogr.sakarya.edu.tr
* @since 21.04.2023
* <p>
* RegexService'i kullanabilmek için BaseManager sınıfını kalıtım alan
* ArithmeticOperatorsService fonksiyonlarını kullanabilmek için FunctionService'i
* implemente eden ArithmeticOperatorsManager sınıfım.
* </p>
*/

package pkt.business.concretes.operators;

import pkt.business.abstracts.operators.ArithmeticOperatorsService;
import pkt.business.abstracts.regex.RegexService;
import pkt.business.concretes.BaseManager;

public class ArithmeticOperatorsManager extends BaseManager implements ArithmeticOperatorsService{

	public ArithmeticOperatorsManager(RegexService regexService) {
		super(regexService);
	}

	@Override
	public int calculate(String expression) {
		int count = super.getRegexService().calculateCount(expression);
		return count;
	}
	
}
