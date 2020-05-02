import janu.Create;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import QuestionPaperPackage.QPaper;
import delete.Delete;

//import akku.StudentPart;
class MainFrame extends JFrame implements ActionListener,ItemListener
{
	Container cont;
	QPaper qpp;
	Delete del;
	Create crt;
	AdminVsStudentPanel asp;
	LoginPanel lp;
	NewLoginPanel new_lp;
	StudentLoginPanel stud_lp;
	AdminPanelOne apo;
	PassError pe;
	UserError ue;
	UserPassError upe;
	StudentPassError stud_pe;
	StudentUserError stud_ue;
	StudentUserPassError stud_upe;
	CreateTest ct;
	SelectSection ss;
	//StudentPart spart;
	public Category ca;
	public Section se;
	public int cnd=1,snd=1,intQnd=1;
	public QuestionPaper qp;
    public String catnam,sname,qnd,fu;
    JButton jb;
    Color c1,c2,c3,c4;
	MainFrame(String s)
	{
		super(s);
		//try{
	//		Class.forName(com.mysql.jdbc.driver).newInstance();
//			con=DriverManager.getConnection()////aiyaaa thi baki chhe
		//}
		c1=new Color(249,247,155);
		c2=new Color(211,247,89);
		c3=new Color(150,236,243);
		Color dg=new Color(2,102,112);
		Color lbc=new Color(159,237,215);


		cont=getContentPane();
		cont.setLayout(null);
		cont.setBackground(c2);
		//setContentPane(new JLabel(new ImageIcon("C:/Users/DHRUVIL/Downloads/8347073.jpg")));
		
		asp=new AdminVsStudentPanel();
		asp.setLayout(null);
		asp.setBounds(100,200,1100,400);
		asp.setBackground(dg);
		cont.add(asp);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		asp.adminButton.addActionListener(this);
		asp.studentButton.addActionListener(this);
		asp.signUpBtn.addActionListener(this);
		/////////////////////////////////////
		crt=new Create();
		crt.setBounds(0,0,1350,1000);
		crt.setLayout(null);
		crt.setBackground(c2);
		cont.add(crt);
		crt.setVisible(false);
		crt.gbcrt.addActionListener(this);
		///////////////////////////////////////////
		del=new Delete();
		del.setBounds(0,0,1350,1000);
		del.setLayout(null);
		del.setBackground(c2);
		cont.add(del);
		del.setVisible(false);
		del.bk.addActionListener(this);
		///////////////////////////////////////
		/*spart=new StudentPart();
		spart.setBounds(100,200,1100,400);
		spart.setBackground(Color.red);
		cont.add(spart);
		spart.setVisible(false);*/
		///////////////////////////////
		lp=new LoginPanel();
		lp.setLayout(null);
		lp.setBounds(100,200,1100,400);
		lp.setBackground(dg);
		cont.add(lp);
		lp.setVisible(false);
		lp.loginPanelGoBackButton.addActionListener(this);
		lp.loginSubmitButton.addActionListener(this);
		///////////////////////////////////////////////
		new_lp=new NewLoginPanel();
		new_lp.setLayout(null);
		new_lp.setBounds(100,200,1100,400);
		new_lp.setBackground(dg);
		cont.add(new_lp);
		new_lp.setVisible(false);
		new_lp.loginPanelGoBackButton.addActionListener(this);
		new_lp.loginSubmitButton.addActionListener(this);
		new_lp.thirdBtn.addActionListener(this);
		/////////////////////////////////////////////
		stud_lp=new StudentLoginPanel();
		stud_lp.setLayout(null);
		stud_lp.setBounds(100,200,1100,400);
		stud_lp.setBackground(dg);
		cont.add(stud_lp);
		stud_lp.setVisible(false);
		stud_lp.loginPanelGoBackButton.addActionListener(this);
		stud_lp.loginSubmitButton.addActionListener(this);
		/////////////////////////////////////////////
		apo=new AdminPanelOne();
		apo.setLayout(null);
		apo.setBounds(0,0,1350,700);
		apo.setBackground(c2);
		cont.add(apo);
		apo.setVisible(false);
		apo.logout.addActionListener(this);
		apo.create.addActionListener(this);
		apo.delete.addActionListener(this);
		apo.show.addActionListener(this);
		apo.update.addActionListener(this);
		//////////////////////////////////////////////////
		pe=new PassError();
		pe.setLayout(null);
		pe.setBounds(400,200,600,200);
		cont.add(pe);
		pe.setBackground(Color.red);
		pe.setVisible(false);
		pe.errorBtn.addActionListener(this);
		//////////////////////////////////////////////
		stud_pe=new StudentPassError();
		stud_pe.setLayout(null);
		stud_pe.setBounds(400,200,600,200);
		cont.add(stud_pe);
		stud_pe.setBackground(Color.red);
		stud_pe.setVisible(false);
		stud_pe.errorBtn.addActionListener(this);
		//////////////////////////////////////////////
		ue=new UserError();
		ue.setLayout(null);
		ue.setBounds(400,200,600,200);
		cont.add(ue);
		ue.setBackground(Color.red);
		ue.setVisible(false);
		ue.errorBtn.addActionListener(this);
		/////////////////////////////////////////////////////////
		stud_ue=new StudentUserError();
		stud_ue.setLayout(null);
		stud_ue.setBounds(400,200,600,200);
		cont.add(stud_ue);
		stud_ue.setBackground(Color.red);
		stud_ue.setVisible(false);
		stud_ue.errorBtn.addActionListener(this);
		/////////////////////////////////////////////////////////
		upe=new UserPassError();
		upe.setLayout(null);
		upe.setBounds(400,200,600,200);
		cont.add(upe);
		upe.setBackground(Color.red);
		upe.setVisible(false);
		upe.errorBtn.addActionListener(this);
		////////////////////////////////////////////////////////
		stud_upe=new StudentUserPassError();
		stud_upe.setLayout(null);
		stud_upe.setBounds(400,200,600,200);
		cont.add(stud_upe);
		stud_upe.setBackground(Color.red);
		stud_upe.setVisible(false);
		stud_upe.errorBtn.addActionListener(this);
		/////////////////////////////////////////////////////////
		ct=new CreateTest();
		ct.setLayout(null);
		ct.setBounds(200,150,400,300);
		cont.add(ct);
		ct.setBackground(Color.yellow);
		ct.setVisible(false);
		ct.revalidate();
		ct.updateUI();
		ct.repaint();
		ct.backToApo.addActionListener(this);
		ct.cNext.addActionListener(this);
		
		///////////////////////////////////////////////
		ss=new SelectSection();
		ss.setLayout(null);
		ss.setBounds(200,150,400,300);
		cont.add(ss);
		ss.setBackground(Color.yellow);
		ss.setVisible(false);
		ss.revalidate();
		ss.updateUI();
		ss.repaint();
		ss.backToCat.addActionListener(this);
		ss.sNext.addActionListener(this);
		///////////////////*///////////////////***********************************
		ca=new Category();
		se=new Section();
		qp=new QuestionPaper();
		
		ca.setLayout(null);
		se.setLayout(null);
		qp.setLayout(null);
		
		ca.setBounds(130, 150, 1100, 400);
		se.setBounds(130, 150, 1100, 400);
		qp.setBounds(130, 150, 1100, 400);
		
		ca.setBackground(dg);
		se.setBackground(dg);
		qp.setBackground(dg);
		
		ca.jcb.setBackground(lbc);
		se.jcb.setBackground(lbc);
		qp.jcb.setBackground(lbc);
		
		ca.jb.setBackground(lbc);
		ca.jl.setForeground(lbc);
		
		se.jb.setBackground(lbc);
		se.jl.setForeground(lbc);
		
		qp.jcb.setBackground(lbc);
		qp.jl.setForeground(lbc);
		
		ca.setVisible(false);
		se.setVisible(false);
		qp.setVisible(false);
		
		/*jb=new JButton("DISPLAY");
		jb.setFont(new java.awt.Font("Comic Sans MS",Font.BOLD, 20));
		//jb.setLayout(null);
		jb.setForeground(Color.white);                  //(Color.white);
		jb.setBackground(new Color(128,0,0));
		jb.setBounds(200,200,200,100);
		jb.addActionListener(this);
		jb.setVisible(false);*/
		
		
			
		ca.jb.addActionListener(this);
		//ca.jb1.addActionListener(this);
		se.jb.addActionListener(this);
		qp.jb.addActionListener(this);
		
		ca.jcb.addItemListener(this);
		
		
		add(ca); add(se); add(qp); 

	}
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent btName) {
		String st=btName.getActionCommand();
		/*if(st.equals("DISPLAY"))
		{
			spart.setVisible(false);
			asp.setVisible(true);
		}*/


		if(st.equals("Sign up"))
		{
			asp.setVisible(false);
			new_lp.setVisible(true);
		}
		else if(st.equals("Confirm"))
		{
			String u,p;
			u=new_lp.userText.getText();
			p=new_lp.passText.getText();
			try{
				Class.forName("com.mysql.jdbc.driver");
			}catch(ClassNotFoundException e1)
			{
				e1.printStackTrace();
			}
			String url="jdbc:mysql://localhost:3306/practice1";
			String password="";
			String username="root";
			String x = null,y=null;
					try
					{
						Connection con=DriverManager.getConnection(url,username,password);
						Statement stmt=con.createStatement();
						String qry="insert into student_login values('"+u+"','"+p+"')";
						stmt.executeUpdate(qry);
						new_lp.setVisible(false);
						asp.setVisible(true);
					}catch(SQLException e2)
					{
						e2.printStackTrace();
					}
					
		}
		else if(st.equals("Have account?"))
		{
			new_lp.setVisible(false);
			stud_lp.setVisible(true);
		}
		else if(st.equals("Return"))
		{
			new_lp.setVisible(false);
			asp.setVisible(true);
		}
		if(st.equals("Student"))
		{
			asp.setVisible(false);
			//spart.setVisible(true);
			stud_lp.setVisible(true);
		}
		else if(st.equals("back to modes"))
		{
			stud_lp.setVisible(false);
			asp.setVisible(true);
		}
		else if(st.equals("login"))
		{
			String u,p;
			int uf=0,pf=0;
			u=stud_lp.userText.getText();
			p=stud_lp.passText.getText();
			try{
				Class.forName("com.mysql.jdbc.driver");
			}catch(ClassNotFoundException e1)
			{ 
				e1.printStackTrace();
			}
			String url="jdbc:mysql://localhost:3306/practice1";
			String password="";
			String username="root";
			String x = null,y=null;
					try
					{
						Connection con=DriverManager.getConnection(url,username,password);
						Statement stmt=con.createStatement();
						String qry="select USERNAME,PASSWORD from student_login where upper(USERNAME)='"+u+"'";
						ResultSet rs=stmt.executeQuery(qry);
						while(rs.next())
						{	
							x=rs.getString("USERNAME");
							y=rs.getString("PASSWORD");
						}
						rs.close();
						stmt.close();
						con.close();
						System.out.print(x+y);
						if(x.equals(u))
						{
							if(y.equals(p))
							{
								//apo.setVisible(true);
								ca.setVisible(true);
								try
								{

								Class.forName("com.mysql.jdbc.Driver");
								Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/practice1","root","");
								Statement stt=conn.createStatement();			
								ResultSet rs2=stt.executeQuery("select * from category");
								int i=0;
								fu=u;			
								while(rs2.next())
								{
									String s1=rs2.getString(2);
									ca.jcb.addItem(s1);
									i++;
								}
								
								ca.jcb.setVisible(true);
								rs2.close();
								stt.close();
								conn.close();
								}
								catch(Exception e)
								{
									System.out.println("ERROR   :  display "+e.getMessage());
								}

								asp.setVisible(false);
								stud_lp.setVisible(false);
								stud_lp.passText.setText("");
								stud_lp.userText.setText("");
							}
							else
							{
								stud_lp.passText.setText("");
								stud_lp.setVisible(false);
								stud_pe.setVisible(true);
							}
						}
						else
						{
							stud_lp.userText.setText("");
							stud_lp.setVisible(false);
							stud_ue.setVisible(true);
							
						}
						/*else
						{
							stud_lp.userText.setText("");
							stud_lp.passText.setText("");
							stud_lp.setVisible(false);
							stud_upe.setVisible(true);
						}*/
						
					}catch(SQLException e2)
			{
				e2.printStackTrace();
			}
		}
		if(st.equals("NEXT"))
		{
			ca.setVisible(false);
			se.setVisible(true);
			qp.setVisible(false);
			
			try
			{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println(".......DRIVER REGISTERED............");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/practice1","root","");
			System.out.println("\n.........DATABASE CONNECTED...");
			catnam=(String)ca.jcb.getSelectedItem();
			System.out.println("CATNAME:djp");
			System.out.println("CATNAME:"+catnam);
			System.out.println("CATNAME:djp");
			Statement stt=con.createStatement();
			
			ResultSet rs1=stt.executeQuery("select sna from section where cno=(select cno from category where upper(cna)='"+catnam+"')");
			//ResultSet rs2=st.executeQuery("select cno from category where upper(cna)='"+catnam+"'");
			//cnd=rs2.getInt(1);
			int i=0;
			
			while(rs1.next())
			{
				String s2=rs1.getString(1);
				se.jcb.addItem(s2);
				i++;
			}
			se.jcb.setVisible(true);
			rs1.close();
			
			stt.close();
			con.close();
			
			}
			
			
			catch(Exception e)
			{
				
				System.out.println("\n error :next1  "+e.getMessage());
			}

			
			ca.jcb.setVisible(true);
			se.jcb.setVisible(true);			
		}
		if(st.equals("admin panel"))
		{
			crt.setVisible(false);
			apo.setVisible(true);
		}
		if(st.equals("back to admin panel"))
		{
			del.setVisible(false);
			apo.setVisible(true);
		}
		if(st.equals("NEXT "))
		{
			ca.setVisible(false);
			se.setVisible(false);
			qp.setVisible(true);

			

			try
			{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/practice1","root","");
			sname=(String)se.jcb.getSelectedItem();
			Statement stt=con.createStatement();
			catnam=(String)ca.jcb.getSelectedItem();
			System.out.println("now :"+catnam);
			System.out.println("now :"+sname);
			ResultSet rs1=stt.executeQuery("select qpno from quep q, section s,category c  where q.cno=c.cno and q.sno=s.sno and upper(cna)='"+catnam+"' and upper(sna)='"+sname+"' group by qpno;");
			System.out.println("****"+catnam+" "+sname);
			
			//ResultSet rs2=st.executeQuery("select sno from section where upper(sna)='"+sname+"'");
			//snd=rs2.getInt(1);
			
			int i=0;
			
			while(rs1.next())
			{
				String s2=rs1.getString(1);
				qp.jcb.addItem(s2);
				i++;
			}
			qp.jcb.setVisible(true);
			rs1.close();
			stt.close();
			con.close();
			/*Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/practice1","root","");
			Statement stt=conn.createStatement();
			ResultSet rs2=stt.executeQuery("select sno from section where upper(sna)='"+sname+"'");
			snd=rs2.getInt(1);
			System.out.println("snd......"+snd);
			rs2.close();stt.close();conn.close();*/
			
			
			}
			
			
			catch(Exception e)
			{
				
				System.out.println("\n error :next2"+e.getMessage());
			}

		}
		if(st.equals("Go_Back"))
		{
			apo.setVisible(true);
			crt.setVisible(false);
		}
		if(st.equals("nextt"))
		{
			sname=(String)se.jcb.getSelectedItem();
			catnam=(String)ca.jcb.getSelectedItem();
			System.out.println("now :"+catnam);
			System.out.println("now :"+sname);
			
			qnd=(String)qp.jcb.getSelectedItem();
			System.out.println("now qnd:"+qnd);
			ca.setVisible(false);
			se.setVisible(false);
			qp.setVisible(false);
			qpp=new QPaper(catnam,sname,qnd,fu);
			add(qpp);
			qpp.setVisible(true);
		}

		if(st.equals("try again !"))
		{
			//ue.setVisible(true);
			stud_pe.setVisible(false);
			stud_lp.setVisible(true);
		}
		if(st.equals("try again!"))
		{
			//ue.setVisible(true);
			stud_ue.setVisible(false);
			stud_lp.setVisible(true);
		}
		if(st.equals("try again! "))
		{
			//ue.setVisible(true);
			stud_upe.setVisible(false);
			stud_lp.setVisible(true);
		}
		if(st.equals("Admin"))
		{
			asp.setVisible(false);
			lp.setVisible(true);	
		}
		else if(st.equals("Back To Modes"))
		{
			lp.setVisible(false);
			asp.setVisible(true);
		}
		else if(st.equals("LOGIN"))
		{
			String u,p;
			u=lp.userText.getText();
			p=lp.passText.getText();
			try{
				Class.forName("com.mysql.jdbc.driver");
			}catch(ClassNotFoundException e1)
			{
				e1.printStackTrace();
			}
			String url="jdbc:mysql://localhost:3306/practice1";
			String password="";
			String username="root";
			String x = null,y=null;
					try
					{
						Connection con=DriverManager.getConnection(url,username,password);
						Statement stmt=con.createStatement();
						String qry="select USERNAME,PASSWORD from admin_login";
						ResultSet rs=stmt.executeQuery(qry);
						while(rs.next())
						{	
							x=rs.getString("USERNAME");
							y=rs.getString("PASSWORD");
						}
						stmt.close();
						con.close();
						System.out.print(x+y);
						if(x.equals(u))
						{
							if(y.equals(p))
							{
								apo.setVisible(true);
								asp.setVisible(false);
								lp.setVisible(false);
								lp.passText.setText("");
								lp.userText.setText("");
							}
							else
							{
								lp.passText.setText("");
								lp.setVisible(false);
								pe.setVisible(true);
							}
						}
						else if(y.equals(p))
						{
							lp.userText.setText("");
							lp.setVisible(false);
							ue.setVisible(true);
							
						}
						else
						{
							lp.userText.setText("");
							lp.passText.setText("");
							lp.setVisible(false);
							upe.setVisible(true);
						}
						
					}catch(SQLException e2)
			{
				e2.printStackTrace();
			}
		}
		if(st.equals("TRY AGAIN !"))
		{
			//ue.setVisible(true);
			pe.setVisible(false);
			lp.setVisible(true);
		}
		if(st.equals("TRY AGAIN!"))
		{
			//ue.setVisible(true);
			ue.setVisible(false);
			lp.setVisible(true);
		}
		if(st.equals("TRY AGAIN! "))
		{
			//ue.setVisible(true);
			upe.setVisible(false);
			lp.setVisible(true);
		}
		if(st.equals("LOGOUT"))
		{
			apo.setVisible(false);
			lp.setVisible(true);
		}
		if(st.equals("GO Back!"))
		{
			ct.setVisible(false);
			apo.setVisible(true);
		}
		if(st.equals("GO Back!"))
		{
			ct.setVisible(false);
			
		}
		if(st.equals("Next"))
		{
			ct.setVisible(false);
			ss.setVisible(true);
			
		}
		if(st.equals("CREATE TEST"))
		{
			apo.setVisible(false);
			//ct.setVisible(true);
		   crt.setVisible(true);
			
		}
		if(st.equals("DELETE TEST"))
		{
			apo.setVisible(false);
			//ct.setVisible(true);
		   del.setVisible(true);
			
		}
		
	}
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
class SelectSection extends JPanel
{
	JLabel selectSec;JButton backToCat,sNext;
	SelectSection()
	{
		selectSec=new JLabel("Select Test Category");
		selectSec.setLayout(null);
		backToCat=new JButton("GO Back !");
		backToCat.setLayout(null);
		add(backToCat);
		sNext=new JButton("Next ");
		sNext.setLayout(null);
		add(sNext);
		add(selectSec);
		selectSec.setBounds(100,50,150,50);
		backToCat.setBounds(250,240,100,50);//ct.setBounds(400,400,400,300);
		sNext.setBounds(100,240,100,50);
	}
}
class CreateTest extends JPanel
{
	String select1;
	int intSelect1;
	JLabel selectCat;
	JButton backToApo,cNext;
	String catname[];
	CreateTest()
	{
		selectCat=new JLabel("Select Test Category");
		selectCat.setLayout(null);
		backToApo=new JButton("GO Back!");
		backToApo.setLayout(null);
		add(backToApo);
		cNext=new JButton("Next");
		cNext.setLayout(null);
		add(cNext);
		add(selectCat);
		selectCat.setBounds(100,50,150,50);
		backToApo.setBounds(250,240,100,50);//ct.setBounds(400,400,400,300);
		cNext.setBounds(100,240,100,50);
		///////////////////////////////////
		
		int c=0;
		
		try{
			Class.forName("com.mysql.jdbc.driver");
		}catch(ClassNotFoundException e1)
		{
			e1.printStackTrace();
		}
		String url="jdbc:mysql://localhost:3306/RUFF_DB";
		String password="";
		String username="root";
		try
		{
			Connection con=DriverManager.getConnection(url,username,password);
			Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			String qry="select * from category";
			ResultSet rs=stmt.executeQuery(qry);
			while(rs.next())
			{	
				c++;
			}
			System.out.println(c);
			catname=new String[c];
			int catnum[]=new int[c];
			rs.beforeFirst();
			int i=0;
			while(rs.next())
			{	
				catname[i]=rs.getString("CNAME");
				catnum[i]=rs.getInt("CNUM");
				System.out.println(catnum[i]);
				System.out.println(catname[i]);
				i++;
			}
			
			JComboBox<String> dropCat=new JComboBox<String>(catname);
			dropCat.setLayout(null);
			dropCat.setBounds(100,140,100,30);
			add(dropCat);
			dropCat.setVisible(true);
			/*select1=(String)dropCat.getSelectedItem();
			String qry1="select CNUM from category where CNAME="+select1;
			rs=stmt.executeQuery(qry1);
			rs.next();
			intSelect1=rs.getInt("CNUM");
			System.out.println("number="+intSelect1);*/
			
			
		}
		catch(SQLException e2)
		{
			e2.printStackTrace();
		}
		
		
		
	}
}
class AdminVsStudentPanel extends JPanel
{
	JButton adminButton,studentButton,signUpBtn;
	AdminVsStudentPanel()
	{
		Color dg=new Color(2,102,112);
		Color lbc=new Color(159,237,215);
		Color c2=new Color(211,247,89);

		adminButton=new JButton("Admin");
		studentButton=new JButton("Student");
		signUpBtn=new JButton("Sign up");
		
		adminButton.setLayout(null);
		studentButton.setLayout(null);
		
		adminButton.setBounds(50,50,400,300);
		add(adminButton);
		adminButton.setBackground(lbc);
		adminButton.setFont(new Font("Arial",Font.PLAIN,40));
		
		studentButton.setBounds(600,50,400,300);
		add(studentButton);
		studentButton.setBackground(lbc);
		studentButton.setFont(new Font("Arial",Font.PLAIN,40));
		
		signUpBtn.setBounds(475,150,100,100);
		add(signUpBtn);
		signUpBtn.setBackground(lbc);
		signUpBtn.setFont(new Font("Arial",Font.PLAIN,20));
		
	}

}
class PassError extends JPanel
{
	JLabel errorMsg;
	JButton errorBtn;
	PassError()
	{
		errorMsg=new JLabel("Incorrect Password");
		errorBtn=new JButton("TRY AGAIN !");
		errorMsg.setLayout(null);
		errorBtn.setLayout(null);
		errorMsg.setBounds(120,30,500,100);
		errorBtn.setBounds(150,150,100,50);
		add(errorMsg);
		add(errorBtn);
		
	}
}
class StudentPassError extends JPanel
{
	JLabel errorMsg;
	JButton errorBtn;
	StudentPassError()
	{
		errorMsg=new JLabel("Incorrect Password");
		errorBtn=new JButton("try again !");
		errorMsg.setLayout(null);
		errorBtn.setLayout(null);
		errorMsg.setBounds(120,30,500,100);
		errorBtn.setBounds(150,150,100,50);
		add(errorMsg);
		add(errorBtn);
		
	}
}
class UserError extends JPanel
{
	JLabel errorMsg;
	JButton errorBtn;
	UserError()
	{
		errorMsg=new JLabel("Incorrect Username");
		errorBtn=new JButton("TRY AGAIN!");
		errorMsg.setLayout(null);
		errorBtn.setLayout(null);
		errorMsg.setBounds(120,30,500,100);
		errorBtn.setBounds(150,150,100,50);
		add(errorMsg);
		add(errorBtn);
		
	}
}
class StudentUserError extends JPanel
{
	JLabel errorMsg;
	JButton errorBtn;
	StudentUserError()
	{
		errorMsg=new JLabel("Incorrect Username");
		errorBtn=new JButton("try again!");
		errorMsg.setLayout(null);
		errorBtn.setLayout(null);
		errorMsg.setBounds(120,30,500,100);
		errorBtn.setBounds(150,150,100,50);
		add(errorMsg);
		add(errorBtn);
		
	}
}
class UserPassError extends JPanel
{
	JLabel errorMsg;
	JButton errorBtn;
	UserPassError()
	{
		errorMsg=new JLabel("Incorrect Username and password");
		errorBtn=new JButton("TRY AGAIN! ");
		errorMsg.setLayout(null);
		errorBtn.setLayout(null);
		errorMsg.setBounds(120,30,500,100);
		errorBtn.setBounds(150,150,100,50);
		add(errorMsg);
		add(errorBtn);
		
	}
}
class StudentUserPassError extends JPanel
{
	JLabel errorMsg;
	JButton errorBtn;
	StudentUserPassError()
	{
		errorMsg=new JLabel("Incorrect Username and password");
		errorBtn=new JButton("try again! ");
		errorMsg.setLayout(null);
		errorBtn.setLayout(null);
		errorMsg.setBounds(120,30,500,100);
		errorBtn.setBounds(150,150,100,50);
		add(errorMsg);
		add(errorBtn);
		
	}
}
class LoginPanel extends JPanel
{
	JLabel usernameLabel,passwordLabel;
	public JTextField userText;
	public JPasswordField passText;
	JButton loginSubmitButton,loginPanelGoBackButton;
	
