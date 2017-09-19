package pe.camm.springhibernatecrud.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SimpleControler {

	@RequestMapping("/simple")
	public @ResponseBody String simple() {

		return "Hola que tal";
	}

	@RequestMapping(value = "/simple2", method = RequestMethod.GET)
	public ModelAndView getdata() {

		List<String> list = getList();	
		
		ModelAndView model = new ModelAndView("demo");
		model.addObject("lists", list);

		return model;

	}

	private List<String> getList() {

		List<String> list = new ArrayList<String>();
		list.add("List A");
		list.add("List B");
		list.add("List C");
		list.add("List D");
		list.add("List 1");
		list.add("List 2");
		list.add("List 3");

		return list;

	}

}
