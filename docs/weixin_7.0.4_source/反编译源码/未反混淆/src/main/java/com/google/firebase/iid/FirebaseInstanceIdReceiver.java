package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Base64;
import com.google.android.gms.common.util.PlatformVersion;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.annotation.concurrent.GuardedBy;

public final class FirebaseInstanceIdReceiver extends WakefulBroadcastReceiver {
    @GuardedBy("FirebaseInstanceIdReceiver.class")
    private static y bvA;
    private static boolean bvy = false;
    @GuardedBy("FirebaseInstanceIdReceiver.class")
    private static y bvz;

    private final void a(Context context, Intent intent, String str) {
        String str2 = null;
        int i = 0;
        int i2 = -1;
        AppMethodBeat.i(108708);
        intent.setComponent(null);
        intent.setPackage(context.getPackageName());
        if (VERSION.SDK_INT <= 18) {
            intent.removeCategory(context.getPackageName());
        }
        String stringExtra = intent.getStringExtra("gcm.rawData64");
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra("gcm.rawData64");
        }
        if ("google.com/iid".equals(intent.getStringExtra("from")) || "com.google.firebase.INSTANCE_ID_EVENT".equals(str)) {
            str2 = "com.google.firebase.INSTANCE_ID_EVENT";
        } else if ("com.google.android.c2dm.intent.RECEIVE".equals(str) || "com.google.firebase.MESSAGING_EVENT".equals(str)) {
            str2 = "com.google.firebase.MESSAGING_EVENT";
        }
        if (str2 != null) {
            if (PlatformVersion.isAtLeastO() && context.getApplicationInfo().targetSdkVersion >= 26) {
                i = 1;
            }
            if (i != 0) {
                if (isOrderedBroadcast()) {
                    setResultCode(-1);
                }
                j(context, str2).a(intent, goAsync());
            } else {
                i2 = o.uS().a(context, str2, intent);
            }
        }
        if (isOrderedBroadcast()) {
            setResultCode(i2);
        }
        AppMethodBeat.o(108708);
    }

    private static synchronized y j(Context context, String str) {
        y yVar;
        synchronized (FirebaseInstanceIdReceiver.class) {
            AppMethodBeat.i(108709);
            if ("com.google.firebase.MESSAGING_EVENT".equals(str)) {
                if (bvA == null) {
                    bvA = new y(context, str);
                }
                yVar = bvA;
                AppMethodBeat.o(108709);
            } else {
                if (bvz == null) {
                    bvz = new y(context, str);
                }
                yVar = bvz;
                AppMethodBeat.o(108709);
            }
        }
        return yVar;
    }

    public final void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(108707);
        if (intent == null) {
            AppMethodBeat.o(108707);
            return;
        }
        Parcelable parcelableExtra = intent.getParcelableExtra("wrapped_intent");
        if (parcelableExtra instanceof Intent) {
            a(context, (Intent) parcelableExtra, intent.getAction());
            AppMethodBeat.o(108707);
            return;
        }
        a(context, intent, intent.getAction());
        AppMethodBeat.o(108707);
    }
}
