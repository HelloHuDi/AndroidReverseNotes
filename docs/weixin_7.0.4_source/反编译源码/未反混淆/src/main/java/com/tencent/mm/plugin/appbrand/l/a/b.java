package com.tencent.mm.plugin.appbrand.l.a;

import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.l.j;
import com.tencent.mm.plugin.appbrand.l.o;
import com.tencent.mm.plugin.appbrand.n.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.GZIPInputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;
import org.json.JSONObject;

public final class b implements Runnable {
    public int azs = 60000;
    private String filename;
    public String hvr;
    c hvw;
    private final String ibJ;
    public ArrayList<String> ioN;
    private int ioO = 15;
    public String ioR;
    public SSLContext ios;
    private final a ipB;
    public Map<String, String> ipC;
    public volatile int ipD;
    private long ipE;
    private HttpURLConnection ipF;
    public volatile boolean isRunning = false;
    private long startTime;
    private String uri;

    public b(c cVar, String str, String str2, String str3, a aVar) {
        AppMethodBeat.i(108279);
        this.hvw = cVar;
        this.uri = str;
        this.filename = str2;
        this.ipB = aVar;
        this.startTime = System.currentTimeMillis();
        this.ibJ = str3;
        AppMethodBeat.o(108279);
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:339:0x1134=Splitter:B:339:0x1134, B:364:0x12d9=Splitter:B:364:0x12d9, B:389:0x147e=Splitter:B:389:0x147e, B:314:0x0f8f=Splitter:B:314:0x0f8f} */
    /* JADX WARNING: Removed duplicated region for block: B:300:0x0e97  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0223  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0273 A:{SYNTHETIC, Splitter:B:34:0x0273} */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0278 A:{SYNTHETIC, Splitter:B:37:0x0278} */
    /* JADX WARNING: Removed duplicated region for block: B:325:0x103c  */
    /* JADX WARNING: Removed duplicated region for block: B:317:0x0fce  */
    /* JADX WARNING: Removed duplicated region for block: B:319:0x101e A:{SYNTHETIC, Splitter:B:319:0x101e} */
    /* JADX WARNING: Removed duplicated region for block: B:322:0x1023 A:{SYNTHETIC, Splitter:B:322:0x1023} */
    /* JADX WARNING: Removed duplicated region for block: B:350:0x11e1  */
    /* JADX WARNING: Removed duplicated region for block: B:342:0x1173  */
    /* JADX WARNING: Removed duplicated region for block: B:344:0x11c3 A:{SYNTHETIC, Splitter:B:344:0x11c3} */
    /* JADX WARNING: Removed duplicated region for block: B:347:0x11c8 A:{SYNTHETIC, Splitter:B:347:0x11c8} */
    /* JADX WARNING: Removed duplicated region for block: B:375:0x1386  */
    /* JADX WARNING: Removed duplicated region for block: B:367:0x1318  */
    /* JADX WARNING: Removed duplicated region for block: B:369:0x1368 A:{SYNTHETIC, Splitter:B:369:0x1368} */
    /* JADX WARNING: Removed duplicated region for block: B:372:0x136d A:{SYNTHETIC, Splitter:B:372:0x136d} */
    /* JADX WARNING: Removed duplicated region for block: B:424:0x16a0  */
    /* JADX WARNING: Removed duplicated region for block: B:415:0x1633  */
    /* JADX WARNING: Removed duplicated region for block: B:417:0x1683 A:{SYNTHETIC, Splitter:B:417:0x1683} */
    /* JADX WARNING: Removed duplicated region for block: B:420:0x1688 A:{SYNTHETIC, Splitter:B:420:0x1688} */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x01d9 A:{Splitter:B:40:0x0291, PHI: r18 , ExcHandler: UnsupportedEncodingException (e java.io.UnsupportedEncodingException)} */
    /* JADX WARNING: Removed duplicated region for block: B:312:0x0f8a A:{Splitter:B:14:0x00dc, PHI: r18 , ExcHandler: FileNotFoundException (e java.io.FileNotFoundException)} */
    /* JADX WARNING: Removed duplicated region for block: B:337:0x112f A:{Splitter:B:14:0x00dc, PHI: r18 , ExcHandler: SSLHandshakeException (e javax.net.ssl.SSLHandshakeException)} */
    /* JADX WARNING: Removed duplicated region for block: B:362:0x12d4 A:{Splitter:B:14:0x00dc, PHI: r18 , ExcHandler: SocketTimeoutException (e java.net.SocketTimeoutException)} */
    /* JADX WARNING: Removed duplicated region for block: B:400:0x1539  */
    /* JADX WARNING: Removed duplicated region for block: B:392:0x14cb  */
    /* JADX WARNING: Removed duplicated region for block: B:394:0x151b A:{SYNTHETIC, Splitter:B:394:0x151b} */
    /* JADX WARNING: Removed duplicated region for block: B:397:0x1520 A:{SYNTHETIC, Splitter:B:397:0x1520} */
    /* JADX WARNING: Removed duplicated region for block: B:412:0x162c A:{Splitter:B:14:0x00dc, PHI: r18 , ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:415:0x1633  */
    /* JADX WARNING: Removed duplicated region for block: B:424:0x16a0  */
    /* JADX WARNING: Removed duplicated region for block: B:417:0x1683 A:{SYNTHETIC, Splitter:B:417:0x1683} */
    /* JADX WARNING: Removed duplicated region for block: B:420:0x1688 A:{SYNTHETIC, Splitter:B:420:0x1688} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0223  */
    /* JADX WARNING: Removed duplicated region for block: B:300:0x0e97  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0273 A:{SYNTHETIC, Splitter:B:34:0x0273} */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0278 A:{SYNTHETIC, Splitter:B:37:0x0278} */
    /* JADX WARNING: Removed duplicated region for block: B:317:0x0fce  */
    /* JADX WARNING: Removed duplicated region for block: B:325:0x103c  */
    /* JADX WARNING: Removed duplicated region for block: B:319:0x101e A:{SYNTHETIC, Splitter:B:319:0x101e} */
    /* JADX WARNING: Removed duplicated region for block: B:322:0x1023 A:{SYNTHETIC, Splitter:B:322:0x1023} */
    /* JADX WARNING: Removed duplicated region for block: B:342:0x1173  */
    /* JADX WARNING: Removed duplicated region for block: B:350:0x11e1  */
    /* JADX WARNING: Removed duplicated region for block: B:344:0x11c3 A:{SYNTHETIC, Splitter:B:344:0x11c3} */
    /* JADX WARNING: Removed duplicated region for block: B:347:0x11c8 A:{SYNTHETIC, Splitter:B:347:0x11c8} */
    /* JADX WARNING: Removed duplicated region for block: B:367:0x1318  */
    /* JADX WARNING: Removed duplicated region for block: B:375:0x1386  */
    /* JADX WARNING: Removed duplicated region for block: B:369:0x1368 A:{SYNTHETIC, Splitter:B:369:0x1368} */
    /* JADX WARNING: Removed duplicated region for block: B:372:0x136d A:{SYNTHETIC, Splitter:B:372:0x136d} */
    /* JADX WARNING: Removed duplicated region for block: B:392:0x14cb  */
    /* JADX WARNING: Removed duplicated region for block: B:400:0x1539  */
    /* JADX WARNING: Removed duplicated region for block: B:394:0x151b A:{SYNTHETIC, Splitter:B:394:0x151b} */
    /* JADX WARNING: Removed duplicated region for block: B:397:0x1520 A:{SYNTHETIC, Splitter:B:397:0x1520} */
    /* JADX WARNING: Removed duplicated region for block: B:424:0x16a0  */
    /* JADX WARNING: Removed duplicated region for block: B:415:0x1633  */
    /* JADX WARNING: Removed duplicated region for block: B:417:0x1683 A:{SYNTHETIC, Splitter:B:417:0x1683} */
    /* JADX WARNING: Removed duplicated region for block: B:420:0x1688 A:{SYNTHETIC, Splitter:B:420:0x1688} */
    /* JADX WARNING: Removed duplicated region for block: B:415:0x1633  */
    /* JADX WARNING: Removed duplicated region for block: B:424:0x16a0  */
    /* JADX WARNING: Removed duplicated region for block: B:417:0x1683 A:{SYNTHETIC, Splitter:B:417:0x1683} */
    /* JADX WARNING: Removed duplicated region for block: B:420:0x1688 A:{SYNTHETIC, Splitter:B:420:0x1688} */
    /* JADX WARNING: Removed duplicated region for block: B:300:0x0e97  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0223  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0273 A:{SYNTHETIC, Splitter:B:34:0x0273} */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0278 A:{SYNTHETIC, Splitter:B:37:0x0278} */
    /* JADX WARNING: Removed duplicated region for block: B:325:0x103c  */
    /* JADX WARNING: Removed duplicated region for block: B:317:0x0fce  */
    /* JADX WARNING: Removed duplicated region for block: B:319:0x101e A:{SYNTHETIC, Splitter:B:319:0x101e} */
    /* JADX WARNING: Removed duplicated region for block: B:322:0x1023 A:{SYNTHETIC, Splitter:B:322:0x1023} */
    /* JADX WARNING: Removed duplicated region for block: B:350:0x11e1  */
    /* JADX WARNING: Removed duplicated region for block: B:342:0x1173  */
    /* JADX WARNING: Removed duplicated region for block: B:344:0x11c3 A:{SYNTHETIC, Splitter:B:344:0x11c3} */
    /* JADX WARNING: Removed duplicated region for block: B:347:0x11c8 A:{SYNTHETIC, Splitter:B:347:0x11c8} */
    /* JADX WARNING: Removed duplicated region for block: B:375:0x1386  */
    /* JADX WARNING: Removed duplicated region for block: B:367:0x1318  */
    /* JADX WARNING: Removed duplicated region for block: B:369:0x1368 A:{SYNTHETIC, Splitter:B:369:0x1368} */
    /* JADX WARNING: Removed duplicated region for block: B:372:0x136d A:{SYNTHETIC, Splitter:B:372:0x136d} */
    /* JADX WARNING: Removed duplicated region for block: B:400:0x1539  */
    /* JADX WARNING: Removed duplicated region for block: B:392:0x14cb  */
    /* JADX WARNING: Removed duplicated region for block: B:394:0x151b A:{SYNTHETIC, Splitter:B:394:0x151b} */
    /* JADX WARNING: Removed duplicated region for block: B:397:0x1520 A:{SYNTHETIC, Splitter:B:397:0x1520} */
    /* JADX WARNING: Removed duplicated region for block: B:424:0x16a0  */
    /* JADX WARNING: Removed duplicated region for block: B:415:0x1633  */
    /* JADX WARNING: Removed duplicated region for block: B:417:0x1683 A:{SYNTHETIC, Splitter:B:417:0x1683} */
    /* JADX WARNING: Removed duplicated region for block: B:420:0x1688 A:{SYNTHETIC, Splitter:B:420:0x1688} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0223  */
    /* JADX WARNING: Removed duplicated region for block: B:300:0x0e97  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0273 A:{SYNTHETIC, Splitter:B:34:0x0273} */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0278 A:{SYNTHETIC, Splitter:B:37:0x0278} */
    /* JADX WARNING: Removed duplicated region for block: B:317:0x0fce  */
    /* JADX WARNING: Removed duplicated region for block: B:325:0x103c  */
    /* JADX WARNING: Removed duplicated region for block: B:319:0x101e A:{SYNTHETIC, Splitter:B:319:0x101e} */
    /* JADX WARNING: Removed duplicated region for block: B:322:0x1023 A:{SYNTHETIC, Splitter:B:322:0x1023} */
    /* JADX WARNING: Removed duplicated region for block: B:342:0x1173  */
    /* JADX WARNING: Removed duplicated region for block: B:350:0x11e1  */
    /* JADX WARNING: Removed duplicated region for block: B:344:0x11c3 A:{SYNTHETIC, Splitter:B:344:0x11c3} */
    /* JADX WARNING: Removed duplicated region for block: B:347:0x11c8 A:{SYNTHETIC, Splitter:B:347:0x11c8} */
    /* JADX WARNING: Removed duplicated region for block: B:367:0x1318  */
    /* JADX WARNING: Removed duplicated region for block: B:375:0x1386  */
    /* JADX WARNING: Removed duplicated region for block: B:369:0x1368 A:{SYNTHETIC, Splitter:B:369:0x1368} */
    /* JADX WARNING: Removed duplicated region for block: B:372:0x136d A:{SYNTHETIC, Splitter:B:372:0x136d} */
    /* JADX WARNING: Removed duplicated region for block: B:392:0x14cb  */
    /* JADX WARNING: Removed duplicated region for block: B:400:0x1539  */
    /* JADX WARNING: Removed duplicated region for block: B:394:0x151b A:{SYNTHETIC, Splitter:B:394:0x151b} */
    /* JADX WARNING: Removed duplicated region for block: B:397:0x1520 A:{SYNTHETIC, Splitter:B:397:0x1520} */
    /* JADX WARNING: Removed duplicated region for block: B:415:0x1633  */
    /* JADX WARNING: Removed duplicated region for block: B:424:0x16a0  */
    /* JADX WARNING: Removed duplicated region for block: B:417:0x1683 A:{SYNTHETIC, Splitter:B:417:0x1683} */
    /* JADX WARNING: Removed duplicated region for block: B:420:0x1688 A:{SYNTHETIC, Splitter:B:420:0x1688} */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x01d9 A:{Splitter:B:40:0x0291, PHI: r18 , ExcHandler: UnsupportedEncodingException (e java.io.UnsupportedEncodingException)} */
    /* JADX WARNING: Removed duplicated region for block: B:312:0x0f8a A:{Splitter:B:14:0x00dc, PHI: r18 , ExcHandler: FileNotFoundException (e java.io.FileNotFoundException)} */
    /* JADX WARNING: Removed duplicated region for block: B:337:0x112f A:{Splitter:B:14:0x00dc, PHI: r18 , ExcHandler: SSLHandshakeException (e javax.net.ssl.SSLHandshakeException)} */
    /* JADX WARNING: Removed duplicated region for block: B:362:0x12d4 A:{Splitter:B:14:0x00dc, PHI: r18 , ExcHandler: SocketTimeoutException (e java.net.SocketTimeoutException)} */
    /* JADX WARNING: Removed duplicated region for block: B:412:0x162c A:{Splitter:B:14:0x00dc, PHI: r18 , ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:300:0x0e97  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0223  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0273 A:{SYNTHETIC, Splitter:B:34:0x0273} */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0278 A:{SYNTHETIC, Splitter:B:37:0x0278} */
    /* JADX WARNING: Removed duplicated region for block: B:325:0x103c  */
    /* JADX WARNING: Removed duplicated region for block: B:317:0x0fce  */
    /* JADX WARNING: Removed duplicated region for block: B:319:0x101e A:{SYNTHETIC, Splitter:B:319:0x101e} */
    /* JADX WARNING: Removed duplicated region for block: B:322:0x1023 A:{SYNTHETIC, Splitter:B:322:0x1023} */
    /* JADX WARNING: Removed duplicated region for block: B:350:0x11e1  */
    /* JADX WARNING: Removed duplicated region for block: B:342:0x1173  */
    /* JADX WARNING: Removed duplicated region for block: B:344:0x11c3 A:{SYNTHETIC, Splitter:B:344:0x11c3} */
    /* JADX WARNING: Removed duplicated region for block: B:347:0x11c8 A:{SYNTHETIC, Splitter:B:347:0x11c8} */
    /* JADX WARNING: Removed duplicated region for block: B:375:0x1386  */
    /* JADX WARNING: Removed duplicated region for block: B:367:0x1318  */
    /* JADX WARNING: Removed duplicated region for block: B:369:0x1368 A:{SYNTHETIC, Splitter:B:369:0x1368} */
    /* JADX WARNING: Removed duplicated region for block: B:372:0x136d A:{SYNTHETIC, Splitter:B:372:0x136d} */
    /* JADX WARNING: Removed duplicated region for block: B:400:0x1539  */
    /* JADX WARNING: Removed duplicated region for block: B:392:0x14cb  */
    /* JADX WARNING: Removed duplicated region for block: B:394:0x151b A:{SYNTHETIC, Splitter:B:394:0x151b} */
    /* JADX WARNING: Removed duplicated region for block: B:397:0x1520 A:{SYNTHETIC, Splitter:B:397:0x1520} */
    /* JADX WARNING: Removed duplicated region for block: B:424:0x16a0  */
    /* JADX WARNING: Removed duplicated region for block: B:415:0x1633  */
    /* JADX WARNING: Removed duplicated region for block: B:417:0x1683 A:{SYNTHETIC, Splitter:B:417:0x1683} */
    /* JADX WARNING: Removed duplicated region for block: B:420:0x1688 A:{SYNTHETIC, Splitter:B:420:0x1688} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:27:0x01d9, code skipped:
            r2 = e;
     */
    /* JADX WARNING: Missing block: B:28:0x01da, code skipped:
            r15 = null;
            r16 = null;
            r10 = 0;
            r12 = r18;
            r13 = null;
     */
    /* JADX WARNING: Missing block: B:135:0x074b, code skipped:
            r2 = move-exception;
     */
    /* JADX WARNING: Missing block: B:137:?, code skipped:
            com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", r2, "Exception: getInputStream error", new java.lang.Object[0]);
     */
    /* JADX WARNING: Missing block: B:140:0x0767, code skipped:
            if ("gzip".equals(r27.ipF.getContentEncoding()) != false) goto L_0x0769;
     */
    /* JADX WARNING: Missing block: B:141:0x0769, code skipped:
            r0 = new java.util.zip.GZIPInputStream(r27.ipF.getErrorStream());
     */
    /* JADX WARNING: Missing block: B:149:?, code skipped:
            r22 = r27.ipF.getErrorStream();
     */
    /* JADX WARNING: Missing block: B:247:?, code skipped:
            r0.flush();
     */
    /* JADX WARNING: Missing block: B:248:0x0c24, code skipped:
            r6 = r10;
     */
    /* JADX WARNING: Missing block: B:312:0x0f8a, code skipped:
            r2 = e;
     */
    /* JADX WARNING: Missing block: B:313:0x0f8b, code skipped:
            r10 = 0;
            r12 = r18;
     */
    /* JADX WARNING: Missing block: B:337:0x112f, code skipped:
            r2 = e;
     */
    /* JADX WARNING: Missing block: B:338:0x1130, code skipped:
            r10 = 0;
            r12 = r18;
     */
    /* JADX WARNING: Missing block: B:362:0x12d4, code skipped:
            r2 = e;
     */
    /* JADX WARNING: Missing block: B:363:0x12d5, code skipped:
            r10 = 0;
            r12 = r18;
     */
    /* JADX WARNING: Missing block: B:387:0x1479, code skipped:
            r2 = e;
     */
    /* JADX WARNING: Missing block: B:388:0x147a, code skipped:
            r10 = 0;
            r12 = r18;
     */
    /* JADX WARNING: Missing block: B:412:0x162c, code skipped:
            r2 = th;
     */
    /* JADX WARNING: Missing block: B:413:0x162d, code skipped:
            r10 = 0;
            r12 = r18;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        Throwable th;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        InputStream inputStream;
        int i;
        Object obj;
        AppMethodBeat.i(108280);
        if (!URLUtil.isHttpsUrl(this.uri) && !URLUtil.isHttpUrl(this.uri)) {
            this.ipB.E(this.filename, this.uri, "downloadFile protocol must be http or https");
            AppMethodBeat.o(108280);
        } else if (this.ioN == null || j.c(this.ioN, this.uri)) {
            Object obj2 = null;
            int i2 = 0;
            if (this.isRunning) {
                this.ipE = System.currentTimeMillis();
                InputStream inputStream2 = null;
                FileOutputStream fileOutputStream3 = null;
                this.ipB.cH(this.filename, this.uri);
                InputStream inputStream3;
                try {
                    String ako;
                    int i3;
                    ((a) e.C(a.class)).f(437, 0, 1);
                    URL url = new URL(this.uri);
                    ab.i("MicroMsg.AppBrandDownloadWorker", "url is %s ,filename is %s , start download", this.uri, this.filename);
                    this.ipF = (HttpURLConnection) url.openConnection();
                    if ((this.ipF instanceof HttpsURLConnection) && this.ios != null) {
                        ((HttpsURLConnection) this.ipF).setSSLSocketFactory(this.ios.getSocketFactory());
                        j.a(this.ipF, this.ioN);
                    }
                    this.ipF.setDoInput(true);
                    this.ipF.setConnectTimeout(this.azs);
                    this.ipF.setReadTimeout(this.azs);
                    this.ipF.setInstanceFollowRedirects(false);
                    this.ipF.setRequestProperty("Accept-Encoding", "gzip");
                    if (this.ipC != null) {
                        ab.i("MicroMsg.AppBrandDownloadWorker", "url %s : set header ", url);
                        for (Entry entry : this.ipC.entrySet()) {
                            this.ipF.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                            ab.i("MicroMsg.AppBrandDownloadWorker", "filename %s : key:%s ,value %s ", this.filename, entry.getKey(), entry.getValue());
                        }
                    }
                    this.ipF.setRequestProperty("User-Agent", this.ibJ);
                    this.ipB.p(j.f(this.ipF));
                    long contentLength = (long) this.ipF.getContentLength();
                    String headerField = this.ipF.getHeaderField("Content-Type");
                    String url2 = url.toString();
                    com.tencent.mm.sdk.f.b.a anJ = com.tencent.mm.sdk.f.b.a.anJ(headerField);
                    if (anJ == null) {
                        ako = com.tencent.mm.sdk.f.b.ako(url2);
                    } else {
                        if (anJ.mimeType.contains("application/octet-stream")) {
                            headerField = com.tencent.mm.sdk.f.b.ako(url2);
                            if (!bo.isNullOrNil(headerField)) {
                                ako = headerField;
                            }
                        }
                        ako = anJ.mimeType;
                    }
                    i2 = this.ipF.getResponseCode();
                    if (contentLength > 0) {
                        ((a) e.C(a.class)).f(437, 16, contentLength);
                    }
                    JSONObject e = j.e(this.ipF);
                    int i4 = 28;
                    if (i2 >= 100 && i2 < 200) {
                        i4 = 20;
                    } else if (200 == i2) {
                        i4 = 21;
                    } else if (i2 > 200 && i2 < 300) {
                        i4 = 22;
                    } else if (302 == i2) {
                        i4 = 23;
                    } else if (i2 >= 300 && i2 < 400) {
                        i4 = 24;
                    } else if (404 == i2) {
                        i4 = 25;
                    } else if (i2 >= 400 && i2 < 500) {
                        i4 = 26;
                    } else if (i2 >= 500) {
                        i4 = 27;
                    }
                    ((a) e.C(a.class)).f(437, (long) i4, 1);
                    ab.i("MicroMsg.AppBrandDownloadWorker", "reportStatusCode:%d, key:%d", Integer.valueOf(i2), Integer.valueOf(i4));
                    this.ipB.p(e);
                    if (i2 != 200) {
                        ab.e("MicroMsg.AppBrandDownloadWorker", "statusCode %s, url is %s ,filename is %s ", Integer.valueOf(i2), this.uri, this.filename);
                        if (j.po(i2)) {
                            headerField = j.c(this.ipF);
                            if (!TextUtils.isEmpty(headerField)) {
                                i3 = this.ioO;
                                this.ioO = i3 - 1;
                                if (i3 <= 0) {
                                    ab.w("MicroMsg.AppBrandDownloadWorker", "reach the max redirect count(%d)", Integer.valueOf(15));
                                    this.ipB.c(this.filename, ako, this.uri, i2);
                                    ((o) e.C(o.class)).a(this.hvw.getAppId(), this.ioR, "GET", this.uri, 0, 0, i2, 1, aID());
                                    ((a) e.C(a.class)).f(437, 10, 1);
                                    ((a) e.C(a.class)).f(437, 12, System.currentTimeMillis() - this.ipE);
                                    aIP();
                                    this.ipB.CI(this.hvr);
                                    AppMethodBeat.o(108280);
                                    return;
                                }
                                ab.i("MicroMsg.AppBrandDownloadWorker", "redirect(%d) URL(%s) to URL(%s)", Integer.valueOf(this.ioO), this.uri, headerField);
                                this.uri = headerField;
                                run();
                                ((o) e.C(o.class)).a(this.hvw.getAppId(), this.ioR, "GET", this.uri, 0, 0, i2, 2, aID());
                                ((a) e.C(a.class)).f(437, 11, 1);
                                ((a) e.C(a.class)).f(437, 13, System.currentTimeMillis() - this.ipE);
                                if (at.getNetType(ah.getContext()) == -1) {
                                    ((a) e.C(a.class)).f(437, 7, 1);
                                }
                                ab.i("MicroMsg.AppBrandDownloadWorker", "downloadFile fail ret:%d", Integer.valueOf(i4));
                                aIP();
                                this.ipB.CI(this.hvr);
                                AppMethodBeat.o(108280);
                                return;
                            }
                        }
                    }
                    i3 = this.ipF.getContentLength();
                    if (i3 <= 0 || this.ipD <= 0 || i3 < this.ipD * 1048576) {
                        long j;
                        long j2;
                        Object obj3;
                        InputStream gZIPInputStream;
                        if ("gzip".equals(this.ipF.getContentEncoding())) {
                            gZIPInputStream = new GZIPInputStream(this.ipF.getInputStream());
                        } else if ("deflate".equals(this.ipF.getContentEncoding())) {
                            gZIPInputStream = new InflaterInputStream(this.ipF.getInputStream(), new Inflater(true));
                        } else {
                            inputStream3 = this.ipF.getInputStream();
                        }
                        try {
                            File file = new File(this.filename);
                            if (file.exists()) {
                                ab.i("MicroMsg.AppBrandDownloadWorker", "exists temp file ,filename is %s ", this.filename);
                                if (!file.delete()) {
                                    ab.e("MicroMsg.AppBrandDownloadWorker", "exists temp file delete failed, filename is %s ", this.filename);
                                    this.ipB.E(this.filename, this.uri, "exists temp file delete failed");
                                    ((o) e.C(o.class)).a(this.hvw.getAppId(), this.ioR, "GET", this.uri, 0, 0, i2, 2, aID());
                                    ((a) e.C(a.class)).f(437, 11, 1);
                                    ((a) e.C(a.class)).f(437, 13, System.currentTimeMillis() - this.ipE);
                                    if (at.getNetType(ah.getContext()) == -1) {
                                        ((a) e.C(a.class)).f(437, 7, 1);
                                    }
                                    ab.i("MicroMsg.AppBrandDownloadWorker", "downloadFile fail ret:%d", Integer.valueOf(i4));
                                    if (inputStream3 != null) {
                                        try {
                                            inputStream3.close();
                                        } catch (IOException e2) {
                                            ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e2, "IOException: url is %s filename %s ", this.uri, this.filename);
                                        } catch (ArrayIndexOutOfBoundsException e3) {
                                            ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e3, "ArrayIndexOutOfBoundsException: url is %s filename %s ", this.uri, this.filename);
                                        } catch (Throwable th2) {
                                            ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", th2, "Throwable: url is %s filename %s ", this.uri, this.filename);
                                        }
                                    }
                                    aIP();
                                    this.ipB.CI(this.hvr);
                                    AppMethodBeat.o(108280);
                                    return;
                                }
                            }
                            if (!file.getParentFile().exists()) {
                                ab.i("MicroMsg.AppBrandDownloadWorker", "create file ,filename is %s ", this.filename);
                                if (!file.getParentFile().mkdirs()) {
                                    ab.e("MicroMsg.AppBrandDownloadWorker", "create file  getParentFile failed, filename is %s ", this.filename);
                                    this.ipB.E(this.filename, this.uri, "getParentFile failed");
                                    ((o) e.C(o.class)).a(this.hvw.getAppId(), this.ioR, "GET", this.uri, 0, 0, i2, 2, aID());
                                    ((a) e.C(a.class)).f(437, 11, 1);
                                    ((a) e.C(a.class)).f(437, 13, System.currentTimeMillis() - this.ipE);
                                    if (at.getNetType(ah.getContext()) == -1) {
                                        ((a) e.C(a.class)).f(437, 7, 1);
                                    }
                                    ab.i("MicroMsg.AppBrandDownloadWorker", "downloadFile fail ret:%d", Integer.valueOf(i4));
                                    if (inputStream3 != null) {
                                        try {
                                            inputStream3.close();
                                        } catch (IOException e22) {
                                            ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e22, "IOException: url is %s filename %s ", this.uri, this.filename);
                                        } catch (ArrayIndexOutOfBoundsException e32) {
                                            ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e32, "ArrayIndexOutOfBoundsException: url is %s filename %s ", this.uri, this.filename);
                                        } catch (Throwable th22) {
                                            ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", th22, "Throwable: url is %s filename %s ", this.uri, this.filename);
                                        }
                                    }
                                    aIP();
                                    this.ipB.CI(this.hvr);
                                    AppMethodBeat.o(108280);
                                    return;
                                }
                            }
                            if (inputStream3 != null) {
                                FileOutputStream fileOutputStream4 = new FileOutputStream(file);
                                try {
                                    byte[] bArr = new byte[j.gr((long) i3)];
                                    i4 = -1;
                                    j = 0;
                                    while (true) {
                                        try {
                                            i3 = inputStream3.read(bArr);
                                            if (i3 == -1 || !this.isRunning) {
                                                break;
                                            } else if (j.y(this.hvw)) {
                                                this.ipB.E(this.filename, this.uri, "interrupted");
                                                ((o) e.C(o.class)).a(this.hvw.getAppId(), this.ioR, "GET", this.uri, 0, j, i2, 2, aID());
                                                ((a) e.C(a.class)).f(437, 11, 1);
                                                ((a) e.C(a.class)).f(437, 13, System.currentTimeMillis() - this.ipE);
                                                if (at.getNetType(ah.getContext()) == -1) {
                                                    ((a) e.C(a.class)).f(437, 7, 1);
                                                }
                                                ab.i("MicroMsg.AppBrandDownloadWorker", "downloadFile fail ret:%d", Integer.valueOf(i4));
                                                try {
                                                    fileOutputStream4.close();
                                                } catch (IOException e222) {
                                                    ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e222, "IOException: url is %s filename %s ", this.uri, this.filename);
                                                }
                                                if (inputStream3 != null) {
                                                    try {
                                                        inputStream3.close();
                                                    } catch (IOException e2222) {
                                                        ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e2222, "IOException: url is %s filename %s ", this.uri, this.filename);
                                                    } catch (ArrayIndexOutOfBoundsException e322) {
                                                        ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e322, "ArrayIndexOutOfBoundsException: url is %s filename %s ", this.uri, this.filename);
                                                    } catch (Throwable th222) {
                                                        ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", th222, "Throwable: url is %s filename %s ", this.uri, this.filename);
                                                    }
                                                }
                                                aIP();
                                                this.ipB.CI(this.hvr);
                                                AppMethodBeat.o(108280);
                                                return;
                                            } else {
                                                fileOutputStream4.write(bArr, 0, i3);
                                                j2 = j + ((long) i3);
                                                if (contentLength > 0) {
                                                    try {
                                                        if (this.isRunning) {
                                                            int i5 = (int) ((100 * j2) / contentLength);
                                                            if (i4 != i5) {
                                                                this.ipB.a(this.uri, i5, j2, contentLength);
                                                                i4 = i5;
                                                            }
                                                            ab.v("MicroMsg.AppBrandDownloadWorker", "download size %d, totalSize %d, percent = %d", Long.valueOf(j2), Long.valueOf(contentLength), Integer.valueOf(i5));
                                                        }
                                                    } catch (UnsupportedEncodingException e4) {
                                                        th222 = e4;
                                                        fileOutputStream = fileOutputStream2;
                                                        inputStream = inputStream3;
                                                        j = j2;
                                                        i = i2;
                                                        obj = null;
                                                        try {
                                                            ((a) e.C(a.class)).f(437, 1, 1);
                                                            ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", th222, "UnsupportedEncodingException: url is %s filename %s ", this.uri, this.filename);
                                                            this.ipB.E(this.filename, this.uri, "unsupport encoding error");
                                                            if (obj == null) {
                                                            }
                                                            if (fileOutputStream != null) {
                                                            }
                                                            if (inputStream != null) {
                                                            }
                                                            aIP();
                                                            this.ipB.CI(this.hvr);
                                                            AppMethodBeat.o(108280);
                                                            return;
                                                        } catch (Throwable th3) {
                                                            th222 = th3;
                                                            fileOutputStream3 = fileOutputStream;
                                                            inputStream2 = inputStream;
                                                            obj2 = obj;
                                                            if (obj2 == null) {
                                                            }
                                                            if (fileOutputStream3 != null) {
                                                            }
                                                            if (inputStream2 != null) {
                                                            }
                                                            aIP();
                                                            this.ipB.CI(this.hvr);
                                                            AppMethodBeat.o(108280);
                                                            throw th222;
                                                        }
                                                    } catch (FileNotFoundException e5) {
                                                        th222 = e5;
                                                        fileOutputStream3 = fileOutputStream2;
                                                        inputStream2 = inputStream3;
                                                        j = j2;
                                                        i = i2;
                                                        try {
                                                            ((a) e.C(a.class)).f(437, 3, 1);
                                                            ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", th222, "FileNotFoundException: url is %s filename %s ", this.uri, this.filename);
                                                            this.ipB.E(this.filename, this.uri, "file not found error");
                                                            if (obj2 == null) {
                                                            }
                                                            if (fileOutputStream3 != null) {
                                                            }
                                                            if (inputStream2 != null) {
                                                            }
                                                            aIP();
                                                            this.ipB.CI(this.hvr);
                                                            AppMethodBeat.o(108280);
                                                            return;
                                                        } catch (Throwable th4) {
                                                            th222 = th4;
                                                            if (obj2 == null) {
                                                            }
                                                            if (fileOutputStream3 != null) {
                                                            }
                                                            if (inputStream2 != null) {
                                                            }
                                                            aIP();
                                                            this.ipB.CI(this.hvr);
                                                            AppMethodBeat.o(108280);
                                                            throw th222;
                                                        }
                                                    } catch (SSLHandshakeException e6) {
                                                        th222 = e6;
                                                        fileOutputStream3 = fileOutputStream2;
                                                        inputStream2 = inputStream3;
                                                        j = j2;
                                                        i = i2;
                                                        ((a) e.C(a.class)).f(437, 2, 1);
                                                        ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", th222, "SSLHandshakeException: url is %s filename %s ", this.uri, this.filename);
                                                        this.ipB.E(this.filename, this.uri, "ssl handshake error");
                                                        if (obj2 == null) {
                                                        }
                                                        if (fileOutputStream3 != null) {
                                                        }
                                                        if (inputStream2 != null) {
                                                        }
                                                        aIP();
                                                        this.ipB.CI(this.hvr);
                                                        AppMethodBeat.o(108280);
                                                        return;
                                                    } catch (SocketTimeoutException e7) {
                                                        th222 = e7;
                                                        fileOutputStream3 = fileOutputStream2;
                                                        inputStream2 = inputStream3;
                                                        j = j2;
                                                        i = i2;
                                                        ((a) e.C(a.class)).f(437, 4, 1);
                                                        ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", th222, "SocketTimeoutException: url is %s filename %s ", this.uri, this.filename);
                                                        this.ipB.E(this.filename, this.uri, "socket timeout");
                                                        if (obj2 == null) {
                                                        }
                                                        if (fileOutputStream3 != null) {
                                                        }
                                                        if (inputStream2 != null) {
                                                        }
                                                        aIP();
                                                        this.ipB.CI(this.hvr);
                                                        AppMethodBeat.o(108280);
                                                        return;
                                                    } catch (Exception e8) {
                                                        th222 = e8;
                                                        fileOutputStream3 = fileOutputStream2;
                                                        inputStream2 = inputStream3;
                                                        j = j2;
                                                        i = i2;
                                                        ((a) e.C(a.class)).f(437, 5, 1);
                                                        ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", th222, "Exception: url is %s filename %s ", this.uri, this.filename);
                                                        this.ipB.E(this.filename, this.uri, th222.getMessage());
                                                        if (obj2 == null) {
                                                        }
                                                        if (fileOutputStream3 != null) {
                                                        }
                                                        if (inputStream2 != null) {
                                                        }
                                                        aIP();
                                                        this.ipB.CI(this.hvr);
                                                        AppMethodBeat.o(108280);
                                                        return;
                                                    } catch (Throwable th5) {
                                                        th222 = th5;
                                                        fileOutputStream3 = fileOutputStream2;
                                                        inputStream2 = inputStream3;
                                                        j = j2;
                                                        i = i2;
                                                        if (obj2 == null) {
                                                        }
                                                        if (fileOutputStream3 != null) {
                                                        }
                                                        if (inputStream2 != null) {
                                                        }
                                                        aIP();
                                                        this.ipB.CI(this.hvr);
                                                        AppMethodBeat.o(108280);
                                                        throw th222;
                                                    }
                                                }
                                                if (j2 <= 0 || this.ipD <= 0 || j2 < ((long) this.ipD) * 1048576) {
                                                    j = j2;
                                                } else {
                                                    ab.i("MicroMsg.AppBrandDownloadWorker", "after read stream, downloadSize %d exceed limit", Long.valueOf(j2));
                                                    this.ipB.E(this.filename, this.uri, "exceed max file size");
                                                    bo.b(fileOutputStream4);
                                                    bo.b(inputStream3);
                                                    com.tencent.mm.a.e.deleteFile(file.getAbsolutePath());
                                                    ((o) e.C(o.class)).a(this.hvw.getAppId(), this.ioR, "GET", this.uri, 0, j2, i2, 2, aID());
                                                    ((a) e.C(a.class)).f(437, 11, 1);
                                                    ((a) e.C(a.class)).f(437, 13, System.currentTimeMillis() - this.ipE);
                                                    if (at.getNetType(ah.getContext()) == -1) {
                                                        ((a) e.C(a.class)).f(437, 7, 1);
                                                    }
                                                    ab.i("MicroMsg.AppBrandDownloadWorker", "downloadFile fail ret:%d", Integer.valueOf(i4));
                                                    try {
                                                        fileOutputStream4.close();
                                                    } catch (IOException e22222) {
                                                        ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e22222, "IOException: url is %s filename %s ", this.uri, this.filename);
                                                    }
                                                    if (inputStream3 != null) {
                                                        try {
                                                            inputStream3.close();
                                                        } catch (IOException e222222) {
                                                            ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e222222, "IOException: url is %s filename %s ", this.uri, this.filename);
                                                        } catch (ArrayIndexOutOfBoundsException e3222) {
                                                            ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e3222, "ArrayIndexOutOfBoundsException: url is %s filename %s ", this.uri, this.filename);
                                                        } catch (Throwable th2222) {
                                                            ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", th2222, "Throwable: url is %s filename %s ", this.uri, this.filename);
                                                        }
                                                    }
                                                    aIP();
                                                    this.ipB.CI(this.hvr);
                                                    AppMethodBeat.o(108280);
                                                    return;
                                                }
                                            }
                                        } catch (UnsupportedEncodingException e9) {
                                            th2222 = e9;
                                            fileOutputStream = fileOutputStream4;
                                            inputStream = inputStream3;
                                            i = i2;
                                            obj = null;
                                            ((a) e.C(a.class)).f(437, 1, 1);
                                            ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", th2222, "UnsupportedEncodingException: url is %s filename %s ", this.uri, this.filename);
                                            this.ipB.E(this.filename, this.uri, "unsupport encoding error");
                                            if (obj == null) {
                                            }
                                            if (fileOutputStream != null) {
                                            }
                                            if (inputStream != null) {
                                            }
                                            aIP();
                                            this.ipB.CI(this.hvr);
                                            AppMethodBeat.o(108280);
                                            return;
                                        } catch (FileNotFoundException e10) {
                                            th2222 = e10;
                                            fileOutputStream3 = fileOutputStream4;
                                            inputStream2 = inputStream3;
                                            i = i2;
                                            ((a) e.C(a.class)).f(437, 3, 1);
                                            ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", th2222, "FileNotFoundException: url is %s filename %s ", this.uri, this.filename);
                                            this.ipB.E(this.filename, this.uri, "file not found error");
                                            if (obj2 == null) {
                                            }
                                            if (fileOutputStream3 != null) {
                                            }
                                            if (inputStream2 != null) {
                                            }
                                            aIP();
                                            this.ipB.CI(this.hvr);
                                            AppMethodBeat.o(108280);
                                            return;
                                        } catch (SSLHandshakeException e11) {
                                            th2222 = e11;
                                            fileOutputStream3 = fileOutputStream4;
                                            inputStream2 = inputStream3;
                                            i = i2;
                                            ((a) e.C(a.class)).f(437, 2, 1);
                                            ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", th2222, "SSLHandshakeException: url is %s filename %s ", this.uri, this.filename);
                                            this.ipB.E(this.filename, this.uri, "ssl handshake error");
                                            if (obj2 == null) {
                                            }
                                            if (fileOutputStream3 != null) {
                                            }
                                            if (inputStream2 != null) {
                                            }
                                            aIP();
                                            this.ipB.CI(this.hvr);
                                            AppMethodBeat.o(108280);
                                            return;
                                        } catch (SocketTimeoutException e12) {
                                            th2222 = e12;
                                            fileOutputStream3 = fileOutputStream4;
                                            inputStream2 = inputStream3;
                                            i = i2;
                                            ((a) e.C(a.class)).f(437, 4, 1);
                                            ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", th2222, "SocketTimeoutException: url is %s filename %s ", this.uri, this.filename);
                                            this.ipB.E(this.filename, this.uri, "socket timeout");
                                            if (obj2 == null) {
                                            }
                                            if (fileOutputStream3 != null) {
                                            }
                                            if (inputStream2 != null) {
                                            }
                                            aIP();
                                            this.ipB.CI(this.hvr);
                                            AppMethodBeat.o(108280);
                                            return;
                                        } catch (Exception e13) {
                                            th2222 = e13;
                                            fileOutputStream3 = fileOutputStream4;
                                            inputStream2 = inputStream3;
                                            i = i2;
                                            ((a) e.C(a.class)).f(437, 5, 1);
                                            ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", th2222, "Exception: url is %s filename %s ", this.uri, this.filename);
                                            this.ipB.E(this.filename, this.uri, th2222.getMessage());
                                            if (obj2 == null) {
                                            }
                                            if (fileOutputStream3 != null) {
                                            }
                                            if (inputStream2 != null) {
                                            }
                                            aIP();
                                            this.ipB.CI(this.hvr);
                                            AppMethodBeat.o(108280);
                                            return;
                                        } catch (Throwable th6) {
                                            th2222 = th6;
                                            fileOutputStream3 = fileOutputStream4;
                                            inputStream2 = inputStream3;
                                            i = i2;
                                            if (obj2 == null) {
                                            }
                                            if (fileOutputStream3 != null) {
                                            }
                                            if (inputStream2 != null) {
                                            }
                                            aIP();
                                            this.ipB.CI(this.hvr);
                                            AppMethodBeat.o(108280);
                                            throw th2222;
                                        }
                                    }
                                } catch (UnsupportedEncodingException e14) {
                                    th2222 = e14;
                                    fileOutputStream = fileOutputStream4;
                                    inputStream = inputStream3;
                                    j = 0;
                                    i = i2;
                                    obj = null;
                                    ((a) e.C(a.class)).f(437, 1, 1);
                                    ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", th2222, "UnsupportedEncodingException: url is %s filename %s ", this.uri, this.filename);
                                    this.ipB.E(this.filename, this.uri, "unsupport encoding error");
                                    if (obj == null) {
                                        ((o) e.C(o.class)).a(this.hvw.getAppId(), this.ioR, "GET", this.uri, 0, j, i, 1, aID());
                                        ((a) e.C(a.class)).f(437, 10, 1);
                                        ((a) e.C(a.class)).f(437, 12, System.currentTimeMillis() - this.ipE);
                                    } else {
                                        ((o) e.C(o.class)).a(this.hvw.getAppId(), this.ioR, "GET", this.uri, 0, j, i, 2, aID());
                                        ((a) e.C(a.class)).f(437, 11, 1);
                                        ((a) e.C(a.class)).f(437, 13, System.currentTimeMillis() - this.ipE);
                                        if (at.getNetType(ah.getContext()) == -1) {
                                            ((a) e.C(a.class)).f(437, 7, 1);
                                        }
                                        ab.i("MicroMsg.AppBrandDownloadWorker", "downloadFile fail ret:%d", Integer.valueOf(i4));
                                    }
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                        } catch (IOException e2222222) {
                                            ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e2222222, "IOException: url is %s filename %s ", this.uri, this.filename);
                                        }
                                    }
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException e22222222) {
                                            ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e22222222, "IOException: url is %s filename %s ", this.uri, this.filename);
                                        } catch (ArrayIndexOutOfBoundsException e32222) {
                                            ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e32222, "ArrayIndexOutOfBoundsException: url is %s filename %s ", this.uri, this.filename);
                                        } catch (Throwable th22222) {
                                            ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", th22222, "Throwable: url is %s filename %s ", this.uri, this.filename);
                                        }
                                    }
                                    aIP();
                                    this.ipB.CI(this.hvr);
                                    AppMethodBeat.o(108280);
                                    return;
                                } catch (FileNotFoundException e15) {
                                    th22222 = e15;
                                    fileOutputStream3 = fileOutputStream4;
                                    inputStream2 = inputStream3;
                                    j = 0;
                                    i = i2;
                                    ((a) e.C(a.class)).f(437, 3, 1);
                                    ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", th22222, "FileNotFoundException: url is %s filename %s ", this.uri, this.filename);
                                    this.ipB.E(this.filename, this.uri, "file not found error");
                                    if (obj2 == null) {
                                        ((o) e.C(o.class)).a(this.hvw.getAppId(), this.ioR, "GET", this.uri, 0, j, i, 1, aID());
                                        ((a) e.C(a.class)).f(437, 10, 1);
                                        ((a) e.C(a.class)).f(437, 12, System.currentTimeMillis() - this.ipE);
                                    } else {
                                        ((o) e.C(o.class)).a(this.hvw.getAppId(), this.ioR, "GET", this.uri, 0, j, i, 2, aID());
                                        ((a) e.C(a.class)).f(437, 11, 1);
                                        ((a) e.C(a.class)).f(437, 13, System.currentTimeMillis() - this.ipE);
                                        if (at.getNetType(ah.getContext()) == -1) {
                                            ((a) e.C(a.class)).f(437, 7, 1);
                                        }
                                        ab.i("MicroMsg.AppBrandDownloadWorker", "downloadFile fail ret:%d", Integer.valueOf(i4));
                                    }
                                    if (fileOutputStream3 != null) {
                                        try {
                                            fileOutputStream3.close();
                                        } catch (IOException e222222222) {
                                            ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e222222222, "IOException: url is %s filename %s ", this.uri, this.filename);
                                        }
                                    }
                                    if (inputStream2 != null) {
                                        try {
                                            inputStream2.close();
                                        } catch (IOException e2222222222) {
                                            ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e2222222222, "IOException: url is %s filename %s ", this.uri, this.filename);
                                        } catch (ArrayIndexOutOfBoundsException e322222) {
                                            ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e322222, "ArrayIndexOutOfBoundsException: url is %s filename %s ", this.uri, this.filename);
                                        } catch (Throwable th222222) {
                                            ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", th222222, "Throwable: url is %s filename %s ", this.uri, this.filename);
                                        }
                                    }
                                    aIP();
                                    this.ipB.CI(this.hvr);
                                    AppMethodBeat.o(108280);
                                    return;
                                } catch (SSLHandshakeException e16) {
                                    th222222 = e16;
                                    fileOutputStream3 = fileOutputStream4;
                                    inputStream2 = inputStream3;
                                    j = 0;
                                    i = i2;
                                    ((a) e.C(a.class)).f(437, 2, 1);
                                    ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", th222222, "SSLHandshakeException: url is %s filename %s ", this.uri, this.filename);
                                    this.ipB.E(this.filename, this.uri, "ssl handshake error");
                                    if (obj2 == null) {
                                        ((o) e.C(o.class)).a(this.hvw.getAppId(), this.ioR, "GET", this.uri, 0, j, i, 1, aID());
                                        ((a) e.C(a.class)).f(437, 10, 1);
                                        ((a) e.C(a.class)).f(437, 12, System.currentTimeMillis() - this.ipE);
                                    } else {
                                        ((o) e.C(o.class)).a(this.hvw.getAppId(), this.ioR, "GET", this.uri, 0, j, i, 2, aID());
                                        ((a) e.C(a.class)).f(437, 11, 1);
                                        ((a) e.C(a.class)).f(437, 13, System.currentTimeMillis() - this.ipE);
                                        if (at.getNetType(ah.getContext()) == -1) {
                                            ((a) e.C(a.class)).f(437, 7, 1);
                                        }
                                        ab.i("MicroMsg.AppBrandDownloadWorker", "downloadFile fail ret:%d", Integer.valueOf(i4));
                                    }
                                    if (fileOutputStream3 != null) {
                                        try {
                                            fileOutputStream3.close();
                                        } catch (IOException e22222222222) {
                                            ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e22222222222, "IOException: url is %s filename %s ", this.uri, this.filename);
                                        }
                                    }
                                    if (inputStream2 != null) {
                                        try {
                                            inputStream2.close();
                                        } catch (IOException e222222222222) {
                                            ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e222222222222, "IOException: url is %s filename %s ", this.uri, this.filename);
                                        } catch (ArrayIndexOutOfBoundsException e3222222) {
                                            ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e3222222, "ArrayIndexOutOfBoundsException: url is %s filename %s ", this.uri, this.filename);
                                        } catch (Throwable th2222222) {
                                            ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", th2222222, "Throwable: url is %s filename %s ", this.uri, this.filename);
                                        }
                                    }
                                    aIP();
                                    this.ipB.CI(this.hvr);
                                    AppMethodBeat.o(108280);
                                    return;
                                } catch (SocketTimeoutException e17) {
                                    th2222222 = e17;
                                    fileOutputStream3 = fileOutputStream4;
                                    inputStream2 = inputStream3;
                                    j = 0;
                                    i = i2;
                                    ((a) e.C(a.class)).f(437, 4, 1);
                                    ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", th2222222, "SocketTimeoutException: url is %s filename %s ", this.uri, this.filename);
                                    this.ipB.E(this.filename, this.uri, "socket timeout");
                                    if (obj2 == null) {
                                        ((o) e.C(o.class)).a(this.hvw.getAppId(), this.ioR, "GET", this.uri, 0, j, i, 1, aID());
                                        ((a) e.C(a.class)).f(437, 10, 1);
                                        ((a) e.C(a.class)).f(437, 12, System.currentTimeMillis() - this.ipE);
                                    } else {
                                        ((o) e.C(o.class)).a(this.hvw.getAppId(), this.ioR, "GET", this.uri, 0, j, i, 2, aID());
                                        ((a) e.C(a.class)).f(437, 11, 1);
                                        ((a) e.C(a.class)).f(437, 13, System.currentTimeMillis() - this.ipE);
                                        if (at.getNetType(ah.getContext()) == -1) {
                                            ((a) e.C(a.class)).f(437, 7, 1);
                                        }
                                        ab.i("MicroMsg.AppBrandDownloadWorker", "downloadFile fail ret:%d", Integer.valueOf(i4));
                                    }
                                    if (fileOutputStream3 != null) {
                                        try {
                                            fileOutputStream3.close();
                                        } catch (IOException e2222222222222) {
                                            ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e2222222222222, "IOException: url is %s filename %s ", this.uri, this.filename);
                                        }
                                    }
                                    if (inputStream2 != null) {
                                        try {
                                            inputStream2.close();
                                        } catch (IOException e22222222222222) {
                                            ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e22222222222222, "IOException: url is %s filename %s ", this.uri, this.filename);
                                        } catch (ArrayIndexOutOfBoundsException e32222222) {
                                            ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e32222222, "ArrayIndexOutOfBoundsException: url is %s filename %s ", this.uri, this.filename);
                                        } catch (Throwable th22222222) {
                                            ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", th22222222, "Throwable: url is %s filename %s ", this.uri, this.filename);
                                        }
                                    }
                                    aIP();
                                    this.ipB.CI(this.hvr);
                                    AppMethodBeat.o(108280);
                                    return;
                                } catch (Exception e18) {
                                    th22222222 = e18;
                                    fileOutputStream3 = fileOutputStream4;
                                    inputStream2 = inputStream3;
                                    j = 0;
                                    i = i2;
                                    ((a) e.C(a.class)).f(437, 5, 1);
                                    ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", th22222222, "Exception: url is %s filename %s ", this.uri, this.filename);
                                    this.ipB.E(this.filename, this.uri, th22222222.getMessage());
                                    if (obj2 == null) {
                                        ((o) e.C(o.class)).a(this.hvw.getAppId(), this.ioR, "GET", this.uri, 0, j, i, 1, aID());
                                        ((a) e.C(a.class)).f(437, 10, 1);
                                        ((a) e.C(a.class)).f(437, 12, System.currentTimeMillis() - this.ipE);
                                    } else {
                                        ((o) e.C(o.class)).a(this.hvw.getAppId(), this.ioR, "GET", this.uri, 0, j, i, 2, aID());
                                        ((a) e.C(a.class)).f(437, 11, 1);
                                        ((a) e.C(a.class)).f(437, 13, System.currentTimeMillis() - this.ipE);
                                        if (at.getNetType(ah.getContext()) == -1) {
                                            ((a) e.C(a.class)).f(437, 7, 1);
                                        }
                                        ab.i("MicroMsg.AppBrandDownloadWorker", "downloadFile fail ret:%d", Integer.valueOf(i4));
                                    }
                                    if (fileOutputStream3 != null) {
                                        try {
                                            fileOutputStream3.close();
                                        } catch (IOException e222222222222222) {
                                            ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e222222222222222, "IOException: url is %s filename %s ", this.uri, this.filename);
                                        }
                                    }
                                    if (inputStream2 != null) {
                                        try {
                                            inputStream2.close();
                                        } catch (IOException e2222222222222222) {
                                            ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e2222222222222222, "IOException: url is %s filename %s ", this.uri, this.filename);
                                        } catch (ArrayIndexOutOfBoundsException e322222222) {
                                            ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e322222222, "ArrayIndexOutOfBoundsException: url is %s filename %s ", this.uri, this.filename);
                                        } catch (Throwable th222222222) {
                                            ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", th222222222, "Throwable: url is %s filename %s ", this.uri, this.filename);
                                        }
                                    }
                                    aIP();
                                    this.ipB.CI(this.hvr);
                                    AppMethodBeat.o(108280);
                                    return;
                                } catch (Throwable th7) {
                                    th222222222 = th7;
                                    fileOutputStream3 = fileOutputStream4;
                                    inputStream2 = inputStream3;
                                    j = 0;
                                    i = i2;
                                    if (obj2 == null) {
                                        ((o) e.C(o.class)).a(this.hvw.getAppId(), this.ioR, "GET", this.uri, 0, j, i, 1, aID());
                                        ((a) e.C(a.class)).f(437, 10, 1);
                                        ((a) e.C(a.class)).f(437, 12, System.currentTimeMillis() - this.ipE);
                                    } else {
                                        ((o) e.C(o.class)).a(this.hvw.getAppId(), this.ioR, "GET", this.uri, 0, j, i, 2, aID());
                                        ((a) e.C(a.class)).f(437, 11, 1);
                                        ((a) e.C(a.class)).f(437, 13, System.currentTimeMillis() - this.ipE);
                                        if (at.getNetType(ah.getContext()) == -1) {
                                            ((a) e.C(a.class)).f(437, 7, 1);
                                        }
                                        ab.i("MicroMsg.AppBrandDownloadWorker", "downloadFile fail ret:%d", Integer.valueOf(r10));
                                    }
                                    if (fileOutputStream3 != null) {
                                        try {
                                            fileOutputStream3.close();
                                        } catch (IOException e19) {
                                            ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e19, "IOException: url is %s filename %s ", this.uri, this.filename);
                                        }
                                    }
                                    if (inputStream2 != null) {
                                        try {
                                            inputStream2.close();
                                        } catch (IOException e192) {
                                            ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e192, "IOException: url is %s filename %s ", this.uri, this.filename);
                                        } catch (ArrayIndexOutOfBoundsException e20) {
                                            ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e20, "ArrayIndexOutOfBoundsException: url is %s filename %s ", this.uri, this.filename);
                                        } catch (Throwable th8) {
                                            ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", th8, "Throwable: url is %s filename %s ", this.uri, this.filename);
                                        }
                                    }
                                    aIP();
                                    this.ipB.CI(this.hvr);
                                    AppMethodBeat.o(108280);
                                    throw th222222222;
                                }
                            }
                            fileOutputStream2 = null;
                            j2 = 0;
                            if (this.isRunning) {
                                this.ipB.c(this.filename, ako, this.uri, i2);
                                long currentTimeMillis = System.currentTimeMillis() - this.ipE;
                                if (contentLength <= 0 || currentTimeMillis <= 0) {
                                    ab.i("MicroMsg.AppBrandDownloadWorker", "reportSpeed len:%d, time:%d return", Long.valueOf(contentLength), Long.valueOf(currentTimeMillis));
                                } else {
                                    i4 = 34;
                                    double d = (((double) contentLength) / ((double) currentTimeMillis)) * 0.9765625d;
                                    if (at.is2G(ah.getContext())) {
                                        i4 = 30;
                                    } else if (at.is3G(ah.getContext())) {
                                        i4 = 31;
                                    } else if (at.is4G(ah.getContext())) {
                                        i4 = 32;
                                    } else if (at.isWifi(ah.getContext())) {
                                        i4 = 33;
                                    }
                                    ((a) e.C(a.class)).f(437, (long) i4, (long) d);
                                    ab.i("MicroMsg.AppBrandDownloadWorker", "reportSpeed len:%d, time:%d, speed:%f, key:%d", Long.valueOf(contentLength), Long.valueOf(currentTimeMillis), Double.valueOf(d), Integer.valueOf(i4));
                                }
                                obj3 = 1;
                            } else {
                                this.ipB.E(this.filename, this.uri, "force stop");
                                obj3 = null;
                            }
                        } catch (UnsupportedEncodingException e21) {
                            th222222222 = e21;
                            fileOutputStream = null;
                            inputStream = inputStream3;
                            j = 0;
                            i = i2;
                            obj = null;
                            ((a) e.C(a.class)).f(437, 1, 1);
                            ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", th222222222, "UnsupportedEncodingException: url is %s filename %s ", this.uri, this.filename);
                            this.ipB.E(this.filename, this.uri, "unsupport encoding error");
                            if (obj == null) {
                            }
                            if (fileOutputStream != null) {
                            }
                            if (inputStream != null) {
                            }
                            aIP();
                            this.ipB.CI(this.hvr);
                            AppMethodBeat.o(108280);
                            return;
                        } catch (FileNotFoundException e23) {
                            th222222222 = e23;
                            inputStream2 = inputStream3;
                            j = 0;
                            i = i2;
                            ((a) e.C(a.class)).f(437, 3, 1);
                            ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", th222222222, "FileNotFoundException: url is %s filename %s ", this.uri, this.filename);
                            this.ipB.E(this.filename, this.uri, "file not found error");
                            if (obj2 == null) {
                            }
                            if (fileOutputStream3 != null) {
                            }
                            if (inputStream2 != null) {
                            }
                            aIP();
                            this.ipB.CI(this.hvr);
                            AppMethodBeat.o(108280);
                            return;
                        } catch (SSLHandshakeException e24) {
                            th222222222 = e24;
                            inputStream2 = inputStream3;
                            j = 0;
                            i = i2;
                            ((a) e.C(a.class)).f(437, 2, 1);
                            ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", th222222222, "SSLHandshakeException: url is %s filename %s ", this.uri, this.filename);
                            this.ipB.E(this.filename, this.uri, "ssl handshake error");
                            if (obj2 == null) {
                            }
                            if (fileOutputStream3 != null) {
                            }
                            if (inputStream2 != null) {
                            }
                            aIP();
                            this.ipB.CI(this.hvr);
                            AppMethodBeat.o(108280);
                            return;
                        } catch (SocketTimeoutException e25) {
                            th222222222 = e25;
                            inputStream2 = inputStream3;
                            j = 0;
                            i = i2;
                            ((a) e.C(a.class)).f(437, 4, 1);
                            ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", th222222222, "SocketTimeoutException: url is %s filename %s ", this.uri, this.filename);
                            this.ipB.E(this.filename, this.uri, "socket timeout");
                            if (obj2 == null) {
                            }
                            if (fileOutputStream3 != null) {
                            }
                            if (inputStream2 != null) {
                            }
                            aIP();
                            this.ipB.CI(this.hvr);
                            AppMethodBeat.o(108280);
                            return;
                        } catch (Exception e26) {
                            th222222222 = e26;
                            inputStream2 = inputStream3;
                            j = 0;
                            i = i2;
                            ((a) e.C(a.class)).f(437, 5, 1);
                            ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", th222222222, "Exception: url is %s filename %s ", this.uri, this.filename);
                            this.ipB.E(this.filename, this.uri, th222222222.getMessage());
                            if (obj2 == null) {
                            }
                            if (fileOutputStream3 != null) {
                            }
                            if (inputStream2 != null) {
                            }
                            aIP();
                            this.ipB.CI(this.hvr);
                            AppMethodBeat.o(108280);
                            return;
                        } catch (Throwable th9) {
                            th222222222 = th9;
                            inputStream2 = inputStream3;
                            j = 0;
                            i = i2;
                            if (obj2 == null) {
                            }
                            if (fileOutputStream3 != null) {
                            }
                            if (inputStream2 != null) {
                            }
                            aIP();
                            this.ipB.CI(this.hvr);
                            AppMethodBeat.o(108280);
                            throw th222222222;
                        }
                        try {
                            ab.v("MicroMsg.AppBrandDownloadWorker", "finished filename = %s , url = %s ", this.filename, this.uri);
                            this.ipF.disconnect();
                            if (obj3 != null) {
                                ((o) e.C(o.class)).a(this.hvw.getAppId(), this.ioR, "GET", this.uri, 0, j2, i2, 1, aID());
                                ((a) e.C(a.class)).f(437, 10, 1);
                                ((a) e.C(a.class)).f(437, 12, System.currentTimeMillis() - this.ipE);
                            } else {
                                ((o) e.C(o.class)).a(this.hvw.getAppId(), this.ioR, "GET", this.uri, 0, j2, i2, 2, aID());
                                ((a) e.C(a.class)).f(437, 11, 1);
                                ((a) e.C(a.class)).f(437, 13, System.currentTimeMillis() - this.ipE);
                                if (at.getNetType(ah.getContext()) == -1) {
                                    ((a) e.C(a.class)).f(437, 7, 1);
                                }
                                ab.i("MicroMsg.AppBrandDownloadWorker", "downloadFile fail ret:%d", Integer.valueOf(i4));
                            }
                            if (fileOutputStream2 != null) {
                                try {
                                    fileOutputStream2.close();
                                } catch (IOException e22222222222222222) {
                                    ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e22222222222222222, "IOException: url is %s filename %s ", this.uri, this.filename);
                                }
                            }
                            if (inputStream3 != null) {
                                try {
                                    inputStream3.close();
                                } catch (IOException e222222222222222222) {
                                    ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e222222222222222222, "IOException: url is %s filename %s ", this.uri, this.filename);
                                } catch (ArrayIndexOutOfBoundsException e3222222222) {
                                    ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e3222222222, "ArrayIndexOutOfBoundsException: url is %s filename %s ", this.uri, this.filename);
                                } catch (Throwable th2222222222) {
                                    ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", th2222222222, "Throwable: url is %s filename %s ", this.uri, this.filename);
                                }
                            }
                            aIP();
                            this.ipB.CI(this.hvr);
                            AppMethodBeat.o(108280);
                            return;
                        } catch (UnsupportedEncodingException e27) {
                            th2222222222 = e27;
                            fileOutputStream = fileOutputStream2;
                            inputStream = inputStream3;
                            j = j2;
                            i = i2;
                            obj = obj3;
                            ((a) e.C(a.class)).f(437, 1, 1);
                            ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", th2222222222, "UnsupportedEncodingException: url is %s filename %s ", this.uri, this.filename);
                            this.ipB.E(this.filename, this.uri, "unsupport encoding error");
                            if (obj == null) {
                            }
                            if (fileOutputStream != null) {
                            }
                            if (inputStream != null) {
                            }
                            aIP();
                            this.ipB.CI(this.hvr);
                            AppMethodBeat.o(108280);
                            return;
                        } catch (FileNotFoundException e28) {
                            th2222222222 = e28;
                            fileOutputStream3 = fileOutputStream2;
                            inputStream2 = inputStream3;
                            j = j2;
                            i = i2;
                            obj2 = obj3;
                            ((a) e.C(a.class)).f(437, 3, 1);
                            ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", th2222222222, "FileNotFoundException: url is %s filename %s ", this.uri, this.filename);
                            this.ipB.E(this.filename, this.uri, "file not found error");
                            if (obj2 == null) {
                            }
                            if (fileOutputStream3 != null) {
                            }
                            if (inputStream2 != null) {
                            }
                            aIP();
                            this.ipB.CI(this.hvr);
                            AppMethodBeat.o(108280);
                            return;
                        } catch (SSLHandshakeException e29) {
                            th2222222222 = e29;
                            fileOutputStream3 = fileOutputStream2;
                            inputStream2 = inputStream3;
                            j = j2;
                            i = i2;
                            obj2 = obj3;
                            ((a) e.C(a.class)).f(437, 2, 1);
                            ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", th2222222222, "SSLHandshakeException: url is %s filename %s ", this.uri, this.filename);
                            this.ipB.E(this.filename, this.uri, "ssl handshake error");
                            if (obj2 == null) {
                            }
                            if (fileOutputStream3 != null) {
                            }
                            if (inputStream2 != null) {
                            }
                            aIP();
                            this.ipB.CI(this.hvr);
                            AppMethodBeat.o(108280);
                            return;
                        } catch (SocketTimeoutException e30) {
                            th2222222222 = e30;
                            fileOutputStream3 = fileOutputStream2;
                            inputStream2 = inputStream3;
                            j = j2;
                            i = i2;
                            obj2 = obj3;
                            ((a) e.C(a.class)).f(437, 4, 1);
                            ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", th2222222222, "SocketTimeoutException: url is %s filename %s ", this.uri, this.filename);
                            this.ipB.E(this.filename, this.uri, "socket timeout");
                            if (obj2 == null) {
                            }
                            if (fileOutputStream3 != null) {
                            }
                            if (inputStream2 != null) {
                            }
                            aIP();
                            this.ipB.CI(this.hvr);
                            AppMethodBeat.o(108280);
                            return;
                        } catch (Exception e31) {
                            th2222222222 = e31;
                            fileOutputStream3 = fileOutputStream2;
                            inputStream2 = inputStream3;
                            j = j2;
                            i = i2;
                            obj2 = obj3;
                            ((a) e.C(a.class)).f(437, 5, 1);
                            ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", th2222222222, "Exception: url is %s filename %s ", this.uri, this.filename);
                            this.ipB.E(this.filename, this.uri, th2222222222.getMessage());
                            if (obj2 == null) {
                            }
                            if (fileOutputStream3 != null) {
                            }
                            if (inputStream2 != null) {
                            }
                            aIP();
                            this.ipB.CI(this.hvr);
                            AppMethodBeat.o(108280);
                            return;
                        } catch (Throwable th10) {
                            th2222222222 = th10;
                            fileOutputStream3 = fileOutputStream2;
                            inputStream2 = inputStream3;
                            j = j2;
                            i = i2;
                            obj2 = obj3;
                            if (obj2 == null) {
                            }
                            if (fileOutputStream3 != null) {
                            }
                            if (inputStream2 != null) {
                            }
                            aIP();
                            this.ipB.CI(this.hvr);
                            AppMethodBeat.o(108280);
                            throw th2222222222;
                        }
                    }
                    ab.i("MicroMsg.AppBrandDownloadWorker", "before actually read stream, contentLength %d exceed limit", Integer.valueOf(i3));
                    this.ipB.E(this.filename, this.uri, "exceed max file size");
                    ((o) e.C(o.class)).a(this.hvw.getAppId(), this.ioR, "GET", this.uri, 0, 0, i2, 2, aID());
                    ((a) e.C(a.class)).f(437, 11, 1);
                    ((a) e.C(a.class)).f(437, 13, System.currentTimeMillis() - this.ipE);
                    if (at.getNetType(ah.getContext()) == -1) {
                        ((a) e.C(a.class)).f(437, 7, 1);
                    }
                    ab.i("MicroMsg.AppBrandDownloadWorker", "downloadFile fail ret:%d", Integer.valueOf(i4));
                    aIP();
                    this.ipB.CI(this.hvr);
                    AppMethodBeat.o(108280);
                } catch (Exception e33) {
                    ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e, "Exception: read err stream failed", new Object[0]);
                    inputStream3 = null;
                } catch (UnsupportedEncodingException e34) {
                } catch (FileNotFoundException e35) {
                } catch (SSLHandshakeException e36) {
                } catch (SocketTimeoutException e37) {
                } catch (Throwable th11) {
                }
            } else {
                this.ipB.E(this.filename, this.uri, "force stop");
                ((o) e.C(o.class)).a(this.hvw.getAppId(), this.ioR, "GET", this.uri, 0, 0, 0, 2, aID());
                AppMethodBeat.o(108280);
            }
        } else {
            this.ipB.E(this.filename, this.uri, "url not in domain list");
            ab.i("MicroMsg.AppBrandDownloadWorker", "not in domain url %s", this.uri);
            AppMethodBeat.o(108280);
        }
    }

    public final void aIP() {
        AppMethodBeat.i(108281);
        this.isRunning = false;
        if (this.ipF != null) {
            try {
                this.ipF.disconnect();
                AppMethodBeat.o(108281);
                return;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", e, "abortTask Exception", new Object[0]);
            }
        }
        AppMethodBeat.o(108281);
    }

    private int aID() {
        AppMethodBeat.i(108282);
        int currentTimeMillis = (int) (System.currentTimeMillis() - this.startTime);
        AppMethodBeat.o(108282);
        return currentTimeMillis;
    }
}
