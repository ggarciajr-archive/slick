name := "Lift 2.5 starter template"

version := "0.0.1"

organization := "net.liftweb"

scalaVersion := "2.10.0"

resolvers ++= Seq("snapshots"     at "http://oss.sonatype.org/content/repositories/snapshots",
                "releases"        at "http://oss.sonatype.org/content/repositories/releases"
                )

seq(com.github.siasia.WebPlugin.webSettings :_*)

unmanagedResourceDirectories in Test <+= (baseDirectory) { _ / "src/main/webapp" }

scalacOptions ++= Seq("-deprecation", "-unchecked")

resolvers ++= Seq(
  "Java.net Maven2 Repo" at "http://download.java.net/maven/2/",
  "Sonatype OSS Snapshot Repository" at "https://oss.sonatype.org/content/repositories/releases/",
  "Maven Central" at "http://repo1.maven.org/maven2"
)

libraryDependencies ++= {
  val liftVersion = "2.5-RC2"
  Seq(
    "net.liftweb"       %% "lift-webkit"        % liftVersion        % "compile",
    "net.liftmodules"   %% "lift-jquery-module" % (liftVersion + "-2.2")
  )
}

libraryDependencies ++= Seq(
    "javax.servlet"         % "servlet-api"        % "2.5"              % "provided->default",
    "org.specs2"            % "specs2_2.10"        % "1.13"             % "test->default",
    "com.h2database"        % "h2"                 % "1.3.165"          % "compile",
    "ch.qos.logback"        % "logback-classic"    % "1.0.9",
    "org.eclipse.jetty"     % "jetty-webapp"       % "8.0.4.v20111024"  % "container",
    "org.eclipse.jetty"     % "jetty-plus"         % "8.0.4.v20111024"  % "container",
    "com.typesafe.slick"    % "slick_2.10"         % "1.0.0"            % "compile"
)