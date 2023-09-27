package dao;

import DataBase.DataBase;
import Model.Hospital;
import Model.Patient;
import dao.Interface.DepartmentDao;
import dao.Interface.PatientDao;

import java.util.*;
import java.util.stream.Collectors;

public class PatientDaoImpl implements PatientDao {
    private DataBase dataBase;

    public PatientDaoImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public String addPatientsToHospital(Long id, List<Patient> patients) {
        for (Hospital h: dataBase.getHospitals()) {
            if(h.getId().equals(id)){
                h.getPatients().addAll(patients);
                return "Successfully added";
            }
        }
        return null;
    }

    @Override
    public Patient getPatientById(Long id) {
        for (Patient p: dataBase.getPatients()) {
            if(p.getId().equals(id)){
                return p;
            }
        }
        return null;
    }


    @Override
    public Map<Integer, Patient> getPatientByAge(int age) {
        Map<Integer, Patient> patientsByAge = new HashMap<>();

        for (Patient p : dataBase.getPatients()) {
            if (p.getAge() == age) {
                patientsByAge.put(p.getAge(), p);
            }
        }

        return patientsByAge.isEmpty() ? null : patientsByAge;
    }


    @Override
    public List<Patient> sortPatientsByAge(String ascOrDesc) {
        List<Hospital> hospitals = dataBase.getHospitals();

        List<Patient> allPatients = hospitals.stream()
                .flatMap(hospital -> hospital.getPatients().stream())
                .collect(Collectors.toList());

        if ("Ascending".equalsIgnoreCase(ascOrDesc)) {
            return allPatients.stream()
                    .sorted(Comparator.comparing(Patient::getAge))
                    .collect(Collectors.toList());
        } else if ("Descending".equalsIgnoreCase(ascOrDesc)) {
            return allPatients.stream()
                    .sorted(Comparator.comparing(Patient::getAge).reversed())
                    .collect(Collectors.toList());
        } else {
            System.out.println("Напишите Ascending  или  Descending!!");
            return Collections.emptyList();
        }
    }

}
