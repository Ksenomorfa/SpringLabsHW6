package lab.service;

import lab.dao.CountryDao;
import lab.dao.CountryDaoJDBC;
import lab.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryDao countryDao;

    public List<Country> getAllCountriesInsideTransaction(
            Propagation propagation) {
        if (Propagation.REQUIRED.equals(propagation)) {
            return getAllCountriesRequired();
        } else if (Propagation.REQUIRES_NEW.equals(propagation)) {
            return getAllCountriesRequiresNew();
        } else if (Propagation.SUPPORTS.equals(propagation)) {
            return getAllCountriesSupports();
        } else if (Propagation.NEVER.equals(propagation)) {
            return getAllCountriesNever();
        } else if (Propagation.MANDATORY.equals(propagation)) {
            return getAllCountriesMandatory();
        } else if (Propagation.NOT_SUPPORTED.equals(propagation)) {
            return getAllCountriesNotSupported();
        } else {
            return getAllCountries();
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List<Country> getAllCountriesRequired() {
        return countryDao.getAllCountries();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<Country> getAllCountriesRequiresNew() {
        return countryDao.getAllCountries();
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Country> getAllCountriesSupports() {
        return countryDao.getAllCountries();
    }

    @Transactional(propagation = Propagation.NEVER)
    public List<Country> getAllCountriesNever() {
        return countryDao.getAllCountries();
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public List<Country> getAllCountriesMandatory() {
        return countryDao.getAllCountries();
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<Country> getAllCountriesNotSupported() {
        return countryDao.getAllCountries();
    }

    public List<Country> getAllCountries() {
        return countryDao.getAllCountries();
    }

    public CountryDao getCountryDao() {
        return countryDao;
    }

    public void setCountryDao(CountryDao countryDao) {
        this.countryDao = countryDao;
    }

}