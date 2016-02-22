import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class PersonDao 
{
	static Connection con = null;
	public static void create(Person p) throws InstantiationException, IllegalAccessException, ClassNotFoundException 
	{
		try 
		{
			Statement stmt = con.createStatement();
			String strUpdate="INSERT INTO person VALUES (" + p.Id + ",'" + p.FName + "','" + p.LName + "'," + p.Age + "); ";
			stmt.execute(strUpdate);
			stmt.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}
	public static ArrayList<Person> read() throws InstantiationException, IllegalAccessException, ClassNotFoundException 
	{
		ArrayList<Person> pp = new ArrayList<Person>();
		try 
		{
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM person");
			while(rs.next())
			{
				Person p = new Person();

				p.Id    = rs.getInt("Id");
				p.FName = rs.getString("FName");
				p.LName = rs.getString("LName");
				p.Age   = rs.getInt("Age");

				pp.add(p);
			}
			rs.close();
			stmt.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return pp;
	}
	public static void update(Person p) throws InstantiationException, IllegalAccessException, ClassNotFoundException 
	{
		try 
		{
			Statement stmt = con.createStatement();
			String strUpdate = "UPDATE person SET FName='" + p.FName + "', LName='" + p.LName + "', AGE=" + p.Age + " WHERE id=" + p.Id + ";";
			stmt.execute(strUpdate);
			stmt.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public static void delete(Person p) throws InstantiationException, IllegalAccessException, ClassNotFoundException 
	{
		try 
		{
			Statement stmt = con.createStatement();
			stmt.execute("delete from person where id = " + p.Id + ";");
			stmt.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public static void connectionOnH2()
	{
		try {
			Class.forName("org.h2.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:h2:~/test","sa","");
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}
	public static void connectionOff()
	{
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void connectionOnMysql()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/person","root","");
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
