package com.tencent.p177mm.plugin.appbrand.page;

import android.net.http.SslCertificate;
import android.os.Build.VERSION;
import android.webkit.URLUtil;
import android.webkit.WebResourceResponse;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.luggage.p147g.C37399a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appcache.C33082aw;
import com.tencent.p177mm.plugin.appbrand.p321l.C19538j;
import com.tencent.p177mm.plugin.appbrand.p321l.C19550n;
import com.tencent.p177mm.plugin.appbrand.p321l.C38414a;
import com.tencent.p177mm.plugin.appbrand.p328r.C19681j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.ByteArrayInputStream;
import java.nio.ByteBuffer;
import java.security.cert.X509Certificate;

/* renamed from: com.tencent.mm.plugin.appbrand.page.ab */
public final class C38458ab {
    C44709u hTn;
    private C19550n iur;

    public C38458ab(C44709u c44709u) {
        this.hTn = c44709u;
    }

    /* renamed from: a */
    public final boolean mo61147a(SslCertificate sslCertificate) {
        AppMethodBeat.m2504i(87312);
        if (this.hTn.getRuntime() == null) {
            AppMethodBeat.m2505o(87312);
            return false;
        }
        boolean z;
        if (this.iur == null) {
            this.iur = C19538j.m30271b((C38414a) this.hTn.getRuntime().mo14986aa(C38414a.class));
        }
        C4990ab.m7410d("AppBrandWebViewClient", "subjectDN: ".concat(String.valueOf(sslCertificate.getIssuedTo().getDName())));
        try {
            sslCertificate.getClass().getDeclaredField("mX509Certificate").setAccessible(true);
            try {
                this.iur.checkServerTrusted(new X509Certificate[]{(X509Certificate) r0.get(sslCertificate)}, MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE);
                z = true;
            } catch (Exception e) {
                C4990ab.m7412e("AppBrandWebViewClient", "Certificate check failed: ".concat(String.valueOf(e)));
                z = false;
            }
        } catch (Exception e2) {
            C4990ab.m7413e("AppBrandWebViewClient", "Certificate check failed: ", e2);
            z = false;
        }
        AppMethodBeat.m2505o(87312);
        return z;
    }

    /* renamed from: Dj */
    public final WebResourceResponse mo61146Dj(String str) {
        WebResourceResponse webResourceResponse = null;
        AppMethodBeat.m2504i(87313);
        if (this.hTn.isRunning()) {
            if (str.startsWith(this.hTn.aJA())) {
                webResourceResponse = C33082aw.m54072c(this.hTn.getRuntime(), str.replaceFirst(this.hTn.aJA(), ""));
                if (webResourceResponse == null) {
                    C4990ab.m7413e("AppBrandWebViewClient", "getAppResourceResponse %s not found", str);
                    webResourceResponse = new WebResourceResponse("image/*", ProtocolPackage.ServerEncoding, new ByteArrayInputStream(new byte[0]));
                    if (VERSION.SDK_INT >= 21) {
                        webResourceResponse.setStatusCodeAndReasonPhrase(404, "NotFound");
                    }
                }
            } else if (URLUtil.isAboutUrl(str) || URLUtil.isHttpUrl(str) || URLUtil.isHttpsUrl(str)) {
                AppMethodBeat.m2505o(87313);
            } else {
                C19681j c19681j = new C19681j();
                this.hTn.getRuntime().asE().mo5843b(str, c19681j);
                if (c19681j.value != null) {
                    webResourceResponse = new WebResourceResponse("", "", new C37399a((ByteBuffer) c19681j.value));
                }
            }
            C4990ab.m7417i("AppBrandWebViewClient", "tryInterceptWebViewRequest, reqURL = %s", str);
            AppMethodBeat.m2505o(87313);
        } else {
            AppMethodBeat.m2505o(87313);
        }
        return webResourceResponse;
    }
}
