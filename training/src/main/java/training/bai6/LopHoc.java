package training.bai6;

import java.util.List;

public class LopHoc {
	private String idClass;
	private List<Student> listStudent;
	
	
	public LopHoc() {
		super();
	}
	public LopHoc(String idClass, List<Student> listStudent) {
		super();
		this.idClass = idClass;
		this.listStudent = listStudent;
	}
	public String getIdClass() {
		return idClass;
	}
	public void setIdClass(String idClass) {
		this.idClass = idClass;
	}
	public List<Student> getListStudent() {
		return listStudent;
	}
	public void setListStudent(List<Student> listStudent) {
		this.listStudent = listStudent;
	}
	@Override
	public String toString() {
		return "LopHoc [idClass=" + idClass + ", listStudent=" + listStudent + "]";
	}
	
	
	
}
