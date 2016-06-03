![Under construction](https://upload.wikimedia.org/wikipedia/commons/f/f9/Road-under-construction.png "Under construction")

<sup>(all together now...)</sup>

# cucumber-jvm-java-maven-parallel-picocontainer-selenium-webdriver-pagefactory-skeleton
*Because no-one else should have to suffer what I did to work this out*

All the things required to run cucumber-jvm in parallel and cross-browser in one repo. No, thank *you*.

## Usage

`mvn test` to run the test you're currently working on (tagged with `@wip`)

`mvn verify` to run in parallel all tests tagged `@complete`

### Parallel test execution

Currently hardcoded in the pom.xml file to run 2 feature files at a time. This is set in the
`acceptance.test.parallel.count` property.

Parallel test functionality provided by the [cucumber-jvm-parallel-plugin](https://github.com/temyers/cucumber-jvm-parallel-plugin)

### Cross browser

`mvn test -Dbrowser=chrome`

Options are:

- `firefox` (default)
- `chrome`
- `ie`

Driver executable locations are currently hardcoded in the browser classes in the `automation.ui`
packages. Hack as necessary.

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
- [x] `mvn test` for wip, `mvn verify` for regression
- [ ] Example tests

## Acknowledgements

- https://opencredo.com/test-automation-concepts-parallel-test-execution/
- https://azevedorafaela.wordpress.com/2015/11/25/polymorphic-step-definitions-with-cucumber-jvm/
