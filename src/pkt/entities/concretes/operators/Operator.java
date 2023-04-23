/**
*
* @author Rafet ERSOY    rafet.ersoy@ogr.sakarya.edu.tr
* @since 21.04.2023
* <p>
* Operatör varlıklarımın base sınıfı olan Operator sınıfı
* </p>
*/

package pkt.entities.concretes.operators;

import pkt.entities.abstracts.operators.IOperator;

public class Operator implements IOperator{
	private String[] operators;
	private String regex;
	
	private int count;
	
	public Operator(String[] operators, String regex) {
		super();
		this.operators = operators;
		this.regex = regex;
		this.count = 0;
	}

	@Override
	public int getCount() {
		return count;
	}

	@Override
	public void setCounts(int count) {
		this.count = count;
	}

	@Override
	public String getRegex() {
		return regex;
	}

}
