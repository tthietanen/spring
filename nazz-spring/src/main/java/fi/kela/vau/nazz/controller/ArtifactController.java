package fi.kela.vau.nazz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.kela.vau.nazz.dao.ArtifactDAO;
import fi.kela.vau.nazz.data.Artifact;
import fi.kela.vau.nazz.data.Status;

@Controller
@RequestMapping(value = "/artifact")
public class ArtifactController {

	// searches classpath for suitable class to inject, synonym @Autowired. If
	// more than 1 suitable found spring start fails
	// @Inject
	private ArtifactDAO dao;

	@Autowired
	public ArtifactController(ArtifactDAO dao) {
		this.dao = dao;
	}

	// FORMIN TEKEMINEN
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add(Model model) {
		Artifact newAf = new Artifact();
		newAf.setName("artifactName");
		newAf.setStatus(Status.NEW.getStatus());

		model.addAttribute("artifact", newAf);
		return "artifact/add";
	}

	// FORMIN TIETOJEN VASTAANOTTO
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String create(@ModelAttribute(value = "artifact") Artifact af) {
		dao.add(af);
		return "redirect:/artifact/list";
		// return "redirect:/artifact/" + af.getId();
	}

	//
	// // HENKILÖN TIETOJEN NÄYTTÄMINEN
	// @RequestMapping(value = "{id}", method = RequestMethod.GET)
	// public String getView(@PathVariable Integer id, Model model) {
	// Artifact henkilo = dao.etsi(id);
	// model.addAttribute("henkilo", henkilo);
	// return "henk/view";
	// }
	//
	// HENKILÖN TIETOJEN LISTAUS
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(Model model) {
		List<Artifact> afList = dao.list();
		model.addAttribute("artifacts", afList);
		return "artifact/list";
	}
}
