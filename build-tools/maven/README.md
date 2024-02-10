# Archetype

It is template

You can check what the archetypes will generate and what to provide for them. 

```
mvn archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4
```

> in windows probably powershell and cmd the properties need to be in double quotes

# POM contains
1. General Project Information
2. Build Settings
3. Build Environment 
4. POM Relations

# Package types
```
<packaging>jar</packaging>   - Java Application (JAR)
<packaging>war</packaging>   - Web Application  (WAR)
<packaging>pom</packaging>   - Maven Project    (POM)
```

# Life Cycles 
1. Clean
2. default or build
3. site

Each one of them has its own list of phases.

Clean phases
```
mvn help::describe -Dcmd=clean

* pre-clean: Not defined
* clean: org.apache.maven.plugins:maven-clean-plugin:3.2.0:clean
* post-clean: Not defined
```

Default phases
```
mvn help::describe -Dcmd=compile

It is a part of the lifecycle for the POM packaging 'pom'. This lifecycle includes the following phases:
* *validate*: Not defined
* initialize: Not defined
* generate-sources: Not defined
* process-sources: Not defined
* generate-resources: Not defined
* process-resources: Not defined
* *compile*: Not defined 
* process-classes: Not defined
* generate-test-sources: Not defined
* process-test-sources: Not defined
* generate-test-resources: Not defined
* process-test-resources: Not defined
* test-compile: Not defined
* process-test-classes: Not defined
* *test*: Not defined
* prepare-package: Not defined
* *package*: Not defined
* pre-integration-test: Not defined
* integration-test: Not defined
* post-integration-test: Not defined
* *verify*: Not defined
* *install*: org.apache.maven.plugins:maven-install-plugin:3.1.1:install
* *deploy*: org.apache.maven.plugins:maven-deploy-plugin:3.1.1:deploy
```

Jar packaging phases
```
process-resources
compile
process-test-resources
test-compile
test
package
install
deploy
```

Site phases
```
pre-site
site
post-site
site-deploy
```

# Plugins

Each plugin has goals.

To execute it 
```
mvn clean:clean compiler:compile
```

> Life Cycles -> Phases -> Goals

All the work done in maven is done by plugins. 

Plugins and phases provide the framework to call plugin goals in a sequence.

So actually the default compile phase calls compiler:compile goal

Important goals:
- dependency:tree - show project dependencies tree
- dependency:go-offline  - resolve all dependencies from remote repositories without checking for updates (useful to avoid network issues). Resolve all, prepare to go offline
- dependency:purge-local-repository - remove dependencies from local repository
- dependency:sources - get sources for all dependencies

# Dependency's scopes
1. compile - is the default scope; means dependency is available in all build phases an packaged with application
2. test - available only during test compilation and execution phases
3. provided - used when you expect the JDK or a container to provide the dependency
4. runtime - require to execute and test the system, NOT required for compilation.
5. system - similar to provided except you need to provide an explicit path to the JAR on the local file system
6. Import - imports dependency of pom

## Optional
Makes it so importing project that has dependency marked as optional mandatory to declare a dependency in the our project. Similar to abstract classes or interfaces the dependencies need to be with common interface.

Good example is SLF4J - The Simple Logging Facade for Java (SLF4J) serves as a simple facade or abstraction for various logging frameworks (e.g. java.util.logging, logback, log4j) allowing the end user to plug in the desired logging framework at deployment time.

We add the api and select the implementation we want to use.

# Maven coordinates
1. groupId
2. artifactId
3. version
* major version
* minor version
* incremental version
* build number 
* qualifier - string 'beta'

groupId and version can be inherited from a parent pom.

# Repository types
1. Local
2. Central
3. Remote
- jboss, oracle ... 
- private (Nexus, Artifactory) - hosted by the company for internal artifacts

# Maven Wagon
API for getting the dependencies through different protocols - HTTP/S, FTP, SSH, SCM ...

Often used when setting a proxy.

# Dependencies
1. Dependency - typically jar or pom
2. Transitive dependency - a dependency of an artifact which your project depends on. Many layers of dependencies.
3. Dependency management - allows project author to specify the versions of artifacts to by used.
4. Dependency mediation -  determines which version will be picked up if there are conflicts.
5. Excluded dependencies - exclude specific dependencies
6. Optional dependencies - excluded by default for downstream projects


















