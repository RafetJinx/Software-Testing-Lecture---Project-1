/**
*
* @author Rafet ERSOY    rafet.ersoy@ogr.sakarya.edu.tr
* @since 21.04.2023
* <p>
* Varlıklarımdan biri olan RelationalOperators'ün tanımlandığı sınıftır.
* </p>
*/

package pkt.entities.concretes.operators;

public class RelationalOperators extends Operator{
	private static final String[] RELATIONAL_OPERATORS = {"<", "<=", ">", ">=", "==", "!="};
	private static final String RELATIONAL_OPERATORS_REGEX = "<=?|>=?|==|!=";
	
	public RelationalOperators() {
		super(RELATIONAL_OPERATORS, RELATIONAL_OPERATORS_REGEX);
	}
}
