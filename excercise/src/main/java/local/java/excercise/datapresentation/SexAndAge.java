package local.java.excercise.datapresentation;

import local.java.model.Sex;

public class SexAndAge{
	
	public SexAndAge(Sex sex, Integer age) {
		super();
		this.sex = sex;
		Age = age;
	}
	
	public String toString() {
		
		return this.sex + " " + this.Age;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Age == null) ? 0 : Age.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SexAndAge other = (SexAndAge) obj;
		if (Age == null) {
			if (other.Age != null)
				return false;
		} else if (!Age.equals(other.Age))
			return false;
		if (sex != other.sex)
			return false;
		return true;
	}
	Sex sex;
	Integer Age;


}
