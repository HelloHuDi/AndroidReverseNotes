package com.google.firebase.analytics.connector;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.connector.internal.C25580b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.google.firebase.analytics.connector.b */
public final class C44650b implements C41643a {
    private static volatile C41643a buL;
    private final AppMeasurement buK;
    @VisibleForTesting
    final Map<String, Object> buM = new ConcurrentHashMap();

    private C44650b(AppMeasurement appMeasurement) {
        AppMethodBeat.m2504i(67871);
        Preconditions.checkNotNull(appMeasurement);
        this.buK = appMeasurement;
        AppMethodBeat.m2505o(67871);
    }

    @KeepForSdk
    /* renamed from: an */
    public static C41643a m81204an(Context context) {
        AppMethodBeat.m2504i(67872);
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (buL == null) {
            synchronized (C41643a.class) {
                try {
                    if (buL == null) {
                        buL = new C44650b(AppMeasurement.getInstance(context));
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(67872);
                    }
                }
            }
        }
        C41643a c41643a = buL;
        AppMethodBeat.m2505o(67872);
        return c41643a;
    }

    @KeepForSdk
    public final void logEvent(String str, String str2, Bundle bundle) {
        AppMethodBeat.m2504i(67873);
        if (!C25580b.m40560aV(str)) {
            String str3 = "Origin not allowed : ";
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                str3.concat(valueOf);
                AppMethodBeat.m2505o(67873);
                return;
            }
            valueOf = new String(str3);
            AppMethodBeat.m2505o(67873);
        } else if (!C25580b.m40562e(str2, bundle)) {
            AppMethodBeat.m2505o(67873);
        } else if (C25580b.m40559a(str, str2, bundle)) {
            this.buK.logEventInternal(str, str2, bundle);
            AppMethodBeat.m2505o(67873);
        } else {
            AppMethodBeat.m2505o(67873);
        }
    }

    @KeepForSdk
    public final void setUserProperty(String str, String str2, Object obj) {
        AppMethodBeat.m2504i(67874);
        String str3;
        String valueOf;
        if (!C25580b.m40560aV(str)) {
            str3 = "Origin not allowed : ";
            valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                str3.concat(valueOf);
                AppMethodBeat.m2505o(67874);
                return;
            }
            valueOf = new String(str3);
            AppMethodBeat.m2505o(67874);
        } else if (!C25580b.m40561aW(str2)) {
            str3 = "User Property not allowed : ";
            valueOf = String.valueOf(str2);
            if (valueOf.length() != 0) {
                str3.concat(valueOf);
                AppMethodBeat.m2505o(67874);
                return;
            }
            valueOf = new String(str3);
            AppMethodBeat.m2505o(67874);
        } else if ((!str2.equals("_ce1") && !str2.equals("_ce2")) || str.equals(AppMeasurement.FCM_ORIGIN) || str.equals("frc")) {
            this.buK.setUserPropertyInternal(str, str2, obj);
            AppMethodBeat.m2505o(67874);
        } else {
            str3 = "User Property not allowed for this origin: ";
            valueOf = String.valueOf(str2);
            if (valueOf.length() != 0) {
                str3.concat(valueOf);
                AppMethodBeat.m2505o(67874);
                return;
            }
            valueOf = new String(str3);
            AppMethodBeat.m2505o(67874);
        }
    }
}
