package com.mshri.app.service.implementation;

import com.mshri.app.entity.User;
import com.mshri.app.exception.NotFoundException;
import com.mshri.app.service.interfaces.IUserService;
import com.mshri.app.utils.HelperUtils;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService implements IUserService {
    private Map<String, User> userListMap= new HashMap<>();
    @Override
    public void addUser(String name)  {
        System.out.printf("method addUser called for %s\n",name);
        if(userListMap.get(name)==null)
        {
            userListMap.put(name,new User(name));
            System.out.printf("ADDED USER SUCCESSFULLY TOTAL USERS=%d\n",userListMap.size());
        }
        else{
            System.out.println("User already exists");
        }
    }
}
