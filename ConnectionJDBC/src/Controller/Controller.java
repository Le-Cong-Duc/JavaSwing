package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.StudentManager;
import View.View;

public class Controller implements ActionListener {
	private StudentManager studentManager;
	private View view;

	public Controller() {
		this.studentManager = new StudentManager();
		this.view = new View();

	}

	public Controller(StudentManager studentManager, View view) {
		this.studentManager = studentManager;
		this.view = view;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			view.btnAdd.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					view.reset();
				}
			});
			
		}catch(

	Exception e1)
	{
		e1.printStackTrace();
	}

}

}
