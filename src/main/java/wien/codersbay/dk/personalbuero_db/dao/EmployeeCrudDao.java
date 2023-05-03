package wien.codersbay.dk.personalbuero_db.dao;

import wien.codersbay.dk.personalbuero_db.exceptions.EmployeeDbException;
import wien.codersbay.dk.personalbuero_db.models.Employee;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

public class EmployeeCrudDao {

    public Employee findById(int employeeId) {
        try ( Connection connection = ConnectionManager.getConnection()) {
            String sql = """
                       select id, firstName, lastName, dateOfBirth, hireDate
                       from employee
                       where id = ?
                    """;
            try (PreparedStatement ps = connection.prepareStatement( sql)) {
                ps.setInt(1, employeeId);
                ResultSet resultSet = ps.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String firstName = resultSet.getString("firstName");
                    String lastName = resultSet.getString("lastName");
                    LocalDate dateOfBirth = resultSet.getDate("dateOfBirth").toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    LocalDate hiredate = resultSet.getDate("hiredate").toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    return new Employee(firstName, lastName, dateOfBirth, hiredate);
                }
            }
            return null;
        } catch (SQLException e) {
            throw new EmployeeDbException();
        }
    }

    public int create(Employee employee) {
        try (Connection connection = ConnectionManager.getConnection()) {
            String sql = """
                    Insert into employee
                    (firstName, lastName, dateOfBirth, hireDate)
                    Values (?, ?, ?, ?)
                    """;

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, employee.getFirstName());
                ps.setString(2, employee.getLastName());
                ps.setDate(3, java.sql.Date.valueOf(employee.getDateOfbirth()));
                ps.setDate(4, java.sql.Date.valueOf(employee.getHireDate()));

                return ps.executeUpdate();
            }
        } catch (SQLException e) {
            throw new EmployeeDbException();
        }
    }

    public boolean update(Employee employee) {
        try (Connection connection = ConnectionManager.getConnection()) {
            String sql = """
                    
                    """
        }
    }

    /*
    public boolean delete(int employeeId) {

    }

    public List<Employee> findall() {

    }
*/

}
