package com.seo.app.GeneralDiscussion.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.seo.app.GeneralDiscussion.domain.ReplyDomain;
import com.seo.app.GeneralDiscussion.dto.ReplyDto;
import com.seo.app.GeneralDiscussion.repository.ReplyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReplyService {
    private final Logger log = LoggerFactory.getLogger(ReplyService.class);

    @Autowired
    private ReplyRepository replyRepository;

    public String reply(ReplyDto replyDto){
        String responseMessage;
        ReplyDomain replyDomain=new ReplyDomain();
        replyDomain.setName(replyDto.getName());
        replyDomain.setReplyTo(replyDto.getReply_to());
        replyDomain.setMessage(replyDto.getMessage());
        replyRepository.save(replyDomain);
        responseMessage="Replied";
        log.info(responseMessage);
        return responseMessage;
    }
    public List<ReplyDto> getReply(int replyTo)
    {
        List<ReplyDomain> replyDomain=replyRepository.findByReplyTo(replyTo);
        ArrayList<ReplyDto> list=new ArrayList<>();
        for(int i=0;i<replyDomain.size();i++) {
            ReplyDto replyDto = new ReplyDto();
            replyDto.setReply_id(replyDomain.get(i).getReplyId());
            replyDto.setName(replyDomain.get(i).getName());
            replyDto.setReply_to(replyDomain.get(i).getReplyTo());
            replyDto.setMessage(replyDomain.get(i).getMessage());
            replyDto.setTime(replyDomain.get(i).getMessageTime());
            list.add(replyDto);
        }
        return list;
    }
}
