package com.azazellj.wp.core.posts;

import com.azazellj.wp.anotation.WPArg;
import com.azazellj.wp.anotation.WPArgsBuilder;
import com.azazellj.wp.anotation.WPField;

@SuppressWarnings("unused")
public interface PostsHelper {


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
            fields = {
                    WPField.DATE,
                    WPField.DATE_GTM,
                    WPField.SLUG,
                    WPField.STATUS,
                    WPField.PASSWORD,
                    WPField.TITLE,
                    WPField.CONTENT,
                    WPField.AUTHOR,
                    WPField.EXCERPT,
                    WPField.FEATURED_MEDIA,
                    WPField.COMMENT_STATUS,
                    WPField.PING_STATUS,
                    WPField.FORMAT,
                    WPField.META,
                    WPField.STICKY,
                    WPField.TEMPLATE,
                    WPField.CATEGORIES,
                    WPField.TAGS
            }
    )
    void createPost();


    @WPArgsBuilder(
            className = "RetrievePostBuilder",
            args = {
                    WPArg.CONTEXT
            },
            fields = {
                    WPField.ID,
                    WPField.PASSWORD
            })
    void retrievePost();


    @WPArgsBuilder(
            className = "UpdatePostBuilder",
            fields = {
                    WPField.ID,
                    WPField.DATE,
                    WPField.DATE_GTM,
                    WPField.SLUG,
                    WPField.STATUS,
                    WPField.PASSWORD,
                    WPField.TITLE,
                    WPField.CONTENT,
                    WPField.AUTHOR,
                    WPField.EXCERPT,
                    WPField.FEATURED_MEDIA,
                    WPField.COMMENT_STATUS,
                    WPField.PING_STATUS,
                    WPField.FORMAT,
                    WPField.META,
                    WPField.STICKY,
                    WPField.TEMPLATE,
                    WPField.CATEGORIES,
                    WPField.TAGS
            }
    )
    void updatePost();


    @WPArgsBuilder(
            className = "DeletePostBuilder",
            args = {WPArg.FORCE},
            fields = {WPField.ID}
    )
    void deletePost();
}
