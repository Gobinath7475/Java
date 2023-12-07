// package com.kgisl.SpringJdbc;

// import java.util.List;

// import org.springframework.jdbc.core.JdbcTemplate;

// import jakarta.servlet.Registration;

// public class EmployeeDao {

//     {
//         System.out.println("DAO loaded");
//     }

//     private JdbcTemplate jdbcTemplate;

//     public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//         this.jdbcTemplate = jdbcTemplate;
//     }

//     public int saveEmployee(Employee e) {
//         String query = "INSERT INTO employee (id, name, salary) VALUES (?, ?, ?)";
//         return jdbcTemplate.update(query, e.getId(), e.getName(), e.getSalary());
//     }

//     public int updateEmployee(Employee e) {
//         String query = "UPDATE employee SET name=?, salary=? WHERE id=?";
//         return jdbcTemplate.update(query, e.getName(), e.getSalary(), e.getId());
//     }

//     public int deleteEmployee(Employee e) {
//         String query = "DELETE FROM employee WHERE id=?";
//         return jdbcTemplate.update(query, e.getId());
//     }

//     public List<Employee> allEmployees() {
//         String query = "SELECT * FROM employee";
//         return jdbcTemplate.query(query,new EmployeeMapper());
//     }

// }