	LoginPanel()
	{
		Color lbc=new Color(159,237,215);

		usernameLabel=new JLabel("USERNAME");
		passwordLabel=new JLabel("PASSWORD");
		usernameLabel.setLayout(null);
		passwordLabel.setLayout(null);
		usernameLabel.setFont(new Font("Arial",Font.BOLD,20));
		passwordLabel.setFont(new Font("Arial",Font.BOLD,20));
		usernameLabel.setForeground(lbc);
		passwordLabel.setForeground(lbc);
		add(usernameLabel);
		add(passwordLabel);
		usernameLabel.setBounds(350,100,500,50);
		passwordLabel.setBounds(350,200,500,50);
		
		
		userText=new JTextField();
		passText=new JPasswordField();
		userText.setLayout(null);
		passText.setLayout(null);
		add(userText);
		add(passText);
		userText.setBounds(600,100,200,40);
		passText.setBounds(600,200,200,40);
	    userText.setToolTipText("ENTER USERNAME");
	    passText.setToolTipText("ENTER PASSWORD");
		
		loginSubmitButton=new JButton("LOGIN");
		loginSubmitButton.setLayout(null);
		loginSubmitButton.setBounds(300,300,200,50);
		add(loginSubmitButton);
		
		loginPanelGoBackButton=new JButton("Back To Modes");
		loginPanelGoBackButton.setLayout(null);
		loginPanelGoBackButton.setBounds(600,300,200,50);
		add(loginPanelGoBackButton);
	}
	
}

