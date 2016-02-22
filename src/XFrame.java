import javax.swing.JFrame;


public class XFrame extends JFrame
{
	public XFrame() throws Exception
	{
		setTitle("Работа с базой данных методами языка Java");
		setBounds(300,200,600,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new XPanel());
		setVisible(true);
	}
}
