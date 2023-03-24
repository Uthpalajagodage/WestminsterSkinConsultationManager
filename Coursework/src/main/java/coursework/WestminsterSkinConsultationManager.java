package coursework;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class WestminsterSkinConsultationManager implements SkinConsultationManager{

    //create a list of doctors
    public ArrayList<Doctor>ListOfDoctors=new ArrayList<>();

    //create a list of consultations
    public ArrayList<Consultation>ConsultationList=new ArrayList<>();
    public File doc_file =new File("cwDB_FileSave/doctorList.txt");//file path for doctor stored data
    public File con_file =new File("cwDB_FileSave/consultationList.txt");//file path for consultation stored data
    public WestminsterSkinConsultationManager () throws IOException {
        ListOfDoctors=loadDataFromfile(ListOfDoctors,doc_file,"Doctor");    //load data
        ConsultationList=loadDataFromfile(ConsultationList,con_file,"Consultation");
    }
    @Override
    public void addANewDoctor(Doctor doctor) {
        ListOfDoctors.add(doctor);

    }

    //delete doctor
    @Override
    public void deleteADoctor(String doctor_medical_number) {
        boolean check=false;
        for (Doctor doctor : ListOfDoctors){
            if (doctor_medical_number.equals(doctor.getMedical_licence_number())) {
                check=true;
                System.out.println("Successfully deleted");
                System.out.println("Doctor's name is: " +doctor.getName());
                System.out.println("Doctor's surname is: " +doctor.getSurname());
                System.out.println("Doctor's birthday is: " +doctor.getDate_of_birth());
                System.out.println("Doctor's mobile number is: " +doctor.getMobile_number());
                System.out.println("Doctor's medical licence number is: " +doctor.getMedical_licence_number());
                System.out.println("Doctor's specialisation is: " +doctor.getSpecialisation());
                System.out.println("\n-------------------------------------------------------------------------------------------------------");
                ListOfDoctors.remove(doctor);
                System.out.println("Total number of doctors are "+ListOfDoctors.size()+".");
                break;
            }
        }
        if (!check){
            System.out.println("Can't found a doctor on this number.");
        }
        System.out.println();

    }

    //print list
    @Override
    public void printTheListOfTheDoctors() {
        Collections.sort(ListOfDoctors);
        for (Doctor doctor : ListOfDoctors) {
            System.out.println("Doctor's name is: " + doctor.getName());
            System.out.println("Doctor's surname is: " + doctor.getSurname());
            System.out.println("Doctor's birthday is: " + doctor.getDate_of_birth());
            System.out.println("Doctor's mobile number is: " + doctor.getMobile_number());
            System.out.println("Doctor's medical licence number is: " + doctor.getMedical_licence_number());
            System.out.println("Doctor's specialisation is: " + doctor.getSpecialisation());
            System.out.println("\n-------------------------------------------------------------------------------------------------------");
        }

    }

    //save file
    @Override
    public void saveInAFile(String storeName) throws IOException {
        ObjectOutputStream oos = null;
        File fileName = null;
        ArrayList listName = null;

        if (storeName.equals("Doctor")){
            fileName=this.doc_file;
            listName=this.ListOfDoctors;
        }
        else {
            fileName=this.con_file;
            listName=this.ConsultationList;
        }

        try {
            oos=new ObjectOutputStream(new FileOutputStream(fileName));//open the file
            oos.writeObject(listName);//write the all data from arraylist in the file
            System.out.println("Successful added data!!! in "+ storeName);
        }catch (Exception e){
//            System.out.println(e);
            System.out.println("Error in "+ storeName);
        }finally {
            oos.close();
        }

    }

    @Override
    public void GuiFrontPage() {
        
    }

    //Load data from to file to list
    public static <T> ArrayList<T> loadDataFromfile(ArrayList<T> listName,File filename,String storename) throws IOException {
        ObjectInputStream ois=null;
        Boolean checkFile=false;

        try {
            if (filename.isFile()){
                if ((filename).length()==0) {
                    System.out.println("No any old data in store "+storename);//Store meaning to file
                }else {
                    ois=new ObjectInputStream(new FileInputStream(filename));
                    listName= (ArrayList<T>) ois.readObject();
                    checkFile=true;
                }
            }else {
                System.out.println("Can't find store "+storename);
            }
        }catch (Exception e){
//            System.out.println(e);
            System.out.println("Error in "+storename);
        }finally {
            if (checkFile){
                ois.close();
            }
        }
        return listName;
    }

    @Override
    public ArrayList<Doctor> returnDoctorArrayList() {
        return ListOfDoctors;
    }
    @Override
    public ArrayList<Patient> returnPatientArrayList() {
        return null;
    }

    @Override
    public ArrayList<Consultation> returnConsultationArrayList() {
        return ConsultationList;
    }
}
