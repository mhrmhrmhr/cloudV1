package com.sip.ams.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sip.ams.entities.Animal;

@Controller
public class FirstController {
	@GetMapping("/home")  //pour indiquer comment éxécuter la méthode  acceuil
//	@ResponseBody //sans passer par un view 
	public String home() {
		return "/first/home"/*<h2>hello spring boot  </h2>"*/;
	}
	@GetMapping("/acceuil") 
	public String acceuil(@RequestParam(required=false ,defaultValue="1")int nom ,@RequestParam(required=false ,defaultValue="rzeigui")String prenom,ModelMap mnObj) {
		
		 String ch="Bienvenue "+nom +"  "+prenom;
		  mnObj.put("msg", ch);
		  String ecole="POLYTEC"; String formation="Formation spring";
		  mnObj.put("ec", ecole); mnObj.put("frm", formation);

		int[] tab= {1,2,3,4};
		mnObj.put("t",tab);
		
		ArrayList<String> list=new ArrayList<String>();
		list.add("maha");
		list.add("latifa");
		mnObj.put("list",list);
		
		ArrayList<Animal> listAnimals=new ArrayList<Animal>();
		Animal animal1=new Animal("animal1", 10);
		Animal animal2=new Animal("animal2", 20);
		Animal animal3=new Animal("animal3", 30);
		listAnimals.add(animal1);
		listAnimals.add(animal2);
		listAnimals.add(animal3);
		mnObj.put("animals",listAnimals);
		return "/first/acceuil";
	}
}
