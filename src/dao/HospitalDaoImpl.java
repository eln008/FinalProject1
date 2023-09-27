package dao;

import DataBase.DataBase;
import Model.Hospital;
import Model.Patient;
import dao.Interface.HospitalDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HospitalDaoImpl implements HospitalDao {

    private DataBase dataBase;

    public HospitalDaoImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public String addHospital(Hospital hospital) {
        List<Hospital> hospitals = dataBase.getHospitals();
        hospitals.add(hospital);
        return "Успешно добавлено";
    }


    @Override
    public Hospital findHospitalById(Long id) {
        List<Hospital> hospitals = dataBase.getHospitals();
        for (Hospital h: hospitals) {
          if(h.getId().equals(id)){
              return h;
          }
        }
        return null;
    }

    @Override
    public List<Hospital> getAllHospital() {
        return dataBase.getHospitals();
    }

    @Override
    public List<Patient> getAllPatientFromHospital(Long id) {
        for (Hospital h: dataBase.getHospitals()) {
            if(h.getId().equals(id)){
                return h.getPatients();
            }
        }
        return null;
    }

    @Override
    public String deleteHospitalById(Long id) {
        List<Hospital> hospitals = dataBase.getHospitals();
        for (Hospital h : hospitals) {
            if(h.getId().equals(id)){
                hospitals.remove(h);
                return "Deleted!";
            }
        }
        return null;
    }

    @Override
    public Map<String, Hospital> getAllHospitalByAddress(String address) {
        Map<String, Hospital> hospitalsByAddress = new HashMap<>();
        for (Hospital hospital : dataBase.getHospitals()) {
            if (hospital.getAddress().equals(address)) {
                hospitalsByAddress.put(hospital.getHospitalName(), hospital);
            }
        }

        return hospitalsByAddress;
    }

}
