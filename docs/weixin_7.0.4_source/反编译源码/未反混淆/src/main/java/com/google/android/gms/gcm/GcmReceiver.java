package com.google.android.gms.gcm;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build.VERSION;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.iid.zzk;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public class GcmReceiver extends WakefulBroadcastReceiver {
    private static boolean zzq = false;
    private static zzk zzr;
    private static zzk zzs;

    private final synchronized zzk zzd(Context context, String str) {
        zzk zzk;
        AppMethodBeat.i(69953);
        if ("com.google.android.c2dm.intent.RECEIVE".equals(str)) {
            if (zzs == null) {
                zzs = new zzk(context, str);
            }
            zzk = zzs;
            AppMethodBeat.o(69953);
        } else {
            if (zzr == null) {
                zzr = new zzk(context, str);
            }
            zzk = zzr;
            AppMethodBeat.o(69953);
        }
        return zzk;
    }

    private final void zzd(Context context, Intent intent) {
        AppMethodBeat.i(69954);
        if (isOrderedBroadcast()) {
            setResultCode(500);
        }
        ResolveInfo resolveService = context.getPackageManager().resolveService(intent, 0);
        if (!(resolveService == null || resolveService.serviceInfo == null)) {
            ServiceInfo serviceInfo = resolveService.serviceInfo;
            String str;
            String str2;
            if (!context.getPackageName().equals(serviceInfo.packageName) || serviceInfo.name == null) {
                str = serviceInfo.packageName;
                str2 = serviceInfo.name;
                new StringBuilder((String.valueOf(str).length() + 94) + String.valueOf(str2).length()).append("Error resolving target intent service, skipping classname enforcement. Resolved service was: ").append(str).append("/").append(str2);
            } else {
                Object obj = serviceInfo.name;
                if (obj.startsWith(".")) {
                    str = String.valueOf(context.getPackageName());
                    str2 = String.valueOf(obj);
                    obj = str2.length() != 0 ? str.concat(str2) : new String(str);
                }
                if (Log.isLoggable("GcmReceiver", 3)) {
                    str = "Restricting intent to a specific service: ";
                    String valueOf = String.valueOf(obj);
                    if (valueOf.length() != 0) {
                        str.concat(valueOf);
                    } else {
                        valueOf = new String(str);
                    }
                }
                intent.setClassName(context.getPackageName(), obj);
            }
        }
        try {
            if ((context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0 ? WakefulBroadcastReceiver.startWakefulService(context, intent) : context.startService(intent)) == null) {
                if (isOrderedBroadcast()) {
                    setResultCode(404);
                    AppMethodBeat.o(69954);
                    return;
                }
            } else if (isOrderedBroadcast()) {
                setResultCode(-1);
            }
            AppMethodBeat.o(69954);
        } catch (SecurityException e) {
            if (isOrderedBroadcast()) {
                setResultCode(401);
            }
            AppMethodBeat.o(69954);
        }
    }

    public void onReceive(Context context, Intent intent) {
        int i = 0;
        AppMethodBeat.i(69952);
        Log.isLoggable("GcmReceiver", 3);
        intent.setComponent(null);
        intent.setPackage(context.getPackageName());
        if (VERSION.SDK_INT <= 18) {
            intent.removeCategory(context.getPackageName());
        }
        if ("google.com/iid".equals(intent.getStringExtra("from"))) {
            intent.setAction("com.google.android.gms.iid.InstanceID");
        }
        String stringExtra = intent.getStringExtra("gcm.rawData64");
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra("gcm.rawData64");
        }
        if (PlatformVersion.isAtLeastO() && context.getApplicationInfo().targetSdkVersion >= 26) {
            i = 1;
        }
        if (i != 0) {
            if (isOrderedBroadcast()) {
                setResultCode(-1);
            }
            zzd(context, intent.getAction()).zzd(intent, goAsync());
            AppMethodBeat.o(69952);
            return;
        }
        "com.google.android.c2dm.intent.RECEIVE".equals(intent.getAction());
        zzd(context, intent);
        if (isOrderedBroadcast() && getResultCode() == 0) {
            setResultCode(-1);
        }
        AppMethodBeat.o(69952);
    }
}
