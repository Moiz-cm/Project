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
