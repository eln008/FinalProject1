package Service;

import Model.Department;
import dao.Interface.DepartmentDao;

import java.util.List;

public class DepartmentService implements DepartmentDao {
    private DepartmentDao dao;

    public DepartmentService(DepartmentDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Department> getAllDepartmentByHospital(Long id) {
        return dao.getAllDepartmentByHospital(id);
    }

    @Override
    public Department findDepartmentByName(String name) {
        return dao.findDepartmentByName(name);
    }
}
