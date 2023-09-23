package training.bai14;

import training.bai14.Dao.StudentDao;
import training.bai14.model.GoodStudent;
import training.bai14.model.NormalStudent;
import training.bai14.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentManagement {
    private StudentDao studentDao = new StudentDao();




    public List<Student> showInforAllStudent(){
         List<Student> listStudent ;
        listStudent = studentDao.getAllStudent();

        return listStudent;
    }
    public void selectStudent(int numberOfSelection) {
        List<GoodStudent> goodStudentList = studentDao.getListOfGoodStudent();
        List<NormalStudent> normalStudentList = studentDao.getListOfNormalStudent();
        List<Student>listStudent = studentDao.getAllStudent();

        if (numberOfSelection < 11 || numberOfSelection > 15) {
            System.out.println("Invalid please input between 11 and 15");
            return;
        }
        if (numberOfSelection > listStudent.size()) {
            System.out.println("Number of student < selection");
            return;
        }
        goodStudentList.sort((s1, s2) -> {
            if (s1.getGpa() != s2.getGpa()) {
                return Double.compare(s2.getGpa(), s1.getGpa()); //Giảm dần theo Gpa
            }
            return s1.getFullName().compareTo(s2.getFullName());// Tăng dần theo tên
        });

        // Chọn các ứng viên khá giỏi cho công ty
        int numGoodCandidates = Math.min(numberOfSelection, goodStudentList.size());
        System.out.println("Selected good students: ");
        for (int i = 0; i < numGoodCandidates;i++){
            GoodStudent selectedStudent = goodStudentList.get(i);
            selectedStudent.ShowMyInfor();
        }

        if(numberOfSelection > goodStudentList.size()){
            // Sắp xếp danh sách sinh viên trung bình theo điểm thi đầu vào, TOEIC và sau đó theo họ tên
            // chỉnh syntax
            normalStudentList.sort((s1,s2) -> {
                if (s1.getEntryTestScore() != s2.getEntryTestScore()) {
                    // Sắp xếp giảm dần theo điểm thi đầu vào
                    return Double.compare(s2.getEntryTestScore(), s1.getEntryTestScore());
                }
                if (s1.getEnglishScore() != s2.getEnglishScore()) {
                    // Sắp xếp giảm dần theo điểm TOEIC
                    return Double.compare(s2.getEnglishScore(), s1.getEnglishScore());
                }
                // Sắp xếp tăng dần theo họ tên
                return s1.getFullName().compareTo(s2.getFullName());
            });
        }
        int numNormalStudent = Math.min(numberOfSelection - numGoodCandidates, normalStudentList.size());
        System.out.println("Selected normal students: ");
        for (int i = 0; i < numNormalStudent;i++){
            NormalStudent selectedStudent = normalStudentList.get(i);
            selectedStudent.ShowMyInfor();
        }

    }
}
