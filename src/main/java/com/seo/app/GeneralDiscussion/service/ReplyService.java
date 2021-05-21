package com.seo.app.GeneralDiscussion.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.seo.app.GeneralDiscussion.domain.ReplyDomain;
import com.seo.app.GeneralDiscussion.dto.ReplyDto;
import com.seo.app.GeneralDiscussion.repository.ReplyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public ReplyDto getReply(int replyTo)
    {
        ReplyDomain replyDomain=replyRepository.findByReplyTo(replyTo);
        ReplyDto replyDto=new ReplyDto();
        replyDto.setReply_id(replyDomain.getReplyId());
        replyDto.setName(replyDomain.getName());
        replyDto.setReply_to(replyDomain.getReplyTo());
        replyDto.setMessage(replyDomain.getMessage());
        return replyDto;
    }
}
