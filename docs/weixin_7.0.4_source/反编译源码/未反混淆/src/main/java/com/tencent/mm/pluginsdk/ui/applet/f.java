package com.tencent.mm.pluginsdk.ui.applet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.c;
import com.tencent.mm.at.a.b.e;
import com.tencent.mm.at.a.c.b;
import com.tencent.mm.at.q;
import com.tencent.mm.hardcoder.i;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public final class f implements b {
    private final byte[] vkf;

    public f() {
        AppMethodBeat.i(11689);
        g.RN().QU();
        StringBuilder stringBuilder = new StringBuilder();
        g.RN();
        this.vkf = com.tencent.mm.a.g.y(stringBuilder.append(a.QG()).append("mmbiz").toString().getBytes());
        AppMethodBeat.o(11689);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0085 A:{Catch:{ Exception -> 0x0106 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.at.a.d.b sE(String str) {
        AppMethodBeat.i(11690);
        ab.d("MicroMsg.ChattingBizImgDownloader", "get image data from url:%s", str);
        com.tencent.mm.at.a.d.b bVar;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setReadTimeout(i.sHCENCODEVIDEOTIMEOUT);
            if (q.sz(str)) {
                httpURLConnection.setRequestProperty("Referer", q.lH(d.vxo));
            }
            if (httpURLConnection.getResponseCode() < 300) {
                Object obj;
                if (str == null || !(str.startsWith("http://mmbiz.qpic.cn") || str.startsWith("http://mmbiz.qlogo.cn") || str.startsWith("https://mmbiz.qpic.cn") || str.startsWith("https://mmbiz.qlogo.cn"))) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj == null || c.b(httpURLConnection) == 0) {
                    InputStream inputStream = httpURLConnection.getInputStream();
                    bVar = new com.tencent.mm.at.a.d.b(e.y(inputStream), httpURLConnection.getContentType(), (byte) 0);
                    if (bVar != null) {
                        boolean z;
                        long currentTimeMillis2 = System.currentTimeMillis();
                        if (q.ahs() && !bo.isNullOrNil(bVar.bqF) && q.sz(str) && bVar.bqF.equals("image/webp")) {
                            z = true;
                        } else {
                            z = false;
                        }
                        ab.d("MicroMsg.ChattingBizImgDownloader", "getImageData, isDownloadWebp: %b", Boolean.valueOf(z));
                        long j = currentTimeMillis2 - currentTimeMillis;
                        ab.d("MicroMsg.ChattingBizImgDownloader", "download used %d ms", Long.valueOf(j));
                        h.pYm.a(86, 4, j, false);
                        if (z) {
                            h.pYm.a(86, 17, j, false);
                        }
                    }
                    AppMethodBeat.o(11690);
                    return bVar;
                }
            }
            httpURLConnection.disconnect();
            ab.w("MicroMsg.ChattingBizImgDownloader.HttpClientFactory", "httpURLConnectionGet 300");
            bVar = null;
            if (bVar != null) {
            }
            AppMethodBeat.o(11690);
            return bVar;
        } catch (Exception e) {
            ab.e("MicroMsg.ChattingBizImgDownloader", "get image data failed.:%s", e.toString());
            bVar = new com.tencent.mm.at.a.d.b(null, null, (byte) 0);
            AppMethodBeat.o(11690);
            return bVar;
        }
    }
}
