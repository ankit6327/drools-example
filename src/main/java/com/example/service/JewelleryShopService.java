package com.example.service;

import java.io.File;
import java.io.IOException;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieRepository;
import org.kie.api.builder.KieScanner;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Product;

@Service
public class JewelleryShopService {

	private final KieContainer kieContainer;

	@Autowired
	private KieServices kieServices;

	@Autowired
	public JewelleryShopService(KieContainer kieContainer) {
		this.kieContainer = kieContainer;
	}

	public Product getProductDiscount(Product product) {
		KieSession kieSession = kieContainer.newKieSession("rulesSession");
//		KieBaseConfiguration config = service.newKieBaseConfiguration();
//	    KieBase base = kContainer.newKieBase(config);
//		 KieSession ksession1 = base.newKieSession();

		// kieSession = kieContainer.getKieBase().newKieSession();
		kieSession.insert(product);
		kieSession.fireAllRules();
		kieSession.dispose();
		// StatelessKieSession kieSession = kieContainer.newStatelessKieSession();
		// kieSession.execute(product);
		// kieSession.fireAllRules();
		// kieSession.dispose();
		return product;
	}

	public Product secondWay(Product product) throws IOException {
		KieFileSystem fileSystem = kieServices.newKieFileSystem();
		// File resource = new File("‪D:\\", "rules.drl");
		File file = new File("‪D:\\", "rules.drl");
		String[] str = file.list();
		boolean value = file.exists();
		if (!value) {
			file.createNewFile();
		}
		System.out.println(value);
		fileSystem.write(ResourceFactory.newFileResource(file));
		// fileSystem.write(resource.get);
		KieRepository kr = kieServices.getRepository();

		KieBuilder kb = kieServices.newKieBuilder(fileSystem);
		kb.buildAll();
		KieContainer kContainer = kieServices.newKieContainer(kr.getDefaultReleaseId());

		KieSession kieSession = kContainer.newKieSession();

		KieScanner kieScanner = kieServices.newKieScanner(kieContainer);
		kieScanner.start(5000L);
		// alternatively:
		kieScanner.scanNow();
		kieSession.insert(product);
		kieSession.fireAllRules();
		kieSession.dispose();
		return product;
	}

	public String updateSession() {

		/*
		 * System.out.println("ArtifactId"+id.getArtifactId());
		 * System.out.println("GroupId"+id.getGroupId());
		 * System.out.println("Version"+id.getVersion());
		 */
		ReleaseId releaseId = kieServices.newReleaseId("com.javainuse", "boot-drools", "1.0.0-SNAPSHOT");
		KieContainer kContainer = kieServices.newKieContainer(releaseId);
		KieScanner kieScanner = kieServices.newKieScanner(kContainer);
		// kieScanner.shutdown();
		kieScanner.start(1000);
		kieScanner.scanNow();

		return "scanning complete";
	}

}