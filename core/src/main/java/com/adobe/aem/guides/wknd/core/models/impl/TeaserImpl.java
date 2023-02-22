package com.adobe.aem.guides.wknd.core.models.impl;
import lombok.experimental.Delegate;
import com.adobe.cq.wcm.core.components.models.Teaser;
import lombok.experimental.Delegate;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.*;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.via.ResourceSuperType;

import javax.inject.Inject;
import javax.inject.Named;

@Model(adaptables = {Resource.class, SlingHttpServletRequest.class},
        resourceType = "wknd/components/MyTeaser",
adapters = com.adobe.cq.wcm.core.components.models.Teaser.class,
defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class TeaserImpl implements Teaser {

    @Self // Indicates that we are resolving the current resource
    @Via(type = ResourceSuperType.class) // Resolve not as this model, but as the model of our supertype (ie: CC Image)
   // Delegate all our methods to the CC Image except those defined below
    private Teaser delegate;


    @Inject
    @Default(values = "Teaser")
    @Optional
    @Named("title")
    String title;
    @Override
    public String getTitle() {
        return delegate.getTitle();
    }
}
