package com.google.android.exoplayer2.p110h;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.p110h.C17668r.C17670e;
import com.google.android.exoplayer2.p110h.C17668r.C17671d;
import com.google.android.exoplayer2.p110h.C17668r.C17672f;
import com.google.android.exoplayer2.p110h.C17668r.C8682c;
import com.google.android.exoplayer2.p111i.C17675v;
import com.google.android.exoplayer2.p111i.C8686n;
import com.google.android.exoplayer2.p1585d.C41599b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.google.android.exoplayer2.h.n */
public final class C24652n implements C17668r {
    private static final Pattern bqr = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private static final AtomicReference<byte[]> bqs = new AtomicReference();
    private InputStream azC;
    private C17665i bib;
    private final C41615u<? super C24652n> bpJ;
    private long bqA;
    private long bqB;
    private long bqC;
    private final boolean bqt;
    private final int bqu;
    private final int bqv;
    private final C8686n<String> bqw;
    private final C17672f bqx;
    private final C17672f bqy;
    private long bqz;
    private HttpURLConnection connection;
    private boolean opened;
    private final String userAgent;

    static {
        AppMethodBeat.m2504i(95833);
        AppMethodBeat.m2505o(95833);
    }

    public C24652n(String str, C41615u<? super C24652n> c41615u, int i, int i2, boolean z, C17672f c17672f) {
        AppMethodBeat.m2504i(95825);
        if (TextUtils.isEmpty(str)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
            AppMethodBeat.m2505o(95825);
            throw illegalArgumentException;
        }
        this.userAgent = str;
        this.bqw = null;
        this.bpJ = c41615u;
        this.bqy = new C17672f();
        this.bqu = i;
        this.bqv = i2;
        this.bqt = z;
        this.bqx = c17672f;
        AppMethodBeat.m2505o(95825);
    }

    public final Uri getUri() {
        AppMethodBeat.m2504i(95826);
        if (this.connection == null) {
            AppMethodBeat.m2505o(95826);
            return null;
        }
        Uri parse = Uri.parse(this.connection.getURL().toString());
        AppMethodBeat.m2505o(95826);
        return parse;
    }

    /* renamed from: a */
    public final long mo2583a(C17665i c17665i) {
        C8682c c8682c;
        AppMethodBeat.m2504i(95827);
        this.bib = c17665i;
        this.bqC = 0;
        this.bqB = 0;
        try {
            int i;
            HttpURLConnection a;
            URL url = new URL(c17665i.uri.toString());
            byte[] bArr = c17665i.bpP;
            long j = c17665i.position;
            long j2 = c17665i.bgY;
            boolean to = c17665i.mo32359to();
            if (this.bqt) {
                i = 0;
                while (true) {
                    int i2 = i + 1;
                    if (i <= 20) {
                        a = m38379a(url, bArr, j, j2, to, false);
                        int responseCode = a.getResponseCode();
                        if (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303 && (bArr != null || (responseCode != 307 && responseCode != 308))) {
                            break;
                        }
                        bArr = null;
                        String headerField = a.getHeaderField("Location");
                        a.disconnect();
                        if (headerField == null) {
                            ProtocolException protocolException = new ProtocolException("Null location redirect");
                            AppMethodBeat.m2505o(95827);
                            throw protocolException;
                        }
                        URL url2 = new URL(url, headerField);
                        String protocol = url2.getProtocol();
                        if ("https".equals(protocol) || "http".equals(protocol)) {
                            i = i2;
                            url = url2;
                        } else {
                            ProtocolException protocolException2 = new ProtocolException("Unsupported protocol redirect: ".concat(String.valueOf(protocol)));
                            AppMethodBeat.m2505o(95827);
                            throw protocolException2;
                        }
                    }
                    NoRouteToHostException noRouteToHostException = new NoRouteToHostException("Too many redirects: ".concat(String.valueOf(i2)));
                    AppMethodBeat.m2505o(95827);
                    throw noRouteToHostException;
                }
            }
            a = m38379a(url, bArr, j, j2, to, true);
            this.connection = a;
            try {
                i = this.connection.getResponseCode();
                C41599b.m72864i("DefaultHttpDataSource", "open, responseCode:%d", Integer.valueOf(i));
                if (i < 200 || i > 299) {
                    Map headerFields = this.connection.getHeaderFields();
                    m38380tu();
                    C17670e c17670e = new C17670e(i, headerFields, c17665i);
                    if (i == 416) {
                        c17670e.initCause(new C8680g());
                    }
                    AppMethodBeat.m2505o(95827);
                    throw c17670e;
                }
                String contentType = this.connection.getContentType();
                if (this.bqw == null || this.bqw.mo19224af(contentType)) {
                    long j3 = (i != 200 || c17665i.position == 0) ? 0 : c17665i.position;
                    this.bqz = j3;
                    if (c17665i.mo32359to()) {
                        this.bqA = c17665i.bgY;
                    } else if (c17665i.bgY != -1) {
                        this.bqA = c17665i.bgY;
                    } else {
                        j3 = C24652n.m38378a(this.connection);
                        this.bqA = j3 != -1 ? j3 - this.bqz : -1;
                    }
                    try {
                        this.azC = this.connection.getInputStream();
                        this.opened = true;
                        if (this.bpJ != null) {
                            this.bpJ.mo59502tq();
                        }
                        j3 = this.bqA;
                        AppMethodBeat.m2505o(95827);
                        return j3;
                    } catch (IOException e) {
                        m38380tu();
                        c8682c = new C8682c(e, c17665i, 1);
                        AppMethodBeat.m2505o(95827);
                        throw c8682c;
                    }
                }
                m38380tu();
                C17671d c17671d = new C17671d(contentType, c17665i);
                AppMethodBeat.m2505o(95827);
                throw c17671d;
            } catch (IOException e2) {
                m38380tu();
                c8682c = new C8682c("Unable to connect to " + c17665i.uri.toString(), e2, c17665i);
                AppMethodBeat.m2505o(95827);
                throw c8682c;
            }
        } catch (IOException e22) {
            c8682c = new C8682c("Unable to connect to " + c17665i.uri.toString(), e22, c17665i);
            AppMethodBeat.m2505o(95827);
            throw c8682c;
        }
    }

