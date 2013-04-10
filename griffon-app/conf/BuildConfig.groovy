griffon.project.dependency.resolution = {
    inherits "global"
    log "warn" 
    repositories {
        griffonHome()
        mavenRepo 'http://www.scala-tools.org/repo-releases'
        mavenCentral()
    }
    dependencies {
        def scalaVersion = '2.10.0'
        build "org.scala-lang:scala-compiler:$scalaVersion",
              "org.scala-lang:scala-library:$scalaVersion"
        compile "org.scala-lang:scala-compiler:$scalaVersion",
                "org.scala-lang:scala-library:$scalaVersion",
                "org.scala-lang:scala-swing:$scalaVersion"
        test 'org.scalatest:scalatest_2.10:1.9.1'
    }
}

log4j = {
    appenders {
        console name: 'stdout', layout: pattern(conversionPattern: '%d [%t] %-5p %c - %m%n')
    }

    error 'org.codehaus.griffon',
          'org.springframework',
          'org.apache.karaf',
          'groovyx.net'
    warn  'griffon'
}