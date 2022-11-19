package it19180380;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ProjectServiceDBConnection;

public class EditProjectDetails {
	
	public Projects get_values_of_projects(String randomProj_ID){
		ProjectServiceDBConnection conn=new ProjectServiceDBConnection();
		Connection connection=conn.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		 Projects projects=new Projects();
		
		try {
		String querry="select * from projects where randomProj_ID=?";
		ps=connection.prepareStatement(querry);	
		ps.setString(1, randomProj_ID);
		rs=ps.executeQuery();
		while(rs.next()){
		 
		
		  projects.setProject_Id(rs.getString("randomProj_ID"));
		  projects.setProject_Title(rs.getString("Project_Title"));
		  projects.setProject_ShortDes(rs.getString("Project_ShortDes"));
		  projects.setProject_LongDes(rs.getString("Project_LongDes"));
		  projects.setProject_Srclink(rs.getString("Project_Srclink"));
		  projects.setProject_Videolink(rs.getString("Project_Videolink"));
		
		}
		} catch (Exception e) {
		System.out.println(e);
		}
		return projects;
		}

	public void edit_projects(Projects project){
		ProjectServiceDBConnection conn=new ProjectServiceDBConnection();
		Connection connection=conn.getConnection();
		
		PreparedStatement ps=null;
		
		
		
		try {
		String querry="update projects set Project_Title=? , Project_ShortDes=? , Project_LongDes=? , Project_Srclink=? , Project_Videolink = ? where randomProj_ID=?";
		ps=connection.prepareStatement(querry);	
		
		
		ps.setString(1, project.getProject_Title());;
		ps.setString(2, project.getProject_ShortDes());;
		ps.setString(3, project.getProject_LongDes());;
		ps.setString(4, project.getProject_Srclink());;
		ps.setString(5, project.getProject_Videolink());;
		ps.setString(6, project.getRandomProj_ID());
	    ps.executeUpdate();
		

		} catch (Exception e) {
		System.out.println(e);
		}
	
		}


}
