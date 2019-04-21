package com.maroc.api.fixtures;


import com.maroc.api.dao.UsersRepository;
import com.maroc.api.entities.Users;
import io.codearte.jfairy.Fairy;


public class UsersFixture implements Fixturable{

   private UsersRepository usersRepository;
   private Fairy fairy = Fairy.create();

    public UsersFixture(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    };


    @Override
    public void insert() {
        System.out.println("Insert fixture : USERS");
        int i = 0;
        int nbUsers = 25;

        for(; i <= nbUsers; i ++){
            Users newUser = new Users();
            newUser.setFirstname(fairy.person().firstName());
            newUser.setLastname(fairy.person().lastName());
            usersRepository.save(newUser);
        }
        System.out.println("Users inserted with success");
    }


}
