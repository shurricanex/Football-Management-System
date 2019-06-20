package myMenu;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MyTable {
	 JFrame f; 
	    // Table 
	    JTable j; 
	  
	    // Constructor 
	    MyTable() 
	    { 
	        // Frame initiallization 
	        f = new JFrame(); 
	  
	        // Frame Title 
	        f.setTitle("JTable Example"); 
	  
	        // Data to be displayed in the JTable 
	        String[][] data = { 
	            { "Manchester United", "Chelsea FC", "July 15 2019" }, 
	            { "Manchester City", "Liverpool FC", "July 16 2019" } 
	        }; 
	  
	        // Column Names 
	        String[] columnNames = { "Name", "Roll Number", "Department" }; 
	  
	        // Initializing the JTable 
	        j = new JTable(data, columnNames); 
	        j.setBounds(30, 40, 200, 300); 
	  
	        // adding it to JScrollPane 
	        JScrollPane sp = new JScrollPane(j); 
	        f.add(sp); 
	        // Frame Size 
	        f.setSize(500, 200); 
	        // Frame Visible = true 
	        f.setVisible(true); 
}
}
