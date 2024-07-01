package org.classreviewsite.review.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReviewPostRequest {

    private String postTitle;

    private String postContent;

    private Long starLating;

    private String lecName;

    private Long userNumber;


}
