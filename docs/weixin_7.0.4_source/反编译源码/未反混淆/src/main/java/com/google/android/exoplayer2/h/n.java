package com.google.android.exoplayer2.h;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.d.b;
import com.google.android.exoplayer2.h.r.c;
import com.google.android.exoplayer2.h.r.d;
import com.google.android.exoplayer2.h.r.e;
import com.google.android.exoplayer2.h.r.f;
import com.google.android.exoplayer2.i.v;
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

public final class n implements r {
    private static final Pattern bqr = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private static final AtomicReference<byte[]> bqs = new AtomicReference();
    private InputStream azC;
    private i bib;
    private final u<? super n> bpJ;
    private long bqA;
    private long bqB;
    private long bqC;
    private final boolean bqt;
    private final int bqu;
    private final int bqv;
    private final com.google.android.exoplayer2.i.n<String> bqw;
    private final f bqx;
    private final f bqy;
    private long bqz;
    private HttpURLConnection connection;
    private boolean opened;
    private final String userAgent;

    static {
        AppMethodBeat.i(95833);
        AppMethodBeat.o(95833);
    }

    public n(String str, u<? super n> uVar, int i, int i2, boolean z, f fVar) {
        AppMethodBeat.i(95825);
        if (TextUtils.isEmpty(str)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
            AppMethodBeat.o(95825);
            throw illegalArgumentException;
        }
        this.userAgent = str;
        this.bqw = null;
        this.bpJ = uVar;
        this.bqy = new f();
        this.bqu = i;
        this.bqv = i2;
        this.bqt = z;
        this.bqx = fVar;
        AppMethodBeat.o(95825);
    }

    public final Uri getUri() {
        AppMethodBeat.i(95826);
        if (this.connection == null) {
            AppMethodBeat.o(95826);
            return null;
        }
        Uri parse = Uri.parse(this.connection.getURL().toString());
        AppMethodBeat.o(95826);
        return parse;
    }

    public final long a(i iVar) {
        c cVar;
        AppMethodBeat.i(95827);
        this.bib = iVar;
        this.bqC = 0;
        this.bqB = 0;
        try {
            int i;
            HttpURLConnection a;
            URL url = new URL(iVar.uri.toString());
            byte[] bArr = iVar.bpP;
            long j = iVar.position;
            long j2 = iVar.bgY;
            boolean to = iVar.to();
            if (this.bqt) {
                i = 0;
                while (true) {
                    int i2 = i + 1;
                    if (i <= 20) {
                        a = a(url, bArr, j, j2, to, false);
                        int responseCode = a.getResponseCode();
                        if (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303 && (bArr != null || (responseCode != 307 && responseCode != 308))) {
                            break;
                        }
                        bArr = null;
                        String headerField = a.getHeaderField("Location");
                        a.disconnect();
                        if (headerField == null) {
                            ProtocolException protocolException = new ProtocolException("Null location redirect");
                            AppMethodBeat.o(95827);
                            throw protocolException;
                        }
                        URL url2 = new URL(url, headerField);
                        String protocol = url2.getProtocol();
                        if ("https".equals(protocol) || "http".equals(protocol)) {
                            i = i2;
                            url = url2;
                        } else {
                            ProtocolException protocolException2 = new ProtocolException("Unsupported protocol redirect: ".concat(String.valueOf(protocol)));
                            AppMethodBeat.o(95827);
                            throw protocolException2;
                        }
                    }
                    NoRouteToHostException noRouteToHostException = new NoRouteToHostException("Too many redirects: ".concat(String.valueOf(i2)));
                    AppMethodBeat.o(95827);
                    throw noRouteToHostException;
                }
            }
            a = a(url, bArr, j, j2, to, true);
            this.connection = a;
            try {
                i = this.connection.getResponseCode();
                b.i("DefaultHttpDataSource", "open, responseCode:%d", Integer.valueOf(i));
                if (i < 200 || i > 299) {
                    Map headerFields = this.connection.getHeaderFields();
                    tu();
                    e eVar = new e(i, headerFields, iVar);
                    if (i == 416) {
                        eVar.initCause(new g());
                    }
                    AppMethodBeat.o(95827);
                    throw eVar;
                }
                String contentType = this.connection.getContentType();
                if (this.bqw == null || this.bqw.af(contentType)) {
                    long j3 = (i != 200 || iVar.position == 0) ? 0 : iVar.position;
                    this.bqz = j3;
                    if (iVar.to()) {
                        this.bqA = iVar.bgY;
                    } else if (iVar.bgY != -1) {
                        this.bqA = iVar.bgY;
                    } else {
                        j3 = a(this.connection);
                        this.bqA = j3 != -1 ? j3 - this.bqz : -1;
                    }
                    try {
                        this.azC = this.connection.getInputStream();
                        this.opened = true;
                        if (this.bpJ != null) {
                            this.bpJ.tq();
                        }
                        j3 = this.bqA;
                        AppMethodBeat.o(95827);
                        return j3;
                    } catch (IOException e) {
                        tu();
                        cVar = new c(e, iVar, 1);
                        AppMethodBeat.o(95827);
                        throw cVar;
                    }
                }
                tu();
                d dVar = new d(contentType, iVar);
                AppMethodBeat.o(95827);
                throw dVar;
            } catch (IOException e2) {
                tu();
                cVar = new c("Unable to connect to " + iVar.uri.toString(), e2, iVar);
                AppMethodBeat.o(95827);
                throw cVar;
            }
        } catch (IOException e22) {
            cVar = new c("Unable to connect to " + iVar.uri.toString(), e22, iVar);
            AppMethodBeat.o(95827);
            throw cVar;
        }
    }

