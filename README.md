# Reactive Streams for Scala.js

The purpose of Reactive Streams is to provide a standard for asynchronous stream processing with non-blocking backpressure.

This repository manages the [Scala.js](http://www.scala-js.org/)
builds of the API. For details and the TCK see
[the JVM](https://github.com/reactive-streams/reactive-streams-jvm).

## Usage in SBT

These packages are currently compiled and supported for
Scala 2.10.x, 2.11.x and 2.12.x with Scala.js 0.6.x.

```scala
libraryDependencies += "org.reactivestreams" %%% "reactive-streams-scalajs" % "1.0.0"
```

These should be used only for Scala.js projects. For cross-compiled projects
that also target [the JVM](https://github.com/reactive-streams/reactive-streams-jvm)
one must still use the official package for the JVM subproject.
So for [cross compilation](https://www.scala-js.org/doc/project/cross-build.html)
the definition could look like:

```scala
lazy val foo = crossProject.in(file("."))
  .settings(commonSettings)
  .jvmSettings(
    libraryDependencies += "org.reactivestreams" % "reactive-streams" % "1.0.0"
  )
  .jsSettings(
    libraryDependencies += "org.reactivestreams" %%% "reactive-streams-scalajs" % "1.0.0"
  )

lazy val fooJVM = foo.jvm
lazy val fooJS = foo.js
```
