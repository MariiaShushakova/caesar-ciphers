package com.javarush.ui;

import com.javarush.Caesar;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {
    JButton btnEncrypt;
    JButton btnDecrypt;
    JButton btnCopy;
    JLabel labelEncrypt;
    JLabel labelDecrypt;
    JLabel labelKey1;
    JLabel labelKey2;
    JLabel labelResult;
    JLabel textResult;
    JTextField textFieldEncrypt;
    JTextField textFieldDecrypt;
    JTextField key1;
    JTextField key2;

    Font myFont18 = new Font("Consolas", Font.PLAIN, 18);
    Font myFont14 = new Font("Consolas", Font.PLAIN, 14);
    Font myFont20 = new Font("Consolas", Font.BOLD, 20);

    String result = "";

    MyFrame(){

        this.setTitle("Caesar-Cipher");
        this.setDefaultCloseOperation(MyFrame.EXIT_ON_CLOSE);
        this.setSize(680,400);
        this.setLayout(null);
        this.setResizable(false); //don't resize my poor UI :)

        ImageIcon image = new ImageIcon("resources/logo.jpg");
        this.setIconImage(image.getImage());

        labelEncrypt = new JLabel("Type text for encrypting: ");
        labelEncrypt.setFont(myFont14);
        labelEncrypt.setBounds(20, 10, 200, 150);
        labelEncrypt.setHorizontalAlignment(JLabel.LEFT);
        labelEncrypt.setVerticalAlignment(JLabel.TOP);
        labelEncrypt.setForeground(Color.BLACK);

        labelKey1 = new JLabel("Key: ");
        labelKey1.setFont(myFont14);
        labelKey1.setBounds(420, 10,70, 45);
        labelKey1.setHorizontalAlignment(JLabel.LEFT);
        labelKey1.setVerticalAlignment(JLabel.TOP);
        labelKey1.setForeground(Color.BLACK);

        textFieldEncrypt = new JTextField();
        textFieldEncrypt.setBounds(15, 30,400, 45);
        textFieldEncrypt.setFont(myFont18);

        key1 = new JTextField();
        key1.setBounds(420, 30,50, 45);
        key1.setFont(myFont18);

        btnEncrypt = new JButton("Encrypt");
        btnEncrypt.addActionListener(this);
        btnEncrypt.setFont(myFont14);
        btnEncrypt.setFocusable(false);
        btnEncrypt.setBounds(480, 32, 130, 40);

        labelDecrypt = new JLabel("Type text for decrypting: ");
        labelDecrypt.setFont(myFont14);
        labelDecrypt.setBounds(20, 100, 200, 150);
        labelDecrypt.setHorizontalAlignment(JLabel.LEFT);
        labelDecrypt.setVerticalAlignment(JLabel.TOP);
        labelDecrypt.setForeground(Color.BLACK);

        labelKey2 = new JLabel("Key: ");
        labelKey2.setFont(myFont14);
        labelKey2.setBounds(420, 100,70, 45);
        labelKey2.setHorizontalAlignment(JLabel.LEFT);
        labelKey2.setVerticalAlignment(JLabel.TOP);
        labelKey2.setForeground(Color.BLACK);

        key2 = new JTextField();
        key2.setBounds(420, 130,50, 45);
        key2.setFont(myFont18);

        textFieldDecrypt = new JTextField();
        textFieldDecrypt.setBounds(15, 130,400, 45);
        textFieldDecrypt.setFont(myFont18);

        btnDecrypt = new JButton("Decrypt");
        btnDecrypt.addActionListener(this);
        btnDecrypt.setFont(myFont14);
        btnDecrypt.setFocusable(false);
        btnDecrypt.setBounds(480, 132, 130, 40);

        labelResult = new JLabel("Result:");
        labelResult.setFont(myFont20);
        labelResult.setBounds(20, 200, 90, 50);
        labelResult.setHorizontalAlignment(JLabel.LEFT);
        labelResult.setVerticalAlignment(JLabel.TOP);
        labelResult.setForeground(Color.BLACK.brighter());

        textResult = new JLabel();
        textResult.setFont(myFont18);
        textResult.setBounds(20, 230, 600, 200);
        textResult.setHorizontalAlignment(JLabel.LEFT);
        textResult.setVerticalAlignment(JLabel.TOP);
        textResult.setForeground(Color.BLACK.brighter());

        btnCopy = new JButton("Copy result");
        btnCopy.setFont(myFont14);
        btnCopy.setBounds(480, 300, 130, 40);
        btnCopy.setFocusable(false);
        btnCopy.addActionListener(this);
        btnCopy.setEnabled(false);


        this.add(textFieldEncrypt);
        this.add(textFieldDecrypt);
        this.add(labelEncrypt);
        this.add(labelDecrypt);
        this.add(btnEncrypt);
        this.add(btnDecrypt);
        this.add(key1);
        this.add(key2);
        this.add(labelKey1);
        this.add(labelKey2);
        this.add(labelResult);
        this.add(btnCopy);
        this.add(textResult);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnEncrypt){
            result = Caesar.encrypt(textFieldEncrypt.getText(), Integer.parseInt(key1.getText()));
            textResult.setText(result);
            textResult.setVisible(true);
            btnCopy.setEnabled(true);

        }

        if(e.getSource() == btnDecrypt){
            result = Caesar.decrypt(textFieldDecrypt.getText(), Integer.parseInt(key2.getText()));
            textResult.setText(result);
            textResult.setVisible(true);
            btnCopy.setEnabled(true);
        }

        if(e.getSource() == btnCopy) {
            String str = textResult.getText();
            Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
            StringSelection strse1 = new StringSelection(str);
            clip.setContents(strse1, strse1);
            JOptionPane.showMessageDialog(null, "Text are copied!");
        }

    }
}
