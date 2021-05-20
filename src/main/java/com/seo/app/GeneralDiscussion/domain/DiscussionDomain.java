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
@Table(name = "discussion")
public class DiscussionDomain {
    private static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("discussion_id")
    @Column(name = "discussion_id")
    private int discussionId;
    private String name;
    private String message;
    @Column(columnDefinition="DATETIME")
    @JsonProperty("message_time")
    private String messageTime;

    public DiscussionDomain() {
        ZonedDateTime utc = ZonedDateTime.now(ZoneOffset.UTC);
        messageTime = utc.format(DateTimeFormatter.ofPattern(DATETIME_FORMAT));
    }
}
