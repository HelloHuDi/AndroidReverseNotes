package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.support.p057v4.p065f.C0417m;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.wrappers.Wrappers;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import javax.annotation.concurrent.GuardedBy;

public final class ConnectionErrorMessages {
    @GuardedBy("sCache")
    private static final C0417m<String, String> zzse = new C0417m();

    static {
        AppMethodBeat.m2504i(61333);
        AppMethodBeat.m2505o(61333);
    }

    private ConnectionErrorMessages() {
    }

    public static String getAppName(Context context) {
        AppMethodBeat.m2504i(61329);
        String packageName = context.getPackageName();
        try {
            packageName = Wrappers.packageManager(context).getApplicationLabel(packageName).toString();
            AppMethodBeat.m2505o(61329);
            return packageName;
        } catch (NameNotFoundException | NullPointerException e) {
            String str = context.getApplicationInfo().name;
            if (TextUtils.isEmpty(str)) {
                AppMethodBeat.m2505o(61329);
                return packageName;
            }
            AppMethodBeat.m2505o(61329);
            return str;
        }
    }

    public static String getDefaultNotificationChannelName(Context context) {
        AppMethodBeat.m2504i(61332);
        String string = context.getResources().getString(C25738R.string.common_google_play_services_notification_channel_name);
        AppMethodBeat.m2505o(61332);
        return string;
    }

    public static String getErrorDialogButtonMessage(Context context, int i) {
        AppMethodBeat.m2504i(61328);
        Resources resources = context.getResources();
        String string;
        switch (i) {
            case 1:
                string = resources.getString(C25738R.string.common_google_play_services_install_button);
                AppMethodBeat.m2505o(61328);
                return string;
            case 2:
                string = resources.getString(C25738R.string.common_google_play_services_update_button);
                AppMethodBeat.m2505o(61328);
                return string;
            case 3:
                string = resources.getString(C25738R.string.common_google_play_services_enable_button);
                AppMethodBeat.m2505o(61328);
                return string;
            default:
                string = resources.getString(17039370);
                AppMethodBeat.m2505o(61328);
                return string;
        }
    }

    public static String getErrorMessage(Context context, int i) {
        AppMethodBeat.m2504i(61326);
        Resources resources = context.getResources();
        String appName = getAppName(context);
        String string;
        switch (i) {
            case 1:
                string = resources.getString(C25738R.string.common_google_play_services_install_text, new Object[]{appName});
                AppMethodBeat.m2505o(61326);
                return string;
            case 2:
                if (DeviceProperties.isWearableWithoutPlayStore(context)) {
                    string = resources.getString(C25738R.string.common_google_play_services_wear_update_text);
                    AppMethodBeat.m2505o(61326);
                    return string;
                }
                string = resources.getString(C25738R.string.common_google_play_services_update_text, new Object[]{appName});
                AppMethodBeat.m2505o(61326);
                return string;
            case 3:
                string = resources.getString(C25738R.string.common_google_play_services_enable_text, new Object[]{appName});
                AppMethodBeat.m2505o(61326);
                return string;
            case 5:
                string = zza(context, "common_google_play_services_invalid_account_text", appName);
                AppMethodBeat.m2505o(61326);
                return string;
            case 7:
                string = zza(context, "common_google_play_services_network_error_text", appName);
                AppMethodBeat.m2505o(61326);
                return string;
            case 9:
                string = resources.getString(C25738R.string.common_google_play_services_unsupported_text, new Object[]{appName});
                AppMethodBeat.m2505o(61326);
                return string;
            case 16:
                string = zza(context, "common_google_play_services_api_unavailable_text", appName);
                AppMethodBeat.m2505o(61326);
                return string;
            case 17:
                string = zza(context, "common_google_play_services_sign_in_failed_text", appName);
                AppMethodBeat.m2505o(61326);
                return string;
            case 18:
                string = resources.getString(C25738R.string.common_google_play_services_updating_text, new Object[]{appName});
                AppMethodBeat.m2505o(61326);
                return string;
            case 20:
                string = zza(context, "common_google_play_services_restricted_profile_text", appName);
                AppMethodBeat.m2505o(61326);
                return string;
            default:
                string = resources.getString(C25738R.string.common_google_play_services_unknown_issue, new Object[]{appName});
                AppMethodBeat.m2505o(61326);
                return string;
        }
    }

    public static String getErrorNotificationMessage(Context context, int i) {
        AppMethodBeat.m2504i(61327);
        String zza;
        if (i == 6) {
            zza = zza(context, "common_google_play_services_resolution_required_text", getAppName(context));
            AppMethodBeat.m2505o(61327);
            return zza;
        }
        zza = getErrorMessage(context, i);
        AppMethodBeat.m2505o(61327);
        return zza;
    }

