package servlets;


public class Dept {
	
	private int id;
	private String name;
	private String location;
	
	
	public Dept() {};
	public Dept(int id, String name, String location) {
		this.id = id;
		this.name = name;
		this.location = location;
	}
	
	
	
	
	@Override
	public String toString() {
		return "Dept [id=" + id + ", name=" + name + ", location=" + location + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
	public static DeptBuilder builder() {
		return new DeptBuilder(new Dept());
	}
	
	// DeptBuilder class
    public static class DeptBuilder {
        private Dept dept;

        // Constructor for EmployeeBuilder
        public DeptBuilder(Dept dept) {
            this.dept = dept;
        }
        
        // Build the final Employee object
        public Dept build() {
            return dept;
        }

        // Methods to set fields
        public DeptBuilder id(int id) {
            dept.setId(id);
            return this;
        }

        public DeptBuilder name(String name) {
            dept.setName(name);
            return this;
        }

        public DeptBuilder location(String location) {
            dept.setLocation(location);
            return this;
        }

       
    }
	
	
	

}
