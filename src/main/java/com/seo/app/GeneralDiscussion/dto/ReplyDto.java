package com.seo.app.GeneralDiscussion.dto;

import lombok.*;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReplyDto {
    private int reply_id;
    private int reply_to;
    private String name;
    private String message;
    private String time;
}
