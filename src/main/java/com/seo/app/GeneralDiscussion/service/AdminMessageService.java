package com.seo.app.GeneralDiscussion.service;

import com.seo.app.GeneralDiscussion.domain.AdminMessageDomain;
import com.seo.app.GeneralDiscussion.dto.MessageDto;
import com.seo.app.GeneralDiscussion.repository.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminMessageService {

    private final Logger log = LoggerFactory.getLogger(AdminMessageService.class);

    @Autowired
    private MessageRepository messageRepository;

    public String addMessage(MessageDto messageDto){
        String response;
        AdminMessageDomain adminMessageDomain=new AdminMessageDomain();
        adminMessageDomain.setName(messageDto.getName());
        adminMessageDomain.setUser(messageDto.getUser());
        adminMessageDomain.setMessage(messageDto.getMessage());
        messageRepository.save(adminMessageDomain);
        response="Message Send";
        log.info(response);
        return response;
    }

    public Iterable<AdminMessageDomain> getMessage() {
        return messageRepository.findAll();
    }

    public MessageDto getMessage(int user)
    {
        AdminMessageDomain messageDomain=messageRepository.findByUser(user);
        MessageDto messageDto=new MessageDto();
        messageDto.setQuestion_id(messageDomain.getQuestionId());
        messageDto.setUser(messageDomain.getUser());
        messageDto.setMessage(messageDomain.getMessage());
        messageDto.setName(messageDomain.getName());
        messageDto.setMessage(messageDomain.getMessage());
        messageDto.setTime(messageDomain.getMessageTime());
        return messageDto;
    }
}
