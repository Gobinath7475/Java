// package com.kgisl.SpringJdbc;

// import java.sql.ResultSet;
// import java.sql.SQLException;
 
// import org.springframework.jdbc.core.RowMapper;
 
// public class EmployeeMapper implements RowMapper<Employee> {
 
//     @Override
//     public Employee mapRow(ResultSet arg0, int arg1) throws SQLException {
//         Employee employee=new Employee();
//         employee.setId(arg0.getInt("id"));
//         employee.setName(arg0.getString("name"));
//         employee.setSalary(arg0.getFloat("salary"));
//         return employee;
//     }
// }
