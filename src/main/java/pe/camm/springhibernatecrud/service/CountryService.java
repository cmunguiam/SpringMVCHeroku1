package pe.camm.springhibernatecrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.camm.springhibernatecrud.dao.CountryDAO;
import pe.camm.springhibernatecrud.model.Country;

@Service("countryService")
public class CountryService {

	@Autowired
	CountryDAO countryDao;

	@Transactional
	public List<Country> getAllCountries() {
		return countryDao.getAllCountries();
	}

	@Transactional
	public Country getCountryById(Integer id) {
		return countryDao.getCountryById(id);
	}

	@Transactional
	public Country addCountry(Country country) {

		return countryDao.addCountry(country);

	}

	@Transactional
	public void updateCountry(Country country) {

		countryDao.updateCountry(country);

	}

	@Transactional
	public void deleteCountry(Integer id) {

		countryDao.deleteCountry(id);
	}

}
