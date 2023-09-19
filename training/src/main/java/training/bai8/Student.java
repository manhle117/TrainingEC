package training.bai8;

public class Student {
	private String fullName;
	private String classId;
	private int age;
	public Student(String fullName, String classId, int age) {
		super();
		this.fullName = fullName;
		this.classId = classId;
		this.age = age;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [fullName=" + fullName + ", classId=" + classId + ", age=" + age + "]";
	}
	
	
}
