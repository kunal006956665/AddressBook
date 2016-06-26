package addressBook;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;

import net.proteanit.sql.DbUtils;

import addressBook.AppUI;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class search extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	Connection Sconec;
	static ResultSet rs;
	private JButton BACK;
	/**
	 * Launch the application.
	 */
	public static void Searchmain(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					search frame = new search();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void getConnec(Connection c)
	{
		Sconec = c;
	}
	/**
	 * Create the frame.
	 */
	public search() {
		setTitle("Search By ID");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(21, 76, 407, 196);
		contentPane.add(table);
		
		textField = new JTextField();
		textField.setBounds(21, 34, 134, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textField.getText();
				String query = "select * from employees where id = ?";
				try {
					PreparedStatement mystate = Sconec.prepareStatement(query);
					mystate.setString(1, id);
					rs = mystate.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (SQLException e1) {
					
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSearch.setBounds(182, 35, 117, 29);
		contentPane.add(btnSearch);
		
		BACK = new JButton("BACK");
		BACK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				AppUI window = new AppUI();
				window.frmFrontPage.setVisible(true);
			}
		});
		BACK.setBounds(311, 35, 117, 29);
		contentPane.add(BACK);
	}
}
