package Record;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.mysql.cj.xdevapi.PreparableStatement;

import member.DBconnection;

public class RecordMatchScore {

	public RecordMatchScore(int mid,JLabel label1, JLabel label2) {
		String score1 = label1.getText();
		String score2 = label2.getText();
		// TODO Auto-generated constructor stub
		String query = "UPDATE `matches`set`score`=? WHERE `mid`=?";
		PreparedStatement st;
		try {
			st = DBconnection.getConnection().prepareStatement(query);
			st.setInt(2,mid);
           st.setString(1,score1+"-"+score2 );
       	if(st.executeUpdate() != 0) {
			JOptionPane.showMessageDialog(null,"Successfully Added");
		
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
				
		
	}

}
