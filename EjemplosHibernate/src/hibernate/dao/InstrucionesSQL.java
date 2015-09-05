package hibernate.dao;

/**
 * @author Iñaki Alfaro
 *
 */
public class InstrucionesSQL {
	static final String b1 = "select * from employees";
	static final String b2 = "select * from employees where DEPARTMENT_ID = 80";
	static final String b3 = "select * from employees where DEPARTMENT_ID IN (select DEPARTMENT_ID FROM DEPARTMENTS WHERE DEPARTMENT_NAME = 'Sales')";
	static final String d1 = "select * from departments";
}
