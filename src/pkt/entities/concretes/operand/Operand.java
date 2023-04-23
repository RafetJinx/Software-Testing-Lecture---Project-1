/**
*
* @author Rafet ERSOY    rafet.ersoy@ogr.sakarya.edu.tr
* @since 21.04.2023
* <p>
* Varlıklarımdan biri olan Operand'ın tanımlandığı sınıftır.
* </p>
*/

package pkt.entities.concretes.operand;

import pkt.entities.abstracts.operand.IOperand;

public class Operand implements IOperand{
	private int count;
	private static final String OPERAND_REGEX = "";

	public Operand() {
		super();
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
		return OPERAND_REGEX;
	}
}
