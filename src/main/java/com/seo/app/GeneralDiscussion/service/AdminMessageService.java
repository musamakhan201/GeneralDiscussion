package com.seo.app.GeneralDiscussion.service;

import com.seo.app.GeneralDiscussion.domain.AdminMessageDomain;
import com.seo.app.GeneralDiscussion.dto.MessageDto;
import com.seo.app.GeneralDiscussion.repository.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<MessageDto> getMessage(int user)
    {
        List<AdminMessageDomain> messageDomain=messageRepository.findByUser(user);
        ArrayList<MessageDto> messageList=new ArrayList<>();
        for(int i=0;i<messageDomain.size();i++) {
            MessageDto messageDto=new MessageDto();
            messageDto.setQuestion_id(messageDomain.get(i).getQuestionId());
            messageDto.setUser(messageDomain.get(i).getUser());
            messageDto.setMessage(messageDomain.get(i).getMessage());
            messageDto.setName(messageDomain.get(i).getName());
            messageDto.setMessage(messageDomain.get(i).getMessage());
            messageDto.setTime(messageDomain.get(i).getMessageTime());
            messageList.add(messageDto);
        }
        return messageList;
    }
}
