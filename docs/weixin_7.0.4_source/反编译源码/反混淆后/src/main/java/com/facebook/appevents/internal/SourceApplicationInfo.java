package com.facebook.appevents.internal;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import com.facebook.FacebookSdk;
import com.tencent.matrix.trace.core.AppMethodBeat;

class SourceApplicationInfo {
    private static final String CALL_APPLICATION_PACKAGE_KEY = "com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage";
    private static final String OPENED_BY_APP_LINK_KEY = "com.facebook.appevents.SourceApplicationInfo.openedByApplink";
    private static final String SOURCE_APPLICATION_HAS_BEEN_SET_BY_THIS_INTENT = "_fbSourceApplicationHasBeenSet";
    private String callingApplicationPackage;
    private boolean openedByAppLink;

    public static class Factory {
        public static SourceApplicationInfo create(Activity activity) {
            boolean z = false;
            AppMethodBeat.m2504i(72224);
            String str = "";
            ComponentName callingActivity = activity.getCallingActivity();
            if (callingActivity != null) {
                str = callingActivity.getPackageName();
                if (str.equals(activity.getPackageName())) {
                    AppMethodBeat.m2505o(72224);
                    return null;
                }
            }
            Intent intent = activity.getIntent();
            if (!(intent == null || intent.getBooleanExtra(SourceApplicationInfo.SOURCE_APPLICATION_HAS_BEEN_SET_BY_THIS_INTENT, false))) {
                intent.putExtra(SourceApplicationInfo.SOURCE_APPLICATION_HAS_BEEN_SET_BY_THIS_INTENT, true);
                Bundle bundleExtra = intent.getBundleExtra("al_applink_data");
                if (bundleExtra != null) {
                    Bundle bundle = bundleExtra.getBundle("referer_app_link");
                    if (bundle != null) {
                        str = bundle.getString("package");
                        z = true;
                    } else {
                        z = true;
                    }
                }
            }
            intent.putExtra(SourceApplicationInfo.SOURCE_APPLICATION_HAS_BEEN_SET_BY_THIS_INTENT, true);
            SourceApplicationInfo sourceApplicationInfo = new SourceApplicationInfo(str, z);
            AppMethodBeat.m2505o(72224);
            return sourceApplicationInfo;
        }
    }

    private SourceApplicationInfo(String str, boolean z) {
        this.callingApplicationPackage = str;
        this.openedByAppLink = z;
    }

    public static SourceApplicationInfo getStoredSourceApplicatioInfo() {
        AppMethodBeat.m2504i(72225);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext());
        if (defaultSharedPreferences.contains(CALL_APPLICATION_PACKAGE_KEY)) {
            SourceApplicationInfo sourceApplicationInfo = new SourceApplicationInfo(defaultSharedPreferences.getString(CALL_APPLICATION_PACKAGE_KEY, null), defaultSharedPreferences.getBoolean(OPENED_BY_APP_LINK_KEY, false));
            AppMethodBeat.m2505o(72225);
            return sourceApplicationInfo;
        }
        AppMethodBeat.m2505o(72225);
        return null;
    }

    public static void clearSavedSourceApplicationInfoFromDisk() {
        AppMethodBeat.m2504i(72226);
        Editor edit = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
        edit.remove(CALL_APPLICATION_PACKAGE_KEY);
        edit.remove(OPENED_BY_APP_LINK_KEY);
        edit.apply();
        AppMethodBeat.m2505o(72226);
    }

    public String getCallingApplicationPackage() {
        return this.callingApplicationPackage;
    }

    public boolean isOpenedByAppLink() {
        return this.openedByAppLink;
    }

    public String toString() {
        AppMethodBeat.m2504i(72227);
        String str = "Unclassified";
        if (this.openedByAppLink) {
            str = "Applink";
        }
        if (this.callingApplicationPackage != null) {
            str = str + "(" + this.callingApplicationPackage + ")";
            AppMethodBeat.m2505o(72227);
            return str;
        }
        AppMethodBeat.m2505o(72227);
        return str;
    }

    public void writeSourceApplicationInfoToDisk() {
        AppMethodBeat.m2504i(72228);
        Editor edit = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
        edit.putString(CALL_APPLICATION_PACKAGE_KEY, this.callingApplicationPackage);
        edit.putBoolean(OPENED_BY_APP_LINK_KEY, this.openedByAppLink);
        edit.apply();
        AppMethodBeat.m2505o(72228);
    }
}
