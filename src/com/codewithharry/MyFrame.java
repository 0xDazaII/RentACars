package com.codewithharry;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyFrame extends JFrame {
    Connection conn = null;
    PreparedStatement state = null;
    ResultSet result = null;
    int id = -1;

    JTabbedPane tab = new JTabbedPane();

    JPanel personPanel = new JPanel();
    JPanel carPanel = new JPanel();
    JPanel rentPanel = new JPanel();
    JPanel spravka1Panel = new JPanel();
    JPanel spravka2Panel = new JPanel();

    //Person
    JTable personTable = new JTable();
    JScrollPane personScroll = new JScrollPane(personTable);

    JPanel personTopPanel = new JPanel();
    JPanel personMidPanel = new JPanel();
    JPanel personBottomPanel = new JPanel();

    JLabel namePersonL = new JLabel("Име и Фамилия: ");
    JLabel phoneNumberPersonL = new JLabel("Телефон: ");
    JLabel egnPersonL = new JLabel("ЕГН: ");

    JTextField namePersonF = new JTextField();
    JTextField phoneNumberF = new JTextField();
    JTextField egnF = new JTextField();

    JButton personAdd = new JButton("Добави");
    JButton personDelete = new JButton("Изтрий");
    JButton personEdit = new JButton("Промени");
    JButton personSearch = new JButton("Търси по ЕГН");

    // Car
    JTable carTable = new JTable();
    JScrollPane carScroll = new JScrollPane(carTable);


    JPanel carTopPanel = new JPanel();
    JPanel carMidPanel = new JPanel();
    JPanel carBottomPanel = new JPanel();

    JLabel markaCarL = new JLabel("Марка: ");
    JLabel nomerCarL = new JLabel("Регистрационен номер: ");
    JLabel yearCarL = new JLabel("Година на производство: ");

    JTextField markaCarF = new JTextField();
    JTextField nomerCarF = new JTextField();
    JTextField yearCarF = new JTextField();

    JButton carAdd = new JButton("Добави");
    JButton carDelete = new JButton("Изтрий");
    JButton carEdit = new JButton("Промени");
    JButton carSearch = new JButton("Търси по марка");

    //RentACar
    JTable rentTable = new JTable();
    JScrollPane rentScroll = new JScrollPane(rentTable);


    JPanel rentTopPanel = new JPanel();
    JPanel rentMidPanel = new JPanel();
    JPanel rentBottomPanel = new JPanel();

    JLabel personRentL = new JLabel("Клиент: ");
    JLabel carRentL = new JLabel("Марка: ");
    JLabel dateRentL = new JLabel("Дата: ");
    JLabel priceRentL = new JLabel("Цена: ");

    JComboBox <String> comboPerson = new JComboBox<String>();
    JComboBox <String> comboCar = new JComboBox<String>();

    JTextField dateRentF = new JTextField();
    JTextField priceRentF = new JTextField();

    JButton rentAdd = new JButton("Добави");
    JButton rentDelete = new JButton("Изтрий");
    JButton rentEdit = new JButton("Промени");
    JButton rentSearch = new JButton("Търси по цена");

    //spravka1
    JTable spravka1Table = new JTable();
    JScrollPane spravka1Scroll = new JScrollPane(spravka1Table);

    JPanel spravka1TopPanel = new JPanel();
    JPanel spravka1MidPanel = new JPanel();
    JPanel spravka1BottomPanel = new JPanel();

    JLabel criteria1Spravka1L = new JLabel("Първа критерия: ");
    JLabel criteria2Spravka1L = new JLabel("Втора критерия: ");

    JTextField criteria1Spravka1F = new JTextField();
    JTextField criteria2Spravka1F = new JTextField();

    JButton showSpravka1 = new JButton("Покажи");


    //spravka2
    JTable spravka2Table = new JTable();
    JScrollPane spravka2Scroll = new JScrollPane(spravka2Table);

    JPanel spravka2TopPanel = new JPanel();
    JPanel spravka2MidPanel = new JPanel();
    JPanel spravka2BottomPanel = new JPanel();

    JLabel criteria1Spravka2L = new JLabel("Първа критерия: ");
    JLabel criteria2Spravka2L = new JLabel("Втора критерия: ");

    JTextField criteria1Spravka2F = new JTextField();
    JTextField criteria2Spravka2F = new JTextField();

    JButton showSpravka2 = new JButton("Покажи");


    public MyFrame() {
        this.setSize(500,500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        tab.add(personPanel, "Клиенти");
        tab.add(carPanel, "Коли");
        tab.add(rentPanel, "Наем");
        tab.add(spravka1Panel, "Спраква по ...1");
        tab.add(spravka2Panel, "Справка по ...2");

        this.add(tab);

        //Person
        personPanel.setLayout(new GridLayout(3,1));

        personTopPanel.setLayout(new GridLayout(3,2));
        personTopPanel.add(namePersonL);
        personTopPanel.add(namePersonF);

        personTopPanel.add(phoneNumberPersonL);
        personTopPanel.add(phoneNumberF);

        personTopPanel.add(egnPersonL);
        personTopPanel.add(egnF);

        personMidPanel.add(personAdd);
        personMidPanel.add(personDelete);
        personMidPanel.add(personEdit);
        personMidPanel.add(personSearch);

        personScroll.setPreferredSize(new Dimension(450, 130 ));
        personBottomPanel.add(personScroll);


        personPanel.add(personTopPanel);
        personPanel.add(personMidPanel);
        personPanel.add(personBottomPanel);

        personTable.addMouseListener(new ClickActionPerson());
        personAdd.addActionListener(new AddActionPerson());
        personDelete.addActionListener(new DeleteActionPerson());
        personEdit.addActionListener(new UpdateActionPerson());

        refreshTable("", personTable);

        //Car
        carPanel.setLayout(new GridLayout(3,1));

        carTopPanel.setLayout(new GridLayout(3,2));
        carTopPanel.add(markaCarL);
        carTopPanel.add(markaCarF);

        carTopPanel.add(nomerCarL);
        carTopPanel.add(nomerCarF);

        carTopPanel.add(yearCarL);
        carTopPanel.add(yearCarF);

        carMidPanel.add(carAdd);
        carMidPanel.add(carDelete);
        carMidPanel.add(carEdit);
        carMidPanel.add(carSearch);

        carScroll.setPreferredSize(new Dimension(450, 130 ));
        carBottomPanel.add(carScroll);

        carPanel.add(carTopPanel);
        carPanel.add(carMidPanel);
        carPanel.add(carBottomPanel);

        //RentACar
        rentPanel.setLayout(new GridLayout(3,1));
        rentTopPanel.setLayout(new GridLayout(4,2));

        rentTopPanel.add(personRentL);
        rentTopPanel.add(comboPerson);

        rentTopPanel.add(carRentL);
        rentTopPanel.add(comboCar);

        rentTopPanel.add(dateRentL);
        rentTopPanel.add(dateRentF);

        rentTopPanel.add(priceRentL);
        rentTopPanel.add(priceRentF);

        rentMidPanel.add(rentAdd);
        rentMidPanel.add(rentDelete);
        rentMidPanel.add(rentEdit);
        rentMidPanel.add(rentSearch);

        rentScroll.setPreferredSize(new Dimension(450, 130 ));
        rentBottomPanel.add(rentScroll);

        rentPanel.add(rentTopPanel);
        rentPanel.add(rentMidPanel);
        rentPanel.add(rentBottomPanel);

        //Spravka 1
        spravka1Panel.setLayout(new GridLayout(3,1));
        spravka1TopPanel.setLayout(new GridLayout(2,2));

        spravka1TopPanel.add(criteria1Spravka1L);
        spravka1TopPanel.add(criteria1Spravka1F);

        spravka1TopPanel.add(criteria2Spravka1L);
        spravka1TopPanel.add(criteria2Spravka1F);

        spravka1MidPanel.add(showSpravka1);

        spravka1Scroll.setPreferredSize(new Dimension(450, 130 ));
        spravka1BottomPanel.add(spravka1Scroll);

        spravka1Panel.add(spravka1TopPanel);
        spravka1Panel.add(spravka1MidPanel);
        spravka1Panel.add(spravka1BottomPanel);

        //Spravka 2
        spravka2Panel.setLayout(new GridLayout(3,1));
        spravka2TopPanel.setLayout(new GridLayout(2,2));

        spravka2TopPanel.add(criteria1Spravka2L);
        spravka2TopPanel.add(criteria1Spravka2F);

        spravka2TopPanel.add(criteria2Spravka2L);
        spravka2TopPanel.add(criteria2Spravka2F);

        spravka2MidPanel.add(showSpravka2);

        spravka2Scroll.setPreferredSize(new Dimension(450, 130 ));
        spravka2BottomPanel.add(spravka2Scroll);

        spravka2Panel.add(spravka2TopPanel);
        spravka2Panel.add(spravka2MidPanel);
        spravka2Panel.add(spravka2BottomPanel);

        this.setVisible(true);
    }//end constructor

    public void refreshTable(String name , JTable table) {
        conn = DBconnection.getConnection();
        String str = "select * from " + name;

        try {
            state = conn.prepareStatement(str);
            result = state.executeQuery();
            table.setModel(new MyModel(result));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    class AddActionPerson implements ActionListener{


        @Override
        public void actionPerformed(ActionEvent e) {
            conn = DBconnection.getConnection();
            String sql = "Insert into person values(null, ? , ? , ? )";
            try {
                state = conn.prepareStatement(sql);
                state.setString(1 , namePersonF.getText());
                state.setString(2 , phoneNumberF.getText());
                state.setString(3 , egnF.getText());
                state.execute();
                refreshTable("", personTable);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            namePersonF.setText("");
            phoneNumberF.setText("");
            egnF.setText("");
        }
    }

     class DeleteActionPerson implements ActionListener{

         @Override
         public void actionPerformed(ActionEvent e) {
             conn = DBconnection.getConnection();
             String sql = "delete from person where ID = ?";

             try {
                 state = conn.prepareStatement(sql);
                 state.setInt(1, id);
                 state.execute();
                 refreshTable("person", personTable);
                 id = -1;

             } catch (SQLException ex) {
                 ex.printStackTrace();
             }

             namePersonF.setText("");
             phoneNumberF.setText("");
             egnF.setText("");

         }
     }

     class UpdateActionPerson implements ActionListener{

         @Override
         public void actionPerformed(ActionEvent e) {
             conn = DBconnection.getConnection();
             String sql = "update person set  name =?, phone =?, egn =? where id=?";

             try {
                 state = conn.prepareStatement(sql);
                 state.setString(1 , namePersonF.getText());
                 state.setString(2 , phoneNumberF.getText());
                 state.setString(3 , egnF.getText());
                 state.setInt(4, id);
                 state.execute();
                 refreshTable("person", personTable);
                 id = -1;
             } catch (SQLException ex) {
                 ex.printStackTrace();
             }

             namePersonF.setText("");
             phoneNumberF.setText("");
             egnF.setText("");

         }
     }

     class ClickActionPerson implements MouseListener{

         @Override
         public void mouseClicked(MouseEvent e) {
             int row = personTable.getSelectedRow();
             id = Integer.parseInt(personTable.getValueAt(row, 0).toString());

             namePersonF.setText("personTable.getValueAt(row, 1).toString()");
             phoneNumberF.setText("personTable.getValueAt(row, 2).toString()");
             egnF.setText("personTable.getValueAt(row, 3).toString()");

         }

         @Override
         public void mousePressed(MouseEvent e) {

         }

         @Override
         public void mouseReleased(MouseEvent e) {

         }

         @Override
         public void mouseEntered(MouseEvent e) {

         }

         @Override
         public void mouseExited(MouseEvent e) {

         }
     }

}// end MyFrame