class StudentLoginPanel extends JPanel
{
	JLabel usernameLabel,passwordLabel;
	public JTextField userText;
	public JPasswordField passText;
	JButton loginSubmitButton,loginPanelGoBackButton;
	
	StudentLoginPanel()
	{
		Color lbc=new Color(159,237,215);

		usernameLabel=new JLabel("USERNAME");
		passwordLabel=new JLabel("PASSWORD");
		usernameLabel.setLayout(null);
		passwordLabel.setLayout(null);
		usernameLabel.setFont(new Font("Arial",Font.BOLD,20));
		passwordLabel.setFont(new Font("Arial",Font.BOLD,20));
		usernameLabel.setForeground(lbc);
		passwordLabel.setForeground(lbc);
		add(usernameLabel);
		add(passwordLabel);
		usernameLabel.setBounds(350,100,500,50);
		passwordLabel.setBounds(350,200,500,50);
		
		
		userText=new JTextField();
		passText=new JPasswordField();
		userText.setLayout(null);
		passText.setLayout(null);
		add(userText);
		add(passText);
		userText.setBounds(600,100,200,40);
		passText.setBounds(600,200,200,40);
	    userText.setToolTipText("ENTER USERNAME");
	    passText.setToolTipText("ENTER PASSWORD");
		
		loginSubmitButton=new JButton("login");
		loginSubmitButton.setLayout(null);
		loginSubmitButton.setBounds(300,300,200,50);
		add(loginSubmitButton);
		
		loginPanelGoBackButton=new JButton("back to modes");
		loginPanelGoBackButton.setLayout(null);
		loginPanelGoBackButton.setBounds(600,300,200,50);
		add(loginPanelGoBackButton);
	}
	
}
class NewLoginPanel extends JPanel
{
	JLabel usernameLabel,passwordLabel;
	public JTextField userText;
	public JPasswordField passText;
	JButton loginSubmitButton,loginPanelGoBackButton,thirdBtn;
	
