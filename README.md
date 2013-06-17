
Brings the Scala language compiler and libraries
------------------------------------------------

Plugin page: [http://artifacts.griffon-framework.org/plugin/scala](http://artifacts.griffon-framework.org/plugin/scala)


The Scala plugin enables compiling and running [Scala]][1] code on your Griffon
application. Scala is a statically typed language for the JVM that has a great
level of interoperability with Java, and so with Groovy too.

Usage
-----
You must place all Scala code under `$appdir/src/scala`, it will be compiled first
before any sources available on  `griffon-app` or `src/main` which means you can't
reference any of those sources from your Scala code, while the Groovy sources can.
However in order to send a message back to the calling code you can create a Scala
Trait (roughly equivalent to a Java interface) and have a Groovy class implement
it. Another alternative would be the usage of Structural Types.

Starting with version 0.3 you will be able to use the [LangBridge Plugin][2]
facilities to communicate with other JVM languages.

Configuration
-------------
The `BuildConfig.groovy` file in the `griffon-app/conf` folder of your application
can be used to configure behavior of the scala plugin.

    scala.src.encoding='UTF-8'  //Scala src file encoding, UTF-8 by default

The following properties can be configured for `scala-test`

 * scala.test.parallel - run tests in parallel. Default: false.
 * scala.test.numthreads - set the number of threads for parallel execution.
 * scala.test.haltonfailure - whether to stop tests on failure or not. Default: false.
 * scala.test.fork - fork the jvm. Default: false.
 * scala.test.maxmemory - maximum memory to be used by test jvm.
 * scala.test.membersonly - specify suites using members-only or wildcard package names.
 * scala.test.wildcard - specify suites using members-only or wildcard package names.
 * scala.test.reporter.stdout - sets the flags for the stdout reporter. Default: FAB.
 * scala.test.reporter.file - sets the name for a file reporter.
 * scala.test.reporter.reporterClass - sets the className for a reporter class.
 * scala.test.scalaConfig - Map with additional properties.

The `scala-test` script supports the following command line flags:

 * stdout - overwrite the flags for the stdout reporter.
 * file - sets the name for a file reporter.
 * reporterClass - sets the className for a reporter class.
 * suite - only executes the specified suite.

Scripts
-------

 * **scala-test** - runs Scala tests found in `$basedir/test/scalatest` using
   Scalatest 1.9.1. Test classes must have Tests as suffix.
 * **scala-repl** - runs a Scala REPL with the application's classpath fully
   configured.

[1]: http://www.scala-lang.org
[2]: /plugin/lang-bridge

