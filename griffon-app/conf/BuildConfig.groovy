griffon.project.dependency.resolution = {
    inherits "global"
    log "warn" 
    repositories {
        griffonHome()
        mavenRepo 'http://www.scala-tools.org/repo-releases'
        mavenCentral()
        // mavenRepo 'http://repository.codehaus.org'
    }
    dependencies {
        def scalaVersion = '2.9.1'
        build "org.scala-lang:scala-compiler:$scalaVersion",
              "org.scala-lang:scala-library:$scalaVersion"
        compile "org.scala-lang:scala-compiler:$scalaVersion",
                "org.scala-lang:scala-library:$scalaVersion",
                "org.scala-lang:scala-swing:$scalaVersion"
        // compile('org.codehaus.groovy.modules:groovytransforms:0.2') { transitive = false }
        test 'org.scalatest:scalatest_2.9.1:1.7.1'
    }
}

griffon {
    doc {
        logo = '<a href="http://griffon.codehaus.org" target="_blank"><img alt="The Griffon Framework" src="../img/griffon.png" border="0"/></a>'
        sponsorLogo = "<br/>"
        footer = "<br/><br/>Made with Griffon (@griffon.version@)"
    }
}

log4j = {
    // Example of changing the log pattern for the default console
    // appender:
    appenders {
        console name: 'stdout', layout: pattern(conversionPattern: '%d [%t] %-5p %c - %m%n')
    }

    error 'org.codehaus.griffon',
          'org.springframework',
          'org.apache.karaf',
          'groovyx.net'
    warn  'griffon'
}
