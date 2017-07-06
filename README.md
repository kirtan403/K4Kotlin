# K4Kotlin
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
    compile 'com.github.kirtan403:K4Kotlin:0.1.2'
}
```

## Usage

### View

#### Set View's visibility to visible

Instead of

    myView.setVisibility(View.VISIBLE);

use:

    myView.show()


#### Set View's visibility to gone

Instead of

    myView.setVisibility(View.GONE);

use:

    myView.hide()


#### Set View's visibility to invsible

Instead of

    myView.setVisibility(View.INVISIBLE);

use:

    myView.invisible()


#### Toggle View's visibility between `VISIBLE` and `GONE`

Instead of

    if(myView.getVisibility()  ==  View.VISIBLE)
        myView.setVisibility(View.GONE);
    else
        myView.setVisibility(View.VISIBLE);

use:

    myView.toggle()
    

#### To fade in a view

    myView.fadeIn()
    myView.fadeIn(1000) // Optional duration 

#### To fade out a view

    myView.fadeOut()
    myView.fadeOut(1000) // Optional duration 

### Activity

#### Hide the keyboard

    hideKeyboard() // Anywhere inside your activity
    
### Context

#### hide/show multiple views

    hideViews(myView1,myView2,myView3,.. myViewN)  // Sets all views visibility to GONE
    showViews(myView1,myView2,myView3,.. myViewN)  // Sets all views visibility to VISIBLE
    
### Number

#### Number?.orZero() method for all number types

    if(myNumberVar?.orZero())  // return 0 if variable is null

### Boolean

#### Boolean?.orFalse() method

    if(myBooleanVar?.orFalse()) // return false if variable is null

### EditText

#### Text watcher

    var textWatcher = myEditText.addTextWatcher {
        Log.d(TAG, "text changed!")
    }
