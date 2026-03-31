package com.ecommerce.backend.scopes;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/scope")
public class ScopeController {

    private final RequestScopedBean requestScopedBean;
    private final SessionScopedBean sessionScopedBean;
    private final ApplicationScopedBean applicationScopedBean;

    @GetMapping("/request")
    public ResponseEntity<String> testRequestScope(){
        requestScopedBean.setUserName("Yogi Reddy");
        return ResponseEntity.ok().body(requestScopedBean.getUserName());
    }

    @GetMapping("/session")
    public ResponseEntity<String> testSessionScope(){
        sessionScopedBean.setUserName("Yogi Reddy");
        return ResponseEntity.ok().body(sessionScopedBean.getUserName());
    }

    @GetMapping("/test")
    public ResponseEntity<Integer> testScope(){
        //requestScopedBean.setUserName("Yogi Reddy");
        return ResponseEntity.ok().body(applicationScopedBean.getVisitorCount());
    }

    @GetMapping("/application")
    public ResponseEntity<Integer> testApplicationScope(){
        applicationScopedBean.increment();
        return ResponseEntity.ok().body(applicationScopedBean.getVisitorCount());
    }
}
