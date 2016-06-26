package addressBook;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AppUI {

	public JFrame frmFrontPage;
	public Connection conec;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppUI window = new AppUI();
					window.frmFrontPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public AppUI() {
		initialize();
		setupConnection();
	}
	public void setupConnection()
	{
		try {
			conec = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydata", "root", "kunal1182");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFrontPage = new JFrame();
		frmFrontPage.setTitle("Front Page");
		frmFrontPage.setBounds(100, 100, 452, 301);
		frmFrontPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFrontPage.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("SEARCH");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmFrontPage.dispose();
				search Sobj = new search();
				Sobj.setVisible(true);
				Sobj.getConnec(conec);
			}
		});
		btnNewButton.setBounds(169, 28, 117, 29);
		frmFrontPage.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ADD");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmFrontPage.dispose();
				Add addobj = new Add();
				addobj.setVisible(true);
				Add.getConec(conec);
			}
		});
		btnNewButton_1.setBounds(169, 85, 117, 29);
		frmFrontPage.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("EDIT");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmFrontPage.dispose();
				edit edtobj = new edit();
				edtobj.setVisible(true);
				edtobj.getConnec(conec);
			}
		});
		btnNewButton_2.setBounds(169, 56, 117, 29);
		frmFrontPage.getContentPane().add(btnNewButton_2);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmFrontPage.dispose();
				Delete Delobj = new Delete();
				Delobj.setVisible(true);
				Delobj.getConnec(conec);
			}
		});
		btnDelete.setBounds(169, 114, 117, 29);
		frmFrontPage.getContentPane().add(btnDelete);
	}
}
