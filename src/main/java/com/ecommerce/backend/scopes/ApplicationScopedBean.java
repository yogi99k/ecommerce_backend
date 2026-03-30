package com.ecommerce.backend.scopes;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

@ApplicationScope
@Component
@Getter @Setter
public class ApplicationScopedBean {
    private int visitorCount;

    public ApplicationScopedBean(){
        System.out.println("ApplicationScopedBean Created!");
    }

    public void increment(){
        visitorCount++;
    }
}
