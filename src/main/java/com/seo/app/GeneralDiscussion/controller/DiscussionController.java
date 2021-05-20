package com.seo.app.GeneralDiscussion.controller;

import com.seo.app.GeneralDiscussion.domain.DiscussionDomain;
import com.seo.app.GeneralDiscussion.dto.DiscussionDto;
import com.seo.app.GeneralDiscussion.service.AddMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("seo")
public class DiscussionController {
    private final Logger log = LoggerFactory.getLogger(DiscussionController.class);

    @Autowired
    private AddMessageService addMessageService;

    @PostMapping(path = "/discuss")
    public String getStatus(@RequestBody DiscussionDto discussionDto) {
        log.info("POST Call received at Discussion/add message with DTO" + discussionDto);
        return addMessageService.addMessage(discussionDto);
    }

    @RequestMapping(value = "/discussions",method = RequestMethod.GET)
    public Iterable<DiscussionDomain> getMessages(){
        return addMessageService.getMessage();
    }
}
