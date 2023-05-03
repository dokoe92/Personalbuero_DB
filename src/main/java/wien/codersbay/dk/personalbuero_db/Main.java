package wien.codersbay.dk.personalbuero_db;

import wien.codersbay.dk.personalbuero_db.dao.EmployeeCrudDao;
import wien.codersbay.dk.personalbuero_db.models.Employee;

public class Main {
    public static void main(String[] argv) {
        EmployeeCrudDao crud = new EmployeeCrudDao();
        Employee em = crud.findById(1);
        System.out.println(em);
    }
}
