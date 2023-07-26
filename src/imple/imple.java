package imple;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import dbcon.dbcon;
import bean.assignbean;
import bean.principalshare;
import bean.projectbean;
import bean.stafbean;
import bean.studentbean;
import bean.testpaperbean;
import inter.inter;

public class imple implements inter{
 
	Connection con;
	@Override
	public int staf(stafbean sb) {
		int u=0;
		try{
		con=dbcon.create();	
		PreparedStatement ps = con.prepareStatement("INSERT INTO college.staffreg VALUES(?,?,?,?,?,?,?)");
		ps.setString(1, sb.getStafid());
		ps.setString(2, sb.getName());
		ps.setString(3, sb.getDepartment());
		ps.setString(4, sb.getMobile());
		ps.setString(5, "Activate");
		ps.setString(6, "");
		ps.setString(7, "");

		u=ps.executeUpdate();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return u;
}
	@Override
	public int stdent(studentbean st) {
		int u=0;
		try{
		con=dbcon.create();	
		PreparedStatement ps = con.prepareStatement("INSERT INTO college.studentreg VALUES(?,?,?,?,?,?,?,?,?)");
		ps.setString(1, st.getStudendid());
		ps.setString(2, st.getName());
		ps.setString(3, st.getDepartment());
		ps.setString(4, st.getMobile());
		ps.setString(5, "Activate");
		ps.setString(6, st.getCname());
		ps.setString(7, st.getCid());
		ps.setString(8,"stud");
		ps.setString(9,"time");
		
		u=ps.executeUpdate();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return u;
}
	@Override
	public int principal(principalshare p) {
		int u=0;
		try{
		con=dbcon.create();	
		PreparedStatement ps = con.prepareStatement("INSERT INTO college.principal VALUES(id,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		ps.setString(1, p.getDate());
		ps.setString(2, p.getFilename());
		ps.setString(3, p.getDepart());
		ps.setString(4, p.getFrom());
		ps.setString(5, "Not View");
		ps.setString(6, "hod");
		ps.setString(7, "staff");
		ps.setString(8, "student");
		ps.setString(9, "");
		ps.setString(10, "");
		ps.setString(11, "");
		ps.setString(12, "");ps.setString(13, "");ps.setString(14, "");ps.setString(15, "time");ps.setString(16, "time");ps.setString(17, "time");

		u=ps.executeUpdate();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return u;
}
	@Override
	public boolean slog(stafbean sl) {
		boolean b=false;
		try
		{
		
			con=dbcon.create();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM college.staffreg where  stafid=? and department=? ");
			ps.setString(1, sl.getStafid());
			ps.setString(2, sl.getDepartment());
			
	         ResultSet rs=ps.executeQuery();
			b=rs.next();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return b;
		
	}
	@Override
	public int assign(assignbean ab) {
		// TODO Auto-generated method stub
		int s=0;
		try{
		con=dbcon.create();	
		PreparedStatement ps = con.prepareStatement("INSERT INTO college.assignment VALUES(id,?,?,?,?,?)");
		ps.setString(1, ab.getStaffid());
		ps.setString(2, ab.getAssignment());
		ps.setString(3, ab.getSubject());
		ps.setString(4, ab.getFile());
		ps.setString(5, "fortest");
	

		s=ps.executeUpdate();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return s;
		
		
		
	}
	@Override
	public boolean stlog(studentbean st) {
		// TODO Auto-generated method stub
		boolean b=false;
		try
		{
		
			con=dbcon.create();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM college.studentreg where  studeid=? and department=? ");
			ps.setString(1, st.getStudendid());
			ps.setString(2, st.getDepartment());
			
	         ResultSet rs=ps.executeQuery();
			b=rs.next();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return b;
		
	}
	@Override
	public int test(testpaperbean tpb) {
		// TODO Auto-generated method stub
		int u=0;
		try{
		con=dbcon.create();	
		PreparedStatement ps = con.prepareStatement("INSERT INTO college.testpaper VALUES(id,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		ps.setString(1, tpb.getStudid());
		ps.setString(2, tpb.getStaffid());
		ps.setString(3, tpb.getSubject());
		ps.setString(4, tpb.getDescription());
		ps.setString(5, tpb.getQuesname());
		ps.setString(6, tpb.getAnspaper());
		ps.setString(7, " ");
		ps.setString(8, " " );
		ps.setString(9, "Test Finished");
		ps.setString(10, " " );
		ps.setString(11, " " );
		ps.setString(12, " " );
		ps.setString(13, " " );
		ps.setString(14, " " );
		
		u=ps.executeUpdate();
		
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return u;	
		}
	@Override
	public int proj(projectbean pb) {
		// TODO Auto-generated method stub
		int u=0;
		try{
		con=dbcon.create();	
		PreparedStatement ps = con.prepareStatement("INSERT INTO college.project VALUES(id,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		ps.setString(1, pb.getStudid());
		ps.setString(2, pb.getProjtitle());
		ps.setString(3, pb.getFilename());
		ps.setString(4, pb.getReview());
		ps.setString(5, " " );
		ps.setString(6, " " );
		ps.setString(7," " );
		ps.setString(8, "Uploaded");
		ps.setString(9, pb.getDept());
		ps.setString(10, " ");
		ps.setString(11, " ");
		ps.setString(12, " ");
		ps.setString(13, " ");
		ps.setString(14, " ");
		ps.setString(15, pb.getPhash());
		ps.setString(16, pb.getAhash());
		
		u=ps.executeUpdate();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return u;	
	}
}
