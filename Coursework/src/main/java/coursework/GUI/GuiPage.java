package coursework.GUI;

import coursework.Doctor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;

import static coursework.ConsoleApplication.manager;


public class GuiPage extends JFrame {
    JFrame frame =new JFrame();
    JLabel mainTitle=new JLabel("List Of Doctors");
    JLabel tableTitle1=new JLabel("Doctor name");
    JLabel tableTitle2=new JLabel("Medical Lisence number");
    JLabel tableTitle3=new JLabel("Specialisation");

    ImageIcon docimage=new ImageIcon("images/docimage.png");
    JLabel Image=new JLabel(docimage);
    JButton backButton=new JButton("Back");
    JButton bookButton=new JButton("Book");
    JButton viewButton=new JButton("View");
    JButton sortButton=new JButton("Sort");
    JTable j;

    public GuiPage() {

        frame.setTitle("Westminster Skin Consultation Manager");
        frame.setSize(900, 800);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mainTitle.setSize(800, 120);
        mainTitle.setLocation(100, 30);
        mainTitle.setFont(new Font("Times New Roman", Font.BOLD, 40));
        Image.add(mainTitle);

        tableTitle1.setSize(800, 120);
        tableTitle1.setLocation(100, 120);
        tableTitle1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        Image.add(tableTitle1);

        tableTitle2.setSize(800, 120);
        tableTitle2.setLocation(350, 120);
        tableTitle2.setFont(new Font("Times New Roman", Font.BOLD, 20));
        Image.add(tableTitle2);

        tableTitle3.setSize(800, 120);
        tableTitle3.setLocation(650, 120);
        tableTitle3.setFont(new Font("Times New Roman", Font.BOLD, 20));
        Image.add(tableTitle3);

        Image.setSize(900,800);
        Image.setLocation(0,0);
        frame.add(Image);

        createTable(manager.returnDoctorArrayList());

        backButton.setSize(80, 50);
        backButton.setLocation(100, 650);
        backButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
        Image.add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new GuiFrontPage();
            }
        });

        bookButton.setSize(80, 50);
        bookButton.setLocation(600, 650);
        bookButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
        Image.add(bookButton);

        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new GuiBookPage();
            }
        });

        viewButton.setSize(80, 50);
        viewButton.setLocation(700, 650);
        viewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
        Image.add(viewButton);
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new GuiViewPage();
            }
        });

        sortButton.setSize(90, 35);
        sortButton.setLocation(100, 550);
        sortButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Doctor> temp_array= (ArrayList<Doctor>) manager.returnDoctorArrayList().clone();
                temp_array.sort(Comparator.comparing(Doctor::getName));
                j.setVisible(false);
                createTable(temp_array);
            }
        });

        j.setVisible(false);
        createTable(manager.returnDoctorArrayList());
        Image.add(sortButton);

    }

    private void createTable(ArrayList<Doctor> arrayList) {
        //table
        // Data to be displayed in the JTable
        String[][] data = new String[arrayList.size()][3];

        for (int x=0;x<arrayList.size();x++){
            data[x][0]="Dr."+arrayList.get(x).getName()+" "+arrayList.get(x).getSurname();
            data[x][1]=arrayList.get(x).getMedical_licence_number();
            data[x][2]=arrayList.get(x).getSpecialisation();

        }

        // Column Names
        String[] columnNames = { "Doctor name", "Doctor medical number", "Doctor type" };

        // Initializing the JTable
        j = new JTable(data, columnNames);
        j.setBounds(50, 200, 800, 330);
        j.setRowHeight(30);
        j.setFont(new Font("Times New Roman", Font.BOLD, 17));
        Image.add(j);
    }

}
