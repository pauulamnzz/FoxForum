package net.ausiasmarch.foxforumserver.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.ausiasmarch.foxforumserver.entity.ThreadEntity;

import net.ausiasmarch.foxforumserver.service.ThreadService;


@RestController
@RequestMapping("/thread")
public class ThreadApi {
    
     @Autowired
    ThreadService oThreadService;



      @GetMapping("/{id}")
        public ResponseEntity<ThreadEntity> get (@PathVariable ("id") Long id){

    return ResponseEntity.ok(oThreadService.get(id));
    }


     @PostMapping("/")
    public ResponseEntity<ThreadEntity> create (@RequestBody ThreadEntity oThreadEntity ){
        return ResponseEntity.ok(oThreadService.create(oThreadEntity));
    }

    @PutMapping("/")
    public ResponseEntity<ThreadEntity> update (@RequestBody ThreadEntity oThreadEntity){
        return ResponseEntity.ok(oThreadService.update(oThreadEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ThreadEntity> delete (@PathVariable ("id") Long id){
        return ResponseEntity.ok(oThreadService.delete(id));
    }


    @GetMapping("/")
public ResponseEntity<Page<ThreadEntity>> getPage (Pageable oPageable){
    
        return ResponseEntity.ok(oThreadService.getPage(oPageable));
}
  

 @PostMapping("/populate/{amount}")
    public ResponseEntity<Long> populate(@PathVariable("amount") Integer amount) {
        return ResponseEntity.ok(oThreadService.populate(amount));
    }
}
