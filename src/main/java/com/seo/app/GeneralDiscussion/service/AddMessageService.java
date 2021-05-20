package com.seo.app.GeneralDiscussion.service;

import com.seo.app.GeneralDiscussion.domain.DiscussionDomain;
import com.seo.app.GeneralDiscussion.dto.DiscussionDto;
import com.seo.app.GeneralDiscussion.repository.DiscussionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddMessageService {
    private final Logger log = LoggerFactory.getLogger(AddMessageService.class);

    @Autowired
    private DiscussionRepository discussionRepository;

    public String addMessage(DiscussionDto discussionDto){
        String response;
        DiscussionDomain discussionDomain=new DiscussionDomain();
        discussionDomain.setName(discussionDto.getName());
        discussionDomain.setMessage(discussionDto.getMessage());
        discussionRepository.save(discussionDomain);
        response="Message Send";
        log.info(response);
        return response;
    }

    public Iterable<DiscussionDomain> getMessage() {
        return discussionRepository.findAll();
    }

}
