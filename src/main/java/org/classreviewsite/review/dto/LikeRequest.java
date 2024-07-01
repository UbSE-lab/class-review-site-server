package org.classreviewsite.review.dto;

import lombok.Data;

@Data
public class LikeRequest {

    private Long userNumber;

    private Long reviewId;

}
