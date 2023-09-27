package training.bai13;

import training.bai13.exception.BirthDayException;
import training.bai13.exception.EmailException;
import training.bai13.exception.FullNameException;
import training.bai13.exception.PhoneException;

public class Validator {
    public static void fullName(String name) throws FullNameException {
        String regex = "^[A-Za-z\\s]+$";
        if (name.trim() == null || name.trim().isEmpty()) {
            throw new FullNameException("Do not input null or empty, please try again");
        }

        // Kiểm tra độ dài của fullName
        if (name.length() < 2 || name.length() > 50) {
            throw new FullNameException("Length of fullName is 2 < name < 50, please try again");
        }
        if(!name.matches(regex)){
            throw new FullNameException("Invalid name, please try again");
        }
    }
    public static void email(String email) throws EmailException {
        String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$";
        if (email.trim() == null || email.trim().isEmpty()) {
            throw new EmailException("Do not input null or empty, please try again");
        }

        if(!email.matches(regex)){
            throw new EmailException("Invalid email, please try again");
        }
    }

    public static void phone(String phone) throws PhoneException {
        String regex = "^[0-9]{10}$";
        if (phone.trim() == null || phone.trim().isEmpty()) {
            throw new PhoneException("Do not input null or empty, please try again");
        }

        if(!phone.matches(regex)){
            throw new PhoneException("Invalid phone(have 10 numberic), please try again");
        }
    }
    public static void birth(String birth) throws BirthDayException {
        String regex = "\\d{2}-\\d{2}-\\d{4}";
        if (birth.trim() == null || birth.trim().isEmpty()){
            throw new BirthDayException("Do not input null or empty, please try again");
        }
        if(!birth.matches(regex)){
            throw new BirthDayException("Invalid date, please try again");
        }
    }
}
