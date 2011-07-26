package com.force;

import org.apache.commons.codec.binary.Base64;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
* A very simple Servlet Filter for HTTP Basic Auth. Only supports exactly one user
* with a password. Please note, HTTP Basic Auth is not encrypted and hence unsafe!
*
* @author Timo B. Huebel (me@tbh.name) (initial creation)
*/
public class BasicAuth implements Filter {

    public static final String PARAM_USER = "user";
    public static final String PARAM_PASSWORD = "password";
    public static final String PARAM_REALM = "realm";

    // valid values: read from 'db'
    private String _user;
    private String _password;
    private String _realm;

    @Override
    public void destroy() {
        // Nothing to do.
    }

    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response,
            final FilterChain chain ) throws IOException, ServletException {

        final HttpServletRequest httpRequest = (HttpServletRequest) request;
        final HttpServletResponse httpResponse = (HttpServletResponse) response;

        final String auth = httpRequest.getHeader( "Authorization" );
        if ( auth != null ) {

            final int index = auth.indexOf( ' ' );
            if ( index > 0 ) {
                final String[] credentials = new String(Base64.decodeBase64(auth.substring(index).getBytes()), "UTF8")
                        .split(":");

                if ( credentials.length == 2 && _user.equals( credentials[0] ) && _password.equals( credentials[1] ) ) {
                    chain.doFilter( httpRequest, httpResponse );
                    return;
                }
            }
        }

        httpResponse.setHeader( "WWW-Authenticate", "Basic realm=\"" + _realm + "\"" );
        httpResponse.sendError( HttpServletResponse.SC_UNAUTHORIZED );
    }

    private boolean isBlank(String str) {
        return str == null || "".equals(str);
    }

    @Override
    public void init(final FilterConfig config ) throws ServletException {

        _user = config.getInitParameter( PARAM_USER );
        _password = config.getInitParameter( PARAM_PASSWORD );
        _realm = config.getInitParameter( PARAM_REALM );

        if ( isBlank( _user ) ) {
            throw new ServletException( "No user provided in filter configuration" );
        }

        if ( isBlank( _password ) ) {
            throw new ServletException( "No password provided in filter configuration" );
        }

        if ( isBlank( _realm ) ) {
            throw new ServletException( "No realm provided in filter configuration" );
        }
    }
}