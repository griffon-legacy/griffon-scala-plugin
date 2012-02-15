/*
 * Copyright 2009-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the 'License');
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an 'AS IS' BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * @author Andres Almiray
 */
class ScalaGriffonPlugin {
    // the plugin version
    String version = '0.9'
    // the version or versions of Griffon the plugin is designed for
    String griffonVersion = '0.9.5 > *'
    // the other plugins this plugin depends on
    Map dependsOn = ['lang-bridge': '0.5']
    // resources that are included in plugin packaging
    List pluginIncludes = []
    // the plugin license
    String license = 'Apache Software License 2.0'
    // Toolkit compatibility. No value means compatible with all
    // Valid values are: swing, javafx, swt, pivot, gtk
    List toolkits = []
    // Platform compatibility. No value means compatible with all
    // Valid values are:
    // linux, linux64, windows, windows64, macosx, macosx64, solaris
    List platforms = []
    // URL where documentation can be found
    String documentation = ''
    // URL where source can be found
    String source = 'https://github.com/griffon/griffon-scala-plugin'

    List authors = [
        [
            name: 'Andres Almiray',
            email: 'aalmiray@yahoo.com'
        ]
    ]
    String title = 'Brings the Scala language compiler and libraries'
    // accepts Markdown syntax. See http://daringfireball.net/projects/markdown/ for details
    String description = '''
The Scala plugin enables compiling and running [Scala]][1] code on your Griffon application. Scala is a statically
typed language for the JVM that has a great level of interoperability with Java, and so with Groovy too.

Usage
-----
You must place all Scala code under `$appdir/src/scala`, it will be compiled first before any sources available on 
`griffon-app` or `src/main` which means you can't reference any of those sources from your Scala code, while the
Groovy sources can. However in order to send a message back to the calling code you can create a Scala Trait
(roughly equivalent to a Java interface) and have a Groovy class implement it. Another alternative would be the
usage of Structural Types.

Starting with version 0.3 you will be able to use the [LangBridge Plugin][2] facilities to communicate with other JVM languages.

Configuration
-------------
The `BuildConfig.groovy` file in the `griffon-app/conf` folder of your application can be used to configure behavior of the
scala plugin.

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

 * **scala-test** - runs Scala tests found in `$basedir/test/scalatest` using Scalatest 1.7.1. Test classes must have Tests as suffix.
 * **scala-repl** - runs a Scala REPL with the application's classpath fully configured.

[1]: http://www.scala-lang.org
[2]: /plugin/lang-bridge
'''
}
