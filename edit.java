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
public class edit extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	Connection editConnec;

	/**
	 * Launch the application.
	 */
	public static void Editmain(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					edit frame = new edit();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public void getConnec(Connection c)
	{
		editConnec = c;
	}
	public edit() {
		setTitle("Edit Info");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("I.D");
		lblNewLabel.setBounds(69, 35, 61, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setBounds(69, 63, 74, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Last Name");
		lblNewLabel_2.setBounds(69, 91, 74, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Email");
		lblNewLabel_3.setBounds(69, 119, 61, 16);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(208, 29, 134, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(208, 57, 134, 28);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(208, 85, 134, 28);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(208, 113, 134, 28);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("Edit");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String id = textField.getText();
				String fn = textField_1.getText();
				String ln = textField_2.getText();
				String em = textField_3.getText();
				String query = "update employees set firstname = ? , lastname = ? , email = ? where id = ?";
				PreparedStatement mystate;
				try {
					mystate = editConnec.prepareStatement(query);
					mystate.setString(1, fn);
					mystate.setString(2, ln);
					mystate.setString(3, em);
					mystate.setString(4, id);
					mystate.executeUpdate();
					mystate.close();
					JOptionPane.showMessageDialog(null,"Entry Edited");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(66, 147, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				AppUI window = new AppUI();
				window.frmFrontPage.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(218, 147, 117, 29);
		contentPane.add(btnNewButton_1);
	}
}
