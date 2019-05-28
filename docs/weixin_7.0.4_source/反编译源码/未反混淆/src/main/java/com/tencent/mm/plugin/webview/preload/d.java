package com.tencent.mm.plugin.webview.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
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

public final class d {
    public static int upM = 30000;
    public static int upN = 30000;

    public static class a {
        public String data = "";
        public Map<String, String> ipC = new HashMap();
        public int statusCode;

        public a() {
            AppMethodBeat.i(7041);
            AppMethodBeat.o(7041);
        }
    }

    public static a a(String str, Map<String, String> map, String str2) {
        Closeable closeable;
        Throwable th;
        AppMethodBeat.i(7042);
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
            a aVar = new a();
            aVar.statusCode = httpURLConnection.getResponseCode();
            if (aVar.statusCode == 200) {
                Closeable f;
                try {
                    f = f(httpURLConnection.getContentEncoding(), httpURLConnection.getInputStream());
                    try {
                        aVar.data = convertStreamToString(f);
                        closeQuietly(f);
                    } catch (IOException e) {
                        closeable = f;
                        closeQuietly(closeable);
                        AppMethodBeat.o(7042);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        closeQuietly(f);
                        AppMethodBeat.o(7042);
                        throw th;
                    }
                } catch (IOException e2) {
                    closeable = null;
                } catch (Throwable th3) {
                    th = th3;
                    f = null;
                    closeQuietly(f);
                    AppMethodBeat.o(7042);
                    throw th;
                }
            }
            int i = 0;
            while (true) {
                String headerFieldKey = httpURLConnection.getHeaderFieldKey(i);
                String headerField = httpURLConnection.getHeaderField(i);
                if (headerFieldKey == null && headerField == null) {
                    AppMethodBeat.o(7042);
                    return aVar;
                }
                aVar.ipC.put(headerFieldKey, headerField);
                i++;
            }
        } catch (MalformedURLException e3) {
            ab.c("MicroMsg.RequestUtil", "", e3);
            AppMethodBeat.o(7042);
            return null;
        } catch (IOException e4) {
            ab.c("MicroMsg.RequestUtil", "", e4);
            AppMethodBeat.o(7042);
            return null;
        } catch (Exception e5) {
            ab.c("MicroMsg.RequestUtil", "", e5);
            AppMethodBeat.o(7042);
            return null;
        }
    }

    public static a w(String str, Map<String, String> map) {
        Closeable closeable;
        Throwable th;
        AppMethodBeat.i(7043);
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            if (httpURLConnection == null) {
                AppMethodBeat.o(7043);
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
            a aVar = new a();
            aVar.statusCode = httpURLConnection.getResponseCode();
            if (aVar.statusCode == 200) {
                Closeable f;
                try {
                    f = f(httpURLConnection.getContentEncoding(), httpURLConnection.getInputStream());
                    try {
                        aVar.data = convertStreamToString(f);
                        closeQuietly(f);
                    } catch (IOException e) {
                        closeable = f;
                        closeQuietly(closeable);
                        AppMethodBeat.o(7043);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        closeQuietly(f);
                        AppMethodBeat.o(7043);
                        throw th;
                    }
                } catch (IOException e2) {
                    closeable = null;
                } catch (Throwable th3) {
                    th = th3;
                    f = null;
                    closeQuietly(f);
                    AppMethodBeat.o(7043);
                    throw th;
                }
            }
            int i = 0;
            while (true) {
                String headerFieldKey = httpURLConnection.getHeaderFieldKey(i);
                String headerField = httpURLConnection.getHeaderField(i);
                if (headerFieldKey == null && headerField == null) {
                    AppMethodBeat.o(7043);
                    return aVar;
                }
                aVar.ipC.put(headerFieldKey, headerField);
                i++;
            }
        } catch (MalformedURLException e3) {
            ab.c("MicroMsg.RequestUtil", "", e3);
            AppMethodBeat.o(7043);
            return null;
        } catch (IOException e4) {
            ab.c("MicroMsg.RequestUtil", "", e4);
            AppMethodBeat.o(7043);
            return null;
        } catch (Exception e5) {
            ab.c("MicroMsg.RequestUtil", "", e5);
            AppMethodBeat.o(7043);
            return null;
        }
    }

    private static InputStream f(String str, InputStream inputStream) {
        AppMethodBeat.i(7044);
        InputStream gZIPInputStream;
        if (str == null || "identity".equalsIgnoreCase(str)) {
            AppMethodBeat.o(7044);
            return inputStream;
        } else if ("gzip".equalsIgnoreCase(str)) {
            gZIPInputStream = new GZIPInputStream(inputStream);
            AppMethodBeat.o(7044);
            return gZIPInputStream;
        } else if ("deflate".equalsIgnoreCase(str)) {
            gZIPInputStream = new InflaterInputStream(inputStream, new Inflater(false), 512);
            AppMethodBeat.o(7044);
            return gZIPInputStream;
        } else {
            RuntimeException runtimeException = new RuntimeException("unsupported content-encoding: ".concat(String.valueOf(str)));
            AppMethodBeat.o(7044);
            throw runtimeException;
        }
    }

    private static String convertStreamToString(InputStream inputStream) {
        AppMethodBeat.i(7045);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader, 512);
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    stringBuilder.append(readLine + IOUtils.LINE_SEPARATOR_UNIX);
                } else {
                    closeQuietly(inputStreamReader);
                    closeQuietly(bufferedReader);
                    String stringBuilder2 = stringBuilder.toString();
                    AppMethodBeat.o(7045);
                    return stringBuilder2;
                }
            } catch (IOException e) {
                ab.c("MicroMsg.RequestUtil", "", e);
                return null;
            } catch (Exception e2) {
                ab.c("MicroMsg.RequestUtil", "", e2);
                return null;
            } finally {
                closeQuietly(inputStreamReader);
                closeQuietly(bufferedReader);
                AppMethodBeat.o(7045);
            }
        }
    }

    private static void closeQuietly(Closeable closeable) {
        AppMethodBeat.i(7046);
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                ab.c("MicroMsg.RequestUtil", "", e);
                AppMethodBeat.o(7046);
                return;
            } catch (Exception e2) {
                ab.c("MicroMsg.RequestUtil", "", e2);
                AppMethodBeat.o(7046);
                return;
            }
        }
        AppMethodBeat.o(7046);
    }
}
