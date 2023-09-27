import DataBase.DataBase;
import Model.Department;
import Model.Doctor;
import Enum.Gender;
import Model.Hospital;
import Model.Patient;
import Service.*;
import dao.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

    public class Main {
        public static void main(String[] args) {
            Doctor doctor1 = new Doctor(1L, "John", "Smith", Gender.MALE, 5);
            Doctor doctor2 = new Doctor(2L, "Jane", "Doe", Gender.FEMAlE, 10);
            Doctor doctor3 = new Doctor(3L, "Emily", "Johnson", Gender.FEMAlE, 3);
            Doctor doctor4 = new Doctor(4L, "Michael", "Brown", Gender.MALE, 8);
            List<Doctor> doctors1 = new ArrayList<>(Arrays.asList(doctor3, doctor2));
            List<Doctor> doctors2 = new ArrayList<>(Arrays.asList(doctor1, doctor4));
            List<Doctor> doctors = new ArrayList<>(Arrays.asList(doctor1, doctor4, doctor3, doctor2));


            Department department1 = new Department(1L, "Cardiology", doctors1);
            Department department2 = new Department(2L, "Orthopedics", doctors2);
            List<Department> departments1 = new ArrayList<>(Arrays.asList(department2));
            List<Department> departments2 = new ArrayList<>(Arrays.asList(department1));
            List<Department> departments = new ArrayList<>(Arrays.asList(department1, department2));

            Patient patient1 = new Patient(1L, "Alice", "Wilson", 32, Gender.FEMAlE);
            Patient patient2 = new Patient(2L, "Robert", "Johnson", 45, Gender.MALE);
            Patient patient3 = new Patient(3L, "Grace", "Miller", 35, Gender.FEMAlE);
            Patient patient4 = new Patient(4L, "William", "Davis", 29, Gender.MALE);
            List<Patient> patients1 = new ArrayList<>(Arrays.asList(patient1, patient2));
            List<Patient> patients2 = new ArrayList<>(Arrays.asList(patient3, patient4));
            List<Patient> patients = new ArrayList<>(Arrays.asList(patient3, patient4, patient1, patient2));

            Hospital hospital1 = new Hospital(1L, "City General Hospital", "123 Main Street", departments1, doctors1, patients1);
            Hospital hospital2 = new Hospital(2L, "Riverside Medical Center", "456 Oak Avenue", departments2, doctors2, patients2);
            List<Hospital> hospitals = new ArrayList<>(Arrays.asList(hospital1, hospital2));

             DataBase dataBase = new DataBase();
             dataBase.setDoctors(doctors);
             dataBase.setDepartments(departments);
             dataBase.setPatients(patients);
             dataBase.setHospitals(hospitals);

        HospitalService hospitalService = new HospitalService(new HospitalDaoImpl(dataBase));
//        System.out.println(hospitalService.addHospital(new Hospital(3L, "Hospital new", "873, Street Aitmatov", departments, doctors, patients)));
//        System.out.println(hospitalService.findHospitalById(2L));
//        System.out.println(hospitalService.getAllHospital());
//        System.out.println(hospitalService.getAllPatientFromHospital(1L));
//        System.out.println(hospitalService.deleteHospitalById(1L));
//        System.out.println(hospitalService.getAllHospitalByAddress("456 Oak Avenue"));

        DoctorService doctorService = new DoctorService(new DoctorDaoImpl(dataBase));
//        System.out.println(doctorService.findDoctorById(2L));
//        List<Long> san = new ArrayList<>(Arrays.asList(1L,2L,3L));
//        System.out.println(doctorService.assignDoctorToDepartment(1L,san));
//            System.out.println(doctorService.getAllDoctorsByDepartmentId(1L));
//            System.out.println(doctorService.getAllDoctorsByHospitalId(2L));

        DepartmentService departmentService = new DepartmentService(new DepartmentDaoImpl(dataBase));
//        System.out.println(departmentService.findDepartmentByName("Cardiology"));
//        System.out.println(departmentService.getAllDepartmentByHospital(2L));

        PatientService patientService = new PatientService(new PatientDaoImpl(dataBase));
//        System.out.println(patientService.getPatientByAge(32));
//        System.out.println(patientService.getPatientById(2L));
//        System.out.println(patientService.addPatientsToHospital(2L, patients1));
//        System.out.println(patientService.sortPatientsByAge("Ascending"));


            GenericService genericService = new GenericService(new GenericDaoImpl(dataBase));
//            System.out.println(genericService.add(2L, hospital2));
//            System.out.println(genericService.updateById(1L,patient1));
//            genericService.removeById(2L);
    }
}