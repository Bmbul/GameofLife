import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class GameofLife extends JFrame implements ActionListener{

	 
	private JButton reset = new JButton("Reset");
	private JButton rand = new JButton("Rand");
	private JButton step = new JButton("Step");
	private LifePanel field = new LifePanel(8);
	int length = field.cells.length;

	public GameofLife(){
		super("Game of Life");
		add(field);
		setLayout(new FlowLayout());
		reset.addActionListener(this);
		add(reset);
		
		rand.addActionListener(this);
		add(rand);
		
		step.addActionListener(this);
		add(step);
		
		setSize(500,300);
		setVisible(true);
		setResizable(false);	
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent click) {
		if (click.getSource() == reset){
			for(int i = 0; i<length; i++){
				for(int j = 0;j<length;j++){
					field.cells[i][j].setAlive(false);
				}
			}
		
		}
		else if (click.getSource() == rand){
			for(int i = 0;i<length; i++){
				for(int j = 0;j<length;j++){
					int num = (int) Math.floor(Math.random()*4);
					if(num >= 3){
						field.cells[i][j].setAlive(true);
					} else {
						field.cells[i][j].setAlive(false);
					}
				}
			}
		}
		else if(click.getSource() == step){
				
				//try{
					for (int i = 0; i < length; i++) {
						for (int j = 0; j < length; j++) {
							
							
							int rStart = i - 1 > -1 ? i - 1 : i;
							
							int rEnd = i + 1 < length ? i + 1 : i;
							
							int cStart = j - 1 > -1 ? j - 1 : j;
							
							int cEnd = j + 1 < length ? j + 1 : j;
							
							int AlNeibr = 0;
							
							
							for (int rw = rStart; rw <= rEnd; rw++) {
								for (int clm = cStart; clm <= cEnd; clm++) {
									if (!(rw == i && clm == j)) {
										AlNeibr += field.cells[rw][clm].isAlive() ? 1 : 0;
									}
								}
							}
							System.out.println("i "  + i);
							System.out.println("j "  + j);
							if(field.cells[i][j].isAlive()) {
								if(AlNeibr < 2 || AlNeibr > 3)
									field.cells[i][j].setAlive(false);
							}
							else {
								if(AlNeibr == 3)
									field.cells[i][j].setAlive(true);
							}
						}
					}
				}//catch(Exception e){
					//System.out.println(length);
					
			//}
		
		}
public static void main(String[] args) {
	GameofLife game = new GameofLife();
}
}

/*
	So in my code I have changed a lot of things that I wrote during quiz
	The problem was that there was a lot of syntax problems, since I did not have
	prepared for that kind of problems
	The logic behind Problems 1 and 2 are the same 
	In the second problem I for rand button I did not get that it has to setAlive for each
	individually, but instead I used rand function take all of the 	LifeButtons decide the
	color and give all of them the same color, like in the first part of Problem 2
	
	So... Most of the mistakes were made because of lack of practice.
	
	But, all in all, this quiz was fun. Thanks a lot :D 

*/