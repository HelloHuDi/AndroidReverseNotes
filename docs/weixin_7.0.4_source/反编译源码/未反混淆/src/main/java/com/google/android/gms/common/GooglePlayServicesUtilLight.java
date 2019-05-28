package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller.SessionInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.UserManager;
import android.util.Log;
import com.facebook.internal.Utility;
import com.google.android.gms.common.internal.MetadataValueReader;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.GmsVersionParser;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class GooglePlayServicesUtilLight {
    public static final String FEATURE_SIDEWINDER = "cn.google";
    public static final String GOOGLE_PLAY_GAMES_PACKAGE = "com.google.android.play.games";
    @Deprecated
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    @Deprecated
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = 12451000;
    public static final String GOOGLE_PLAY_STORE_GAMES_URI_STRING = "http://play.google.com/store/apps/category/GAME";
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
    public static final String GOOGLE_PLAY_STORE_URI_STRING = "http://play.google.com/store/apps/";
    public static final boolean HONOR_DEBUG_CERTIFICATES = false;
    public static final String KEY_METADATA_GOOGLE_PLAY_SERVICES_VERSION = "com.google.android.gms.version";
    public static final int MAX_ATTEMPTS_NO_SUCH_ALGORITHM = 2;
    @VisibleForTesting
    public static boolean sIsTestMode = false;
    @VisibleForTesting
    public static boolean sTestIsUserBuild = false;
    private static boolean zzbr = false;
    @VisibleForTesting
    private static boolean zzbs = false;
    @VisibleForTesting
    static final AtomicBoolean zzbt = new AtomicBoolean();
    private static final AtomicBoolean zzbu = new AtomicBoolean();

    static {
        AppMethodBeat.i(89418);
        AppMethodBeat.o(89418);
    }

    GooglePlayServicesUtilLight() {
    }

    @Deprecated
    public static void cancelAvailabilityErrorNotifications(Context context) {
        AppMethodBeat.i(89407);
        if (zzbt.getAndSet(true)) {
            AppMethodBeat.o(89407);
            return;
        }
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            if (notificationManager != null) {
                notificationManager.cancel(10436);
            }
            AppMethodBeat.o(89407);
        } catch (SecurityException e) {
            AppMethodBeat.o(89407);
        }
    }

    public static void enableUsingApkIndependentContext() {
        AppMethodBeat.i(89393);
        zzbu.set(true);
        AppMethodBeat.o(89393);
    }

    @Deprecated
    public static void ensurePlayServicesAvailable(Context context) {
        AppMethodBeat.i(89398);
        ensurePlayServicesAvailable(context, GOOGLE_PLAY_SERVICES_VERSION_CODE);
        AppMethodBeat.o(89398);
    }

    @Deprecated
    public static void ensurePlayServicesAvailable(Context context, int i) {
        AppMethodBeat.i(89399);
        int isGooglePlayServicesAvailable = GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, i);
        if (isGooglePlayServicesAvailable != 0) {
            Intent errorResolutionIntent = GoogleApiAvailabilityLight.getInstance().getErrorResolutionIntent(context, isGooglePlayServicesAvailable, "e");
            new StringBuilder(57).append("GooglePlayServices not available due to error ").append(isGooglePlayServicesAvailable);
            if (errorResolutionIntent == null) {
                GooglePlayServicesNotAvailableException googlePlayServicesNotAvailableException = new GooglePlayServicesNotAvailableException(isGooglePlayServicesAvailable);
                AppMethodBeat.o(89399);
                throw googlePlayServicesNotAvailableException;
            }
            GooglePlayServicesRepairableException googlePlayServicesRepairableException = new GooglePlayServicesRepairableException(isGooglePlayServicesAvailable, "Google Play Services not available", errorResolutionIntent);
            AppMethodBeat.o(89399);
            throw googlePlayServicesRepairableException;
        }
        AppMethodBeat.o(89399);
    }

    @Deprecated
    public static int getApkVersion(Context context) {
        int i = 0;
        AppMethodBeat.i(89412);
        try {
            i = context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
            AppMethodBeat.o(89412);
            return i;
        } catch (NameNotFoundException e) {
            AppMethodBeat.o(89412);
            return i;
        }
    }

    @Deprecated
    public static int getClientVersion(Context context) {
        AppMethodBeat.i(89411);
        Preconditions.checkState(true);
        int clientVersion = ClientLibraryUtils.getClientVersion(context, context.getPackageName());
        AppMethodBeat.o(89411);
        return clientVersion;
    }

    @Deprecated
    public static PendingIntent getErrorPendingIntent(int i, Context context, int i2) {
        AppMethodBeat.i(89406);
        PendingIntent errorResolutionPendingIntent = GoogleApiAvailabilityLight.getInstance().getErrorResolutionPendingIntent(context, i, i2);
        AppMethodBeat.o(89406);
        return errorResolutionPendingIntent;
    }

    @Deprecated
    @VisibleForTesting
    public static String getErrorString(int i) {
        AppMethodBeat.i(89394);
        String zza = ConnectionResult.zza(i);
        AppMethodBeat.o(89394);
        return zza;
    }

    @Deprecated
    public static Intent getGooglePlayServicesAvailabilityRecoveryIntent(int i) {
        AppMethodBeat.i(89402);
        Intent errorResolutionIntent = GoogleApiAvailabilityLight.getInstance().getErrorResolutionIntent(null, i, null);
        AppMethodBeat.o(89402);
        return errorResolutionIntent;
    }

    @Deprecated
    public static String getOpenSourceSoftwareLicenseInfo(Context context) {
        AppMethodBeat.i(89408);
        InputStream openInputStream;
        try {
            openInputStream = context.getContentResolver().openInputStream(new Builder().scheme("android.resource").authority("com.google.android.gms").appendPath("raw").appendPath("oss_notice").build());
            String next = new Scanner(openInputStream).useDelimiter("\\A").next();
            if (openInputStream != null) {
                openInputStream.close();
            }
            AppMethodBeat.o(89408);
            return next;
        } catch (NoSuchElementException e) {
            if (openInputStream != null) {
                openInputStream.close();
            }
            AppMethodBeat.o(89408);
            return null;
        } catch (Exception e2) {
            AppMethodBeat.o(89408);
            return null;
        } catch (Throwable th) {
            if (openInputStream != null) {
                openInputStream.close();
            }
            AppMethodBeat.o(89408);
        }
    }

    public static Context getRemoteContext(Context context) {
        AppMethodBeat.i(89410);
        try {
            Context createPackageContext = context.createPackageContext("com.google.android.gms", 3);
            AppMethodBeat.o(89410);
            return createPackageContext;
        } catch (NameNotFoundException e) {
            AppMethodBeat.o(89410);
            return null;
        }
    }

    public static Resources getRemoteResource(Context context) {
        AppMethodBeat.i(89409);
        try {
            Resources resourcesForApplication = context.getPackageManager().getResourcesForApplication("com.google.android.gms");
            AppMethodBeat.o(89409);
            return resourcesForApplication;
        } catch (NameNotFoundException e) {
            AppMethodBeat.o(89409);
            return null;
        }
    }

    public static boolean honorsDebugCertificates(Context context) {
        AppMethodBeat.i(89405);
        if (isTestKeysBuild(context) || !isUserBuildDevice()) {
            AppMethodBeat.o(89405);
            return true;
        }
        AppMethodBeat.o(89405);
        return false;
    }

    @Deprecated
    public static int isGooglePlayServicesAvailable(Context context) {
        AppMethodBeat.i(89395);
        int isGooglePlayServicesAvailable = isGooglePlayServicesAvailable(context, GOOGLE_PLAY_SERVICES_VERSION_CODE);
        AppMethodBeat.o(89395);
        return isGooglePlayServicesAvailable;
    }

    @Deprecated
    public static int isGooglePlayServicesAvailable(Context context, int i) {
        int googlePlayServicesVersion;
        AppMethodBeat.i(89396);
        try {
            context.getResources().getString(R.string.common_google_play_services_unknown_issue);
        } catch (Throwable th) {
        }
        if (!("com.google.android.gms".equals(context.getPackageName()) || zzbu.get())) {
            googlePlayServicesVersion = MetadataValueReader.getGooglePlayServicesVersion(context);
            if (googlePlayServicesVersion == 0) {
                IllegalStateException illegalStateException = new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
                AppMethodBeat.o(89396);
                throw illegalStateException;
            } else if (googlePlayServicesVersion != GOOGLE_PLAY_SERVICES_VERSION_CODE) {
                IllegalStateException illegalStateException2 = new IllegalStateException("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected " + GOOGLE_PLAY_SERVICES_VERSION_CODE + " but found " + googlePlayServicesVersion + ".  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
                AppMethodBeat.o(89396);
                throw illegalStateException2;
            }
        }
        boolean z = (DeviceProperties.isWearableWithoutPlayStore(context) || DeviceProperties.isIoT(context)) ? false : true;
        googlePlayServicesVersion = zza(context, z, i);
        AppMethodBeat.o(89396);
        return googlePlayServicesVersion;
    }

    @Deprecated
    public static boolean isGooglePlayServicesUid(Context context, int i) {
        AppMethodBeat.i(89400);
        boolean isGooglePlayServicesUid = UidVerifier.isGooglePlayServicesUid(context, i);
        AppMethodBeat.o(89400);
        return isGooglePlayServicesUid;
    }

    @Deprecated
    public static boolean isPlayServicesPossiblyUpdating(Context context, int i) {
        AppMethodBeat.i(89414);
        if (i == 18) {
            AppMethodBeat.o(89414);
            return true;
        } else if (i == 1) {
            boolean isUninstalledAppPossiblyUpdating = isUninstalledAppPossiblyUpdating(context, "com.google.android.gms");
            AppMethodBeat.o(89414);
            return isUninstalledAppPossiblyUpdating;
        } else {
            AppMethodBeat.o(89414);
            return false;
        }
    }

    @Deprecated
    public static boolean isPlayStorePossiblyUpdating(Context context, int i) {
        AppMethodBeat.i(89415);
        if (i == 9) {
            boolean isUninstalledAppPossiblyUpdating = isUninstalledAppPossiblyUpdating(context, "com.android.vending");
            AppMethodBeat.o(89415);
            return isUninstalledAppPossiblyUpdating;
        }
        AppMethodBeat.o(89415);
        return false;
    }

    @TargetApi(18)
    public static boolean isRestrictedUserProfile(Context context) {
        AppMethodBeat.i(89417);
        if (PlatformVersion.isAtLeastJellyBeanMR2()) {
            Bundle applicationRestrictions = ((UserManager) context.getSystemService("user")).getApplicationRestrictions(context.getPackageName());
            if (applicationRestrictions != null && "true".equals(applicationRestrictions.getString("restricted_profile"))) {
                AppMethodBeat.o(89417);
                return true;
            }
        }
        AppMethodBeat.o(89417);
        return false;
    }

    @Deprecated
    @VisibleForTesting
    public static boolean isSidewinderDevice(Context context) {
        AppMethodBeat.i(89413);
        boolean isSidewinder = DeviceProperties.isSidewinder(context);
        AppMethodBeat.o(89413);
        return isSidewinder;
    }

    public static boolean isTestKeysBuild(Context context) {
        AppMethodBeat.i(89404);
        if (!zzbs) {
            try {
                PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo("com.google.android.gms", 64);
                GoogleSignatureVerifier instance = GoogleSignatureVerifier.getInstance(context);
                if (packageInfo == null || instance.isGooglePublicSignedPackage(packageInfo, false) || !instance.isGooglePublicSignedPackage(packageInfo, true)) {
                    zzbr = false;
                } else {
                    zzbr = true;
                }
                zzbs = true;
            } catch (NameNotFoundException e) {
                zzbs = true;
            } catch (Throwable th) {
                zzbs = true;
                AppMethodBeat.o(89404);
            }
        }
        boolean z = zzbr;
        AppMethodBeat.o(89404);
        return z;
    }

    @TargetApi(21)
    static boolean isUninstalledAppPossiblyUpdating(Context context, String str) {
        AppMethodBeat.i(89416);
        boolean equals = str.equals("com.google.android.gms");
        if (PlatformVersion.isAtLeastLollipop()) {
            try {
                for (SessionInfo appPackageName : context.getPackageManager().getPackageInstaller().getAllSessions()) {
                    if (str.equals(appPackageName.getAppPackageName())) {
                        AppMethodBeat.o(89416);
                        return true;
                    }
                }
            } catch (Exception e) {
                AppMethodBeat.o(89416);
                return false;
            }
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, Utility.DEFAULT_STREAM_BUFFER_SIZE);
            if (equals) {
                boolean z = applicationInfo.enabled;
                AppMethodBeat.o(89416);
                return z;
            } else if (!applicationInfo.enabled || isRestrictedUserProfile(context)) {
                AppMethodBeat.o(89416);
                return false;
            } else {
                AppMethodBeat.o(89416);
                return true;
            }
        } catch (NameNotFoundException e2) {
            AppMethodBeat.o(89416);
            return false;
        }
    }

    @Deprecated
    public static boolean isUserBuildDevice() {
        AppMethodBeat.i(89403);
        boolean isUserBuild = DeviceProperties.isUserBuild();
        AppMethodBeat.o(89403);
        return isUserBuild;
    }

    @Deprecated
    public static boolean isUserRecoverableError(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 9:
                return true;
            default:
                return false;
        }
    }

    @TargetApi(19)
    @Deprecated
    public static boolean uidHasPackageName(Context context, int i, String str) {
        AppMethodBeat.i(89401);
        boolean uidHasPackageName = UidVerifier.uidHasPackageName(context, i, str);
        AppMethodBeat.o(89401);
        return uidHasPackageName;
    }

    @VisibleForTesting
    private static int zza(Context context, boolean z, int i) {
        AppMethodBeat.i(89397);
        Preconditions.checkArgument(i >= 0);
        PackageManager packageManager = context.getPackageManager();
        PackageInfo packageInfo = null;
        if (z) {
            try {
                packageInfo = packageManager.getPackageInfo("com.android.vending", 8256);
            } catch (NameNotFoundException e) {
                AppMethodBeat.o(89397);
                return 9;
            }
        }
        try {
            PackageInfo packageInfo2 = packageManager.getPackageInfo("com.google.android.gms", 64);
            GoogleSignatureVerifier instance = GoogleSignatureVerifier.getInstance(context);
            if (!instance.isGooglePublicSignedPackage(packageInfo2, true)) {
                AppMethodBeat.o(89397);
                return 9;
            } else if (z && (!instance.isGooglePublicSignedPackage(packageInfo, true) || !packageInfo.signatures[0].equals(packageInfo2.signatures[0]))) {
                AppMethodBeat.o(89397);
                return 9;
            } else if (GmsVersionParser.parseBuildVersion(packageInfo2.versionCode) < GmsVersionParser.parseBuildVersion(i)) {
                new StringBuilder(77).append("Google Play services out of date.  Requires ").append(i).append(" but found ").append(packageInfo2.versionCode);
                AppMethodBeat.o(89397);
                return 2;
            } else {
                ApplicationInfo applicationInfo = packageInfo2.applicationInfo;
                if (applicationInfo == null) {
                    try {
                        applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                    } catch (NameNotFoundException e2) {
                        Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.", e2);
                        AppMethodBeat.o(89397);
                        return 1;
                    }
                }
                if (applicationInfo.enabled) {
                    AppMethodBeat.o(89397);
                    return 0;
                }
                AppMethodBeat.o(89397);
                return 3;
            }
        } catch (NameNotFoundException e3) {
            AppMethodBeat.o(89397);
            return 1;
        }
    }
}
