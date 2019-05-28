package com.tencent.smtt.sdk;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Set;

public class GeolocationPermissions {
    private static GeolocationPermissions a;

    private static synchronized GeolocationPermissions a() {
        GeolocationPermissions geolocationPermissions;
        synchronized (GeolocationPermissions.class) {
            AppMethodBeat.i(63903);
            if (a == null) {
                a = new GeolocationPermissions();
            }
            geolocationPermissions = a;
            AppMethodBeat.o(63903);
        }
        return geolocationPermissions;
    }

    public static GeolocationPermissions getInstance() {
        AppMethodBeat.i(63902);
        GeolocationPermissions a = a();
        AppMethodBeat.o(63902);
        return a;
    }

    public void allow(String str) {
        AppMethodBeat.i(63907);
        bv a = bv.a();
        if (a == null || !a.b()) {
            android.webkit.GeolocationPermissions.getInstance().allow(str);
            AppMethodBeat.o(63907);
            return;
        }
        a.c().g(str);
        AppMethodBeat.o(63907);
    }

    public void clear(String str) {
        AppMethodBeat.i(63906);
        bv a = bv.a();
        if (a == null || !a.b()) {
            android.webkit.GeolocationPermissions.getInstance().clear(str);
            AppMethodBeat.o(63906);
            return;
        }
        a.c().f(str);
        AppMethodBeat.o(63906);
    }

    public void clearAll() {
        AppMethodBeat.i(63908);
        bv a = bv.a();
        if (a == null || !a.b()) {
            android.webkit.GeolocationPermissions.getInstance().clearAll();
            AppMethodBeat.o(63908);
            return;
        }
        a.c().o();
        AppMethodBeat.o(63908);
    }

    public void getAllowed(String str, ValueCallback<Boolean> valueCallback) {
        AppMethodBeat.i(63905);
        bv a = bv.a();
        if (a == null || !a.b()) {
            android.webkit.GeolocationPermissions.getInstance().getAllowed(str, valueCallback);
            AppMethodBeat.o(63905);
            return;
        }
        a.c().c(str, valueCallback);
        AppMethodBeat.o(63905);
    }

    public void getOrigins(ValueCallback<Set<String>> valueCallback) {
        AppMethodBeat.i(63904);
        bv a = bv.a();
        if (a == null || !a.b()) {
            android.webkit.GeolocationPermissions.getInstance().getOrigins(valueCallback);
            AppMethodBeat.o(63904);
            return;
        }
        a.c().b((ValueCallback) valueCallback);
        AppMethodBeat.o(63904);
    }
}
