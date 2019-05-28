package com.tencent.tencentmap.mapsdk.maps.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public final class ct implements HostnameVerifier {
    private String a;

    public ct(String str) {
        this.a = str;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(98667);
        if (TextUtils.isEmpty(this.a) || !(obj instanceof ct)) {
            AppMethodBeat.o(98667);
            return false;
        }
        String str = ((ct) obj).a;
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(98667);
            return false;
        }
        boolean equals = this.a.equals(str);
        AppMethodBeat.o(98667);
        return equals;
    }

    public final boolean verify(String str, SSLSession sSLSession) {
        AppMethodBeat.i(98666);
        boolean verify = HttpsURLConnection.getDefaultHostnameVerifier().verify(this.a, sSLSession);
        AppMethodBeat.o(98666);
        return verify;
    }
}
