package com.tencent.p177mm.pluginsdk.p592g.p593a.p596c;

import android.net.SSLCertificateSocketFactory;
import android.net.SSLSessionCache;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p1570d.C40433a;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p1570d.C44052b;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p595b.C35786d;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p595b.C35788g;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p595b.C40428f;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p595b.C4713a;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p595b.C4714b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.SecureRandom;
import java.util.Collection;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;

/* renamed from: com.tencent.mm.pluginsdk.g.a.c.j */
public final class C35791j {
    private static final Class[] vfi = new Class[]{InterruptedException.class};
    private static final Class[] vfj = new Class[]{UnknownHostException.class, IllegalArgumentException.class, MalformedURLException.class, IOException.class, FileNotFoundException.class, C4713a.class, C35786d.class, C35788g.class};
    private static final Class[] vfk = new Class[]{SocketException.class, SocketTimeoutException.class};
    private boolean vfh = false;

    C35791j() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:79:0x022a A:{SYNTHETIC, Splitter:B:79:0x022a} */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01f4 A:{Splitter:B:11:0x004d, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01f8 A:{SYNTHETIC, Splitter:B:68:0x01f8} */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01f8 A:{SYNTHETIC, Splitter:B:68:0x01f8} */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01f4 A:{Splitter:B:11:0x004d, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01f4 A:{Splitter:B:11:0x004d, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:50:0x0190, code skipped:
            r3 = e;
     */
    /* JADX WARNING: Missing block: B:51:0x0191, code skipped:
            r5 = r2;
     */
    /* JADX WARNING: Missing block: B:65:0x01f4, code skipped:
            r3 = th;
     */
    /* JADX WARNING: Missing block: B:66:0x01f5, code skipped:
            r5 = r2;
     */
    /* JADX WARNING: Missing block: B:69:?, code skipped:
            r5.disconnect();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    static C40432m m58654a(C4715e c4715e) {
        Throwable e;
        HttpURLConnection httpURLConnection;
        AppMethodBeat.m2504i(79580);
        if (C5046bo.isNullOrNil(c4715e.getFilePath())) {
            C4990ab.m7413e("MicroMsg.ResDownloader.NetworkPerformer", "%s: filePath is null or nil, just return null", c4715e.dib());
            AppMethodBeat.m2505o(79580);
            return null;
        }
        while (true) {
            try {
                boolean z;
                if (!c4715e.awc()) {
                    C40433a.ajj(c4715e.getFilePath());
                }
                C35791j.diw();
                URL url = new URL(c4715e.getURL());
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
                try {
                    C4990ab.m7417i("MicroMsg.ResDownloader.NetworkPerformer", "%s: connection opened, url = %s", c4715e.dib(), c4715e.getURL());
                    C35791j.diw();
                    C35791j.m58657a(c4715e, httpURLConnection2);
                    C35791j.diw();
                    long ek = C40433a.m69347ek(c4715e.getFilePath());
                    C4990ab.m7417i("MicroMsg.ResDownloader.NetworkPerformer", "%s: RangeOffset = %d", c4715e.dib(), Long.valueOf(ek));
                    if (ek == 0) {
                        z = false;
                    } else {
                        httpURLConnection2.addRequestProperty("Range", "bytes=" + ek + "-");
                        z = true;
                    }
                    C4990ab.m7417i("MicroMsg.ResDownloader.NetworkPerformer", "%s: hasRangerHeader=%b", c4715e.dib(), Boolean.valueOf(z));
                    C35791j.diw();
                    if ("https".equalsIgnoreCase(url.getProtocol())) {
                        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection2;
                        SSLContext ahL = C35791j.ahL("TLSv1.2");
                        if (ahL == null) {
                            ahL = C35791j.ahL("TLSv1");
                            if (ahL == null) {
                                ahL = SSLContext.getDefault();
                            }
                        }
                        if (ahL != null) {
                            ahL.init(null, null, new SecureRandom());
                            httpsURLConnection.setSSLSocketFactory(ahL.getSocketFactory());
                        }
                        httpsURLConnection.setSSLSocketFactory(SSLCertificateSocketFactory.getDefault(c4715e.diu(), new SSLSessionCache(C4996ah.getContext())));
                    }
                } catch (Exception e2) {
                } catch (Throwable th) {
                }
                C35791j.diw();
                C4990ab.m7411d("MicroMsg.ResDownloader.NetworkPerformer", "%s: HttpMethod = %s", c4715e.dib(), c4715e.dis());
                if ("POST".equals(c4715e.dis()) && !C5046bo.m7540cb(null)) {
                    httpURLConnection2.setDoOutput(true);
                    httpURLConnection2.setRequestProperty("Content-Type", c4715e.div());
                    Object[] objArr = null;
                    httpURLConnection2.setFixedLengthStreamingMode(objArr.length);
                    DataOutputStream dataOutputStream;
                    try {
                        dataOutputStream = new DataOutputStream(httpURLConnection2.getOutputStream());
                        try {
                            dataOutputStream.write(null);
                            try {
                                dataOutputStream.close();
                            } catch (IOException e3) {
                                C4990ab.m7413e("MicroMsg.ResDownloader.NetworkPerformer", "%s: Method POST, send request body, close IOException", c4715e.dib());
                                C4990ab.printErrStackTrace("MicroMsg.ResDownloader.NetworkPerformer", e3, "", new Object[0]);
                            }
                        } catch (IOException e4) {
                            e = e4;
                            try {
                                C4990ab.m7413e("MicroMsg.ResDownloader.NetworkPerformer", "%s: Method POST, send request body, write IOException", c4715e.dib());
                                C4990ab.printErrStackTrace("MicroMsg.ResDownloader.NetworkPerformer", e, "", new Object[0]);
                                AppMethodBeat.m2505o(79580);
                                throw e;
                            } catch (Throwable th2) {
                                e = th2;
                                if (dataOutputStream != null) {
                                    try {
                                        dataOutputStream.close();
                                    } catch (IOException e5) {
                                        C4990ab.m7413e("MicroMsg.ResDownloader.NetworkPerformer", "%s: Method POST, send request body, close IOException", c4715e.dib());
                                        C4990ab.printErrStackTrace("MicroMsg.ResDownloader.NetworkPerformer", e5, "", new Object[0]);
                                    }
                                }
                                AppMethodBeat.m2505o(79580);
                                throw e;
                            }
                        }
                    } catch (IOException e6) {
                        e = e6;
                        dataOutputStream = null;
                        C4990ab.m7413e("MicroMsg.ResDownloader.NetworkPerformer", "%s: Method POST, send request body, write IOException", c4715e.dib());
                        C4990ab.printErrStackTrace("MicroMsg.ResDownloader.NetworkPerformer", e, "", new Object[0]);
                        AppMethodBeat.m2505o(79580);
                        throw e;
                    } catch (Throwable th3) {
                        e = th3;
                        dataOutputStream = null;
                        if (dataOutputStream != null) {
                        }
                        AppMethodBeat.m2505o(79580);
                        throw e;
                    }
                }
                C35791j.diw();
                C40432m a = C35791j.m58656a(c4715e, httpURLConnection2, z);
                httpURLConnection2.disconnect();
                if (httpURLConnection2 != null) {
                    try {
                        httpURLConnection2.disconnect();
                    } catch (Exception e7) {
                    }
                }
                AppMethodBeat.m2505o(79580);
                return a;
            } catch (Exception e8) {
                Exception e9 = e8;
                httpURLConnection = null;
                try {
                    C40432m b = C35791j.m58658b(c4715e, e9);
                    if (b == null) {
                        C4990ab.m7417i("MicroMsg.ResDownloader.NetworkPerformer", "%s: get null response in catch-block, may retry", c4715e.dib());
                        if (!c4715e.awg()) {
                            C4990ab.m7417i("MicroMsg.ResDownloader.NetworkPerformer", "%s: retry times out", c4715e.dib());
                            b = C35791j.m58655a(c4715e, e9);
                            if (httpURLConnection != null) {
                                try {
                                    httpURLConnection.disconnect();
                                } catch (Exception e10) {
                                }
                            }
                            AppMethodBeat.m2505o(79580);
                            return b;
                        } else if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Exception e11) {
                            }
                        }
                    } else {
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Exception e12) {
                            }
                        }
                        AppMethodBeat.m2505o(79580);
                        return b;
                    }
                } catch (Throwable th4) {
                    e = th4;
                    if (httpURLConnection != null) {
                    }
                    AppMethodBeat.m2505o(79580);
                    throw e;
                }
            } catch (Throwable th42) {
                e = th42;
                httpURLConnection = null;
                if (httpURLConnection != null) {
                }
                AppMethodBeat.m2505o(79580);
                throw e;
            }
        }
    }

    private static void diw() {
        AppMethodBeat.m2504i(79581);
        if (Thread.interrupted()) {
            InterruptedException interruptedException = new InterruptedException(Thread.currentThread().getName() + " has interrupted by someone!");
            AppMethodBeat.m2505o(79581);
            throw interruptedException;
        }
        AppMethodBeat.m2505o(79581);
    }

    /* renamed from: a */
    private static void m58657a(C4715e c4715e, HttpURLConnection httpURLConnection) {
        AppMethodBeat.m2504i(79582);
        C4990ab.m7411d("MicroMsg.ResDownloader.NetworkPerformer", "%s: add http headers", c4715e.dib());
        Collection<C35789b> dit = c4715e.dit();
        if (dit != null && dit.size() > 0) {
            for (C35789b c35789b : dit) {
                httpURLConnection.addRequestProperty(c35789b.name, c35789b.value);
            }
        }
        httpURLConnection.setRequestMethod(c4715e.dis());
        if ("GET".equalsIgnoreCase(c4715e.dis())) {
            httpURLConnection.setDoOutput(false);
        }
        httpURLConnection.setConnectTimeout(c4715e.getConnectTimeout());
        httpURLConnection.setReadTimeout(c4715e.getReadTimeout());
        httpURLConnection.setUseCaches(false);
        if (c4715e.awb()) {
            httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        } else {
            httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
        }
        String property = System.getProperty("http.agent");
        if (!C5046bo.isNullOrNil(property)) {
            httpURLConnection.setRequestProperty("User-agent", property);
        }
        if (c4715e.awf()) {
            httpURLConnection.setInstanceFollowRedirects(true);
            AppMethodBeat.m2505o(79582);
            return;
        }
        httpURLConnection.setInstanceFollowRedirects(false);
        AppMethodBeat.m2505o(79582);
    }

    private static SSLContext ahL(String str) {
        AppMethodBeat.m2504i(79583);
        try {
            SSLContext instance = SSLContext.getInstance(str);
            AppMethodBeat.m2505o(79583);
            return instance;
        } catch (Exception e) {
            AppMethodBeat.m2505o(79583);
            return null;
        }
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:75:0x0187=Splitter:B:75:0x0187, B:63:0x014a=Splitter:B:63:0x014a} */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x022a A:{PHI: r4 , Catch:{ InterruptedException -> 0x022a, UnknownHostException -> 0x034d, SSLHandshakeException -> 0x0346, SocketException -> 0x033f, SocketTimeoutException -> 0x0338, IOException -> 0x0331 }, Splitter:B:91:0x01d7, ExcHandler: InterruptedException (e java.lang.InterruptedException)} */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x034d A:{PHI: r4 , Splitter:B:91:0x01d7, ExcHandler: UnknownHostException (e java.net.UnknownHostException)} */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0346 A:{PHI: r4 , Splitter:B:91:0x01d7, ExcHandler: SSLHandshakeException (e javax.net.ssl.SSLHandshakeException)} */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x033f A:{PHI: r4 , Splitter:B:91:0x01d7, ExcHandler: SocketException (e java.net.SocketException)} */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x0338 A:{PHI: r4 , Splitter:B:91:0x01d7, ExcHandler: SocketTimeoutException (e java.net.SocketTimeoutException)} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00fa A:{Splitter:B:1:0x001d, ExcHandler: InterruptedException (e java.lang.InterruptedException)} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x012b A:{Splitter:B:1:0x001d, ExcHandler: UnknownHostException (e java.net.UnknownHostException)} */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0148 A:{Splitter:B:1:0x001d, ExcHandler: SSLHandshakeException (e javax.net.ssl.SSLHandshakeException)} */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0185 A:{Splitter:B:1:0x001d, ExcHandler: SocketException (e java.net.SocketException)} */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01c5 A:{Splitter:B:1:0x001d, ExcHandler: SocketTimeoutException (e java.net.SocketTimeoutException)} */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x031f A:{Splitter:B:1:0x001d, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:31:0x00fa, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:32:0x00fb, code skipped:
            r4 = null;
     */
    /* JADX WARNING: Missing block: B:49:0x012b, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:50:0x012c, code skipped:
            r4 = null;
     */
    /* JADX WARNING: Missing block: B:61:0x0148, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:62:0x0149, code skipped:
            r4 = null;
     */
    /* JADX WARNING: Missing block: B:73:0x0185, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:74:0x0186, code skipped:
            r4 = null;
     */
    /* JADX WARNING: Missing block: B:83:0x01c5, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:84:0x01c6, code skipped:
            r4 = null;
     */
    /* JADX WARNING: Missing block: B:107:0x022a, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:135:0x02f3, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:136:0x02f4, code skipped:
            r5 = -1;
            r6 = null;
     */
    /* JADX WARNING: Missing block: B:142:0x031f, code skipped:
            r0 = th;
     */
    /* JADX WARNING: Missing block: B:143:0x0320, code skipped:
            r4 = null;
     */
    /* JADX WARNING: Missing block: B:150:0x032e, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:151:0x032f, code skipped:
            r6 = r4;
     */
    /* JADX WARNING: Missing block: B:156:0x0338, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:159:0x033f, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:162:0x0346, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:165:0x034d, code skipped:
            r0 = e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private static C40432m m58656a(C4715e c4715e, HttpURLConnection httpURLConnection, boolean z) {
        Object obj;
        Throwable th;
        SocketException e;
        IOException e2;
        Closeable closeable;
        InputStream errorStream;
        C40428f c40428f;
        AppMethodBeat.m2504i(79584);
        C4990ab.m7417i("MicroMsg.ResDownloader.NetworkPerformer", "%s: step4, start to read response", c4715e.dib());
        Closeable closeable2 = null;
        int i = -1;
        int responseCode;
        try {
            boolean z2;
            C40432m c40432m;
            responseCode = httpURLConnection.getResponseCode();
            int contentLength = httpURLConnection.getContentLength();
            String contentEncoding = httpURLConnection.getContentEncoding();
            String contentType = httpURLConnection.getContentType();
            if ("bytes".equals(httpURLConnection.getHeaderField("Accept-Ranges"))) {
                z2 = true;
            } else {
                String headerField = httpURLConnection.getHeaderField("Content-Range");
                z2 = headerField != null && headerField.startsWith("bytes");
            }
            C4990ab.m7417i("MicroMsg.ResDownloader.NetworkPerformer", "%s: received status code = %d, content-length = %d, content-encoding = %s, content-type = %s, isSupportRange = %b, \nresponseHeaders = %s", c4715e.dib(), Integer.valueOf(responseCode), Integer.valueOf(contentLength), contentEncoding, contentType, Boolean.valueOf(z2), C44052b.m79181aQ(httpURLConnection.getHeaderFields()));
            long ek = C40433a.m69347ek(c4715e.getFilePath());
            if (contentLength == 0 && 206 == responseCode && ek > 0) {
                C4990ab.m7417i("MicroMsg.ResDownloader.NetworkPerformer", "%s: file exists, return", c4715e.dib());
                c40432m = new C40432m(c4715e, ek, contentType);
                C40433a.m69346e(null);
                C40433a.m69346e(null);
                AppMethodBeat.m2505o(79584);
            } else if ((301 == responseCode || 302 == responseCode) && !c4715e.awf()) {
                C4990ab.m7417i("MicroMsg.ResDownloader.NetworkPerformer", "%s: task redirects not allowed, return", c4715e.dib());
                C35786d c35786d = new C35786d();
                AppMethodBeat.m2505o(79584);
                throw c35786d;
            } else if (contentLength == 0) {
                C35788g c35788g = new C35788g();
                AppMethodBeat.m2505o(79584);
                throw c35788g;
            } else if (c4715e.awd() || contentLength >= 0) {
                if (contentLength > 0) {
                    if (!c4715e.mo9636gh((long) contentLength)) {
                        C4713a c4713a = new C4713a();
                        AppMethodBeat.m2505o(79584);
                        throw c4713a;
                    }
                }
                if (416 == responseCode) {
                    C4714b c4714b = new C4714b((long) contentLength, ek);
                    AppMethodBeat.m2505o(79584);
                    throw c4714b;
                }
                Closeable bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                try {
                    boolean z3;
                    if (!C5046bo.isNullOrNil(contentEncoding) && contentEncoding.equalsIgnoreCase("gzip")) {
                        bufferedInputStream = new GZIPInputStream(bufferedInputStream);
                    }
                    contentEncoding = c4715e.getFilePath();
                    String dib = c4715e.dib();
                    if (z && z2) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    C4990ab.m7411d("MicroMsg.ResDownloader.NetworkPerformer", "%s: getOutputStream, filePath %s", dib, contentEncoding);
                    if (C5046bo.isNullOrNil(contentEncoding)) {
                        FileNotFoundException fileNotFoundException = new FileNotFoundException(String.format("%s filePath is null or nil", new Object[]{dib}));
                        AppMethodBeat.m2505o(79584);
                        throw fileNotFoundException;
                    }
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(contentEncoding, z3));
                    try {
                        C4990ab.m7417i("MicroMsg.ResDownloader.NetworkPerformer", "%s: append = %b, isSupportRange = %s", c4715e.dib(), Boolean.valueOf(z), Boolean.valueOf(z2));
                        byte[] bArr = new byte[16384];
                        i = 0;
                        while (true) {
                            int read = bufferedInputStream.read(bArr, 0, 16384);
                            if (read == -1) {
                                break;
                            }
                            bufferedOutputStream.write(bArr, 0, read);
                            i += read;
                            C35791j.diw();
                        }
                        C4990ab.m7417i("MicroMsg.ResDownloader.NetworkPerformer", "%s: read count = %d", c4715e.dib(), Integer.valueOf(i));
                        bufferedOutputStream.flush();
                        C4990ab.m7417i("MicroMsg.ResDownloader.NetworkPerformer", "%s: download complete, flush and send complete status", c4715e.dib());
                        if (c4715e.awd()) {
                            c40432m = new C40432m(c4715e, C40433a.m69347ek(c4715e.getFilePath()), contentType);
                            C40433a.m69346e(bufferedInputStream);
                            C40433a.m69346e(bufferedOutputStream);
                            if (i > 0 && C26417a.flv != null) {
                                C26417a.flv.mo44184cm(i, 0);
                            }
                            AppMethodBeat.m2505o(79584);
                        } else {
                            c40432m = new C40432m(c4715e, (long) contentLength, contentType);
                            C40433a.m69346e(bufferedInputStream);
                            C40433a.m69346e(bufferedOutputStream);
                            if (i > 0 && C26417a.flv != null) {
                                C26417a.flv.mo44184cm(i, 0);
                            }
                            AppMethodBeat.m2505o(79584);
                        }
                    } catch (InterruptedException e3) {
                        InterruptedException e4 = e3;
                        obj = bufferedOutputStream;
                        try {
                            AppMethodBeat.m2505o(79584);
                            throw e4;
                        } catch (Throwable th2) {
                            th = th2;
                            C40433a.m69346e(bufferedInputStream);
                            C40433a.m69346e(closeable2);
                            if (i > 0 && C26417a.flv != null) {
                                C26417a.flv.mo44184cm(i, 0);
                            }
                            AppMethodBeat.m2505o(79584);
                            throw th;
                        }
                    } catch (UnknownHostException e5) {
                        UnknownHostException e6 = e5;
                        obj = bufferedOutputStream;
                        AppMethodBeat.m2505o(79584);
                        throw e6;
                    } catch (SSLHandshakeException e7) {
                        th = e7;
                        obj = bufferedOutputStream;
                        C4990ab.m7413e("MicroMsg.ResDownloader.NetworkPerformer", "%s: HttpUrlConnection SSLHandshakeException!", c4715e.dib());
                        C4990ab.printErrStackTrace("MicroMsg.ResDownloader.NetworkPerformer", th, "", new Object[0]);
                        AppMethodBeat.m2505o(79584);
                        throw th;
                    } catch (SocketException e8) {
                        e = e8;
                        obj = bufferedOutputStream;
                        C4990ab.m7412e("MicroMsg.ResDownloader.NetworkPerformer", c4715e.dib() + ": " + e.getMessage());
                        AppMethodBeat.m2505o(79584);
                        throw e;
                    } catch (SocketTimeoutException e9) {
                        SocketTimeoutException e10 = e9;
                        obj = bufferedOutputStream;
                        AppMethodBeat.m2505o(79584);
                        throw e10;
                    } catch (IOException e11) {
                        e2 = e11;
                        obj = bufferedOutputStream;
                        closeable = bufferedInputStream;
                        try {
                            C40433a.m69346e(closeable);
                            errorStream = httpURLConnection.getErrorStream();
                            C4990ab.m7413e("MicroMsg.ResDownloader.NetworkPerformer", "%s: HttpUrlConnection getInputStream failed! %s", c4715e.dib(), e2);
                            c40428f = new C40428f(responseCode, e2);
                            AppMethodBeat.m2505o(79584);
                            throw c40428f;
                        } catch (Throwable th3) {
                            th = th3;
                            bufferedInputStream = closeable;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        obj = bufferedOutputStream;
                        C40433a.m69346e(bufferedInputStream);
                        C40433a.m69346e(closeable2);
                        C26417a.flv.mo44184cm(i, 0);
                        AppMethodBeat.m2505o(79584);
                        throw th;
                    }
                } catch (InterruptedException e12) {
                } catch (UnknownHostException e13) {
                } catch (SSLHandshakeException e14) {
                } catch (SocketException e15) {
                } catch (SocketTimeoutException e16) {
                } catch (IOException e17) {
                    e2 = e17;
                    closeable = bufferedInputStream;
                    C40433a.m69346e(closeable);
                    errorStream = httpURLConnection.getErrorStream();
                    C4990ab.m7413e("MicroMsg.ResDownloader.NetworkPerformer", "%s: HttpUrlConnection getInputStream failed! %s", c4715e.dib(), e2);
                    c40428f = new C40428f(responseCode, e2);
                    AppMethodBeat.m2505o(79584);
                    throw c40428f;
                }
            } else {
                e = new SocketException();
                AppMethodBeat.m2505o(79584);
                throw e;
            }
            return c40432m;
        } catch (InterruptedException e18) {
        } catch (UnknownHostException e19) {
        } catch (SSLHandshakeException e20) {
        } catch (SocketException e21) {
        } catch (SocketTimeoutException e22) {
        } catch (IOException e23) {
            e2 = e23;
            closeable = null;
            C40433a.m69346e(closeable);
            errorStream = httpURLConnection.getErrorStream();
            C4990ab.m7413e("MicroMsg.ResDownloader.NetworkPerformer", "%s: HttpUrlConnection getInputStream failed! %s", c4715e.dib(), e2);
            c40428f = new C40428f(responseCode, e2);
            AppMethodBeat.m2505o(79584);
            throw c40428f;
        } catch (Throwable th5) {
        }
    }

    /* renamed from: a */
    private static C40432m m58655a(C4715e c4715e, Exception exception) {
        AppMethodBeat.m2504i(79585);
        int i = -1;
        if (exception instanceof C40428f) {
            i = ((C40428f) exception).httpStatusCode;
            exception = ((C40428f) exception).veV;
        }
        C4990ab.m7417i("MicroMsg.ResDownloader.NetworkPerformer", "%s: download failed, caused by %s", c4715e.dib(), exception);
        C40432m c40432m = new C40432m(c4715e, exception, i, 3);
        AppMethodBeat.m2505o(79585);
        return c40432m;
    }

    /* renamed from: b */
    private static C40432m m58658b(C4715e c4715e, Exception exception) {
        AppMethodBeat.m2504i(79586);
        C40432m a;
        if (exception instanceof ProtocolException) {
            C4990ab.m7413e("MicroMsg.ResDownloader.NetworkPerformer", "%s: Protocol not support, the protocol: %s", c4715e.dib(), c4715e.dis());
            a = C35791j.m58655a(c4715e, exception);
            AppMethodBeat.m2505o(79586);
            return a;
        } else if (exception instanceof C4714b) {
            C4990ab.m7413e("MicroMsg.ResDownloader.NetworkPerformer", "%s: %s [%s]", c4715e.dib(), exception.getClass().getSimpleName(), exception.getMessage());
            C40433a.ajj(c4715e.getFilePath());
            AppMethodBeat.m2505o(79586);
            return null;
        } else {
            for (Object equals : vfi) {
                if (equals.equals(exception.getClass())) {
                    C4990ab.m7417i("MicroMsg.ResDownloader.NetworkPerformer", "%s: download canceled, caused by %s", c4715e.dib(), exception);
                    a = new C40432m(c4715e, exception, 4);
                    AppMethodBeat.m2505o(79586);
                    return a;
                }
            }
            for (Object equals2 : vfk) {
                if (equals2.equals(exception.getClass())) {
                    AppMethodBeat.m2505o(79586);
                    return null;
                }
            }
            for (Object equals3 : vfj) {
                if (equals3.equals(exception.getClass())) {
                    a = C35791j.m58655a(c4715e, exception);
                    AppMethodBeat.m2505o(79586);
                    return a;
                }
            }
            a = C35791j.m58655a(c4715e, exception);
            AppMethodBeat.m2505o(79586);
            return a;
        }
    }
}
