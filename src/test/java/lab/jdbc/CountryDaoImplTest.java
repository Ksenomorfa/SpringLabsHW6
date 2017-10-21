package lab.jdbc;

import lab.dao.CountryDao;
import lab.model.Country;
import lab.model.simple.SimpleCountry;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Illustrates basic use of Hibernate as a JPA provider.
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:application-context.xml")
public class CountryDaoImplTest {

	private static Log log = LogFactory.getLog(CountryDaoImplTest.class);

    private Country exampleCountry = new SimpleCountry(1, "Australia", "AU");

    @Autowired
    private CountryDao countryDao;

    @Test
    void testSaveCountry() {

        countryDao.save(exampleCountry);

        List<Country> countryList = countryDao.getAllCountries();
        assertEquals(1, countryList.size());
        assertEquals(exampleCountry, countryList.get(0));
    }

    @Test
    void testGetAllCountries() {
        countryDao.save(exampleCountry);
        countryDao.save(new SimpleCountry(2, "Canada", "CA"));

        List<Country> countryList = countryDao.getAllCountries();
        assertEquals(2, countryList.size());
    }

    @Test
    void testGetCountryByName() {
        countryDao.save(exampleCountry);
        Country country = countryDao.getCountryByName("Australia");
        assertEquals(exampleCountry, country);
    }

}
