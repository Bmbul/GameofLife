import java.awt.*;
import javax.swing.*;
public class LifePanel extends JPanel{
	public LifeButton cells [][];
	
	public LifePanel(int length){
		super();
		cells = new LifeButton[length][length];
		setLayout(new GridLayout(length,length));
		
		for(int i = 0; i<length;i++)
			for(int j =0;j<length;j++)
				{	
					cells[i][j] = new LifeButton();
					add(cells[i][j]);
				}
	}
}