package training.bai14;


import training.bai14.exception.InvalidDOBExceptionException;
import training.bai14.exception.InvalidFullNameException;
import training.bai14.exception.InvalidOrtherException;
import training.bai14.exception.InvalidPhoneNumberException;

import java.util.Date;

public class Validator {
    public static void fullName(String name) throws InvalidFullNameException {
        String regex = "^[A-Za-z\\s]+$";
        // Kiểm tra độ dài của fullName
        if (name.trim().length() < 10 || name.length() > 50) {
            throw new InvalidFullNameException("Length of fullName is 10 < name < 50, please try again");
        }
        if(!name.matches(regex)){
            throw new InvalidFullNameException("Invalid name, please try again");
        }
    }


    public static void phone(String phone) throws InvalidPhoneNumberException {
        String regex = "^(090|098|091|031|035|038)\\d{7}$";
        if(!phone.matches(regex)){
            throw new InvalidPhoneNumberException("Invalid phone(have 10 numberic and start with 090|098|091|031|035|038), please try again");
        }
    }
    public static void sex(int sex) throws InvalidOrtherException{
        if(sex < 0 || sex > 2){
            throw  new InvalidOrtherException("Invalid Sex (0: male; 1: female; 2:Other), please try again");
        }
    }
    public static void stringNormal(String inputString) throws InvalidOrtherException{
        String regex = "^[A-Za-z0-9]+$";
        if(!inputString.matches(regex)){
            throw new InvalidOrtherException("Invalid Input String, please try again");
        }
    }
    public static void checkDouble(double input) throws InvalidOrtherException{
        String inputString = Double.toString(input);
        String regex = "^\\d+\\.\\d$";

        if (!inputString.matches(regex)) {
            throw new InvalidOrtherException("Invalid Input (format should be x.x), please try again");
        }
        if (input < 0 || input > 10){
            throw new InvalidOrtherException("Invalid Input (between 0 and 10) , please try again ");
        }
    }


}
