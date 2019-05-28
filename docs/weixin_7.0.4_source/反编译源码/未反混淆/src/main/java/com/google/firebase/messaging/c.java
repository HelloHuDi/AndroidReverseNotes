package com.google.firebase.messaging;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.KeyguardManager;
import android.app.Notification;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Color;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.support.v4.app.v;
import android.support.v4.content.b;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.firebase.iid.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.MissingFormatArgumentException;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;

final class c {
    private static c bxf;
    private final Context bvF;
    private Bundle bxg;
    private Method bxh;
    private Method bxi;
    private final AtomicInteger bxj = new AtomicInteger((int) SystemClock.elapsedRealtime());

    private c(Context context) {
        AppMethodBeat.i(77221);
        this.bvF = context.getApplicationContext();
        AppMethodBeat.o(77221);
    }

    @TargetApi(26)
    private final Notification a(CharSequence charSequence, String str, int i, Integer num, Uri uri, PendingIntent pendingIntent, PendingIntent pendingIntent2, String str2) {
        AppMethodBeat.i(77223);
        Builder smallIcon = new Builder(this.bvF).setAutoCancel(true).setSmallIcon(i);
        if (!TextUtils.isEmpty(charSequence)) {
            smallIcon.setContentTitle(charSequence);
        }
        if (!TextUtils.isEmpty(str)) {
            smallIcon.setContentText(str);
            smallIcon.setStyle(new BigTextStyle().bigText(str));
        }
        if (num != null) {
            smallIcon.setColor(num.intValue());
        }
        if (uri != null) {
            smallIcon.setSound(uri);
        }
        if (pendingIntent != null) {
            smallIcon.setContentIntent(pendingIntent);
        }
        if (pendingIntent2 != null) {
            smallIcon.setDeleteIntent(pendingIntent2);
        }
        if (str2 != null) {
            if (this.bxh == null) {
                this.bxh = bd("setChannelId");
            }
            if (this.bxh == null) {
                this.bxh = bd("setChannel");
            }
            if (this.bxh != null) {
                try {
                    this.bxh.invoke(smallIcon, new Object[]{str2});
                } catch (IllegalAccessException | IllegalArgumentException | SecurityException | InvocationTargetException e) {
                }
            }
        }
        Notification build = smallIcon.build();
        AppMethodBeat.o(77223);
        return build;
    }

    static synchronized c as(Context context) {
        c cVar;
        synchronized (c.class) {
            AppMethodBeat.i(77218);
            if (bxf == null) {
                bxf = new c(context);
            }
            cVar = bxf;
            AppMethodBeat.o(77218);
        }
        return cVar;
    }

    private static void b(Intent intent, Bundle bundle) {
        AppMethodBeat.i(77229);
        for (String str : bundle.keySet()) {
            if (str.startsWith("google.c.a.") || str.equals("from")) {
                intent.putExtra(str, bundle.getString(str));
            }
        }
        AppMethodBeat.o(77229);
    }

    @TargetApi(26)
    private static Method bd(String str) {
        AppMethodBeat.i(77224);
        try {
            Method method = Builder.class.getMethod(str, new Class[]{String.class});
            AppMethodBeat.o(77224);
            return method;
        } catch (NoSuchMethodException | SecurityException e) {
            AppMethodBeat.o(77224);
            return null;
        }
    }

    private final Integer be(String str) {
        Integer num = null;
        AppMethodBeat.i(77227);
        if (VERSION.SDK_INT < 21) {
            AppMethodBeat.o(77227);
        } else {
            if (!TextUtils.isEmpty(str)) {
                try {
                    num = Integer.valueOf(Color.parseColor(str));
                    AppMethodBeat.o(77227);
                } catch (IllegalArgumentException e) {
                    new StringBuilder(String.valueOf(str).length() + 54).append("Color ").append(str).append(" not valid. Notification will use default color.");
                }
            }
            int i = vb().getInt("com.google.firebase.messaging.default_notification_color", 0);
            if (i != 0) {
                try {
                    num = Integer.valueOf(b.i(this.bvF, i));
                    AppMethodBeat.o(77227);
                } catch (NotFoundException e2) {
                }
            }
            AppMethodBeat.o(77227);
        }
        return num;
    }

    static String d(Bundle bundle, String str) {
        AppMethodBeat.i(77219);
        String string = bundle.getString(str);
        if (string == null) {
            string = bundle.getString(str.replace("gcm.n.", "gcm.notification."));
        }
        AppMethodBeat.o(77219);
        return string;
    }

