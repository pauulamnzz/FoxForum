package net.ausiasmarch.foxforumserver.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import net.ausiasmarch.foxforumserver.entity.ReplyEntity;
import net.ausiasmarch.foxforumserver.service.ReplyService;

@RestController
@RequestMapping("/reply")
public class ReplyApi {

    @Autowired
    ReplyService oReplyService;

    @GetMapping("/{id}")
    public ResponseEntity<ReplyEntity> get(@PathVariable("id") Long id) {
        return ResponseEntity.ok(oReplyService.get(id));
    }

    @PostMapping("/")
    public ResponseEntity<ReplyEntity> create(@RequestBody ReplyEntity ReplyEntity) {
        return ResponseEntity.ok(oReplyService.create(ReplyEntity));
    }

    @PutMapping("/")
    public ResponseEntity<ReplyEntity> update(@RequestBody ReplyEntity ReplyEntity) {
        return ResponseEntity.ok(oReplyService.update(ReplyEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ReplyEntity> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(oReplyService.delete(id));
    }

    @GetMapping("/")
    public ResponseEntity<Page<ReplyEntity>> getPage(Pageable oPageable) {
        return ResponseEntity.ok(oReplyService.getPage(oPageable));
    }

    @PostMapping("/populate/{amount}")
    public ResponseEntity<Long> populate(@PathVariable("amount") Integer amount) {
        return ResponseEntity.ok(oReplyService.populate(amount));
    }
}
