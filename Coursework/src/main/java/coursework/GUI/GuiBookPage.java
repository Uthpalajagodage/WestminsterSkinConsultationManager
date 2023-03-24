package coursework.GUI;

import coursework.Consultation;
import coursework.Doctor;
import coursework.Patient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Random;

import static coursework.ConsoleApplication.manager;

public class GuiBookPage extends JFrame {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel detailPanel = new JPanel();
    JPanel panel3 = new JPanel();
    ImageIcon bookPageImage=new ImageIcon("images/bookPageImage.png");
    JLabel Image=new JLabel(bookPageImage);
    JLabel mainTitle=new JLabel("Book Consultation");
    JLabel licenceNum=new JLabel("Enter Dr's Medical licence number");
    JTextField licenceNumText=new JTextField();
    JLabel licenceNumCheck=new JLabel("*Required");
    JLabel dateInput=new JLabel("Enter Appointment date (YYYY/MM/DD)");
    JTextField dateInputText=new JTextField();
    JLabel dateInputCheck=new JLabel("*Required");
    JLabel timeInput=new JLabel("Enter Appointment Time[09.00-22.00] (HH:mm)");
    JTextField timeInputText=new JTextField();
    JLabel timeInputCheck=new JLabel("*Required");
    JLabel durationInput=new JLabel("Enter Appointment time duration (h)");
    JTextField durationInputText=new JTextField();
    JLabel durationInputCheck=new JLabel("*Required");
    JButton backButton=new JButton("Back");
    JButton resetButton=new JButton("Reset");
    JButton checkButton=new JButton("Check Availability");

    //availability part
    JLabel bookTitle = new JLabel("Check Availability");
    ImageIcon availableImage=new ImageIcon("images/availableImage.png");
    JLabel aImage = new JLabel(availableImage);
    JButton bButton = new JButton("Back");
    JButton bookButton = new JButton("Book Appointment");
    JLabel noteTitle = new JLabel("Note");
    JTextField note = new JTextField();

    //reg part
    JLabel regTitle = new JLabel("Register");
    ImageIcon regImage=new ImageIcon("images/regImage.png");
    JLabel rImage = new JLabel(regImage);
    JLabel fName = new JLabel("First Name");
    JTextField fNameText = new JTextField();
    JLabel fNamecheck = new JLabel("*Required");
    JLabel sName = new JLabel("Surname");
    JTextField sNameText = new JTextField();
    JLabel sNamecheck = new JLabel("*Required");
    JLabel bDay = new JLabel("Birthday [YYYY/MM/DD]");
    JTextField bDayText = new JTextField();
    JLabel bDaycheck = new JLabel("*Required");
    JLabel mobileNumber = new JLabel("Mobile Number");
    JTextField mobileNumberText = new JTextField();
    JLabel mobileNumbercheck = new JLabel("*Required");
    JLabel idNum = new JLabel("ID Number");
    JTextField idNumText = new JTextField();
    JLabel idNumcheck = new JLabel("*Required");
    JButton buttonBack = new JButton("Back");
    JButton buttonReset = new JButton("Reset");
    JButton buttonConfirm = new JButton("Confirm");

    //note panel

    JLabel display1 = new JLabel();
    JLabel display2 = new JLabel("is available for your booking time.");
    JLabel display3 = new JLabel("Your allocated to");

    //book doctor
    Doctor finalDoctor;



