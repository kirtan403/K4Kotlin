# K4Kotlin [![Release](https://jitpack.io/v/kirtan403/k4kotlin.svg)](https://jitpack.io/#kirtan403/k4kotlin)

A sweet, small set of Kotlin functions to reduce your android boilerplate code

## Dependency

Add this in your project level `build.gradle` file (**not** your module `build.gradle` file):

```gradle
allprojects {
	repositories {
        maven { url "https://jitpack.io" } // add this line
    }
}
```

Then, add the library to your module `build.gradle`
```gradle
dependencies {
    compile 'com.github.kirtan403:K4Kotlin:0.4.2' // For all modules (NOT RECOMMENDED)
    compile 'com.github.kirtan403.k4kotlin:k4kotlin:0.4.2' // Core extension functions
    compile 'com.github.kirtan403.k4kotlin:k4kotlin-retrofit:0.4.2' // Extensions for Retrofit
}
```



#### NOTE: Upgrading from < 0.3.0

If you are upgrading from `0.1.x` or `0.2.x` to  `> 0.3.0`, you might need to change the dependency in your `build.gradle` file. 

From `0.3.0`, library modules are divided into multiple specific modules. So if you will not change the dependency package, then you might unnecessary adding recurring dependencies you might not need. So 

For including your basic functionality, you should change from 

```gradle
// from
compile 'com.github.kirtan403:K4Kotlin:0.2.x'
// to 
compile 'com.github.kirtan403.k4kotlin:k4kotlin:0.3.0'
```

Then, additionally you can add as many other modules you might need.

## [Usage / Documentaion](https://github.com/kirtan403/K4Kotlin/wiki)

Check out the wiki for detailed documentation and usage examples.

For `k4kotlin` core module [click here](https://github.com/kirtan403/K4Kotlin/wiki/K4Kotlin)
For `k4kotlin-retrofit` module's documentation, [click here](https://github.com/kirtan403/K4Kotlin/wiki/Retrofit)


