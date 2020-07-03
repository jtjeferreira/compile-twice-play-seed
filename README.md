# compile-twice-play-seed

Reproducer for an issue with play framework compile source code twice

## Reproduce

* launch sbt
* `compile`
* modify `A.scala` file in core module
* `run`
* compilation of A.scala happens twice

```
$ run
[info] Compiling 1 Scala source to /home/joao/git/play-seed/core/target/scala-2.13/classes ...

--- (Running the application, auto-reloading is enabled) ---

[info] p.c.s.AkkaHttpServer - Listening for HTTP on /0:0:0:0:0:0:0:0:9000

(Server started, use Enter to stop and go back to the console...)

[info] Compiling 1 Scala source to /home/joao/git/play-seed/core/target/scala-2.13/classes ...
WARNING: An illegal reflective access operation has occurred
WARNING: Illegal reflective access by com.google.inject.internal.cglib.core.$ReflectUtils$1 (file:/home/joao/.coursier/cache/v1/https/repo1.maven.org/maven2/com/google/inject/guice/4.2.3/guice-4.2.3.jar) to method java.lang.ClassLoader.defineClass(java.lang.String,byte[],int,int,java.security.ProtectionDomain)
WARNING: Please consider reporting this to the maintainers of com.google.inject.internal.cglib.core.$ReflectUtils$1
WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
WARNING: All illegal access operations will be denied in a future release
2020-07-03 16:29:10 INFO  play.api.http.EnabledFilters  Enabled Filters (see <https://www.playframework.com/documentation/latest/Filters>):

    play.filters.csrf.CSRFFilter
    play.filters.headers.SecurityHeadersFilter
    play.filters.hosts.AllowedHostsFilter

2020-07-03 16:29:10 INFO  play.api.Play  Application started (Dev) (no global state)
2020-07-03 16:29:10 WARN  p.a.m.DefaultUrlEncodedCookieDataCodec  Cookie failed message authentication check
2020-07-03 16:29:10 WARN  p.a.m.DefaultUrlEncodedCookieDataCodec  Cookie failed message authentication check
2020-07-03 16:29:10 WARN  p.a.m.DefaultUrlEncodedCookieDataCodec  Cookie failed message authentication check
2020-07-03 16:29:11 WARN  p.a.m.DefaultUrlEncodedCookieDataCodec  Cookie failed message authentication check
2020-07-03 16:30:40 INFO  p.a.i.l.c.CoordinatedShutdownSupport  Starting synchronous coordinated shutdown with ServerStoppedReason reason and 35000 milliseconds timeout
2020-07-03 16:30:40 INFO  play.core.server.AkkaHttpServer  Stopping Akka HTTP server...
2020-07-03 16:30:40 INFO  play.core.server.AkkaHttpServer  Terminating server binding for /0:0:0:0:0:0:0:0:9000
2020-07-03 16:30:40 INFO  play.core.server.AkkaHttpServer  Running provided shutdown stop hooks
```
