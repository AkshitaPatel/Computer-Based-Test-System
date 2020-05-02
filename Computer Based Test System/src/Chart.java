////////////////  PIE CHART //////////////////////////////////////////////////////
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
 
public class Chart extends ApplicationFrame {  
   public Chart( String title ) throws Exception{
      super( title ); 
      setContentPane(createDemoPanel( ));
   }  
   private static PieDataset createDataset( ) throws Exception{
	   Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/chart","root","");
		Statement statement=con.createStatement();			
	       ResultSet resultSet = statement.executeQuery("select * from mobile_data" );
      DefaultPieDataset dataset = new DefaultPieDataset( );
      while( resultSet.next( ) ) 
      {
          dataset.setValue( 
          resultSet.getString( "mobile_brand" ) ,
          Double.parseDouble( resultSet.getString( "unit_sale" )));
       }
	
      return dataset; 
      }
   
   private static JFreeChart createChart( PieDataset dataset ) {
      JFreeChart chart = ChartFactory.createPieChart(      
         "Mobile Sales",   // chart title 
         dataset,          // data    
         true,             // include legend   
         true, 
         false);
      return chart;
   }
   
   public static JPanel createDemoPanel( ) throws Exception{
      JFreeChart chart = createChart(createDataset( ) );  
      return new ChartPanel( chart ); 
   }
   public static void main( String[ ] args ) throws Exception{
      Chart demo = new Chart( "Mobile Sales" );  
      demo.setSize( 800 , 600 );    
      RefineryUtilities.centerFrameOnScreen( demo );    
      demo.setVisible( true ); 
   }
}
