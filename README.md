<sup>(all together now...)</sup>
# cucumber-jvm-java-maven-parallel-picocontainer-selenium-webdriver-pagefactory-skeleton
*Because no-one else should have to suffer what I did to work this out*

All the things in one project. No, thank *you*.

## Usage

`mvn integration-test`

`mvn integration-test -Dbrowser=chrome`

## Project status

- [x] [Mavenized](https://maven.apache.org/pom.html) the project
- [x] [Cucumber](https://cucumber.io/) test runner, because shiny
- [x] [Picocontainer integration](https://cucumber.io/blog/2015/07/08/polymorphic-step-definitions), because [dependency injection](http://martinfowler.com/articles/injection.html)
- [ ] JUnit format output, because [continuous delivery](https://continuousdelivery.com/foundations/test-automation/)
- [x] Parallel test execution, because slightly faster snail
- [x] [Selenium Webdriver](http://www.seleniumhq.org/projects/webdriver/), because browser testing
- [x] [PageFactory](https://github.com/SeleniumHQ/selenium/wiki/PageFactory), because page object model
- [x] Cross-browser, because cross-browser
- [ ] Target env a runtime switch, because flexible
- [ ] `mvn test` for wip, `mvn integration-test` for regression
- [ ] Example tests
