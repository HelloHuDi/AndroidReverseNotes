package com.google.android.gms.auth;

import android.accounts.Account;
import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.URISyntaxException;
import java.util.List;

public final class GoogleAuthUtil extends zzg {
    public static final int CHANGE_TYPE_ACCOUNT_ADDED = 1;
    public static final int CHANGE_TYPE_ACCOUNT_REMOVED = 2;
    public static final int CHANGE_TYPE_ACCOUNT_RENAMED_FROM = 3;
    public static final int CHANGE_TYPE_ACCOUNT_RENAMED_TO = 4;
    public static final String GOOGLE_ACCOUNT_TYPE = "com.google";
    private static final String KEY_ANDROID_PACKAGE_NAME = zzg.KEY_ANDROID_PACKAGE_NAME;
    private static final String KEY_CALLER_UID = zzg.KEY_CALLER_UID;
    public static final String KEY_SUPPRESS_PROGRESS_SCREEN = "suppressProgressScreen";
    public static final String WORK_ACCOUNT_TYPE = "com.google.work";

    private GoogleAuthUtil() {
    }

    public static void clearToken(Context context, String str) {
        AppMethodBeat.i(76950);
        zzg.clearToken(context, str);
        AppMethodBeat.o(76950);
    }

    public static List<AccountChangeEvent> getAccountChangeEvents(Context context, int i, String str) {
        AppMethodBeat.i(76951);
        List accountChangeEvents = zzg.getAccountChangeEvents(context, i, str);
        AppMethodBeat.o(76951);
        return accountChangeEvents;
    }

    public static String getAccountId(Context context, String str) {
        AppMethodBeat.i(76952);
        String accountId = zzg.getAccountId(context, str);
        AppMethodBeat.o(76952);
        return accountId;
    }

    public static String getToken(Context context, Account account, String str) {
        AppMethodBeat.i(76947);
        String token = zzg.getToken(context, account, str);
        AppMethodBeat.o(76947);
        return token;
    }

    public static String getToken(Context context, Account account, String str, Bundle bundle) {
        AppMethodBeat.i(76948);
        String token = zzg.getToken(context, account, str, bundle);
        AppMethodBeat.o(76948);
        return token;
    }

    @Deprecated
    public static String getToken(Context context, String str, String str2) {
        AppMethodBeat.i(76945);
        String token = zzg.getToken(context, str, str2);
        AppMethodBeat.o(76945);
        return token;
    }

    @Deprecated
    public static String getToken(Context context, String str, String str2, Bundle bundle) {
        AppMethodBeat.i(76946);
        String token = zzg.getToken(context, str, str2, bundle);
        AppMethodBeat.o(76946);
        return token;
    }

    public static String getTokenWithNotification(Context context, Account account, String str, Bundle bundle) {
        AppMethodBeat.i(76941);
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putBoolean("handle_notification", true);
        String zze = zzd(context, account, str, bundle).zze();
        AppMethodBeat.o(76941);
        return zze;
    }

    public static String getTokenWithNotification(Context context, Account account, String str, Bundle bundle, Intent intent) {
        AppMethodBeat.i(76942);
        IllegalArgumentException illegalArgumentException;
        if (intent == null) {
            illegalArgumentException = new IllegalArgumentException("Callback cannot be null.");
            AppMethodBeat.o(76942);
            throw illegalArgumentException;
        }
        try {
            Intent.parseUri(intent.toUri(1), 1);
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putParcelable("callback_intent", intent);
            bundle.putBoolean("handle_notification", true);
            String zze = zzd(context, account, str, bundle).zze();
            AppMethodBeat.o(76942);
            return zze;
        } catch (URISyntaxException e) {
            illegalArgumentException = new IllegalArgumentException("Parameter callback contains invalid data. It must be serializable using toUri() and parseUri().");
            AppMethodBeat.o(76942);
            throw illegalArgumentException;
        }
    }

    public static String getTokenWithNotification(Context context, Account account, String str, Bundle bundle, String str2, Bundle bundle2) {
        AppMethodBeat.i(76943);
        Preconditions.checkNotEmpty(str2, "Authority cannot be empty or null.");
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (bundle2 == null) {
            bundle2 = new Bundle();
        }
        ContentResolver.validateSyncExtrasBundle(bundle2);
        bundle.putString("authority", str2);
        bundle.putBundle("sync_extras", bundle2);
        bundle.putBoolean("handle_notification", true);
        String zze = zzd(context, account, str, bundle).zze();
        AppMethodBeat.o(76943);
        return zze;
    }

    @Deprecated
    public static String getTokenWithNotification(Context context, String str, String str2, Bundle bundle) {
        AppMethodBeat.i(76938);
        String tokenWithNotification = getTokenWithNotification(context, new Account(str, "com.google"), str2, bundle);
        AppMethodBeat.o(76938);
        return tokenWithNotification;
    }

    @Deprecated
    public static String getTokenWithNotification(Context context, String str, String str2, Bundle bundle, Intent intent) {
        AppMethodBeat.i(76939);
        String tokenWithNotification = getTokenWithNotification(context, new Account(str, "com.google"), str2, bundle, intent);
        AppMethodBeat.o(76939);
        return tokenWithNotification;
    }

    @Deprecated
    public static String getTokenWithNotification(Context context, String str, String str2, Bundle bundle, String str3, Bundle bundle2) {
        AppMethodBeat.i(76940);
        String tokenWithNotification = getTokenWithNotification(context, new Account(str, "com.google"), str2, bundle, str3, bundle2);
        AppMethodBeat.o(76940);
        return tokenWithNotification;
    }

    @Deprecated
    public static void invalidateToken(Context context, String str) {
        AppMethodBeat.i(76949);
        zzg.invalidateToken(context, str);
        AppMethodBeat.o(76949);
    }

    @TargetApi(23)
    public static Bundle removeAccount(Context context, Account account) {
        AppMethodBeat.i(76953);
        Bundle removeAccount = zzg.removeAccount(context, account);
        AppMethodBeat.o(76953);
        return removeAccount;
    }

    @TargetApi(26)
    public static Boolean requestGoogleAccountsAccess(Context context) {
        AppMethodBeat.i(76954);
        Boolean requestGoogleAccountsAccess = zzg.requestGoogleAccountsAccess(context);
        AppMethodBeat.o(76954);
        return requestGoogleAccountsAccess;
    }

    private static TokenData zzd(Context context, Account account, String str, Bundle bundle) {
        UserRecoverableNotifiedException userRecoverableNotifiedException;
        AppMethodBeat.i(76944);
        if (bundle == null) {
            bundle = new Bundle();
        }
        try {
            TokenData zze = zzg.zze(context, account, str, bundle);
            GooglePlayServicesUtilLight.cancelAvailabilityErrorNotifications(context);
            AppMethodBeat.o(76944);
            return zze;
        } catch (GooglePlayServicesAvailabilityException e) {
            GooglePlayServicesUtil.showErrorNotification(e.getConnectionStatusCode(), context);
            userRecoverableNotifiedException = new UserRecoverableNotifiedException("User intervention required. Notification has been pushed.");
            AppMethodBeat.o(76944);
            throw userRecoverableNotifiedException;
        } catch (UserRecoverableAuthException e2) {
            GooglePlayServicesUtilLight.cancelAvailabilityErrorNotifications(context);
            userRecoverableNotifiedException = new UserRecoverableNotifiedException("User intervention required. Notification has been pushed.");
            AppMethodBeat.o(76944);
            throw userRecoverableNotifiedException;
        }
    }
}
