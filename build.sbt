lazy val root = (project in file(".")).enablePlugins(PlayScala)
  .settings(
    name := """compile-twice-play-seed""",
    organization := "com.example",
    version := "1.0-SNAPSHOT",
    scalaVersion := "2.13.3",
    libraryDependencies += guice,
    libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test,
  )
  .dependsOn(core)
  .aggregate(core)

lazy val core = (project in file("core"))
    .settings(
      name := "core",
      organization := "com.example",
      version := "1.0-SNAPSHOT",
      scalaVersion := "2.13.3",
    )
