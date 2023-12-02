package View;

import java.awt.DisplayMode;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Controller.Controller;
import Model.Student;
import Model.StudentManager;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class View extends JFrame {

	int current = 0;

	private JPanel panel_1;
	private JPanel panel_2;

	private JLabel lblID;
	private JLabel lblName;
	private JLabel lblAge;
	private JLabel lblGender;
	public JRadioButton rdbMale;
	public JRadioButton rdbFemale;
	public JTextField txtID;
	public JTextField txtName;
	public JTextField txtAge;
	public JButton btnAdd;
	public JButton btnUpdate;
	public JButton btnSave;
	public JButton btnDelete;
	ButtonGroup G;
	public JTable table;
	private JScrollPane scrollPane;
	DefaultTableModel model;
	public JTextField txtEmail;
	private JLabel lblPhoneNumber;
	public JTextField txtPhoneNumber;
	ArrayList<Student> list;

	private void tableMouseClicked(java.awt.event.MouseEvent evt) {
		current = table.getSelectedRow();
		Display(current);
	}

	Connection conn = null;
	String url = "\"jdbc:sqlserver://DESKTOP-K7HVB4T:1433;databaseName=STUDENT";
	String name = "sa";
	String pass = "18112005";

	public View() {
		this.list = new ArrayList<>();
		this.init();
		this.setVisible(true);
	}

	public void init() {
		this.setTitle("List Student");
		this.setDefaultCloseOperation(View.EXIT_ON_CLOSE);
		this.setSize(750, 370);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		panel_1 = new JPanel();
		panel_1.setBounds(10, 10, 300, 310);
		panel_1.setLayout(null);
		panel_1.setBorder(
				new TitledBorder(null, "Student Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		panel_2 = new JPanel();
		panel_2.setBounds(320, 10, 400, 310);
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(null, "List Student", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panel_1);
		getContentPane().add(panel_2);

		lblID = new JLabel("Mã sinh viên : ");
		lblID.setBounds(10, 22, 100, 30);
		lblID.setFont(new Font("Times New Roman", Font.BOLD, 12));

		lblName = new JLabel("Tên : ");
		lblName.setBounds(10, 60, 100, 30);
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 12));

		lblAge = new JLabel("Tuổi : ");
		lblAge.setBounds(10, 101, 100, 30);
		lblAge.setFont(new Font("Times New Roman", Font.BOLD, 12));

		lblGender = new JLabel("Giới tính : ");
		lblGender.setBounds(10, 205, 100, 30);
		lblGender.setFont(new Font("Times New Roman", Font.BOLD, 12));

		rdbMale = new JRadioButton("Male");
		rdbMale.setBounds(83, 208, 80, 25);
		rdbMale.setFont(new Font("Times New Roman", Font.BOLD, 12));

		rdbFemale = new JRadioButton("Female");
		rdbFemale.setBounds(180, 208, 80, 25);
		rdbFemale.setFont(new Font("Times New Roman", Font.BOLD, 12));

		G = new ButtonGroup();
		G.add(rdbMale);
		G.add(rdbFemale);

		txtID = new JTextField();
		txtID.setBounds(100, 25, 160, 25);
		txtID.setFont(new Font("Times New Roman", Font.BOLD, 12));

		txtName = new JTextField();
		txtName.setBounds(100, 63, 160, 25);
		txtName.setFont(new Font("Times New Roman", Font.BOLD, 12));

		txtAge = new JTextField();
		txtAge.setBounds(100, 104, 160, 25);
		txtAge.setFont(new Font("Times New Roman", Font.BOLD, 12));

		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		btnAdd.setBounds(10, 240, 90, 30);
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 12));

		btnUpdate = new JButton("Update");

		btnUpdate.setBounds(170, 240, 90, 30);
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 12));

		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (txtID.equals("")) {
					JOptionPane.showMessageDialog(null, "Please fill student id");
					txtID.requestFocus();
				}
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					conn = DriverManager.getConnection(url, name, pass);
					String sql = "DELETE FROM SINHVIEN WHERE masv = ?";
					PreparedStatement stm = conn.prepareStatement(sql);
					stm.setString(1, txtID.getText());
					stm.executeUpdate();
					JOptionPane.showMessageDialog(null, "Delete Successfully!");
					conn.close();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error");
				}
				LoadDataToArrayList();
				LoadToArrayToTable();
			}
		});
		btnDelete.setBounds(170, 269, 90, 30);
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 12));

		btnSave = new JButton("Save");

		btnSave.setBounds(10, 269, 90, 30);
		btnSave.setFont(new Font("Times New Roman", Font.BOLD, 12));

		panel_1.add(lblID);
		panel_1.add(lblName);
		panel_1.add(lblAge);
		panel_1.add(lblGender);
		panel_1.add(rdbMale);
		panel_1.add(rdbFemale);
		panel_1.add(txtID);
		panel_1.add(txtName);
		panel_1.add(txtAge);
		panel_1.add(btnAdd);
		panel_1.add(btnUpdate);
		panel_1.add(btnDelete);
		panel_1.add(btnSave);

		JLabel lblEmail = new JLabel("Email : ");
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblEmail.setBounds(10, 135, 100, 30);
		panel_1.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txtEmail.setBounds(100, 140, 160, 25);
		panel_1.add(txtEmail);

		lblPhoneNumber = new JLabel("PhoneNumber : ");
		lblPhoneNumber.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblPhoneNumber.setBounds(10, 172, 100, 30);
		panel_1.add(lblPhoneNumber);

		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txtPhoneNumber.setBounds(100, 176, 160, 25);
		panel_1.add(txtPhoneNumber);

		table = new JTable();
		model = new DefaultTableModel();
		Object[] column = { "ID", "Tên", "Tuổi","Email","Sdt" ,"Giới Tính" };
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, name, pass);
			Statement st = conn.createStatement();
			String sql = "SELCECT*FROM SINHVIEN";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Object[] row = new Object[] { rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4),
						rs.getString(5), rs.getBoolean(6) };
			}
		} catch (Exception ee) {
			ee.printStackTrace();
		}
		model.setColumnIdentifiers(column);
		model.setRowCount(0);

		table.setModel(model);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 30, 350, 250);
		scrollPane.setViewportView(table);

		panel_2.add(scrollPane);
		setVisible(true);
	}

	public void Display(int i) {
		Student s = list.get(i);
		txtID.setText(String.valueOf(s.getMasv()));
		txtName.setText(s.getName());
		txtAge.setText(String.valueOf(s.getAge()));
		txtEmail.setText(s.getEmail());
		txtPhoneNumber.setText(s.getPhoneNumber());
		boolean gt = s.isGioiTinh();
		if (gt == true) {
			rdbMale.setSelected(true);
		} else {
			rdbFemale.setSelected(true);
		}
	}

	public void LoadDataToArrayList() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, name, pass);
			Statement st = conn.createStatement();
			String sql = "SELECT*FROM SINHVIEN";
			ResultSet rs = st.executeQuery(sql);
			list.clear();
			while (rs.next()) {
				int masv = rs.getInt(1);
				String name = rs.getString(2);
				int age = rs.getInt(3);
				String email = rs.getString(4);
				String phoneNumber = rs.getString(5);
				boolean gt = rs.getBoolean(6);

				Student student = new Student(masv, name, age, email, phoneNumber, gt);

				list.add(student);
			}
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void LoadToArrayToTable() {
		DefaultTableModel modell = (DefaultTableModel) table.getModel();
		modell.setRowCount(0);
		for (Student s : list) {
			model.addRow(new Object[] { s.getMasv(), s.getName(), s.getAge(), s.getEmail(), s.getPhoneNumber(),
					s.isGioiTinh() });
		}
	}

	public void reset() {
		txtID.setText("");
		txtName.setText("");
		txtAge.setText("");
		txtEmail.setText("");
		txtPhoneNumber.setText("");
	}
}
