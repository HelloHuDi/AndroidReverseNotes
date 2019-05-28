package com.tencent.p177mm.pluginsdk.p597ui.applet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.hardcoder.C1625i;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p187al.C37458c;
import com.tencent.p177mm.p190at.C41764q;
import com.tencent.p177mm.p190at.p191a.p1527d.C37477b;
import com.tencent.p177mm.p190at.p191a.p192b.C36693e;
import com.tencent.p177mm.p190at.p191a.p193c.C37474b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* renamed from: com.tencent.mm.pluginsdk.ui.applet.f */
public final class C35838f implements C37474b {
    private final byte[] vkf;

    public C35838f() {
        AppMethodBeat.m2504i(11689);
        C1720g.m3534RN().mo5159QU();
        StringBuilder stringBuilder = new StringBuilder();
        C1720g.m3534RN();
        this.vkf = C1178g.m2592y(stringBuilder.append(C1668a.m3384QG()).append("mmbiz").toString().getBytes());
        AppMethodBeat.m2505o(11689);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0085 A:{Catch:{ Exception -> 0x0106 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: sE */
    public final C37477b mo33454sE(String str) {
        AppMethodBeat.m2504i(11690);
        C4990ab.m7411d("MicroMsg.ChattingBizImgDownloader", "get image data from url:%s", str);
        C37477b c37477b;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setReadTimeout(C1625i.sHCENCODEVIDEOTIMEOUT);
            if (C41764q.m73704sz(str)) {
                httpURLConnection.setRequestProperty("Referer", C41764q.m73700lH(C7243d.vxo));
            }
            if (httpURLConnection.getResponseCode() < 300) {
                Object obj;
                if (str == null || !(str.startsWith("http://mmbiz.qpic.cn") || str.startsWith("http://mmbiz.qlogo.cn") || str.startsWith("https://mmbiz.qpic.cn") || str.startsWith("https://mmbiz.qlogo.cn"))) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj == null || C37458c.m63163b(httpURLConnection) == 0) {
                    InputStream inputStream = httpURLConnection.getInputStream();
                    c37477b = new C37477b(C36693e.m60878y(inputStream), httpURLConnection.getContentType(), (byte) 0);
                    if (c37477b != null) {
                        boolean z;
                        long currentTimeMillis2 = System.currentTimeMillis();
                        if (C41764q.ahs() && !C5046bo.isNullOrNil(c37477b.bqF) && C41764q.m73704sz(str) && c37477b.bqF.equals("image/webp")) {
                            z = true;
                        } else {
                            z = false;
                        }
                        C4990ab.m7411d("MicroMsg.ChattingBizImgDownloader", "getImageData, isDownloadWebp: %b", Boolean.valueOf(z));
                        long j = currentTimeMillis2 - currentTimeMillis;
                        C4990ab.m7411d("MicroMsg.ChattingBizImgDownloader", "download used %d ms", Long.valueOf(j));
                        C7060h.pYm.mo8378a(86, 4, j, false);
                        if (z) {
                            C7060h.pYm.mo8378a(86, 17, j, false);
                        }
                    }
                    AppMethodBeat.m2505o(11690);
                    return c37477b;
                }
            }
            httpURLConnection.disconnect();
            C4990ab.m7420w("MicroMsg.ChattingBizImgDownloader.HttpClientFactory", "httpURLConnectionGet 300");
            c37477b = null;
            if (c37477b != null) {
            }
            AppMethodBeat.m2505o(11690);
            return c37477b;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.ChattingBizImgDownloader", "get image data failed.:%s", e.toString());
            c37477b = new C37477b(null, null, (byte) 0);
            AppMethodBeat.m2505o(11690);
            return c37477b;
        }
    }
}
