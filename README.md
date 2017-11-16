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
    compile 'com.github.kirtan403:K4Kotlin:0.2.0'
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

    myView.toggleVisibility()
    

#### To fade in a view

    myView.fadeIn()
    myView.fadeIn(1000) // Optional duration 

#### To fade out a view

    myView.fadeOut()
    myView.fadeOut(1000) // Optional duration 

#### Fade to specific alpha of a view

    myView.fadeTo(0.5f)
    myView.fadeTo(0.5f,1000) // Optional duration 
    
#### View Animations

Enter and exit animations for views

    mView.enterFromTop()
    mView.enterFromLeft()
    mView.enterFromBottom()
    mView.enterFromRight()
    
    mView.exitToTop()
    mView.exitToLeft()
    mView.exitToBottom()
    mView.exitToRight()
    
    // with optional duration
    mView.enterFromTop(1000)

### Activity

#### Hide the keyboard

    hideKeyboard() // Anywhere inside your activity
    
### Context

#### hide/show multiple views

    hideViews(myView1,myView2,myView3,.. myViewN)  // Sets all views visibility to GONE
    showViews(myView1,myView2,myView3,.. myViewN)  // Sets all views visibility to VISIBLE
    
#### dpToPx

    dpToPx(14) // returns px equal to 14dp

#### pxToDp

    pxToDp(14) // returns dp equal to 14px
    
### Number

#### Number?.orZero() method for all number types

    if(myNumberVar.orZero())  // return 0 if variable is null

### Boolean

#### Boolean?.orFalse() method

    if(myBooleanVar.orFalse()) // return false if variable is null

### EditText

#### Text watcher

    var textWatcher = myEditText.addTextWatcher {
        Log.d(TAG, "text changed!")
    }

### Spinner

#### setItems - Set spinner list 

Generates the adapter from the ArrayList of Object and accepts layout file resource and Object to String conversion method.

    spinner.setItems(items) { it.name + " (" + it.code + ")" }  // function that converts item instance to string for spinner
    
#### onItemChanged - simpler callback method for OnItemSelectedListener 

    mBinding.spinner.onItemSelected { _, _, position, _ ->
    	val (name, _) = countries[position.orZero()]
   	toast("You selected : $name")
    }
   
### Any - helpers for all classes

#### TAG - a property helpful for Log Tags

You don't need to declare a TAG everytime you want to use the `Log.d(TAG,"My log")`. It is declared globally for all classes, and can be used without declaring TAG in class.
