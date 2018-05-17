//developer: JiaQi Tang  s3598284
package interfaces;

import java.util.Collection;

import exceptions.NoAvailableException;
import exceptions.NoParentException;
import exceptions.NoSuchAgeException;
import exceptions.NotToBeClassmatesException;
import exceptions.NotToBeColleaguesException;
import exceptions.NotToBeCoupledException;
import exceptions.NotToBeFriendsException;
import exceptions.TooYoungException;

public interface GameEngine {
	public void initialPeopleList() throws Exception;
	public void initialRelationList();
	public void listAllPeople();
	public void addPeople(String name,String pic,String status,String gender,String age,String state) throws NoParentException, NoSuchAgeException;
	public void removePeople(People people) throws NoParentException;
    public String findRelationship(String people1,String people2);
    public void defineRelation(String people1,String people2,String relationship) throws TooYoungException, NotToBeFriendsException,NoAvailableException, NotToBeCoupledException, NotToBeColleaguesException, NotToBeClassmatesException;
    public void defineParents(String child,String father,String mother)throws NoParentException;
    public String findParents(String name);
    public String findChild(String name);
    public String findCouple(String name);
    public boolean selectPeople(String name);
    public Collection<People> getPeopleList();
    public People getSelectedPeople(String name);
    public void removeAllRelationship(String name);
}
