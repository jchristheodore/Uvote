package com.rmit;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;

public class Util 
{

	/**
	 * Method to validate a string is null or empty
	 * 
	 * @param value
	 * @return
	 */
	public static Boolean isNullorEmpty(String value) 
	{
		if (value != null && !"".equals(value))
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	public static void formatTextBox(JTextField jtextfield, Button button, String UIName)
	{
		if(jtextfield != null)
		{
		    jtextfield.addKeyListener(new KeyAdapter() 
		    {
		        public void keyTyped(KeyEvent e) 
		        {
		            char enteredChar = e.getKeyChar();
		            if (!(Character.isDigit(enteredChar) || (enteredChar == KeyEvent.VK_BACK_SPACE)
		                    || (enteredChar == KeyEvent.VK_DELETE)) || (jtextfield.getText().length() > 0
		                    								  || (Character.getNumericValue(enteredChar)) > 8)) 
		            {
		                e.consume();
		            }
		        }
		    });
		}
		else if(button != null)
	    {
		    button.addActionListener(new ActionListener() 
		    { 
		    	  public void actionPerformed(ActionEvent e) 
		    	  { 
		    		  if(!Util.isNullorEmpty(UIName) && UIName.equals("UVoting"))
		    		  {
		    			  UVoteUI.clearAllInput(UIName);
		    		  }
		    	  } 
		    });
	    }
		
	}
	
	public static void setPlaceHolder(JTextField jtextField, String text)
	{
		jtextField.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) 
			{
				if(jtextField.getText().equals(text))
				{
					jtextField.setText("");  
				}
				jtextField.setForeground(new Color(50, 50, 50));
			}

			@Override
			public void focusLost(FocusEvent e) 
			{
		        if (jtextField.getText().length() == 0) 
		        {  
		        	jtextField.setText(text);  
		        	jtextField.setForeground(new Color(150, 150, 150));  
		        } 
			}  
		});
	}
	
	public static void invokeEnterEvent(Button button, JTextField inputField, String actionCommand)
	{
		if(button != null)
		{
			button.addActionListener(new ActionListener() 
		    { 
		    	  public void actionPerformed(ActionEvent e) 
		    	  { 
		    		  if(actionCommand.equals(e.getActionCommand()))
		    		  {
		    			  Authentication.onLogin();
		    		  }
		    		  
		    	  } 
		    });
		}
		else if(inputField != null)
		{
			inputField.addActionListener(new ActionListener() 
		    { 
		    	  public void actionPerformed(ActionEvent e) 
		    	  { 
		    		  if(actionCommand.equals(e.getActionCommand()))
		    		  {
		    			  Authentication.onLogin();
		    		  }
		    		  
		    	  } 
		    });
		}
	}
	
}
