package com.sip.ams.controllers;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sip.ams.entities.Marque;
import com.sip.ams.repository.MarqueRepository;
@Controller
@RequestMapping("/marque/")

public class MarqueController {
	private final MarqueRepository marqueRepository; // objet mais pas une instance
	 @Autowired
	 public MarqueController(MarqueRepository marqueRepository) {
	 this.marqueRepository = marqueRepository;
	 }

	 @GetMapping("list")
	 public String listMarques(Model model) {
	 model.addAttribute("marques", marqueRepository.findAll());//findall() methode de jpa
	 
	 return "marque/listMarque";
	 }
//2eme methode avec le model
	 @GetMapping("add")
	 public String showAddMarqueForm(Model model) {
		 Marque marque = new Marque();
		 model.addAttribute("marque", marque);
	 return "marque/addMarque";
	 }

	 @PostMapping("add")
	 public String addMarque(@Valid Marque marque, BindingResult result,
	Model model) {
	 if (result.hasErrors()) {
	 return "marque/addMarque";
	 }
	 marqueRepository.save(marque);
	 return "redirect:list";
	 }

	 @GetMapping("delete/{id}")
	 public String deleteMarque(@PathVariable("id") long id, Model model) { //variable de chemin utilisé avec les id
		 
	 Marque marque = marqueRepository.findById(id)
			 
	 .orElseThrow(()-> new IllegalArgumentException("Invalid marqueId:" + id));
	 
	 marqueRepository.delete(marque);
	 model.addAttribute("marques", marqueRepository.findAll());
	 return "marque/listMarque";
	 }


	 @GetMapping("edit/{id}")
	 public String showProviderFormToUpdate(@PathVariable("id") long id, Model
	model) {
	 Marque marque = marqueRepository.findById(id)
	 .orElseThrow(()->new IllegalArgumentException("Invalid marqueId:" + id));
	 model.addAttribute("marque", marque);
	 return "marque/updateMarque";
	 }
	 @PostMapping("update/{id}")
	 public String updateProvider(@PathVariable("id") long id, @Valid Marque
	marque, BindingResult result,
	 Model model) {
	 if (result.hasErrors()) {
		 marque.setId(id);
		 return "marque/updateMarque";
		 }
		 marqueRepository.save(marque);
		 model.addAttribute("marques", marqueRepository.findAll());
		 return "marque/listMarque";
		 }
		}

	