    public static String getErrorNotificationTitle(Context context, int i) {
        AppMethodBeat.m2504i(61325);
        String zzb = i == 6 ? zzb(context, "common_google_play_services_resolution_required_title") : getErrorTitle(context, i);
        if (zzb == null) {
            zzb = context.getResources().getString(C25738R.string.common_google_play_services_notification_ticker);
        }
        AppMethodBeat.m2505o(61325);
        return zzb;
    }

    public static String getErrorTitle(Context context, int i) {
        AppMethodBeat.m2504i(61324);
        Resources resources = context.getResources();
        String string;
        switch (i) {
            case 1:
                string = resources.getString(C25738R.string.common_google_play_services_install_title);
                AppMethodBeat.m2505o(61324);
                return string;
            case 2:
                string = resources.getString(C25738R.string.common_google_play_services_update_title);
                AppMethodBeat.m2505o(61324);
                return string;
            case 3:
                string = resources.getString(C25738R.string.common_google_play_services_enable_title);
                AppMethodBeat.m2505o(61324);
                return string;
            case 4:
            case 6:
            case 18:
                AppMethodBeat.m2505o(61324);
                return null;
            case 5:
                string = zzb(context, "common_google_play_services_invalid_account_title");
                AppMethodBeat.m2505o(61324);
                return string;
            case 7:
                string = zzb(context, "common_google_play_services_network_error_title");
                AppMethodBeat.m2505o(61324);
                return string;
            case 8:
                AppMethodBeat.m2505o(61324);
                return null;
            case 9:
                AppMethodBeat.m2505o(61324);
                return null;
            case 10:
                AppMethodBeat.m2505o(61324);
                return null;
            case 11:
                AppMethodBeat.m2505o(61324);
                return null;
            case 16:
                AppMethodBeat.m2505o(61324);
                return null;
            case 17:
                string = zzb(context, "common_google_play_services_sign_in_failed_title");
                AppMethodBeat.m2505o(61324);
                return string;
            case 20:
                string = zzb(context, "common_google_play_services_restricted_profile_title");
                AppMethodBeat.m2505o(61324);
                return string;
            default:
                new StringBuilder(33).append("Unexpected error code ").append(i);
                AppMethodBeat.m2505o(61324);
                return null;
        }
    }

    private static String zza(Context context, String str, String str2) {
        AppMethodBeat.m2504i(61330);
        Resources resources = context.getResources();
        String zzb = zzb(context, str);
        if (zzb == null) {
            zzb = resources.getString(C25738R.string.common_google_play_services_unknown_issue);
        }
        zzb = String.format(resources.getConfiguration().locale, zzb, new Object[]{str2});
        AppMethodBeat.m2505o(61330);
        return zzb;
    }

    /* JADX WARNING: Missing block: B:18:0x0042, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(61331);
     */
    /* JADX WARNING: Missing block: B:30:0x006e, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(61331);
     */
    /* JADX WARNING: Missing block: B:38:?, code skipped:
            return null;
     */
    /* JADX WARNING: Missing block: B:39:?, code skipped:
            return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static String zzb(Context context, String str) {
        String str2;
        AppMethodBeat.m2504i(61331);
        synchronized (zzse) {
            try {
                str2 = (String) zzse.get(str);
                if (str2 != null) {
                } else {
                    Resources remoteResource = GooglePlayServicesUtil.getRemoteResource(context);
                    if (remoteResource == null) {
                        AppMethodBeat.m2505o(61331);
                        return null;
                    }
                    int identifier = remoteResource.getIdentifier(str, "string", "com.google.android.gms");
                    String valueOf;
                    if (identifier == 0) {
                        str2 = "Missing resource: ";
                        valueOf = String.valueOf(str);
                        if (valueOf.length() != 0) {
                            str2.concat(valueOf);
                        } else {
                            valueOf = new String(str2);
                        }
                    } else {
                        str2 = remoteResource.getString(identifier);
                        if (TextUtils.isEmpty(str2)) {
                            str2 = "Got empty resource: ";
                            valueOf = String.valueOf(str);
                            if (valueOf.length() != 0) {
                                str2.concat(valueOf);
                            } else {
                                valueOf = new String(str2);
                            }
                        } else {
                            zzse.put(str, str2);
                            AppMethodBeat.m2505o(61331);
                            return str2;
                        }
                    }
                }
            } finally {
                AppMethodBeat.m2505o(61331);
            }
        }
        return str2;
    }
}
