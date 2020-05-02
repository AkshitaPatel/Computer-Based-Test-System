package QuestionPaperPackage;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

//import com.mysql.jdbc.ResultSet;


public class QPaper extends JFrame
{
	public QPaper(String catnam,String sname,String qnd,String fu)
	{
		
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	
	//	QPaper tsp=new QPaper();
		GraphPanel gp=new GraphPanel(catnam,sname,qnd,fu);
		JScrollPane sp=new JScrollPane(gp,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		this.add(sp);
		this.setVisible(true);
	}
}

class GraphPanel extends JPanel implements ActionListener
{
	
	public JPanel mp=new JPanel();
	public Subp1 p[]=new Subp1[10];
	public JLabel jl,jl1;
	public JButton Button;
	public Connection conn;
	public Statement stmt;
	public int c;
	public String arr[]=new String[100];
	public String opt[][]=new String[100][4];
	public int ans[]=new int[100];
	public int ansdb[]=new int[100];
	public int mks[]=new int[100];
	public int neg[]=new int[100];
	String fut,qndt,snamet,catnamt;
	int cnot,snot,qpnot;
	//public resultPanel rp;
	
	public GraphPanel(String catnam,String sname,String qnd,String fu)
	{
		fut=fu;qndt=qnd;snamet=sname;catnamt=catnam;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/practice1","root","");
			//Class.forName("oraclejdbc.driver.OracleDriver");
			//conn=DriverManager.getConnection("jdbc:oracle:thin@localhost:8080:xe","sys","janvi");
	        stmt=conn.createStatement();
	       
	       int abc=Integer.parseInt(qnd);
	       qpnot=abc;
	       System.out.println(" abc:"+abc);
	       catnam=catnam.toUpperCase();
	       sname=sname.toUpperCase();
	       ResultSet rs=stmt.executeQuery("SELECT * FROM quep WHERE cno in(select cno from category where upper(cna)='"+catnam+"') AND sno in(select sno from section where upper(sna)='"+sname+"') and qpno="+abc);
	       /*ResultSet rs1=stmt.executeQuery("select cno from category where upper(cna)='"+catnam+"'");
	       
	       ResultSet rs2=stmt.executeQuery("select sno from section where upper(sna)='"+sname+"'");

	       //ResultSet rs=stmt.executeQuery("select q.* from quep q, section s,category c  where q.cno=c.cno and q.sno=s.sno and upper(c.cna)='"+catnam+"' and upper(s.sna)='"+sname+"' and qpno="+abc);
	       
	       while(rs1.next())
	       {
	    	   cnot=rs1.getInt(1);
	       }
	       while(rs2.next())
	       {
	    	   snot=rs2.getInt(1);
	       }*/
	       int index=0;
	        while(rs.next()) {
	        	c++;
	        	arr[index]=rs.getString(5);
	        	ansdb[index]=rs.getInt(10);
	        	mks[index]=rs.getInt(11);
	        	neg[index]=rs.getInt(12);
	        	System.out.println(ansdb[index]);
	        	int column=0;
	        	while(column!=4) 
	        	{
	        		opt[index][column]=rs.getString(6+column);
	        		column++;
	        	}
	        	index++;
	        }
	        rs.close();
		    ResultSet rs1=stmt.executeQuery("select cno from category where upper(cna)='"+catnam+"'");
		    while(rs1.next())
		       {
		    	   cnot=rs1.getInt(1);
		    	   System.out.println("iiiiiiiiiiiii  "+cnot);
		       }
		    rs1.close();
		       ResultSet rs2=stmt.executeQuery("select sno from section where upper(sna)='"+sname+"'");
		       while(rs2.next())
		       {
		    	   snot=rs2.getInt(1);
		       }
		       rs2.close();
		}
		catch(Exception e1) {
			
		}
	
            
		int j=c*170+250; 
		this.setPreferredSize(new Dimension(1500,j));
		

		add(mp);
		
		mp.setLayout(null);
		mp.setLocation(100,0);
		mp.setPreferredSize(new Dimension(1500,j));
		mp.setBackground(Color.white);
		