    public GuiBookPage() {

        frame.setTitle("Westminster Skin Consultation Manager");
        frame.setSize(900, 800);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        panel.setSize(900, 800);
        panel.setVisible(true);
        panel.setLayout(null);
        panel.setBackground(Color.white);
        frame.add(panel);

        Image.setSize(900,800);
        Image.setLocation(0,0);
        panel.add(Image);

        mainTitle.setSize(800, 120);
        mainTitle.setLocation(300, 10);
        mainTitle.setFont(new Font("Times New Roman", Font.BOLD, 40));
        Image.add(mainTitle);

        licenceNum.setSize(500, 70);
        licenceNum.setLocation(100, 100);
        licenceNum.setFont(new Font("Times New Roman", Font.BOLD, 25));
        Image.add(licenceNum);

        licenceNumText.setSize(200, 40);
        licenceNumText.setLocation(500, 150);
        licenceNumText.setFont(new Font("Times New Roman", Font.BOLD, 20));
        licenceNumText.setHorizontalAlignment(JTextField.CENTER);
        licenceNumText.setBackground(new Color(218,221,227));
        Image.add(licenceNumText);

        licenceNumCheck.setSize(300, 70);
        licenceNumCheck.setLocation(750, 75);
        licenceNumCheck.setFont(new Font("Times New Roman", Font.BOLD, 10));
        licenceNumCheck.setForeground(Color.red);
        licenceNumCheck.setVisible(false);
        Image.add(licenceNumCheck);

        dateInput.setSize(500, 70);
        dateInput.setLocation(100, 225);
        dateInput.setFont(new Font("Times New Roman", Font.BOLD, 25));
        Image.add(dateInput);

        dateInputText.setSize(200, 40);
        dateInputText.setLocation(500, 300);
        dateInputText.setFont(new Font("Times New Roman", Font.BOLD, 20));
        dateInputText.setHorizontalAlignment(JTextField.CENTER);
        dateInputText.setBackground(new Color(218,221,227));
        Image.add(dateInputText);

        dateInputCheck.setSize(300, 70);
        dateInputCheck.setLocation(750, 225);
        dateInputCheck.setFont(new Font("Times New Roman", Font.BOLD, 10));
        dateInputCheck.setForeground(Color.red);
        dateInputCheck.setVisible(false);
        Image.add(dateInputCheck);

        timeInput.setSize(700, 70);
        timeInput.setLocation(100, 375);
        timeInput.setFont(new Font("Times New Roman", Font.BOLD, 25));
        Image.add(timeInput);

        timeInputText.setSize(200, 40);
        timeInputText.setLocation(500, 450);
        timeInputText.setFont(new Font("Times New Roman", Font.BOLD, 20));
        timeInputText.setHorizontalAlignment(JTextField.CENTER);
        timeInputText.setBackground(new Color(218,221,227));
        Image.add(timeInputText);

        timeInputCheck.setSize(300, 70);
        timeInputCheck.setLocation(750, 400);
        timeInputCheck.setFont(new Font("Times New Roman", Font.BOLD, 10));
        timeInputCheck.setForeground(Color.red);
        timeInputCheck.setVisible(false);
        Image.add(timeInputCheck);

        durationInput.setSize(500, 70);
        durationInput.setLocation(100, 525);
        durationInput.setFont(new Font("Times New Roman", Font.BOLD, 25));
        Image.add(durationInput);

        durationInputText.setSize(200, 40);
        durationInputText.setLocation(500, 600);
        durationInputText.setFont(new Font("Times New Roman", Font.BOLD, 20));
        durationInputText.setHorizontalAlignment(JTextField.CENTER);
        durationInputText.setBackground(new Color(218,221,227));
        Image.add(durationInputText);

        durationInputCheck.setSize(300, 70);
        durationInputCheck.setLocation(750, 525);
        durationInputCheck.setFont(new Font("Times New Roman", Font.BOLD, 10));
        durationInputCheck.setForeground(Color.red);
        durationInputCheck.setVisible(false);
        Image.add(durationInputCheck);


        backButton.setSize(80, 50);
        backButton.setLocation(100, 650);
        backButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
        Image.add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new GuiPage();
            }
        });

        resetButton.setSize(80, 50);
        resetButton.setLocation(600, 650);
        resetButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                licenceNumText.setText(null);
                dateInputText.setText(null);
                timeInputText.setText(null);
                durationInputText.setText(null);
                licenceNumCheck.setVisible(false);
                dateInputCheck.setVisible(false);
                timeInputCheck.setVisible(false);
                durationInputCheck.setVisible(false);
            }
        });
        Image.add(resetButton);

        checkButton.setSize(180, 50);
        checkButton.setLocation(700, 650);
        checkButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                medicalNumValidation();
                appointmentDateValidation();
                appointmentTimeValidation();
                appointmentDurationValidation();

                if (medicalNumValidation() && (appointmentDateValidation()) && (appointmentTimeValidation()) && (appointmentDurationValidation()) ) {
                    Doctor current_doctor = findCurrentDoctor();

                    boolean check_flag_currentDoctor = false;

                    for (Consultation consultation : manager.returnConsultationArrayList()) {
                        if ((current_doctor.getMedical_licence_number().equals(consultation.getDoctor().getMedical_licence_number())) && (timeInputText.getText().equals(consultation.getTime())) && (dateInputText.getText().equals(consultation.getDate()))){

                        check_flag_currentDoctor = true;
                        break;
                        }
                    }

                    if (check_flag_currentDoctor){
                        //current doctor booked
                        Random randomDr = new Random();
                        boolean nextDrCheck;
                        int docIndex;

                        while (true){
                            nextDrCheck=false;
                            docIndex=randomDr.nextInt(0,manager.returnDoctorArrayList().size());

                            if (!(current_doctor==manager.returnDoctorArrayList().get(docIndex))){ //to check other dr s availability
                                for (Consultation consultation:manager.returnConsultationArrayList()){
                                    if ( manager.returnDoctorArrayList().get(docIndex).getMedical_licence_number().equals(consultation.getDoctor().getMedical_licence_number())
                                            && (timeInputText.getText().equals(consultation.getTime())) && ((timeInputText.getText().equals(consultation.getDate())))){
                                        nextDrCheck=true;
                                        break;
                                    }
                                }
                            }
                            else {
                                nextDrCheck=true;
                            }

                            if (!nextDrCheck){
                                break;
                            }
                        }
                        finalDoctor=manager.returnDoctorArrayList().get(docIndex);
                        display1.setText("Dr."+current_doctor.getName()+" "+current_doctor.getSurname());
                        display1.setVisible(true);
                        display2.setText("is not available for your booking time.");
                        display2.setVisible(true);
                        display3.setText("Your allocated to"+" "+"Dr."+finalDoctor.getName()+" "+finalDoctor.getSurname()+".");
                        display3.setVisible(true);


                    }
                    else{
                        finalDoctor = current_doctor;
                        display1.setText("Dr."+finalDoctor.getName()+" "+finalDoctor.getSurname());
                        display1.setVisible(true);
                        display2.setText("is available for your booking time.");
                        display2.setVisible(true);
                        display3.setVisible(false);

                    }

                    panel.setVisible(false);
                    panel2.setVisible(true);
                }
            }
        });
        Image.add(checkButton);

        //availability part

        panel2.setSize(900, 800);
        panel2.setVisible(false);
        panel2.setLayout(null);
        frame.add(panel2);

        aImage.setSize(900,800);
        aImage.setLocation(0,0);
        panel2.add(aImage);

        bookTitle.setSize(800, 120);
        bookTitle.setLocation(300, 10);
        bookTitle.setFont(new Font("Times New Roman", Font.BOLD, 35));
        aImage.add(bookTitle);

        detailPanel.setSize(900, 300);
        detailPanel.setLocation(0,100);
        detailPanel.setVisible(true);
        detailPanel.setLayout(null);
        detailPanel.setBackground(Color.pink);
        aImage.add(detailPanel);

        display1.setSize(800, 120);
        display1.setLocation(200, 30);
        display1.setFont(new Font("Times New Roman", Font.BOLD, 25));
        display1.setVisible(false);
        detailPanel.add(display1);

        display2.setSize(800, 120);
        display2.setLocation(200, 100);
        display2.setFont(new Font("Times New Roman", Font.BOLD, 25));
        display2.setVisible(false);
        detailPanel.add(display2);

        display3.setSize(800, 120);
        display3.setLocation(200, 170);
        display3.setFont(new Font("Times New Roman", Font.BOLD, 25));
        display3.setVisible(false);
        detailPanel.add(display3);

        noteTitle.setSize(800, 120);
        noteTitle.setLocation(200, 450);
        noteTitle.setFont(new Font("Times New Roman", Font.BOLD, 30));
        aImage.add(noteTitle);

        note.setSize(400, 100);
        note.setLocation(350, 450);
        note.setFont(new Font("Times New Roman", Font.BOLD, 20));
        note.setHorizontalAlignment(JTextField.CENTER);
        note.setBackground(new Color(218,221,227));
        aImage.add(note);


        bButton.setSize(80, 50);
        bButton.setLocation(100, 650);
        bButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
        aImage.add(bButton);

        bButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel2.setVisible(false);
                panel.setVisible(true);
            }
        });

        bookButton.setSize(250, 50);
        bookButton.setLocation(600, 650);
        bookButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
        aImage.add(bookButton);
        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                panel2.setVisible(false);
                panel3.setVisible(true);
            }
        });

        //reg part
        panel3.setSize(900, 800);
        panel3.setVisible(false);
        panel3.setLayout(null);
        panel3.setBackground(Color.white);
        frame.add(panel3);

        rImage.setSize(900,800);
        rImage.setLocation(0,0);
        panel3.add(rImage);

        regTitle.setSize(800, 120);
        regTitle.setLocation(300, 10);
        regTitle.setFont(new Font("Times New Roman", Font.BOLD, 40));
        rImage.add(regTitle);

        fName.setSize(300, 70);
        fName.setLocation(500, 100);
        fName.setFont(new Font("Times New Roman", Font.BOLD, 25));
        rImage.add(fName);

        fNameText.setSize(200, 40);
        fNameText.setLocation(500, 150);
        fNameText.setFont(new Font("Times New Roman", Font.BOLD, 15));
        fNameText.setHorizontalAlignment(JTextField.CENTER);
        fNameText.setBackground(new Color(218,221,227));
        rImage.add(fNameText);

        fNamecheck.setSize(300, 70);
        fNamecheck.setLocation(800, 100);
        fNamecheck.setFont(new Font("Times New Roman", Font.BOLD, 10));
        fNamecheck.setForeground(Color.red);
        fNamecheck.setVisible(false);
        rImage.add(fNamecheck);

        sName.setSize(300, 70);
        sName.setLocation(500,200 );
        sName.setFont(new Font("Times New Roman", Font.BOLD, 25));
        rImage.add(sName);

        sNameText.setSize(200, 40);
        sNameText.setLocation(500, 250);
        sNameText.setFont(new Font("Times New Roman", Font.BOLD, 15));
        sNameText.setHorizontalAlignment(JTextField.CENTER);
        sNameText.setBackground(new Color(218,221,227));
        rImage.add(sNameText);

        sNamecheck.setSize(300, 70);
        sNamecheck.setLocation(800, 200);
        sNamecheck.setFont(new Font("Times New Roman", Font.BOLD, 10));
        sNamecheck.setForeground(Color.red);
        sNamecheck.setVisible(false);
        rImage.add(sNamecheck);

        bDay.setSize(300, 70);
        bDay.setLocation(500, 300);
        bDay.setFont(new Font("Times New Roman", Font.BOLD, 25));
        rImage.add(bDay);

        bDayText.setSize(200, 40);
        bDayText.setLocation(500, 350);
        bDayText.setFont(new Font("Times New Roman", Font.BOLD, 15));
        bDayText.setHorizontalAlignment(JTextField.CENTER);
        bDayText.setBackground(new Color(218,221,227));
        rImage.add(bDayText);

        bDaycheck.setSize(300, 70);
        bDaycheck.setLocation(800, 300);
        bDaycheck.setFont(new Font("Times New Roman", Font.BOLD, 10));
        bDaycheck.setForeground(Color.red);
        bDaycheck.setVisible(false);
        rImage.add(bDaycheck);

        mobileNumber.setSize(300, 70);
        mobileNumber.setLocation(500, 400);
        mobileNumber.setFont(new Font("Times New Roman", Font.BOLD, 25));
        rImage.add(mobileNumber);

        mobileNumberText.setSize(200, 40);
        mobileNumberText.setLocation(500, 450);
        mobileNumberText.setFont(new Font("Times New Roman", Font.BOLD, 15));
        mobileNumberText.setHorizontalAlignment(JTextField.CENTER);
        mobileNumberText.setBackground(new Color(218,221,227));
        rImage.add(mobileNumberText);

        mobileNumbercheck.setSize(300, 70);
        mobileNumbercheck.setLocation(800, 400);
        mobileNumbercheck.setFont(new Font("Times New Roman", Font.BOLD, 10));
        mobileNumbercheck.setForeground(Color.red);
        mobileNumbercheck.setVisible(false);
        rImage.add(mobileNumbercheck);

        idNum.setSize(300, 70);
        idNum.setLocation(500, 500);
        idNum.setFont(new Font("Times New Roman", Font.BOLD, 25));
        rImage.add(idNum);

        idNumText.setSize(200, 40);
        idNumText.setLocation(500, 550);
        idNumText.setFont(new Font("Times New Roman", Font.BOLD, 15));
        idNumText.setHorizontalAlignment(JTextField.CENTER);
        idNumText.setBackground(new Color(218,221,227));
        rImage.add(idNumText);

        idNumcheck.setSize(300, 70);
        idNumcheck.setLocation(800, 500);
        idNumcheck.setFont(new Font("Times New Roman", Font.BOLD, 10));
        idNumcheck.setForeground(Color.red);
        idNumcheck.setVisible(false);
        rImage.add(idNumcheck);

        buttonBack.setSize(80, 50);
        buttonBack.setLocation(100, 650);
        buttonBack.setFont(new Font("Times New Roman", Font.BOLD, 15));
        rImage.add(buttonBack);

        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel3.setVisible(false);
                panel2.setVisible(true);
            }
        });

        buttonReset.setSize(80, 50);
        buttonReset.setLocation(600, 650);
        buttonReset.setFont(new Font("Times New Roman", Font.BOLD, 15));
        buttonReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fNameText.setText(null);
                sNameText.setText(null);
                bDayText.setText(null);
                mobileNumberText.setText(null);
                idNumText.setText(null);
                fNamecheck.setVisible(false);
                sNamecheck.setVisible(false);
                bDaycheck.setVisible(false);
                mobileNumbercheck.setVisible(false);
                idNumcheck.setVisible(false);
            }
        });
        rImage.add(buttonReset);

        buttonConfirm.setSize(180, 50);
        buttonConfirm.setLocation(700, 650);
        buttonConfirm.setFont(new Font("Times New Roman", Font.BOLD, 15));
        buttonConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                regFnameValidation();
                regSnameValidation();
                regBirthdayValidation();
                regMobileNumbervalidation();
                regIdValidation();

                if ((regFnameValidation()) && (regSnameValidation())&&(regBirthdayValidation())&&(regMobileNumbervalidation())&&(regIdValidation())) {

                    Patient patient=new Patient(fNameText.getText(),sNameText.getText(),bDayText.getText(),mobileNumberText.getText(),idNumText.getText());

                    Consultation consultation=new Consultation(dateInputText.getText(),timeInputText.getText(),generateCost(),note.getText(),finalDoctor,patient,Integer.parseInt(durationInputText.getText()));
                    manager.returnConsultationArrayList().add(consultation);
                    try {
                        manager.saveInAFile("Consultation");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }

                    panel.setVisible(false);
                    frame.setVisible(false);

                    new GuiConfirmPage(consultation);

                }
            }
        });
        rImage.add(buttonConfirm);
    }
