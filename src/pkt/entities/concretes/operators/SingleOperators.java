/**
*
* @author Rafet ERSOY    rafet.ersoy@ogr.sakarya.edu.tr
* @since 21.04.2023
* <p>
* Varlıklarımdan biri olan SingleOperators'ün tanımlandığı sınıftır.
* </p>
*/

package pkt.entities.concretes.operators;

public class SingleOperators extends Operator{
	private static final String[] SINGLE_OPERATORS = {"++", "--", "!"};
	private static final String SINGLE_OPERATORS_REGEX = "(?<!\\\\!)[\\\\+\\\\-]{2}|!(?!=)";

	public SingleOperators() {
		super(SINGLE_OPERATORS, SINGLE_OPERATORS_REGEX);
	}
}
