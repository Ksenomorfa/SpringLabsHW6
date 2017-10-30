/**
 * 
 */
package lab.dao;

import lab.model.Country;
import lab.model.User;
import lab.model.simple.SimpleCountry;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class HsqlCountryDao extends JdbcDaoSupport implements CountryDao {

	private static Log log = LogFactory.getLog(HsqlCountryDao.class);

	@Override
	public void save(Country country) {

		if (country != null) {
			log.debug( "Processing country: " + country);
			this.getJdbcTemplate().update(
					"insert into country (name, code_name) values (?, ?)",
					country.getName(), country.getCodeName());

		} else {
			log.debug("Domain country is null!");
		}
	}

	@Override
	public Country select(int id) {

		Country country = null;

		if (id > 0) {
			country = this.getJdbcTemplate().queryForObject(
					"select id, code_name, name from country where id = ?",
					new Object[] { id }, new CountryMapper());
		}
		log.debug("Receidved user: " + country);
		
		return country;
	}

	@Override
	public List<Country> getAllCountries() {
		return this.getJdbcTemplate().query(
				"select id, code_name, name from country"
				, new CountryMapper());
	}

	private static final class CountryMapper implements RowMapper<Country> {

		public Country mapRow(ResultSet rs, int rowNum) throws SQLException {
			Country country = new SimpleCountry();
			country.setId(rs.getInt("id"));
			country.setName(rs.getString("name"));
			country.setCodeName(rs.getString("code_name"));
			return country;
		}
	}
}
