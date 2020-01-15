package org.example;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

@Path("aliens")
public class AlienResource {

    AlienRepo repo = new AlienRepo();

    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<Alien> getAliens(){
        System.out.println("get alien called");

        //List<Alien> aliens = Arrays.asList(a1,a2);
        return repo.getAliens();
    }

    @GET
    @Path("alien/{id}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Alien getAlien(@PathParam("id") int id){
        System.out.println("get alien called");

        //List<Alien> aliens = Arrays.asList(a1,a2);
        return repo.getAlien(id);
    }

    @POST
    @Path("alien")
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Alien createAlien(Alien a1){
        System.out.println(a1);
        repo.create(a1);
        return a1;
    }

    @PUT
    @Path("updateAlien")
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Alien updateAlien(Alien a1){
        System.out.println("Updated Alien Called " + a1);
        System.out.println(" Just a1.getId(): " + a1.getId());
        System.out.println(" repo.getAlien(a1.getId()).getId(): " + repo.getAlien(a1.getId()).getId());
        if (repo.getAlien(a1.getId()).getId() == 0){
            repo.create(a1);
        }else {
            repo.update(a1);
        }

        return a1;
    }

    @DELETE
    @Path("deleteAlien/{id}")
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Alien deleteAlien(@PathParam("id") int id){
        Alien a = repo.getAlien(id);
        if (a.getId() != 0){
            repo.deleteAlien(id);
        }
        return a;
    }


}
