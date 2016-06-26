package addressBook;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	static Connection DelConec;
	static PreparedStatement mystate;
	/**
	 * Launch the application.
	 */
	public static void Deletemain(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete frame = new Delete();
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
		DelConec = c;
	}
	public Delete() {
		setTitle("Delete on Id");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 301);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter ID");
		lblNewLabel.setBounds(67, 86, 61, 16);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(166, 80, 134, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query = "Delete from employees where id = ?";
				String id = textField.getText();
				//System.out.println
				try {
					PreparedStatement myState = DelConec.prepareStatement(query);
					//myState.setString(1, id);
					myState.setString(1,id);
					myState.executeUpdate();
					myState.close();
					JOptionPane.showMessageDialog(null,"Entry Deleted");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(67, 142, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				AppUI window = new AppUI();
				window.frmFrontPage.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(180, 142, 117, 29);
		contentPane.add(btnNewButton_1);
		
	}
}
