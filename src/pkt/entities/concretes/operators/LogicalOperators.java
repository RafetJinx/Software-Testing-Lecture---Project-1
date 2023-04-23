/**
*
* @author Rafet ERSOY    rafet.ersoy@ogr.sakarya.edu.tr
* @since 21.04.2023
* <p>
* Varlıklarımdan biri olan LogicalOperators'ün tanımlandığı sınıftır.
* </p>
*/

package pkt.entities.concretes.operators;

public class LogicalOperators extends Operator{
	private static final String[] LOGICAL_OPERATORS = {"&&", "||", "!"};
	private static final String LOGICAL_OPERATORS_REGEX = "\\&\\&|\\|\\||(?<![!=])\\!(?!=)";

	public LogicalOperators() {
		super(LOGICAL_OPERATORS, LOGICAL_OPERATORS_REGEX);
	}
}
