package com.gsdesign.analytics;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;

import java.util.Map;

public class GoogleAnalyticsModule extends ReactContextBaseJavaModule {

    private Tracker tracker;

    public GoogleAnalyticsModule(ReactApplicationContext reactContext, Context activityContext, String trackingId) {
        super(reactContext);
        GoogleAnalytics analytics = GoogleAnalytics.getInstance(activityContext.getApplicationContext());
        tracker = analytics.newTracker(trackingId);
    }

    @Override
    public String getName() {
        return "RNGoogleAnalytics";
    }

    @ReactMethod
    public void createEvent(ReadableMap args) {
        Log.d("RNGoogleAnalytics", String.format("Sending Event %s", args));

        HitBuilders.EventBuilder builder = new HitBuilders.EventBuilder();

        String category = args.getString("category");
        String action = args.getString("action");
        String label = args.getString("label");

        if(!TextUtils.isEmpty(category)) {
            builder.setCategory(category);
        }

        if(!TextUtils.isEmpty(action)) {
            builder.setCategory(action);
        }

        if(!TextUtils.isEmpty(label)) {
            builder.setCategory(label);
        }

        if(!args.isNull("value")) {
            builder.setValue(new Long(args.getInt("value")));
        }

        tracker.send(builder.build());
    }

    @ReactMethod
    public void createScreenView(String screenName) {
        Log.d("RNGoogleAnalytics", String.format("Sending Screen view: %s", screenName));
        tracker.setScreenName(screenName);
        tracker.send(new HitBuilders.ScreenViewBuilder().build());
    }
}
