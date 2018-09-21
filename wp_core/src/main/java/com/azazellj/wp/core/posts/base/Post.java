package com.azazellj.wp.core.posts.base;

import com.azazellj.wp.core.base.Route;
//import com.azazellj.wp.anotation.Context;
//import com.azazellj.wp.internal.CommentStatus;
//import com.azazellj.wp.internal.ContextType;
//import com.azazellj.wp.internal.Format;
//import com.azazellj.wp.internal.PingStatus;
//import com.azazellj.wp.internal.PostStatus;
//import com.google.gson.annotations.SerializedName;

public class Post extends Route {

//
//    /**
//     * The date the object was published, in the site's timezone.
//     */
//    @Context(values = {ContextType.VIEW, ContextType.EDIT, ContextType.EMBED})
//    private String date;
//
//
//    /**
//     * The date the object was published, as GMT.
//     */
//
//    @SerializedName("date_gmt")
//    @Context(values = {ContextType.VIEW, ContextType.EDIT})
//    private String dateAsGTM;
//
//
//    /**
//     * The globally unique identifier for the object.
//     * <p/>
//     * Read only.
//     */
//    @Context(values = {ContextType.VIEW, ContextType.EDIT})
//    private Object guid;
//
//
//    /**
//     * Unique identifier for the object.
//     * <p/>
//     * Read only.
//     */
//    @Context(values = {ContextType.VIEW, ContextType.EDIT, ContextType.EMBED})
//    private int id;
//
//
//    /**
//     * URL to the object.
//     * <p/>
//     * Read only.
//     */
//    @Context(values = {ContextType.VIEW, ContextType.EDIT, ContextType.EMBED})
//    private String link;
//
//
//    /**
//     * The date the object was last modified, in the site's timezone.
//     * <p/>
//     * Read only.
//     */
//    @Context(values = {ContextType.VIEW, ContextType.EDIT})
//    private String modified;
//
//
//    /**
//     * The date the object was last modified, as GMT.
//     * <p/>
//     * Read only.
//     */
//    @Context(values = {ContextType.VIEW, ContextType.EDIT})
//    @SerializedName("modified_gmt")
//    private String modifiedAsGTM;
//
//
//    /**
//     * An alphanumeric identifier for the object unique to its type.
//     */
//    @Context(values = {ContextType.VIEW, ContextType.EDIT, ContextType.EMBED})
//    private String slug;
//
//
//    /**
//     * A named status for the object.
//     */
//    @Context(values = {ContextType.VIEW, ContextType.EDIT})
//    private PostStatus status;
//
//
//    /**
//     * Type of Post for the object.
//     */
//    @Context(values = {ContextType.VIEW, ContextType.EDIT, ContextType.EMBED})
//    private String type;
//
//
//    /**
//     * A password to protect access to the content and excerpt.
//     */
//    @Context(values = {ContextType.EDIT})
//    private String password;
//
//
//    /**
//     * The title for the object.
//     */
//    @Context(values = {ContextType.VIEW, ContextType.EDIT, ContextType.EMBED})
//    private Object title;
//
//
//    /**
//     * The content for the object.
//     */
//    @Context(values = {ContextType.VIEW, ContextType.EDIT})
//    private Object content;
//
//
//    /**
//     * The ID for the author of the object.
//     */
//    @Context(values = {ContextType.VIEW, ContextType.EDIT, ContextType.EMBED})
//    private int author;
//
//
//    /**
//     * The excerpt for the object.
//     */
//    @Context(values = {ContextType.VIEW, ContextType.EDIT, ContextType.EMBED})
//    private Object excerpt;
//
//
//    /**
//     * The ID of the featured media for the object.
//     */
//    @SerializedName("featured_media")
//    @Context(values = {ContextType.VIEW, ContextType.EDIT, ContextType.EMBED})
//    private int featuredMedia;
//
//
//    /**
//     * Whether or not comments are open on the object.
//     */
//    @SerializedName("comment_status")
//    @Context(values = {ContextType.VIEW, ContextType.EDIT})
//    private CommentStatus commentStatus;
//
//
//    /**
//     * Whether or not the object can be pinged.
//     */
//    @SerializedName("ping_status")
//    @Context(values = {ContextType.VIEW, ContextType.EDIT})
//    private PingStatus pingStatus;
//
//
//    /**
//     * The format for the object.
//     */
//    @Context(values = {ContextType.VIEW, ContextType.EDIT})
//    private Format format;
//
//
//    /**
//     * Meta fields.
//     */
//    @Context(values = {ContextType.VIEW, ContextType.EDIT})
//    private Object meta;
//
//
//    /**
//     * Whether or not the object should be treated as sticky.
//     */
//    @Context(values = {ContextType.VIEW, ContextType.EDIT})
//    private boolean sticky;
//
//
//    /**
//     * The theme file to use to display the object.
//     */
//    @Context(values = {ContextType.VIEW, ContextType.EDIT})
//    private String template;
//
//
//    /**
//     * The terms assigned to the object in the category taxonomy.
//     */
//    @Context(values = {ContextType.VIEW, ContextType.EDIT})
//    private Object /*Array*/ categories;
//
//
//    /**
//     * The terms assigned to the object in the post_tag taxonomy.
//     */
//    @Context(values = {ContextType.VIEW, ContextType.EDIT})
//    private Object /*Array*/ tags;
//

    @Override
    public String getBaseRoute() {
        return "/wp/v2/posts";
    }
}
