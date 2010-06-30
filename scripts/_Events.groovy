/*
 * Copyright 2009-2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * @author Andres Almiray
 */

includeTargets << griffonScript("Init")
includePluginScript("scala", "_ScalaCommon")

eventPackagePluginStart = { pluginName, plugin ->
    def destFileName = "lib/check/scalacheck-tasks.jar"
    ant.delete(dir: destFileName, quiet: false, failOnError: false)
    ant.jar(destfile: destFileName) {
        fileset(dir: classesDirPath) {
            exclude(name: '_*.class')
            exclude(name: '*GriffonPlugin.class')
        }
    }
}

eventCopyLibsEnd = { jardir ->
    if(compilingScalaPlugin()) return
    adjustScalaHome()
    ant.echo(message: "[scala] Copying Scala jar files from ${scalaHome}/lib")

    ant.fileset(dir:"${scalaHome}/lib/", includes:"*.jar").each {
        griffonCopyDist(it.toString(), jardir)
    }
}

eventCompileStart = { 
    if(compilingScalaPlugin()) return
    compileScalaSrc()
}
 
private boolean compilingScalaPlugin() { 
    getPluginDirForName('scala')?.file?.canonicalPath == basedir
}

eventStatsStart = { pathToInfo ->
    if(!pathToInfo.find{ it.path == "src.commons"} ) {
        pathToInfo << [name: "Common Sources", path: "src.commons", filetype: [".groovy",".java"]]
    }
    if(!pathToInfo.find{ it.path == "src.scala"} ) {
        pathToInfo << [name: "Scala Sources", path: "src.scala", filetype: [".scala"]]
    }
}
