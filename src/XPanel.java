import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.TableRowSorter;

public class XPanel extends JPanel
{
	JTable PersonTable = null;
	PersonTableModel dbm = null;
	JButton btR = null;

	public XPanel() throws Exception
	{
		setLayout(null);

		JButton btC = new JButton();
				btR = new JButton();
		JButton btU = new JButton();
		JButton btD = new JButton();
		JButton btConOnH2 = new JButton();
		JButton btConOnMysql = new JButton();
		JButton btConOff = new JButton();

		dbm = new PersonTableModel();
		PersonTable = new JTable(dbm);
		TableRowSorter<PersonTableModel> sorter=new TableRowSorter<PersonTableModel>(dbm);
		PersonTable.setRowSorter(sorter);
		
		JScrollPane ScrollTable=new JScrollPane(PersonTable);

		btC.setText("Create");
		btR.setText("Read");
		btU.setText("Update");
		btD.setText("Delete");
		btConOnH2.setText("Connect H2");
		btConOnMysql.setText("Connect Mysql");
		btConOff.setText("Disconnect");

		btC.addActionListener(new ActionCreate());
		btR.addActionListener(new ActionRead());
		btU.addActionListener(new ActionUpdate());
		btD.addActionListener(new ActionDelete());
		btConOnH2.addActionListener(new ActionConnectH2());
		btConOnMysql.addActionListener(new ActionConnectMysql());
		btConOff.addActionListener(new ActionDisconnect());

		btC.setBounds(130, 300, 120, 20);
		btR.setBounds(230, 300, 120, 20);
		btU.setBounds(330, 300, 120, 20);
		btD.setBounds(430, 300, 120, 20);
		btConOnH2.setBounds(130, 330, 120, 20);
		btConOnMysql.setBounds(230, 330, 120, 20);
		btConOff.setBounds(330, 330, 120, 20);
		ScrollTable.setBounds(50, 20, 500, 250);

		add(btC);
		add(btR);
		add(btU);
		add(btD);
		add(btConOnH2);
		add(btConOnMysql);
		add(btConOff);
		add(ScrollTable);
	}		

	class ActionCreate implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			PersonDialog pd = new PersonDialog();
			pd.setVisible(true);

			if(pd.flagOk == 1) 
			{
				Person p = pd.getPerson();
				try {
					PersonDao.create(p);
				} catch (InstantiationException | IllegalAccessException
						| ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				btR.doClick();
			}
		}
	}
	class ActionRead implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			try {
				dbm.pp = PersonDao.read();
			} catch (InstantiationException | IllegalAccessException
					| ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			PersonTable.revalidate();
		}
	}
	class ActionUpdate implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			PersonDialog pd = new PersonDialog();

			int row = PersonTable.getSelectedRow();
			Person p = dbm.pp.get(row);
			pd.setPerson(p);

			pd.showUpdate();

			if(pd.flagOk == 1) 
			{
				p = pd.getPerson();
				try {
					PersonDao.update(p);
				} catch (InstantiationException | IllegalAccessException
						| ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				btR.doClick();
			}
		}
	}
	class ActionDelete implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			PersonDialog pd = new PersonDialog();
			pd.setVisible(true);

			if(pd.flagOk == 1) 
			{
				Person p = pd.getPerson();
				try {
					PersonDao.delete(p);
				} catch (InstantiationException | IllegalAccessException
						| ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				btR.doClick();
			}
		}
	}
	class ActionConnectH2 implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			PersonDao.connectionOnH2();
		}
	}
	class ActionConnectMysql implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			PersonDao.connectionOnMysql();
		}
	}
	class ActionDisconnect implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			PersonDao.connectionOff();
		}
	}
}