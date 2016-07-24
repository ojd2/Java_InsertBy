/*
 _____    _____  ____       ___     
/\  __`\ /\___ \/\  _`\   /'___`\   
\ \ \/\ \\/__/\ \ \ \/\ \/\_\ /\ \  
 \ \ \ \ \  _\ \ \ \ \ \ \/_/// /__ 
  \ \ \_\ \/\ \_\ \ \ \_\ \ // /_\ \
   \ \_____\ \____/\ \____//\______/
    \/_____/\/___/  \/___/ \/_____/ 
*/

// Set up data structure for list of employee details associated with salary.
public class SalaryList {
  private final String firstName; // required data
  private final String lastName; // required data
  private final int salary; // required data
  private final int u_id; // required data
  private final String address; // optional
  private final String department; // optional

  // Bind SalaryList properties to an initialised object of an employee
  private Employee(_GroupEmployee employee) {
    this.firstName = employee.firstName;
    this.lastName = employee.lastName;
    this.salary = employee.salary;
    this.u_id = employee.u_id;
    this.address = employee.address;
    this.department = employee.department;
  }
  // Initiate some setters and getters for more secure data binding of objects 
  public String getFirstName() {
    return firstName;
  }
  public String getLastName() {
    return lastName;
  }
  public int getSalary() {
    return salary;
  }
  public int getUId() {
    return u_id;
  }
  public String getAddress() {
    return address;
  }
  public String getDepartment() {
    return department;
  }
  // Group our properties together
  public static class _GroupEmployee {
    private final String firstName;
    private final String lastName;
    private int salary;
    private int u_id;
    private String address;
    private String department;
    // Group required properties only
    public getProp(String firstName, String lastName, int salary, int u_id) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.salary = salary;
      this.u_id = u_id;
    }
    // Group optional properties
    public getProp address(String address) {
      this.address = address;
      return this;
    }
     public getProp department(String department) {
      this.department = department;
      return this;
    }
    // Bind Employee to a created object of employee
    public Employee _GROUP() {
      return new Employee(this);
      if (salary < 15000) {
        throw new IllegalStateException(“Age out of salary range”); // bad, not thread-safe
      } else if (u_id === u_id && salary > 15000) {
          System.out.println("Employee Member Inserted into Database: " + firstName + " " lastName + " " + u_id);
      }
        return Employee(this);
        MySQLAccess mysql = new MySQLAccess();
        mysql.readDataBase();
    }
  }
}
// Group our employee data together for an employee
public _GroupEmployee getProp() {
  return new
    _GroupEmployee.employee("Jhon", "Doe", "20000", "2320981")
    .address("Fake address 1234")
    .department("Accounting")
    ._GROUP();
}

// SQL integration  integration test, which will connect to the temporary MySQL server, 
// create a table there and insert some data into it. This is just an example to show 
// that MySQL server is running and is capable of serving transactions.
package de.vogella.mysql.first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class MySQLAccess {
  private Connection connect = null;
  private Statement statement = null;
  private PreparedStatement preparedStatement = null;
  private ResultSet resultSet = null;

  public void readDataBase() throws Exception {
    try {
      // This will load the MySQL driver, each DB has its own driver
      Class.forName("com.mysql.jdbc.Driver");
      // Setup the connection with the DB
      connect = DriverManager
          .getConnection("jdbc:mysql://localhost/record?"
              + "user=root&password=root");

      // Statements allow to issue SQL queries to the database
      statement = connect.createStatement();
      // Result set get the result of the SQL query
      resultSet = statement
          .executeQuery("select * from record.employees");
      writeResultSet(resultSet);

      // PreparedStatements can use variables and are more efficient
      preparedStatement = connect
          .prepareStatement("insert into  record.employees values (firstName, lastName, salary, u_id, address, department)");
      // Parameters start with 1
      preparedStatement.setString(1, employee.firstName);
      preparedStatement.setString(2, employee.lastName);
      preparedStatement.setInt(3, employee.salary);
      preparedStatement.setDate(4, new java.sql.Date(2016, 07, 24));
      preparedStatement.setInt(5, employee.u_id);
      preparedStatement.setString(6, employee.address);
      preparedStatement.seString(7, employee.department);
      preparedStatement.executeUpdate();

      preparedStatement = connect
          .prepareStatement("SELECT firstName, lastName, salary, u_id, address, department from record.employees");
      resultSet = preparedStatement.executeQuery();
      writeResultSet(resultSet);

      // Remove again the insert employee
      preparedStatement = connect
      .prepareStatement("delete from record.employees where myuser= employee ; ");
      preparedStatement.executeUpdate();
      
      resultSet = statement
      .executeQuery("select * from record.employees");
      writeMetaData(resultSet);
      
    } catch (Exception e) {
      throw e;
    } finally {
      close();
    }
  }

  private void writeMetaData(ResultSet resultSet) throws SQLException {
    // Now get some metadata from the database
    // Result set get the result of the SQL query.
    System.out.println("The columns in the table are: ");
    System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
    for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
      System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
    }
  }
  private void writeResultSet(ResultSet resultSet) throws SQLException {
    // ResultSet is initially before the first data set
    while (resultSet.next()) {
      // It is possible to get the columns via name
      // also possible to get the columns via the column number
      // which starts at 1
      // e.g. resultSet.getSTring(2);
      String firstName = resultSet.getString("firstName");
      String lastName = resultSet.getLastName("lastName");
      Int u_id = resultSet.getInt("u_id");
      Int salary = resultSet.getInt("salary");
      String Date = resultSet.getDate("date");
      String department = resultSet.getString("department");
    }
  }

  // You need to close the resultSet for security.
  private void close() {
    try {
      if (resultSet != null) {
        resultSet.close();
      }
      if (statement != null) {
        statement.close();
      }
      if (connect != null) {
        connect.close();
      }
    } catch (Exception e) {

    }
  }

}


