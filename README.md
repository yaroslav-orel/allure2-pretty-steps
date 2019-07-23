# allure2-pretty-steps

[ ![Download](https://api.bintray.com/packages/yaroslav-orel/allure2-pretty-steps/allure2-pretty-steps/images/download.svg) ](https://bintray.com/yaroslav-orel/allure2-pretty-steps/allure2-pretty-steps/_latestVersion)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.yaroslav-orel/allure2-pretty-steps/badge.svg?style=flat)](https://maven-badges.herokuapp.com/maven-central/com.github.yaroslav-orel/allure2-pretty-steps)
[![Open Source Love](https://badges.frapsoft.com/os/mit/mit.svg?v=102)](https://github.com/ellerbrock/open-source-badge/)

Convert ```Allure2``` camel case ```@Step```s into human readable format

# Motivitation
```Allure2``` java bindings don't convert method name into human readable format
```
@Step
public void stepName(){}
```
So above Step will show up in ```Allure2``` report like this 

```stepName``` 

In order to make it more readable, client needs to manually set ```@Step```'s value which would look like
```
@Step("Step Name")
public void stepName(){}
```
While it is useful to be able to manually set ```@Step```'s value, one can develop a habit ofter repeating method name in ```@Step```'s value which seems redundant.

With ```allure2-pretty-steps``` there's no need to manually set ```@Step```'s value because method name is automatically converted to human readable format and supplied to ```Allure2``` report.

# Usage

Just add ```allure2-pretty-steps``` to your build file 

### Maven
```
<dependency>
	<groupId>com.github.yaroslav-orel</groupId>
	<artifactId>allure2-pretty-steps</artifactId>
	<version>1.0</version>
</dependency>
```

### Gradle
```
implementation 'com.github.yaroslav-orel:allure2-pretty-steps:1.0'
```
