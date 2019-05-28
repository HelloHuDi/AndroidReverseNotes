package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.support.p057v4.content.WakefulBroadcastReceiver;
import android.util.Base64;
import com.google.android.gms.common.util.PlatformVersion;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.annotation.concurrent.GuardedBy;

public final class FirebaseInstanceIdReceiver extends WakefulBroadcastReceiver {
    @GuardedBy("FirebaseInstanceIdReceiver.class")
    private static C17711y bvA;
    private static boolean bvy = false;
    @GuardedBy("FirebaseInstanceIdReceiver.class")
    private static C17711y bvz;

    /* renamed from: a */
    private final void m73020a(Context context, Intent intent, String str) {
        String str2 = null;
        int i = 0;
        int i2 = -1;
        AppMethodBeat.m2504i(108708);
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
                m73021j(context, str2).mo32798a(intent, goAsync());
            } else {
                i2 = C25587o.m40589uS().mo43247a(context, str2, intent);
            }
        }
        if (isOrderedBroadcast()) {
            setResultCode(i2);
        }
        AppMethodBeat.m2505o(108708);
    }

    /* renamed from: j */
    private static synchronized C17711y m73021j(Context context, String str) {
        C17711y c17711y;
        synchronized (FirebaseInstanceIdReceiver.class) {
            AppMethodBeat.m2504i(108709);
            if ("com.google.firebase.MESSAGING_EVENT".equals(str)) {
                if (bvA == null) {
                    bvA = new C17711y(context, str);
                }
                c17711y = bvA;
                AppMethodBeat.m2505o(108709);
            } else {
                if (bvz == null) {
                    bvz = new C17711y(context, str);
                }
                c17711y = bvz;
                AppMethodBeat.m2505o(108709);
            }
        }
        return c17711y;
    }

    public final void onReceive(Context context, Intent intent) {
        AppMethodBeat.m2504i(108707);
        if (intent == null) {
            AppMethodBeat.m2505o(108707);
            return;
        }
        Parcelable parcelableExtra = intent.getParcelableExtra("wrapped_intent");
        if (parcelableExtra instanceof Intent) {
            m73020a(context, (Intent) parcelableExtra, intent.getAction());
            AppMethodBeat.m2505o(108707);
            return;
        }
        m73020a(context, intent, intent.getAction());
        AppMethodBeat.m2505o(108707);
    }
}