    public final void close() {
        AppMethodBeat.i(95829);
        try {
            if (this.azC != null) {
                long j;
                HttpURLConnection httpURLConnection = this.connection;
                if (this.bqA == -1) {
                    j = this.bqA;
                } else {
                    j = this.bqA - this.bqC;
                }
                if (v.SDK_INT == 19 || v.SDK_INT == 20) {
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
            tu();
            if (this.opened) {
                this.opened = false;
                if (this.bpJ != null) {
                    this.bpJ.tr();
                    AppMethodBeat.o(95829);
                    return;
                }
            }
            AppMethodBeat.o(95829);
        } catch (IOException e2) {
            c cVar = new c(e2, this.bib, 3);
            AppMethodBeat.o(95829);
            throw cVar;
        } catch (Throwable th) {
            this.azC = null;
            tu();
            if (this.opened) {
                this.opened = false;
                if (this.bpJ != null) {
                    this.bpJ.tr();
                }
            }
            AppMethodBeat.o(95829);
        }
    }

    private HttpURLConnection a(URL url, byte[] bArr, long j, long j2, boolean z, boolean z2) {
        AppMethodBeat.i(95830);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.bqu);
        httpURLConnection.setReadTimeout(this.bqv);
        if (this.bqx != null) {
            for (Entry entry : this.bqx.tv().entrySet()) {
                httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
        }
        for (Entry entry2 : this.bqy.tv().entrySet()) {
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
                AppMethodBeat.o(95830);
                return httpURLConnection;
            }
        }
        httpURLConnection.connect();
        AppMethodBeat.o(95830);
        return httpURLConnection;
    }

    private static long a(HttpURLConnection httpURLConnection) {
        AppMethodBeat.i(95831);
        long j = -1;
        String headerField = httpURLConnection.getHeaderField("Content-Length");
        if (!TextUtils.isEmpty(headerField)) {
            try {
                j = Long.parseLong(headerField);
            } catch (NumberFormatException e) {
                b.e("DefaultHttpDataSource", "Unexpected Content-Length [" + headerField + "]", new Object[0]);
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
                        b.w("DefaultHttpDataSource", "Inconsistent headers [" + headerField + "] [" + headerField2 + "]", new Object[0]);
                        j = Math.max(j, parseLong);
                    }
                } catch (NumberFormatException e2) {
                    b.e("DefaultHttpDataSource", "Unexpected Content-Range [" + headerField2 + "]", new Object[0]);
                }
            }
        }
        AppMethodBeat.o(95831);
        return j;
    }

    private void tu() {
        AppMethodBeat.i(95832);
        if (this.connection != null) {
            try {
                this.connection.disconnect();
            } catch (Exception e) {
                b.e("DefaultHttpDataSource", "Unexpected error while disconnecting", e);
            }
            this.connection = null;
        }
        AppMethodBeat.o(95832);
    }

    public final int read(byte[] bArr, int i, int i2) {
        AppMethodBeat.i(95828);
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
                        AppMethodBeat.o(95828);
                        throw interruptedIOException;
                    } else if (read == -1) {
                        eOFException = new EOFException();
                        AppMethodBeat.o(95828);
                        throw eOFException;
                    } else {
                        this.bqB += (long) read;
                        if (this.bpJ != null) {
                            this.bpJ.eK(read);
                        }
                    }
                }
                bqs.set(bArr2);
            }
            if (i2 == 0) {
                AppMethodBeat.o(95828);
                return 0;
            }
            if (this.bqA != -1) {
                long j = this.bqA - this.bqC;
                if (j == 0) {
                    AppMethodBeat.o(95828);
                    return -1;
                }
                i2 = (int) Math.min((long) i2, j);
            }
            int read2 = this.azC.read(bArr, i, i2);
            if (read2 != -1) {
                this.bqC += (long) read2;
                if (this.bpJ != null) {
                    this.bpJ.eK(read2);
                }
                AppMethodBeat.o(95828);
                return read2;
            } else if (this.bqA != -1) {
                eOFException = new EOFException();
                AppMethodBeat.o(95828);
                throw eOFException;
            } else {
                AppMethodBeat.o(95828);
                return -1;
            }
        } catch (IOException e) {
            c cVar = new c(e, this.bib, 2);
            AppMethodBeat.o(95828);
            throw cVar;
        }
    }
}
