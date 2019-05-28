package com.google.firebase.analytics.connector;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class b implements a {
    private static volatile a buL;
    private final AppMeasurement buK;
    @VisibleForTesting
    final Map<String, Object> buM = new ConcurrentHashMap();

    private b(AppMeasurement appMeasurement) {
        AppMethodBeat.i(67871);
        Preconditions.checkNotNull(appMeasurement);
        this.buK = appMeasurement;
        AppMethodBeat.o(67871);
    }

    @KeepForSdk
    public static a an(Context context) {
        AppMethodBeat.i(67872);
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (buL == null) {
            synchronized (a.class) {
                try {
                    if (buL == null) {
                        buL = new b(AppMeasurement.getInstance(context));
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(67872);
                    }
                }
            }
        }
        a aVar = buL;
        AppMethodBeat.o(67872);
        return aVar;
    }

    @KeepForSdk
    public final void logEvent(String str, String str2, Bundle bundle) {
        AppMethodBeat.i(67873);
        if (!com.google.firebase.analytics.connector.internal.b.aV(str)) {
            String str3 = "Origin not allowed : ";
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                str3.concat(valueOf);
                AppMethodBeat.o(67873);
                return;
            }
            valueOf = new String(str3);
            AppMethodBeat.o(67873);
        } else if (!com.google.firebase.analytics.connector.internal.b.e(str2, bundle)) {
            AppMethodBeat.o(67873);
        } else if (com.google.firebase.analytics.connector.internal.b.a(str, str2, bundle)) {
            this.buK.logEventInternal(str, str2, bundle);
            AppMethodBeat.o(67873);
        } else {
            AppMethodBeat.o(67873);
        }
    }

    @KeepForSdk
    public final void setUserProperty(String str, String str2, Object obj) {
        AppMethodBeat.i(67874);
        String str3;
        String valueOf;
        if (!com.google.firebase.analytics.connector.internal.b.aV(str)) {
            str3 = "Origin not allowed : ";
            valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                str3.concat(valueOf);
                AppMethodBeat.o(67874);
                return;
            }
            valueOf = new String(str3);
            AppMethodBeat.o(67874);
        } else if (!com.google.firebase.analytics.connector.internal.b.aW(str2)) {
            str3 = "User Property not allowed : ";
            valueOf = String.valueOf(str2);
            if (valueOf.length() != 0) {
                str3.concat(valueOf);
                AppMethodBeat.o(67874);
                return;
            }
            valueOf = new String(str3);
            AppMethodBeat.o(67874);
        } else if ((!str2.equals("_ce1") && !str2.equals("_ce2")) || str.equals(AppMeasurement.FCM_ORIGIN) || str.equals("frc")) {
            this.buK.setUserPropertyInternal(str, str2, obj);
            AppMethodBeat.o(67874);
        } else {
            str3 = "User Property not allowed for this origin: ";
            valueOf = String.valueOf(str2);
            if (valueOf.length() != 0) {
                str3.concat(valueOf);
                AppMethodBeat.o(67874);
                return;
            }
            valueOf = new String(str3);
            AppMethodBeat.o(67874);
        }
    }
}
