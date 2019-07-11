package com.tutorialspoint;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/UserService")
public class UserService {
	
	UserDao userdao = new UserDao();

	@GET
	@Path("/users")
	@Produces(MediaType.APPLICATION_XML)
//	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUsers(){
		List allUsersList = null;
		allUsersList = userdao.getAllUsers();
		return allUsersList;
		
	}

}