    private static Object[] e(Bundle bundle, String str) {
        AppMethodBeat.i(77220);
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf("_loc_args");
        String d = d(bundle, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        if (TextUtils.isEmpty(d)) {
            AppMethodBeat.o(77220);
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(d);
            String[] strArr = new String[jSONArray.length()];
            for (int i = 0; i < strArr.length; i++) {
                strArr[i] = jSONArray.opt(i);
            }
            AppMethodBeat.o(77220);
            return strArr;
        } catch (JSONException e) {
            valueOf = String.valueOf(str);
            valueOf2 = String.valueOf("_loc_args");
            valueOf2 = (valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)).substring(6);
            new StringBuilder((String.valueOf(valueOf2).length() + 41) + String.valueOf(d).length()).append("Malformed ").append(valueOf2).append(": ").append(d).append("  Default value will be used.");
            AppMethodBeat.o(77220);
            return null;
        }
    }

    @TargetApi(26)
    private final boolean fl(int i) {
        AppMethodBeat.i(77226);
        if (VERSION.SDK_INT != 26) {
            AppMethodBeat.o(77226);
            return true;
        }
        try {
            if (this.bvF.getResources().getDrawable(i, null) instanceof AdaptiveIconDrawable) {
                new StringBuilder(77).append("Adaptive icons cannot be used in notifications. Ignoring icon id: ").append(i);
                AppMethodBeat.o(77226);
                return false;
            }
            AppMethodBeat.o(77226);
            return true;
        } catch (NotFoundException e) {
            AppMethodBeat.o(77226);
            return false;
        }
    }

