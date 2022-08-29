enablePlugins(JavaAppPackaging)
enablePlugins(GraalVMNativeImagePlugin)

val scala3Version = "3.2.0-RC1"

lazy val root = project
  .in(file("."))
  .settings(
    name         := "korolev_min_zio_http",
    version      := "0.1.0-SNAPSHOT",
    scalaVersion := scala3Version,
    libraryDependencies ++= Seq(
      "org.scalameta" %% "munit"             % "1.0.0-M6" % Test,
      "org.fomkin"    %% "korolev-zio-http"  % "1.5.0"
    ),
    scalacOptions ++= Seq(
      "-deprecation",
      "-feature",
      "-language:postfixOps",
      "-language:implicitConversions",
      "-language:higherKinds",
      "-Ykind-projector",
      "-explain"
    ),

    graalVMNativeImageCommand := "/Users/akopytov2/soft/graalvm-ce-java17-22.2.0/Contents/Home/bin/native-image",
    GraalVMNativeImage / mainClass := Some("Main"),
    graalVMNativeImageOptions ++= Seq(
      "--allow-incomplete-classpath",
      "--initialize-at-build-time=ch.qos.logback.classic.Logger",
      "--initialize-at-build-time=ch.qos.logback.classic.Level",
      "--initialize-at-build-time=ch.qos.logback.core.spi.AppenderAttachableImpl",
      "--initialize-at-build-time=ch.qos.logback.core.status.InfoStatus",
      "--initialize-at-build-time=ch.qos.logback.classic.PatternLayout",
      "--initialize-at-build-time=ch.qos.logback.classic.joran.action.ConsolePluginAction",
      "--initialize-at-build-time=org.slf4j.impl.StaticLoggerBinder",
      "--initialize-at-build-time=ch.qos.logback.core.CoreConstants",
      "--initialize-at-build-time=ch.qos.logback.core.joran.action.NestedBasicPropertyIA$1",
      "--initialize-at-build-time=ch.qos.logback.core.pattern.parser.TokenStream$1",
      "--initialize-at-build-time=ch.qos.logback.core.subst.Parser$1",
      "--initialize-at-build-time=org.slf4j.MDC",
      "--initialize-at-build-time=ch.qos.logback.core.util.StatusPrinter",
      "--initialize-at-build-time=ch.qos.logback.core.pattern.parser.Parser",
      "--initialize-at-build-time=ch.qos.logback.core.joran.action.NestedComplexPropertyIA$1",
      "--initialize-at-build-time=ch.qos.logback.core.subst.Tokenizer$1",
      "--initialize-at-build-time=ch.qos.logback.core.subst.Token",
      "--initialize-at-build-time=org.slf4j.LoggerFactory",
      "--initialize-at-build-time=ch.qos.logback.core.subst.NodeToStringTransformer$1",
      "--initialize-at-build-time=ch.qos.logback.core.util.Loader",
      "--initialize-at-run-time=io.netty.channel.epoll.Epoll",
      "--initialize-at-run-time=io.netty.channel.epoll.Native",
      "--initialize-at-run-time=io.netty.channel.epoll.EpollEventLoop",
      "--initialize-at-run-time=io.netty.channel.epoll.EpollEventArray",
      "--initialize-at-run-time=io.netty.channel.DefaultFileRegion",
      "--initialize-at-run-time=io.netty.channel.kqueue.KQueueEventArray",
      "--initialize-at-run-time=io.netty.channel.kqueue.KQueueEventLoop",
      "--initialize-at-run-time=io.netty.channel.kqueue.Native",
      "--initialize-at-run-time=io.netty.channel.unix.Errors",
      "--initialize-at-run-time=io.netty.channel.unix.IovArray",
      "--initialize-at-run-time=io.netty.channel.unix.Limits",
      "--initialize-at-run-time=io.netty.util.internal.logging.Log4JLogger",
      "--initialize-at-run-time=io.netty.channel.kqueue.KQueue"
    )
  )
