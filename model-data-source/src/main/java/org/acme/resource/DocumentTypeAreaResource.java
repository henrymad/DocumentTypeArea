package org.acme.resource;

import io.smallrye.mutiny.Uni;
import org.acme.model.entity.DocumentTypeArea;
import org.acme.service.DocumentTypeAreaCrud;
import org.acme.service.IDocumentTypeAreaCrud;

import javax.ws.rs.*;
import java.util.List;

@Path("/api")
@Produces("application/json")
@Consumes("application/json")
public class DocumentTypeAreaResource {

    private final IDocumentTypeAreaCrud documentTypeAreaCrud;

    public DocumentTypeAreaResource(IDocumentTypeAreaCrud documentTypeAreaCrud) {
        this.documentTypeAreaCrud = documentTypeAreaCrud;
    }

    @GET
    @Path("/document-type-area/list")
    public Uni<List<DocumentTypeArea>> list(){
        return documentTypeAreaCrud.list();
    }

    @POST
    @Path("/document-type-area/create")
    public Uni<DocumentTypeArea> create(DocumentTypeArea area){
        return documentTypeAreaCrud.create(area);
    }

    @PUT
    @Path("/document-type-area/update")
    public Uni<DocumentTypeArea> update(@QueryParam("id") Long id, DocumentTypeArea area) throws NotFoundException{
        return documentTypeAreaCrud.update(id, area);
    }

    @PUT
    @Path("/document-type-area/enable")
    public Uni<DocumentTypeArea> enable(@QueryParam("id") Long id){
        return documentTypeAreaCrud.enable(id);
    }

    @PUT
    @Path("/document-type-area/disable")
    public Uni<DocumentTypeArea> disable(@QueryParam("id") Long id){
        return documentTypeAreaCrud.disable(id);
    }
}
