/**
*
* @author Rafet ERSOY    rafet.ersoy@ogr.sakarya.edu.tr
* @since 21.04.2023
* <p>
* RegexService'i kullanabilmek için BaseManager sınıfını kalıtım alan
* OperandService fonksiyonlarını kullanabilmek için FunctionService'i
* implemente eden OperandManager sınıfım.
* </p>
*/

package pkt.business.concretes.operand;

import pkt.business.abstracts.operand.OperandService;
import pkt.business.abstracts.regex.RegexService;
import pkt.business.concretes.BaseManager;

public class OperandManager extends BaseManager implements OperandService{
	
	public OperandManager(RegexService regexService) {
		super(regexService);
	}

	@Override
	public int calculate(String expression) {
		int count = super.getRegexService().calculateCount(expression);
		return count;
	}

}
