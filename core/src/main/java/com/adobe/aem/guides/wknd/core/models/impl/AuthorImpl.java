package com.adobe.aem.guides.wknd.core.models.impl;


import com.adobe.aem.guides.wknd.core.models.Author;
import com.day.cq.wcm.api.Page;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.*;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;

import javax.inject.Inject;
import javax.inject.Named;

@Model(adaptables = SlingHttpServletRequest.class,
        adapters = Author.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class AuthorImpl implements Author {
@ScriptVariable
    Page currentPage;

    @Inject
    @Via("resource")
    @Default(values = "prachi")
    @Optional
    @Named("fname")
    String fname;

    @Inject
    @Via("resource")
    @Default(values = "shingade")
    @Optional
    @Named("lname")
    String lname;

    @Override
    public String getFirstName() {
        return fname;
    }

    @Override
    public String getLastName() {
        return lname;
    }

    @Override
    public String getPageTitle() {
        return currentPage.getTitle();
    }
}
