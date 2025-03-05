package webServices;

import java.util.List;

import org.apache.cxf.frontend.ServerFactoryBean;

public class MovieServer {
	
	public static void main(String[] args) {
		
		ServerFactoryBean server = new ServerFactoryBean();
		server.setAddress("http://localhost:7777/MovieService");
		
		MovieServiceImpl impl = new MovieServiceImpl();
		impl.addMovie(new Movie(1, "Topgun", "English", "Action", List.of("Tom Cruise", "Jennifer Conley")));
		impl.addMovie(new Movie(2,"De dana dan", "Hindi", "Comedy", List.of("Akashay Kumar", "Sunil shetty", "Paresh Rawal")));
		impl.addMovie(new Movie(3, "3 Idiots", "Hindi", "Comedy", List.of("Aamir Khan", "Sharman Joshi", "R madhvan")));
		impl.addMovie(new Movie(4, "Jawan", "Hindi", "Action", List.of("Shah Rukh Khan", "Nayanthara")));
		
		server.setServiceBean(impl);
		server.setServiceClass(MovieService.class);
		server.create();
		System.out.println("Movie Server is running...");
	}

}
