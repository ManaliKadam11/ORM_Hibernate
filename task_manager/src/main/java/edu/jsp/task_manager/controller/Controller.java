package edu.jsp.task_manager.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import edu.jsp.task_manager.model.Employee;
import edu.jsp.task_manager.model.Task;

public class Controller {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("task_manager");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction = manager.getTransaction();

	public boolean addEmployee(Employee employee) {
		transaction.begin();
		manager.persist(employee);
		transaction.commit();
		return true;
	}

	public boolean removeEmployee(int id) {
		transaction.begin();
		Employee employee = manager.find(Employee.class, id);
		if (employee != null) {
			for (Task task : new ArrayList<>(employee.getTasks())) {
				task.getEmployees().remove(employee);
				manager.merge(task);
			}
			manager.remove(employee);
			transaction.commit();
			return true;
		} else {
			throw new EmployeeNotFoundException("Employee with ID " + id + " not found.");

		}
	}

	public Employee searchEmployee(int id) {
		Employee employee = manager.find(Employee.class, id);
		if (employee != null) {
			return employee;
		} else {
			throw new EmployeeNotFoundException("Employee with ID " + id + " not found.");
		}
	}

	public List<Employee> getAllEmployee() {
		String query = "select e from Employee e";
		Query query2 = manager.createQuery(query);
		@SuppressWarnings("unchecked")
		List<Employee> employees = (List<Employee>) query2.getResultList();
		if (employees != null) {
			return employees;
		} else {
			return null;
		}
	}

	public boolean addTask(Task task) {
		if (task != null) {
			transaction.begin();
			manager.persist(task);
			transaction.commit();
			return true;
		} else {
			return false;
		}
	}

	public boolean removeTask(int id) {
		transaction.begin();
		Task task = manager.find(Task.class, id);
		if (task != null) {
			for (Employee employee : task.getEmployees()) {
				employee.getTasks().remove(task);
				manager.merge(employee);
			}
			manager.remove(task);
			transaction.commit();
			return true;
		} else {
			transaction.rollback();
			throw new TaskNotFoundException("Task with ID " + id + " not found.");

		}
	}

	public List<Task> getAllTasks() {
		String query = "select t from Task t";
		Query query2 = manager.createQuery(query);
		@SuppressWarnings("unchecked")
		List<Task> tasks = (List<Task>) query2.getResultList();
		if (tasks != null) {
			return tasks;
		} else {
			return null;
		}
	}

	public Task searchTask(int id) {
		Task task = manager.find(Task.class, id);
		if (task != null) {
			return task;
		} else {
			throw new TaskNotFoundException("Task with ID " + id + " not found.");
		}
	}

	public boolean assignTask(int tid, int empid) {
		Employee employee = manager.find(Employee.class, empid);
		Task task = manager.find(Task.class, tid);

		List<Task> tasks = new ArrayList<Task>();
		tasks.add(task);

		List<Employee> employees = new ArrayList<Employee>();
		employees.add(employee);

		if (employee != null && task != null) {
			employee.setTasks(tasks);
			task.setEmployees(employees);
			transaction.begin();
			manager.merge(employee);
			manager.merge(task);
			transaction.commit();
			return true;
		} else {
			return false;
		}
	}

	public boolean updateSalary(int id, double newSalary) {

		Employee employee = manager.find(Employee.class, id);

		if (employee != null) {
			employee.setSalary(newSalary);
			transaction.begin();
			manager.merge(employee);
			transaction.commit();
			return true;
		} else {
			throw new EmployeeNotFoundException("Employee with ID " + id + " not found.");
		}
	}

}
