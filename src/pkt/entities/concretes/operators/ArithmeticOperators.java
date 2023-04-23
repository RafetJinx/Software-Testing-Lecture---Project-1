/**
*
* @author Rafet ERSOY    rafet.ersoy@ogr.sakarya.edu.tr
* @since 21.04.2023
* <p>
* Varlıklarımdan biri olan ArithmeticOperators'ün tanımlandığı sınıftır.
* </p>
*/

package pkt.entities.concretes.operators;

public class ArithmeticOperators extends Operator{
	private static final String[] ARITHMETIC_OPERATORS = {
			"+", "++", "-", "--", "*", "/", "%", "&", "|", "^",
			"=", "+=", "-=", "/=", "*=", "%=", "&=", "|=", "^="
	};
	private static final String ARITHMETIC_OPERATORS_REGEX = "(?<!\\!)\\=|\\+\\=|\\-\\=|\\+{1,2}|\\-{1,2}|\\*\\=?|\\/\\=?|\\%\\=?|\\&\\=?|\\|\\=?|\\^\\=?";

	public ArithmeticOperators() {
		super(ARITHMETIC_OPERATORS, ARITHMETIC_OPERATORS_REGEX);
	}
}
