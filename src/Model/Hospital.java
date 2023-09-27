package Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hospital {
    private Long id;
    private String hospitalName;
    private String address;
    private List<Department> departments;
    private List<Doctor> doctors;
    private List<Patient> patients;
    private Map<Long, Object> objects = new HashMap<>();
    private List<Object> objects1;



    public Hospital(Long id, String hospitalName, String address, List<Department> departments, List<Doctor> doctors, List<Patient> patients) {
        this.id = id;
        this.hospitalName = hospitalName;
        this.address = address;
        this.departments = departments;
        this.doctors = doctors;
        this.patients = patients;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
    public void addObject(Long objectId, Object object) {
        objects.put(objectId, object);
    }

    public void removeObject(Long objectId) {
        objects.remove(objectId);
    }

    public Map<Long, Object> getObjects() {
        return objects;
    }

    public void setObjects(Map<Long, Object> objects) {
        this.objects = objects;
    }

    public Object getObject(Long objectId) {
        return objects.get(objectId);
    }

    public List<Object> getObjects1() {
        return objects1;
    }

    public void setObjects1(List<Object> objects1) {
        this.objects1 = objects1;
    }

    @Override
    public String toString() {
        return "\nHospital{" +
                "id=" + id +
                ", hospitalName='" + hospitalName + '\'' +
                ", address='" + address + '\'' +
                ", departments=" + departments +
                ", doctors=" + doctors +
                ", patients=" + patients +
                '}';
    }
}
