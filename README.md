# Ironbridge Api

Ironbridge Api is used to interact with the Ironbridge Xposed module.

## Features

+ Connect to the public bridge, send and receive content
+ ~~Connect to the custom bridge, send and receive content~~ (TODO)

## Quick Start

### 1. Install Ironbridge Xposed module

### 2. Connect to the public bridge

java: 

```java
Ironbridge bridge = IronBridge.getPublicBridge();
// attention: bridge may be null if the public bridge is not available
// always check if bridge is null after calling getPublicBridge()
if (bridge != null) {
    // do something
}
```

kotlin:

```kotlin
val bridge = IronBridge.getPublicBridge()
// attention: bridge may be null if the public bridge is not available
// always check if bridge is null after calling getPublicBridge()
bridge?.let {
    // do something
}
```

### 3. Send content to the bridge

java:

```java
// example
bridge.sendBoolean(
        "main", // the channel
        "a boolean value", // the key
        true // the value
        );
```

kotlin:

```kotlin
// example
bridge.sendBoolean(
        "main", // the channel
        "a boolean value", // the key
        true // the value
        )
```

#### current supported types:

+ String
+ int
+ long
+ float
+ double
+ boolean

### 4. Receive content from the bridge

java:

```java
ironbridge.addListener(new BridgeListener.Stub() {
    @Override
    public void onReceivedString(String key, String value) {
        // do something
    }

    @Override
    public void onReceivedInt(String key, int value) {
        // do something
    }

    @Override
    public void onReceivedLong(String key, long value) {
        // do something
    }

    @Override
    public void onReceivedFloat(String key, float value) {
        // do something
    }

    @Override
    public void onReceivedDouble(String key, double value) {
        // do something
    }

    @Override
    public void onReceivedBoolean(String key, boolean value) {
        // do something
    }

    @Override
    public String getChannel() {
        // return the channel name that the channel you want to listen
        return "main";
    }
});
```

kotlin:

```kotlin
bridge?.addListener(object: BridgeListener.Stub() {
    override fun onReceivedString(key: String?, value: String?) {
        // do something
    }

    override fun onReceivedInt(key: String?, value: Int) {
        // do something
    }

    override fun onReceivedLong(key: String?, value: Long) {
        // do something
    }

    override fun onReceivedFloat(key: String?, value: Float) {
        // do something
    }

    override fun onReceivedDouble(key: String?, value: Double) {
        // do something
    }

    override fun onReceivedBoolean(key: String?, value: Boolean) {
        // do something
    }

    override fun getChannel(): String {
        // return the channel name that the channel you want to listen
        return "main"
    }
})
```
