//developer: YunFei Zhou s3598797
package functionality;

import interfaces.Relation;

public class RelationImpl implements Relation {
	private String name1;
	private String name2;
	private String relationType;
	public RelationImpl(String name1, String name2, String relationType) {
		this.name1=name1;
		this.name2=name2;
		this.relationType=relationType;
	}

	@Override
	public String showRelation(String name1, String name2) {
		return this.relationType;
	}

	@Override
	public String getName1() {
		return this.name1;
	}

	@Override
	public String getName2() {
		return this.name2;
	}

	@Override
	public String getRelation() {
		return this.relationType;
	}
}