	NewLoginPanel()
	{
		Color lbc=new Color(159,237,215);

		usernameLabel=new JLabel("USERNAME");
		passwordLabel=new JLabel("PASSWORD");
		usernameLabel.setLayout(null);
		passwordLabel.setLayout(null);
		usernameLabel.setFont(new Font("Arial",Font.BOLD,20));
		passwordLabel.setFont(new Font("Arial",Font.BOLD,20));
		usernameLabel.setForeground(lbc);
		passwordLabel.setForeground(lbc);
		add(usernameLabel);
		add(passwordLabel);
		usernameLabel.setBounds(350,100,500,50);
		passwordLabel.setBounds(350,200,500,50);
		
		
		userText=new JTextField();
		passText=new JPasswordField();
		userText.setLayout(null);
		passText.setLayout(null);
		add(userText);
		add(passText);
		userText.setBounds(600,100,200,40);
		passText.setBounds(600,200,200,40);
	    userText.setToolTipText("ENTER USERNAME");
	    passText.setToolTipText("ENTER PASSWORD");
		
		loginSubmitButton=new JButton("Confirm");
		loginSubmitButton.setLayout(null);
		loginSubmitButton.setBounds(300,300,150,50);
		add(loginSubmitButton);
		
		thirdBtn=new JButton("Return");
		thirdBtn.setLayout(null);
		thirdBtn.setBounds(500,300,150,50);
		add(thirdBtn);
		
		loginPanelGoBackButton=new JButton("Have account?");
		loginPanelGoBackButton.setLayout(null);
		loginPanelGoBackButton.setBounds(700,300,150,50);
		add(loginPanelGoBackButton);
	}
	
}
class AdminPanelOne extends JPanel
{
	JLabel msg;
	JButton logout,create,delete,update,show;
	AdminPanelOne()
	{
		msg=new JLabel("ADMIN PANEL");
		logout=new JButton("LOGOUT");
		create=new JButton("CREATE TEST");
		delete=new JButton("DELETE TEST");
		update=new JButton("UPDATE TEST");
		show=new JButton("DISPLAY TEST");
		msg.setLayout(null);
		logout.setLayout(null);
		create.setLayout(null);
		delete.setLayout(null);
		update.setLayout(null);
		show.setLayout(null);
		add(msg);
		add(logout);
		add(create);
		add(delete);
		//add(update);
		Color dg=new Color(2,102,112);
		Color lbc=new Color(159,237,215);
		Color c2=new Color(211,247,89);

		//add(show);
		msg.setForeground(dg);
		show.setBounds(0,200,675,250);
		update.setBounds(0,450,675,250);
		create.setBounds(675,200,625,250);
		create.setBackground(lbc);
		create.setForeground(dg);
		create.setFont(new Font("Arial", Font.PLAIN, 40));
		delete.setBounds(50,200,625,250);
		delete.setBackground(lbc);
		delete.setForeground(dg);
		delete.setFont(new Font("Arial", Font.PLAIN, 40));

		logout.setBounds(620,500,100,40);
		logout.setBackground(lbc);
		msg.setBounds(500,50,800,100);
		msg.setFont(new Font("Arial",Font.BOLD,60));
		
	}
}
class Category extends JPanel
{
	public JComboBox<String> jcb;
	public JButton jb;
	//public JButton jb1;
	public JLabel jl;
	public Category()
	{
		setBackground(Color.red);
		jl=new JLabel("Select Category:");
		jl.setBounds(20,200,200,50);
		
		/*jb1=new JButton("DELETE");
		jb1.setBounds(100,400,100,50);
		jb1.setBackground(Color.red);
		jb1.setFont(new java.awt.Font("Comic Sans MS",Font.BOLD, 14));*/
		
		
	    jb=new JButton("NEXT");
		jb.setBounds(650,200,100,50);
	 	jb.setBackground(Color.cyan);
		jb.setFont(new java.awt.Font("Comic Sans MS",Font.BOLD, 14));
		
		jcb=new JComboBox();
		jcb.setBounds(150,200,300,50);
		jcb.setVisible(false);

		
		add(jcb);  add(jl);  add(jb); //add(jb1);
	}
	
}
class Section extends JPanel
{
	public JComboBox<String> jcb;
	public JButton jb;
	public JLabel jl;
	public Section()
	{
		jl=new JLabel("Select Section:");
		jl.setBounds(20,200,200,50);
		setBackground(Color.red);
		jb=new JButton("NEXT ");
		jb.setBounds(650,200,100,50);
		jb.setBackground(Color.cyan);
		jb.setFont(new java.awt.Font("Comic Sans MS",Font.BOLD, 14));
		
		jcb=new JComboBox();
		jcb.setBounds(150,200,300,50);
		jcb.setVisible(false);
		
		add(jcb);  add(jl);  add(jb);
	}
	
}
class QuestionPaper extends JPanel
{
	public JComboBox jcb;
	public JButton jb;
	public JLabel jl;
	public QuestionPaper()
	{
		jl=new JLabel("Select Question Paper:");
		jl.setBounds(20,200,200,50);
		setBackground(Color.white);
		
		jb=new JButton("nextt");
		jb.setBounds(650,200,100,50);
		//jb.setBackground(Color.red);
		jb.setFont(new java.awt.Font("Comic Sans MS",Font.BOLD, 14));
		jcb=new JComboBox();
		jcb.setBounds(200,200,300,50);
		jcb.setVisible(false);

		
		add(jcb);  add(jl);  add(jb);
	}
	
}
public class Login {

	public static void main(String[] args) {
		MainFrame mainFrame=new MainFrame("CBTS");
		mainFrame.setBounds(0,0,1350,700);
		mainFrame.setBackground(Color.green);
		mainFrame.setVisible(true);
		

	}

}
