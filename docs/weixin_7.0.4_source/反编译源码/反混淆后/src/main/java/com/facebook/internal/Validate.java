package com.facebook.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Looper;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.FacebookSdkNotInitializedException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.List;

public final class Validate {
    private static final String CONTENT_PROVIDER_BASE = "com.facebook.app.FacebookContentProvider";
    private static final String CONTENT_PROVIDER_NOT_FOUND_REASON = "A ContentProvider for this app was not set up in the AndroidManifest.xml, please add %s as a provider to your AndroidManifest.xml file. See https://developers.facebook.com/docs/sharing/android for more info.";
    private static final String CUSTOM_TAB_REDIRECT_ACTIVITY_NOT_FOUND_REASON = "FacebookActivity is declared incorrectly in the AndroidManifest.xml, please add com.facebook.FacebookActivity to your AndroidManifest.xml file. See https://developers.facebook.com/docs/android/getting-started for more info.";
    private static final String FACEBOOK_ACTIVITY_NOT_FOUND_REASON = "FacebookActivity is not declared in the AndroidManifest.xml. If you are using the facebook-common module or dependent modules please add com.facebook.FacebookActivity to your AndroidManifest.xml file. See https://developers.facebook.com/docs/android/getting-started for more info.";
    private static final String NO_INTERNET_PERMISSION_REASON = "No internet permissions granted for the app, please add <uses-permission android:name=\"android.permission.INTERNET\" /> to your AndroidManifest.xml.";
    private static final String TAG = Validate.class.getName();

    static {
        AppMethodBeat.m2504i(72593);
        AppMethodBeat.m2505o(72593);
    }

    public static void notNull(Object obj, String str) {
        AppMethodBeat.m2504i(72569);
        if (obj == null) {
            NullPointerException nullPointerException = new NullPointerException("Argument '" + str + "' cannot be null");
            AppMethodBeat.m2505o(72569);
            throw nullPointerException;
        }
        AppMethodBeat.m2505o(72569);
    }

