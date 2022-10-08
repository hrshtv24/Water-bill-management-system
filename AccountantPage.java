package myproject;
import myproject.*;
import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.util.Vector;
public class AccountantPage
{ 
  JFrame accFrame;
  JButton Add,view,edit,logout;
  JLabel l;

	public AccountantPage()
	{
		accFrame=new JFrame();
    accFrame.setSize(450,400);
    accFrame.setVisible(true);
    accFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	// Initializing components
   
   Add=new JButton("Add Customer");
   edit=new JButton("Edit Customer");
  view=new JButton("View Customer");
  logout=new JButton("Logout");
  l=new JLabel("Admin Section");
  
  //setting layout
  accFrame.setLayout(null);
  l.setBounds(160,10,150,50);
  Add.setBounds(40,70,160,30);
 view.setBounds(250,70,160,30); 
 edit.setBounds(40,130,160,30);
  logout.setBounds(250,130,160,30);
 
 //adding compoenets to frame
  accFrame.add(l);
  accFrame.add(logout);
  accFrame.add(Add);
  accFrame.add(view);
  accFrame.add(edit);
  Add.addActionListener(new AddHandler());
  view.addActionListener(new ViewHandler());
 edit.addActionListener(new EditHandler());
  logout.addActionListener(new LogoutHandler()); 
 }//1st cons brace

   public AccountantPage(String title)
	{   // initializing Frame  
	  	accFrame=new JFrame(title);
    accFrame.setSize(450,400);
    accFrame.setVisible(true);
    accFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	// Initializing components
   
   Add=new JButton("Add Customer");
   edit=new JButton("Edit Customer");
  view=new JButton("View Customer");
  logout=new JButton("Logout");
  l=new JLabel("Accountant Section");
  
  //setting layout
  accFrame.setLayout(null);
  l.setBounds(160,10,150,50);
  Add.setBounds(40,70,160,30);
 view.setBounds(250,70,160,30); 
 edit.setBounds(40,130,160,30);
  logout.setBounds(250,130,160,30);
 
 //adding compoenets to frame
  accFrame.add(l);
  accFrame.add(logout);
  accFrame.add(Add);
  accFrame.add(view);
  accFrame.add(edit);
  //Button Events
  Add.addActionListener(new AddHandler());
  view.addActionListener(new ViewHandler());
  edit.addActionListener(new EditHandler());
  logout.addActionListener(new LogoutHandler());
 }//2nd constructor brace

