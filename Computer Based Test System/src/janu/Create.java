package janu;
import java.awt.EventQueue;
import java.lang.*;
import javax.swing.JFrame;
import java.util.ServiceLoader;
import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;  
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Button;

import javax.swing.JTextField;

public class Create extends JPanel implements ActionListener, ItemListener
{
	//JFrame jf;
	//Container cont;
	public Category ca;
	String cnm="",snm="";
	int qpno=0;
	Section se;
	QuestionPaper qp;
	public Questions qt;
	Show sh;
	public JButton jb,gbcrt;
	public Create()
	{
		//super(s);
		//cont=getContentPane();
		//cont.setLayout(null);
		//cont.setBackground(Color.white);
		Color dg=new Color(2,102,112);
		Color lbc=new Color(159,237,215);
		Color c2=new Color(211,247,89);


		ca=new Category();
		
		se=new Section();
		qp=new QuestionPaper();
		sh=new Show();
		qt=new Questions();
		ca.setLayout(null);
		se.setLayout(null);
		qp.setLayout(null);
		sh.setLayout(null);
		qt.setLayout(null);
		ca.setBounds(0, 0, 1350, 700);
		
		se.setBounds(0, 0, 1350, 700);
		qp.setBounds(0, 0, 1350, 700);
		qt.setBounds(0, 0, 1350, 700);
		sh.setBounds(0, 0, 1350, 700);

		se.setBackground(c2);
		ca.setBackground(c2);
		qp.setBackground(c2);
		qt.setBackground(c2);

		
		ca.setVisible(false);
		ca.setBackground(c2);
		se.setVisible(false);
		qp.setVisible(false);
		qt.setVisible(false);
		sh.setVisible(false);
		jb=new JButton("Create");
		jb.setFont(new java.awt.Font("Comic Sans MS",Font.BOLD, 20));
		jb.setForeground(Color.white);                  //(Color.white);
		jb.setBackground(dg);
		jb.setBounds(200,200,400,200);
		jb.addActionListener(this);
		
		gbcrt=new JButton("admin panel");
		gbcrt.setFont(new java.awt.Font("Comic Sans MS",Font.BOLD, 20));
		gbcrt.setForeground(Color.white);                  //(Color.white);
		gbcrt.setBackground(dg);
		gbcrt.setBounds(700,200,400,200);
		gbcrt.addActionListener(this);
		
			
		ca.jb.addActionListener(this);
		se.jb.addActionListener(this);
		se.add_sec.addActionListener(this);
		se.gbs.addActionListener(this);
		qp.add_q.addActionListener(this);
		qp.gbq.addActionListener(this);
		ca.add.addActionListener(this);
		qt.add_qt.addActionListener(this);
		qt.gb.addActionListener(this);
		ca.gbc.addActionListener(this);
		//ca.jcb.addItemListener(this);
		
		add(ca); add(se); add(qp); add(jb);add(gbcrt); add(sh); add(qt);
		
		
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	@Override
	
	
	
	public void actionPerformed(ActionEvent ae) {
		String s=ae.getActionCommand();
		String catnam="",sname="";
		
		System.out.println(" action");
		
		if(s.equals("Create"))
		{
			System.out.println(" action :: ca");
			ca.setVisible(true);
			se.setVisible(false);
			qp.setVisible(false);
			sh.setVisible(false);
			jb.setVisible(false);
			gbcrt.setVisible(false);
			try
			{

			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/practice1","root","");
			Statement st=con.createStatement();			
			ResultSet rs1=st.executeQuery("select * from category");
			int i=0;
						
			while(rs1.next())
			{
				String s1=rs1.getString(2);
				ca.jcb.addItem(s1);
				i++;
			}
			
			ca.jcb.setVisible(true);
			rs1.close();
			st.close();
			con.close();
			}
			catch(Exception e)
			{
				System.out.println("ERROR   :   "+e.getMessage());
			}
			
		}
		
		
		else if(s.equals("Go_back"))
		{
			ca.setVisible(false);
			gbcrt.setVisible(true);
			jb.setVisible(true);
			
		}
		else if(s.equals("Go  back"))
		{
			se.setVisible(false);
			ca.setVisible(true);
		}
		
		else if(s.equals("Go back "))
		{
			qp.setVisible(false);
			se.setVisible(true);
		}
		else if(s.equals("add")) {
		


try{
	Class.forName("com.mysql.jdbc.driver");
}catch(ClassNotFoundException e1)
{
e1.printStackTrace();
}
String url="jdbc:mysql://localhost:3306/practice1";
String password="";
String username="root";
 cnm=ca.cat_name.getText();

System.out.println("cnm-add"+cnm);
try
{
	
Connection
con=DriverManager.getConnection(url,username,password);

System.out.println("nnn");

String qry="insert into category (cna) values ('"+cnm+"')";
Statement stmt=con.createStatement();
	 
 stmt.executeUpdate(qry);

}
	catch(SQLException e2)
	{
	e2.printStackTrace();
	}
ca.setVisible(false);
se.setVisible(true);
		}
		else if(s.equals("Go_Back"))
		{
			qt.setVisible(false);
			ca.setVisible(true);
		}
		else if(s.equals("add1")) {
		System.out.print("add1");

			try{
				Class.forName("com.mysql.jdbc.driver");
			}catch(ClassNotFoundException e1)
			{
			e1.printStackTrace();
			}
			String url="jdbc:mysql://localhost:3306/practice1";
			String password="";
			String username="root";
			catnam=cnm;
			System.out.println("add1-cat"+catnam);
			
			
			snm=se.sec_name.getText();
			
			try
			{
			int id=0;	
			Connection
			con=DriverManager.getConnection(url,username,password);
			Statement stmt=con.createStatement();
			String qry1="select cno from `category` where cna='"+catnam+"' ";
			ResultSet rs= stmt.executeQuery(qry1);
			while(rs.next())
			{
				
				id=rs.getInt("cno");
				System.out.print("cno going in section  "+id);
				
			}
			System.out.print("cno going in section  "+id);
			
			String qry="insert into `section` (cno,sna) values ('"+id+"','"+snm+"')";
			  
			 stmt.executeUpdate(qry);

			}
				catch(SQLException e2)
				{
				e2.printStackTrace();
				}
			se.setVisible(false);
			qp.setVisible(true);
					}
					
					else if(s.equals("NEXT"))
					{
						ca.setVisible(false);
						se.setVisible(true);
						qp.setVisible(false);
						sh.setVisible(false);
						jb.setVisible(false);
					
						
						try
						{
						Class.forName("com.mysql.jdbc.Driver");
						System.out.println(".......DRIVER REGISTERED............");
						
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost/practice1","root","");
						System.out.println("\n.........DATABASE CONNECTED...");
						
							catnam=(String)ca.jcb.getSelectedItem();
							cnm=catnam;
							System.out.println("cnm-next"+cnm);
									
						
						System.out.println("CATNAME:"+catnam);
						Statement st=con.createStatement();
						
						ResultSet rs1=st.executeQuery(" select sna from section where cno=(select cno from category where upper(cna)='"+catnam+"')");
						int i=0;
						
						while(rs1.next())
						{
							String s2=rs1.getString(1);
							se.jcb.addItem(s2);
							i++;
						}
						
						se.jcb.setVisible(true);
						rs1.close();
						st.close();
						con.close();
						
						}
						
						
						catch(Exception e)
						{
							
							System.out.println("\n error :"+e.getMessage());
						}

					
						ca.jcb.setVisible(true);
						se.jcb.setVisible(true);			
		}
		
		else if(s.equals("NEXT1"))
		{
			System.out.print("\n next selected");
		
			ca.setVisible(false);
			se.setVisible(false);
			qp.setVisible(true);
			sh.setVisible(false);
			jb.setVisible(false);
			try
			{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/practice1","root","");
		
	
				snm=(String)se.jcb.getSelectedItem();
				catnam=cnm;
				
				
		
			Statement st=con.createStatement();
		
			ResultSet rs1=st.executeQuery("select qpno from quep q, section s,category c  where q.cno=c.cno and q.sno=s.sno and upper(c.cna)='"+cnm+"' and upper(s.sna)='"+snm+"' ");
			int i=0;
			
			
			while(rs1.next())
			{
				int s2=rs1.getInt(1);
				qp.jcb.addItem(s2);
				i++;
				System.out.print("qpno  "+s2);
			}
			qp.jcb.setVisible(true);
			rs1.close();
			st.close();
			con.close();
			
			}
			
			
			catch(Exception e)
			{
				
				System.out.println("\n error :"+e.getMessage());
			}

		}
		else if(s.equals("add2")) {
			
								
			int x=Integer.parseInt(qp.q_name.getText());
			qpno=x;
			

			try{
				Class.forName("com.mysql.jdbc.driver");
			}catch(ClassNotFoundException e1)
			{
			e1.printStackTrace();
			}
			String url="jdbc:mysql://localhost:3306/practice1";
			String password="";
			String username="root";
			try
			{
			int c_id=0,s_id=0;	
			Connection
			con=DriverManager.getConnection(url,username,password);
			Statement stmt=con.createStatement();
			String qry1="select cno from category where cna='"+cnm+"' ";
			ResultSet rs= stmt.executeQuery(qry1);
			while(rs.next())
			{
				c_id=rs.getInt("cno");
				
			}
			 qry1="select sno from section where cno='"+c_id+"' and sna='"+snm+"'";
			 rs= stmt.executeQuery(qry1);
			while(rs.next())
			{
				s_id=rs.getInt("sno");
				
			}			

			

			}
				catch(SQLException e2)
				{
				e2.printStackTrace();
				}
			qp.setVisible(false);
			qt.setVisible(true);
					}
	

		
		else if(s.equals("add3")) {
		
			String q,o1,o2,o3,o4;
			int ans=10;
	 q=qt.qt_name.getText();
	
		o1=qt.op1.getText();
		 o2=qt.op2.getText();
		 o3=qt.op3.getText();
		 o4=qt.op4.getText();
		int m=0,n=0,qn=0;
		
		
		try {
			 ans=Integer.parseInt(qt.ans.getText());}
			catch(NumberFormatException n1) {
				ans=10;
			}
		
		try {
			 qn=Integer.parseInt(qt.q.getText());}
			catch(NumberFormatException n1) {
				qn=0;
			}
		try {
		 m=Integer.parseInt(qt.marks.getText());}
		catch(NumberFormatException n1) {
			m=0;
		}
		try {
			 n=Integer.parseInt(qt.neg.getText());}
			catch(NumberFormatException n1) {
				n=0;
			}
		
		System.out.println(m+n+q+o1+o2+m+n);
		if(q==null||o1==null||o2==null||o3==null||o4==null||m==0||n==0||qn==0) {
			JOptionPane.showMessageDialog(null,"enter all values first",null, JOptionPane.ERROR_MESSAGE);
		}
		else {
			
			if(catnam=="choose anyone") {
				catnam=ca.cat_name.getText();
				System.out.print("add11-cat"+catnam);
				}
				else {
					catnam=(String)ca.jcb.getSelectedItem();
				}
			if(sname=="choose anyone") {
				sname=se.sec_name.getText();
								}
				else {
					sname=(String)se.jcb.getSelectedItem();
				}
			qpno=Integer.parseInt(qp.q_name.getText());
			System.out.println("final cnfm "+catnam+sname+qpno);
			
			

			try{
				Class.forName("com.mysql.jdbc.driver");
			}catch(ClassNotFoundException e1)
			{
			e1.printStackTrace();
			}
			String url="jdbc:mysql://localhost:3306/practice1";
			String password="";
			String username="root";
			try
			{
			int c_id=0,s_id=0,qp_id=0;	
			Connection
			con=DriverManager.getConnection(url,username,password);
			Statement stmt=con.createStatement();
			String qry1="select cno from category where cna='"+cnm+"' ";
			ResultSet rs= stmt.executeQuery(qry1);
			while(rs.next())
			{
				c_id=rs.getInt("cno");
				
			}
			 qry1="select sno from `section` where cno='"+c_id+"' and sna='"+snm+"'";
			 rs= stmt.executeQuery(qry1);
			while(rs.next())
			{
				s_id=rs.getInt("sno");
				
			}			
			
					String qry="insert into `quep` (cno,sno,qpno,qno,qtext,opt_1,opt_2,opt_3,opt_4,ans,qmks,neg) values ('"+c_id+"','"+s_id+"','"+qpno+"','"+qn+"','"+q+"','"+o1+"','"+o2+"','"+o3+"','"+o4+"','"+ans+"','"+m+"','"+n+"')";
			
					  
			 stmt.executeUpdate(qry);
			
			 JOptionPane.showMessageDialog(null,"question added successfully",null, JOptionPane.INFORMATION_MESSAGE);
			 
			 
			 qt.qt_name.setText("");
			 qt.ans.setText("");
				qt.op1.setText("");
				 qt.op2.setText("");
				 qt.op3.setText("");
				 qt.op4.setText("");
				 qt.marks.setText("");
				 qt.neg.setText("");
				 qt.q.setText("");
			
			}
				catch(SQLException e2)
				{
					 JOptionPane.showMessageDialog(null,"invalid! enter again",null, JOptionPane.ERROR_MESSAGE);
				e2.printStackTrace();
				}
		
			
		}
		}
		}
		
	
	@Override
	public void itemStateChanged(ItemEvent ae) 
	{
	}
}


class Category extends JPanel
{
	JComboBox<String> jcb;
	JButton jb,add,gbc;
	JTextField cat_name;
	JLabel jl,add_cat;
	Category()
	{
		Color dg=new Color(2,102,112);
		Color lbc=new Color(159,237,215);
		Color c2=new Color(211,247,89);
		//setBackground(Color.white);
		jl=new JLabel("Select Category:");
		jl.setBounds(250,300,200,50);
		jb=new JButton("NEXT");
		jb.setForeground(lbc);
		jb.setBounds(730,300,100,50);
		jb.setBackground(dg);
		jb.setFont(new java.awt.Font("Comic Sans MS",Font.BOLD, 18));
		add_cat=new JLabel("Add new category: ");
		add_cat.setLayout(null);
		add_cat.setBounds(250,200,150,40);
		
		cat_name=new JTextField();
		cat_name.setLayout(null);
		cat_name.setBounds(400,200,300,40);
		
		jcb=new JComboBox();
		jcb.setBounds(400,300,300,50);
		jcb.setVisible(false);

		add=new JButton("add");
		add.setLayout(null);
			add.setBounds(730,200,70,40);
			add.setFont(new java.awt.Font("Comic Sans MS",Font.BOLD, 18));

			add.setBackground(dg);
			add.setForeground(lbc);
		gbc=new JButton("Go_back");
		gbc.setBounds(730,400,150,50);
		gbc.setForeground(lbc);
		gbc.setBackground(dg);
		gbc.setFont(new java.awt.Font("Comic Sans MS",Font.BOLD, 18));
		add(gbc);
		
		
		add(jcb);  add(jl);  
		add(add_cat);add(cat_name);	add(add);
		add(jb);
	}
	
}
class Section extends JPanel
{
	JLabel  new_sec;
JTextField sec_name;
	JComboBox<String> jcb;
	JButton jb,add_sec,gbs;
	JLabel jl;
	Section()
	{
		Color dg=new Color(2,102,112);
		Color lbc=new Color(159,237,215);
		Color c2=new Color(211,247,89);
		
		new_sec=new JLabel("Add new section: ");
		new_sec.setLayout(null);
		new_sec.setBounds(250,200,150,40);	
		sec_name=new JTextField();
		sec_name.setLayout(null);
		sec_name.setBounds(400,200,300,40);
		add(new_sec);
		add(sec_name);
		add_sec=new JButton("add1");
		add_sec.setLayout(null);
		add_sec.setBounds(750,200,70,40);
		add_sec.setBackground(dg);
		add_sec.setForeground(lbc);
		add(add_sec);
		jl=new JLabel("Select Section:");
		jl.setBounds(250,300,200,50);
		setBackground(Color.white);
		jb=new JButton("NEXT1");
		jb.setBounds(750,300,100,50);
		jb.setBackground(dg);
		jb.setForeground(lbc);
		jb.setFont(new java.awt.Font("Comic Sans MS",Font.BOLD, 14));
		
		jcb=new JComboBox();
		jcb.setBounds(400,300,300,50);
		
		gbs=new JButton("Go  back");
		gbs.setBounds(750,400,100,50);
		gbs.setBackground(dg);
		gbs.setForeground(lbc);
		gbs.setFont(new java.awt.Font("Comic Sans MS",Font.BOLD, 14));
		add(gbs);
		add(jcb);  add(jl);  add(jb);
	}
	
}
class QuestionPaper extends JPanel
{
	JComboBox<Integer> jcb;
	JButton add_q,gbq;
	JLabel jl,new_q;
	JTextField q_name;
	QuestionPaper()
	{
		Color dg=new Color(2,102,112);
		Color lbc=new Color(159,237,215);
		Color c2=new Color(211,247,89);
		new_q=new JLabel("Add new paper no: ");
		new_q.setLayout(null);
		new_q.setBounds(450,300,150,40);
		q_name=new JTextField();
		q_name.setLayout(null);
		q_name.setBounds(600,300,120,40);
		add(new_q);
		add(q_name);
		add_q=new JButton("add2");
		add_q.setLayout(null);
		add_q.setBounds(800,300,70,40);
		add_q.setBackground(dg);
		add_q.setForeground(lbc);
		add(add_q);
		jl=new JLabel("Select Question Paper:");
		jl.setBounds(150,200,200,50);
		setBackground(Color.white);

		gbq=new JButton("Go back ");
		gbq.setBounds(800,400,100,50);
		gbq.setForeground(lbc);
		gbq.setBackground(dg);
		gbq.setFont(new java.awt.Font("Comic Sans MS",Font.BOLD, 14));
		add(gbq);
		
		jcb=new JComboBox();
		jcb.setBounds(400,200,300,50);
		//add(jcb);  //add(jl);  
	}
	
}

class Questions extends JPanel
{
	//JComboBox<String> jcb;
	public JButton nx3,add_qt,gb;
	public JLabel new_qt,opt,mks,ans_l,qno;
	public JTextField qt_name,op1,op2,op3,op4,q,ans,marks,neg;
	public Questions()
	{
		Color dg=new Color(2,102,112);
		Color lbc=new Color(159,237,215);
		Color c2=new Color(211,247,89);
		new_qt=new JLabel("Add question: ");
		new_qt.setForeground(dg);
		new_qt.setLayout(null);
		new_qt.setBounds(150,100,150,40);
		qt_name=new JTextField();
		qt_name.setForeground(dg);

		qt_name.setLayout(null);
		qt_name.setBounds(320,100,250,40);
		add(new_qt);
		add(qt_name);
		qno=new JLabel("question number:");
		qno.setForeground(dg);

		qno.setLayout(null);
		qno.setBounds(150,50,150,40);
		q=new JTextField();
		q.setLayout(null);
		q.setBounds(320,50,100,40);
		add(qno);add(q);
		opt=new JLabel("Enter 4 options");
		opt.setForeground(dg);

		opt.setLayout(null);
		opt.setBounds(150,200,150,40);
		op1=new JTextField();
		op1.setLayout(null);
		op1.setBounds(320,200,100,40);
		op2=new JTextField();
		op2.setLayout(null);
		op2.setBounds(440,200,100,40);
		op3=new JTextField();
		op3.setLayout(null);
		op3.setBounds(560,200,100,40);
		op4=new JTextField();
		op4.setLayout(null);
		op4.setBounds(680,200,100,40);
		op1.setForeground(dg);
		op2.setForeground(dg);
		op3.setForeground(dg);
		op4.setForeground(dg);

	add(opt);	add(op1);add(op2);add(op3);add(op4);

	ans_l=new JLabel("Enter correct answer");
	ans_l.setLayout(null);
	ans_l.setBounds(150,300,150,40);
	ans=new JTextField();
	ans.setLayout(null);
	ans.setBounds(320,300,100,40);
	mks=new JLabel("Enter total and negative marks");
	mks.setForeground(dg);

	mks.setLayout(null);
	mks.setBounds(100,400,250,40);
	marks=new JTextField();
	marks.setLayout(null);
	marks.setBounds(370,400,80,40);
	neg=new JTextField();
	neg.setLayout(null);
	neg.setBounds(460,400,80,40);
	add(ans_l);add(ans);
	add(mks);add(marks);add(neg);
		add_qt=new JButton("add3");
		add_qt.setBackground(dg);
		add_qt.setForeground(lbc);
		add_qt.setLayout(null);
		add_qt.setBounds(400,500,70,40);
		add(add_qt);
		gb=new JButton("Go_Back");
		gb.setBackground(dg);
		gb.setForeground(lbc);
		gb.setLayout(null);
		gb.setBounds(400,600,70,40);
		add(gb);
		

	}
	
}


class Show extends JPanel
{
 JScrollPane jsp=null;
}
/*public class Create
{
	public static void main(String[] args) 
	{
		MyDisplay mf=new MyDisplay("Create");
		mf.setVisible(true);
		mf.setSize(800,600);
		mf.setLocation(50,50);
	}
} 
*/