    public static <T> void notEmpty(Collection<T> collection, String str) {
        AppMethodBeat.m2504i(72570);
        if (collection.isEmpty()) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Container '" + str + "' cannot be empty");
            AppMethodBeat.m2505o(72570);
            throw illegalArgumentException;
        }
        AppMethodBeat.m2505o(72570);
    }

    public static <T> void containsNoNulls(Collection<T> collection, String str) {
        AppMethodBeat.m2504i(72571);
        notNull(collection, str);
        for (T t : collection) {
            if (t == null) {
                NullPointerException nullPointerException = new NullPointerException("Container '" + str + "' cannot contain null values");
                AppMethodBeat.m2505o(72571);
                throw nullPointerException;
            }
        }
        AppMethodBeat.m2505o(72571);
    }

    public static void containsNoNullOrEmpty(Collection<String> collection, String str) {
        AppMethodBeat.m2504i(72572);
        notNull(collection, str);
        for (String str2 : collection) {
            if (str2 == null) {
                NullPointerException nullPointerException = new NullPointerException("Container '" + str + "' cannot contain null values");
                AppMethodBeat.m2505o(72572);
                throw nullPointerException;
            } else if (str2.length() == 0) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Container '" + str + "' cannot contain empty values");
                AppMethodBeat.m2505o(72572);
                throw illegalArgumentException;
            }
        }
        AppMethodBeat.m2505o(72572);
    }

    public static <T> void notEmptyAndContainsNoNulls(Collection<T> collection, String str) {
        AppMethodBeat.m2504i(72573);
        containsNoNulls(collection, str);
        notEmpty(collection, str);
        AppMethodBeat.m2505o(72573);
    }

    public static void runningOnUiThread() {
        AppMethodBeat.m2504i(72574);
        if (Looper.getMainLooper().equals(Looper.myLooper())) {
            AppMethodBeat.m2505o(72574);
            return;
        }
        FacebookException facebookException = new FacebookException("This method should be called from the UI thread");
        AppMethodBeat.m2505o(72574);
        throw facebookException;
    }

    public static void notNullOrEmpty(String str, String str2) {
        AppMethodBeat.m2504i(72575);
        if (Utility.isNullOrEmpty(str)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Argument '" + str2 + "' cannot be null or empty");
            AppMethodBeat.m2505o(72575);
            throw illegalArgumentException;
        }
        AppMethodBeat.m2505o(72575);
    }

    public static void oneOf(Object obj, String str, Object... objArr) {
        AppMethodBeat.m2504i(72576);
        for (Object obj2 : objArr) {
            if (obj2 != null) {
                if (obj2.equals(obj)) {
                    AppMethodBeat.m2505o(72576);
                    return;
                }
            } else if (obj == null) {
                AppMethodBeat.m2505o(72576);
                return;
            }
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Argument '" + str + "' was not one of the allowed values");
        AppMethodBeat.m2505o(72576);
        throw illegalArgumentException;
    }

    public static void sdkInitialized() {
        AppMethodBeat.m2504i(72577);
        if (FacebookSdk.isInitialized()) {
            AppMethodBeat.m2505o(72577);
            return;
        }
        FacebookSdkNotInitializedException facebookSdkNotInitializedException = new FacebookSdkNotInitializedException("The SDK has not been initialized, make sure to call FacebookSdk.sdkInitialize() first.");
        AppMethodBeat.m2505o(72577);
        throw facebookSdkNotInitializedException;
    }

    public static String hasAppID() {
        AppMethodBeat.m2504i(72578);
        String applicationId = FacebookSdk.getApplicationId();
        if (applicationId == null) {
            IllegalStateException illegalStateException = new IllegalStateException("No App ID found, please set the App ID.");
            AppMethodBeat.m2505o(72578);
            throw illegalStateException;
        }
        AppMethodBeat.m2505o(72578);
        return applicationId;
    }

    public static String hasClientToken() {
        AppMethodBeat.m2504i(72579);
        String clientToken = FacebookSdk.getClientToken();
        if (clientToken == null) {
            IllegalStateException illegalStateException = new IllegalStateException("No Client Token found, please set the Client Token.");
            AppMethodBeat.m2505o(72579);
            throw illegalStateException;
        }
        AppMethodBeat.m2505o(72579);
        return clientToken;
    }

    public static void hasInternetPermissions(Context context) {
        AppMethodBeat.m2504i(72580);
        hasInternetPermissions(context, true);
        AppMethodBeat.m2505o(72580);
    }

    public static void hasInternetPermissions(Context context, boolean z) {
        AppMethodBeat.m2504i(72581);
        notNull(context, "context");
        if (context.checkCallingOrSelfPermission("android.permission.INTERNET") == -1 && z) {
            IllegalStateException illegalStateException = new IllegalStateException(NO_INTERNET_PERMISSION_REASON);
            AppMethodBeat.m2505o(72581);
            throw illegalStateException;
        }
        AppMethodBeat.m2505o(72581);
    }

    public static boolean hasWiFiPermission(Context context) {
        AppMethodBeat.m2504i(72582);
        boolean hasPermission = hasPermission(context, "android.permission.ACCESS_WIFI_STATE");
        AppMethodBeat.m2505o(72582);
        return hasPermission;
    }

    public static boolean hasChangeWifiStatePermission(Context context) {
        AppMethodBeat.m2504i(72583);
        boolean hasPermission = hasPermission(context, "android.permission.CHANGE_WIFI_STATE");
        AppMethodBeat.m2505o(72583);
        return hasPermission;
    }

    public static boolean hasLocationPermission(Context context) {
        AppMethodBeat.m2504i(72584);
        if (hasPermission(context, "android.permission.ACCESS_COARSE_LOCATION") || hasPermission(context, "android.permission.ACCESS_FINE_LOCATION")) {
            AppMethodBeat.m2505o(72584);
            return true;
        }
        AppMethodBeat.m2505o(72584);
        return false;
    }

    public static boolean hasBluetoothPermission(Context context) {
        AppMethodBeat.m2504i(72585);
        if (hasPermission(context, "android.permission.BLUETOOTH") && hasPermission(context, "android.permission.BLUETOOTH_ADMIN")) {
            AppMethodBeat.m2505o(72585);
            return true;
        }
        AppMethodBeat.m2505o(72585);
        return false;
    }

    public static boolean hasPermission(Context context, String str) {
        AppMethodBeat.m2504i(72586);
        if (context.checkCallingOrSelfPermission(str) == 0) {
            AppMethodBeat.m2505o(72586);
            return true;
        }
        AppMethodBeat.m2505o(72586);
        return false;
    }

    public static void hasFacebookActivity(Context context) {
        AppMethodBeat.m2504i(72587);
        hasFacebookActivity(context, true);
        AppMethodBeat.m2505o(72587);
    }

    public static void hasFacebookActivity(Context context, boolean z) {
        AppMethodBeat.m2504i(72588);
        notNull(context, "context");
        PackageManager packageManager = context.getPackageManager();
        ActivityInfo activityInfo = null;
        if (packageManager != null) {
            try {
                activityInfo = packageManager.getActivityInfo(new ComponentName(context, "com.facebook.FacebookActivity"), 1);
            } catch (NameNotFoundException e) {
            }
        }
        if (activityInfo == null && z) {
            IllegalStateException illegalStateException = new IllegalStateException(FACEBOOK_ACTIVITY_NOT_FOUND_REASON);
            AppMethodBeat.m2505o(72588);
            throw illegalStateException;
        }
        AppMethodBeat.m2505o(72588);
    }

    public static void checkCustomTabRedirectActivity(Context context) {
        AppMethodBeat.m2504i(72589);
        checkCustomTabRedirectActivity(context, true);
        AppMethodBeat.m2505o(72589);
    }

    public static void checkCustomTabRedirectActivity(Context context, boolean z) {
        AppMethodBeat.m2504i(72590);
        if (hasCustomTabRedirectActivity(context) || !z) {
            AppMethodBeat.m2505o(72590);
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException(CUSTOM_TAB_REDIRECT_ACTIVITY_NOT_FOUND_REASON);
        AppMethodBeat.m2505o(72590);
        throw illegalStateException;
    }

    public static boolean hasCustomTabRedirectActivity(Context context) {
        boolean z;
        AppMethodBeat.m2504i(72591);
        notNull(context, "context");
        PackageManager packageManager = context.getPackageManager();
        List list = null;
        if (packageManager != null) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.addCategory("android.intent.category.BROWSABLE");
            intent.setData(Uri.parse("fb" + FacebookSdk.getApplicationId() + "://authorize"));
            list = packageManager.queryIntentActivities(intent, 64);
        }
        if (list != null) {
            z = false;
            for (ResolveInfo resolveInfo : list) {
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                if (activityInfo.name.equals("com.facebook.CustomTabActivity") && activityInfo.packageName.equals(context.getPackageName())) {
                    z = true;
                } else {
                    AppMethodBeat.m2505o(72591);
                    return false;
                }
            }
        }
        z = false;
        AppMethodBeat.m2505o(72591);
        return z;
    }

    public static void hasContentProvider(Context context) {
        AppMethodBeat.m2504i(72592);
        notNull(context, "context");
        String hasAppID = hasAppID();
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            if (packageManager.resolveContentProvider(CONTENT_PROVIDER_BASE.concat(String.valueOf(hasAppID)), 0) == null) {
                IllegalStateException illegalStateException = new IllegalStateException(String.format(CONTENT_PROVIDER_NOT_FOUND_REASON, new Object[]{hasAppID}));
                AppMethodBeat.m2505o(72592);
                throw illegalStateException;
            }
        }
        AppMethodBeat.m2505o(72592);
    }
}
