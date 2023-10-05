package net.ausiasmarch.foxforumserver.service;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.ausiasmarch.foxforumserver.entity.UserEntity;
import net.ausiasmarch.foxforumserver.repository.UserRepository;
import net.ausiasmarch.foxforumserver.exception.ResourceNotFoundException;

@Service
public class UserService {

@Autowired
UserRepository oUserRepository;


    public UserEntity get (Long id){
    return oUserRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found"));

    }

    public UserEntity create (UserEntity oUserEntity){
        oUserEntity.setId(null);
        oUserEntity.setPassword("e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e");
        return oUserRepository.save(oUserEntity);
    }

    
    public UserEntity update (UserEntity oUserEntity){
        UserEntity oUserEntityAux = oUserRepository.findById(oUserEntity.getId())
        .orElseThrow(()-> new ResourceNotFoundException("User not Found"));
        
        oUserEntityAux.setName(oUserEntity.getName());
        oUserEntityAux.setSurname(oUserEntity.getSurname());
        oUserEntityAux.setLastname(oUserEntity.getLastname());
        oUserEntityAux.setEmail(oUserEntity.getEmail());
        oUserEntityAux.setUsename(oUserEntity.getUsename());
       // oUserEntityAux.setPassword(oUserEntity.getPassword());
        oUserEntityAux.setRole(oUserEntity.getRole());

        
        return oUserRepository.save(oUserEntityAux);
    
   
    }

     public UserEntity delete(Long id) {
        
       UserEntity oUserEntityAux =oUserRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
oUserRepository.deleteById(id);
return oUserEntityAux;
    
    }
    
public Page<UserEntity> getPage(Pageable oPageable){
return oUserRepository.findAll(oPageable);
}



public Long populate (Integer amount){
    for (int i=0; i<amount;i++){
oUserRepository.save(new UserEntity("name"+i, "suername" +i, "lastname" +i, "email"+i, "username" +i,
 "e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e", true));

}
  
return oUserRepository.count();
}
}
