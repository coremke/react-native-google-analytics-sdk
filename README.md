# React Native Google analytics

> Basic wrapper around events and screen views for Google Analytics

## Android Setup

### 1. Update Gradle Settings (`android/settings.gradle`)

```gradle
...
include ':react-native-google-analytics-sdk'
project(':react-native-google-analytics-sdk').projectDir = new File(rootProject.projectDir, '../node_modules/react-native-google-analytics-sdk/android')
```

### 2. Update Gradle Build (`android/build.gradle`)


```gradle
...
dependencies {
    compile project(':react-native-google-analytics-sdk')
}
```

### 3. Add new string resource, `ga_tracking_id` to `android/app/src/main/res/values/strings.xml` with your GA Tracking ID

```xml
<resources>
    ...
    <string name="ga_tracking_id">FILL IN YOUR TRACKING ID</string>
</resources>

```

### 4. Register the Module in `MainActivity.java`

```java
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mReactRootView = new ReactRootView(this);

    mReactInstanceManager = ReactInstanceManager.builder()
            .setApplication(getApplication())
            .setBundleAssetName("index.android.bundle")
            .setJSMainModuleName("index.android")
            .addPackage(new MainReactPackage())

            // ----- Add this line -----
            .addPackage(new GoogleAnalyticsPackage(this, getString(R.string.ga_tracking_id)))

            .setUseDeveloperSupport(BuildConfig.DEBUG)
            .setInitialLifecycleState(LifecycleState.RESUMED)
            .build();

    ...
}
```

### 5. Use in your JS

```js
var RNGoogleAnalytics = require('react-native').NativeModules.RNGoogleAnalytics;

// Create a new screen view
RNGoogleAnalytics.createScreenView('screen name');

// Create a new event
RNGoogleAnalytics.createEvent({
    category: 'category',
    action: 'action',
    label: 'label',
    value: 1,
});

```
