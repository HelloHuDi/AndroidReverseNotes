package com.tencent.p177mm.plugin.wepkg.downloader;

import android.net.SSLCertificateSocketFactory;
import android.net.SSLSessionCache;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p1570d.C40433a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.SecureRandom;
import java.util.concurrent.Future;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;

/* renamed from: com.tencent.mm.plugin.wepkg.downloader.c */
public final class C14800c implements Runnable {
    private String mContentType;
    private int mStatusCode;
    private int retCode = 0;
    C30006f uVO;
    Future<?> uVP;
    HttpURLConnection uVQ;
    private String uVR;
    private String uVS;
    private String uVT;
    boolean uVU;
    private boolean uVV;
    private boolean uVW = false;

    public C14800c(C30006f c30006f) {
        this.uVO = c30006f;
    }

    /* JADX WARNING: Removed duplicated region for block: B:63:0x01e2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        AppMethodBeat.m2504i(63421);
        if (this.uVO == null) {
            AppMethodBeat.m2505o(63421);
        } else if (this.uVO.mUrl == null) {
            AppMethodBeat.m2505o(63421);
        } else {
            int i = this.uVO.lqQ;
            int i2 = 0;
            do {
                try {
                    URL url = new URL(this.uVO.mUrl);
                    this.uVQ = (HttpURLConnection) url.openConnection();
                    this.uVQ.setConnectTimeout(this.uVO.uWu);
                    this.uVQ.setReadTimeout(this.uVO.uWv);
                    this.uVQ.setUseCaches(false);
                    this.uVQ.setDoInput(true);
                    this.uVQ.setRequestMethod("GET");
                    this.uVQ.setDoOutput(false);
                    this.uVQ.setInstanceFollowRedirects(true);
                    this.uVQ.setRequestProperty("Accept-Encoding", "gzip, deflate");
                    String property = System.getProperty("http.agent");
                    if (!C5046bo.isNullOrNil(property)) {
                        this.uVQ.setRequestProperty("User-agent", property);
                    }
                    if (this.uVO.uWw) {
                        boolean z;
                        long ek = C40433a.m69347ek(this.uVO.mFilePath);
                        C4990ab.m7417i("MicroMsg.Wepkg.WePkgDownloadTask", "%s: RangeOffset = %d", this.uVO.uWo, Long.valueOf(ek));
                        if (ek == 0) {
                            z = false;
                        } else {
                            this.uVQ.addRequestProperty("Range", "bytes=" + ek + "-");
                            z = true;
                        }
                        this.uVV = z;
                    } else {
                        C40433a.ajj(this.uVO.mFilePath);
                    }
                    if ("https".equalsIgnoreCase(url.getProtocol())) {
                        int i3 = this.uVO.uWu;
                        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) this.uVQ;
                        SSLContext ahL = C14800c.ahL("TLSv1.2");
                        if (ahL == null) {
                            ahL = C14800c.ahL("TLSv1");
                            if (ahL == null) {
                                try {
                                    ahL = SSLContext.getDefault();
                                } catch (Exception e) {
                                }
                            }
                        }
                        if (ahL != null) {
                            try {
                                ahL.init(null, null, new SecureRandom());
                                httpsURLConnection.setSSLSocketFactory(ahL.getSocketFactory());
                            } catch (Exception e2) {
                            }
                        }
                        httpsURLConnection.setSSLSocketFactory(SSLCertificateSocketFactory.getDefault(i3, new SSLSessionCache(C4996ah.getContext())));
                    }
                    dgv();
                    C4990ab.m7417i("MicroMsg.Wepkg.WePkgDownloadTask", "handle responose retcode:%s", Integer.valueOf(this.retCode));
                    C30006f c30006f;
                    int i4;
                    if (this.retCode == 0) {
                        if (this.uVO.uWx != null) {
                            C40395a c40395a = this.uVO.uWx;
                            c30006f = this.uVO;
                            if (this.uVW) {
                                i4 = 1;
                            } else {
                                i4 = 0;
                            }
                            c40395a.mo9817a(new C35756g(c30006f, 1, 0, i4, i2));
                            if (this.uVO.mUrl.startsWith("https") && this.retCode == 1013 && i2 >= i - 1) {
                                C4990ab.m7416i("MicroMsg.Wepkg.WePkgDownloadTask", "change https to http request");
                                this.uVO.mUrl = this.uVO.mUrl.replaceFirst("https", "http");
                                this.retCode = 0;
                                this.uVW = false;
                            }
                            AppMethodBeat.m2505o(63421);
                            return;
                        }
                    } else if (this.retCode == 1011 || this.retCode == 1001 || this.retCode == 1009 || this.retCode == 1002 || this.retCode == 1007) {
                        if (this.uVO.mUrl.startsWith("https") && this.retCode == 1013 && i2 >= i - 1) {
                            C4990ab.m7416i("MicroMsg.Wepkg.WePkgDownloadTask", "change https to http request");
                            this.uVO.mUrl = this.uVO.mUrl.replaceFirst("https", "http");
                            this.retCode = 0;
                            this.uVW = false;
                            i2 = -1;
                        }
                        if (this.uVO.uWx != null) {
                            C40395a c40395a2 = this.uVO.uWx;
                            c30006f = this.uVO;
                            int i5 = this.retCode;
                            if (this.uVW) {
                                i4 = 1;
                            } else {
                                i4 = 0;
                            }
                            c40395a2.mo9817a(new C35756g(c30006f, 2, i5, i4, i2));
                        }
                        AppMethodBeat.m2505o(63421);
                    }
                    if (this.uVO.mUrl.startsWith("https") && this.retCode == 1013 && i2 >= i - 1) {
                        C4990ab.m7416i("MicroMsg.Wepkg.WePkgDownloadTask", "change https to http request");
                        this.uVO.mUrl = this.uVO.mUrl.replaceFirst("https", "http");
                        this.retCode = 0;
                        this.uVW = false;
                        i2 = -1;
                    }
                } catch (Exception e3) {
                    C4990ab.m7413e("MicroMsg.Wepkg.WePkgDownloadTask", "run exception : %s", e3.getMessage());
                    if (this.uVO.mUrl.startsWith("https") && this.retCode == 1013 && i2 >= i - 1) {
                        C4990ab.m7416i("MicroMsg.Wepkg.WePkgDownloadTask", "change https to http request");
                        this.uVO.mUrl = this.uVO.mUrl.replaceFirst("https", "http");
                        this.retCode = 0;
                        this.uVW = false;
                        i2 = -1;
                    }
                } catch (Throwable th) {
                    if (this.uVO.mUrl.startsWith("https") && this.retCode == 1013 && i2 >= i - 1) {
                        C4990ab.m7416i("MicroMsg.Wepkg.WePkgDownloadTask", "change https to http request");
                        this.uVO.mUrl = this.uVO.mUrl.replaceFirst("https", "http");
                        this.retCode = 0;
                        this.uVW = false;
                    }
                    AppMethodBeat.m2505o(63421);
                }
                i2++;
            } while (i2 < i);
            if (this.uVO.uWx != null) {
            }
            AppMethodBeat.m2505o(63421);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:63:0x0251 A:{SYNTHETIC, Splitter:B:63:0x0251} */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x01ad A:{Catch:{ all -> 0x0261 }} */
    /* JADX WARNING: Missing block: B:6:0x0038, code skipped:
            com.tencent.p177mm.pluginsdk.p592g.p593a.p1570d.C40433a.m69346e(r2);
            com.tencent.p177mm.pluginsdk.p592g.p593a.p1570d.C40433a.m69346e(r0);
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(63422);
     */
    /* JADX WARNING: Missing block: B:105:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void dgv() {
        Exception exception;
        Object obj;
        Closeable closeable;
        Closeable closeable2;
        Throwable th;
        boolean z = true;
        AppMethodBeat.m2504i(63422);
        Closeable closeable3 = null;
        try {
            this.mStatusCode = this.uVQ.getResponseCode();
            C4990ab.m7417i("MicroMsg.Wepkg.WePkgDownloadTask", "%s: received status code = %d", this.uVO.uWo, Integer.valueOf(this.mStatusCode));
            Closeable closeable4;
            switch (this.mStatusCode) {
                case 200:
                case 206:
                    long ahN;
                    boolean z2;
                    this.mContentType = this.uVQ.getHeaderField("Content-Type");
                    this.uVQ.getHeaderFields();
                    this.uVR = this.uVQ.getHeaderField("Content-Range");
                    this.uVS = this.uVQ.getHeaderField("Content-Length");
                    boolean z3 = "bytes".equals(this.uVQ.getHeaderField("Accept-Ranges")) ? true : this.uVR != null && this.uVR.startsWith("bytes");
                    if (!this.uVV) {
                        C4990ab.m7416i("MicroMsg.Wepkg.WePkgDownloadTask", "local dont have download file. not support range");
                        ahN = C14800c.ahN(this.uVS);
                        z2 = false;
                    } else if (z3) {
                        ahN = (long) C14800c.ahM(this.uVR);
                        if (ahN == -1) {
                            C4990ab.m7416i("MicroMsg.Wepkg.WePkgDownloadTask", "content-range in header is error, not support range");
                            C40433a.ajj(this.uVO.mFilePath);
                            ahN = C14800c.ahN(this.uVS);
                            z2 = false;
                        } else {
                            z2 = z3;
                        }
                    } else {
                        C4990ab.m7416i("MicroMsg.Wepkg.WePkgDownloadTask", "Header no Accept-Ranges, not support range");
                        C40433a.ajj(this.uVO.mFilePath);
                        ahN = C14800c.ahN(this.uVS);
                        z2 = z3;
                    }
                    this.uVW = z2;
                    C4990ab.m7417i("MicroMsg.Wepkg.WePkgDownloadTask", "%s: content-range = %s, content-length = %s, content-type = %s, isSupportRange = %b", this.uVO.uWo, this.uVR, this.uVS, this.mContentType, Boolean.valueOf(z2));
                    if (ahN == -1) {
                        this.retCode = 1010;
                        closeable4 = null;
                        break;
                    }
                    C4990ab.m7417i("MicroMsg.Wepkg.WePkgDownloadTask", "ServerLength(%d) and HeaderLength(%d)", Long.valueOf(this.uVO.uWs), Long.valueOf(ahN));
                    this.uVT = this.uVQ.getContentEncoding();
                    InputStream inputStream = this.uVQ.getInputStream();
                    if (C5046bo.isNullOrNil(this.uVT) || !this.uVT.contains("gzip")) {
                        closeable4 = new BufferedInputStream(inputStream);
                    } else {
                        C4990ab.m7416i("MicroMsg.Wepkg.WePkgDownloadTask", "Content encoding is gzip");
                        closeable4 = new GZIPInputStream(inputStream);
                    }
                    try {
                        String str = this.uVO.mFilePath;
                        String str2 = this.uVO.uWo;
                        if (!(this.uVV && z2)) {
                            z = false;
                        }
                        C4990ab.m7411d("MicroMsg.Wepkg.WePkgDownloadTask", "%s: getOutputStream, filePath %s", str2, str);
                        if (C5046bo.isNullOrNil(str)) {
                            FileNotFoundException fileNotFoundException = new FileNotFoundException(String.format("%s filePath is null or nil", new Object[]{str2}));
                            AppMethodBeat.m2505o(63422);
                            throw fileNotFoundException;
                        }
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str, z));
                        int i;
                        try {
                            C4990ab.m7417i("MicroMsg.Wepkg.WePkgDownloadTask", "%s: append = %b, isSupportRange = %s", this.uVO.uWo, Boolean.valueOf(this.uVV), Boolean.valueOf(z2));
                            byte[] bArr = new byte[4096];
                            i = 0;
                            while (true) {
                                int read = closeable4.read(bArr, 0, 4096);
                                if (read == -1) {
                                    C4990ab.m7417i("MicroMsg.Wepkg.WePkgDownloadTask", "%s: read count = %d", this.uVO.mUrl, Integer.valueOf(i));
                                    bufferedOutputStream.flush();
                                    C4990ab.m7417i("MicroMsg.Wepkg.WePkgDownloadTask", "%s: download complete, flush and send complete status", this.uVO.mUrl);
                                    Object closeable32 = bufferedOutputStream;
                                    break;
                                }
                                bufferedOutputStream.write(bArr, 0, read);
                                i += read;
                            }
                        } catch (Exception e) {
                            exception = e;
                            obj = bufferedOutputStream;
                            closeable = closeable4;
                            try {
                                if (!this.uVU) {
                                    this.retCode = 1001;
                                } else if (C1720g.m3540Rg().acS() == 0) {
                                    this.retCode = 1002;
                                } else {
                                    i = 1000;
                                    if (exception instanceof SSLException) {
                                        i = 1013;
                                    } else if (exception instanceof SocketTimeoutException) {
                                        i = 1003;
                                    } else if (exception instanceof UnknownHostException) {
                                        i = 1004;
                                    } else if (exception instanceof ConnectException) {
                                        i = 1005;
                                    } else if (exception instanceof SocketException) {
                                        i = 1006;
                                    } else if (exception instanceof IOException) {
                                        i = 1007;
                                    } else if (exception instanceof InterruptedException) {
                                        i = 1008;
                                    }
                                    this.retCode = i;
                                }
                                C4990ab.m7413e("MicroMsg.Wepkg.WePkgDownloadTask", "exception : %s", exception.getMessage());
                                C40433a.m69346e(closeable);
                                C40433a.m69346e(closeable2);
                                AppMethodBeat.m2505o(63422);
                                return;
                            } catch (Throwable th2) {
                                th = th2;
                                C40433a.m69346e(closeable);
                                C40433a.m69346e(closeable2);
                                AppMethodBeat.m2505o(63422);
                                throw th;
                            }
                        } catch (Throwable th22) {
                            th = th22;
                            obj = bufferedOutputStream;
                            closeable = closeable4;
                            C40433a.m69346e(closeable);
                            C40433a.m69346e(closeable2);
                            AppMethodBeat.m2505o(63422);
                            throw th;
                        }
                    } catch (Exception e2) {
                        exception = e2;
                        closeable2 = null;
                        closeable = closeable4;
                        if (!this.uVU) {
                        }
                        C4990ab.m7413e("MicroMsg.Wepkg.WePkgDownloadTask", "exception : %s", exception.getMessage());
                        C40433a.m69346e(closeable);
                        C40433a.m69346e(closeable2);
                        AppMethodBeat.m2505o(63422);
                        return;
                    } catch (Throwable th3) {
                        th = th3;
                        closeable2 = null;
                        closeable = closeable4;
                        C40433a.m69346e(closeable);
                        C40433a.m69346e(closeable2);
                        AppMethodBeat.m2505o(63422);
                        throw th;
                    }
                    break;
                default:
                    this.retCode = this.mStatusCode;
                    closeable4 = null;
                    break;
            }
        } catch (Exception e3) {
            exception = e3;
            closeable2 = null;
            closeable = null;
        } catch (Throwable th4) {
            th = th4;
            closeable2 = null;
            closeable = null;
            C40433a.m69346e(closeable);
            C40433a.m69346e(closeable2);
            AppMethodBeat.m2505o(63422);
            throw th;
        }
    }

    private static SSLContext ahL(String str) {
        AppMethodBeat.m2504i(63423);
        try {
            SSLContext instance = SSLContext.getInstance(str);
            AppMethodBeat.m2505o(63423);
            return instance;
        } catch (Exception e) {
            AppMethodBeat.m2505o(63423);
            return null;
        }
    }

    private static int ahM(String str) {
        AppMethodBeat.m2504i(63424);
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split("/");
            if (split != null && split.length == 2) {
                try {
                    int intValue = Integer.valueOf(split[1]).intValue();
                    AppMethodBeat.m2505o(63424);
                    return intValue;
                } catch (NumberFormatException e) {
                }
            }
        }
        AppMethodBeat.m2505o(63424);
        return -1;
    }

    private static long ahN(String str) {
        AppMethodBeat.m2504i(63425);
        if (!TextUtils.isEmpty(str)) {
            try {
                long longValue = Long.valueOf(str).longValue();
                AppMethodBeat.m2505o(63425);
                return longValue;
            } catch (NumberFormatException e) {
            }
        }
        AppMethodBeat.m2505o(63425);
        return -1;
    }
}
