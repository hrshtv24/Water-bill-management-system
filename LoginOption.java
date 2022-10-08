package myproject;
import myproject.*;
import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class LoginOption  
{ JFrame fr;
  JLabel l;
  JButton admin,acc; 
public LoginOption(){
	fr=new JFrame();
    fr.setSize(400,400);
    fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     setComponents();	 
	 fr.setVisible(true);
	 admin.addActionListener(new AdminHandler());
	 //acc.addActionListener(new AccHandler());
}
  public LoginOption(String title)
  { fr=new JFrame(title);
    fr.setSize(400,400);
    fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     setComponents();	 
	 fr.setVisible(true);
	 admin.addActionListener(new AdminHandler());
	 //acc.addActionListener(new AccHandler());
	 
   }
	public class AdminHandler implements ActionListener
	{ JFrame f; 
	  JLabel l1,l2;
	   JTextField t1;
	   JPasswordField adPas;
	   JButton log;
	  public void actionPerformed(ActionEvent ad)
	  {
         fr.dispose();
       f=new JFrame();
       f.setSize(500,400);
	   f.setVisible(true);
	   f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       l1=new JLabel("UserName:");
	   l2=new JLabel("Password:");
	   t1=new JTextField();
	   adPas=new JPasswordField();
	   log=new JButton("Login");
	   f.setLayout(null);
	   l1.setBounds(30,20,100,20);
	   l2.setBounds(30,50,100,20);
	   t1.setBounds(150,20,100,20);
	   adPas.setBounds(150,50,100,20);
	   log.setBounds(130,90,100,20);
	   f.add(l1); f.add(l2); f.add(t1); f.add(adPas); f.add(log);
		log.addActionListener(new AdminLogin());   
		}
	public class AdminLogin implements ActionListener
	{
		public void actionPerformed(ActionEvent ae1)
		{
			try{
		//   Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); 

		Connection con=DriverManager.getConnection("jdbc:ucanaccess://D:/Harshit/Foni/Javaprograms/Database1.accdb");
		Statement st=con.createStatement();
		String sql="SELECT * FROM Admin_Table WHERE AdminName='"+t1.getText()+"' and Password='"+adPas.getText()+"' ";
		ResultSet rs=st.executeQuery(sql);
		if(rs.next())
		{ 
			JOptionPane.showMessageDialog(new JFrame(),"Successfully Login..");
			f.dispose();
			new AccountantPage("Admin Page");
		}
		else
		
	  JOptionPane.showMessageDialog(null,"Incorrect userName or Password");	
		con.close();
		}
		catch(Exception ob)
		{
			System.out.println("Exception: "+ob.getMessage());
		}
		}
	}
	}
	
	 
 public void setComponents()
   {
	   l=new JLabel("Water Bill");
	   admin=new JButton("Admin Control");
	  
	   fr.setLayout(null);
	   l.setBounds(150,20,180,20);
	   admin.setBounds(100,100,150,30);
	  
	   fr.add(l); fr.add(admin); 
	   
	   
   }
   public static void main(String args[])
   {
	   LoginOption l=new LoginOption("Water Bill");
   }
}