package com.tencent.smtt.utils;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.hardcoder.C1625i;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

/* renamed from: com.tencent.smtt.utils.n */
public class C44463n {

    /* renamed from: com.tencent.smtt.utils.n$a */
    public interface C24288a {
        /* renamed from: a */
        void mo12147a(int i);
    }

    /* renamed from: a */
    public static String m80449a(String str, Map<String, String> map, byte[] bArr, C24288a c24288a, boolean z) {
        String str2 = null;
        AppMethodBeat.m2504i(65255);
        if (bArr == null) {
            AppMethodBeat.m2505o(65255);
        } else {
            HttpURLConnection a = C44463n.m80452a(str, (Map) map);
            if (a != null) {
                if (z) {
                    C44463n.m80454a(a, bArr);
                } else {
                    C44463n.m80455b(a, bArr);
                }
                str2 = C44463n.m80451a(a, c24288a, false);
            }
            AppMethodBeat.m2505o(65255);
        }
        return str2;
    }

    /* renamed from: a */
    public static String m80450a(String str, byte[] bArr, C24288a c24288a, boolean z) {
        String c;
        String str2 = null;
        AppMethodBeat.m2504i(65254);
        if (z) {
            try {
                c = C46743p.m88599a().mo75293c();
            } catch (Exception e) {
                AppMethodBeat.m2505o(65254);
            }
        } else {
            c = C44464o.m80456a().mo70638b();
        }
        c = str + c;
        if (z) {
            try {
                bArr = C46743p.m88599a().mo75291a(bArr);
            } catch (Exception e2) {
            }
        } else {
            bArr = C44464o.m80456a().mo70637a(bArr);
        }
        if (bArr == null) {
            AppMethodBeat.m2505o(65254);
        } else {
            Map hashMap = new HashMap();
            hashMap.put("Content-Type", "application/x-www-form-urlencoded");
            hashMap.put("Content-Length", String.valueOf(bArr.length));
            HttpURLConnection a = C44463n.m80452a(c, hashMap);
            if (a != null) {
                C44463n.m80455b(a, bArr);
                str2 = C44463n.m80451a(a, c24288a, z);
            }
            AppMethodBeat.m2505o(65254);
        }
        return str2;
    }

    /* renamed from: a */
    private static String m80451a(HttpURLConnection httpURLConnection, C24288a c24288a, boolean z) {
        String str;
        Throwable th;
        Closeable closeable;
        AppMethodBeat.m2504i(65259);
        Closeable inflaterInputStream;
        Closeable byteArrayOutputStream;
        try {
            int responseCode = httpURLConnection.getResponseCode();
            if (c24288a != null) {
                c24288a.mo12147a(responseCode);
            }
            if (responseCode == 200) {
                InputStream inputStream = httpURLConnection.getInputStream();
                String contentEncoding = httpURLConnection.getContentEncoding();
                if (contentEncoding == null || !contentEncoding.equalsIgnoreCase("gzip")) {
                    if (contentEncoding != null) {
                        if (contentEncoding.equalsIgnoreCase("deflate")) {
                            inflaterInputStream = new InflaterInputStream(inputStream, new Inflater(true));
                        }
                    }
                    Object inflaterInputStream2 = inputStream;
                } else {
                    inflaterInputStream2 = new GZIPInputStream(inputStream);
                }
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        byte[] bArr = new byte[128];
                        while (true) {
                            int read = inflaterInputStream2.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                        str = z ? new String(byteArrayOutputStream.toByteArray(), ProtocolPackage.ServerEncoding) : new String(C44464o.m80456a().mo70639c(byteArrayOutputStream.toByteArray()));
                    } catch (Throwable th2) {
                        th = th2;
                        closeable = byteArrayOutputStream;
                        C44463n.m80453a(inflaterInputStream2);
                        C44463n.m80453a(closeable);
                        AppMethodBeat.m2505o(65259);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    closeable = null;
                    C44463n.m80453a(inflaterInputStream2);
                    C44463n.m80453a(closeable);
                    AppMethodBeat.m2505o(65259);
                    throw th;
                }
            }
            byteArrayOutputStream = null;
            inflaterInputStream2 = null;
            str = null;
            C44463n.m80453a(inflaterInputStream2);
            C44463n.m80453a(byteArrayOutputStream);
        } catch (Throwable th32) {
            th = th32;
            closeable = null;
            inflaterInputStream2 = null;
            C44463n.m80453a(inflaterInputStream2);
            C44463n.m80453a(closeable);
            AppMethodBeat.m2505o(65259);
            throw th;
        }
        AppMethodBeat.m2505o(65259);
        return str;
    }

