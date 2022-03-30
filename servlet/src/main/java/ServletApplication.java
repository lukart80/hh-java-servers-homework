import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;


public class ServletApplication {

  public static Server createServer(int port) {
    Server server = new Server(port);
    ServletHandler servletHandler = new ServletHandler();
    servletHandler.addServletWithMapping(CounterServlet.class, "/");
    servletHandler.addFilterWithMapping(ClearCounterFilter.class, "/counter/clear", 0);
    server.setHandler(servletHandler);
    return server;
  }

  public static void main(String[] args) throws Exception {
    int port = 8081;
    Server server = createServer(port);
    server.start();
    server.join();
  }
}
