package coursework;

import coursework.GUI.GuiFrontPage;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Scanner;

public class ConsoleApplication {
    public static Scanner input=new Scanner(System.in);

    public static SkinConsultationManager manager;

    static {
        try {
            manager = new WestminsterSkinConsultationManager();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) throws IOException {
        doctorConsolePart();

    }

    public static void doctorConsolePart() throws IOException {
        String option;
        while (true) {
            while (true) {
                System.out.println("\n-----------------------------Westminster Skin Consultation Main Menu---------------------------");
                System.out.println("Enter [A] to Add a new doctor");
                System.out.println("Enter [D] to Delete a doctor");
                System.out.println("Enter [P] to Print the list of the doctors");
                System.out.println("Enter [S] to Save in a file ");
                System.out.println("Enter [G] to Get the GUI ");
                System.out.println("Enter [Q] to Quit ");
                System.out.println("------------------------------------------------------------------------------------------------");
                System.out.println("*Please choose one option");


                option = input.next().toUpperCase();  //string to uppercase letter

                if ((option.equals("A")) | (option.equals("D")) | (option.equals("P")) | (option.equals("S")) |(option.equals("G")) | (option.equals("Q"))) {
                    break;
                } else {
                    System.out.println("Please Enter valid Input.");
                }


            }

            if (option.equals("A")) {
                addANewDoctor();
            } else if (option.equals("D")) {
                System.out.println("Please enter the medical number of the doctor you want to delete.");
                manager.deleteADoctor(input.next());
            } else if (option.equals("P")) {
                manager.printTheListOfTheDoctors();
            } else if (option.equals("S")) {
                manager.saveInAFile("Doctor");
            } else if (option.equals("G")) {
                new GuiFrontPage();
                break;
            } else if (option.equals("Q")) {
                System.exit(0);
            } else {
                System.out.println("Invalid Input.");
            }
        }
    }

    //add a doctor
    public static void addANewDoctor() {
        String name;
        String surname;
        String date_of_birth;
        String mobile_number;
        String medical_licence_number;
        String specialisation;

        if (manager.returnDoctorArrayList().size()<10){
            System.out.print("Enter Doctor's name :");
            name=input.next();
            System.out.print("Enter Doctor's surname :");
            surname=input.next();
            date_of_birth=birthdayValidation();         //birthday validation method
            mobile_number=mobileNumberValidation();     //mobile number validation
            medical_licence_number=medicalLicenceNumberValidation();    //medical licence number validation
            System.out.print("Enter Doctor's specialisation :");
            specialisation=input.next();

            Doctor doctor=new Doctor(name,surname,date_of_birth,mobile_number,medical_licence_number,specialisation);

            System.out.println("Successfully added");
            System.out.println("\n-------------------------------------------------------------------------------------------------------");
            System.out.println("Doctor's name is: " +doctor.getName());
            System.out.println("Doctor's surname is: " +doctor.getSurname());
            System.out.println("Doctor's birthday is: " +doctor.getDate_of_birth());
            System.out.println("Doctor's mobile number is: " +doctor.getMobile_number());
            System.out.println("Doctor's medical licence number is: " +doctor.getMedical_licence_number());
            System.out.println("Doctor's specialisation is: " +doctor.getSpecialisation());
            System.out.println("\n-------------------------------------------------------------------------------------------------------");

            manager.addANewDoctor(doctor);
        }
        else{
            System.out.println("The list is almost full.");
        }

    }

    //validation part

    //mobile number validation
    public static String mobileNumberValidation(){
        String mobile_number;

        while (true){
            System.out.print("Please enter your mobile number :");
            mobile_number=input.next();
           try {
               Integer.parseInt(mobile_number);
               if (mobile_number.length()==10){
                   break;
               }
               else {
                   System.out.println("Invalid mobile number.Please enter correct numbers.");
               }
           }
           catch (Exception e){
               System.out.println("Please enter integers for mobile number ");
           }
        }
        return mobile_number;
    }


    //birthday validation
    public static String birthdayValidation(){
        String date_of_birth;
        DateTimeFormatter formater= DateTimeFormatter.ofPattern("yyyy/MM/dd");

        while (true) {
            System.out.print("Enter Doctor's birthday (yyyy/MM/dd) :");
            date_of_birth = input.next();

            try {
                formater.parse(date_of_birth);
                int birth_year=Integer.parseInt(""+date_of_birth.charAt(0)+date_of_birth.charAt(1)+date_of_birth.charAt(2)+date_of_birth.charAt(3)); //convert string date of birth to integer date of birth.
                int current_year= Calendar.getInstance().get(Calendar.YEAR); //to get current year

                // checking the year range
                if ((birth_year>=(current_year-70)) && (birth_year<(current_year-20))){
                    break;
                }
                else {
                    System.out.println("use  "+(current_year-70)+"-"+(current_year-20)+" year range");
                }
            }
            catch (Exception e) {
                System.out.println("Please enter valid birth year");
            }
        }

        return date_of_birth;
    }


    //doctor's medical licence number validation
    public static String medicalLicenceNumberValidation() {
        String medical_licence_number;

        if (manager.returnDoctorArrayList().size()==0){
            System.out.print("Enter Doctor's medical licence number :");
            medical_licence_number=input.next();
        }
        else {
            while (true) {
                boolean check = false;
                System.out.print("Enter Doctor's medical licence number :");
                medical_licence_number = input.next();
                for (Doctor doctor : manager.returnDoctorArrayList()) {
                    if (medical_licence_number.equals(doctor.getMedical_licence_number())) {
                        System.out.println("This medical number is already used.Please enter another one.");
                        check = true;
                        break;
                    }
                }
                if (!check) {
                    break;
                }
            }
        }
        return medical_licence_number;

    }
}
