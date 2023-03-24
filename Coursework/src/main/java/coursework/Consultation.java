package coursework;
import java.io.Serializable;

public class Consultation implements Serializable{
    private String date;
    private String time;
    private Integer cost;
    private String notes;
    private Doctor doctor;
    private Patient patient;
    private int patient_appointment_time;


    //constructor

    public Consultation(String date, String time, Integer cost, String notes, Doctor doctor, Patient patient, int patient_appointment_time) {
        this.date = date;
        this.time = time;
        this.cost = cost;
        this.notes = encrypt(notes);
        this.doctor = doctor;
        this.patient = patient;
        this.patient_appointment_time = patient_appointment_time;
    }


    //getters

    public String getDate() {

        return date;
    }

    public String getTime() {

        return time;
    }

    public Integer getCost() {

        return cost;
    }

    public String getNotes() {

        return notes;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public int getPatient_appointment_time() {
        return patient_appointment_time;
    }
    //setters

    public void setDate(String date) {

        this.date = date;
    }

    public void setTime(String time) {

        this.time = time;
    }

    public void setCost(Integer cost) {

        this.cost = cost;
    }

    public void setNotes(String notes) {

        this.notes = notes;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setPatient_appointment_time(int patient_appointment_time) {
        this.patient_appointment_time = patient_appointment_time;
    }

    // Encryption code
    public  String encrypt(String plainText) {
        StringBuilder encryptedText = new StringBuilder();
        for (int i = 0; i < plainText.length(); i++) {
            char c = plainText.charAt(i);
            encryptedText.append((char) (c + 7));
        }
        return encryptedText.toString();
    }

    // Decryption code
    public  String decrypt() {
        String encryptedText=this.notes;
        StringBuilder decryptedText = new StringBuilder();
        for (int i = 0; i < encryptedText.length(); i++) {
            char c = encryptedText.charAt(i);
            decryptedText.append((char) (c - 7));
        }
        return decryptedText.toString();
    }

    @Override
    public String toString() {
        return "Consultation{" +
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", cost=" + cost +
                ", encrpt notes='" + notes + '\'' +
                ", decrpt notes='" + decrypt() + '\'' +
                ", doctor=" + doctor +
                ", patient=" + patient +
                ", patient_appointment_time=" + patient_appointment_time +
                '}';
    }


}