    /* renamed from: a */
    private static HttpURLConnection m80452a(String str, Map<String, String> map) {
        HttpURLConnection httpURLConnection;
        AppMethodBeat.m2504i(65256);
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setConnectTimeout(C1625i.sHCENCODEVIDEOTIMEOUT);
                if (VERSION.SDK_INT > 13) {
                    httpURLConnection.setRequestProperty("Connection", "close");
                } else {
                    httpURLConnection.setRequestProperty("http.keepAlive", "false");
                }
                for (Entry entry : map.entrySet()) {
                    httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
                AppMethodBeat.m2505o(65256);
            } catch (Exception e) {
                AppMethodBeat.m2505o(65256);
                return httpURLConnection;
            }
        } catch (Exception e2) {
            httpURLConnection = null;
            AppMethodBeat.m2505o(65256);
            return httpURLConnection;
        }
        return httpURLConnection;
    }

    /* renamed from: a */
    private static void m80453a(Closeable closeable) {
        AppMethodBeat.m2504i(65260);
        if (closeable != null) {
            try {
                closeable.close();
                AppMethodBeat.m2505o(65260);
                return;
            } catch (Exception e) {
            }
        }
        AppMethodBeat.m2505o(65260);
    }

    /* renamed from: a */
    private static void m80454a(HttpURLConnection httpURLConnection, byte[] bArr) {
        Throwable th;
        Closeable closeable;
        AppMethodBeat.m2504i(65257);
        Closeable gZIPOutputStream;
        try {
            gZIPOutputStream = new GZIPOutputStream(new BufferedOutputStream(httpURLConnection.getOutputStream(), 204800));
            try {
                gZIPOutputStream.write(bArr);
                gZIPOutputStream.flush();
                C44463n.m80453a(null);
                C44463n.m80453a(gZIPOutputStream);
                AppMethodBeat.m2505o(65257);
            } catch (Exception e) {
                C44463n.m80453a(null);
                C44463n.m80453a(gZIPOutputStream);
                AppMethodBeat.m2505o(65257);
            } catch (Throwable th2) {
                th = th2;
                closeable = gZIPOutputStream;
                C44463n.m80453a(null);
                C44463n.m80453a(closeable);
                AppMethodBeat.m2505o(65257);
                throw th;
            }
        } catch (Exception e2) {
            gZIPOutputStream = null;
            C44463n.m80453a(null);
            C44463n.m80453a(gZIPOutputStream);
            AppMethodBeat.m2505o(65257);
        } catch (Throwable th3) {
            th = th3;
            closeable = null;
            C44463n.m80453a(null);
            C44463n.m80453a(closeable);
            AppMethodBeat.m2505o(65257);
            throw th;
        }
    }

    /* renamed from: b */
    private static void m80455b(HttpURLConnection httpURLConnection, byte[] bArr) {
        AppMethodBeat.m2504i(65258);
        Closeable closeable = null;
        try {
            closeable = httpURLConnection.getOutputStream();
            closeable.write(bArr);
            closeable.flush();
        } catch (Exception e) {
        } finally {
            C44463n.m80453a(closeable);
            AppMethodBeat.m2505o(65258);
        }
    }
}
