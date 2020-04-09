package dao;
import model.Skill;
import utility.ConnectionManager;
import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement; 

public class SkillDAO{

	public TreeMap<String,Integer> skillCount() throws SQLException, Exception{
		TreeMap<String,Integer> treeMap = new TreeMap<String,Integer>();
		
		int count=0;
		
		ConnectionManager cm=new ConnectionManager();
		Skill skill=null;
		
		String query = "SELECT name, count(name) FROM skill GROUP by name";
		
		Statement stmt=cm.getConnection().createStatement();
		
		ResultSet rs=stmt.executeQuery(query);
		
		while(rs.next()) {
			skill=new Skill();
		    skill.setSkillName(rs.getString("name"));
		    count = rs.getInt("count(name)");
		    treeMap.put(skill.getSkillName(),count);
		}
		return treeMap;
	}
}

