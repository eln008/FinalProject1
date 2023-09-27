package dao;
import DataBase.DataBase;
import Model.Hospital;
import Model.Patient;
import dao.Interface.GenericDao;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;


public class GenericDaoImpl implements GenericDao {
    private DataBase dataBase;
    private static final Logger logger = Logger.getLogger(GenericDaoImpl.class.getName());


    public GenericDaoImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public String add(Long hospitalId, Object o) {
        Hospital hospital = null;

        List<Hospital> hospitals = dataBase.getHospitals();
        for (Hospital h : hospitals) {
            if (h.getId().equals(hospitalId)) {
                hospital = h;
                break;
            }
        }

        if (hospital != null) {
            Map<Long, Object> objects = hospital.getObjects();
            Long uniqueId = System.currentTimeMillis();
            while (objects.containsKey(uniqueId)) {
                uniqueId = System.currentTimeMillis();
            }
            objects.put(uniqueId, o);
            hospital.setObjects(objects);
            return "Successfully added";
        } else {
            return "not found ";
        }
    }



    @Override
    public void removeById(Long id) {
        List<Hospital> hospitals = dataBase.getHospitals();
        for (Hospital hospital : hospitals) {
            List<Object> objects = (List<Object>) hospital.getObjects();
            Iterator<Object> iterator = objects.iterator();
            while (((Iterator<?>) iterator).hasNext()) {
                Object object = iterator.next();
                if (object instanceof Patient && ((Patient) object).getId().equals(id)) {
                    iterator.remove();
                    return;
                }
            }
        }
    }

    @Override
    public String updateById(Long id, Object updatedObject) {
        List<Hospital> hospitals = dataBase.getHospitals();
        for (Hospital hospital : hospitals) {
            Map<Long, Object> objects = hospital.getObjects();
            for (Long key : objects.keySet()) {
                Object object = objects.get(key);
                if (object instanceof Patient && ((Patient) object).getId().equals(id)) {
                    logger.info("Found object with ID: " + id);
                    objects.put(key, updatedObject);
                    hospital.setObjects(objects);
                    logger.info("Object updated successfully");
                    return "Successfully updated";
                }
            }
        }
        logger.warning("Object not found with ID: " + id);
        return "Object not found with the given ID.";
    }





}

