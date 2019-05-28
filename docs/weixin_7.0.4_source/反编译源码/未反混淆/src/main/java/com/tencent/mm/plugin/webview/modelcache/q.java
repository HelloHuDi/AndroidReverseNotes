package com.tencent.mm.plugin.webview.modelcache;

import android.net.Uri;
import android.webkit.URLUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiPauseDownloadTask;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public final class q {
    public static boolean Ed(String str) {
        AppMethodBeat.i(6867);
        if (bo.isNullOrNil(str) || !(URLUtil.isHttpsUrl(str) || URLUtil.isHttpUrl(str))) {
            AppMethodBeat.o(6867);
            return false;
        }
        AppMethodBeat.o(6867);
        return true;
    }

    public static String aeJ(String str) {
        AppMethodBeat.i(6868);
        if (Ed(str)) {
            String aeK;
            try {
                URI uri = new URI(str);
                String toLowerCase = bo.nullAsNil(uri.getScheme()).toLowerCase();
                String toLowerCase2 = bo.nullAsNil(uri.getHost()).toLowerCase();
                if (bo.isNullOrNil(toLowerCase2)) {
                    AppMethodBeat.o(6868);
                    return null;
                }
                int port = uri.getPort() == -1 ? toLowerCase.equalsIgnoreCase("http") ? 80 : JsApiPauseDownloadTask.CTRL_INDEX : uri.getPort();
                str = toLowerCase + "://" + toLowerCase2 + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + port + "/" + bo.nullAsNil(uri.getPath()) + (bo.isNullOrNil(uri.getQuery()) ? "" : "?" + uri.getQuery()) + (bo.isNullOrNil(uri.getFragment()) ? "" : "#" + uri.getFragment());
                if (str.endsWith("/")) {
                    str = str + "/";
                }
                aeK = aeK(str);
                AppMethodBeat.o(6868);
                return aeK;
            } catch (URISyntaxException e) {
                aeK = str;
                ab.e("MicroMsg.WebViewCacheUtils", "getFormattedHttpURL URISyntaxException : %s", e.getMessage());
                AppMethodBeat.o(6868);
                return aeK;
            } catch (Exception e2) {
                aeK = str;
                ab.e("MicroMsg.WebViewCacheUtils", "getFormattedHttpURL normal : %s", e2.getMessage());
                AppMethodBeat.o(6868);
                return aeK;
            }
        }
        AppMethodBeat.o(6868);
        return null;
    }

    private static String aeK(String str) {
        AppMethodBeat.i(6869);
        Uri parse = Uri.parse(str);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(parse.getScheme()).append("://");
        stringBuilder.append(parse.getHost()).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(parse.getPort());
        if (bo.ek(parse.getPathSegments())) {
            stringBuilder.append("/");
        } else {
            for (String append : parse.getPathSegments()) {
                stringBuilder.append("/").append(append);
            }
        }
        if (!bo.isNullOrNil(parse.getQuery())) {
            stringBuilder.append("?").append(parse.getQuery());
        }
        if (!bo.isNullOrNil(parse.getFragment())) {
            stringBuilder.append("#").append(parse.getFragment());
        }
        if (str.endsWith("/")) {
            stringBuilder.append("/");
        }
        String append2 = stringBuilder.toString();
        AppMethodBeat.o(6869);
        return append2;
    }

    public static String aeL(String str) {
        AppMethodBeat.i(6870);
        String aeJ = aeJ(str);
        if (bo.isNullOrNil(aeJ)) {
            AppMethodBeat.o(6870);
            return null;
        }
        aeJ = Uri.parse(aeJ).getHost();
        AppMethodBeat.o(6870);
        return aeJ;
    }

    public static String aeM(String str) {
        AppMethodBeat.i(6871);
        String aeN = aeN(str);
        if (bo.isNullOrNil(aeN)) {
            AppMethodBeat.o(6871);
            return null;
        }
        aeN = aeN.replaceAll("http://", "").replaceAll("https://", "");
        AppMethodBeat.o(6871);
        return aeN;
    }

    public static String aeN(String str) {
        AppMethodBeat.i(6872);
        String aeJ = aeJ(str);
        if (bo.isNullOrNil(aeJ)) {
            ab.e("MicroMsg.WebViewCacheUtils", "evaluateResURLWithScheme, original url is invalid = %s", str);
            AppMethodBeat.o(6872);
            return null;
        }
        Uri parse = Uri.parse(aeJ);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(parse.getScheme()).append("://").append(parse.getHost()).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(parse.getPort());
        if (!bo.ek(parse.getPathSegments())) {
            for (String aeJ2 : parse.getPathSegments()) {
                stringBuilder.append("/").append(bo.nullAsNil(aeJ2));
            }
        }
        if (str.endsWith("/")) {
            stringBuilder.append("/");
        }
        aeJ2 = stringBuilder.toString();
        AppMethodBeat.o(6872);
        return aeJ2;
    }

    public static byte[] aeO(String str) {
        Exception e;
        Throwable th;
        AppMethodBeat.i(6873);
        Closeable byteArrayOutputStream;
        Closeable inputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setRequestMethod("GET");
                int responseCode = httpURLConnection.getResponseCode();
                int contentLength = httpURLConnection.getContentLength();
                ab.d("MicroMsg.WebViewCacheUtils", "getBytesFromURL, url = %s, statusCode = %d, contentLength = %d", str, Integer.valueOf(responseCode), Integer.valueOf(contentLength));
                inputStream = httpURLConnection.getInputStream();
                if (inputStream != null) {
                    try {
                        byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                        while (true) {
                            contentLength = inputStream.read(bArr);
                            if (contentLength != -1) {
                                byteArrayOutputStream.write(bArr, 0, contentLength);
                            } else {
                                bArr = byteArrayOutputStream.toByteArray();
                                bo.b(inputStream);
                                bo.b(byteArrayOutputStream);
                                AppMethodBeat.o(6873);
                                return bArr;
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            ab.e("MicroMsg.WebViewCacheUtils", "getBytesFromURL, url = %s, e = %s", str, e);
                            bo.b(inputStream);
                            bo.b(byteArrayOutputStream);
                            AppMethodBeat.o(6873);
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            bo.b(inputStream);
                            bo.b(byteArrayOutputStream);
                            AppMethodBeat.o(6873);
                            throw th;
                        }
                    }
                }
                bo.b(inputStream);
                bo.b(byteArrayOutputStream);
                AppMethodBeat.o(6873);
                return null;
            } catch (Exception e3) {
                e = e3;
                inputStream = null;
            } catch (Throwable th3) {
                th = th3;
                inputStream = null;
                bo.b(inputStream);
                bo.b(byteArrayOutputStream);
                AppMethodBeat.o(6873);
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            byteArrayOutputStream = null;
            inputStream = null;
            ab.e("MicroMsg.WebViewCacheUtils", "getBytesFromURL, url = %s, e = %s", str, e);
            bo.b(inputStream);
            bo.b(byteArrayOutputStream);
            AppMethodBeat.o(6873);
            return null;
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
            inputStream = null;
            bo.b(inputStream);
            bo.b(byteArrayOutputStream);
            AppMethodBeat.o(6873);
            throw th;
        }
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:16:0x0041=Splitter:B:16:0x0041, B:11:0x0026=Splitter:B:11:0x0026} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String aeP(String str) {
        FileNotFoundException e;
        Throwable th;
        Exception e2;
        String str2 = null;
        AppMethodBeat.i(6874);
        if (e.ct(str)) {
            Closeable openRead;
            try {
                int asZ = (int) e.asZ(str);
                openRead = e.openRead(str);
                try {
                    str2 = g.b(openRead, asZ);
                    bo.b(openRead);
                    AppMethodBeat.o(6874);
                } catch (FileNotFoundException e3) {
                    e = e3;
                    try {
                        ab.e("MicroMsg.WebViewCacheUtils", "getContentMd5, localPath = %s, exception = %s", str, e);
                        bo.b(openRead);
                        AppMethodBeat.o(6874);
                        return str2;
                    } catch (Throwable th2) {
                        th = th2;
                        bo.b(openRead);
                        AppMethodBeat.o(6874);
                        throw th;
                    }
                } catch (Exception e4) {
                    e2 = e4;
                    ab.e("MicroMsg.WebViewCacheUtils", "getContentMd5, localPath = %s, exception = %s", str, e2);
                    bo.b(openRead);
                    AppMethodBeat.o(6874);
                    return str2;
                }
            } catch (FileNotFoundException e5) {
                e = e5;
                openRead = str2;
            } catch (Exception e6) {
                e2 = e6;
                openRead = str2;
                ab.e("MicroMsg.WebViewCacheUtils", "getContentMd5, localPath = %s, exception = %s", str, e2);
                bo.b(openRead);
                AppMethodBeat.o(6874);
                return str2;
            } catch (Throwable th3) {
                th = th3;
                openRead = str2;
                bo.b(openRead);
                AppMethodBeat.o(6874);
                throw th;
            }
        }
        AppMethodBeat.o(6874);
        return str2;
    }

    public static int a(i iVar) {
        AppMethodBeat.i(6875);
        if (!bo.nullAsNil(iVar.uIJ).equals("cache")) {
            AppMethodBeat.o(6875);
            return -1;
        } else if (Boolean.parseBoolean((String) iVar.puc.get("async")) && !bo.isNullOrNil((String) iVar.puc.get("src"))) {
            AppMethodBeat.o(6875);
            return 2;
        } else if (bo.isNullOrNil((String) iVar.puc.get("resourceList"))) {
            AppMethodBeat.o(6875);
            return -1;
        } else {
            AppMethodBeat.o(6875);
            return 1;
        }
    }
}
