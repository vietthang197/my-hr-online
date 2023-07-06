package com.thanglv.hronline;

import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.massindexing.MassIndexer;
import org.hibernate.search.mapper.orm.session.SearchSession;

import com.thanglv.hronline.entity.CorpIndustry;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@ApplicationScoped
public class App {
	
	@PersistenceContext(unitName = "defaultUnit")
	private EntityManager entityManager;

	@PostConstruct
	public void initIndex() {
		SearchSession searchSession = Search.session( entityManager );

        MassIndexer indexer = searchSession.massIndexer( CorpIndustry.class )
                .threadsToLoadObjects( 7 );

        try {
			indexer.startAndWait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
