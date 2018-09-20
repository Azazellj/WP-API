package com.azazellj.wp;

import com.azazellj.wp.anotation.WPArg;
import com.azazellj.wp.anotation.WPArgsBuilder;
import com.azazellj.wp.anotation.WPField;

public interface AppPostsHelper {
    @WPArgsBuilder(
            className = "GetPostBuilder",
            args = {
                    WPArg.CONTEXT,
                    WPArg.PAGE,
                    WPArg.PER_PAGE,
                    WPArg.SEARCH,
                    WPArg.AFTER,
                    WPArg.AUTHOR,
                    WPArg.AUTHOR_EXCLUDE,
                    WPArg.BEFORE,
                    WPArg.EXCLUDE,
                    WPArg.INCLUDE,
                    WPArg.OFFSET,
                    WPArg.ORDER,
                    WPArg.ORDER_BY,
                    WPArg.SLUG,
                    WPArg.STATUS,
                    WPArg.CATEGORIES,
                    WPArg.CATEGORIES_EXCLUDE,
                    WPArg.TAGS,
                    WPArg.STICKY
            })
    void listPosts();

    @WPArgsBuilder(
            className = "CreatePostBuilder",
            args = {
                    WPArg.CONTEXT
            },
            fields = {
                    WPField.ID,
                    WPField.PASSWORD
            })
    void createPost();
}
