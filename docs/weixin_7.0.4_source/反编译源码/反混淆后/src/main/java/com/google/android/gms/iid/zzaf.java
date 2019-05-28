package com.google.android.gms.iid;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.support.p057v4.p065f.C6197a;
import android.util.Log;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.Tasks;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.IOException;
import java.security.KeyPair;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class zzaf {
    private static int zzck = 0;
    private static final zzaj<Boolean> zzco = zzai.zzw().zzd("gcm_iid_use_messenger_ipc", true);
    private static String zzcp = null;
    private static boolean zzcq = false;
    private static int zzcr = 0;
    private static int zzcs = 0;
    private static BroadcastReceiver zzct = null;
    private PendingIntent zzad;
    private Messenger zzah;
    private Map<String, Object> zzcu = new C6197a();
    private Messenger zzcv;
    private MessengerCompat zzcw;
    private Context zzk;

    static {
        AppMethodBeat.m2504i(57546);
        AppMethodBeat.m2505o(57546);
    }

    public zzaf(Context context) {
        AppMethodBeat.m2504i(57530);
        this.zzk = context;
        AppMethodBeat.m2505o(57530);
    }

    private static void zzd(Object obj, Object obj2) {
        AppMethodBeat.m2504i(57540);
        if (obj instanceof ConditionVariable) {
            ((ConditionVariable) obj).open();
        }
        if (obj instanceof Messenger) {
            Messenger messenger = (Messenger) obj;
            Message obtain = Message.obtain();
            obtain.obj = obj2;
            try {
                messenger.send(obtain);
                AppMethodBeat.m2505o(57540);
                return;
            } catch (RemoteException e) {
                String valueOf = String.valueOf(e);
                new StringBuilder(String.valueOf(valueOf).length() + 24).append("Failed to send response ").append(valueOf);
            }
        }
        AppMethodBeat.m2505o(57540);
    }

    private final void zzd(String str, Object obj) {
        AppMethodBeat.m2504i(57539);
        synchronized (getClass()) {
            try {
                Object obj2 = this.zzcu.get(str);
                this.zzcu.put(str, obj);
                zzd(obj2, obj);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(57539);
            }
        }
    }

    private static boolean zzd(PackageManager packageManager, String str) {
        AppMethodBeat.m2504i(57534);
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 0);
            zzcp = applicationInfo.packageName;
            zzcs = applicationInfo.uid;
            AppMethodBeat.m2505o(57534);
            return true;
        } catch (NameNotFoundException e) {
            AppMethodBeat.m2505o(57534);
            return false;
        }
    }

    private static boolean zzd(PackageManager packageManager, String str, String str2) {
        AppMethodBeat.m2504i(57533);
        if (packageManager.checkPermission("com.google.android.c2dm.permission.SEND", str) == 0) {
            boolean zzd = zzd(packageManager, str);
            AppMethodBeat.m2505o(57533);
            return zzd;
        }
        new StringBuilder((String.valueOf(str).length() + 56) + String.valueOf(str2).length()).append("Possible malicious package ").append(str).append(" declares ").append(str2).append(" without permission");
        AppMethodBeat.m2505o(57533);
        return false;
    }

    private final synchronized void zzg(Intent intent) {
        AppMethodBeat.m2504i(57537);
        if (this.zzad == null) {
            Intent intent2 = new Intent();
            intent2.setPackage("com.google.example.invalidpackage");
            this.zzad = PendingIntent.getBroadcast(this.zzk, 0, intent2, 0);
        }
        intent.putExtra("app", this.zzad);
        AppMethodBeat.m2505o(57537);
    }

    static String zzi(Bundle bundle) {
        AppMethodBeat.m2504i(57538);
        IOException iOException;
        if (bundle == null) {
            iOException = new IOException("SERVICE_NOT_AVAILABLE");
            AppMethodBeat.m2505o(57538);
            throw iOException;
        }
        String string = bundle.getString("registration_id");
        if (string == null) {
            string = bundle.getString("unregistered");
        }
        if (string == null) {
            string = bundle.getString("error");
            if (string != null) {
                IOException iOException2 = new IOException(string);
                AppMethodBeat.m2505o(57538);
                throw iOException2;
            }
            string = String.valueOf(bundle);
            new StringBuilder(String.valueOf(string).length() + 29).append("Unexpected response from GCM ").append(string);
            Throwable th = new Throwable();
            iOException = new IOException("SERVICE_NOT_AVAILABLE");
            AppMethodBeat.m2505o(57538);
            throw iOException;
        }
        AppMethodBeat.m2505o(57538);
        return string;
    }

    private final Bundle zzj(Bundle bundle) {
        AppMethodBeat.m2504i(57543);
        Bundle zzk = zzk(bundle);
        if (zzk != null && zzk.containsKey("google.messenger")) {
            zzk = zzk(bundle);
            if (zzk != null && zzk.containsKey("google.messenger")) {
                zzk = null;
            }
        }
        AppMethodBeat.m2505o(57543);
        return zzk;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x011b A:{SYNTHETIC, Splitter:B:32:0x011b} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final Bundle zzk(Bundle bundle) {
        AppMethodBeat.m2504i(57545);
        ConditionVariable conditionVariable = new ConditionVariable();
        String zzv = zzv();
        synchronized (getClass()) {
            try {
                this.zzcu.put(zzv, conditionVariable);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(57545);
            }
        }
        if (this.zzah == null) {
            zzl(this.zzk);
            this.zzah = new Messenger(new zzag(this, Looper.getMainLooper()));
        }
        Object iOException;
        if (zzcp == null) {
            iOException = new IOException(InstanceID.ERROR_MISSING_INSTANCEID_SERVICE);
            throw iOException;
        }
        Bundle bundle2;
        Intent intent = new Intent(zzcq ? "com.google.iid.TOKEN_REQUEST" : "com.google.android.c2dm.intent.REGISTER");
        intent.setPackage(zzcp);
        intent.putExtras(bundle);
        zzg(intent);
        intent.putExtra("kid", new StringBuilder(String.valueOf(zzv).length() + 5).append("|ID|").append(zzv).append("|").toString());
        intent.putExtra("X-kid", new StringBuilder(String.valueOf(zzv).length() + 5).append("|ID|").append(zzv).append("|").toString());
        boolean equals = "com.google.android.gsf".equals(zzcp);
        String stringExtra = intent.getStringExtra("useGsf");
        if (stringExtra != null) {
            equals = "1".equals(stringExtra);
        }
        if (Log.isLoggable("InstanceID", 3)) {
            stringExtra = String.valueOf(intent.getExtras());
            new StringBuilder(String.valueOf(stringExtra).length() + 8).append("Sending ").append(stringExtra);
        }
        if (this.zzcv != null) {
            intent.putExtra("google.messenger", this.zzah);
            Message obtain = Message.obtain();
            obtain.obj = intent;
            try {
                this.zzcv.send(obtain);
            } catch (RemoteException e) {
                Log.isLoggable("InstanceID", 3);
            }
            conditionVariable.block(30000);
            synchronized (getClass()) {
                try {
                    iOException = this.zzcu.remove(zzv);
                    if (iOException instanceof Bundle) {
                        bundle2 = (Bundle) iOException;
                    } else if (iOException instanceof String) {
                        IOException iOException2 = new IOException((String) iOException);
                        AppMethodBeat.m2505o(57545);
                        throw iOException2;
                    } else {
                        String valueOf = String.valueOf(iOException);
                        new StringBuilder(String.valueOf(valueOf).length() + 12).append("No response ").append(valueOf);
                        IOException iOException3 = new IOException(InstanceID.ERROR_TIMEOUT);
                        AppMethodBeat.m2505o(57545);
                        throw iOException3;
                    }
                } finally {
                    AppMethodBeat.m2505o(57545);
                }
            }
            return bundle2;
        }
        if (equals) {
            synchronized (this) {
                try {
                    if (zzct == null) {
                        zzct = new zzah(this);
                        Log.isLoggable("InstanceID", 3);
                        IntentFilter intentFilter = new IntentFilter("com.google.android.c2dm.intent.REGISTRATION");
                        intentFilter.addCategory(this.zzk.getPackageName());
                        this.zzk.registerReceiver(zzct, intentFilter, "com.google.android.c2dm.permission.SEND", null);
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(57545);
                    }
                }
            }
            this.zzk.sendBroadcast(intent);
        } else {
            intent.putExtra("google.messenger", this.zzah);
            intent.putExtra("messenger2", "1");
            if (this.zzcw != null) {
                Message obtain2 = Message.obtain();
                obtain2.obj = intent;
                try {
                    this.zzcw.send(obtain2);
                } catch (RemoteException e2) {
                    Log.isLoggable("InstanceID", 3);
                }
            }
            if (zzcq) {
                this.zzk.sendBroadcast(intent);
            } else {
                this.zzk.startService(intent);
            }
        }
        conditionVariable.block(30000);
        synchronized (getClass()) {
        }
        return bundle2;
    }

    public static boolean zzk(Context context) {
        AppMethodBeat.m2504i(57531);
        if (zzcp != null) {
            zzl(context);
        }
        boolean z = zzcq;
        AppMethodBeat.m2505o(57531);
        return z;
    }

    public static String zzl(Context context) {
        AppMethodBeat.m2504i(57532);
        String str;
        if (zzcp != null) {
            str = zzcp;
            AppMethodBeat.m2505o(57532);
            return str;
        }
        boolean z;
        zzcr = Process.myUid();
        PackageManager packageManager = context.getPackageManager();
        if (!PlatformVersion.isAtLeastO()) {
            for (ResolveInfo resolveInfo : packageManager.queryIntentServices(new Intent("com.google.android.c2dm.intent.REGISTER"), 0)) {
                if (zzd(packageManager, resolveInfo.serviceInfo.packageName, "com.google.android.c2dm.intent.REGISTER")) {
                    zzcq = false;
                    z = true;
                    break;
                }
            }
            z = false;
            if (z) {
                str = zzcp;
                AppMethodBeat.m2505o(57532);
                return str;
            }
        }
        for (ResolveInfo resolveInfo2 : packageManager.queryBroadcastReceivers(new Intent("com.google.iid.TOKEN_REQUEST"), 0)) {
            if (zzd(packageManager, resolveInfo2.activityInfo.packageName, "com.google.iid.TOKEN_REQUEST")) {
                zzcq = true;
                z = true;
                break;
            }
        }
        z = false;
        if (z) {
            str = zzcp;
            AppMethodBeat.m2505o(57532);
            return str;
        } else if (zzd(packageManager, "com.google.android.gms")) {
            zzcq = PlatformVersion.isAtLeastO();
            str = zzcp;
            AppMethodBeat.m2505o(57532);
            return str;
        } else if (PlatformVersion.isAtLeastLollipop() || !zzd(packageManager, "com.google.android.gsf")) {
            AppMethodBeat.m2505o(57532);
            return null;
        } else {
            zzcq = false;
            str = zzcp;
            AppMethodBeat.m2505o(57532);
            return str;
        }
    }

    private static int zzm(Context context) {
        AppMethodBeat.m2504i(57535);
        try {
            int i = context.getPackageManager().getPackageInfo(zzl(context), 0).versionCode;
            AppMethodBeat.m2505o(57535);
            return i;
        } catch (NameNotFoundException e) {
            AppMethodBeat.m2505o(57535);
            return -1;
        }
    }

    private static synchronized String zzv() {
        String num;
        synchronized (zzaf.class) {
            AppMethodBeat.m2504i(57544);
            int i = zzck;
            zzck = i + 1;
            num = Integer.toString(i);
            AppMethodBeat.m2505o(57544);
        }
        return num;
    }

    /* Access modifiers changed, original: final */
    public final Bundle zzd(Bundle bundle, KeyPair keyPair) {
        AppMethodBeat.m2504i(57542);
        int zzm = zzm(this.zzk);
        bundle.putString("gmsv", Integer.toString(zzm));
        bundle.putString("osv", Integer.toString(VERSION.SDK_INT));
        bundle.putString("app_ver", Integer.toString(InstanceID.zzg(this.zzk)));
        bundle.putString("app_ver_name", InstanceID.zzh(this.zzk));
        bundle.putString("cliv", "iid-12451000");
        bundle.putString("appid", InstanceID.zzd(keyPair));
        Bundle zzj;
        if (zzm < 12000000 || !((Boolean) zzco.get()).booleanValue()) {
            zzj = zzj(bundle);
            AppMethodBeat.m2505o(57542);
            return zzj;
        }
        try {
            zzj = (Bundle) Tasks.await(new zzr(this.zzk).zzd(1, bundle));
            AppMethodBeat.m2505o(57542);
            return zzj;
        } catch (InterruptedException | ExecutionException e) {
            if (Log.isLoggable("InstanceID", 3)) {
                String valueOf = String.valueOf(e);
                new StringBuilder(String.valueOf(valueOf).length() + 22).append("Error making request: ").append(valueOf);
            }
            if ((e.getCause() instanceof zzaa) && ((zzaa) e.getCause()).getErrorCode() == 4) {
                zzj = zzj(bundle);
                AppMethodBeat.m2505o(57542);
                return zzj;
            }
            AppMethodBeat.m2505o(57542);
            return null;
        }
    }

    public final void zze(Message message) {
        AppMethodBeat.m2504i(57536);
        if (message == null) {
            AppMethodBeat.m2505o(57536);
        } else if (message.obj instanceof Intent) {
            Intent intent = (Intent) message.obj;
            intent.setExtrasClassLoader(MessengerCompat.class.getClassLoader());
            if (intent.hasExtra("google.messenger")) {
                Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                if (parcelableExtra instanceof MessengerCompat) {
                    this.zzcw = (MessengerCompat) parcelableExtra;
                }
                if (parcelableExtra instanceof Messenger) {
                    this.zzcv = (Messenger) parcelableExtra;
                }
            }
            zzh((Intent) message.obj);
            AppMethodBeat.m2505o(57536);
        } else {
            AppMethodBeat.m2505o(57536);
        }
    }

    public final void zzh(Intent intent) {
        AppMethodBeat.m2504i(57541);
        if (intent == null) {
            Log.isLoggable("InstanceID", 3);
            AppMethodBeat.m2505o(57541);
            return;
        }
        String action = intent.getAction();
        String valueOf;
        if ("com.google.android.c2dm.intent.REGISTRATION".equals(action) || "com.google.android.gms.iid.InstanceID".equals(action)) {
            CharSequence stringExtra = intent.getStringExtra("registration_id");
            if (stringExtra == null) {
                stringExtra = intent.getStringExtra("unregistered");
            }
            if (stringExtra == null) {
                Object stringExtra2 = intent.getStringExtra("error");
                if (stringExtra2 == null) {
                    action = String.valueOf(intent.getExtras());
                    new StringBuilder(String.valueOf(action).length() + 49).append("Unexpected response, no error or registration id ").append(action);
                    AppMethodBeat.m2505o(57541);
                    return;
                }
                if (Log.isLoggable("InstanceID", 3)) {
                    action = "Received InstanceID error ";
                    String valueOf2 = String.valueOf(stringExtra2);
                    if (valueOf2.length() != 0) {
                        action.concat(valueOf2);
                    } else {
                        valueOf2 = new String(action);
                    }
                }
                action = null;
                if (stringExtra2.startsWith("|")) {
                    String[] split = stringExtra2.split("\\|");
                    if (!"ID".equals(split[1])) {
                        String str = "Unexpected structured response ";
                        valueOf = String.valueOf(stringExtra2);
                        if (valueOf.length() != 0) {
                            str.concat(valueOf);
                        } else {
                            valueOf = new String(str);
                        }
                    }
                    if (split.length > 2) {
                        action = split[2];
                        stringExtra2 = split[3];
                        if (stringExtra2.startsWith(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D)) {
                            stringExtra2 = stringExtra2.substring(1);
                        }
                    } else {
                        stringExtra2 = "UNKNOWN";
                    }
                    intent.putExtra("error", stringExtra2);
                }
                if (action == null) {
                    synchronized (getClass()) {
                        try {
                            for (String action2 : this.zzcu.keySet()) {
                                Object obj = this.zzcu.get(action2);
                                this.zzcu.put(action2, stringExtra2);
                                zzd(obj, stringExtra2);
                            }
                        } finally {
                            AppMethodBeat.m2505o(57541);
                        }
                    }
                    return;
                }
                zzd(action2, stringExtra2);
                AppMethodBeat.m2505o(57541);
                return;
            }
            Matcher matcher = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)").matcher(stringExtra);
            if (matcher.matches()) {
                action2 = matcher.group(1);
                valueOf = matcher.group(2);
                Object extras = intent.getExtras();
                extras.putString("registration_id", valueOf);
                zzd(action2, extras);
                AppMethodBeat.m2505o(57541);
                return;
            }
            if (Log.isLoggable("InstanceID", 3)) {
                valueOf = "Unexpected response string: ";
                action2 = String.valueOf(stringExtra);
                if (action2.length() != 0) {
                    valueOf.concat(action2);
                    AppMethodBeat.m2505o(57541);
                    return;
                }
                action2 = new String(valueOf);
            }
            AppMethodBeat.m2505o(57541);
            return;
        }
        if (Log.isLoggable("InstanceID", 3)) {
            action2 = "Unexpected response ";
            valueOf = String.valueOf(intent.getAction());
            if (valueOf.length() != 0) {
                action2.concat(valueOf);
                AppMethodBeat.m2505o(57541);
                return;
            }
            valueOf = new String(action2);
        }
        AppMethodBeat.m2505o(57541);
    }
}
