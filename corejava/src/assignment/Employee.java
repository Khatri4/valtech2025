package assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Employee implements Comparable<Employee> {
	
	private long id;
    private String name;
    private int age;
    private float salary;
    private Gender gender;
    private int level;
    private int experience;
    
    public enum Gender {
        MALE, FEMALE, OTHER
    }
    
    
//    constructor for class
    public Employee() {}
	public Employee(long id, String name, int age, float salary, Gender gender, int level, int experience) {
			this.id = id;
			this.name = name;
			this.age = age;
			this.salary = salary;
			this.gender = gender;
			this.level = level;
			this.experience = experience;
	}
	
	public static EmployeeBuilder builder() {
		return new EmployeeBuilder(new Employee());
	}
	
	
	
	//    getter setter for variables
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	
	
//	hash code and equal to
	@Override
	public int hashCode() {
		return toString().hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return age == other.age && experience == other.experience && gender == other.gender && id == other.id
				&& level == other.level && Objects.equals(name, other.name)
				&& Float.floatToIntBits(salary) == Float.floatToIntBits(other.salary);
	}
	
	
// 	toString code
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + ", gender=" + gender
				+ ", level=" + level + ", experience=" + experience + "]";
	}



	// EmployeeBuilder class
    public static class EmployeeBuilder {
        private Employee employee;

        // Constructor for EmployeeBuilder
        public EmployeeBuilder(Employee employee) {
            this.employee = employee;
        }
        
        // Build the final Employee object
        public Employee build() {
            return employee;
        }

        // Methods to set fields
        public EmployeeBuilder id(long id) {
            employee.setId(id);
            return this;
        }

        public EmployeeBuilder name(String name) {
            employee.setName(name);
            return this;
        }

        public EmployeeBuilder age(int age) {
            employee.setAge(age);
            return this;
        }

        public EmployeeBuilder salary(float salary) {
            employee.setSalary(salary);
            return this;
        }

        public EmployeeBuilder gender(String gender) {
            employee.setGender(Gender.valueOf(gender));
            return this;
        }

        public EmployeeBuilder level(int level) {
            employee.setLevel(level);
            return this;
        }

        public EmployeeBuilder experience(int experience) {
            employee.setExperience(experience);
            return this;
        }

       
    }
    
    
//    compare to method
	@Override
	public int compareTo(Employee o) {
		int compareLevel=Integer.compare(this.level,o.level);
		if(compareLevel!=0) {
			return compareLevel;
		}
		int compareExp=Integer.compare(this.experience,o.experience);
		if(compareLevel!=0) {
			return compareExp;
		}
		int genderComparison=this.gender.compareTo(o.gender);
		if(genderComparison!=0) {
			return genderComparison;
		}
		int compareSalary=Float.compare(this.salary, o.salary);
			return compareSalary;
	}
     

    
    
}