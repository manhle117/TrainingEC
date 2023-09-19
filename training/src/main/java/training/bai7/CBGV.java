package training.bai7;

import java.util.List;

public class CBGV {
	private String teacherId;
	private List<String> listStudentId;
	
	
	public CBGV(String teacherId, List<String> listStudentId) {
		super();
		this.teacherId = teacherId;
		this.listStudentId = listStudentId;
	}
	public String getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	public List<String> getListStudentId() {
		return listStudentId;
	}
	public void setListStudentId(List<String> listStudentId) {
		this.listStudentId = listStudentId;
	}
	@Override
	public String toString() {
		return "CBGV [teacherId=" + teacherId + ", listStudentId=" + listStudentId + "]";
	}
	
	
	
}
