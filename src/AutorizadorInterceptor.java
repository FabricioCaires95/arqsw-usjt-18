import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter {
	
	
	@Override
    public boolean preHandle(HttpServletRequest request, 
            HttpServletResponse response,
            Object controller) throws Exception {

            String uri = request.getRequestURI();
            if(uri.endsWith("/") ||
                    uri.endsWith("autenticar")){
                return true;
            }

            if(request.getSession()
                    .getAttribute("usuario") != null) {
                return true;
            }

            response.sendRedirect("/pipoca/");
            return false;
    }

}