    public final void close() {
        AppMethodBeat.m2504i(95829);
        try {
            if (this.azC != null) {
                long j;
                HttpURLConnection httpURLConnection = this.connection;
                if (this.bqA == -1) {
                    j = this.bqA;
                } else {
                    j = this.bqA - this.bqC;
                }
                if (C17675v.SDK_INT == 19 || C17675v.SDK_INT == 20) {
                    try {
                        InputStream inputStream = httpURLConnection.getInputStream();
                        if (j != -1 ? j <= 2048 : inputStream.read() == -1) {
                            String name = inputStream.getClass().getName();
                            if (name.equals("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream") || name.equals("com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream")) {
                                Method declaredMethod = inputStream.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                                declaredMethod.setAccessible(true);
                                declaredMethod.invoke(inputStream, new Object[0]);
                            }
                        }
                    } catch (Exception e) {
                    }
                }
                this.azC.close();
            }
            this.azC = null;
            m38380tu();
            if (this.opened) {
                this.opened = false;
                if (this.bpJ != null) {
                    this.bpJ.mo59503tr();
                    AppMethodBeat.m2505o(95829);
                    return;
                }
            }
            AppMethodBeat.m2505o(95829);
        } catch (IOException e2) {
            C8682c c8682c = new C8682c(e2, this.bib, 3);
            AppMethodBeat.m2505o(95829);
            throw c8682c;
        } catch (Throwable th) {
            this.azC = null;
            m38380tu();
            if (this.opened) {
                this.opened = false;
                if (this.bpJ != null) {
                    this.bpJ.mo59503tr();
                }
            }
            AppMethodBeat.m2505o(95829);
        }
    }

    /* renamed from: a */
    private HttpURLConnection m38379a(URL url, byte[] bArr, long j, long j2, boolean z, boolean z2) {
        AppMethodBeat.m2504i(95830);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.bqu);
        httpURLConnection.setReadTimeout(this.bqv);
        if (this.bqx != null) {
            for (Entry entry : this.bqx.mo32361tv().entrySet()) {
                httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
        }
        for (Entry entry2 : this.bqy.mo32361tv().entrySet()) {
            httpURLConnection.setRequestProperty((String) entry2.getKey(), (String) entry2.getValue());
        }
        if (!(j == 0 && j2 == -1)) {
            String str = "bytes=" + j + "-";
            if (j2 != -1) {
                str = str + ((j + j2) - 1);
            }
            httpURLConnection.setRequestProperty("Range", str);
        }
        httpURLConnection.setRequestProperty("User-Agent", this.userAgent);
        if (!z) {
            httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
        }
        httpURLConnection.setInstanceFollowRedirects(z2);
        httpURLConnection.setDoOutput(bArr != null);
        if (bArr != null) {
            httpURLConnection.setRequestMethod("POST");
            if (bArr.length != 0) {
                httpURLConnection.setFixedLengthStreamingMode(bArr.length);
                httpURLConnection.connect();
                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(bArr);
                outputStream.close();
                AppMethodBeat.m2505o(95830);
                return httpURLConnection;
            }
        }
        httpURLConnection.connect();
        AppMethodBeat.m2505o(95830);
        return httpURLConnection;
    }

