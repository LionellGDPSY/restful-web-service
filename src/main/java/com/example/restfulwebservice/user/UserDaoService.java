package com.example.restfulwebservice.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static int userCount = 3;

    static {
        users.add(new User(1, "Kenneth", new Date()));
        users.add(new User(2, "Alice", new Date()));
        users.add(new User(3, "Elena", new Date()));
    }

    public List<User> findAll(){
        return users;
    }

    public User save(User user){
        if (user.getId() == null){
            user.setId(++userCount);
        }
        users.add(user);
        return user;
    }
    public User findOne(int id){
        for (User user : users) {
            if (user.getId().equals(id)){
                return user;
            }
        }
        // 해당하는 값이 없으면 null return
        return null;
    }


    public User deleteById(int id){

        //iterator 이란 list형 데이터를 순차적으로 접근해서 사용하기 위한 열거형 타입의 데이터.
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()){
            User user = iterator.next();

            if (user.getId()== id){
                iterator.remove();
                return user;
            }
        }

        return null;
    }
}
