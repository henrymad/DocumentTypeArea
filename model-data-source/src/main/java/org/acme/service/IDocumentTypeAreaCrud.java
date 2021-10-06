package org.acme.service;

import io.smallrye.mutiny.Uni;
import org.acme.model.entity.DocumentTypeArea;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
public interface IDocumentTypeAreaCrud {
    Uni<List<DocumentTypeArea>> list();
    Uni<DocumentTypeArea> create(DocumentTypeArea area);
    Uni<DocumentTypeArea> update(Long id, DocumentTypeArea area) throws NotFoundException;
    Uni<DocumentTypeArea> enable(Long id);
    Uni<DocumentTypeArea> disable(Long id);

}
