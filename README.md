![Under construction](https://upload.wikimedia.org/wikipedia/commons/f/f9/Road-under-construction.png "Under construction")

<sup>(all together now...)</sup>

# cucumber-jvm-java-maven-parallel-picocontainer-selenium-webdriver-pagefactory-skeleton
*Because no-one else should have to suffer what I did to work this out*

All the things required to run cucumber-jvm in parallel and cross-browser in one repo. No, thank *you*.

## Usage

Convention suggests that the Maven [surefire](http://maven.apache.org/surefire) should be used for unit tests and the [failsafe](http://maven.apache.org/surefire/maven-failsafe-plugin/usage.html) plugin should be used for integration testing.  The main reason for this is that surefire will automatically fail the build on any unit test failure but the failsafe plugin allows for greater developer control over how failure should impact overall build status.

`mvn test` to run unit tests (currently just an example unit test)

`mvn verify` to run the feature/scenario you're currently working on (tagged with `@wip`)

`mvn -Dcucumber.opts="--tags @foo" verify` to run features/scenarios tagged `@foo`

`mvn -Dcucumber.opts="classpath:features/more_web_searching.feature:12" verify` to run a single scenario by line number

`mvn -Pparallel-cuke verify` to run in parallel all tests tagged `@complete`

> It's worth being aware that the failsafe `integration-test` goal will NOT fail a build, this is why you would typically run `verify`.  Note also unit tests will ALWAYS run regardless of your target goal - this is intentional.

> Also worth noting the failsafe output regarding the number of tests is incorrect, it counts steps and the scenario itself so a single scenario comprising 4 steps counts as 5 tests! For more info see this [issue](https://github.com/cucumber/cucumber-jvm/issues/263)

### Clean Build Outputs

`mvn clean` will remove the `target` directory and all the compiled resources and reports.

## Requirements

- Java 8
- Maven 3.3

### Parallel test execution

Currently hardcoded in the pom.xml file to run 2 feature files at a time. This is set in the
`acceptance.test.parallel.count` property.

Results of parallel execution are in `junit` and `json` format and can be found in the `target/cucumber-parallel` directory as configured in the pom.xml file. This allows standard Jenkins JUnit reporting and the slightly more eye catching [cucumber reports](https://github.com/jenkinsci/cucumber-reports-plugin) plugin.

Parallel test functionality provided by the [cucumber-jvm-parallel-plugin](https://github.com/temyers/cucumber-jvm-parallel-plugin) which generates the 'runner classes' (see `target/generated-test-sources/cucumber`) and the [maven-failsafe-plugin](http://maven.apache.org/surefire/maven-failsafe-plugin/usage.html).

### Cross browser

`mvn test -Dbrowser=chrome`

Options are:

- `firefox` (default)
- `chrome`
- `ie`

Driver executable locations are currently hardcoded in the browser classes in the `automation.ui`
packages. Hack as necessary.

### Service Testing (REST and friends...)

We are using [REST-assured](https://github.com/rest-assured/rest-assured) as our client of choice.  It exposes a nice [DSL](https://en.wikipedia.org/wiki/Domain-specific_language) for testing REST like services, meaning more time spent thinking about the problem and less about boilerplate code. Note REST-assured is happy working with both JSON and XML (and therefore also HTML).

If you want to TDD your service test classes with a fake service running over http then [Wiremock](https://github.com/tomakehurst/wiremock) is your friend.  The included [examples](src/test/java/unit/BBCServiceTest.java) illustrate how this can be achieved.

## Project status

- [x] [Mavenized](https://maven.apache.org/pom.html) the project
- [x] [Cucumber](https://cucumber.io/) test runner, because shiny
- [x] [Picocontainer integration](https://cucumber.io/blog/2015/07/08/polymorphic-step-definitions), because [dependency injection](http://martinfowler.com/articles/injection.html)
- [x] JUnit format output, because [continuous delivery](https://continuousdelivery.com/foundations/test-automation/)
- [x] Parallel test execution, because slightly faster snail
- [x] [Selenium Webdriver](http://www.seleniumhq.org/projects/webdriver/), because browser testing
- [x] [PageFactory](https://github.com/SeleniumHQ/selenium/wiki/PageFactory), because page object model
- [x] Cross-browser, because cross-browser
- [ ] Target env a runtime switch, because flexible
- [x] `mvn test` for unit, `mvn verify` for wip, `mvn verify -Pparallel-cuke` for full regression in parallel
- [x] Logging with slf4j/logback, because useful
- [ ] Example tests

## Acknowledgements

- https://opencredo.com/test-automation-concepts-parallel-test-execution/
- https://azevedorafaela.wordpress.com/2015/11/25/polymorphic-step-definitions-with-cucumber-jvm/
