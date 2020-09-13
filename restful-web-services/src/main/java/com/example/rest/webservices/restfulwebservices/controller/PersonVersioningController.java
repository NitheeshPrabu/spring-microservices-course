package com.example.rest.webservices.restfulwebservices.controller;

import com.example.rest.webservices.restfulwebservices.versioning.Name;
import com.example.rest.webservices.restfulwebservices.versioning.PersonV1;
import com.example.rest.webservices.restfulwebservices.versioning.PersonV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class PersonVersioningController {

    @GetMapping(path = "/v1/person")
    public PersonV1 getV1PersonUsingUri() {
        return new PersonV1("Person One");
    }

    @GetMapping(path = "/v2/person")
    public PersonV2 getV2PersonUsingUri() {
        return new PersonV2(new Name("Person", "Two"));
    }

    @GetMapping(value = "/person/params", params = "version=1")
    public PersonV1 getV1PersonUsingParams() {
        return new PersonV1("Person One");
    }

    @GetMapping(value = "/person/params", params = "version=2")
    public PersonV2 getV2PersonUsingParams() {
        return new PersonV2(new Name("Person", "Two"));
    }

    @GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 getV1PersonUsingHeader() {
        return new PersonV1("Person One");
    }

    @GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 getV2PersonUsingHeader() {
        return new PersonV2(new Name("Person", "Two"));
    }

    @GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v1+json")
    public PersonV1 getV1PersonUsingMediaType() {
        return new PersonV1("Person One");
    }

    @GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v2+json")
    public PersonV2 getV2PersonUsingMediaType() {
        return new PersonV2(new Name("Person", "Two"));
    }
}
