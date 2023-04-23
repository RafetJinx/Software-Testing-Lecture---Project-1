/**
*
* @author Rafet ERSOY    rafet.ersoy@ogr.sakarya.edu.tr
* @since 21.04.2023
* <p>
* Varlıklarımdan biri olan SingleOperators'un tanımlandığı sınıftır.
* </p>
*/

package pkt.entities.concretes.operators;

public class BinaryOperators extends Operator{
	private static final String[] BINARY_OPERATORS = {
			"+", "-", "*", "/", "%", 
			"&", "|", "^", "=", "+=", 
			"-=", "/=", "*=", "%=", "&=", 
			"|=", "^=", "<", "<=", ">", 
			">=", "==", "!=", "&&", "||"
	};
	
	private static final String BINARY_OPERATORS_REGEX = "\\|\\=|(?<!\\+)\\+\\=?(?!\\+)|(?<!\\-)\\-\\=?(?!\\-)|\\*\\=?|\\/\\=?|\\%\\=?|\\&{2}|(?<!\\&)\\&(?!\\&)\\=?|\\|{1,2}|\\^\\=?|\\=\\=?|\\<\\=?|\\>\\=?|\\!\\=";

	public BinaryOperators( ) {
		super(BINARY_OPERATORS, BINARY_OPERATORS_REGEX);
	}
}
