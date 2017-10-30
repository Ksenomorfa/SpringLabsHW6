package lab.dao;

import java.util.List;

import lab.model.Country;

public interface CountryDao {

	void save(Country country);
	Country select(int id);
	List<Country> getAllCountries();

	//Country getCountryByName(String name) throws CountryNotFoundException;
}