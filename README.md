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
        name = "jitpack"
        url = uri("https://jitpack.io/")
    }
```

Then, define the dependency like so:

```kts
  implementation("com.github.EvilSquirrelGuy:JHaaC:VERSION")
```

If there's a new version, you will probably need to wait for jitpack to build it, but you builds will succeed once this is done!
Also, make sure to replace `VERSION` with the actual version, anything older than `0.1.2` won't work.


## Developing

Good question, don't ask me.
