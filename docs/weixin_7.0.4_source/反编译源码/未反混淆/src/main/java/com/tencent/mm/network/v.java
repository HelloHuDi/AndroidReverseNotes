package com.tencent.mm.network;

import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public final class v {
    public HttpsURLConnection gdG;

    public v(String str) {
        this(new URL(str));
        AppMethodBeat.i(58635);
        AppMethodBeat.o(58635);
    }

    private v(URL url) {
        AppMethodBeat.i(58636);
        this.gdG = null;
        try {
            this.gdG = (HttpsURLConnection) url.openConnection();
            AppMethodBeat.o(58636);
        } catch (MalformedURLException e) {
            ab.e("MicroMsg.MMHttpsUrlConnection", "MalformedURLException : %s", e.getMessage());
            ab.e("MicroMsg.MMHttpsUrlConnection", "exception:%s", bo.l(e));
            AppMethodBeat.o(58636);
        } catch (IOException e2) {
            ab.e("MicroMsg.MMHttpsUrlConnection", "IOException : %s", e2.getMessage());
            ab.e("MicroMsg.MMHttpsUrlConnection", "exception:%s", bo.l(e2));
            AppMethodBeat.o(58636);
        } catch (Exception e3) {
            ab.e("MicroMsg.MMHttpsUrlConnection", "Exception :" + e3.getMessage());
            ab.e("MicroMsg.MMHttpsUrlConnection", "exception:%s", bo.l(e3));
            AppMethodBeat.o(58636);
        }
    }

    public final void amZ() {
        AppMethodBeat.i(58637);
        this.gdG.setConnectTimeout(AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS);
        AppMethodBeat.o(58637);
    }

    public final void ana() {
        AppMethodBeat.i(58638);
        this.gdG.setReadTimeout(AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS);
        AppMethodBeat.o(58638);
    }

    public final void vc(String str) {
        AppMethodBeat.i(58639);
        this.gdG.setRequestProperty("Referer", str);
        AppMethodBeat.o(58639);
    }

    public final void anb() {
        AppMethodBeat.i(58640);
        this.gdG.setUseCaches(true);
        AppMethodBeat.o(58640);
    }
}
