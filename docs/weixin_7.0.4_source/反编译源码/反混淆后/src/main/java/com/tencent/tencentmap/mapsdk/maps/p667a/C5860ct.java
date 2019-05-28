package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ct */
public final class C5860ct implements HostnameVerifier {
    /* renamed from: a */
    private String f1536a;

    public C5860ct(String str) {
        this.f1536a = str;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(98667);
        if (TextUtils.isEmpty(this.f1536a) || !(obj instanceof C5860ct)) {
            AppMethodBeat.m2505o(98667);
            return false;
        }
        String str = ((C5860ct) obj).f1536a;
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(98667);
            return false;
        }
        boolean equals = this.f1536a.equals(str);
        AppMethodBeat.m2505o(98667);
        return equals;
    }

    public final boolean verify(String str, SSLSession sSLSession) {
        AppMethodBeat.m2504i(98666);
        boolean verify = HttpsURLConnection.getDefaultHostnameVerifier().verify(this.f1536a, sSLSession);
        AppMethodBeat.m2505o(98666);
        return verify;
    }
}
