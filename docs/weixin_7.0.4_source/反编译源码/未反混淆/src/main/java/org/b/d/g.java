package org.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.b.b.b;
import org.b.g.e;

public final class g {
    private String BYW;
    private InputStream azv;
    public int code;
    private Map<String, String> headers;

    g(HttpURLConnection httpURLConnection) {
        AppMethodBeat.i(77242);
        try {
            Object obj;
            InputStream inputStream;
            httpURLConnection.connect();
            this.code = httpURLConnection.getResponseCode();
            this.headers = i(httpURLConnection);
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
            AppMethodBeat.o(77242);
        } catch (UnknownHostException e) {
            b bVar = new b("The IP address of a host could not be determined.", e);
            AppMethodBeat.o(77242);
            throw bVar;
        }
    }

    private static Map<String, String> i(HttpURLConnection httpURLConnection) {
        AppMethodBeat.i(77243);
        HashMap hashMap = new HashMap();
        for (String str : httpURLConnection.getHeaderFields().keySet()) {
            hashMap.put(str, (String) ((List) httpURLConnection.getHeaderFields().get(str)).get(0));
        }
        AppMethodBeat.o(77243);
        return hashMap;
    }

    public final String getBody() {
        AppMethodBeat.i(77244);
        String str;
        if (this.BYW != null) {
            str = this.BYW;
            AppMethodBeat.o(77244);
            return str;
        }
        this.BYW = e.T(this.azv);
        str = this.BYW;
        AppMethodBeat.o(77244);
        return str;
    }
}
