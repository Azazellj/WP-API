package com.azazellj.wp.anotation.defaults;

import com.azazellj.wp.internal.PostStatus;

public @interface DefaultPostStatus {
    PostStatus value() default PostStatus.PUBLISH;
}
