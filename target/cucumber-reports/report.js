$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/wikipedia.feature");
formatter.feature({
  "name": "Validate Wikipedia Search",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Wiki"
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user navigates to \"https://www.wikipedia.org/\"",
  "keyword": "Given "
});
formatter.match({
  "location": "BaseSteps.userNavigatesTo(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Validate Wikipedia main languages",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Wiki"
    },
    {
      "name": "@WikiLanguages"
    }
  ]
});
formatter.step({
  "name": "user should see below languages around the logo",
  "rows": [
    {
      "cells": [
        "English",
        "Русский",
        "日本語",
        "Deutsch",
        "Français",
        "Español",
        "Italiano",
        "中文",
        "فارسی",
        "Polski"
      ]
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "WikipediaSteps.user_should_see_below_languages_around_the_logo(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});