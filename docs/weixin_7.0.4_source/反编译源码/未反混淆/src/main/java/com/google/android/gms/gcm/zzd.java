package com.google.android.gms.gcm;

import android.app.Notification;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.v.c;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.google.android.gms.common.util.PlatformVersion;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import java.util.MissingFormatArgumentException;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;

final class zzd {
    static zzd zzj;
    private final Context zzk;
    private String zzl;
    private final AtomicInteger zzm = new AtomicInteger((int) SystemClock.elapsedRealtime());

    private zzd(Context context) {
        AppMethodBeat.i(70023);
        this.zzk = context.getApplicationContext();
        AppMethodBeat.o(70023);
    }

    static synchronized zzd zzd(Context context) {
        zzd zzd;
        synchronized (zzd.class) {
            AppMethodBeat.i(70021);
            if (zzj == null) {
                zzj = new zzd(context);
            }
            zzd = zzj;
            AppMethodBeat.o(70021);
        }
        return zzd;
    }

    static String zzd(Bundle bundle, String str) {
        AppMethodBeat.i(70022);
        String string = bundle.getString(str);
        if (string == null) {
            string = bundle.getString(str.replace("gcm.n.", "gcm.notification."));
        }
        AppMethodBeat.o(70022);
        return string;
    }

    private final Bundle zze() {
        AppMethodBeat.i(70026);
        ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = this.zzk.getPackageManager().getApplicationInfo(this.zzk.getPackageName(), 128);
        } catch (NameNotFoundException e) {
        }
        Bundle bundle;
        if (applicationInfo == null || applicationInfo.metaData == null) {
            bundle = Bundle.EMPTY;
            AppMethodBeat.o(70026);
            return bundle;
        }
        bundle = applicationInfo.metaData;
        AppMethodBeat.o(70026);
        return bundle;
    }

    private final String zze(Bundle bundle, String str) {
        AppMethodBeat.i(70025);
        String zzd = zzd(bundle, str);
        if (TextUtils.isEmpty(zzd)) {
            String valueOf = String.valueOf(str);
            zzd = String.valueOf("_loc_key");
            valueOf = zzd(bundle, zzd.length() != 0 ? valueOf.concat(zzd) : new String(valueOf));
            if (TextUtils.isEmpty(valueOf)) {
                AppMethodBeat.o(70025);
                return null;
            }
            Resources resources = this.zzk.getResources();
            int identifier = resources.getIdentifier(valueOf, "string", this.zzk.getPackageName());
            if (identifier == 0) {
                String valueOf2 = String.valueOf(str);
                zzd = String.valueOf("_loc_key");
                zzd = (zzd.length() != 0 ? valueOf2.concat(zzd) : new String(valueOf2)).substring(6);
                new StringBuilder((String.valueOf(zzd).length() + 49) + String.valueOf(valueOf).length()).append(zzd).append(" resource not found: ").append(valueOf).append(" Default value will be used.");
                AppMethodBeat.o(70025);
                return null;
            }
            String valueOf3 = String.valueOf(str);
            zzd = String.valueOf("_loc_args");
            valueOf3 = zzd(bundle, zzd.length() != 0 ? valueOf3.concat(zzd) : new String(valueOf3));
            if (TextUtils.isEmpty(valueOf3)) {
                zzd = resources.getString(identifier);
                AppMethodBeat.o(70025);
                return zzd;
            }
            try {
                JSONArray jSONArray = new JSONArray(valueOf3);
                String[] strArr = new String[jSONArray.length()];
                for (int i = 0; i < strArr.length; i++) {
                    strArr[i] = jSONArray.opt(i);
                }
                zzd = resources.getString(identifier, strArr);
                AppMethodBeat.o(70025);
                return zzd;
            } catch (JSONException e) {
                valueOf = String.valueOf(str);
                zzd = String.valueOf("_loc_args");
                zzd = (zzd.length() != 0 ? valueOf.concat(zzd) : new String(valueOf)).substring(6);
                new StringBuilder((String.valueOf(zzd).length() + 41) + String.valueOf(valueOf3).length()).append("Malformed ").append(zzd).append(": ").append(valueOf3).append("  Default value will be used.");
                AppMethodBeat.o(70025);
                return null;
            } catch (MissingFormatArgumentException e2) {
                new StringBuilder((String.valueOf(valueOf).length() + 58) + String.valueOf(valueOf3).length()).append("Missing format argument for ").append(valueOf).append(": ").append(valueOf3).append(" Default value will be used.");
                AppMethodBeat.o(70025);
                return null;
            }
        }
        AppMethodBeat.o(70025);
        return zzd;
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x02d0  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x02d9  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x02e2  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x02ea  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x02ef  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0200  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0162  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x017b  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x02d0  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x02d9  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x02e2  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x02ea  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x02ef  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0200  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zze(Bundle bundle) {
        CharSequence loadLabel;
        int identifier;
        int i;
        String zzd;
        Uri uri;
        String zzd2;
        Intent intent;
        PendingIntent pendingIntent;
        c as;
        Notification build;
        NotificationManager notificationManager;
        Bundle bundle2;
        String str = null;
        AppMethodBeat.i(70024);
        String zze = zze(bundle, "gcm.n.title");
        if (TextUtils.isEmpty(zze)) {
            loadLabel = this.zzk.getApplicationInfo().loadLabel(this.zzk.getPackageManager());
        } else {
            Object loadLabel2 = zze;
        }
        String zze2 = zze(bundle, "gcm.n.body");
        String zzd3 = zzd(bundle, "gcm.n.icon");
        if (!TextUtils.isEmpty(zzd3)) {
            Resources resources = this.zzk.getResources();
            identifier = resources.getIdentifier(zzd3, "drawable", this.zzk.getPackageName());
            if (identifier != 0) {
                i = identifier;
            } else {
                identifier = resources.getIdentifier(zzd3, "mipmap", this.zzk.getPackageName());
                if (identifier != 0) {
                    i = identifier;
                } else {
                    new StringBuilder(String.valueOf(zzd3).length() + 57).append("Icon resource ").append(zzd3).append(" not found. Notification will use app icon.");
                }
            }
            zzd = zzd(bundle, "gcm.n.color");
            zze = zzd(bundle, "gcm.n.sound2");
            if (!TextUtils.isEmpty(zze)) {
                uri = null;
            } else if ("default".equals(zze) || this.zzk.getResources().getIdentifier(zze, "raw", this.zzk.getPackageName()) == 0) {
                uri = RingtoneManager.getDefaultUri(2);
            } else {
                String packageName = this.zzk.getPackageName();
                uri = Uri.parse(new StringBuilder((String.valueOf(packageName).length() + 24) + String.valueOf(zze).length()).append("android.resource://").append(packageName).append("/raw/").append(zze).toString());
            }
            zzd2 = zzd(bundle, "gcm.n.click_action");
            Intent intent2;
            if (TextUtils.isEmpty(zzd2)) {
                intent2 = new Intent(zzd2);
                intent2.setPackage(this.zzk.getPackageName());
                intent2.setFlags(268435456);
                intent = intent2;
            } else {
                intent2 = this.zzk.getPackageManager().getLaunchIntentForPackage(this.zzk.getPackageName());
                if (intent2 == null) {
                    pendingIntent = null;
                    if (PlatformVersion.isAtLeastO() || this.zzk.getApplicationInfo().targetSdkVersion < 26) {
                        as = new c(this.zzk).z(true).as(i);
                        if (!TextUtils.isEmpty(loadLabel2)) {
                            as.d(loadLabel2);
                        }
                        if (!TextUtils.isEmpty(zze2)) {
                            as.e(zze2);
                        }
                        if (!TextUtils.isEmpty(zzd)) {
                            as.mColor = Color.parseColor(zzd);
                        }
                        if (uri != null) {
                            as.b(uri);
                        }
                        if (pendingIntent != null) {
                            as.EI = pendingIntent;
                        }
                        build = as.build();
                    } else {
                        String zzd4 = zzd(bundle, "gcm.n.android_channel_id");
                        if (PlatformVersion.isAtLeastO()) {
                            notificationManager = (NotificationManager) this.zzk.getSystemService(NotificationManager.class);
                            if (!TextUtils.isEmpty(zzd4)) {
                                if (notificationManager.getNotificationChannel(zzd4) != null) {
                                    str = zzd4;
                                } else {
                                    new StringBuilder(String.valueOf(zzd4).length() + 122).append("Notification Channel requested (").append(zzd4).append(") has not been created by the app. Manifest configuration, or default, value will be used.");
                                }
                            }
                            if (this.zzl != null) {
                                str = this.zzl;
                            } else {
                                this.zzl = zze().getString("com.google.android.gms.gcm.default_notification_channel_id");
                                if (TextUtils.isEmpty(this.zzl) || notificationManager.getNotificationChannel(this.zzl) == null) {
                                    if (notificationManager.getNotificationChannel("fcm_fallback_notification_channel") == null) {
                                        notificationManager.createNotificationChannel(new NotificationChannel("fcm_fallback_notification_channel", this.zzk.getString(R.string.r), 3));
                                    }
                                    this.zzl = "fcm_fallback_notification_channel";
                                    str = this.zzl;
                                } else {
                                    str = this.zzl;
                                }
                            }
                        }
                        Builder smallIcon = new Builder(this.zzk).setAutoCancel(true).setSmallIcon(i);
                        if (!TextUtils.isEmpty(loadLabel2)) {
                            smallIcon.setContentTitle(loadLabel2);
                        }
                        if (!TextUtils.isEmpty(zze2)) {
                            smallIcon.setContentText(zze2);
                            smallIcon.setStyle(new BigTextStyle().bigText(zze2));
                        }
                        if (!TextUtils.isEmpty(zzd)) {
                            smallIcon.setColor(Color.parseColor(zzd));
                        }
                        if (uri != null) {
                            smallIcon.setSound(uri);
                        }
                        if (pendingIntent != null) {
                            smallIcon.setContentIntent(pendingIntent);
                        }
                        if (str != null) {
                            smallIcon.setChannelId(str);
                        }
                        build = smallIcon.build();
                    }
                    zzd3 = zzd(bundle, "gcm.n.tag");
                    Log.isLoggable("GcmNotification", 3);
                    notificationManager = (NotificationManager) this.zzk.getSystemService("notification");
                    if (TextUtils.isEmpty(zzd3)) {
                        zzd3 = "GCM-Notification:" + SystemClock.uptimeMillis();
                    }
                    notificationManager.notify(zzd3, 0, build);
                    AppMethodBeat.o(70024);
                    return true;
                }
                intent = intent2;
            }
            bundle2 = new Bundle(bundle);
            GcmListenerService.zzd(bundle2);
            intent.putExtras(bundle2);
            for (String zze3 : bundle2.keySet()) {
                if (zze3.startsWith("gcm.n.") || zze3.startsWith("gcm.notification.")) {
                    intent.removeExtra(zze3);
                }
            }
            pendingIntent = PendingIntent.getActivity(this.zzk, this.zzm.getAndIncrement(), intent, ErrorDialogData.SUPPRESSED);
            if (PlatformVersion.isAtLeastO()) {
            }
            as = new c(this.zzk).z(true).as(i);
            if (TextUtils.isEmpty(loadLabel2)) {
            }
            if (TextUtils.isEmpty(zze2)) {
            }
            if (TextUtils.isEmpty(zzd)) {
            }
            if (uri != null) {
            }
            if (pendingIntent != null) {
            }
            build = as.build();
            zzd3 = zzd(bundle, "gcm.n.tag");
            Log.isLoggable("GcmNotification", 3);
            notificationManager = (NotificationManager) this.zzk.getSystemService("notification");
            if (TextUtils.isEmpty(zzd3)) {
            }
            notificationManager.notify(zzd3, 0, build);
            AppMethodBeat.o(70024);
            return true;
        }
        identifier = this.zzk.getApplicationInfo().icon;
        if (identifier == 0) {
            identifier = 17301651;
        }
        i = identifier;
        zzd = zzd(bundle, "gcm.n.color");
        zze3 = zzd(bundle, "gcm.n.sound2");
        if (!TextUtils.isEmpty(zze3)) {
        }
        zzd2 = zzd(bundle, "gcm.n.click_action");
        if (TextUtils.isEmpty(zzd2)) {
        }
        bundle2 = new Bundle(bundle);
        GcmListenerService.zzd(bundle2);
        intent.putExtras(bundle2);
        for (String zze32 : bundle2.keySet()) {
        }
        pendingIntent = PendingIntent.getActivity(this.zzk, this.zzm.getAndIncrement(), intent, ErrorDialogData.SUPPRESSED);
        if (PlatformVersion.isAtLeastO()) {
        }
        as = new c(this.zzk).z(true).as(i);
        if (TextUtils.isEmpty(loadLabel2)) {
        }
        if (TextUtils.isEmpty(zze2)) {
        }
        if (TextUtils.isEmpty(zzd)) {
        }
        if (uri != null) {
        }
        if (pendingIntent != null) {
        }
        build = as.build();
        zzd3 = zzd(bundle, "gcm.n.tag");
        Log.isLoggable("GcmNotification", 3);
        notificationManager = (NotificationManager) this.zzk.getSystemService("notification");
        if (TextUtils.isEmpty(zzd3)) {
        }
        notificationManager.notify(zzd3, 0, build);
        AppMethodBeat.o(70024);
        return true;
    }
}
