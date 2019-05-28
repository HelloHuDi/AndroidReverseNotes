package org.p1128b.p1132d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.p1128b.p1130b.C36641b;
import org.p1128b.p1134g.C41175e;

/* renamed from: org.b.d.g */
public final class C41172g {
    private String BYW;
    private InputStream azv;
    public int code;
    private Map<String, String> headers;

    C41172g(HttpURLConnection httpURLConnection) {
        AppMethodBeat.m2504i(77242);
        try {
            Object obj;
            InputStream inputStream;
            httpURLConnection.connect();
            this.code = httpURLConnection.getResponseCode();
            this.headers = C41172g.m71630i(httpURLConnection);
            if (this.code < 200 || this.code >= 400) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                inputStream = httpURLConnection.getInputStream();
            } else {
                inputStream = httpURLConnection.getErrorStream();
            }
            this.azv = inputStream;
            AppMethodBeat.m2505o(77242);
        } catch (UnknownHostException e) {
            C36641b c36641b = new C36641b("The IP address of a host could not be determined.", e);
            AppMethodBeat.m2505o(77242);
            throw c36641b;
        }
    }

    /* renamed from: i */
    private static Map<String, String> m71630i(HttpURLConnection httpURLConnection) {
        AppMethodBeat.m2504i(77243);
        HashMap hashMap = new HashMap();
        for (String str : httpURLConnection.getHeaderFields().keySet()) {
            hashMap.put(str, (String) ((List) httpURLConnection.getHeaderFields().get(str)).get(0));
        }
        AppMethodBeat.m2505o(77243);
        return hashMap;
    }

    public final String getBody() {
        AppMethodBeat.m2504i(77244);
        String str;
        if (this.BYW != null) {
            str = this.BYW;
            AppMethodBeat.m2505o(77244);
            return str;
        }
        this.BYW = C41175e.m71631T(this.azv);
        str = this.BYW;
        AppMethodBeat.m2505o(77244);
        return str;
    }
}
