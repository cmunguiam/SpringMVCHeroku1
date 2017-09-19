package pe.camm.springhibernatecrud.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.camm.springhibernatecrud.model.Country;

@Repository
public class CountryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@SuppressWarnings("unchecked")
	public List<Country> getAllCountries() {

		Session session = this.sessionFactory.getCurrentSession();
		List<Country> countryList = session.createQuery("from Country").list();
		return countryList;

	}

	public Country getCountryById(Integer id) {

		Session session = this.sessionFactory.getCurrentSession();
		Country country = (Country) session.load(Country.class, id);
		System.out.println(country);
		return country;

	}

	public Country addCountry(Country country) {

		Session session = this.sessionFactory.getCurrentSession();
		session.persist(country);
		return country;

	}

	public void updateCountry(Country country) {

		Session session = this.sessionFactory.getCurrentSession();
		session.update(country);

	}

	public void deleteCountry(Integer id) {

		Session session = this.sessionFactory.getCurrentSession();
		Country country = (Country) session.load(Country.class, id);
		if (null != country) {
			session.delete(country);
		}
	}

}
