// package com.kgisl.Spring;

// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.ResponseBody;

// @Controller
// @RequestMapping("/req")
// public class mappingController {
    // @RequestMapping(value = "/ex/foos", method = RequestMethod.GET)
    // @ResponseBody
    // public String getFoosBySimplePath() {
    // return "Get some Foos";
    // }

    // @RequestMapping(value = "/ex/foos", method =RequestMethod.POST)
    // @ResponseBody
    // public String postFoos() {
    // return "Post some Foos";
    // }

    // @RequestMapping(value = "/ex/foos", headers = "key=josh sannam", method =
    // RequestMethod.GET)
    // @ResponseBody
    // public String getFoosWithHeader() {
    // return "Get some Foos with Header";
    // }

    // @RequestMapping(value = "/ex/foos", headers = { "key1=val1", "key2=val2" },
    // method = RequestMethod.GET)
    // @ResponseBody
    // public String getFoosWithHeaders() {
    // return "Get some Foos with Header";
    // }

    // @RequestMapping(
    // value = "/ex/foos",
    // method = RequestMethod.GET,
    // headers = "Accept=application/json")
    // @ResponseBody
    // public String getFoosAsJsonFromBrowser() {
    // return "Get some Foos with Header Old";
    // }

    // @RequestMapping(value = "/ex/foos", method = RequestMethod.GET, produces =
    // "application/json")
    // @ResponseBody
    // public String getFoosAsJsonFromREST() {
    // return "Get some Foos with Header New";
    // }

    // @RequestMapping(value = "/ex/foos", method = RequestMethod.GET, produces = {
    // "application/json",
    // "application/xml" })
    // @ResponseBody
    // public String getFoosAsJsonFromREST() {
    // return "Get some Foos with Header New";
    // }

    // @RequestMapping(value = "/ex/foos/{id}", method = RequestMethod.GET)
    // @ResponseBody
    // public String getFoosBySimplePathWithPathVariable(
    // @PathVariable("id") long id) {
    // return "Get a specific Foo with id=" + id;
    // }

    // @RequestMapping(value = "/ex/foos/{fooid}/bar/{barid}", method =
    // RequestMethod.GET)
    // @ResponseBody
    // public String getFoosBySimplePathWithPathVariables(@PathVariable("fooid")
    // long fooid,
    // @PathVariable("barid") long barid) {
    // return "Get a specific Bar with id=" + barid +
    // " from a Foo with id=" + fooid;
    // }

    // @RequestMapping(value = "/ex/bars/{numericId:[\\d]+}", method =
    // RequestMethod.GET)
    // @ResponseBody
    // public String getBarsBySimplePathWithPathVariable(
    // @PathVariable("numericId") long numericId) {
    // return "Get a specific Bar with id=" + numericId;
    // }

    // @RequestMapping(value = "/ex/bars", method = RequestMethod.GET)
    // @ResponseBody
    // public String getBarBySimplePathWithRequestParam(
    // @RequestParam("id") long id) {
    // return "Get a specific Bar with id=" + id;
    // }

    // @RequestMapping(value = "/ex/bars", params = "id", method =
    // RequestMethod.GET)
    // @ResponseBody
    // public String getBarBySimplePathWithExplicitRequestParam(
    // @RequestParam("id") long id) {
    // return "Get a specific Bar with id=" + id;
    // }

    // @RequestMapping(value = "/ex/bars", params = { "id", "second" }, method =
    // RequestMethod.GET)
    // @ResponseBody
    // public String getBarBySimplePathWithExplicitRequestParams(
    // @RequestParam("id") long id , @RequestParam("second") long second) {
    // return "Narrow Get a specific Bar with id=" + id + second;
    // }

    // @RequestMapping(value = { "/ex/advanced/bars", "/ex/advanced/foos" }, method = RequestMethod.GET)
    // @ResponseBody
    // public String getFoosOrBarsByPath() {
    //     return "Advanced - Get some Foos or Bars";
    // }
// }
