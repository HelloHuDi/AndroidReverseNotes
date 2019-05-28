package com.google.android.gms.common;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.Notification;
import android.app.Notification.BigTextStyle;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.v.b;
import android.support.v4.app.v.c;
import android.util.TypedValue;
import android.widget.ProgressBar;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.GooglePlayServicesUpdatedReceiver;
import com.google.android.gms.common.api.internal.GooglePlayServicesUpdatedReceiver.Callback;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.api.internal.zzbt;
import com.google.android.gms.common.api.internal.zzh;
import com.google.android.gms.common.internal.ConnectionErrorMessages;
import com.google.android.gms.common.internal.DialogRedirect;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class GoogleApiAvailability extends GoogleApiAvailabilityLight {
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    private static final Object mLock = new Object();
    private static final GoogleApiAvailability zzas = new GoogleApiAvailability();
    private String zzat;

    @SuppressLint({"HandlerLeak"})
    class zza extends Handler {
        private final Context zzau;

        public zza(Context context) {
            super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
            AppMethodBeat.i(60415);
            this.zzau = context.getApplicationContext();
            AppMethodBeat.o(60415);
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.i(60416);
            switch (message.what) {
                case 1:
                    int isGooglePlayServicesAvailable = GoogleApiAvailability.this.isGooglePlayServicesAvailable(this.zzau);
                    if (GoogleApiAvailability.this.isUserResolvableError(isGooglePlayServicesAvailable)) {
                        GoogleApiAvailability.this.showErrorNotification(this.zzau, isGooglePlayServicesAvailable);
                        AppMethodBeat.o(60416);
                        return;
                    }
                    break;
                default:
                    new StringBuilder(50).append("Don't know how to handle this message: ").append(message.what);
                    break;
            }
            AppMethodBeat.o(60416);
        }
    }

    static {
        AppMethodBeat.i(60450);
        AppMethodBeat.o(60450);
    }

    GoogleApiAvailability() {
    }

    public static GoogleApiAvailability getInstance() {
        return zzas;
    }

    static Dialog zza(Context context, int i, DialogRedirect dialogRedirect, OnCancelListener onCancelListener) {
        Builder builder = null;
        AppMethodBeat.i(60445);
        if (i == 0) {
            AppMethodBeat.o(60445);
            return null;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16843529, typedValue, true);
        if ("Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId))) {
            builder = new Builder(context, 5);
        }
        if (builder == null) {
            builder = new Builder(context);
        }
        builder.setMessage(ConnectionErrorMessages.getErrorMessage(context, i));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        String errorDialogButtonMessage = ConnectionErrorMessages.getErrorDialogButtonMessage(context, i);
        if (errorDialogButtonMessage != null) {
            builder.setPositiveButton(errorDialogButtonMessage, dialogRedirect);
        }
        errorDialogButtonMessage = ConnectionErrorMessages.getErrorTitle(context, i);
        if (errorDialogButtonMessage != null) {
            builder.setTitle(errorDialogButtonMessage);
        }
        AlertDialog create = builder.create();
        AppMethodBeat.o(60445);
        return create;
    }

    @TargetApi(26)
    private final String zza(Context context, NotificationManager notificationManager) {
        AppMethodBeat.i(60448);
        Preconditions.checkState(PlatformVersion.isAtLeastO());
        String zzb = zzb();
        if (zzb == null) {
            zzb = "com.google.android.gms.availability";
            NotificationChannel notificationChannel = notificationManager.getNotificationChannel(zzb);
            String defaultNotificationChannelName = ConnectionErrorMessages.getDefaultNotificationChannelName(context);
            if (notificationChannel == null) {
                notificationManager.createNotificationChannel(new NotificationChannel(zzb, defaultNotificationChannelName, 4));
            } else if (!defaultNotificationChannelName.equals(notificationChannel.getName())) {
                notificationChannel.setName(defaultNotificationChannelName);
                notificationManager.createNotificationChannel(notificationChannel);
            }
        }
        AppMethodBeat.o(60448);
        return zzb;
    }

    static void zza(Activity activity, Dialog dialog, String str, OnCancelListener onCancelListener) {
        AppMethodBeat.i(60446);
        if (activity instanceof FragmentActivity) {
            SupportErrorDialogFragment.newInstance(dialog, onCancelListener).show(((FragmentActivity) activity).getSupportFragmentManager(), str);
            AppMethodBeat.o(60446);
            return;
        }
        ErrorDialogFragment.newInstance(dialog, onCancelListener).show(activity.getFragmentManager(), str);
        AppMethodBeat.o(60446);
    }

    private final String zzb() {
        String str;
        synchronized (mLock) {
            str = this.zzat;
        }
        return str;
    }

    public Task<Void> checkApiAvailability(GoogleApi<?> googleApi, GoogleApi<?>... googleApiArr) {
        AppMethodBeat.i(60429);
        Task continueWith = checkApiAvailabilityAndPackages(googleApi, googleApiArr).continueWith(new zza(this));
        AppMethodBeat.o(60429);
        return continueWith;
    }

    public Task<Map<zzh<?>, String>> checkApiAvailabilityAndPackages(GoogleApi<?> googleApi, GoogleApi<?>... googleApiArr) {
        AppMethodBeat.i(60430);
        Preconditions.checkNotNull(googleApi, "Requested API must not be null.");
        for (Object checkNotNull : googleApiArr) {
            Preconditions.checkNotNull(checkNotNull, "Requested API must not be null.");
        }
        Iterable arrayList = new ArrayList(googleApiArr.length + 1);
        arrayList.add(googleApi);
        arrayList.addAll(Arrays.asList(googleApiArr));
        Task zza = GoogleApiManager.zzbf().zza(arrayList);
        AppMethodBeat.o(60430);
        return zza;
    }

    public int getApkVersion(Context context) {
        AppMethodBeat.i(60441);
        int apkVersion = super.getApkVersion(context);
        AppMethodBeat.o(60441);
        return apkVersion;
    }

    public int getClientVersion(Context context) {
        AppMethodBeat.i(60440);
        int clientVersion = super.getClientVersion(context);
        AppMethodBeat.o(60440);
        return clientVersion;
    }

    public Dialog getErrorDialog(Activity activity, int i, int i2) {
        AppMethodBeat.i(60418);
        Dialog errorDialog = getErrorDialog(activity, i, i2, null);
        AppMethodBeat.o(60418);
        return errorDialog;
    }

    public Dialog getErrorDialog(Activity activity, int i, int i2, OnCancelListener onCancelListener) {
        AppMethodBeat.i(60419);
        Dialog zza = zza((Context) activity, i, DialogRedirect.getInstance(activity, getErrorResolutionIntent(activity, i, "d"), i2), onCancelListener);
        AppMethodBeat.o(60419);
        return zza;
    }

    @Deprecated
    public Intent getErrorResolutionIntent(int i) {
        AppMethodBeat.i(60435);
        Intent errorResolutionIntent = super.getErrorResolutionIntent(i);
        AppMethodBeat.o(60435);
        return errorResolutionIntent;
    }

    public Intent getErrorResolutionIntent(Context context, int i, String str) {
        AppMethodBeat.i(60436);
        Intent errorResolutionIntent = super.getErrorResolutionIntent(context, i, str);
        AppMethodBeat.o(60436);
        return errorResolutionIntent;
    }

    public PendingIntent getErrorResolutionPendingIntent(Context context, int i, int i2) {
        AppMethodBeat.i(60437);
        PendingIntent errorResolutionPendingIntent = super.getErrorResolutionPendingIntent(context, i, i2);
        AppMethodBeat.o(60437);
        return errorResolutionPendingIntent;
    }

    public PendingIntent getErrorResolutionPendingIntent(Context context, int i, int i2, String str) {
        AppMethodBeat.i(60439);
        PendingIntent errorResolutionPendingIntent = super.getErrorResolutionPendingIntent(context, i, i2, str);
        AppMethodBeat.o(60439);
        return errorResolutionPendingIntent;
    }

    public PendingIntent getErrorResolutionPendingIntent(Context context, ConnectionResult connectionResult) {
        AppMethodBeat.i(60438);
        PendingIntent resolution;
        if (connectionResult.hasResolution()) {
            resolution = connectionResult.getResolution();
            AppMethodBeat.o(60438);
            return resolution;
        }
        resolution = getErrorResolutionPendingIntent(context, connectionResult.getErrorCode(), 0);
        AppMethodBeat.o(60438);
        return resolution;
    }

    public final String getErrorString(int i) {
        AppMethodBeat.i(60444);
        String errorString = super.getErrorString(i);
        AppMethodBeat.o(60444);
        return errorString;
    }

    public int isGooglePlayServicesAvailable(Context context) {
        AppMethodBeat.i(60432);
        int isGooglePlayServicesAvailable = super.isGooglePlayServicesAvailable(context);
        AppMethodBeat.o(60432);
        return isGooglePlayServicesAvailable;
    }

    public int isGooglePlayServicesAvailable(Context context, int i) {
        AppMethodBeat.i(60433);
        int isGooglePlayServicesAvailable = super.isGooglePlayServicesAvailable(context, i);
        AppMethodBeat.o(60433);
        return isGooglePlayServicesAvailable;
    }

    public boolean isPlayServicesPossiblyUpdating(Context context, int i) {
        AppMethodBeat.i(60442);
        boolean isPlayServicesPossiblyUpdating = super.isPlayServicesPossiblyUpdating(context, i);
        AppMethodBeat.o(60442);
        return isPlayServicesPossiblyUpdating;
    }

    public boolean isPlayStorePossiblyUpdating(Context context, int i) {
        AppMethodBeat.i(60443);
        boolean isPlayStorePossiblyUpdating = super.isPlayStorePossiblyUpdating(context, i);
        AppMethodBeat.o(60443);
        return isPlayStorePossiblyUpdating;
    }

    public final boolean isUserResolvableError(int i) {
        AppMethodBeat.i(60434);
        boolean isUserResolvableError = super.isUserResolvableError(i);
        AppMethodBeat.o(60434);
        return isUserResolvableError;
    }

    public Task<Void> makeGooglePlayServicesAvailable(Activity activity) {
        AppMethodBeat.i(60417);
        Preconditions.checkMainThread("makeGooglePlayServicesAvailable must be called from the main thread");
        int isGooglePlayServicesAvailable = isGooglePlayServicesAvailable(activity);
        Task forResult;
        if (isGooglePlayServicesAvailable == 0) {
            forResult = Tasks.forResult(null);
            AppMethodBeat.o(60417);
            return forResult;
        }
        zzbt zzd = zzbt.zzd(activity);
        zzd.zzb(new ConnectionResult(isGooglePlayServicesAvailable, null), 0);
        forResult = zzd.getTask();
        AppMethodBeat.o(60417);
        return forResult;
    }

    public GooglePlayServicesUpdatedReceiver registerCallbackOnUpdate(Context context, Callback callback) {
        AppMethodBeat.i(60428);
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        GooglePlayServicesUpdatedReceiver googlePlayServicesUpdatedReceiver = new GooglePlayServicesUpdatedReceiver(callback);
        context.registerReceiver(googlePlayServicesUpdatedReceiver, intentFilter);
        googlePlayServicesUpdatedReceiver.zzc(context);
        if (isUninstalledAppPossiblyUpdating(context, "com.google.android.gms")) {
            AppMethodBeat.o(60428);
            return googlePlayServicesUpdatedReceiver;
        }
        callback.zzv();
        googlePlayServicesUpdatedReceiver.unregister();
        AppMethodBeat.o(60428);
        return null;
    }

    @TargetApi(26)
    public void setDefaultNotificationChannelId(Context context, String str) {
        AppMethodBeat.i(60431);
        if (PlatformVersion.isAtLeastO()) {
            Preconditions.checkNotNull(((NotificationManager) context.getSystemService("notification")).getNotificationChannel(str));
        }
        synchronized (mLock) {
            try {
                this.zzat = str;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(60431);
            }
        }
    }

    public boolean showErrorDialogFragment(Activity activity, int i, int i2) {
        AppMethodBeat.i(60420);
        boolean showErrorDialogFragment = showErrorDialogFragment(activity, i, i2, null);
        AppMethodBeat.o(60420);
        return showErrorDialogFragment;
    }

    public boolean showErrorDialogFragment(Activity activity, int i, int i2, OnCancelListener onCancelListener) {
        AppMethodBeat.i(60422);
        Dialog errorDialog = getErrorDialog(activity, i, i2, onCancelListener);
        if (errorDialog == null) {
            AppMethodBeat.o(60422);
            return false;
        }
        zza(activity, errorDialog, GooglePlayServicesUtil.GMS_ERROR_DIALOG, onCancelListener);
        AppMethodBeat.o(60422);
        return true;
    }

    public boolean showErrorDialogFragment(Activity activity, LifecycleFragment lifecycleFragment, int i, int i2, OnCancelListener onCancelListener) {
        AppMethodBeat.i(60421);
        Dialog zza = zza((Context) activity, i, DialogRedirect.getInstance(lifecycleFragment, getErrorResolutionIntent(activity, i, "d"), i2), onCancelListener);
        if (zza == null) {
            AppMethodBeat.o(60421);
            return false;
        }
        zza(activity, zza, GooglePlayServicesUtil.GMS_ERROR_DIALOG, onCancelListener);
        AppMethodBeat.o(60421);
        return true;
    }

    public void showErrorNotification(Context context, int i) {
        AppMethodBeat.i(60423);
        showErrorNotification(context, i, null);
        AppMethodBeat.o(60423);
    }

    public void showErrorNotification(Context context, int i, String str) {
        AppMethodBeat.i(60424);
        zza(context, i, str, getErrorResolutionPendingIntent(context, i, 0, "n"));
        AppMethodBeat.o(60424);
    }

    public void showErrorNotification(Context context, ConnectionResult connectionResult) {
        AppMethodBeat.i(60425);
        zza(context, connectionResult.getErrorCode(), null, getErrorResolutionPendingIntent(context, connectionResult));
        AppMethodBeat.o(60425);
    }

    public Dialog showUpdatingDialog(Activity activity, OnCancelListener onCancelListener) {
        AppMethodBeat.i(60427);
        ProgressBar progressBar = new ProgressBar(activity, null, 16842874);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        Builder builder = new Builder(activity);
        builder.setView(progressBar);
        builder.setMessage(ConnectionErrorMessages.getErrorMessage(activity, 18));
        builder.setPositiveButton("", null);
        Dialog create = builder.create();
        zza(activity, create, "GooglePlayServicesUpdatingDialog", onCancelListener);
        AppMethodBeat.o(60427);
        return create;
    }

    public boolean showWrappedErrorNotification(Context context, ConnectionResult connectionResult, int i) {
        AppMethodBeat.i(60426);
        PendingIntent errorResolutionPendingIntent = getErrorResolutionPendingIntent(context, connectionResult);
        if (errorResolutionPendingIntent != null) {
            zza(context, connectionResult.getErrorCode(), null, GoogleApiActivity.zza(context, errorResolutionPendingIntent, i));
            AppMethodBeat.o(60426);
            return true;
        }
        AppMethodBeat.o(60426);
        return false;
    }

    /* Access modifiers changed, original: final */
    public final void zza(Context context) {
        AppMethodBeat.i(60449);
        new zza(context).sendEmptyMessageDelayed(1, 120000);
        AppMethodBeat.o(60449);
    }

    @TargetApi(20)
    private final void zza(Context context, int i, String str, PendingIntent pendingIntent) {
        AppMethodBeat.i(60447);
        if (i == 18) {
            zza(context);
            AppMethodBeat.o(60447);
        } else if (pendingIntent == null) {
            AppMethodBeat.o(60447);
        } else {
            Notification build;
            int i2;
            String errorNotificationTitle = ConnectionErrorMessages.getErrorNotificationTitle(context, i);
            String errorNotificationMessage = ConnectionErrorMessages.getErrorNotificationMessage(context, i);
            Resources resources = context.getResources();
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            if (DeviceProperties.isWearable(context)) {
                Preconditions.checkState(PlatformVersion.isAtLeastKitKatWatch());
                Notification.Builder style = new Notification.Builder(context).setSmallIcon(context.getApplicationInfo().icon).setPriority(2).setAutoCancel(true).setContentTitle(errorNotificationTitle).setStyle(new BigTextStyle().bigText(errorNotificationMessage));
                if (DeviceProperties.isWearableWithoutPlayStore(context)) {
                    style.addAction(R.drawable.acw, resources.getString(R.string.common_open_on_phone), pendingIntent);
                } else {
                    style.setContentIntent(pendingIntent);
                }
                if (PlatformVersion.isAtLeastO() && PlatformVersion.isAtLeastO()) {
                    style.setChannelId(zza(context, notificationManager));
                }
                build = style.build();
            } else {
                c z = new c(context).as(17301642).g(resources.getString(R.string.common_google_play_services_notification_ticker)).j(System.currentTimeMillis()).z(true);
                z.EI = pendingIntent;
                c e = z.d(errorNotificationTitle).e(errorNotificationMessage);
                e.Fa = true;
                e = e.a(new b().c(errorNotificationMessage));
                if (PlatformVersion.isAtLeastO() && PlatformVersion.isAtLeastO()) {
                    e.mChannelId = zza(context, notificationManager);
                }
                build = e.build();
            }
            switch (i) {
                case 1:
                case 2:
                case 3:
                    i2 = 10436;
                    GooglePlayServicesUtilLight.zzbt.set(false);
                    break;
                default:
                    i2 = 39789;
                    break;
            }
            if (str == null) {
                notificationManager.notify(i2, build);
                AppMethodBeat.o(60447);
                return;
            }
            notificationManager.notify(str, i2, build);
            AppMethodBeat.o(60447);
        }
    }
}
