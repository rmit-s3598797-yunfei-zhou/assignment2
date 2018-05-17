//developer: JiaQi Tang  s3598284
package functionality;

import interfaces.People;

public class PeopleImpl implements People {
	private String name;
	private String pic;
	private String status;
	private String gender;
	private String age;
	private String state;
	public PeopleImpl(String name,String pic,String status,String gender,String age,String state) {
		this.name=name;
		this.pic=pic;
		this.status=status;
		this.gender=gender;
		this.age=age;
		this.state=state;
	}
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name=name;
	}

	@Override
	public String getPic() {
		return pic;
	}

	@Override
	public void setPic(String pic) {
		this.pic=pic;
	}

	@Override
	public String getStatus() {
		return status;
	}

	@Override
	public void setStatus(String status) {
		this.status=status;
	}

	@Override
	public String getGender() {
		return gender;
	}

	@Override
	public void setGender(String gender) {
		this.gender=gender;
	}

	@Override
	public String getAge() {
		return age;
	}

	@Override
	public void setAge(String age) {
		this.age=age;
	}

	@Override
	public String getState() {
		return state;
	}

	@Override
	public void setState(String state) {
		this.state=state;
	}
}