    /* renamed from: a */
    private static long m38378a(HttpURLConnection httpURLConnection) {
        AppMethodBeat.m2504i(95831);
        long j = -1;
        String headerField = httpURLConnection.getHeaderField("Content-Length");
        if (!TextUtils.isEmpty(headerField)) {
            try {
                j = Long.parseLong(headerField);
            } catch (NumberFormatException e) {
                C41599b.m72863e("DefaultHttpDataSource", "Unexpected Content-Length [" + headerField + "]", new Object[0]);
            }
        }
        String headerField2 = httpURLConnection.getHeaderField("Content-Range");
        if (!TextUtils.isEmpty(headerField2)) {
            Matcher matcher = bqr.matcher(headerField2);
            if (matcher.find()) {
                try {
                    long parseLong = (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
                    if (j < 0) {
                        j = parseLong;
                    } else if (j != parseLong) {
                        C41599b.m72865w("DefaultHttpDataSource", "Inconsistent headers [" + headerField + "] [" + headerField2 + "]", new Object[0]);
                        j = Math.max(j, parseLong);
                    }
                } catch (NumberFormatException e2) {
                    C41599b.m72863e("DefaultHttpDataSource", "Unexpected Content-Range [" + headerField2 + "]", new Object[0]);
                }
            }
        }
        AppMethodBeat.m2505o(95831);
        return j;
    }

    /* renamed from: tu */
    private void m38380tu() {
        AppMethodBeat.m2504i(95832);
        if (this.connection != null) {
            try {
                this.connection.disconnect();
            } catch (Exception e) {
                C41599b.m72863e("DefaultHttpDataSource", "Unexpected error while disconnecting", e);
            }
            this.connection = null;
        }
        AppMethodBeat.m2505o(95832);
    }

    public final int read(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(95828);
        try {
            EOFException eOFException;
            if (this.bqB != this.bqz) {
                byte[] bArr2 = (byte[]) bqs.getAndSet(null);
                if (bArr2 == null) {
                    bArr2 = new byte[4096];
                }
                while (this.bqB != this.bqz) {
                    int read = this.azC.read(bArr2, 0, (int) Math.min(this.bqz - this.bqB, (long) bArr2.length));
                    if (Thread.interrupted()) {
                        InterruptedIOException interruptedIOException = new InterruptedIOException();
                        AppMethodBeat.m2505o(95828);
                        throw interruptedIOException;
                    } else if (read == -1) {
                        eOFException = new EOFException();
                        AppMethodBeat.m2505o(95828);
                        throw eOFException;
                    } else {
                        this.bqB += (long) read;
                        if (this.bpJ != null) {
                            this.bpJ.mo59501eK(read);
                        }
                    }
                }
                bqs.set(bArr2);
            }
            if (i2 == 0) {
                AppMethodBeat.m2505o(95828);
                return 0;
            }
            if (this.bqA != -1) {
                long j = this.bqA - this.bqC;
                if (j == 0) {
                    AppMethodBeat.m2505o(95828);
                    return -1;
                }
                i2 = (int) Math.min((long) i2, j);
            }
            int read2 = this.azC.read(bArr, i, i2);
            if (read2 != -1) {
                this.bqC += (long) read2;
                if (this.bpJ != null) {
                    this.bpJ.mo59501eK(read2);
                }
                AppMethodBeat.m2505o(95828);
                return read2;
            } else if (this.bqA != -1) {
                eOFException = new EOFException();
                AppMethodBeat.m2505o(95828);
                throw eOFException;
            } else {
                AppMethodBeat.m2505o(95828);
                return -1;
            }
        } catch (IOException e) {
            C8682c c8682c = new C8682c(e, this.bib, 2);
            AppMethodBeat.m2505o(95828);
            throw c8682c;
        }
    }
}
