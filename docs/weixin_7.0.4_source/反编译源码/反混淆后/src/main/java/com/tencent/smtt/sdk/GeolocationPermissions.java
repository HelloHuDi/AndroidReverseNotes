package com.tencent.smtt.sdk;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Set;

public class GeolocationPermissions {
    /* renamed from: a */
    private static GeolocationPermissions f3014a;

    /* renamed from: a */
    private static synchronized GeolocationPermissions m24492a() {
        GeolocationPermissions geolocationPermissions;
        synchronized (GeolocationPermissions.class) {
            AppMethodBeat.m2504i(63903);
            if (f3014a == null) {
                f3014a = new GeolocationPermissions();
            }
            geolocationPermissions = f3014a;
            AppMethodBeat.m2505o(63903);
        }
        return geolocationPermissions;
    }

    public static GeolocationPermissions getInstance() {
        AppMethodBeat.m2504i(63902);
        GeolocationPermissions a = m24492a();
        AppMethodBeat.m2505o(63902);
        return a;
    }

    public void allow(String str) {
        AppMethodBeat.m2504i(63907);
        C40978bv a = C40978bv.m71073a();
        if (a == null || !a.mo64921b()) {
            android.webkit.GeolocationPermissions.getInstance().allow(str);
            AppMethodBeat.m2505o(63907);
            return;
        }
        a.mo64922c().mo57594g(str);
        AppMethodBeat.m2505o(63907);
    }

    public void clear(String str) {
        AppMethodBeat.m2504i(63906);
        C40978bv a = C40978bv.m71073a();
        if (a == null || !a.mo64921b()) {
            android.webkit.GeolocationPermissions.getInstance().clear(str);
            AppMethodBeat.m2505o(63906);
            return;
        }
        a.mo64922c().mo57590f(str);
        AppMethodBeat.m2505o(63906);
    }

    public void clearAll() {
        AppMethodBeat.m2504i(63908);
        C40978bv a = C40978bv.m71073a();
        if (a == null || !a.mo64921b()) {
            android.webkit.GeolocationPermissions.getInstance().clearAll();
            AppMethodBeat.m2505o(63908);
            return;
        }
        a.mo64922c().mo57611o();
        AppMethodBeat.m2505o(63908);
    }

    public void getAllowed(String str, ValueCallback<Boolean> valueCallback) {
        AppMethodBeat.m2504i(63905);
        C40978bv a = C40978bv.m71073a();
        if (a == null || !a.mo64921b()) {
            android.webkit.GeolocationPermissions.getInstance().getAllowed(str, valueCallback);
            AppMethodBeat.m2505o(63905);
            return;
        }
        a.mo64922c().mo57582c(str, valueCallback);
        AppMethodBeat.m2505o(63905);
    }

    public void getOrigins(ValueCallback<Set<String>> valueCallback) {
        AppMethodBeat.m2504i(63904);
        C40978bv a = C40978bv.m71073a();
        if (a == null || !a.mo64921b()) {
            android.webkit.GeolocationPermissions.getInstance().getOrigins(valueCallback);
            AppMethodBeat.m2505o(63904);
            return;
        }
        a.mo64922c().mo57575b((ValueCallback) valueCallback);
        AppMethodBeat.m2505o(63904);
    }
}
