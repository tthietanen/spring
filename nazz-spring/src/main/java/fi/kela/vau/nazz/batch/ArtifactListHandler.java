package fi.kela.vau.nazz.batch;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fi.kela.vau.nazz.dao.ArtifactDAO;
import fi.kela.vau.nazz.data.Artifact;

public class ArtifactListHandler {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-config.xml");
		ArtifactDAO dao = (ArtifactDAO) context.getBean("artifactDAO");

		System.out.println("-------------------");
		System.out.println("LISTATAAN KAIKKI");
		System.out.println("-------------------");

		List<Artifact> artifacts = dao.list();
		for (Artifact af : artifacts) {
			System.out.println(af.getName());
		}

		System.out.println("-------------------");
		System.out.println("HAETAAN YKSI (ID=3)");
		System.out.println("-------------------");

		Artifact af = dao.search(2);
		System.out.println(af.getId());
		System.out.println(af.getName());
		System.out.println(af.getStatus());

		System.out.println("-------------------");
		System.out.println("LISÄTÄÄN UUSI");
		System.out.println("-------------------");

		Artifact newAf = new Artifact();
		newAf.setName("Artifact3");
		dao.add(newAf);

		System.out.println("-------------------");
		System.out.println("HAETAAN KAIKKI");
		System.out.println("-------------------");
		artifacts = dao.list();
		for (Artifact afAll : artifacts) {
			System.out.println(afAll.getName());
		}

		context.close();

	}
}
