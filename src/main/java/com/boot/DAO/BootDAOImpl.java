package com.boot.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.boot.classes.ToDo;

@Repository("bootDAO")
public class BootDAOImpl implements BootDAO {

	public static Connection conn = null;

	static {
		System.out.println("static");
		/*
		 * try { Class.forName("oracle.jdbc.driver.OracleDriver"); conn =
		 * DriverManager.getConnection("jdbc:oracle:thin:@52.222.124.54:1521:ZBDBORCL",
		 * "ZBSYSTEM", "zbdbmanager"); System.out.println("Connection established.."); }
		 * catch (Exception e) { System.out.println("error establishing connection:  " +
		 * e); }
		 */
		// for local
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager");
			System.out.println("Connection established..");
		} catch (Exception e) {
			System.out.println("error establishing connection:  " + e);
		}
		/*
		 * getAllDocumentTypesFromDB(12); try {
		 * getAllDocumentTypesFromFile("D:\\YITSOL\\INDEX.DAT"); } catch (IOException e)
		 * { System.out.println("getAllDocumentTypesFromFile: "+e); }
		 */
	}

	public String getData(String name) {
		return "Hello " + name;
	}

	@Override
	public List<ToDo> getToDoList() {
		List<ToDo> toDoList = new ArrayList<ToDo>();
		try {
			Statement getToDoStmt = conn.createStatement();
			ResultSet getToDoRs = getToDoStmt.executeQuery("select * from TODOS");
			while (getToDoRs.next()) {
				ToDo toDo = new ToDo();
				toDo.setId(getToDoRs.getInt("ID"));
				toDo.setToDoName(getToDoRs.getString("TODONAME"));
				toDo.setDescription(getToDoRs.getString("DESCRIPTION"));
				toDo.setDone(Boolean.valueOf(getToDoRs.getString("DONE")));
				toDoList.add(toDo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return toDoList;
	}

	@Override
	public boolean addToDo(ToDo toDo) {
		boolean result = false;
		
		try {
			Statement addToDoStmt = conn.createStatement();
			Statement getMaxStmt = conn.createStatement();
			int maxId = 1;
			ResultSet getMaxRs = getMaxStmt.executeQuery("SELECT MAX(ID) FROM TODOS");
			if(getMaxRs!=null && getMaxRs.next()) {
				maxId = getMaxRs.getInt(1);
			}
			int i = addToDoStmt.executeUpdate("INSERT INTO TODOS(ID,TODONAME,DESCRIPTION) VALUES(" + (maxId+1) + ",'" + toDo.getToDoName() + "','" + toDo.getDescription() + "')");
			if(i>0) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean deleteToDo(int toDoId) {
		boolean result = false;
		try {
			Statement deleteToDoStmt = conn.createStatement();
			int i = deleteToDoStmt.executeUpdate("DELETE FROM TODOS WHERE ID = " + toDoId);
			if(i>0) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return result;
	}

	@Override
	public boolean completeToDo(int id) {
		boolean result = false;
		try {
			Statement completeToDoStmt = conn.createStatement();
			int i = completeToDoStmt.executeUpdate("UPDATE TODOS SET DONE='true' WHERE ID = " + id);
			if(i>0) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
