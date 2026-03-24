# JHaaC
Java HTML-as-a-Config Library

JHaaC is a simple wrapper for parsing HTML config files. Why? Because why not.

If you are considering using this in your project, don't. Go use something sensible like YAML, JSON, or even XML.
If you're still considering using this, you have been warned. This is a quick project I threw together while procrastinating
doing something else, so be warned. Also your users will hate you.

## Importing

Since this library is written to use Gradle Kotlin DSL, we'll assume you're using that too.

Add this to the `repositories` section of your `build.gradle.kts`.
```kts
maven {
        name = "JHaaC"
        url = uri("https://maven.pkg.github.com/EvilSquirrelGuy/JHaaC")
        credentials {
            username = project.findProperty("gpr.user") as String? ?: System.getenv("GPR_USER")
            password = project.findProperty("gpr.token") as String? ?: System.getenv("GPR_TOKEN")
        }
    }
```

And make sure that you have `gpr.user` and `gpr.token` set somewhere (ideally in `$HOME/.gradle/gradle.properties`).

## Developing

Good question, don't ask me.
