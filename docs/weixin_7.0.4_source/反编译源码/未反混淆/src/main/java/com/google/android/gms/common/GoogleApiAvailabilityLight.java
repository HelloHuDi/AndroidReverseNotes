package com.google.android.gms.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.GmsIntents;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GoogleApiAvailabilityLight {
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
    private static final GoogleApiAvailabilityLight zzaw = new GoogleApiAvailabilityLight();

    static {
        AppMethodBeat.i(89377);
        AppMethodBeat.o(89377);
    }

    GoogleApiAvailabilityLight() {
    }

    public static GoogleApiAvailabilityLight getInstance() {
        return zzaw;
    }

    @VisibleForTesting
    private static String zza(Context context, String str) {
        AppMethodBeat.i(89376);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("gcore_");
        stringBuilder.append(GOOGLE_PLAY_SERVICES_VERSION_CODE);
        stringBuilder.append("-");
        if (!TextUtils.isEmpty(str)) {
            stringBuilder.append(str);
        }
        stringBuilder.append("-");
        if (context != null) {
            stringBuilder.append(context.getPackageName());
        }
        stringBuilder.append("-");
        if (context != null) {
            try {
                stringBuilder.append(Wrappers.packageManager(context).getPackageInfo(context.getPackageName(), 0).versionCode);
            } catch (NameNotFoundException e) {
            }
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(89376);
        return stringBuilder2;
    }

    public void cancelAvailabilityErrorNotifications(Context context) {
        AppMethodBeat.i(89369);
        GooglePlayServicesUtilLight.cancelAvailabilityErrorNotifications(context);
        AppMethodBeat.o(89369);
    }

    public int getApkVersion(Context context) {
        AppMethodBeat.i(89371);
        int apkVersion = GooglePlayServicesUtilLight.getApkVersion(context);
        AppMethodBeat.o(89371);
        return apkVersion;
    }

    public int getClientVersion(Context context) {
        AppMethodBeat.i(89370);
        int clientVersion = GooglePlayServicesUtilLight.getClientVersion(context);
        AppMethodBeat.o(89370);
        return clientVersion;
    }

    @Deprecated
    public Intent getErrorResolutionIntent(int i) {
        AppMethodBeat.i(89365);
        Intent errorResolutionIntent = getErrorResolutionIntent(null, i, null);
        AppMethodBeat.o(89365);
        return errorResolutionIntent;
    }

    public Intent getErrorResolutionIntent(Context context, int i, String str) {
        AppMethodBeat.i(89366);
        Intent createPlayStoreIntent;
        switch (i) {
            case 1:
            case 2:
                if (context == null || !DeviceProperties.isWearableWithoutPlayStore(context)) {
                    createPlayStoreIntent = GmsIntents.createPlayStoreIntent("com.google.android.gms", zza(context, str));
                    AppMethodBeat.o(89366);
                    return createPlayStoreIntent;
                }
                createPlayStoreIntent = GmsIntents.createAndroidWearUpdateIntent();
                AppMethodBeat.o(89366);
                return createPlayStoreIntent;
            case 3:
                createPlayStoreIntent = GmsIntents.createSettingsIntent("com.google.android.gms");
                AppMethodBeat.o(89366);
                return createPlayStoreIntent;
            default:
                AppMethodBeat.o(89366);
                return null;
        }
    }

    public PendingIntent getErrorResolutionPendingIntent(Context context, int i, int i2) {
        AppMethodBeat.i(89367);
        PendingIntent errorResolutionPendingIntent = getErrorResolutionPendingIntent(context, i, i2, null);
        AppMethodBeat.o(89367);
        return errorResolutionPendingIntent;
    }

    public PendingIntent getErrorResolutionPendingIntent(Context context, int i, int i2, String str) {
        AppMethodBeat.i(89368);
        Intent errorResolutionIntent = getErrorResolutionIntent(context, i, str);
        if (errorResolutionIntent == null) {
            AppMethodBeat.o(89368);
            return null;
        }
        PendingIntent activity = PendingIntent.getActivity(context, i2, errorResolutionIntent, 134217728);
        AppMethodBeat.o(89368);
        return activity;
    }

    public String getErrorString(int i) {
        AppMethodBeat.i(89375);
        String errorString = GooglePlayServicesUtilLight.getErrorString(i);
        AppMethodBeat.o(89375);
        return errorString;
    }

    public int isGooglePlayServicesAvailable(Context context) {
        AppMethodBeat.i(89360);
        int isGooglePlayServicesAvailable = isGooglePlayServicesAvailable(context, GOOGLE_PLAY_SERVICES_VERSION_CODE);
        AppMethodBeat.o(89360);
        return isGooglePlayServicesAvailable;
    }

    public int isGooglePlayServicesAvailable(Context context, int i) {
        AppMethodBeat.i(89361);
        int isGooglePlayServicesAvailable = GooglePlayServicesUtilLight.isGooglePlayServicesAvailable(context, i);
        if (GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(context, isGooglePlayServicesAvailable)) {
            isGooglePlayServicesAvailable = 18;
        }
        AppMethodBeat.o(89361);
        return isGooglePlayServicesAvailable;
    }

    public boolean isPlayServicesPossiblyUpdating(Context context, int i) {
        AppMethodBeat.i(89372);
        boolean isPlayServicesPossiblyUpdating = GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(context, i);
        AppMethodBeat.o(89372);
        return isPlayServicesPossiblyUpdating;
    }

    public boolean isPlayStorePossiblyUpdating(Context context, int i) {
        AppMethodBeat.i(89373);
        boolean isPlayStorePossiblyUpdating = GooglePlayServicesUtilLight.isPlayStorePossiblyUpdating(context, i);
        AppMethodBeat.o(89373);
        return isPlayStorePossiblyUpdating;
    }

    public boolean isUninstalledAppPossiblyUpdating(Context context, String str) {
        AppMethodBeat.i(89374);
        boolean isUninstalledAppPossiblyUpdating = GooglePlayServicesUtilLight.isUninstalledAppPossiblyUpdating(context, str);
        AppMethodBeat.o(89374);
        return isUninstalledAppPossiblyUpdating;
    }

    public boolean isUserResolvableError(int i) {
        AppMethodBeat.i(89364);
        boolean isUserRecoverableError = GooglePlayServicesUtilLight.isUserRecoverableError(i);
        AppMethodBeat.o(89364);
        return isUserRecoverableError;
    }

    public void verifyGooglePlayServicesIsAvailable(Context context) {
        AppMethodBeat.i(89362);
        GooglePlayServicesUtilLight.ensurePlayServicesAvailable(context);
        AppMethodBeat.o(89362);
    }

    public void verifyGooglePlayServicesIsAvailable(Context context, int i) {
        AppMethodBeat.i(89363);
        GooglePlayServicesUtilLight.ensurePlayServicesAvailable(context, i);
        AppMethodBeat.o(89363);
    }
}
