package com.google.android.gms.auth;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.common.BlockingServiceConnection;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.common.util.GmsVersion;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.List;

public class zzg {
    private static final String[] ACCEPTABLE_ACCOUNT_TYPES = new String[]{"com.google", "com.google.work", "cn.google"};
    public static final int CHANGE_TYPE_ACCOUNT_ADDED = 1;
    public static final int CHANGE_TYPE_ACCOUNT_REMOVED = 2;
    public static final int CHANGE_TYPE_ACCOUNT_RENAMED_FROM = 3;
    public static final int CHANGE_TYPE_ACCOUNT_RENAMED_TO = 4;
    public static final String GOOGLE_ACCOUNT_TYPE = "com.google";
    @SuppressLint({"InlinedApi"})
    public static final String KEY_ANDROID_PACKAGE_NAME = "androidPackageName";
    @SuppressLint({"InlinedApi"})
    public static final String KEY_CALLER_UID = "callerUid";
    public static final String KEY_SUPPRESS_PROGRESS_SCREEN = "suppressProgressScreen";
    public static final String WORK_ACCOUNT_TYPE = "com.google.work";
    private static final ComponentName zzp = new ComponentName("com.google.android.gms", "com.google.android.gms.auth.GetToken");
    private static final Logger zzq = new Logger("Auth", "GoogleAuthUtil");

    static {
        AppMethodBeat.i(77073);
        AppMethodBeat.o(77073);
    }

    zzg() {
    }

    public static void clearToken(Context context, String str) {
        AppMethodBeat.i(77063);
        Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
        ensurePlayServicesAvailable(context, GmsVersion.VERSION_URDA);
        Bundle bundle = new Bundle();
        String str2 = context.getApplicationInfo().packageName;
        bundle.putString("clientPackageName", str2);
        if (!bundle.containsKey(KEY_ANDROID_PACKAGE_NAME)) {
            bundle.putString(KEY_ANDROID_PACKAGE_NAME, str2);
        }
        zzd(context, zzp, new zzi(str, bundle));
        AppMethodBeat.o(77063);
    }

    private static void ensurePlayServicesAvailable(Context context, int i) {
        AppMethodBeat.i(77069);
        try {
            GooglePlayServicesUtilLight.ensurePlayServicesAvailable(context.getApplicationContext(), i);
            AppMethodBeat.o(77069);
        } catch (GooglePlayServicesRepairableException e) {
            GooglePlayServicesAvailabilityException googlePlayServicesAvailabilityException = new GooglePlayServicesAvailabilityException(e.getConnectionStatusCode(), e.getMessage(), e.getIntent());
            AppMethodBeat.o(77069);
            throw googlePlayServicesAvailabilityException;
        } catch (GooglePlayServicesNotAvailableException e2) {
            GoogleAuthException googleAuthException = new GoogleAuthException(e2.getMessage());
            AppMethodBeat.o(77069);
            throw googleAuthException;
        }
    }

    public static List<AccountChangeEvent> getAccountChangeEvents(Context context, int i, String str) {
        AppMethodBeat.i(77064);
        Preconditions.checkNotEmpty(str, "accountName must be provided");
        Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
        ensurePlayServicesAvailable(context, GmsVersion.VERSION_URDA);
        List list = (List) zzd(context, zzp, new zzj(str, i));
        AppMethodBeat.o(77064);
        return list;
    }

    public static String getAccountId(Context context, String str) {
        AppMethodBeat.i(77065);
        Preconditions.checkNotEmpty(str, "accountName must be provided");
        Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
        ensurePlayServicesAvailable(context, GmsVersion.VERSION_URDA);
        String token = getToken(context, str, "^^_account_id_^^", new Bundle());
        AppMethodBeat.o(77065);
        return token;
    }

    public static String getToken(Context context, Account account, String str) {
        AppMethodBeat.i(77059);
        String token = getToken(context, account, str, new Bundle());
        AppMethodBeat.o(77059);
        return token;
    }

    public static String getToken(Context context, Account account, String str, Bundle bundle) {
        AppMethodBeat.i(77060);
        zze(account);
        String zze = zze(context, account, str, bundle).zze();
        AppMethodBeat.o(77060);
        return zze;
    }

    @Deprecated
    public static String getToken(Context context, String str, String str2) {
        AppMethodBeat.i(77057);
        String token = getToken(context, new Account(str, "com.google"), str2);
        AppMethodBeat.o(77057);
        return token;
    }

