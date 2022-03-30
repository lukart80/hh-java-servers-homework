package resource;


import DTO.CounterDTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import service.Counter;


@Path("/counter")
public class CounterResource {

    @GET
    @Produces("application/json")
    public Response getCounter() {
        Counter counter = Counter.getCounterInstance();
        return Response.ok(new CounterDTO(counter.getCounterValue())).build();
    }
    @POST
    @Produces("application/json")
    public Response incrementCounter() {
        Counter counter = Counter.getCounterInstance();
        counter.incrementCounter();
        return Response.ok().build();
    }

    @DELETE
    @Produces("application/json")
    public Response subtractCounter(@HeaderParam("Subtraction-Value") Integer value) {
        if (value == null) {
            return Response.status(400).build();
        }
        Counter counter = Counter.getCounterInstance();
        counter.subtractCounter(value);
        return Response.ok().build();
    }

    @POST
    @Path("/clear")
    @Produces("application/json")
    public Response clearCounter(@HeaderParam("hh-auth") String clearParam) {
        if (clearParam == null || !isClearParamCorrect(clearParam)) {
            return Response.status(400).build();
        }
        Counter counter = Counter.getCounterInstance();
        counter.clearCounter();
        return Response.ok().build();
    }

    private boolean isClearParamCorrect(String clearParam) {
        return clearParam.length() > 10;
    }


}


