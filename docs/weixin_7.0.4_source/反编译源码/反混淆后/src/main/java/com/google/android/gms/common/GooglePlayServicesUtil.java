package com.google.android.gms.common;

import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.support.p057v4.app.Fragment;
import com.google.android.gms.common.internal.DialogRedirect;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class GooglePlayServicesUtil extends GooglePlayServicesUtilLight {
    public static final String GMS_ERROR_DIALOG = "GooglePlayServicesErrorDialog";
    @Deprecated
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    @Deprecated
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";

    private GooglePlayServicesUtil() {
    }

    @Deprecated
    public static Dialog getErrorDialog(int i, Activity activity, int i2) {
        AppMethodBeat.m2504i(60451);
        Dialog errorDialog = getErrorDialog(i, activity, i2, null);
        AppMethodBeat.m2505o(60451);
        return errorDialog;
    }

    @Deprecated
    public static Dialog getErrorDialog(int i, Activity activity, int i2, OnCancelListener onCancelListener) {
        AppMethodBeat.m2504i(60452);
        if (GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(activity, i)) {
            i = 18;
        }
        Dialog errorDialog = GoogleApiAvailability.getInstance().getErrorDialog(activity, i, i2, onCancelListener);
        AppMethodBeat.m2505o(60452);
        return errorDialog;
    }

    @Deprecated
    public static PendingIntent getErrorPendingIntent(int i, Context context, int i2) {
        AppMethodBeat.m2504i(60459);
        PendingIntent errorPendingIntent = GooglePlayServicesUtilLight.getErrorPendingIntent(i, context, i2);
        AppMethodBeat.m2505o(60459);
        return errorPendingIntent;
    }

    @Deprecated
    @VisibleForTesting
    public static String getErrorString(int i) {
        AppMethodBeat.m2504i(60457);
        String errorString = GooglePlayServicesUtilLight.getErrorString(i);
        AppMethodBeat.m2505o(60457);
        return errorString;
    }

    public static Context getRemoteContext(Context context) {
        AppMethodBeat.m2504i(60462);
        Context remoteContext = GooglePlayServicesUtilLight.getRemoteContext(context);
        AppMethodBeat.m2505o(60462);
        return remoteContext;
    }

    public static Resources getRemoteResource(Context context) {
        AppMethodBeat.m2504i(60461);
        Resources remoteResource = GooglePlayServicesUtilLight.getRemoteResource(context);
        AppMethodBeat.m2505o(60461);
        return remoteResource;
    }

    @Deprecated
    public static int isGooglePlayServicesAvailable(Context context) {
        AppMethodBeat.m2504i(60458);
        int isGooglePlayServicesAvailable = GooglePlayServicesUtilLight.isGooglePlayServicesAvailable(context);
        AppMethodBeat.m2505o(60458);
        return isGooglePlayServicesAvailable;
    }

    @Deprecated
    public static boolean isUserRecoverableError(int i) {
        AppMethodBeat.m2504i(60460);
        boolean isUserRecoverableError = GooglePlayServicesUtilLight.isUserRecoverableError(i);
        AppMethodBeat.m2505o(60460);
        return isUserRecoverableError;
    }

    @Deprecated
    public static boolean showErrorDialogFragment(int i, Activity activity, int i2) {
        AppMethodBeat.m2504i(60456);
        boolean showErrorDialogFragment = showErrorDialogFragment(i, activity, i2, null);
        AppMethodBeat.m2505o(60456);
        return showErrorDialogFragment;
    }

    @Deprecated
    public static boolean showErrorDialogFragment(int i, Activity activity, int i2, OnCancelListener onCancelListener) {
        AppMethodBeat.m2504i(60453);
        boolean showErrorDialogFragment = showErrorDialogFragment(i, activity, null, i2, onCancelListener);
        AppMethodBeat.m2505o(60453);
        return showErrorDialogFragment;
    }

    public static boolean showErrorDialogFragment(int i, Activity activity, Fragment fragment, int i2, OnCancelListener onCancelListener) {
        AppMethodBeat.m2504i(60454);
        if (GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(activity, i)) {
            i = 18;
        }
        GoogleApiAvailability instance = GoogleApiAvailability.getInstance();
        if (fragment == null) {
            boolean showErrorDialogFragment = instance.showErrorDialogFragment(activity, i, i2, onCancelListener);
            AppMethodBeat.m2505o(60454);
            return showErrorDialogFragment;
        }
        Dialog zza = GoogleApiAvailability.zza((Context) activity, i, DialogRedirect.getInstance(fragment, GoogleApiAvailability.getInstance().getErrorResolutionIntent(activity, i, "d"), i2), onCancelListener);
        if (zza == null) {
            AppMethodBeat.m2505o(60454);
            return false;
        }
        GoogleApiAvailability.zza(activity, zza, GMS_ERROR_DIALOG, onCancelListener);
        AppMethodBeat.m2505o(60454);
        return true;
    }

    @Deprecated
    public static void showErrorNotification(int i, Context context) {
        AppMethodBeat.m2504i(60455);
        GoogleApiAvailability instance = GoogleApiAvailability.getInstance();
        if (GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(context, i) || GooglePlayServicesUtilLight.isPlayStorePossiblyUpdating(context, i)) {
            instance.zza(context);
            AppMethodBeat.m2505o(60455);
            return;
        }
        instance.showErrorNotification(context, i);
        AppMethodBeat.m2505o(60455);
    }
}