    @Deprecated
    public static String getToken(Context context, String str, String str2, Bundle bundle) {
        AppMethodBeat.i(77058);
        String token = getToken(context, new Account(str, "com.google"), str2, bundle);
        AppMethodBeat.o(77058);
        return token;
    }

    @Deprecated
    public static void invalidateToken(Context context, String str) {
        AppMethodBeat.i(77062);
        AccountManager.get(context).invalidateAuthToken("com.google", str);
        AppMethodBeat.o(77062);
    }

    @TargetApi(23)
    public static Bundle removeAccount(Context context, Account account) {
        AppMethodBeat.i(77066);
        Preconditions.checkNotNull(context);
        zze(account);
        ensurePlayServicesAvailable(context, GmsVersion.VERSION_URDA);
        Bundle bundle = (Bundle) zzd(context, zzp, new zzk(account));
        AppMethodBeat.o(77066);
        return bundle;
    }

    @TargetApi(26)
    public static Boolean requestGoogleAccountsAccess(Context context) {
        AppMethodBeat.i(77067);
        Preconditions.checkNotNull(context);
        ensurePlayServicesAvailable(context, 11400000);
        Boolean bool = (Boolean) zzd(context, zzp, new zzl(context.getApplicationInfo().packageName));
        AppMethodBeat.o(77067);
        return bool;
    }

    private static <T> T zzd(Context context, ComponentName componentName, zzm<T> zzm) {
        AppMethodBeat.i(77071);
        ServiceConnection blockingServiceConnection = new BlockingServiceConnection();
        GmsClientSupervisor instance = GmsClientSupervisor.getInstance(context);
        if (instance.bindService(componentName, blockingServiceConnection, "GoogleAuthUtil")) {
            try {
                Object zze = zzm.zze(blockingServiceConnection.getService());
                instance.unbindService(componentName, blockingServiceConnection, "GoogleAuthUtil");
                AppMethodBeat.o(77071);
                return zze;
            } catch (RemoteException | InterruptedException e) {
                zzq.i("GoogleAuthUtil", "Error on service connection.", e);
                IOException iOException = new IOException("Error on service connection.", e);
                AppMethodBeat.o(77071);
                throw iOException;
            } catch (Throwable th) {
                instance.unbindService(componentName, blockingServiceConnection, "GoogleAuthUtil");
                AppMethodBeat.o(77071);
            }
        } else {
            IOException iOException2 = new IOException("Could not bind to service.");
            AppMethodBeat.o(77071);
            throw iOException2;
        }
    }

    private static <T> T zzd(T t) {
        AppMethodBeat.i(77070);
        if (t == null) {
            zzq.w("GoogleAuthUtil", "Binder call returned null.");
            IOException iOException = new IOException("Service unavailable.");
            AppMethodBeat.o(77070);
            throw iOException;
        }
        AppMethodBeat.o(77070);
        return t;
    }

    public static TokenData zze(Context context, Account account, String str, Bundle bundle) {
        AppMethodBeat.i(77061);
        Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
        Preconditions.checkNotEmpty(str, "Scope cannot be empty or null.");
        zze(account);
        ensurePlayServicesAvailable(context, GmsVersion.VERSION_URDA);
        Bundle bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
        String str2 = context.getApplicationInfo().packageName;
        bundle2.putString("clientPackageName", str2);
        if (TextUtils.isEmpty(bundle2.getString(KEY_ANDROID_PACKAGE_NAME))) {
            bundle2.putString(KEY_ANDROID_PACKAGE_NAME, str2);
        }
        bundle2.putLong("service_connection_start_time_millis", SystemClock.elapsedRealtime());
        TokenData tokenData = (TokenData) zzd(context, zzp, new zzh(account, str, bundle2));
        AppMethodBeat.o(77061);
        return tokenData;
    }

    private static void zze(Account account) {
        AppMethodBeat.i(77068);
        IllegalArgumentException illegalArgumentException;
        if (account == null) {
            illegalArgumentException = new IllegalArgumentException("Account cannot be null");
            AppMethodBeat.o(77068);
            throw illegalArgumentException;
        } else if (TextUtils.isEmpty(account.name)) {
            illegalArgumentException = new IllegalArgumentException("Account name cannot be empty!");
            AppMethodBeat.o(77068);
            throw illegalArgumentException;
        } else {
            for (String equals : ACCEPTABLE_ACCOUNT_TYPES) {
                if (equals.equals(account.type)) {
                    AppMethodBeat.o(77068);
                    return;
                }
            }
            illegalArgumentException = new IllegalArgumentException("Account type not supported");
            AppMethodBeat.o(77068);
            throw illegalArgumentException;
        }
    }
}
