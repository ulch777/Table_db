import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class PersonDialog extends JDialog 
{
	JTextField tt1 = null;
	JTextField tt2 = null;
	JTextField tt3 = null;
	JTextField tt4 = null;

	int flagOk = 0;

	public PersonDialog()
	{
		setLayout(null);
		setModal(true);
		setBounds(400, 300, 300, 300);

	

		JLabel lb1 = new JLabel("ID");
		JLabel lb2 = new JLabel("Имя");
		JLabel lb3 = new JLabel("Фамилия");
		JLabel lb4 = new JLabel("Возраст");
		tt1 = new JTextField();
		tt2 = new JTextField();
		tt3 = new JTextField();
		tt4 = new JTextField();
		
		JButton btnOk     = new JButton("Ok");
		JButton btnCancel = new JButton("Cancel");

		tt1.setBounds(5, 10, 270, 30);
		lb1.setBounds(5, 30, 270, 30);
		tt2.setBounds(5, 50, 270, 30);
		lb2.setBounds(5, 70, 270, 30);
		tt3.setBounds(5, 90, 270, 30);
		lb3.setBounds(5, 110, 270, 30);
		tt4.setBounds(5, 130, 270, 30);
		lb4.setBounds(5, 150, 270, 30);

		btnOk.setBounds(75, 180, 100, 22);
		btnCancel.setBounds(170, 180, 100, 22);
		
		add(tt1);
		add(tt2);
		add(tt3);
		add(tt4);
		add(lb1);
		add(lb2);
		add(lb3);
		add(lb4);
		add(btnOk);
		add(btnCancel);
		
		btnOk.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				flagOk = 1;
				setVisible(false);
			}
		});
		btnCancel.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				flagOk = 0;
				setVisible(false);
			}
		});
	}

	Person getPerson()
	{
		Person p=new Person();

		p.Id    = Integer.parseInt(tt1.getText());
		p.FName = tt2.getText();
		p.LName = tt3.getText();
		p.Age   = Integer.parseInt(tt4.getText());

		return p;
	}
	void setPerson(Person p)
	{
		tt1.setText("" +p.Id);
		tt2.setText(p.FName);
		tt3.setText(p.LName);
		tt4.setText("" + p.Age);
	}
	
	public void showUpdate() 
	{
		setTitle("Update Person");
		tt1.setEditable(false);
		setVisible(true);
	}
}
