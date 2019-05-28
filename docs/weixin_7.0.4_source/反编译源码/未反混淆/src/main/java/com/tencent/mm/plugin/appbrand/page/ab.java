package com.tencent.mm.plugin.appbrand.page;

import android.net.http.SslCertificate;
import android.os.Build.VERSION;
import android.webkit.URLUtil;
import android.webkit.WebResourceResponse;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.aw;
import com.tencent.mm.plugin.appbrand.l.a;
import com.tencent.mm.plugin.appbrand.l.j;
import com.tencent.mm.plugin.appbrand.l.n;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.ByteArrayInputStream;
import java.nio.ByteBuffer;
import java.security.cert.X509Certificate;

public final class ab {
    u hTn;
    private n iur;

    public ab(u uVar) {
        this.hTn = uVar;
    }

    public final boolean a(SslCertificate sslCertificate) {
        AppMethodBeat.i(87312);
        if (this.hTn.getRuntime() == null) {
            AppMethodBeat.o(87312);
            return false;
        }
        boolean z;
        if (this.iur == null) {
            this.iur = j.b((a) this.hTn.getRuntime().aa(a.class));
        }
        com.tencent.mm.sdk.platformtools.ab.d("AppBrandWebViewClient", "subjectDN: ".concat(String.valueOf(sslCertificate.getIssuedTo().getDName())));
        try {
            sslCertificate.getClass().getDeclaredField("mX509Certificate").setAccessible(true);
            try {
                this.iur.checkServerTrusted(new X509Certificate[]{(X509Certificate) r0.get(sslCertificate)}, MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE);
                z = true;
            } catch (Exception e) {
                com.tencent.mm.sdk.platformtools.ab.e("AppBrandWebViewClient", "Certificate check failed: ".concat(String.valueOf(e)));
                z = false;
            }
        } catch (Exception e2) {
            com.tencent.mm.sdk.platformtools.ab.e("AppBrandWebViewClient", "Certificate check failed: ", e2);
            z = false;
        }
        AppMethodBeat.o(87312);
        return z;
    }

    public final WebResourceResponse Dj(String str) {
        WebResourceResponse webResourceResponse = null;
        AppMethodBeat.i(87313);
        if (this.hTn.isRunning()) {
            if (str.startsWith(this.hTn.aJA())) {
                webResourceResponse = aw.c(this.hTn.getRuntime(), str.replaceFirst(this.hTn.aJA(), ""));
                if (webResourceResponse == null) {
                    com.tencent.mm.sdk.platformtools.ab.e("AppBrandWebViewClient", "getAppResourceResponse %s not found", str);
                    webResourceResponse = new WebResourceResponse("image/*", ProtocolPackage.ServerEncoding, new ByteArrayInputStream(new byte[0]));
                    if (VERSION.SDK_INT >= 21) {
                        webResourceResponse.setStatusCodeAndReasonPhrase(404, "NotFound");
                    }
                }
            } else if (URLUtil.isAboutUrl(str) || URLUtil.isHttpUrl(str) || URLUtil.isHttpsUrl(str)) {
                AppMethodBeat.o(87313);
            } else {
                com.tencent.mm.plugin.appbrand.r.j jVar = new com.tencent.mm.plugin.appbrand.r.j();
                this.hTn.getRuntime().asE().b(str, jVar);
                if (jVar.value != null) {
                    webResourceResponse = new WebResourceResponse("", "", new com.tencent.luggage.g.a((ByteBuffer) jVar.value));
                }
            }
            com.tencent.mm.sdk.platformtools.ab.i("AppBrandWebViewClient", "tryInterceptWebViewRequest, reqURL = %s", str);
            AppMethodBeat.o(87313);
        } else {
            AppMethodBeat.o(87313);
        }
        return webResourceResponse;
    }
}
