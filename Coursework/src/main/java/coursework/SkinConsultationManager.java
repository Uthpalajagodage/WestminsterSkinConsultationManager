package coursework;

import java.io.IOException;
import java.util.ArrayList;

public interface SkinConsultationManager {
    void addANewDoctor(Doctor doctor);
    void deleteADoctor(String doctor_medical_number);
    void printTheListOfTheDoctors();
    void saveInAFile(String storeName) throws IOException;
    void GuiFrontPage();

    ArrayList<Doctor> returnDoctorArrayList();

    ArrayList<Patient> returnPatientArrayList();

    ArrayList<Consultation> returnConsultationArrayList();

}