		jl1=new JLabel("TEST");
        jl1.setBounds(340,25,400,50);
        jl1.setFont(new Font("Tahoma", Font.BOLD, 50));
  		jl1.setBackground(new Color(255, 255, 240));
  		mp.add(jl1);
		int k=0;
		for(int i=0;i<c;i++) {
			p[i]=new Subp1(opt,i);
			mp.add(p[i]);
			p[i].setLayout(null);
			p[i].setLocation(100,0);	
			p[i].setBounds(100,100+k,700,150);
			p[i].setBackground(Color.green);
			

			jl=new JLabel(arr[i]);
	        jl.setBounds(20,10,339,20);
	  		jl.setBackground(new Color(255, 255, 240));
	  		p[i].add(jl);
		   
     		k+=170;
		 }
		
     
		 Button = new JButton("Submit");
		 Button.setFont(new Font("Tahoma",Font.PLAIN, 25));
		 Button.setBounds(530,k+100,200,50);
		 Button.setBackground(new Color(255, 255, 240));
		 mp.add(Button);
		 Button.addActionListener(this);
		 /*int t;
			for(int i=1;i<9;i++)
			{
				t=i-1;
				if(i%4==1)
				{
					p[t]=new Subp1(opt,t);
					mp.add(p[t]);
					p[t].setLayout(null);
					//p[t].setLocation(100,0);	
					p[t].setBounds(100,10+k,500,140);
					p[t].setBackground(Color.green);
					jl=new JLabel(arr[t]);
			        jl.setBounds(20,10,339,20);
			  		jl.setBackground(new Color(255, 255, 240));
			  		p[t].add(jl);
				}
				else if(i%4==2)
				{
					p[t]=new Subp1(opt,t);
					mp.add(p[t]);
					p[t].setLayout(null);
					//p[t].setLocation(100,0);	
					p[t].setBounds(650,10+k,500,140);
					p[t].setBackground(Color.green);
					jl=new JLabel(arr[t]);
			        jl.setBounds(20,10,339,20);
			  		jl.setBackground(new Color(255, 255, 240));
			  		p[t].add(jl);
			  		k+=150;
				}
				else if(i%4==3)
				{
					p[t]=new Subp1(opt,t);
					p[t].setLayout(null);
					mp.add(p[t]);
					//p[t].setLocation(100,0);	
					p[t].setBounds(100,10+k,500,140);
					p[t].setBackground(Color.green);
					jl=new JLabel(arr[t]);
			        jl.setBounds(20,10,339,20);
			  		jl.setBackground(new Color(255, 255, 240));
			  		p[t].add(jl);
				}
				else if(i%4==0)
				{
					p[t]=new Subp1(opt,t);
					mp.add(p[t]);
					p[t].setLayout(null);
					//p[t].setLocation(100,0);	
					p[t].setBounds(650,10+k,500,140);
					p[t].setBackground(Color.green);
					jl=new JLabel(arr[t]);
			        jl.setBounds(20,10,339,20);
			  		jl.setBackground(new Color(255, 255, 240));
			  		p[t].add(jl);
			  		k+=150;
				}
			}*/
	}
	
	public void actionPerformed(ActionEvent e) {
        String s=e.getActionCommand();
		int qa=0,tr=0,wr=0;
		int om=0;int flag=0;int tm=0;
		
		if(s.equals("Submit")) {
		
	          for(int i=0;i<c;i++) {
	        	  tm=tm+mks[i];
                for(int j=0;j<4;j++) {				
			       if(p[i].jb[j].isSelected()) {
			    	   flag=1;
			    	   qa++;
			    	    try {
			  			// Class.forName("com.mysql.jdbc.Driver");
			  			 //conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
			  	         //stmt.executeUpdate("update student set std_ans='"+j+"' where qno='"+(i+1)+"' ");
			  	         ans[i]=j+1; 
			  	         if(ans[i]==ansdb[i]){
			  	        	 System.out.println("true"+i);
			  	        	 tr++;
			  	        	 om=om+mks[i];
			  	         }
			  	         else
			  	         {
			  	        	 wr++;
			  	        	 om=om-neg[i];
			  	         }
			  		
			    	    }catch(Exception e1) {
			  		    }
			  	   }
	            }
	         }
	          String rmk;
	          if(om>=0.4*tm)
	        	  rmk="pass";
	          else
	        	  rmk="fail";
	          
	         // rp=new resultPanel(ans,ansdb,c,tr,wr,qa);add(rp);
	        //  mp.setVisible(false);
	         try{
	        	 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/practice1","root","");
	         
				Statement stmt=con.createStatement();
			      
			 String sql="insert into result(USERNAME,CNO,SNO,QPNO,TMKS,OMKS,REMARKS) values('"+fut+"',"+cnot+","+snot+","+qpnot+","+tm+","+om+",'"+rmk+"')";
			      stmt.executeUpdate(sql);
	         }catch(Exception eE){}
	          
	          try
	  		{
	  		 Chart demo = new Chart( "Analysis ",qa,tr,wr ,c); 
	  		
	  	     demo.setSize( 800 , 600 );
	  	     
	  	    JLabel ds=new JLabel("TOTAL :"+c+"SKIPPED :"+(c-qa)+" CORRECT :"+tr+" INCORRECT :"+wr);
	  		 demo.setLayout(null);
	  		 ds.setBounds(10,50,500,10);
	  		 ds.setVisible(true);
	  		 demo.add(ds);

	  	     RefineryUtilities.centerFrameOnScreen( demo );
	  	     
	  	     demo.setVisible( true ); 
	  		}
	  		catch(Exception ex)
	  		{
	  			System.out.println("ERROR:"+ex.getMessage());
	  		}
	          //rp.setVisible(true);
	          
	          
		 }
	}
}
	
