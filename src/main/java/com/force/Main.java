package com.force;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 *
 * This class launches the web application in an embedded Jetty container.
 * This is the entry point to your application. The Java command that is used for
 * launching should fire this main method.
 *
 * @author John Simone
 */
public class Main {

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

        /*
        HashLoginService loginService = new HashLoginService("hash-realm", "src/test/resources/realm.properties");
        Constraint constraint = new Constraint();
        constraint.setAuthenticate(true);
        constraint.setName("BASIC");
        constraint.setRoles(new String[]{"ADMIN"});
        ConstraintMapping constraintMapping = new ConstraintMapping();
        constraintMapping.setPathSpec("/");
        constraintMapping.setConstraint(constraint);
        ConstraintSecurityHandler constraintSecurityHandler = new ConstraintSecurityHandler();
        constraintSecurityHandler.setConstraintMappings(new ConstraintMapping[] {constraintMapping});
        constraintSecurityHandler.setAuthenticator(new BasicAuthenticator());
        constraintSecurityHandler.setLoginService(loginService);
        root.setSecurityHandler(constraintSecurityHandler);
        */

        //Parent loader priority is a class loader setting that Jetty accepts.
        //By default Jetty will behave like most web containers in that it will
        //allow your application to replace non-server libraries that are part of the
        //container. Setting parent loader priority to true changes this behavior.
        //Read more here: http://wiki.eclipse.org/Jetty/Reference/Jetty_Classloading

        /*
        ServletHandler handler = new ServletHandler();
        FilterHolder filterHolder = new FilterHolder();
        filterHolder.setFilter(new BasicAuth());
        handler.addFilter(filterHolder);
        root.setServletHandler(handler);
        */

        root.setParentLoaderPriority(true);
        server.setHandler(root);


        server.start();
        server.join();
    }

}
