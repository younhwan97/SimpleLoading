<h1 align="center">SimpleLoading</h1></br>

<p align="center">
  <a href="https://android-arsenal.com/api?level=21"><img alt="API" src="https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat"/></a>
</p><br>

> 💡 This library provide a simple loading dialog for Jetpack Compose.</p>
<p align="center">
<img src="preview/preview1.gif" width="268"/>
</p>

## Download
[![jipack](https://jitpack.io/v/younhwan97/SimpleLoading.svg)](https://jitpack.io/#younhwan97/SimpleLoading)

### **Step 1.** Add the JitPack repository to your build file

Add it in your root `build.gradle` at the end of repositories:

```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

### **Step 2.** Add the dependency

```gradle
dependencies {
    implementation 'com.github.younhwan97:SimpleLoading:0.0.6'
}
```

## Usage

You can implement Loading Dialog with SimpleLoading composable function as seen in the below:

```Kotlin
val state = remember { mutableStateOf(true) }

SimpleLoading(
    openDialogCustom = state
)
```

<img align="right" src="preview/preview2.gif" width="290" height="575"/>

You can change the color of the dialog using the `color` parameter. 

```kotlin
val state = remember {
    mutableStateOf(false)
}

SimpleLoading(
    openDialogCustom = state,
    color = Color.Black
)

```

<br><br>

If you want to hide the close button, pass `false` to the `clickableClose` parameter as seen in the below:

```kotlin
val state = remember {
    mutableStateOf(false)
}

SimpleLoading(
    openDialogCustom = state,
    color = Color.Black,
    clickableClose = false
)
```