/**
*
* @author Rafet ERSOY    rafet.ersoy@ogr.sakarya.edu.tr
* @since 21.04.2023
* <p>
* RegexService'i kullanabilmek için BaseManager sınıfını kalıtım alan
* RelationalOperatorsService fonksiyonlarını kullanabilmek için FunctionService'i
* implemente eden RelationalOperatorsManager sınıfım.
* </p>
*/

package pkt.business.concretes.operators;

import pkt.business.abstracts.operators.RelationalOperatorsService;
import pkt.business.abstracts.regex.RegexService;
import pkt.business.concretes.BaseManager;

public class RelationalOperatorsManager extends BaseManager implements RelationalOperatorsService{

	public RelationalOperatorsManager(RegexService regexService) {
		super(regexService);
	}

	@Override
	public int calculate(String expression) {
		int count = super.getRegexService().calculateCount(expression);
		return count;
	}

}
