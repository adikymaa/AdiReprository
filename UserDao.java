package com.tutorialspoint;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
	
	
public List<User> getAllUsers(){
	
	List<User> userList = null;
	
		try {
			File file = new File("Usersdata.dat");
			
			if(file.exists()) {
				FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);
				userList = (List<User>)ois.readObject();
				ois.close();
			} else {
			
			userList = new ArrayList<User>();
			User user1 = new User(101,"Rajesh","sw engg");
			User user2 = new User(104,"alex","sw engg");
			User user3 = new User(105,"Ramesh","sw engg");
			User user4 = new User(106,"Karan","sw engg");
			userList.add(user1);
			userList.add(user2);
			userList.add(user3);
			userList.add(user4);
			saveUser(userList);
		}
			
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	return userList;
	
}

public void saveUser(List<User> ulist) {
	
	File file = new File("Usersdata.dat");
	try {
		FileOutputStream fis = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fis);
		oos.writeObject(ulist);
		oos.close();	
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	
	
	
}
	
}
