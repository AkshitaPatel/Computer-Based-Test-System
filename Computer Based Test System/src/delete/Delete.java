package delete;

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

public class Delete extends JPanel implements ActionListener, ItemListener
{
	JFrame jf;
	Container cont;
	Category ca;

	Section se;
	QuestionPaper qp;
	Questions qt;
	Show sh;
	public JButton jb,bk;
	String cname,sname;
	public Delete()
	{
		//super(s);
		//cont=getContentPane();
		//cont.setLayout(null);
		//cont.setBackground(Color.white);
		
		ca=new Category();
		Color dg=new Color(2,102,112);
		Color lbc=new Color(159,237,215);
		Color c2=new Color(211,247,89);
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
		
		se.setVisible(false);
		qp.setVisible(false);
		qt.setVisible(false);
		sh.setVisible(false);
		
		jb=new JButton("Delete");
		jb.setFont(new java.awt.Font("Comic Sans MS",Font.BOLD, 20));
		jb.setForeground(Color.white);                  //(Color.white);
		jb.setBackground(new Color(128,0,0));
		jb.setBounds(400,300,200,100);
		jb.addActionListener(this);
		
		bk=new JButton("back to admin panel");
		bk.setFont(new java.awt.Font("Comic Sans MS",Font.BOLD, 20));
		bk.setForeground(Color.white);                  //(Color.white);
		bk.setBackground(new Color(128,0,0));
		bk.setBounds(650,300,200,100);
		bk.addActionListener(this);
		add(bk);
		
			
		ca.jb.addActionListener(this);
		se.jb.addActionListener(this);
		se.add_sec.addActionListener(this);
		qp.add_q.addActionListener(this);
		qp.jb.addActionListener(this);
		ca.add.addActionListener(this);
		qt.add_qt.addActionListener(this);
		
		//ca.jcb.addItemListener(this);
		
		add(ca); add(se); add(qp); add(jb);add(sh);//add(qt);
		
		
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	@Override
	
	
	
	public void actionPerformed(ActionEvent ae) {
		String s=ae.getActionCommand();
		String catnam="",sname="";
		
		
		
		if(s.equals("Delete"))
		{
			ca.setVisible(true);
			se.setVisible(false);
			qp.setVisible(false);
			sh.setVisible(false);
			jb.setVisible(false);
			bk.setVisible(false);
			
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
		
		
		
		
		
		
		else if(s.equals("delete")) {
			
System.out.println("delete");

try{
	Class.forName("com.mysql.jdbc.driver");
}catch(ClassNotFoundException e1)
{
e1.printStackTrace();
}
String url="jdbc:mysql://localhost:3306/practice1";
String password="";
String username="root";
String x=ca.cat_name.getText();
int id=0;
try
{
	
Connection
con=DriverManager.getConnection(url,username,password);

Statement stmt=con.createStatement();
String qry1="select cno from `category` where cna='"+x+"' ";
ResultSet rs= stmt.executeQuery(qry1);
while(rs.next())
{
	id=rs.getInt("cno");
	
}
System.out.println("id of cno"+id);
 qry1="delete from `category` where cna='"+x+"' ";
stmt.executeUpdate(qry1);

String qry2="delete from `section` where cno='"+id+"' ";
stmt.executeUpdate(qry2);
String qry3="delete from `quep` where cno='"+id+"' ";
stmt.executeUpdate(qry3);
JOptionPane.showMessageDialog(null,"deleted successfully",null, JOptionPane.INFORMATION_MESSAGE);

}
	catch(SQLException e2)
	{
	e2.printStackTrace();
	}
	ca.setVisible(false);
	bk.setVisible(true);
	jb.setVisible(true);
		}
				
		else if(s.equals("delete1")) {
			System.out.println("delete1");

			try{
				Class.forName("com.mysql.jdbc.driver");
			}catch(ClassNotFoundException e1)
			{
			e1.printStackTrace();
			}
			String url="jdbc:mysql://localhost:3306/practice1";
			String password="";
			String username="root";
			catnam=(String)ca.jcb.getSelectedItem();
			String x=se.sec_name.getText();
			try
			{
			int id=0;	
			Connection
			con=DriverManager.getConnection(url,username,password);
			Statement stmt=con.createStatement();
			String qry1="select sno from `section` where sna='"+x+"' ";
			ResultSet rs= stmt.executeQuery(qry1);
			while(rs.next())
			{
				id=rs.getInt("sno");
				
			}
			qry1="delete from `section` where sno='"+id+"' ";
			stmt.executeUpdate(qry1);
			qry1="delete from `quep` where sno='"+id+"' ";
			stmt.executeUpdate(qry1);
						JOptionPane.showMessageDialog(null,"deleted successfully",null, JOptionPane.INFORMATION_MESSAGE);


			}
				catch(SQLException e2)
				{
				e2.printStackTrace();
				}
			se.setVisible(false);
			
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
						cname=catnam;
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
			//System.out.println("\n.........DATABASE CONNECTED...");
			sname=(String)se.jcb.getSelectedItem();
			//System.out.println(ina);
			Statement st=con.createStatement();
			catnam=(String)ca.jcb.getSelectedItem();
			System.out.println("now :"+catnam);
			System.out.println("now :"+sname);
			ResultSet rs1=st.executeQuery("select qpno from quep q, section s,category c  where q.cno=c.cno and q.sno=s.sno and upper(c.cna)='"+catnam+"' and upper(s.sna)='"+sname+"' ");
			int i=0;
			
			
			while(rs1.next())
			{
				String s2=rs1.getString(1);
				qp.jcb.addItem(s2);
				i++;
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

	
		else if(s.equals("NEXT2"))
		{

			System.out.print("\n next selected");
			
				try
			{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/practice1","root","");
		
	
				sname=(String)se.jcb.getSelectedItem();
				catnam=(String)ca.jcb.getSelectedItem();
				System.out.print("add11-cat"+catnam);
		Object	qpno= qp.jcb.getSelectedItem();

			Statement st=con.createStatement();
			System.out.println("now :"+catnam);
			System.out.println("now :"+sname);
			ResultSet rs1=st.executeQuery("select qtext from quep q, section s,category c  where q.cno=c.cno and q.sno=s.sno and upper(c.cna)='"+catnam+"' and upper(s.sna)='"+sname+"' and upper(q.qpno)='"+qpno+"' ");
			int i=0;
						
			while(rs1.next())
			{
				String s2=rs1.getString(1);
				qt.jcb.addItem(s2);
				i++;
				System.out.print("qpno  "+s2);
			}
			qt.jcb.setVisible(true);
			rs1.close();
			st.close();
			con.close();
			
			}
			
			
			catch(Exception e)
			{
				
				System.out.println("\n error :"+e.getMessage());
			}


			
			ca.setVisible(false);
			se.setVisible(false);
			qp.setVisible(false);
			qt.setVisible(true);
			jb.setVisible(false);
		}
		
		else if(s.equals("delete2")) {
			System.out.println("works");
	
	int qpno= Integer.parseInt(qp.q_name.getText());
       			
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
				
				sname=(String)se.jcb.getSelectedItem();
			
				cname=(String)ca.jcb.getSelectedItem();
				int c_id=0,s_id=0;
			Connection
			con=DriverManager.getConnection(url,username,password);
			Statement stmt=con.createStatement();
			String qry1="select cno from category where cna='"+cname+"' ";
			ResultSet rs= stmt.executeQuery(qry1);
			while(rs.next())
			{
				c_id=rs.getInt("cno");
				
			}
			 qry1="select sno from section where cno='"+c_id+"' and sna='"+sname+"'";
			 rs= stmt.executeQuery(qry1);
			while(rs.next())
			{
				s_id=rs.getInt("sno");
				
			}			
		System.out.println(sname+cname+qpno+"   "+c_id+" "+s_id);
		qry1="delete from quep where qpno="+qpno+" and cno="+c_id+"and sno="+s_id;
			stmt.executeUpdate(qry1);
			
			
			
		 JOptionPane.showMessageDialog(null,"Deleted successfully",null, JOptionPane.INFORMATION_MESSAGE);
			}
				catch(SQLException e2)
				{
					 JOptionPane.showMessageDialog(null,"invalid! enter again",null, JOptionPane.ERROR_MESSAGE);
				e2.printStackTrace();
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
	JButton jb,add;
	JTextField cat_name;
	JLabel jl,add_cat;
	Category()
	{
		//setBackground(Color.white);
		
		Color dg=new Color(2,102,112);
		Color lbc=new Color(159,237,215);
		Color c2=new Color(211,247,89);
		jl=new JLabel("Select Category:");
		jl.setBounds(250,200,200,50);
		jb=new JButton("NEXT");
		jb.setBounds(750,200,100,50);
		jb.setBackground(dg);
		//jb.setBackground(Color.cyan);
		jb.setFont(new java.awt.Font("Comic Sans MS",Font.BOLD, 14));
		add_cat=new JLabel("delete category: ");
		add_cat.setLayout(null);
		add_cat.setBounds(250,100,150,40);
		
		cat_name=new JTextField();
		cat_name.setLayout(null);
		cat_name.setBounds(400,100,120,40);
		
		jcb=new JComboBox();
		jcb.setBounds(400,200,300,50);
		jcb.setVisible(false);

		add=new JButton("delete");
		add.setLayout(null);
		add.setBackground(dg);
			add.setBounds(520,100,70,40);
		
		
		
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
	JButton jb,add_sec;
	JLabel jl;
	Section()
	{
		Color dg=new Color(2,102,112);
		Color lbc=new Color(159,237,215);
		Color c2=new Color(211,247,89);
		
		new_sec=new JLabel("Delete section: ");
		new_sec.setLayout(null);
		new_sec.setBounds(250,100,150,40);	
		sec_name=new JTextField();
		sec_name.setLayout(null);
		sec_name.setBounds(400,100,120,40);
		add(new_sec);
		add(sec_name);
		add_sec=new JButton("delete1");
		add_sec.setLayout(null);
		add_sec.setBackground(dg);
		add_sec.setBounds(520,100,90,40);
		add(add_sec);
		jl=new JLabel("list of Section:");
		jl.setBounds(250,200,200,50);
		setBackground(dg);
		jb=new JButton("NEXT1");
		jb.setBounds(750,200,100,50);
		jb.setBackground(dg);
		jb.setFont(new java.awt.Font("Comic Sans MS",Font.BOLD, 14));
		
		jcb=new JComboBox();
		jcb.setBounds(400,200,300,50);
		add(jcb);  add(jl);  //add(jb);
	}
	
}
class QuestionPaper extends JPanel
{
	JComboBox<String> jcb;
	JButton jb,add_q;
	JLabel jl,new_q;
	JTextField q_name;
	QuestionPaper()
	{
		Color dg=new Color(2,102,112);
		Color lbc=new Color(159,237,215);
		Color c2=new Color(211,247,89);
		new_q=new JLabel("Delete question paper: ");
		new_q.setLayout(null);
		new_q.setBounds(250,100,150,40);
		q_name=new JTextField();
		q_name.setLayout(null);
		q_name.setBounds(400,100,120,40);
		add(new_q);
		add(q_name);
		add_q=new JButton("delete2");
		add_q.setLayout(null);
		add_q.setBackground(dg);
		add_q.setBounds(520,100,90,40);
		add(add_q);
		jl=new JLabel("List of Question Paper:");
		jl.setBounds(250,200,200,50);
		setBackground(Color.white);
		
		jb=new JButton("NEXT2");
		jb.setBounds(750,200,100,50);
		jb.setBackground(dg);
		jb.setFont(new java.awt.Font("Comic Sans MS",Font.BOLD, 14));
		jcb=new JComboBox();
		jcb.setBounds(400,200,300,50);
		add(jcb);  add(jl);  //add(jb);
	}
	
}

class Questions extends JPanel
{
	JComboBox<String> jcb;
	JButton add_qt;
	JLabel new_qt;
	
	Questions()
	{
		new_qt=new JLabel("Delete question: ");
		new_qt.setLayout(null);
		new_qt.setBounds(150,100,150,40);
		add(new_qt);
		jcb=new JComboBox();
		jcb.setBounds(200,200,300,50);
		add(jcb); 
        add_qt=new JButton("delete3");
		add_qt.setLayout(null);
		add_qt.setBounds(400,300,100,40);
		add(add_qt);

	}
	
}


class Show extends JPanel
{
 JScrollPane jsp=null;
}
/*public class delete
{
	public static void main(String[] args) 
	{
		MyDisplay mf=new MyDisplay("Delete");
		mf.setVisible(true);
		mf.setSize(800,600);
		mf.setLocation(50,50);
	}
} */
