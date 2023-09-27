package dao;

import DataBase.DataBase;
import Model.Department;
import Model.Doctor;
import Model.Hospital;
import dao.Interface.DepartmentDao;
import dao.Interface.DoctorDao;

import java.util.ArrayList;
import java.util.List;

public class DoctorDaoImpl implements DoctorDao {
    private DataBase dataBase;

    public DoctorDaoImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public Doctor findDoctorById(Long id) {
        List<Doctor> doctors = dataBase.getDoctors();
        for (Doctor d:doctors) {
           if(d.getId().equals(id)){
               return d;
           }
        }
        return null;
    }

    @Override
    public String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId) {
        for (Department d : dataBase.getDepartments()) {
            if (d.getId().equals(departmentId)) {
                List<Doctor> doctors = new ArrayList<>();
                for (Long doctorId : doctorsId) {
                    Doctor doctor = findDoctorById(doctorId);
                    if (doctor != null) {
                        doctors.add(doctor);
                    }
                }
                d.setDoctors(doctors);
                return "Added!";
            }
        }
        return null;
    }



    @Override
    public List<Doctor> getAllDoctorsByHospitalId(Long id) {
        for (Hospital h:dataBase.getHospitals() ) {
            if(h.getId().equals(id)){
                return h.getDoctors();
            }
        }
        return null;
    }

    @Override
    public List<Doctor> getAllDoctorsByDepartmentId(Long id) {
        for (Department d : dataBase.getDepartments()) {
            if(d.getId().equals(id)){
                return d.getDoctors();
            }
        }
        return null;
    }
}
