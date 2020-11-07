package com.in28minutes.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

    //URI Versioning
    @GetMapping("v1/person")
    public PersonV1 personV1() {
        return new PersonV1("Indranil Sarkar");
    }

    @GetMapping("v2/person")
    public PersonV2 personV2() {
        return new PersonV2(new Name("Indranil", "Sarkar"));
    }

    //Request Parameter Versioning
    @GetMapping(value = "/person/param", params = "version=1")
    public PersonV1 paramsV1() {
        return new PersonV1("Indranil Sarkar");
    }

    @GetMapping(value = "/person/param", params = "version=2")
    public PersonV2 paramsV2() {
        return new PersonV2(new Name("Indranil", "Sarkar"));
    }

    //Header Versioning
    @GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
    public PersonV2 headerV1() {
        return new PersonV2(new Name("Indranil", "Sarkar"));
    }

    @GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 headerV2() {
        return new PersonV2(new Name("Indranil", "Sarkar"));
    }

    //Media Type Versioning
    @GetMapping(value = "/person/produces", produces = "application/example.company.app-v1+json")
    public PersonV2 producesV1() {
        return new PersonV2(new Name("Indranil", "Sarkar"));
    }

    @GetMapping(value = "/person/produces", produces = "application/example.company.app-v2+json")
    public PersonV2 producesV2() {
        return new PersonV2(new Name("Indranil", "Sarkar"));
    }
}
