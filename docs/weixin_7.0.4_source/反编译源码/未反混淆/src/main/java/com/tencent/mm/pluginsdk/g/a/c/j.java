package com.tencent.mm.pluginsdk.g.a.c;

import android.net.SSLCertificateSocketFactory;
import android.net.SSLSessionCache;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ao;
import com.tencent.mm.pluginsdk.g.a.b.a;
import com.tencent.mm.pluginsdk.g.a.b.d;
import com.tencent.mm.pluginsdk.g.a.b.f;
import com.tencent.mm.pluginsdk.g.a.b.g;
import com.tencent.mm.pluginsdk.g.a.d.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
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

public final class j {
    private static final Class[] vfi = new Class[]{InterruptedException.class};
    private static final Class[] vfj = new Class[]{UnknownHostException.class, IllegalArgumentException.class, MalformedURLException.class, IOException.class, FileNotFoundException.class, a.class, d.class, g.class};
    private static final Class[] vfk = new Class[]{SocketException.class, SocketTimeoutException.class};
    private boolean vfh = false;

    j() {
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
    static m a(e eVar) {
        Throwable e;
        HttpURLConnection httpURLConnection;
        AppMethodBeat.i(79580);
        if (bo.isNullOrNil(eVar.getFilePath())) {
            ab.e("MicroMsg.ResDownloader.NetworkPerformer", "%s: filePath is null or nil, just return null", eVar.dib());
            AppMethodBeat.o(79580);
            return null;
        }
        while (true) {
            try {
                boolean z;
                if (!eVar.awc()) {
                    com.tencent.mm.pluginsdk.g.a.d.a.ajj(eVar.getFilePath());
                }
                diw();
                URL url = new URL(eVar.getURL());
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
                try {
                    ab.i("MicroMsg.ResDownloader.NetworkPerformer", "%s: connection opened, url = %s", eVar.dib(), eVar.getURL());
                    diw();
                    a(eVar, httpURLConnection2);
                    diw();
                    long ek = com.tencent.mm.pluginsdk.g.a.d.a.ek(eVar.getFilePath());
                    ab.i("MicroMsg.ResDownloader.NetworkPerformer", "%s: RangeOffset = %d", eVar.dib(), Long.valueOf(ek));
                    if (ek == 0) {
                        z = false;
                    } else {
                        httpURLConnection2.addRequestProperty("Range", "bytes=" + ek + "-");
                        z = true;
                    }
                    ab.i("MicroMsg.ResDownloader.NetworkPerformer", "%s: hasRangerHeader=%b", eVar.dib(), Boolean.valueOf(z));
                    diw();
                    if ("https".equalsIgnoreCase(url.getProtocol())) {
                        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection2;
                        SSLContext ahL = ahL("TLSv1.2");
                        if (ahL == null) {
                            ahL = ahL("TLSv1");
                            if (ahL == null) {
                                ahL = SSLContext.getDefault();
                            }
                        }
                        if (ahL != null) {
                            ahL.init(null, null, new SecureRandom());
                            httpsURLConnection.setSSLSocketFactory(ahL.getSocketFactory());
                        }
                        httpsURLConnection.setSSLSocketFactory(SSLCertificateSocketFactory.getDefault(eVar.diu(), new SSLSessionCache(ah.getContext())));
                    }
                } catch (Exception e2) {
                } catch (Throwable th) {
                }
                diw();
                ab.d("MicroMsg.ResDownloader.NetworkPerformer", "%s: HttpMethod = %s", eVar.dib(), eVar.dis());
                if ("POST".equals(eVar.dis()) && !bo.cb(null)) {
                    httpURLConnection2.setDoOutput(true);
                    httpURLConnection2.setRequestProperty("Content-Type", eVar.div());
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
                                ab.e("MicroMsg.ResDownloader.NetworkPerformer", "%s: Method POST, send request body, close IOException", eVar.dib());
                                ab.printErrStackTrace("MicroMsg.ResDownloader.NetworkPerformer", e3, "", new Object[0]);
                            }
                        } catch (IOException e4) {
                            e = e4;
                            try {
                                ab.e("MicroMsg.ResDownloader.NetworkPerformer", "%s: Method POST, send request body, write IOException", eVar.dib());
                                ab.printErrStackTrace("MicroMsg.ResDownloader.NetworkPerformer", e, "", new Object[0]);
                                AppMethodBeat.o(79580);
                                throw e;
                            } catch (Throwable th2) {
                                e = th2;
                                if (dataOutputStream != null) {
                                    try {
                                        dataOutputStream.close();
                                    } catch (IOException e5) {
                                        ab.e("MicroMsg.ResDownloader.NetworkPerformer", "%s: Method POST, send request body, close IOException", eVar.dib());
                                        ab.printErrStackTrace("MicroMsg.ResDownloader.NetworkPerformer", e5, "", new Object[0]);
                                    }
                                }
                                AppMethodBeat.o(79580);
                                throw e;
                            }
                        }
                    } catch (IOException e6) {
                        e = e6;
                        dataOutputStream = null;
                        ab.e("MicroMsg.ResDownloader.NetworkPerformer", "%s: Method POST, send request body, write IOException", eVar.dib());
                        ab.printErrStackTrace("MicroMsg.ResDownloader.NetworkPerformer", e, "", new Object[0]);
                        AppMethodBeat.o(79580);
                        throw e;
                    } catch (Throwable th3) {
                        e = th3;
                        dataOutputStream = null;
                        if (dataOutputStream != null) {
                        }
                        AppMethodBeat.o(79580);
                        throw e;
                    }
                }
                diw();
                m a = a(eVar, httpURLConnection2, z);
                httpURLConnection2.disconnect();
                if (httpURLConnection2 != null) {
                    try {
                        httpURLConnection2.disconnect();
                    } catch (Exception e7) {
                    }
                }
                AppMethodBeat.o(79580);
                return a;
            } catch (Exception e8) {
                Exception e9 = e8;
                httpURLConnection = null;
                try {
                    m b = b(eVar, e9);
                    if (b == null) {
                        ab.i("MicroMsg.ResDownloader.NetworkPerformer", "%s: get null response in catch-block, may retry", eVar.dib());
                        if (!eVar.awg()) {
                            ab.i("MicroMsg.ResDownloader.NetworkPerformer", "%s: retry times out", eVar.dib());
                            b = a(eVar, e9);
                            if (httpURLConnection != null) {
                                try {
                                    httpURLConnection.disconnect();
                                } catch (Exception e10) {
                                }
                            }
                            AppMethodBeat.o(79580);
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
                        AppMethodBeat.o(79580);
                        return b;
                    }
                } catch (Throwable th4) {
                    e = th4;
                    if (httpURLConnection != null) {
                    }
                    AppMethodBeat.o(79580);
                    throw e;
                }
            } catch (Throwable th42) {
                e = th42;
                httpURLConnection = null;
                if (httpURLConnection != null) {
                }
                AppMethodBeat.o(79580);
                throw e;
            }
        }
    }

    private static void diw() {
        AppMethodBeat.i(79581);
        if (Thread.interrupted()) {
            InterruptedException interruptedException = new InterruptedException(Thread.currentThread().getName() + " has interrupted by someone!");
            AppMethodBeat.o(79581);
            throw interruptedException;
        }
        AppMethodBeat.o(79581);
    }

    private static void a(e eVar, HttpURLConnection httpURLConnection) {
        AppMethodBeat.i(79582);
        ab.d("MicroMsg.ResDownloader.NetworkPerformer", "%s: add http headers", eVar.dib());
        Collection<b> dit = eVar.dit();
        if (dit != null && dit.size() > 0) {
            for (b bVar : dit) {
                httpURLConnection.addRequestProperty(bVar.name, bVar.value);
            }
        }
        httpURLConnection.setRequestMethod(eVar.dis());
        if ("GET".equalsIgnoreCase(eVar.dis())) {
            httpURLConnection.setDoOutput(false);
        }
        httpURLConnection.setConnectTimeout(eVar.getConnectTimeout());
        httpURLConnection.setReadTimeout(eVar.getReadTimeout());
        httpURLConnection.setUseCaches(false);
        if (eVar.awb()) {
            httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        } else {
            httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
        }
        String property = System.getProperty("http.agent");
        if (!bo.isNullOrNil(property)) {
            httpURLConnection.setRequestProperty("User-agent", property);
        }
        if (eVar.awf()) {
            httpURLConnection.setInstanceFollowRedirects(true);
            AppMethodBeat.o(79582);
            return;
        }
        httpURLConnection.setInstanceFollowRedirects(false);
        AppMethodBeat.o(79582);
    }

    private static SSLContext ahL(String str) {
        AppMethodBeat.i(79583);
        try {
            SSLContext instance = SSLContext.getInstance(str);
            AppMethodBeat.o(79583);
            return instance;
        } catch (Exception e) {
            AppMethodBeat.o(79583);
            return null;
        }
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:75:0x0187=Splitter:B:75:0x0187, B:63:0x014a=Splitter:B:63:0x014a} */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x022a A:{Catch:{ InterruptedException -> 0x022a, UnknownHostException -> 0x034d, SSLHandshakeException -> 0x0346, SocketException -> 0x033f, SocketTimeoutException -> 0x0338, IOException -> 0x0331 }, Splitter:B:91:0x01d7, PHI: r4 , ExcHandler: InterruptedException (e java.lang.InterruptedException)} */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x034d A:{Splitter:B:91:0x01d7, PHI: r4 , ExcHandler: UnknownHostException (e java.net.UnknownHostException)} */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0346 A:{Splitter:B:91:0x01d7, PHI: r4 , ExcHandler: SSLHandshakeException (e javax.net.ssl.SSLHandshakeException)} */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x033f A:{Splitter:B:91:0x01d7, PHI: r4 , ExcHandler: SocketException (e java.net.SocketException)} */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x0338 A:{Splitter:B:91:0x01d7, PHI: r4 , ExcHandler: SocketTimeoutException (e java.net.SocketTimeoutException)} */
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
    private static m a(e eVar, HttpURLConnection httpURLConnection, boolean z) {
        Object obj;
        Throwable th;
        SocketException e;
        IOException e2;
        Closeable closeable;
        InputStream errorStream;
        f fVar;
        AppMethodBeat.i(79584);
        ab.i("MicroMsg.ResDownloader.NetworkPerformer", "%s: step4, start to read response", eVar.dib());
        Closeable closeable2 = null;
        int i = -1;
        int responseCode;
        try {
            boolean z2;
            m mVar;
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
            ab.i("MicroMsg.ResDownloader.NetworkPerformer", "%s: received status code = %d, content-length = %d, content-encoding = %s, content-type = %s, isSupportRange = %b, \nresponseHeaders = %s", eVar.dib(), Integer.valueOf(responseCode), Integer.valueOf(contentLength), contentEncoding, contentType, Boolean.valueOf(z2), b.aQ(httpURLConnection.getHeaderFields()));
            long ek = com.tencent.mm.pluginsdk.g.a.d.a.ek(eVar.getFilePath());
            if (contentLength == 0 && 206 == responseCode && ek > 0) {
                ab.i("MicroMsg.ResDownloader.NetworkPerformer", "%s: file exists, return", eVar.dib());
                mVar = new m(eVar, ek, contentType);
                com.tencent.mm.pluginsdk.g.a.d.a.e(null);
                com.tencent.mm.pluginsdk.g.a.d.a.e(null);
                AppMethodBeat.o(79584);
            } else if ((301 == responseCode || 302 == responseCode) && !eVar.awf()) {
                ab.i("MicroMsg.ResDownloader.NetworkPerformer", "%s: task redirects not allowed, return", eVar.dib());
                d dVar = new d();
                AppMethodBeat.o(79584);
                throw dVar;
            } else if (contentLength == 0) {
                g gVar = new g();
                AppMethodBeat.o(79584);
                throw gVar;
            } else if (eVar.awd() || contentLength >= 0) {
                if (contentLength > 0) {
                    if (!eVar.gh((long) contentLength)) {
                        a aVar = new a();
                        AppMethodBeat.o(79584);
                        throw aVar;
                    }
                }
                if (416 == responseCode) {
                    com.tencent.mm.pluginsdk.g.a.b.b bVar = new com.tencent.mm.pluginsdk.g.a.b.b((long) contentLength, ek);
                    AppMethodBeat.o(79584);
                    throw bVar;
                }
                Closeable bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                try {
                    boolean z3;
                    if (!bo.isNullOrNil(contentEncoding) && contentEncoding.equalsIgnoreCase("gzip")) {
                        bufferedInputStream = new GZIPInputStream(bufferedInputStream);
                    }
                    contentEncoding = eVar.getFilePath();
                    String dib = eVar.dib();
                    if (z && z2) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    ab.d("MicroMsg.ResDownloader.NetworkPerformer", "%s: getOutputStream, filePath %s", dib, contentEncoding);
                    if (bo.isNullOrNil(contentEncoding)) {
                        FileNotFoundException fileNotFoundException = new FileNotFoundException(String.format("%s filePath is null or nil", new Object[]{dib}));
                        AppMethodBeat.o(79584);
                        throw fileNotFoundException;
                    }
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(contentEncoding, z3));
                    try {
                        ab.i("MicroMsg.ResDownloader.NetworkPerformer", "%s: append = %b, isSupportRange = %s", eVar.dib(), Boolean.valueOf(z), Boolean.valueOf(z2));
                        byte[] bArr = new byte[16384];
                        i = 0;
                        while (true) {
                            int read = bufferedInputStream.read(bArr, 0, 16384);
                            if (read == -1) {
                                break;
                            }
                            bufferedOutputStream.write(bArr, 0, read);
                            i += read;
                            diw();
                        }
                        ab.i("MicroMsg.ResDownloader.NetworkPerformer", "%s: read count = %d", eVar.dib(), Integer.valueOf(i));
                        bufferedOutputStream.flush();
                        ab.i("MicroMsg.ResDownloader.NetworkPerformer", "%s: download complete, flush and send complete status", eVar.dib());
                        if (eVar.awd()) {
                            mVar = new m(eVar, com.tencent.mm.pluginsdk.g.a.d.a.ek(eVar.getFilePath()), contentType);
                            com.tencent.mm.pluginsdk.g.a.d.a.e(bufferedInputStream);
                            com.tencent.mm.pluginsdk.g.a.d.a.e(bufferedOutputStream);
                            if (i > 0 && ao.a.flv != null) {
                                ao.a.flv.cm(i, 0);
                            }
                            AppMethodBeat.o(79584);
                        } else {
                            mVar = new m(eVar, (long) contentLength, contentType);
                            com.tencent.mm.pluginsdk.g.a.d.a.e(bufferedInputStream);
                            com.tencent.mm.pluginsdk.g.a.d.a.e(bufferedOutputStream);
                            if (i > 0 && ao.a.flv != null) {
                                ao.a.flv.cm(i, 0);
                            }
                            AppMethodBeat.o(79584);
                        }
                    } catch (InterruptedException e3) {
                        InterruptedException e4 = e3;
                        obj = bufferedOutputStream;
                        try {
                            AppMethodBeat.o(79584);
                            throw e4;
                        } catch (Throwable th2) {
                            th = th2;
                            com.tencent.mm.pluginsdk.g.a.d.a.e(bufferedInputStream);
                            com.tencent.mm.pluginsdk.g.a.d.a.e(closeable2);
                            if (i > 0 && ao.a.flv != null) {
                                ao.a.flv.cm(i, 0);
                            }
                            AppMethodBeat.o(79584);
                            throw th;
                        }
                    } catch (UnknownHostException e5) {
                        UnknownHostException e6 = e5;
                        obj = bufferedOutputStream;
                        AppMethodBeat.o(79584);
                        throw e6;
                    } catch (SSLHandshakeException e7) {
                        th = e7;
                        obj = bufferedOutputStream;
                        ab.e("MicroMsg.ResDownloader.NetworkPerformer", "%s: HttpUrlConnection SSLHandshakeException!", eVar.dib());
                        ab.printErrStackTrace("MicroMsg.ResDownloader.NetworkPerformer", th, "", new Object[0]);
                        AppMethodBeat.o(79584);
                        throw th;
                    } catch (SocketException e8) {
                        e = e8;
                        obj = bufferedOutputStream;
                        ab.e("MicroMsg.ResDownloader.NetworkPerformer", eVar.dib() + ": " + e.getMessage());
                        AppMethodBeat.o(79584);
                        throw e;
                    } catch (SocketTimeoutException e9) {
                        SocketTimeoutException e10 = e9;
                        obj = bufferedOutputStream;
                        AppMethodBeat.o(79584);
                        throw e10;
                    } catch (IOException e11) {
                        e2 = e11;
                        obj = bufferedOutputStream;
                        closeable = bufferedInputStream;
                        try {
                            com.tencent.mm.pluginsdk.g.a.d.a.e(closeable);
                            errorStream = httpURLConnection.getErrorStream();
                            ab.e("MicroMsg.ResDownloader.NetworkPerformer", "%s: HttpUrlConnection getInputStream failed! %s", eVar.dib(), e2);
                            fVar = new f(responseCode, e2);
                            AppMethodBeat.o(79584);
                            throw fVar;
                        } catch (Throwable th3) {
                            th = th3;
                            bufferedInputStream = closeable;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        obj = bufferedOutputStream;
                        com.tencent.mm.pluginsdk.g.a.d.a.e(bufferedInputStream);
                        com.tencent.mm.pluginsdk.g.a.d.a.e(closeable2);
                        ao.a.flv.cm(i, 0);
                        AppMethodBeat.o(79584);
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
                    com.tencent.mm.pluginsdk.g.a.d.a.e(closeable);
                    errorStream = httpURLConnection.getErrorStream();
                    ab.e("MicroMsg.ResDownloader.NetworkPerformer", "%s: HttpUrlConnection getInputStream failed! %s", eVar.dib(), e2);
                    fVar = new f(responseCode, e2);
                    AppMethodBeat.o(79584);
                    throw fVar;
                }
            } else {
                e = new SocketException();
                AppMethodBeat.o(79584);
                throw e;
            }
            return mVar;
        } catch (InterruptedException e18) {
        } catch (UnknownHostException e19) {
        } catch (SSLHandshakeException e20) {
        } catch (SocketException e21) {
        } catch (SocketTimeoutException e22) {
        } catch (IOException e23) {
            e2 = e23;
            closeable = null;
            com.tencent.mm.pluginsdk.g.a.d.a.e(closeable);
            errorStream = httpURLConnection.getErrorStream();
            ab.e("MicroMsg.ResDownloader.NetworkPerformer", "%s: HttpUrlConnection getInputStream failed! %s", eVar.dib(), e2);
            fVar = new f(responseCode, e2);
            AppMethodBeat.o(79584);
            throw fVar;
        } catch (Throwable th5) {
        }
    }

    private static m a(e eVar, Exception exception) {
        AppMethodBeat.i(79585);
        int i = -1;
        if (exception instanceof f) {
            i = ((f) exception).httpStatusCode;
            exception = ((f) exception).veV;
        }
        ab.i("MicroMsg.ResDownloader.NetworkPerformer", "%s: download failed, caused by %s", eVar.dib(), exception);
        m mVar = new m(eVar, exception, i, 3);
        AppMethodBeat.o(79585);
        return mVar;
    }

    private static m b(e eVar, Exception exception) {
        AppMethodBeat.i(79586);
        m a;
        if (exception instanceof ProtocolException) {
            ab.e("MicroMsg.ResDownloader.NetworkPerformer", "%s: Protocol not support, the protocol: %s", eVar.dib(), eVar.dis());
            a = a(eVar, exception);
            AppMethodBeat.o(79586);
            return a;
        } else if (exception instanceof com.tencent.mm.pluginsdk.g.a.b.b) {
            ab.e("MicroMsg.ResDownloader.NetworkPerformer", "%s: %s [%s]", eVar.dib(), exception.getClass().getSimpleName(), exception.getMessage());
            com.tencent.mm.pluginsdk.g.a.d.a.ajj(eVar.getFilePath());
            AppMethodBeat.o(79586);
            return null;
        } else {
            for (Object equals : vfi) {
                if (equals.equals(exception.getClass())) {
                    ab.i("MicroMsg.ResDownloader.NetworkPerformer", "%s: download canceled, caused by %s", eVar.dib(), exception);
                    a = new m(eVar, exception, 4);
                    AppMethodBeat.o(79586);
                    return a;
                }
            }
            for (Object equals2 : vfk) {
                if (equals2.equals(exception.getClass())) {
                    AppMethodBeat.o(79586);
                    return null;
                }
            }
            for (Object equals3 : vfj) {
                if (equals3.equals(exception.getClass())) {
                    a = a(eVar, exception);
                    AppMethodBeat.o(79586);
                    return a;
                }
            }
            a = a(eVar, exception);
            AppMethodBeat.o(79586);
            return a;
        }
    }
}
