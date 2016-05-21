lazy val settings = Seq(
  name := "reactive-streams-scalajs",
  organization := "org.reactivestreams",
  version := "1.0.0",

  description := "A Protocol for Asynchronous Non-Blocking Data Sequence",

  scalaVersion := "2.11.8",
  crossScalaVersions := Seq("2.11.8", "2.10.6", "2.12.0-M4"),
  scalacOptions ++= (CrossVersion.partialVersion(scalaVersion.value) match {
    case Some((2, majorVersion)) if majorVersion <= 11 =>
      // generates code with the Java 6 class format, but only for
      // Scala 2.10 and 2.11, because 2.12 requires Java 8
      Seq("-target:jvm-1.6")
    case _ =>
      Seq.empty
  }),

  // Publishing settings
  publishMavenStyle := true,
  publishTo := {
    val nexus = "https://oss.sonatype.org/"
    if (isSnapshot.value)
      Some("snapshots" at nexus + "content/repositories/snapshots")
    else
      Some("releases"  at nexus + "service/local/staging/deploy/maven2")
  },

  pomExtra :=
    <url>https://github.com/reactive-streams/reactive-streams-scalajs/</url>
    <licenses>
      <license>
        <name>CC0</name>
        <url>http://creativecommons.org/publicdomain/zero/1.0/</url>
        <distribution>repo</distribution>
      </license>
    </licenses>
    <scm>
      <url>git@github.com:reactive-streams/reactive-streams-scalajs.git</url>
      <connection>scm:git:git@github.com:reactive-streams/reactive-streams-scalajs.git</connection>
    </scm>
    <developers>
      <developer>
        <id>reactive-streams-sig</id>
        <name>Reactive Streams SIG</name>
        <url>http://www.reactive-streams.org/</url>
      </developer>
    </developers>
)

lazy val root = project.in(file("."))
  .settings(settings)
  .enablePlugins(ScalaJSPlugin)
