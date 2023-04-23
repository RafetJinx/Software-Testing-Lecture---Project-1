/**
*
* @author Rafet ERSOY    rafet.ersoy@ogr.sakarya.edu.tr
* @since 21.04.2023
* <p>
* Bütün varlıklarımı kapsayacak Entities Arayüzüm ve 
* varlıklarımın sahip olmalarını istediğim fonksiyonların imzası
* </p>
*/

package pkt.entities.abstracts;

public interface IEntities {
	int getCount();
	void setCounts(int count);
	
	String getRegex();
}
