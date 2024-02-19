package edu.jsp.task_manager.view;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

import edu.jsp.task_manager.controller.Controller;
import edu.jsp.task_manager.controller.EmployeeNotFoundException;
import edu.jsp.task_manager.controller.TaskNotFoundException;
import edu.jsp.task_manager.model.Employee;
import edu.jsp.task_manager.model.Task;

public class View {

	Scanner scanner = new Scanner(System.in);
	Controller controller = new Controller();
	boolean loop = true;

	public static void main(String[] args) {
		View view = new View();
		while (view.loop) {
			view.mainView();
		}
	}

	public static void displayMenu() {
		System.out.println("1. Add the Employee");
		System.out.println("2. Remove the Employee");
		System.out.println("3. Update the Salary");
		System.out.println("4. Search the Employee");
		System.out.println("5. Get All Employees");
		System.out.println("6. Add Task");
		System.out.println("7. Remove Task");
		System.out.println("8. Search Task");
		System.out.println("9. Get All Tasks");
		System.out.println("10. Assign Task to Employee");
		System.out.println("11. Update the Salary");
	}

	public void mainView() {
		displayMenu();
		System.out.println("Enter your choice:");
		int choice = scanner.nextInt();
		scanner.nextLine();

		switch (choice) {
		case 1:
			addEmp();
			break;
		case 2:
			removeEmployee();
			break;
		case 3:
			updateSalary();
			break;
		case 4:
			searchEmployee();
			break;
		case 5:
			getAllEmployee();
			break;
		case 6:
			addTask();
			break;
		case 7:
			removeTask();
			break;
		case 8:
			searchTask();
			break;
		case 9:
			getAllTasks();
			break;
		case 10:
			assignTask();
			break;
		case 0:
			scanner.close();
			this.loop = false;
			System.out.println("***Thankyou***");
			break;
		default:
			System.out.println("Invalid choice. Please choose a valid option.");
			break;
		}
	}

	public void addEmp() {
		Employee employee = new Employee();
		System.out.println("Enter Employee name: ");
		employee.setName(scanner.nextLine());
		System.out.println("Enter Employee age: ");
		employee.setAge(scanner.nextInt());
		scanner.nextLine();
		System.out.println("Enter Employee salary: ");
		employee.setSalary(scanner.nextDouble());

		if (controller.addEmployee(employee) == true) {
			System.out.println("Employees saved");
		} else {
			System.out.println("Something went wrong");
		}
	}

	public void removeEmployee() {
		System.out.println("Enter Employee id: ");
		int id = scanner.nextInt();
		try {
			if (controller.removeEmployee(id)) {
				System.out.println("Employee removed successfully");
			} else {
				System.out.println("Employee not found");
			}
		} catch (EmployeeNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void searchEmployee() {
		System.out.println("Enter the id of the employee to be found: ");
		int id = scanner.nextInt();
		Employee employee = null;
		try {
			employee = controller.searchEmployee(id);
		} catch (EmployeeNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (employee != null) {
			System.out.println("Employee ID: " + employee.getId() + "\nEmployee name: " + employee.getName()
					+ "\nEmployee age: " + employee.getAge() + "\nEmployee date of joining: " + employee.getDoj()
					+ "\nEmployee salary: " + employee.getSalary() + "\nEmployee Tasks: " + employee.getTasks());
		} else {
			System.out.println("Employee not found");
		}
	}

	public void getAllEmployee() {
		List<Employee> employees = controller.getAllEmployee();
		if (employees != null) {
			for (Employee employee : employees) {
				System.out.println("Employee ID: " + employee.getId() + "\nEmployee name: " + employee.getName()
						+ "\nEmployee age: " + employee.getAge() + "\nEmployee date of joining: " + employee.getDoj()
						+ "\nEmployee salary: " + employee.getSalary() + "\nEmployee Tasks: " + employee.getTasks()
						+ "\n-------------------------------------");
			}
		} else {
			System.out.println("Employees not exist");
		}
	}

	public void addTask() {
		try {
			Task task = new Task();
			System.out.println("Enter Task name: ");
			task.setName(scanner.nextLine());
			System.out.println("Enter Starting date of the task (year-month-date): ");
			String startDate = scanner.nextLine();
			LocalDate date = LocalDate.parse(startDate);
			task.setStartDate(date);
			System.out.println("Enter the Deadline to be set (year-month-date): ");
			String endDate = scanner.nextLine();
			LocalDate date2 = LocalDate.parse(endDate);
			task.setDeadline(date2);

			if (controller.addTask(task)) {
				System.out.println("Task added successfully");
			} else {
				System.out.println("Something went wrong");
			}
		} catch (DateTimeParseException e) {
			System.out.println("Invalid date format. Please enter the date in the specified format.");
		}
	}

	public void removeTask() {
		System.out.println("Enter Task id: ");
		int id = scanner.nextInt();
		try {
			if (controller.removeTask(id)) {
				System.out.println("Task removed successfully");
			} else {
				System.out.println("Task not found");
			}
		} catch (TaskNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void searchTask() {
		System.out.println("Enter the id of the task to be found: ");
		int id = scanner.nextInt();
		Task task = null;
		try {
			task = controller.searchTask(id);
		} catch (TaskNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (task != null) {
			System.out.println("Task ID: " + task.getId() + "\nTask name: " + task.getName() + "\nTask starting date: "
					+ task.getStartDate() + "\nTask end date: " + task.getDeadline()
					+ "\nEmployees assigned to this above task: " + task.getEmployees());
		} else {
			System.out.println("No task found");
		}
	}

	public void getAllTasks() {
		List<Task> tasks = controller.getAllTasks();
		if (tasks != null) {
			for (Task task : tasks) {
				System.out.println("Task ID: " + task.getId() + "\nTask name: " + task.getName() + "\nStart date: "
						+ task.getStartDate() + "\nDeadline: " + task.getDeadline()
						+ "\nEmployees assigned to this task" + task.getEmployees()
						+ "\n-------------------------------------");
			}
		} else {
			System.out.println("Tasks not exist");
		}
	}

	public void assignTask() {
		System.out.println("Enter task ID to assign: ");
		int taskid = scanner.nextInt();
		System.out.println("Enter employee ID to assign task: ");
		int empid = scanner.nextInt();
		if (controller.assignTask(taskid, empid)) {
			System.out.println("Task assigned successfully");
		} else {
			System.out.println("Something went wrong.");
		}
	}

	public void updateSalary() {
		System.out.println("Enter the Employee ID: ");
		int id = scanner.nextInt();
		System.out.println("Enter the new Salary: ");
		double newSalary = scanner.nextDouble();
		try {
			if (controller.updateSalary(id, newSalary)) {
				System.out.println("Salary updated successfully");
			} else {
				System.out.println("Something went wrong");
			}
		} catch (EmployeeNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
