package com.azazellj.wp.anotation;


import com.azazellj.wp.anotation.defaults.DefaultContextType;
import com.azazellj.wp.anotation.defaults.DefaultInt;
import com.azazellj.wp.anotation.defaults.DefaultOrder;
import com.azazellj.wp.anotation.defaults.DefaultOrderBy;
import com.azazellj.wp.anotation.defaults.DefaultPostStatus;
import com.azazellj.wp.internal.ContextType;
import com.azazellj.wp.internal.Order;
import com.azazellj.wp.internal.OrderBy;
import com.azazellj.wp.internal.PostStatus;

public enum WPArg implements WPParam {


    /**
     * Scope under which the request is made; determines fields present in response.
     * <p/>
     * Default {@link ContextType#VIEW}
     */
    @DefaultContextType
    CONTEXT("context"),


    /**
     * Current page of the collection.
     * <p/>
     * Default <b>1</b>.
     */
    @DefaultInt
    PAGE("page"),


    /**
     * Maximum number of items to be returned in result set.
     * <p/>
     * Default <b>10</b>.
     */
    @DefaultInt(value = 10)
    PER_PAGE("per_page"),


    /**
     * Limit results to those matching a string.
     */
    SEARCH("search"),


    /**
     * Limit response to posts published after a given ISO8601 compliant date.
     */
    AFTER("after"),


    /**
     * Limit result set to posts assigned to specific authors.
     */

    AUTHOR("author"),


    /**
     * Ensure result set excludes posts assigned to specific authors.
     */
    AUTHOR_EXCLUDE("author_exclude"),


    /**
     * Limit response to posts published before a given ISO8601 compliant date.
     */
    BEFORE("before"),


    /**
     * Ensure result set excludes specific IDs.
     */
    EXCLUDE("exclude"),


    /**
     * Limit result set to specific IDs.
     */
    INCLUDE("include"),


    /**
     * Offset the result set by a specific number of items.
     */
    OFFSET("offset"),


    /**
     * Order sort attribute ascending or descending.
     * <p/>
     * Default <b>{@link Order#DESCEND}</b>.
     */
    @DefaultOrder
    ORDER("order"),


    /**
     * Sort collection by object attribute.
     * <p/>
     * Default <b>{@link OrderBy#DATE}</b>.
     */
    @DefaultOrderBy
    ORDER_BY("orderby"),


    /**
     * Limit result set to posts with one or more specific slugs.
     */
    SLUG("slug"),


    /**
     * Limit result set to posts assigned one or more statuses.
     * <p/>
     * Default <b>{@link PostStatus#PUBLISH}</b>.
     */
    @DefaultPostStatus
    STATUS("status"),


    /**
     * Limit result set to all items that have the specified term assigned in the categories taxonomy.
     */
    CATEGORIES("categories"),


    /**
     * Limit result set to all items except those that have the specified term assigned in the categories taxonomy.
     */
    CATEGORIES_EXCLUDE("categories_exclude"),


    /**
     * Limit result set to all items that have the specified term assigned in the tags taxonomy.
     */
    TAGS("tags"),


    /**
     * Limit result set to all items except those that have the specified term assigned in the tags taxonomy.
     */
    TAGS_EXCLUDE("tags_exclude"),


    /**
     * Limit result set to items that are sticky.
     */
    STICKY("sticky");


    private String argName;


    WPArg(String argName) {
        this.argName = argName;
    }


    @Override
    public String getParamName() {
        return this.argName;
    }
}
