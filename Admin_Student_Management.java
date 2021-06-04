

public class Admin_Student_Management extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;
	private JTextField textField_3;
	private JTextField textField_4;
	

	int Student_ID;
	String Student_Name = null;
	String Email = null;
	String Password = null;
	String DOB = null;
	String Gender = null;
	String Contact_No = null;
	int Department_ID = 0;
	
	Connection con = null;
  	Statement statement = null;
  	ResultSet rs = null;
    PreparedStatement ps = null;
    private JTextField textField_5;
	public int Admin_ID;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Student_Management frame = new Admin_Student_Management();
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
	public Admin_Student_Management() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 860, 514);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Home");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Admin_Home home = new Admin_Home();
				home.Admin_ID = Admin_ID;
				home.setVisible(true);
				setVisible(false);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Log Out");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPage login = new LoginPage();
				login.setVisible(true);
				setVisible(false);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Shutdown");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Management");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(54, 40, 676, 50);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(414, 102, 140, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(414, 134, 140, 25);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(414, 225, 140, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(414, 256, 140, 25);
		contentPane.add(passwordField);
		
		textField_3 = new JTextField();
		textField_3.setBounds(414, 286, 140, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(414, 318, 140, 25);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Student ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(250, 101, 119, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Student Name");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(250, 133, 109, 25);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Email");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setHorizontalTextPosition(SwingConstants.LEADING);
		lblNewLabel_3.setBounds(250, 225, 109, 25);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setHorizontalTextPosition(SwingConstants.LEADING);
		lblNewLabel_4.setBounds(250, 255, 109, 25);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Contact No");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(250, 286, 109, 25);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Department ID");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6.setBounds(250, 317, 109, 25);
		contentPane.add(lblNewLabel_6);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertStudent();
			}
		});
		btnNewButton.setBounds(250, 363, 82, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {UpdateQuery();} 
				catch (SQLException e1) {}
			}
		});
		btnNewButton_1.setBounds(360, 363, 82, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {DeleteQuery();}
				catch (Exception e1) {}
			}
		});
		btnNewButton_2.setBounds(472, 363, 82, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_7 = new JLabel("Date of Birth");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_7.setBounds(250, 164, 97, 25);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Gender");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setBounds(250, 195, 107, 25);
		contentPane.add(lblNewLabel_8);
		
		textField_5 = new JTextField();
		textField_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textField_5.setBounds(414, 165, 140, 25);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JRadioButton Male = new JRadioButton("Male");
		Male.setForeground(Color.WHITE);
		JRadioButton Female = new JRadioButton("Female");
		Female.setForeground(Color.WHITE);
		Female.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Female.isSelected())
				{
					Male.setSelected(false);
					Gender = "Female";
				}
			}
		});
		
		Male.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Male.isSelected())
				{
					Female.setSelected(false);
					Gender = "Male";
				}
			}
		});
		Male.setBackground(Color.DARK_GRAY);
		Male.setBounds(414, 195, 65, 23);
		contentPane.add(Male);
		
		Female.setBackground(Color.DARK_GRAY);
		Female.setBounds(481, 195, 73, 23);
		contentPane.add(Female);
		
		
	}
	public void InsertStudent()
	{
		 if(textField.getText().equalsIgnoreCase(""))
		 {Student_ID = 0;}
		 else 
		 {Student_ID = Integer.parseInt(textField.getText());}
		 Student_Name = textField_1.getText();
		 DOB = textField_5.getText();
		 Email = textField_2.getText();
		 Password = passwordField.getText();
		 Contact_No = textField_3.getText();
		 if(textField_4.getText().equalsIgnoreCase(""))
		 {Department_ID = 0;}
		 else 
		 {Department_ID = Integer.parseInt(textField_4.getText());}
		 
		 new StudentsFactory();
		 AbstractStudent student = StudentsFactory.getStudent(Student_ID);
		 
		 String query = "insert into Students (Student_ID, Name, DOB, Gender, Email, Password,[Contact No],[Date of Join], DId)"+" values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
		 con = Connector.getConnection();
		 try{ps = con.prepareStatement(query);}
		 catch(Exception e1) {}
		 
		 try{
				if(Student_ID == 0|| Student_ID < 0 || Student_Name.equalsIgnoreCase("")
				|| Email.equalsIgnoreCase("")|| Password.equalsIgnoreCase("")
				|| Contact_No.equalsIgnoreCase("")|| Department_ID == 0)
				{ throw new Exception(); }
		try {
			if(student.getMessage().equals("Not Exist in Database"))
			{
			try {ps.setInt (1, Student_ID);} 
			catch (SQLException e3) {}
			
			
			try {ps.setString (2, Student_Name);} 
			catch (SQLException e3) {}
			
			try {ps.setString (3, DOB);} 
			catch (SQLException e3) {}
			
			try {ps.setString (4, Gender);} 
			catch (SQLException e3) {}
			
			try {ps.setString (5, Email);} 
			catch (SQLException e3) {}
			
			
			try {ps.setString (6, Password);} 
			catch (SQLException e3) {}
			
			
			try {ps.setString (7, Contact_No);} 
			catch (SQLException e2) {}

			try {ps.setString (8, "");} 
			catch (SQLException e2) {}
			
			try {ps.setInt (9, Department_ID);} 
			catch (SQLException e3) {}
			
			try {ps.execute();} 
			catch (SQLException e1) {}
			
			JOptionPane.showMessageDialog(null,"Successfully Added");
			}else
		{throw new ArithmeticException();}
		}
		catch(ArithmeticException a)
		{JOptionPane.showMessageDialog(null, "Student Already in Database");}
			}
			catch(Exception e1)
			{JOptionPane.showMessageDialog(null,"Invalid Input");
			}
			
			textField.setText("");
			textField_1.setText("");
			textField_2.setText("");
			textField_3.setText("");
			textField_4.setText("");
			textField_5.setText("");
			passwordField.setText("");
		}
			public void UpdateQuery() throws SQLException
			{ 
				 con = Connector.getConnection();
				 String update = null;
				 
				 if(textField.getText().equalsIgnoreCase(""))
				 {Student_ID = 0;}
				 else 
				 {Student_ID = Integer.parseInt(textField.getText());}
				 
				 if(textField_4.getText().equalsIgnoreCase(""))
				 {Department_ID = 0;}
				 else 
				 {Department_ID = Integer.parseInt(textField_4.getText());}
				 
				 Student_Name = textField_1.getText();
				 Email = textField_2.getText();
				 Password = passwordField.getText();
				 Contact_No = textField_3.getText();
				 DOB = textField_5.getText();
				
				new StudentsFactory();
				AbstractStudent student = StudentsFactory.getStudent(Student_ID);
				
				try {
				 if(Student_ID == 0 || Student_ID < 0)
				 {throw new Exception();}
				 try {
				 if(student.getMessage().equals(Student_ID+" Exist in Database"))
				 {
				 if(!Student_Name.equalsIgnoreCase("")) {
				 update = "update Students set Name='"+Student_Name+"' where Student_ID = "+Student_ID;
				 statement = con.createStatement();
				 statement.executeUpdate(update);
				 }
				 if(!DOB.equalsIgnoreCase("")) {
				 update = "update Students set DOB='"+DOB+"' where Student_ID = "+Student_ID;
				 statement = con.createStatement();
				 statement.executeUpdate(update);				 
				 
				 if(!Gender.equalsIgnoreCase("Select")) {
				 update = "update Students set Gender='"+Gender+"' where Student_ID = "+Student_ID;
				 statement = con.createStatement();
				 statement.executeUpdate(update);
				 }
				 if(!Email.equalsIgnoreCase("")) {
				 update = "update Students set Email='"+Email+"' where Student_ID = "+Student_ID;
				 statement = con.createStatement();
				 statement.executeUpdate(update);
				 }
				 if(!Password.equalsIgnoreCase("")) {
				 update = "update Students set Password='"+Password+"' where Student_ID = "+Student_ID;
				 statement = con.createStatement();
				 statement.executeUpdate(update);
				 }
				 if(!Contact_No.equalsIgnoreCase("")) {
				 update = "update Students set [Contact No]='"+Contact_No+"' where Student_ID = "+Student_ID;
				 statement = con.createStatement();
				 statement.executeUpdate(update);
				 }
				 if(Department_ID != 0) {
				 update = "update Students set DId='"+Department_ID+"' where Student_ID = "+Student_ID;
				 statement = con.createStatement();
				 statement.executeUpdate(update);
				 }
				 JOptionPane.showMessageDialog(null, "Sucessfully Updated Given Fields ");
				 }}
				 else {throw new ArithmeticException(); }
				 }
				catch(ArithmeticException a)
				{JOptionPane.showMessageDialog(null, "Student dont Exist in Database");}
				 } 
				catch(Exception ee)
				 {JOptionPane.showMessageDialog(null, "Try Giving Valid Student ID ");}
				
			}
			public void DeleteQuery() throws Exception
			{
				
				con = Connector.getConnection();
				
				if(textField.getText().equalsIgnoreCase(""))
				 {Student_ID = 0;}
				 else 
				 {Student_ID = Integer.parseInt(textField.getText());
				 }

				try {
				new StudentsFactory();
				AbstractStudent student = StudentsFactory.getStudent(Student_ID);
					
				if(Student_ID == 0 || Student_ID < 0)
				{throw new Exception();}
				else {
				try {
				if(student.getMessage().equals(Student_ID+" Exist in Database"))
				{
					String delete = "delete from Students where Student_Id = "+Student_ID;
				
				statement = con.createStatement();
				statement.executeUpdate(delete);
				JOptionPane.showMessageDialog(null, "Sucessfully Deleted "); 
				}
				else if(student.getMessage().equals("Not Exist in Database"))
				{ throw new ArithmeticException(); }
				}
				catch(ArithmeticException a)
					{JOptionPane.showMessageDialog(null, "Student dont Exist in Database");}
				}}
				catch(Exception e)
				{JOptionPane.showMessageDialog(null, "Invalid Student ID ");}
		}
	}


