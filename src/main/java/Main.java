import com.force.BasicAuth;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import java.util.Enumeration;

/**
 *
 * This class launches the web application in an embedded Jetty container.
 * This is the entry point to your application. The Java command that is used for
 * launching should fire this main method.
 *
 * @author John Simone
 */
public class Main {

    public class BasicFilterConfig implements FilterConfig {

        @Override
        public String getFilterName() {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public ServletContext getServletContext() {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public String getInitParameter(String name) {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public Enumeration getInitParameterNames() {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception{
        String webappDirLocation = "src/main/webapp/";

        //The port that we should run on can be set into an environment variable
        //Look for that variable and default to 8080 if it isn't there.
        String webPort = System.getenv("PORT");
        if(webPort == null || webPort.isEmpty()) {
            webPort = "8080";
        }

        Server server = new Server(Integer.valueOf(webPort));
        WebAppContext root = new WebAppContext();

        root.setContextPath("/");
        root.setDescriptor(webappDirLocation+"/WEB-INF/web.xml");
        root.setResourceBase(webappDirLocation);
        root.setParentLoaderPriority(true);

        root.addFilter(BasicAuth.class, "/*", 31);

        server.setHandler(root);
        server.start();
        server.join();
    }

}
