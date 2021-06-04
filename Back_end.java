//file has been updated//
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
