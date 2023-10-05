package net.ausiasmarch.foxforumserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.ausiasmarch.foxforumserver.entity.ThreadEntity;
import net.ausiasmarch.foxforumserver.exception.ResourceNotFoundException;
import net.ausiasmarch.foxforumserver.repository.ThreadRepository;


@Service
public class ThreadService {


    @Autowired
ThreadRepository oThreadRepository;


 public ThreadEntity get (Long id){
    return oThreadRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found"));

    }


 public ThreadEntity create (ThreadEntity oThreadEntity){
        oThreadEntity.setId(null);
        return oThreadRepository.save(oThreadEntity);
    }

    public ThreadEntity update (ThreadEntity oThreadEntity){

        ThreadEntity oThreadEntityAux = oThreadRepository.findById(oThreadEntity.getId()).orElseThrow(()-> new ResourceNotFoundException("User not Found"));
        
        oThreadEntityAux.setTitle(oThreadEntity.getTitle());
        oThreadEntityAux.setId_user(oThreadEntity.getId_user());
        return oThreadRepository.save(oThreadEntityAux);
        
    
    }
public ThreadEntity delete(Long id) {
        
       ThreadEntity oThreadEntityAux =oThreadRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
oThreadRepository.deleteById(id);
return oThreadEntityAux;
    
    }
public Page<ThreadEntity> getPage(Pageable oPageable){
return oThreadRepository.findAll(oPageable);
}

public Long populate (Integer amount){
    for (int i=0; i<amount;i++){
 oThreadRepository.save(new ThreadEntity("title" + i, (long) i));
}
  
return oThreadRepository.count();
}
}
