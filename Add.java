package addressBook;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Add extends JFrame  {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	static Connection addConec;
	static PreparedStatement mystate;
	private JButton btnNewButton;
	/**
	 * Launch the application.
	 */
	public static void Addmain(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add frame = new Add();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static void getConec(Connection c)
	{
		addConec = c;
	}
	/**
	 * Create the frame.
	 */
	public Add() {
		setTitle("ADD Entry");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 301);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(93, 25, 61, 16);
		contentPane.add(lblId);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(93, 53, 77, 16);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(93, 81, 77, 16);
		contentPane.add(lblLastName);
		
		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setBounds(93, 110, 61, 16);
		contentPane.add(lblEmail);
		
		textField = new JTextField();
		textField.setBounds(223, 19, 134, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(223, 47, 134, 28);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(223, 75, 134, 28);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(223, 104, 134, 28);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textField.getText();
				String fn = textField_1.getText();
				String ln = textField_2.getText();
				String em = textField_3.getText();
				String query = "insert into employees values(?,?,?,?)";
				//System.out.println("id = "+id+" fn = "+fn+" ln = "+" em = "+em);
				try {
					mystate = addConec.prepareStatement(query);
					//System.out.println("here");
					mystate.setString(1, id);
					mystate.setString(2, fn);
					mystate.setString(3, ln);
					mystate.setString(4, em);
					mystate.executeUpdate();
					mystate.close();
					JOptionPane.showMessageDialog(null,"Entry Added");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,"Entry NOT Added");
					e1.printStackTrace();
				}
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
			}
		});
		btnAdd.setBounds(93, 148, 117, 29);
		contentPane.add(btnAdd);
		
		btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				AppUI window = new AppUI();
				window.frmFrontPage.setVisible(true);
			}
		});
		btnNewButton.setBounds(240, 148, 117, 29);
		contentPane.add(btnNewButton);
	}
}
