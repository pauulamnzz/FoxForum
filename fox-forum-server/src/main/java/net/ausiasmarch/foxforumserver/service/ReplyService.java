package net.ausiasmarch.foxforumserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable; 
import org.springframework.stereotype.Service;
import net.ausiasmarch.foxforumserver.entity.ReplyEntity;
import net.ausiasmarch.foxforumserver.exception.ResourceNotFoundException;
import net.ausiasmarch.foxforumserver.repository.ReplyRepository;

@Service
public class ReplyService {

    @Autowired
    ReplyRepository oReplyRepository;

    public ReplyEntity get(Long id) {
        return oReplyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Reply not found"));
    }

    public ReplyEntity create(ReplyEntity oReplyEntity) {
        oReplyEntity.setId(null);
        return oReplyRepository.save(oReplyEntity);
    }

    public ReplyEntity update(ReplyEntity oReplyEntity) {
        ReplyEntity oReplyEntityAux = oReplyRepository.findById(oReplyEntity.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Reply not found"));

        oReplyEntityAux.setTitle(oReplyEntity.getTitle());
        oReplyEntityAux.setBody(oReplyEntity.getBody());
        oReplyEntityAux.setId_user(oReplyEntity.getId_user());
        oReplyEntityAux.setId_thread(oReplyEntity.getId_thread());
        return oReplyRepository.save(oReplyEntityAux);
    }

    public ReplyEntity delete(Long id) {
        ReplyEntity oReplyEntityAux = oReplyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reply not found"));
        oReplyRepository.deleteById(id);
        return oReplyEntityAux;
    }

    public Page<ReplyEntity> getPage(Pageable oPageable) {
        return oReplyRepository.findAll(oPageable);
    }

    public Long populate(Integer amount) {
        for (int i = 0; i < amount; i++) {
            oReplyRepository.save(new ReplyEntity(null, "title" + i, "body" + i, (long) i, (long) i));
        }

        return oReplyRepository.count();
    }
}
