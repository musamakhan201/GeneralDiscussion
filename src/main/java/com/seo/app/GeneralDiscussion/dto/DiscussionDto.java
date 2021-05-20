package com.seo.app.GeneralDiscussion.dto;

import lombok.*;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DiscussionDto {
    private int discussion_id;
    private String name;
    private String message;
}
