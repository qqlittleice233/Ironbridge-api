# Ironbridge Api

Ironbridge Api is used to interact with the Ironbridge Xposed module.

## Features

+ Connect to the public bridge, send and receive content
+ ~~Connect to the custom bridge, send and receive content~~ (TODO)

## Quick Start

### 1. Install [Ironbridge Xposed module](https://github.com/Xposed-Modules-Repo/com.qqlittleice.ironbridge/releases)

### 2. Connect to the public bridge

```java
// Java
Ironbridge bridge = IronBridge.getPublicBridge();
// attention: bridge may be null if the public bridge is not available
// always check if bridge is null after calling getPublicBridge()
if (bridge != null) {
    // do something
}
```

```kotlin
// Kotlin
val bridge = IronBridge.getPublicBridge()
// attention: bridge may be null if the public bridge is not available
// always check if bridge is null after calling getPublicBridge()
bridge?.let {
    // do something
}
```

### 3. Send content to the bridge

```java
// Java
bridge.sendBoolean(
        "main", // the channel
        "a boolean value", // the key
        true // the value
        );
// ......
```

```kotlin
// Kotlin
bridge.sendBoolean(
        "main", // the channel
        "a boolean value", // the key
        true // the value
        )
// ......
```

#### current supported types:

+ String

+ int

+ long

+ float

+ double

+ boolean

+ List

  - String

  - Integer

  - Long

  - Float

  - Double

  - Boolean

+ Array

  - int

  - long

  - float

  - double

  - boolean

+ Parcelable (Make sure all clients have the same class)

+ Serializable (Make sure all clients have the same class)

+ IBinder

### 4. Receive content from the bridge

```java
// Java
ironbridge.addListener(new BridgeListener.Stub() {
    @Override
    public void onReceivedString(String key, String value) {
        // do something
    }
    
    // ......

    @Override
    public String getChannel() {
        // return the channel name that the channel you want to listen
        return "main";
    }
});
```

```kotlin
// Kotlin
bridge?.addListener(object: BridgeListener.Stub() {
    override fun onReceivedString(key: String?, value: String?) {
        // do something
    }

    // ......
    
    override fun getChannel(): String {
        // return the channel name that the channel you want to listen
        return "main"
    }
})
```
