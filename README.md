# K4Kotlin 

[![Release](https://jitpack.io/v/ptrbrynt/k4kotlin.svg)](https://jitpack.io/#ptrbrynt/k4kotlin)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/c2c336e19c394865a49eb8be914e0d71)](https://www.codacy.com/project/ptrbrynt/K4Kotlin/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=ptrbrynt/K4Kotlin&amp;utm_campaign=Badge_Grade_Dashboard)
[![CircleCI](https://circleci.com/gh/ptrbrynt/K4Kotlin.svg?style=svg)](https://circleci.com/gh/ptrbrynt/K4Kotlin)

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
    // K4Kotlin core extension functions
    compile 'com.github.kirtan403.k4kotlin:k4kotlin:0.5.3'
    
    // Extensions for Retrofit
    compile 'com.github.kirtan403.k4kotlin:k4kotlin-retrofit:0.5.3'
    
    // For all modules (NOT RECOMMENDED) - Below line will include all the above dependencies
    compile 'com.github.kirtan403:K4Kotlin:0.5.3'
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


