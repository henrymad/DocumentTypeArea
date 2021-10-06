package org.acme.service;

import io.quarkus.hibernate.reactive.panache.common.runtime.ReactiveTransactional;
import io.smallrye.mutiny.Uni;
import org.acme.model.entity.DocumentTypeArea;
import org.acme.repositories.DocumentTypeAreaRepo;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.NotFoundException;
import java.util.List;

@ApplicationScoped
public class DocumentTypeAreaCrud implements IDocumentTypeAreaCrud {

    private final DocumentTypeAreaRepo documentTypeAreaRepo;

    public DocumentTypeAreaCrud(DocumentTypeAreaRepo documentTypeAreaRepo) {
        this.documentTypeAreaRepo = documentTypeAreaRepo;
    }

    @ReactiveTransactional
    public Uni<List<DocumentTypeArea> > list() {
        return documentTypeAreaRepo.listAll();
    }

    @ReactiveTransactional
    public Uni<DocumentTypeArea> create(DocumentTypeArea area) {
        return documentTypeAreaRepo.persist(area);
    }

    private Uni<DocumentTypeArea> findOrFail(Long id) throws NotFoundException {
        return this.documentTypeAreaRepo.findById(id)
                .onItem().ifNotNull()
                .transform(area -> area)
                .onItem().ifNull()
                .failWith(new NotFoundException("DocumentTypeArea Not Found"));

    }

    @ReactiveTransactional
    public Uni<DocumentTypeArea> update(Long id, DocumentTypeArea area) throws NotFoundException{
        Uni<DocumentTypeArea> areaX = this.findOrFail(id);
        return areaX.onItem().transform(areaResponse -> {
            areaResponse.setName(area.getName());
            areaResponse.setActive(area.getActive());
            this.documentTypeAreaRepo.persist(areaResponse);
            return areaResponse;
        });
    }

    @ReactiveTransactional
    public Uni<DocumentTypeArea> enable(Long id){
        return this.change(id, true);
    }

    @ReactiveTransactional
    public Uni<DocumentTypeArea> disable(Long id){
        return this.change(id, false);
    }

    private Uni<DocumentTypeArea> change(Long id, boolean isActive){
        Uni<DocumentTypeArea> areaX = this.findOrFail(id);
        return areaX.onItem().transform(areaResponse -> {
            areaResponse.setActive(isActive);
            this.documentTypeAreaRepo.persist(areaResponse);
            return areaResponse;
        });
    }


}
