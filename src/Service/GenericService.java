package Service;

import dao.Interface.GenericDao;

public class GenericService implements GenericDao {
    private GenericDao genericDao;

    public GenericService(GenericDao genericDao) {
        this.genericDao = genericDao;
    }

    @Override
    public String add(Long hospitalId, Object o) {
        return genericDao.add(hospitalId, o);
    }

    @Override
    public void removeById(Long id) {
        genericDao.removeById(id);
    }

    @Override
    public String updateById(Long id, Object o) {
        return genericDao.updateById(id, o);
    }
}
