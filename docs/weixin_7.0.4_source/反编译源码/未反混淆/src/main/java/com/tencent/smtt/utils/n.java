package com.tencent.smtt.utils;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.i;
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

public class n {

    public interface a {
        void a(int i);
    }

    public static String a(String str, Map<String, String> map, byte[] bArr, a aVar, boolean z) {
        String str2 = null;
        AppMethodBeat.i(65255);
        if (bArr == null) {
            AppMethodBeat.o(65255);
        } else {
            HttpURLConnection a = a(str, (Map) map);
            if (a != null) {
                if (z) {
                    a(a, bArr);
                } else {
                    b(a, bArr);
                }
                str2 = a(a, aVar, false);
            }
            AppMethodBeat.o(65255);
        }
        return str2;
    }

    public static String a(String str, byte[] bArr, a aVar, boolean z) {
        String c;
        String str2 = null;
        AppMethodBeat.i(65254);
        if (z) {
            try {
                c = p.a().c();
            } catch (Exception e) {
                AppMethodBeat.o(65254);
            }
        } else {
            c = o.a().b();
        }
        c = str + c;
        if (z) {
            try {
                bArr = p.a().a(bArr);
            } catch (Exception e2) {
            }
        } else {
            bArr = o.a().a(bArr);
        }
        if (bArr == null) {
            AppMethodBeat.o(65254);
        } else {
            Map hashMap = new HashMap();
            hashMap.put("Content-Type", "application/x-www-form-urlencoded");
            hashMap.put("Content-Length", String.valueOf(bArr.length));
            HttpURLConnection a = a(c, hashMap);
            if (a != null) {
                b(a, bArr);
                str2 = a(a, aVar, z);
            }
            AppMethodBeat.o(65254);
        }
        return str2;
    }

    private static String a(HttpURLConnection httpURLConnection, a aVar, boolean z) {
        String str;
        Throwable th;
        Closeable closeable;
        AppMethodBeat.i(65259);
        Closeable inflaterInputStream;
        Closeable byteArrayOutputStream;
        try {
            int responseCode = httpURLConnection.getResponseCode();
            if (aVar != null) {
                aVar.a(responseCode);
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
                        str = z ? new String(byteArrayOutputStream.toByteArray(), ProtocolPackage.ServerEncoding) : new String(o.a().c(byteArrayOutputStream.toByteArray()));
                    } catch (Throwable th2) {
                        th = th2;
                        closeable = byteArrayOutputStream;
                        a(inflaterInputStream2);
                        a(closeable);
                        AppMethodBeat.o(65259);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    closeable = null;
                    a(inflaterInputStream2);
                    a(closeable);
                    AppMethodBeat.o(65259);
                    throw th;
                }
            }
            byteArrayOutputStream = null;
            inflaterInputStream2 = null;
            str = null;
            a(inflaterInputStream2);
            a(byteArrayOutputStream);
        } catch (Throwable th32) {
            th = th32;
            closeable = null;
            inflaterInputStream2 = null;
            a(inflaterInputStream2);
            a(closeable);
            AppMethodBeat.o(65259);
            throw th;
        }
        AppMethodBeat.o(65259);
        return str;
    }

    private static HttpURLConnection a(String str, Map<String, String> map) {
        HttpURLConnection httpURLConnection;
        AppMethodBeat.i(65256);
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setConnectTimeout(i.sHCENCODEVIDEOTIMEOUT);
                if (VERSION.SDK_INT > 13) {
                    httpURLConnection.setRequestProperty("Connection", "close");
                } else {
                    httpURLConnection.setRequestProperty("http.keepAlive", "false");
                }
                for (Entry entry : map.entrySet()) {
                    httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
                AppMethodBeat.o(65256);
            } catch (Exception e) {
                AppMethodBeat.o(65256);
                return httpURLConnection;
            }
        } catch (Exception e2) {
            httpURLConnection = null;
            AppMethodBeat.o(65256);
            return httpURLConnection;
        }
        return httpURLConnection;
    }

    private static void a(Closeable closeable) {
        AppMethodBeat.i(65260);
        if (closeable != null) {
            try {
                closeable.close();
                AppMethodBeat.o(65260);
                return;
            } catch (Exception e) {
            }
        }
        AppMethodBeat.o(65260);
    }

    private static void a(HttpURLConnection httpURLConnection, byte[] bArr) {
        Throwable th;
        Closeable closeable;
        AppMethodBeat.i(65257);
        Closeable gZIPOutputStream;
        try {
            gZIPOutputStream = new GZIPOutputStream(new BufferedOutputStream(httpURLConnection.getOutputStream(), 204800));
            try {
                gZIPOutputStream.write(bArr);
                gZIPOutputStream.flush();
                a(null);
                a(gZIPOutputStream);
                AppMethodBeat.o(65257);
            } catch (Exception e) {
                a(null);
                a(gZIPOutputStream);
                AppMethodBeat.o(65257);
            } catch (Throwable th2) {
                th = th2;
                closeable = gZIPOutputStream;
                a(null);
                a(closeable);
                AppMethodBeat.o(65257);
                throw th;
            }
        } catch (Exception e2) {
            gZIPOutputStream = null;
            a(null);
            a(gZIPOutputStream);
            AppMethodBeat.o(65257);
        } catch (Throwable th3) {
            th = th3;
            closeable = null;
            a(null);
            a(closeable);
            AppMethodBeat.o(65257);
            throw th;
        }
    }

    private static void b(HttpURLConnection httpURLConnection, byte[] bArr) {
        AppMethodBeat.i(65258);
        Closeable closeable = null;
        try {
            closeable = httpURLConnection.getOutputStream();
            closeable.write(bArr);
            closeable.flush();
        } catch (Exception e) {
        } finally {
            a(closeable);
            AppMethodBeat.o(65258);
        }
    }
}
