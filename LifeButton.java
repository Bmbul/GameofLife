import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class LifeButton extends JButton implements ActionListener{
	
	public LifeButton(){
    	setBackground(Color.WHITE);
    	this.addActionListener(this);
    }
    boolean isAlive(){
    	return getBackground() == Color.BLACK;
    }
    void setAlive(boolean val){
    	if(val == true)
    		setBackground(Color.BLACK);
    	else
    		setBackground(Color.WHITE);
    }
    
    public void actionPerformed(ActionEvent click){
    	setAlive(!isAlive());
    }
}
