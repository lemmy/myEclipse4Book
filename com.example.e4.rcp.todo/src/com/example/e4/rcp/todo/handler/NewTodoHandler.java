package com.example.e4.rcp.todo.handler;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;

import com.example.e4.rcp.todo.model.ITodoService;
import com.example.e4.rcp.todo.model.Todo;
import com.example.e4.rcp.todo.wizard.ConfirmationWizardPage;
import com.example.e4.rcp.todo.wizard.TodoWizard;
import com.example.e4.rcp.todo.wizard.TodoWizardPage;

public class NewTodoHandler {
	@Execute
	public void execute(Shell shell, ITodoService model) {
		Wizard wizard = new TodoWizard();
		wizard.setWindowTitle("New Todo Window Title");

		Todo todo = new Todo();

		wizard.addPage(new TodoWizardPage("New Todo", todo));
		wizard.addPage(new ConfirmationWizardPage("Confirm Todo"));

		WizardDialog dialog = new WizardDialog(shell, wizard);
		if (dialog.open() == WizardDialog.OK) {
			model.saveTodo(todo);
		}
	}
}