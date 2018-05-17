//developer: JiaQi Tang  s3598284
package functionality;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import exceptions.NoAvailableException;
import exceptions.NoParentException;
import exceptions.NoSuchAgeException;
import exceptions.NotToBeClassmatesException;
import exceptions.NotToBeColleaguesException;
import exceptions.NotToBeCoupledException;
import exceptions.NotToBeFriendsException;
import exceptions.TooYoungException;
import interfaces.GameEngine;
import interfaces.People;
import interfaces.Relation;

public class GameEngineImpl implements GameEngine {
	Collection<People> peopleList = new ArrayList<People>();
	Collection<Relation> relationList = new ArrayList<Relation>();
	People selectedPeople = null;
	// jdbc
	Connection con = null;
	Statement stmt = null;
	int result2 = 0;
	int result3 = 0;
	int result4 = 0;
	int result5 = 0;
	ResultSet result1 = null;

	@Override
	public void initialPeopleList() throws Exception{
		try {
			String path = "../ApAssignment2/src/inPutData/inputPeople.txt";
			File file = new File(path); // read the above file path
			InputStreamReader reader = new InputStreamReader(new FileInputStream(file)); // create a stream reader
			BufferedReader br = new BufferedReader(reader); // create a buffered reader
			String line = "";
			// jdbc part:
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			con = DriverManager.getConnection("jdbc:hsqldb:TestDB", "sa", "123");
			stmt = con.createStatement();
			result4 = stmt.executeUpdate("DROP TABLE people if exists");
			System.out.println(result4 + " tables dropped");
			result3 = stmt.executeUpdate(
					"CREATE TABLE people (name varchar(20), picture varchar(20), status varchar(20), gender varchar(20), age varchar(20), state varchar(20));");
			System.out.println(result3 + " tables created from database");

			while ((line = br.readLine()) != null) {
				String[] p = line.split(",");
				// read txt and put data into arrayList
				peopleList.add(new PeopleImpl(p[0], p[1], p[2], p[3], p[4], p[5]));
				// also insert the txt data into database
				result2 = stmt.executeUpdate("INSERT INTO people VALUES ('" + p[0] + "','" + p[1] + "','" + p[2] + "','"
						+ p[3] + "','" + p[4] + "','" + p[5] + "')");
				System.out.println(result2 + " people inserted into database");
			}
			System.out.println("txt document exists");
			System.out.println("loading data from txt documents successfully!");
			br.close();
		} catch (FileNotFoundException e) {
			try {
				try {
					Class.forName("org.hsqldb.jdbc.JDBCDriver");
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				con = DriverManager.getConnection("jdbc:hsqldb:TestDB", "sa", "123");
				stmt = con.createStatement();
				result1 = stmt.executeQuery("SELECT name,picture,status,gender,age,state FROM people");
				while (result1.next()) {
					peopleList.add(new PeopleImpl(result1.getString("name"), result1.getString("picture"),
							result1.getString("status"), result1.getString("gender"), result1.getString("age"),
							result1.getString("state")));
				}
			} catch (SQLException e1) {
				throw new Exception();
			}
			System.out.println("txt document not found");
			System.out.println("loading data from database successfully!");
		} catch (Exception e) {
			System.out.println("txt document and database are both not found");
			throw new Exception();
		}
	}

	@Override
	public void initialRelationList() {
		try {
			String path1 = "../ApAssignment2/src/inPutData/inputRelation.txt";
			File file1 = new File(path1);
			InputStreamReader reader1 = new InputStreamReader(new FileInputStream(file1));
			BufferedReader br1 = new BufferedReader(reader1);
			String line1 = "";
			while ((line1 = br1.readLine()) != null) {
				String[] p = line1.split(",");
				relationList.add(new RelationImpl(p[0], p[1], p[2]));
			}
			br1.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void listAllPeople() {
		for (People people : peopleList) {
			System.out.println("Name: " + people.getName() + " Pic: " + people.getPic() + " Status: "
					+ people.getStatus() + " Gender: " + people.getGender() + " Age: " + people.getAge() + " State "
					+ people.getState());
		}
	}

	@Override
	public void addPeople(String name, String pic, String status, String gender, String age, String state)
			throws NoParentException, NoSuchAgeException {
		if ((Integer.parseInt(age) <= 16) && (findParents(name) == null)) {
			throw new NoParentException();
		}
		if (Integer.parseInt(age) < 0 || Integer.parseInt(age) > 150) {
			throw new NoSuchAgeException();
		}
		peopleList.add(new PeopleImpl(name, pic, status, gender, age, state));
		// when add people, we also need to update the database
		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			con = DriverManager.getConnection("jdbc:hsqldb:TestDB", "sa", "123");
			stmt = con.createStatement();
			result2 = stmt.executeUpdate("INSERT INTO people VALUES ('" + name + "','" + pic + "','" + status + "','"
					+ gender + "','" + age + "','" + state + "')");
			System.out.println(result2 + " people added into database");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void removePeople(People people) throws NoParentException {
		// when add people, we also need to update the database
		String name = people.getName();
		if (findChild(people.getName()) != null) {
			throw new NoParentException();
		}
		peopleList.remove(people);
		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			con = DriverManager.getConnection("jdbc:hsqldb:TestDB", "sa", "123");
			stmt = con.createStatement();
			result5 = stmt.executeUpdate("DELETE FROM people WHERE name LIKE '" + name + "%'");
			System.out.println(result5 + " people deleted from database");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void removeAllRelationship(String name) {
		for (Relation relation : relationList) {
			if (relation.getName1().contains(name)) {
				relationList.remove(relation);
			}
			if (relation.getName2().contains(name)) {
				relationList.remove(relation);
			}
		}
	}

	@Override
	public String findRelationship(String people1, String people2) {
		for (Relation relation : relationList) {
			if ((relation.getName1() != null && relation.getName1().contains(people1))
					&& (relation.getName2() != null && relation.getName2().contains(people2))) {
				return relation.getRelation();
			}
			if ((relation.getName1() != null && relation.getName1().contains(people2))
					&& (relation.getName2() != null && relation.getName2().contains(people1))) {
				return relation.getRelation();
			}
		}
		return null;
	}

	@Override
	public void defineRelation(String people1, String people2, String relationship)
			throws TooYoungException, NotToBeFriendsException, NoAvailableException, NotToBeCoupledException,
			NotToBeColleaguesException, NotToBeClassmatesException {
		// define two integers for comparing age
		int age1 = Integer.parseInt(getSelectedPeople(people1).getAge());
		int age2 = Integer.parseInt(getSelectedPeople(people2).getAge());
		// define exceptions throwing
		if ((age1 < 3 || age2 < 3) && relationship.contains("friend")) {
			throw new TooYoungException();
		}
		if ((((age1 < 3 && age2 > 16) || (age2 < 3 && age1 > 16)) || ((age1 - age2 > 3) || (age2 - age1 > 3)))
				&& relationship.contains("friend")) {
			throw new NotToBeFriendsException();
		}
		if ((findCouple(people1) != null || findCouple(people2) != null) && relationship.contains("couple")) {
			throw new NoAvailableException();
		}
		if (((age1 <= 16 && relationship.contains("couple")) || (age2 <= 16 && relationship.contains("couple")))) {
			throw new NotToBeCoupledException();
		}
		if ((age1 <= 16 || age2 <= 16) && relationship.contains("colleague")) {
			throw new NotToBeColleaguesException();
		}
		if ((age1 < 3 || age2 < 3) && relationship.contains("colleague")) {
			throw new NotToBeClassmatesException();
		}
		relationList.add(new RelationImpl(people1, people2, relationship));
	}

	@Override
	public void defineParents(String child, String father, String mother) throws NoParentException {
		// define exceptions throwing
		if (!findRelationship(father, mother).contains("couple")) {
			throw new NoParentException();
		}

		relationList.add(new RelationImpl(child, father, "parent"));
		relationList.add(new RelationImpl(child, mother, "parent"));
	}

	@Override
	public String findParents(String name) {
		Collection<String> parentList = new ArrayList<String>();
		String parents = null;
		for (Relation relation : relationList) {
			if ((relation.getName1()).contains(name)&& (relation.getRelation().contains("parent"))) {
				parentList.add(relation.getName2());
			}
			if ((relation.getName2()).contains(name)&& (relation.getRelation().contains("parent"))) {
				parentList.add(relation.getName1());
			}
		}
		if (parentList != null) {
			for (String parent : parentList) {
				parents = parents + "||" + parent;
			}
		}
		return parents;
	}

	@Override
	public String findChild(String name) {
		Collection<String> childrenList = new ArrayList<String>();
		String children = null;
		for (Relation relation : relationList) {
			if (((relation.getName1()).contains(name)
					&& Integer.parseInt(getSelectedPeople(relation.getName2()).getAge()) <= 16)
					&& (relation.getRelation().contains("parent"))) {
				childrenList.add(relation.getName2());
			}
			if (((relation.getName2()).contains(name)
					&& Integer.parseInt(getSelectedPeople(relation.getName1()).getAge()) <= 16)
					&& (relation.getRelation().contains("parent"))) {
				childrenList.add(relation.getName1());
			}
		}
		if (childrenList != null) {
			for (String child : childrenList) {
				children = children + "||" + child;
			}
		}
		return children;
	}

	/*
	 * because the "NoAvailableException", I need to know whether this person has a
	 * husband or wife
	 */
	@Override
	public String findCouple(String name) {
		for (Relation relation : relationList) {
			if ((relation.getName1()).contains(name) && (relation.getRelation().contains("couple"))) {
				return relation.getName2();
			}
			if ((relation.getName2()).contains(name) && (relation.getRelation().contains("couple"))) {
				return relation.getName1();
			}
		}
		return null;
	}

	@Override
	public boolean selectPeople(String name) {
		for (People people : peopleList) {
			if (people.getName() != null && people.getName().contains(name)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Collection<People> getPeopleList() {
		return peopleList;
	}

	@Override
	public People getSelectedPeople(String name) {
		for (People people : peopleList) {
			if (people.getName() != null && people.getName().contains(name)) {
				return people;
			}
		}
		return null;
	}
}
