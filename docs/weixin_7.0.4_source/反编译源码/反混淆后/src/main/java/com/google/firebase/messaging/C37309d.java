package com.google.firebase.messaging;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.C41642a;
import com.google.firebase.analytics.connector.C41643a;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.firebase.messaging.d */
final class C37309d {
    /* renamed from: a */
    static void m62709a(String str, Intent intent) {
        AppMethodBeat.m2504i(77231);
        Bundle bundle = new Bundle();
        String stringExtra = intent.getStringExtra("google.c.a.c_id");
        if (stringExtra != null) {
            bundle.putString("_nmid", stringExtra);
        }
        stringExtra = intent.getStringExtra("google.c.a.c_l");
        if (stringExtra != null) {
            bundle.putString("_nmn", stringExtra);
        }
        stringExtra = intent.getStringExtra("google.c.a.m_l");
        if (!TextUtils.isEmpty(stringExtra)) {
            bundle.putString("label", stringExtra);
        }
        stringExtra = intent.getStringExtra("from");
        if (stringExtra == null || !stringExtra.startsWith("/topics/")) {
            stringExtra = null;
        }
        if (stringExtra != null) {
            bundle.putString("_nt", stringExtra);
        }
        try {
            bundle.putInt("_nmt", Integer.parseInt(intent.getStringExtra("google.c.a.ts")));
        } catch (NumberFormatException e) {
        }
        if (intent.hasExtra("google.c.a.udt")) {
            try {
                bundle.putInt("_ndt", Integer.parseInt(intent.getStringExtra("google.c.a.udt")));
            } catch (NumberFormatException e2) {
            }
        }
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            stringExtra = String.valueOf(bundle);
            new StringBuilder((String.valueOf(str).length() + 22) + String.valueOf(stringExtra).length()).append("Sending event=").append(str).append(" params=").append(stringExtra);
        }
        C41643a c41643a = (C41643a) C41642a.m73006ut().mo67041x(C41643a.class);
        if (c41643a != null) {
            c41643a.logEvent(AppMeasurement.FCM_ORIGIN, str, bundle);
            AppMethodBeat.m2505o(77231);
            return;
        }
        AppMethodBeat.m2505o(77231);
    }
}