/*class resultPanel extends JPanel{
	
	resultPanel(int[] ans,int[] ansdb,int c,int tr,int wr,int qa){
	    /*JPanel temp=new JPanel();
		temp.setPreferredSize(new Dimension(1500,1500));
		add(temp);
		temp.setBackground(Color.pink);
		temp.setLayout(null);
		JLabel attempt,corr,wrong;
		attempt=new JLabel("Attempted:"+qa);
		corr=new JLabel("corrected:"+tr);
		wrong=new JLabel("Wrong: "+wr);
		temp.add(attempt);
		temp.add(corr);
		temp.add(wrong);
		attempt.setFont(new java.awt.Font("Comic Sans MS",Font.BOLD, 20));
		corr.setFont(new java.awt.Font("Comic Sans MS",Font.BOLD, 20));
		wrong.setFont(new java.awt.Font("Comic Sans MS",Font.BOLD, 20));
		attempt.setBackground(Color.BLACK);
		corr.setBackground(Color.BLACK);
		wrong.setBackground(Color.BLACK);
		attempt.setBounds(0,0,100,50);
		corr.setBounds(0,200,100,50);
		wrong.setBounds(0,300,100,50);
		
		*/
		
	 	




class Chart extends ApplicationFrame { 
    static int qa;
	static int tr;
	static int wr;
	static int c;
  public Chart( String title,int qa,int tr,int wr ,int c) throws Exception{
     super( title ); 
     this.qa=qa; this.c=c; this.tr=tr; this.wr=wr;
     setContentPane(createDemoPanel( ));
  }  
  private static PieDataset createDataset( ) throws Exception{
     DefaultPieDataset dataset = new DefaultPieDataset( );
         dataset.setValue( "Skipped" ,c-qa);
         
         
         dataset.setValue( 
                 "Correct" ,tr);
         
         dataset.setValue( 
                 "Incorrect" ,wr);	
     return dataset; 
     }
  
  private static JFreeChart createChart( PieDataset dataset ) {
     JFreeChart chart = ChartFactory.createPieChart(      
        "Result Analysis",   // chart title 
        dataset,          // data    
        true,             // include legend   
        true, 
        false);
     return chart;
  }
  
  public static JPanel createDemoPanel( ) throws Exception{
     JFreeChart chart = createChart(createDataset( ) );  
     return new ChartPanel(chart); 
  }
     
}


















class Subp1 extends JPanel
{
	JRadioButton jb[]=new JRadioButton[4];
    ButtonGroup bg=new ButtonGroup();
	JLabel jl;
	Connection conn;
	Statement stmt;
    int k=0;
    Subp1(String[][] opt,int row)
	{ 
    	 for(int i=0;i<4;i++) {
    	
    		jb[i]=new JRadioButton(opt[row][i]);
      	    add(jb[i]);
      	    
      	    if(i==0) {
      	     jb[i].setBounds(20,50,100, 20);
      	    }
      	    if(i==1) {
      	     jb[i].setBounds(20,100,100, 20);	
      	    }
      	    if(i==2) {
      	    	jb[i].setBounds(160,50,100, 20);	
      	    }
      	    if(i==3) {
      	    	jb[i].setBounds(160,100,100, 20);	
      	    }
      	    
	        jb[i].setBackground(new Color(255, 255, 255));
      	    jb[i].setVisible(true);
      	    bg.add(jb[i]);
      	    
      	}
		
	}
}

