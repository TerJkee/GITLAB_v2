package com.epam.metrics.connectors.rest.jira.models.oldModels;

import com.epam.metrics.connectors.rest.jira.helpers.JiraRestClient;

/**
 * Derived from rcars jira-client
 */
public abstract class Resource {

    public static final String DEFAULT_API_REV = "latest";
    public static String apirev = DEFAULT_API_REV;

    protected JiraRestClient restclient = null;
    protected String id = null;
    protected String self = null;

    /**
     * Creates a new JIRA resource.
     *
     * @param restclient REST client instance
     */
    public Resource(JiraRestClient restclient) {
        this.restclient = restclient;
    }

    /**
     * Gets the JIRA REST API revision number.
     */
    public static String getApiRev() {
        return apirev;
    }

    /**
     * Sets the JIRA REST API revision number.
     */
    public static void setApiRev(String apirev) {
        Resource.apirev = apirev;
    }

    /**
     * Resource base URI with API revision number.
     */
    public static String getBaseUri() {
        return String.format("/rest/api/%s/", apirev);
    }

    /**
     * Resource base URI with API revision number.
     */
    public static String getAuthUri() {
        return String.format("/rest/auth/%s/", apirev);
    }

    /**
     * Internal JIRA ID.
     */
    public String getId() {
        return id;
    }

    /**
     * REST API resource URL.
     */
    public String getUrl() {
        return self;
    }

    /**
     * Resource URL.
     */
    public String getSelf() {
        return self;
    }
}