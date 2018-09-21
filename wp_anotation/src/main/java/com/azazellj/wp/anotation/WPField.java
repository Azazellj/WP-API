package com.azazellj.wp.anotation;

import com.azazellj.wp.internal.ContextType;

public enum WPField implements WPParam {


    /**
     * The date the object was published, in the site's timezone.
     */
    @Context(values = {ContextType.VIEW, ContextType.EDIT, ContextType.EMBED})
    DATE("date"),


    /**
     * The date the object was published, as GMT.
     */
    @Context(values = {ContextType.VIEW, ContextType.EDIT})
    DATE_GTM("date_gmt"),


    /**
     * The globally unique identifier for the object.
     * <p/>
     * Read only.
     */
    @Context(values = {ContextType.VIEW, ContextType.EDIT})
    GUID("guid"),


    /**
     * Unique identifier for the object.
     * <p/>
     * Read only.
     */
    @Context(values = {ContextType.VIEW, ContextType.EDIT, ContextType.EMBED})
    ID("id"),


    /**
     * URL to the object.
     * <p/>
     * Read only.
     */
    @Context(values = {ContextType.VIEW, ContextType.EDIT, ContextType.EMBED})
    LINK("link"),


    /**
     * The date the object was last modified, in the site's timezone.
     * <p/>
     * Read only.
     */
    @Context(values = {ContextType.VIEW, ContextType.EDIT})
    MODIFIED("modified"),


    /**
     * The date the object was last modified, as GMT.
     * <p/>
     * Read only.
     */
    @Context(values = {ContextType.VIEW, ContextType.EDIT})
    MODIFIED_GTM("modified_gtm"),


    /**
     * An alphanumeric identifier for the object unique to its type.
     */
    @Context(values = {ContextType.VIEW, ContextType.EDIT, ContextType.EMBED})
    SLUG("slug"),


    /**
     * A named status for the object.
     */
    @Context(values = {ContextType.VIEW, ContextType.EDIT})
    STATUS("status"),


    /**
     * Type of Post for the object.
     */
    @Context(values = {ContextType.VIEW, ContextType.EDIT, ContextType.EMBED})
    TYPE("type"),


    /**
     * A password to protect access to the content and excerpt.
     */
    @Context(values = {ContextType.EDIT})
    PASSWORD("password"),


    /**
     * The title for the object.
     */
    @Context(values = {ContextType.VIEW, ContextType.EDIT, ContextType.EMBED})
    TITLE("title"),


    /**
     * The content for the object.
     */
    @Context(values = {ContextType.VIEW, ContextType.EDIT})
    CONTENT("content"),


    /**
     * The ID for the author of the object.
     */
    @Context(values = {ContextType.VIEW, ContextType.EDIT, ContextType.EMBED})
    AUTHOR("author"),


    /**
     * The excerpt for the object.
     */
    @Context(values = {ContextType.VIEW, ContextType.EDIT, ContextType.EMBED})
    EXCERPT("excerpt"),


    /**
     * The ID of the featured media for the object.
     */
    @Context(values = {ContextType.VIEW, ContextType.EDIT, ContextType.EMBED})
    FEATURED_MEDIA("featured_media"),


    /**
     * Whether or not comments are open on the object.
     */
    @Context(values = {ContextType.VIEW, ContextType.EDIT})
    COMMENT_STATUS("comment_status"),


    /**
     * Whether or not the object can be pinged.
     */
    @Context(values = {ContextType.VIEW, ContextType.EDIT})
    PING_STATUS("ping_status"),


    /**
     * The format for the object.
     */
    @Context(values = {ContextType.VIEW, ContextType.EDIT})
    FORMAT("format"),


    /**
     * Meta fields.
     */
    @Context(values = {ContextType.VIEW, ContextType.EDIT})
    META("meta"),


    /**
     * Whether or not the object should be treated as sticky.
     */
    @Context(values = {ContextType.VIEW, ContextType.EDIT})
    STICKY("sticky"),


    /**
     * The theme file to use to display the object.
     */
    @Context(values = {ContextType.VIEW, ContextType.EDIT})
    TEMPLATE("template"),


    /**
     * The terms assigned to the object in the category taxonomy.
     */
    @Context(values = {ContextType.VIEW, ContextType.EDIT})
    CATEGORIES("categories"),


    /**
     * The terms assigned to the object in the post_tag taxonomy.
     */
    @Context(values = {ContextType.VIEW, ContextType.EDIT})
    TAGS("tags");


    private String fieldName;


    WPField(String fieldName) {
        this.fieldName = fieldName;
    }


    @Override
    public String getParamName() {
        return this.fieldName;
    }
}