    private final Bundle vb() {
        AppMethodBeat.i(77230);
        Bundle bundle;
        if (this.bxg != null) {
            bundle = this.bxg;
            AppMethodBeat.o(77230);
            return bundle;
        }
        ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = this.bvF.getPackageManager().getApplicationInfo(this.bvF.getPackageName(), 128);
        } catch (NameNotFoundException e) {
        }
        if (applicationInfo == null || applicationInfo.metaData == null) {
            bundle = Bundle.EMPTY;
            AppMethodBeat.o(77230);
            return bundle;
        }
        this.bxg = applicationInfo.metaData;
        bundle = this.bxg;
        AppMethodBeat.o(77230);
        return bundle;
    }

    @TargetApi(26)
    private final String zzn(String str) {
        AppMethodBeat.i(77228);
        if (PlatformVersion.isAtLeastO()) {
            NotificationManager notificationManager = (NotificationManager) this.bvF.getSystemService(NotificationManager.class);
            try {
                if (this.bxi == null) {
                    this.bxi = notificationManager.getClass().getMethod("getNotificationChannel", new Class[]{String.class});
                }
                if (!TextUtils.isEmpty(str)) {
                    if (this.bxi.invoke(notificationManager, new Object[]{str}) != null) {
                        AppMethodBeat.o(77228);
                        return str;
                    }
                    new StringBuilder(String.valueOf(str).length() + 122).append("Notification Channel requested (").append(str).append(") has not been created by the app. Manifest configuration, or default, value will be used.");
                }
                str = vb().getString("com.google.firebase.messaging.default_notification_channel_id");
                if (!TextUtils.isEmpty(str)) {
                    if (this.bxi.invoke(notificationManager, new Object[]{str}) != null) {
                        AppMethodBeat.o(77228);
                        return str;
                    }
                }
                if (this.bxi.invoke(notificationManager, new Object[]{"fcm_fallback_notification_channel"}) == null) {
                    Object newInstance = Class.forName("android.app.NotificationChannel").getConstructor(new Class[]{String.class, CharSequence.class, Integer.TYPE}).newInstance(new Object[]{"fcm_fallback_notification_channel", this.bvF.getString(R.string.a), Integer.valueOf(3)});
                    notificationManager.getClass().getMethod("createNotificationChannel", new Class[]{r1}).invoke(notificationManager, new Object[]{newInstance});
                }
                str = "fcm_fallback_notification_channel";
                AppMethodBeat.o(77228);
                return str;
            } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException | LinkageError | NoSuchMethodException | SecurityException | InvocationTargetException e) {
                AppMethodBeat.o(77228);
                return null;
            }
        }
        AppMethodBeat.o(77228);
        return null;
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0208  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x026b  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x02b8  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x034c  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0317  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0320  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0331  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0339  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x033e  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0342  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0187  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x006c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean k(Bundle bundle) {
        PendingIntent pendingIntent = null;
        AppMethodBeat.i(77222);
        if ("1".equals(d(bundle, "gcm.n.noui"))) {
            AppMethodBeat.o(77222);
            return true;
        }
        boolean z;
        if (!((KeyguardManager) this.bvF.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            if (!PlatformVersion.isAtLeastLollipop()) {
                SystemClock.sleep(10);
            }
            int myPid = Process.myPid();
            List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.bvF.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses != null) {
                for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.pid == myPid) {
                        z = runningAppProcessInfo.importance == 100;
                        if (z) {
                            int identifier;
                            Integer be;
                            CharSequence d;
                            Uri uri;
                            String d2;
                            Intent intent;
                            PendingIntent a;
                            android.support.v4.app.v.c as;
                            Notification build;
                            NotificationManager notificationManager;
                            CharSequence zzd = zzd(bundle, "gcm.n.title");
                            if (TextUtils.isEmpty(zzd)) {
                                zzd = this.bvF.getApplicationInfo().loadLabel(this.bvF.getPackageManager());
                            }
                            String zzd2 = zzd(bundle, "gcm.n.body");
                            String d3 = d(bundle, "gcm.n.icon");
                            if (!TextUtils.isEmpty(d3)) {
                                Intent intent2;
                                Parcelable parcelable;
                                Resources resources = this.bvF.getResources();
                                identifier = resources.getIdentifier(d3, "drawable", this.bvF.getPackageName());
                                if (identifier == 0 || !fl(identifier)) {
                                    identifier = resources.getIdentifier(d3, "mipmap", this.bvF.getPackageName());
                                    if (identifier == 0 || !fl(identifier)) {
                                        new StringBuilder(String.valueOf(d3).length() + 61).append("Icon resource ").append(d3).append(" not found. Notification will use default icon.");
                                    }
                                }
                                be = be(d(bundle, "gcm.n.color"));
                                d = d(bundle, "gcm.n.sound2");
                                if (TextUtils.isEmpty(d)) {
                                    d = d(bundle, "gcm.n.sound");
                                }
                                if (!TextUtils.isEmpty(d)) {
                                    uri = null;
                                } else if ("default".equals(d) || this.bvF.getResources().getIdentifier(d, "raw", this.bvF.getPackageName()) == 0) {
                                    uri = RingtoneManager.getDefaultUri(2);
                                } else {
                                    String packageName = this.bvF.getPackageName();
                                    uri = Uri.parse(new StringBuilder((String.valueOf(packageName).length() + 24) + String.valueOf(d).length()).append("android.resource://").append(packageName).append("/raw/").append(d).toString());
                                }
                                d2 = d(bundle, "gcm.n.click_action");
                                if (TextUtils.isEmpty(d2)) {
                                    intent2 = new Intent(d2);
                                    intent2.setPackage(this.bvF.getPackageName());
                                    intent2.setFlags(268435456);
                                    intent = intent2;
                                } else {
                                    d = d(bundle, "gcm.n.link_android");
                                    if (TextUtils.isEmpty(d)) {
                                        d = d(bundle, "gcm.n.link");
                                    }
                                    Uri parse = !TextUtils.isEmpty(d) ? Uri.parse(d) : null;
                                    if (parse != null) {
                                        intent2 = new Intent("android.intent.action.VIEW");
                                        intent2.setPackage(this.bvF.getPackageName());
                                        intent2.setData(parse);
                                        intent = intent2;
                                    } else {
                                        intent = this.bvF.getPackageManager().getLaunchIntentForPackage(this.bvF.getPackageName());
                                    }
                                }
                                if (intent != null) {
                                    parcelable = null;
                                } else {
                                    intent.addFlags(67108864);
                                    Bundle bundle2 = new Bundle(bundle);
                                    FirebaseMessagingService.i(bundle2);
                                    intent.putExtras(bundle2);
                                    for (String d32 : bundle2.keySet()) {
                                        if (d32.startsWith("gcm.n.") || d32.startsWith("gcm.notification.")) {
                                            intent.removeExtra(d32);
                                        }
                                    }
                                    parcelable = PendingIntent.getActivity(this.bvF, this.bxj.incrementAndGet(), intent, ErrorDialogData.SUPPRESSED);
                                }
                                if (FirebaseMessagingService.j(bundle)) {
                                    Parcelable a2 = parcelable;
                                } else {
                                    intent = new Intent("com.google.firebase.messaging.NOTIFICATION_OPEN");
                                    b(intent, bundle);
                                    intent.putExtra("pending_intent", parcelable);
                                    a2 = o.a(this.bvF, this.bxj.incrementAndGet(), intent);
                                    intent2 = new Intent("com.google.firebase.messaging.NOTIFICATION_DISMISS");
                                    b(intent2, bundle);
                                    pendingIntent = o.a(this.bvF, this.bxj.incrementAndGet(), intent2);
                                }
                                if (PlatformVersion.isAtLeastO() || this.bvF.getApplicationInfo().targetSdkVersion <= 25) {
                                    as = new android.support.v4.app.v.c(this.bvF).z(true).as(identifier);
                                    if (!TextUtils.isEmpty(zzd)) {
                                        as.d(zzd);
                                    }
                                    if (!TextUtils.isEmpty(zzd2)) {
                                        as.e(zzd2);
                                        as.a(new v.b().c(zzd2));
                                    }
                                    if (be != null) {
                                        as.mColor = be.intValue();
                                    }
                                    if (uri != null) {
                                        as.b(uri);
                                    }
                                    if (a2 != null) {
                                        as.EI = a2;
                                    }
                                    if (pendingIntent != null) {
                                        as.a(pendingIntent);
                                    }
                                    build = as.build();
                                } else {
                                    build = a(zzd, zzd2, identifier, be, uri, a2, pendingIntent, zzn(d(bundle, "gcm.n.android_channel_id")));
                                }
                                zzd2 = d(bundle, "gcm.n.tag");
                                Log.isLoggable("FirebaseMessaging", 3);
                                notificationManager = (NotificationManager) this.bvF.getSystemService("notification");
                                if (TextUtils.isEmpty(zzd2)) {
                                    zzd2 = "FCM-Notification:" + SystemClock.uptimeMillis();
                                }
                                notificationManager.notify(zzd2, 0, build);
                                AppMethodBeat.o(77222);
                                return true;
                            }
                            int i = vb().getInt("com.google.firebase.messaging.default_notification_icon", 0);
                            if (i == 0 || !fl(i)) {
                                i = this.bvF.getApplicationInfo().icon;
                            }
                            if (i == 0 || !fl(i)) {
                                i = 17301651;
                            }
                            identifier = i;
                            be = be(d(bundle, "gcm.n.color"));
                            d = d(bundle, "gcm.n.sound2");
                            if (TextUtils.isEmpty(d)) {
                            }
                            if (!TextUtils.isEmpty(d)) {
                            }
                            d2 = d(bundle, "gcm.n.click_action");
                            if (TextUtils.isEmpty(d2)) {
                            }
                            if (intent != null) {
                            }
                            if (FirebaseMessagingService.j(bundle)) {
                            }
                            if (PlatformVersion.isAtLeastO()) {
                            }
                            as = new android.support.v4.app.v.c(this.bvF).z(true).as(identifier);
                            if (TextUtils.isEmpty(zzd)) {
                            }
                            if (TextUtils.isEmpty(zzd2)) {
                            }
                            if (be != null) {
                            }
                            if (uri != null) {
                            }
                            if (a2 != null) {
                            }
                            if (pendingIntent != null) {
                            }
                            build = as.build();
                            zzd2 = d(bundle, "gcm.n.tag");
                            Log.isLoggable("FirebaseMessaging", 3);
                            notificationManager = (NotificationManager) this.bvF.getSystemService("notification");
                            if (TextUtils.isEmpty(zzd2)) {
                            }
                            notificationManager.notify(zzd2, 0, build);
                            AppMethodBeat.o(77222);
                            return true;
                        }
                        AppMethodBeat.o(77222);
                        return false;
                    }
                }
            }
        }
        z = false;
        if (z) {
        }
    }

    private final String zzd(Bundle bundle, String str) {
        AppMethodBeat.i(77225);
        String d = d(bundle, str);
        if (TextUtils.isEmpty(d)) {
            String valueOf = String.valueOf(str);
            d = String.valueOf("_loc_key");
            valueOf = d(bundle, d.length() != 0 ? valueOf.concat(d) : new String(valueOf));
            if (TextUtils.isEmpty(valueOf)) {
                AppMethodBeat.o(77225);
                return null;
            }
            Resources resources = this.bvF.getResources();
            int identifier = resources.getIdentifier(valueOf, "string", this.bvF.getPackageName());
            if (identifier == 0) {
                String valueOf2 = String.valueOf(str);
                d = String.valueOf("_loc_key");
                d = (d.length() != 0 ? valueOf2.concat(d) : new String(valueOf2)).substring(6);
                new StringBuilder((String.valueOf(d).length() + 49) + String.valueOf(valueOf).length()).append(d).append(" resource not found: ").append(valueOf).append(" Default value will be used.");
                AppMethodBeat.o(77225);
                return null;
            }
            Object[] e = e(bundle, str);
            if (e == null) {
                d = resources.getString(identifier);
                AppMethodBeat.o(77225);
                return d;
            }
            try {
                d = resources.getString(identifier, e);
                AppMethodBeat.o(77225);
                return d;
            } catch (MissingFormatArgumentException e2) {
                d = Arrays.toString(e);
                new StringBuilder((String.valueOf(valueOf).length() + 58) + String.valueOf(d).length()).append("Missing format argument for ").append(valueOf).append(": ").append(d).append(" Default value will be used.");
                AppMethodBeat.o(77225);
                return null;
            }
        }
        AppMethodBeat.o(77225);
        return d;
    }
}
