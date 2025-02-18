package servlets;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class LoadConfigListener implements ServletContextListener {
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		Properties p = new Properties();
		ServletContext context = sce.getServletContext();
		try (InputStream is = context.getResourceAsStream("/WEB-INF/config.properties") ) {
			if(is == null) {
				throw new RuntimeException("File not found");
			} 
			p.load(is);
			String url = p.getProperty("url");
			String username = p.getProperty("username");
			String password = p.getProperty("password");
			String driver = p.getProperty("driver");
			
			Class.forName(driver);
			
			context.setAttribute("url", url);
			context.setAttribute("password", password);
			context.setAttribute("username", username);
			
			
			}catch (IOException | ClassNotFoundException  e) {
				throw new RuntimeException(e);
				
		}
		
		
		System.out.println("first piece of code that will executed...");
		System.out.println("Loading...config...done...");
		System.out.println("Creating database conection pools...");
		ServletContext application = sce.getServletContext();
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Closing all databases connections in the connection pools");
	}

}
