package pe.camm.springhibernatecrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pe.camm.springhibernatecrud.model.Country;
import pe.camm.springhibernatecrud.service.CountryService;

@Controller
public class CountryController {

	@Autowired
	CountryService countryService;

	@RequestMapping(value = "/getAllCountries", method = RequestMethod.GET)
	public String getAllCountries(Model model) {

		List<Country> countryList = countryService.getAllCountries();
		Country country = new Country();
		model.addAttribute("country", country);
		model.addAttribute("countryList", countryList);
		return "countryDetails";

	}

	@RequestMapping(value = "/getCountryById/{id}", method = RequestMethod.GET)
	public Country getCountryById(@PathVariable Integer id) {

		return countryService.getCountryById(id);

	}

	@RequestMapping(value = "/addCountry", method = RequestMethod.POST)
	public String addCountry(@ModelAttribute("country") Country country) {

		if (country.getId() == null) {
			countryService.addCountry(country);
		} else {
			countryService.updateCountry(country);
		}
		return "redirect:getAllCountries";

	}

	@RequestMapping(value = "/updateCountry/{id}", method = RequestMethod.GET)
	public String updateCountry(@PathVariable("id") Integer id, Model model) {

		List<Country> countryList = this.countryService.getAllCountries();
		Country country = new Country();
		 System.out.println(id);
		country = this.countryService.getCountryById(id);
		model.addAttribute("country", country);
		// this.countryService.getAllCountries()
		// this.countryService.getCountryById(id)

		model.addAttribute("countryList", countryList);
		return "countryDetails";

	}

	@RequestMapping(value = "/deleteCountry/{id}", method = RequestMethod.GET)
	public String deleteCountry(@PathVariable("id") Integer id) {

		countryService.deleteCountry(id);
		return "redirect:/getAllCountries";

	}

}
