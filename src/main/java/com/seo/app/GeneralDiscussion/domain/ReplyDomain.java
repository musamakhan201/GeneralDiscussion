package com.seo.app.GeneralDiscussion.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@ToString
@Getter
@Setter
@Entity
@AllArgsConstructor
@Table(name = "admin_reply")
public class ReplyDomain {
    private static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("reply_id")
    @Column(name = "reply_id")
    private int replyId;
    private String name;
    private String message;
    @JsonProperty("reply_to")
    @Column(name = "reply_to")
    private int replyTo;
    @Column(columnDefinition="DATETIME")
    @JsonProperty("message_time")
    private String messageTime;

    public ReplyDomain() {
        ZonedDateTime utc = ZonedDateTime.now(ZoneOffset.UTC);
        messageTime = utc.format(DateTimeFormatter.ofPattern(DATETIME_FORMAT));
    }
}
