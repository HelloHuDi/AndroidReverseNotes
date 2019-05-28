package com.tencent.p177mm.plugin.webview.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

/* renamed from: com.tencent.mm.plugin.webview.preload.d */
public final class C43927d {
    public static int upM = 30000;
    public static int upN = 30000;

    /* renamed from: com.tencent.mm.plugin.webview.preload.d$a */
    public static class C4560a {
        public String data = "";
        public Map<String, String> ipC = new HashMap();
        public int statusCode;

        public C4560a() {
            AppMethodBeat.m2504i(7041);
            AppMethodBeat.m2505o(7041);
        }
    }

    /* renamed from: a */
    public static C4560a m78796a(String str, Map<String, String> map, String str2) {
        Closeable closeable;
        Throwable th;
        AppMethodBeat.m2504i(7042);
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(upM);
            httpURLConnection.setReadTimeout(upN);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            if (map != null && map.size() > 0) {
                for (String str3 : map.keySet()) {
                    httpURLConnection.setRequestProperty(str3, (String) map.get(str3));
                }
            }
            byte[] bytes = str2.getBytes();
            httpURLConnection.connect();
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(bytes);
            dataOutputStream.flush();
            C4560a c4560a = new C4560a();
            c4560a.statusCode = httpURLConnection.getResponseCode();
            if (c4560a.statusCode == 200) {
                Closeable f;
                try {
                    f = C43927d.m78797f(httpURLConnection.getContentEncoding(), httpURLConnection.getInputStream());
                    try {
                        c4560a.data = C43927d.convertStreamToString(f);
                        C43927d.closeQuietly(f);
                    } catch (IOException e) {
                        closeable = f;
                        C43927d.closeQuietly(closeable);
                        AppMethodBeat.m2505o(7042);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        C43927d.closeQuietly(f);
                        AppMethodBeat.m2505o(7042);
                        throw th;
                    }
                } catch (IOException e2) {
                    closeable = null;
                } catch (Throwable th3) {
                    th = th3;
                    f = null;
                    C43927d.closeQuietly(f);
                    AppMethodBeat.m2505o(7042);
                    throw th;
                }
            }
            int i = 0;
            while (true) {
                String headerFieldKey = httpURLConnection.getHeaderFieldKey(i);
                String headerField = httpURLConnection.getHeaderField(i);
                if (headerFieldKey == null && headerField == null) {
                    AppMethodBeat.m2505o(7042);
                    return c4560a;
                }
                c4560a.ipC.put(headerFieldKey, headerField);
                i++;
            }
        } catch (MalformedURLException e3) {
            C4990ab.m7409c("MicroMsg.RequestUtil", "", e3);
            AppMethodBeat.m2505o(7042);
            return null;
        } catch (IOException e4) {
            C4990ab.m7409c("MicroMsg.RequestUtil", "", e4);
            AppMethodBeat.m2505o(7042);
            return null;
        } catch (Exception e5) {
            C4990ab.m7409c("MicroMsg.RequestUtil", "", e5);
            AppMethodBeat.m2505o(7042);
            return null;
        }
    }

    /* renamed from: w */
    public static C4560a m78798w(String str, Map<String, String> map) {
        Closeable closeable;
        Throwable th;
        AppMethodBeat.m2504i(7043);
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            if (httpURLConnection == null) {
                AppMethodBeat.m2505o(7043);
                return null;
            }
            httpURLConnection.setConnectTimeout(upM);
            httpURLConnection.setReadTimeout(upN);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setUseCaches(false);
            if (map != null && map.size() > 0) {
                for (String str2 : map.keySet()) {
                    httpURLConnection.setRequestProperty(str2, (String) map.get(str2));
                }
            }
            C4560a c4560a = new C4560a();
            c4560a.statusCode = httpURLConnection.getResponseCode();
            if (c4560a.statusCode == 200) {
                Closeable f;
                try {
                    f = C43927d.m78797f(httpURLConnection.getContentEncoding(), httpURLConnection.getInputStream());
                    try {
                        c4560a.data = C43927d.convertStreamToString(f);
                        C43927d.closeQuietly(f);
                    } catch (IOException e) {
                        closeable = f;
                        C43927d.closeQuietly(closeable);
                        AppMethodBeat.m2505o(7043);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        C43927d.closeQuietly(f);
                        AppMethodBeat.m2505o(7043);
                        throw th;
                    }
                } catch (IOException e2) {
                    closeable = null;
                } catch (Throwable th3) {
                    th = th3;
                    f = null;
                    C43927d.closeQuietly(f);
                    AppMethodBeat.m2505o(7043);
                    throw th;
                }
            }
            int i = 0;
            while (true) {
                String headerFieldKey = httpURLConnection.getHeaderFieldKey(i);
                String headerField = httpURLConnection.getHeaderField(i);
                if (headerFieldKey == null && headerField == null) {
                    AppMethodBeat.m2505o(7043);
                    return c4560a;
                }
                c4560a.ipC.put(headerFieldKey, headerField);
                i++;
            }
        } catch (MalformedURLException e3) {
            C4990ab.m7409c("MicroMsg.RequestUtil", "", e3);
            AppMethodBeat.m2505o(7043);
            return null;
        } catch (IOException e4) {
            C4990ab.m7409c("MicroMsg.RequestUtil", "", e4);
            AppMethodBeat.m2505o(7043);
            return null;
        } catch (Exception e5) {
            C4990ab.m7409c("MicroMsg.RequestUtil", "", e5);
            AppMethodBeat.m2505o(7043);
            return null;
        }
    }

    /* renamed from: f */
    private static InputStream m78797f(String str, InputStream inputStream) {
        AppMethodBeat.m2504i(7044);
        InputStream gZIPInputStream;
        if (str == null || "identity".equalsIgnoreCase(str)) {
            AppMethodBeat.m2505o(7044);
            return inputStream;
        } else if ("gzip".equalsIgnoreCase(str)) {
            gZIPInputStream = new GZIPInputStream(inputStream);
            AppMethodBeat.m2505o(7044);
            return gZIPInputStream;
        } else if ("deflate".equalsIgnoreCase(str)) {
            gZIPInputStream = new InflaterInputStream(inputStream, new Inflater(false), 512);
            AppMethodBeat.m2505o(7044);
            return gZIPInputStream;
        } else {
            RuntimeException runtimeException = new RuntimeException("unsupported content-encoding: ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(7044);
            throw runtimeException;
        }
    }

    private static String convertStreamToString(InputStream inputStream) {
        AppMethodBeat.m2504i(7045);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader, 512);
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    stringBuilder.append(readLine + IOUtils.LINE_SEPARATOR_UNIX);
                } else {
                    C43927d.closeQuietly(inputStreamReader);
                    C43927d.closeQuietly(bufferedReader);
                    String stringBuilder2 = stringBuilder.toString();
                    AppMethodBeat.m2505o(7045);
                    return stringBuilder2;
                }
            } catch (IOException e) {
                C4990ab.m7409c("MicroMsg.RequestUtil", "", e);
                return null;
            } catch (Exception e2) {
                C4990ab.m7409c("MicroMsg.RequestUtil", "", e2);
                return null;
            } finally {
                C43927d.closeQuietly(inputStreamReader);
                C43927d.closeQuietly(bufferedReader);
                AppMethodBeat.m2505o(7045);
            }
        }
    }

    private static void closeQuietly(Closeable closeable) {
        AppMethodBeat.m2504i(7046);
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                C4990ab.m7409c("MicroMsg.RequestUtil", "", e);
                AppMethodBeat.m2505o(7046);
                return;
            } catch (Exception e2) {
                C4990ab.m7409c("MicroMsg.RequestUtil", "", e2);
                AppMethodBeat.m2505o(7046);
                return;
            }
        }
        AppMethodBeat.m2505o(7046);
    }
}
