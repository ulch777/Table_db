import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;


public class PersonTableModel extends AbstractTableModel
{
	ArrayList<Person> pp = new ArrayList<Person>();
	
	@Override
	public int getColumnCount() 
	{
		return 4;
	}
	@Override
	public int getRowCount() 
	{
		return pp.size();
	}
	@Override
	public String getColumnName(int col) 
	{
		String str = "";
		switch (col) 
		{
			case 0: str = "Id";   break;
			case 1: str = "FName";break;
			case 2: str = "LName";break;
			case 3: str = "Age";  break;
		}
		return str;
	}
	
	@Override
	public Object getValueAt(int row, int col) 
	{
		Object str = null;
		Person p = pp.get(row);
		switch (col) 
		{
		
			case 0: str = p.Id;   break;
			case 1: str = p.FName;break;
			case 2: str = p.LName;break;
			case 3: str = p.Age;  break;
		}
		
		return str;
	}
//	@Override
//	 public Class getColumnClass(int col) {
//		    return columnTypes.get(col);
//		  }
}
