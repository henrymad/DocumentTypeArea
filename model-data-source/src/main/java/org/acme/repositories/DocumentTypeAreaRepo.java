package org.acme.repositories;

import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;
import org.acme.model.entity.DocumentTypeArea;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DocumentTypeAreaRepo implements PanacheRepositoryBase<DocumentTypeArea, Long> {
}