//find current doctor
    private Doctor findCurrentDoctor() {
        Doctor doc=null;

        for (Doctor doctor:manager.returnDoctorArrayList()){
            if (licenceNumText.getText().equals(doctor.getMedical_licence_number())){
                doc=doctor;
                break;
            }
        }
        return doc;
    }
//cost
    private int generateCost() {
        int hours = Integer.parseInt(durationInputText.getText());
        boolean check_flage=false;

        for(Consultation consultation : manager.returnConsultationArrayList()){
            if (idNumText.getText().equals(consultation.getPatient().getId())){
                check_flage=true;
                break;
            }
        }
        if (check_flage){
            return 25*hours; //old patient
        }
        else {
            return 15*hours; //new patient
        }
    }

    //booking page

    //Doctor MedicalLicence Number Validation-check the users input
    private boolean medicalNumValidation() {
        if ((licenceNumText.getText().length()==0)){
            licenceNumCheck.setVisible(true);
            licenceNumCheck.setText("*Required");
            return false;
        }
        else {
            boolean check_flag = false;
            for (Doctor doctor : manager.returnDoctorArrayList()) {
                if (doctor.getMedical_licence_number().equals(licenceNumText.getText())) {
                    check_flag = true;
                    break;
                }
            }
            if (check_flag) {
                licenceNumCheck.setVisible(false);
                return true;
            } else {
                licenceNumCheck.setVisible(true);
                licenceNumCheck.setText("*Can't find doctor");
                return false;
            }
        }
    }

    //appointment date validation
    private boolean appointmentDateValidation(){
        if ((dateInputText.getText().length()==0)){
            dateInputCheck.setVisible(true);
            dateInputCheck.setText("*Required");
            return false;
        }
        else {

            DateTimeFormatter formater= DateTimeFormatter.ofPattern("yyyy/MM/dd");

            try {
                formater.parse(dateInputText.getText());
                int user_year=Integer.parseInt(""+dateInputText.getText().charAt(0)+dateInputText.getText().charAt(1)+dateInputText.getText().charAt(2)+dateInputText.getText().charAt(3)); //convert string date of birth to integer date of birth.
                int current_year= Calendar.getInstance().get(Calendar.YEAR); //to get current year

                // checking the year range
                if (user_year>=current_year){
                    dateInputCheck.setVisible(false);
                    return true;
                }
                else {
                    dateInputCheck.setVisible(true);
                    dateInputCheck.setText("*Invalid date");
                    return false;
                }
            }
            catch (Exception e) {
                dateInputCheck.setVisible(true);
                dateInputCheck.setText("*Invalid date format");
                return false;
            }
        }

    }

    //Appointment time validation

    private boolean appointmentTimeValidation() {
        if ((timeInputText.getText().length() == 0)) {
            timeInputCheck.setVisible(true);
            timeInputCheck.setText("*Required");
            return false;
        }
        else {
            DateTimeFormatter formater= DateTimeFormatter.ofPattern("HH:mm");
            try {
                formater.parse(timeInputText.getText());
                int user_time=Integer.parseInt(""+timeInputText.getText().charAt(0)+timeInputText.getText().charAt(1)); //convert string time to integer time.

                 //checking the time range
                if ((user_time>=9) && (user_time<=22)){
                    timeInputCheck.setVisible(false);
                    return true;
                }
                else {
                    timeInputCheck.setVisible(true);
                    timeInputCheck.setText("*Invalid time");
                    return false;
                }
            }
            catch (Exception e) {
                timeInputCheck.setVisible(true);
                timeInputCheck.setText("*Invalid time format");
                return false;
            }
        }
    }

    //time duration validation
    private boolean appointmentDurationValidation() {
        if ((durationInputText.getText().length() == 0)) {
            durationInputCheck.setVisible(true);
            durationInputCheck.setText("*Required");
            return false;
        }
        else {
            try {
                Integer.parseInt(durationInputText.getText());//convert string time to integer time.
                durationInputCheck.setVisible(false);
                return true;


            } catch (Exception e) {
                durationInputCheck.setVisible(true);
                durationInputCheck.setText("*Invalid input");
                return false;

            }
        }

    }

    //register page

    //first name validation
    private boolean regFnameValidation() {
        if ((fNameText.getText().length() == 0)) {
            fNamecheck.setVisible(true);
            fNamecheck.setText("*Required");
            return false;
        }
        else {
            fNamecheck.setVisible(false);
            return true;
        }

    }
    //surname validation
    private boolean regSnameValidation() {
        if ((sNameText.getText().length() == 0)) {
            sNamecheck.setVisible(true);
            sNamecheck.setText("*Required");
            return false;
        }
        else {
            sNamecheck.setVisible(false);
            return true;
        }

    }

    //birthday validation
    private boolean regBirthdayValidation(){
        if ((bDayText.getText().length()==0)){
            bDaycheck.setVisible(true);
            bDaycheck.setText("*Required");
            return false;
        }
        else {
            DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            try {
                formater.parse(bDayText.getText());
                int born_year = Integer.parseInt("" + bDayText.getText().charAt(0) + bDayText.getText().charAt(1) + bDayText.getText().charAt(2) + bDayText.getText().charAt(3)); //convert string date of birth to integer date of birth.
                int current_year = Calendar.getInstance().get(Calendar.YEAR); //to get current year

                // checking the year range
                if (born_year <= current_year) {
                    bDaycheck.setVisible(false);
                    return true;
                } else {
                    bDaycheck.setVisible(true);
                    bDaycheck.setText("*Invalid format");
                    return false;
                }
            } catch (Exception e) {
                bDaycheck.setVisible(true);
                bDaycheck.setText("*Invalid format");
                return false;
            }
        }
    }
    //mobile number validation
    private boolean regMobileNumbervalidation() {
        if ((mobileNumberText.getText().length()==0)){
            mobileNumbercheck.setVisible(true);
            mobileNumbercheck.setText("*Required");
            return false;
        }
        else {
            try {
                Integer.parseInt(mobileNumberText.getText());
                if (mobileNumberText.getText().length()==10){
                    mobileNumbercheck.setVisible(false);
                    return true;
                }
                else {
                    mobileNumbercheck.setVisible(true);
                    mobileNumbercheck.setText("*Invalid number");
                    return false;
                }
            }
            catch (Exception e){
                mobileNumbercheck.setVisible(true);
                mobileNumbercheck.setText("*Invalid format");
                return false;

            }
        }
    }


    //id number validation

    private boolean regIdValidation() {
        if ((idNumText.getText().length() == 0)) {
            idNumcheck.setVisible(true);
            idNumcheck.setText("*Required");
            return false;
        }
        else {
            try {
                Integer.parseInt(idNumText.getText());//convert string to integer .
                 idNumcheck.setVisible(false);
                return true;


            } catch (Exception e) {
                idNumcheck.setVisible(true);
                idNumcheck.setText("*Invalid input");
                return false;

            }
        }

    }

}
