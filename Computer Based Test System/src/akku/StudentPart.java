package akku;

//package jframe;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

//import QuestionPaperPackage.Subp1;
//import QuestionPaperPackage.resultPanel;

public class StudentPart extends JPanel implements ActionListener, ItemListener
{
	//public JPanel jf;
	//public Container cont;
	public Category ca;
	public Section se;
	public int cnd=1,snd=1,intQnd=1;
	public QuestionPaper qp;
	//public Show sh;
    public String catnam,sname,qnd;
	public JButton jb;
	public GraphPanel sh;
	public StudentPart()
	{
		//super(s);
		this.setVisible(true);
		this.setLayout(null);
		//cont=getContentPane();
		//cont.setLayout(null);
		//cont.setBackground(Color.white);
		//cont.setVisible(true);
		
		ca=new Category();
		se=new Section();
		qp=new QuestionPaper();
		sh=new GraphPanel();
		
		ca.setLayout(null);
		se.setLayout(null);
		qp.setLayout(null);
		sh.setLayout(null);
		
		ca.setBounds(0, 0, 1100, 400);
		se.setBounds(0, 0, 1100, 400);
		qp.setBounds(0, 0, 1100, 400);
		sh.setBounds(0, 0, 1100, 400);

		sh.setBackground(Color.PINK);
		
		ca.setVisible(false);
		se.setVisible(false);
		qp.setVisible(false);
		sh.setVisible(false);
		
		jb=new JButton("DISPLAY");
		jb.setFont(new java.awt.Font("Comic Sans MS",Font.BOLD, 20));
		//jb.setLayout(null);
		jb.setForeground(Color.white);                  //(Color.white);
		jb.setBackground(new Color(128,0,0));
		jb.setBounds(200,200,200,100);
		jb.addActionListener(this);
		jb.setVisible(true);
		
		
			
		ca.jb.addActionListener(this);
		//ca.jb1.addActionListener(this);
		se.jb.addActionListener(this);
		qp.jb.addActionListener(this);
		sh.submitt.addActionListener(this);
		
		ca.jcb.addItemListener(this);
		
		
		add(ca); add(se); add(qp); add(jb);add(sh);
		
		
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	@Override
	
	
	
	public void actionPerformed(ActionEvent ae) {
		
		String s=ae.getActionCommand();
		
		
		if(s.equals("DISPLAY"))
		{
			System.out.println("djp");
			ca.setVisible(true);
			se.setVisible(false);
			qp.setVisible(false);
			sh.setVisible(false);
			jb.setVisible(false);
			
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
				System.out.println("ERROR   :  display "+e.getMessage());
			}
			
			
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
			System.out.println("CATNAME:djp");
			System.out.println("CATNAME:"+catnam);
			System.out.println("CATNAME:djp");
			Statement st=con.createStatement();
			
			ResultSet rs1=st.executeQuery("select sna from section where cno=(select cno from category where upper(cna)='"+catnam+"')");
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
			
			st.close();
			con.close();
			
			}
			
			
			catch(Exception e)
			{
				
				System.out.println("\n error :next1  "+e.getMessage());
			}

			
			ca.jcb.setVisible(true);
			se.jcb.setVisible(true);			
		}
		
		else if(s.equals("NEXT "))
		{
			ca.setVisible(false);
			se.setVisible(false);
			qp.setVisible(true);
			sh.setVisible(false);
			jb.setVisible(false);

			

			try
			{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/practice1","root","");
			sname=(String)se.jcb.getSelectedItem();
			Statement st=con.createStatement();
			catnam=(String)ca.jcb.getSelectedItem();
			System.out.println("now :"+catnam);
			System.out.println("now :"+sname);
			ResultSet rs1=st.executeQuery("select qpno from quep q, section s,category c  where q.cno=c.cno and q.sno=s.sno and upper(cna)='"+catnam+"' and upper(sna)='"+sname+"' group by qpno;");
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
			st.close();
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
		
		else if(s.equals("nextt"))
		{

			ca.setVisible(false);
			se.setVisible(false);
			qp.setVisible(false);
			sh.setVisible(true);
			jb.setVisible(false);


		}
			
	
		
	}
//	@Override
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

////////////////////////////////////////////////////////////////////////////***********************



///////////////////////////////////////////////////////////////////////
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
		jb.setBackground(Color.red);
		jb.setFont(new java.awt.Font("Comic Sans MS",Font.BOLD, 14));
		jcb=new JComboBox();
		jcb.setBounds(200,200,300,50);
		jcb.setVisible(false);

		
		add(jcb);  add(jl);  add(jb);
	}
	
}

class Show extends JPanel
{

	public JScrollPane jsp=null;
}

/*public class StudentPart
{

	public MyDisplay mf;
	//public void StudentPartMethod()
	public static void main(String []args)
	{
		mf=new MyDisplay();
		mf.setLayout(null);
		mf.setBackground(Color.red);
		mf.setVisible(true);
		mf.setSize(800,600);
		JLabel jl=new JLabel("HELLO");
		jl.setBounds(100,100,100,100);
		mf.setLocation(50,50);
		mf.add(jl);
	}
}
*/

class GraphPanel extends JPanel 
{
	JButton submitt;
	GraphPanel()
	{
		submitt=new JButton("submitt");
		add(submitt);
		
	}
}

class Qsubp extends JPanel
{
	JRadioButton jb[]=new JRadioButton[4];
    ButtonGroup bg=new ButtonGroup();
	JLabel jl;
   Qsubp()
   {
	   
   }
}
	