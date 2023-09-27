package training.Exam;

import training.Exam.exception.InvalidDOBExceptionException;
import training.Exam.exception.InvalidOrtherException;
import training.bai15.exception.InvalidPhoneNumberException;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Validator {
    public static void empIdCheck(String empId) throws InvalidOrtherException {
        String regex = "^(MNV)\\d{3}$";
        if(!empId.matches(regex)){
            throw new InvalidOrtherException("Input invalid, Format MNVxxx - x is number ");
        }
    }
    public static void checkRoleValid(int role) throws InvalidOrtherException {
        String regex = "^(1|2|3)$";
        String roleString = Integer.toString(role);
        if(!roleString.matches(regex)){
            throw  new InvalidOrtherException("Invalid role, please choose (1: Management, 2: Leader, 3: Dev)");
        }
    }
    public static Date checkDateStart(String dateInput) throws InvalidDOBExceptionException{
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date date;
        dateFormat.setLenient(false);
        try {
             date = dateFormat.parse(dateInput);
            return new Date(date.getTime());
        } catch (ParseException e) {
            throw new InvalidDOBExceptionException("Invalid date input(dd/MM/yyyy ), please try again!");
        }
    }
    public static void checkProductivityScore(double input) throws InvalidOrtherException {
        String inputString = Double.toString(input);
        String regex = "^\\d+\\.\\d$";

        if (!inputString.matches(regex)) {
            throw new InvalidOrtherException("Invalid Input (format should be x.x), please try again");
        }
        if (input < 0.8 || input > 1.2){
            throw new InvalidOrtherException("Invalid Input (between 0.8 and 1.2) , please try again ");
        }
    }
    public static void checkIntGreaterThan0(int input) throws InvalidOrtherException {
        if(input < 0){
            throw new InvalidOrtherException("Invalid Input ( input >= 0)");
        }
    }


}
