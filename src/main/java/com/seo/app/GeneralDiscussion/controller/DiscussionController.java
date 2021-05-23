package com.seo.app.GeneralDiscussion.controller;

import com.seo.app.GeneralDiscussion.domain.AdminMessageDomain;
import com.seo.app.GeneralDiscussion.domain.DiscussionDomain;
import com.seo.app.GeneralDiscussion.dto.DiscussionDto;
import com.seo.app.GeneralDiscussion.dto.MessageDto;
import com.seo.app.GeneralDiscussion.dto.ReplyDto;
import com.seo.app.GeneralDiscussion.service.AddMessageService;
import com.seo.app.GeneralDiscussion.service.AdminMessageService;
import com.seo.app.GeneralDiscussion.service.ReplyService;
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

    @Autowired
    private AdminMessageService adminMessageService;

    @Autowired
    private ReplyService replyService;

    @PostMapping(path = "/discuss")
    public String getStatus(@RequestBody DiscussionDto discussionDto) {
        log.info("POST Call received at Discussion/add message with DTO" + discussionDto);
        return addMessageService.addMessage(discussionDto);
    }

    @RequestMapping(value = "/discussions",method = RequestMethod.GET)
    public Iterable<DiscussionDomain> getMessages(){
        return addMessageService.getMessage();
    }

    @PostMapping(path = "/message")
    public String sendAdminMessage(@RequestBody MessageDto messageDto) {
        log.info("POST Call received at Message/add message with DTO" + messageDto);
        return adminMessageService.addMessage(messageDto);
    }

    @RequestMapping(value = "/message",method = RequestMethod.GET)
    public Iterable<AdminMessageDomain> getAdminMessages(){
        return adminMessageService.getMessage();
    }

    @PostMapping(path = "/reply")
    public String sendReplyMessage(@RequestBody ReplyDto replyDto) {
        log.info("POST Call received at Reply/add reply with DTO" + replyDto);
        return replyService.reply(replyDto);
    }

    @RequestMapping(value = "/get/reply", method = RequestMethod.POST)
    public ReplyDto replyMessage(@RequestParam(value = "reply_to") int replyTo){
        log.info("POST Call received at Reply/reply to User" + replyTo);
        return replyService.getReply(replyTo);
    }

    @RequestMapping(value = "/user/message", method = RequestMethod.POST)
    public MessageDto userMessage(@RequestParam(value = "user") int user){
        log.info("POST Call received at msg/msg to Admin" + user);
        return adminMessageService.getMessage(user);
    }
}
