import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "edi"
  val appVersion      = "0.1-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    javaCore,
    javaJdbc,
    javaEbean,
    "org.json"%"org.json"%"chargebee-1.0"
  )

  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here      
  )

}
