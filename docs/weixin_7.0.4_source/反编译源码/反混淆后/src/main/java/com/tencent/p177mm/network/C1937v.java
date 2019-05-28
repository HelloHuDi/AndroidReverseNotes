package com.tencent.p177mm.network;

import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

/* renamed from: com.tencent.mm.network.v */
public final class C1937v {
    public HttpsURLConnection gdG;

    public C1937v(String str) {
        this(new URL(str));
        AppMethodBeat.m2504i(58635);
        AppMethodBeat.m2505o(58635);
    }

    private C1937v(URL url) {
        AppMethodBeat.m2504i(58636);
        this.gdG = null;
        try {
            this.gdG = (HttpsURLConnection) url.openConnection();
            AppMethodBeat.m2505o(58636);
        } catch (MalformedURLException e) {
            C4990ab.m7413e("MicroMsg.MMHttpsUrlConnection", "MalformedURLException : %s", e.getMessage());
            C4990ab.m7413e("MicroMsg.MMHttpsUrlConnection", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(58636);
        } catch (IOException e2) {
            C4990ab.m7413e("MicroMsg.MMHttpsUrlConnection", "IOException : %s", e2.getMessage());
            C4990ab.m7413e("MicroMsg.MMHttpsUrlConnection", "exception:%s", C5046bo.m7574l(e2));
            AppMethodBeat.m2505o(58636);
        } catch (Exception e3) {
            C4990ab.m7412e("MicroMsg.MMHttpsUrlConnection", "Exception :" + e3.getMessage());
            C4990ab.m7413e("MicroMsg.MMHttpsUrlConnection", "exception:%s", C5046bo.m7574l(e3));
            AppMethodBeat.m2505o(58636);
        }
    }

    public final void amZ() {
        AppMethodBeat.m2504i(58637);
        this.gdG.setConnectTimeout(AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS);
        AppMethodBeat.m2505o(58637);
    }

    public final void ana() {
        AppMethodBeat.m2504i(58638);
        this.gdG.setReadTimeout(AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS);
        AppMethodBeat.m2505o(58638);
    }

    /* renamed from: vc */
    public final void mo5665vc(String str) {
        AppMethodBeat.m2504i(58639);
        this.gdG.setRequestProperty("Referer", str);
        AppMethodBeat.m2505o(58639);
    }

    public final void anb() {
        AppMethodBeat.m2504i(58640);
        this.gdG.setUseCaches(true);
        AppMethodBeat.m2505o(58640);
    }
}
