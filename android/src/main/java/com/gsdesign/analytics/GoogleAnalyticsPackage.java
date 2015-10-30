package com.gsdesign.analytics;

import android.content.Context;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import com.gsdesign.analytics.GoogleAnalyticsModule;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GoogleAnalyticsPackage implements ReactPackage {

    private Context activityContext;
    private String trackingId;

    public GoogleAnalyticsPackage(Context context, String trackingId) {
        activityContext = context;
        this.trackingId = trackingId;
    }

    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        List<NativeModule> modules = new ArrayList<>();

        modules.add(new GoogleAnalyticsModule(reactContext, activityContext, trackingId));

        return modules;
    }

    @Override
    public List<Class<? extends JavaScriptModule>> createJSModules() {
        return Collections.emptyList();
    }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        return Arrays.asList();
    }

}
