package dao;

import DataBase.DataBase;
import Model.Department;
import Model.Hospital;
import dao.Interface.DepartmentDao;

import java.util.List;

public class DepartmentDaoImpl implements DepartmentDao {
    private DataBase dataBase;

    public DepartmentDaoImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public List<Department> getAllDepartmentByHospital(Long id) {
        for (Hospital h:dataBase.getHospitals()) {
            if(h.getId().equals(id)){
                return dataBase.getDepartments();
            }
        }
        return null;
    }

    @Override
    public Department findDepartmentByName(String name) {
        for (Department d:dataBase.getDepartments()) {
            if(d.getDepartmentName().equals(name)){
                return d;
            }
        }
        return null;
    }
}