 public class AddHandler implements ActionListener
 { 
    JFrame addF;
	JButton addCustomer,back;
	JLabel nL,feeL,paidL,coNL,ptitle,adrsL;
	JTextField nT,feeT,paidT,coNT,adrsT;
	 public void actionPerformed(ActionEvent Ae)
	 {
		 accFrame.dispose();
		 addF=new JFrame();
	//	Initializing Frame 
		 addF.setSize(500,400);
		 addF.setVisible(true);
		 addF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// Initializing JFrame components		
		nL=new JLabel("Name:");
		feeL=new JLabel("Unit:");
		adrsL=new JLabel("House No.:");
		 coNL=new JLabel("Contact No:");
		 ptitle=new JLabel("Add Customer");
// JTextField Initializing
		 nT=new JTextField();
		
		feeT=new JTextField();
		
		adrsT=new JTextField();
		
		 coNT=new JTextField();
		 
		 addCustomer=new JButton("Add Customer");
		 back=new JButton("Back");
	// Setting Layout
	addF.setLayout(null);
	ptitle.setBounds(200,40,160,40);
	nL.setBounds(10,90,100,20);
	nT.setBounds(130,90,260,20);
	
	feeL.setBounds(10,120,100,20);
	feeT.setBounds(130,120,200,20);
	
	adrsL.setBounds(10,150,100,20);
	adrsT.setBounds(130,150,200,20);
	
	coNL.setBounds(10,180,100,20);
	coNT.setBounds(130,180,200,20);
	addCustomer.setBounds(140,210,160,30);
	back.setBounds(340,210,100,30);
// Adding components to frame
addF.add(nL); addF.add(nT); 
addF.add(feeL); addF.add(feeT);
 addF.add(adrsL); addF.add(adrsT);  
 addF.add(coNL); addF.add(coNT);
 addF.add(addCustomer); addF.add(back);
  addCustomer.addActionListener(new AddCustomerHandler());
  back.addActionListener(new BackAddCustomerHandler());
	}// actionPerformed method brace
	public class BackAddCustomerHandler implements ActionListener
	{ public void actionPerformed(ActionEvent BAE)
		{  addF.dispose();
		   new AccountantPage();
		}
	}
	public class AddCustomerHandler implements ActionListener
	{
       public Integer getTotalBill()
	  {  if(Integer.parseInt(feeT.getText())<=100)
	        return (Integer.parseInt(feeT.getText())*2);
		    else
			return (Integer.parseInt(feeT.getText())*4);		
	   }
		public void actionPerformed(ActionEvent addSte)
		{     try{
			    Connection con=DriverManager.getConnection("jdbc:ucanaccess://D:/Harshit/Foni/Javaprograms/Database1.accdb");
		        Statement st=con.createStatement();
	           String sql="INSERT INTO Customer_Details_Table(CustomerName,Unit,TotalBill,HouseNo,ContactNo) VALUES('"+nT.getText()+"','"+feeT.getText()+"','"+getTotalBill()+"','"+adrsT.getText()+"','"+coNT.getText()+"')";
			   st.executeUpdate(sql);
			     con.close();
			   JOptionPane.showMessageDialog(null,"Customer added successfully!");
			   nT.setText("");feeT.setText("");adrsT.setText("");coNT.setText("");
		}
		catch(Exception E){
		System.out.println("Exception: "+E);
		}
			   }
			
	}
 }// AddHandler brace
 public class LogoutHandler implements ActionListener
 {
	 public void actionPerformed(ActionEvent LE)
	 {
		 JFrame f=new JFrame();
		  int a=JOptionPane.showConfirmDialog(f,"Are you sure?");
             if(a==JOptionPane.YES_OPTION)
			 {
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             accFrame.dispose(); 		 
			 }
		 new LoginOption();
		  }
 }
 
public class ViewHandler implements ActionListener
{ 
   JFrame vF;
   //JButton backV;
   JTable studentT;
   public void actionPerformed(ActionEvent VE)
	{ 
	try{
	  Connection con=DriverManager.getConnection("jdbc:ucanaccess://D:/Harshit/Foni/Javaprograms/Database1.accdb");
		Statement st=con.createStatement();
		String query="Select * from Customer_Details_Table";
		ResultSet rs=st.executeQuery(query);
		ResultSetMetaData md=rs.getMetaData();
       int columnsCount=md.getColumnCount();
	   Vector columns=new Vector(columnsCount);
	   // store columns name
       for(int i=1;i<=columnsCount;i++)
	    columns.add(md.getColumnName(i));
		Vector data=new Vector();
		Vector row;
		while(rs.next())
		{
			row=new Vector(columnsCount);
			for(int i=1;i<=columnsCount;i++)
				row.add(rs.getString(i));
			  // add 	a particular row in with specified data
			  data.add(row);
		}
		rs.close();
		//accFrame.dispose();
		vF=new JFrame("Customers Details");
	//	backV= new JButton("Back");
		DefaultTableModel model1=new DefaultTableModel(data,columns);
		studentT=new JTable(model1);
		studentT.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		studentT.setRowHeight(20);
		studentT.getColumnModel().getColumn(1).setPreferredWidth(150);
		studentT.getColumnModel().getColumn(2).setPreferredWidth(150);
	//	vF.setLayout(null);
		studentT.setBounds(10,10,600,350);
	//	backV.setBounds(345,375,50,20);
		JScrollPane sp=new JScrollPane(studentT);
		// Enabling scrollbars
		
		sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
        sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED); 
        sp.setVisible(true);
		vF.add(sp);
	//	vF.add(backV);
		vF.setSize(700,400);
		//vF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vF.setVisible(true);
	 // backV.addActionListener(new BackViewHandler());
	}
	catch(Exception E)
	{ System.out.println("Exception: "+E);
	}
		
	} // View actionPerformed ends
}
public class EditHandler implements ActionListener
 { JFrame editF;
  JButton updateCustomer,backUpd,load;
	//JTextArea  adrsT;
	JLabel rL,nL,feeL,paidL,coNL,ptitle,adrsL;
	JTextField rT,nT,feeT,paidT,coNT,adrsT;
	 public void actionPerformed(ActionEvent Ae)
	 {
		 accFrame.dispose();
		 editF=new JFrame();
	//	Initializing Frame 
		 editF.setSize(500,400);
		 editF.setVisible(true);
		 editF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// Initializing JFrame components		
		rL=new JLabel("CustomerID");
		nL=new JLabel("Name:");
	
		feeL=new JLabel("Units:");
		
		adrsL=new JLabel("House No.:");
		
		 coNL=new JLabel("Contact No:");
		 ptitle=new JLabel("Edit Customer Details");
// JTextField Initializing
       rT=new JTextField();		
		nT=new JTextField();
		feeT=new JTextField();
		
		adrsT=new JTextField();  // Address Text area
		
		 coNT=new JTextField();
		 
		 updateCustomer=new JButton("Update Customer");
		 backUpd=new JButton("Back");
		 load=new JButton("Load");
	// Setting Layout
	editF.setLayout(null);
	ptitle.setBounds(200,20,160,30);
    rL.setBounds(10,60,100,20);
	rT.setBounds(130,60,60,20);
	load.setBounds(210,60,100,20);
	nL.setBounds(10,90,100,20);
	nT.setBounds(130,90,260,20);

	feeL.setBounds(10,120,100,20);
	feeT.setBounds(130,120,200,20);

	adrsL.setBounds(10,150,100,20);
	adrsT.setBounds(130,150,200,20);

	coNL.setBounds(10,180,100,20);
	coNT.setBounds(130,180,200,20);
	updateCustomer.setBounds(140,210,160,30);
	backUpd.setBounds(340,210,100,30);
// Adding components to frame
editF.add(nL); editF.add(nT);
editF.add(feeL); editF.add(feeT); 
 editF.add(adrsL); editF.add(adrsT);

 editF.add(coNL); editF.add(coNT); editF.add(load); editF.add(rL); editF.add(rT);
 editF.add(updateCustomer); editF.add(backUpd);
 load.addActionListener(new LoadHandler());
 updateCustomer.addActionListener(new UpdateHandler());
 backUpd.addActionListener(new BackUpdateHandler());
	 } // Edit Customer Handler actionPerformed ends
	 public class BackUpdateHandler implements ActionListener
	 {  public void actionPerformed(ActionEvent BUE)
		 {
			 editF.dispose();
			 new AccountantPage();
		 }
	 }
	 public class LoadHandler implements ActionListener
	 {
		 public void actionPerformed(ActionEvent le)
		 {   try{
			 Connection con=DriverManager.getConnection("jdbc:ucanaccess://D:/Harshit/Foni/Javaprograms/Database1.accdb");
		 Statement st=con.createStatement();
		 String query="Select * from Customer_Details_Table where CustomerID='"+rT.getText()+"'";
		 ResultSet rs=st.executeQuery(query);
		  while(rs.next())
		  {
	
			nT.setText(rs.getString("CustomerName"));
			
		
			feeT.setText(rs.getString("Unit"));
			
			adrsT.setText(rs.getString("HouseNo"));
			
			coNT.setText(rs.getString("ContactNo"));
		  }  // while loops ends
		  con.close();
		  JOptionPane.showMessageDialog(null,"Record Loaded!\n please edit required information.");
		 } // try block ends
		 catch(Exception E)
		 { System.out.println("Exception: "+E);	}
		 
		 }
	 }
	 public class UpdateHandler implements ActionListener
	 {  
	      
       public Integer getTotalBill()
	  {  if(Integer.parseInt(feeT.getText())<=100)
	        return (Integer.parseInt(feeT.getText())*2);
		    else
			return (Integer.parseInt(feeT.getText())*4);		
	   }
		 public void actionPerformed(ActionEvent UE)
		 { try{  
		 Connection con=DriverManager.getConnection("jdbc:ucanaccess://D:/Harshit/Foni/Javaprograms/Database1.accdb");
		      Statement st=con.createStatement();
	  String UpdQuery="Update Customer_Details_Table  set CustomerName='"+nT.getText()+"', Unit='"+feeT.getText()+"', TotalBill='"+getTotalBill()+"', HouseNo='"+adrsT.getText()+"', ContactNo='"+coNT.getText()+"' where CustomerID='"+rT.getText()+"' ";
       st.executeUpdate(UpdQuery);
	   con.close();
	   JFrame f=new JFrame();
	   int n=JOptionPane.showConfirmDialog(f,"Changes can not be undone!\n Do you want to continue?");
	   if(n==JOptionPane.YES_OPTION){
		   f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   JOptionPane.showMessageDialog(null,"Record updated successfully!");
		   editF.dispose();
		   new AccountantPage();
          }
		  else{
		   f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  }
	    	 
	  }
        catch(Exception E)	
		{ System.out.println("Exception: "+E); 
		} // catch block ends
		}// Update Handler actionPerformed ends
	 }
 }
 }
	
