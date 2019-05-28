package com.tencent.p177mm.plugin.webview.modelcache;

import android.net.Uri;
import android.webkit.URLUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.plugin.appbrand.jsapi.appdownload.JsApiPauseDownloadTask;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C29945i;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/* renamed from: com.tencent.mm.plugin.webview.modelcache.q */
public final class C14525q {
    /* renamed from: Ed */
    public static boolean m22728Ed(String str) {
        AppMethodBeat.m2504i(6867);
        if (C5046bo.isNullOrNil(str) || !(URLUtil.isHttpsUrl(str) || URLUtil.isHttpUrl(str))) {
            AppMethodBeat.m2505o(6867);
            return false;
        }
        AppMethodBeat.m2505o(6867);
        return true;
    }

    public static String aeJ(String str) {
        AppMethodBeat.m2504i(6868);
        if (C14525q.m22728Ed(str)) {
            String aeK;
            try {
                URI uri = new URI(str);
                String toLowerCase = C5046bo.nullAsNil(uri.getScheme()).toLowerCase();
                String toLowerCase2 = C5046bo.nullAsNil(uri.getHost()).toLowerCase();
                if (C5046bo.isNullOrNil(toLowerCase2)) {
                    AppMethodBeat.m2505o(6868);
                    return null;
                }
                int port = uri.getPort() == -1 ? toLowerCase.equalsIgnoreCase("http") ? 80 : JsApiPauseDownloadTask.CTRL_INDEX : uri.getPort();
                str = toLowerCase + "://" + toLowerCase2 + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + port + "/" + C5046bo.nullAsNil(uri.getPath()) + (C5046bo.isNullOrNil(uri.getQuery()) ? "" : "?" + uri.getQuery()) + (C5046bo.isNullOrNil(uri.getFragment()) ? "" : "#" + uri.getFragment());
                if (str.endsWith("/")) {
                    str = str + "/";
                }
                aeK = C14525q.aeK(str);
                AppMethodBeat.m2505o(6868);
                return aeK;
            } catch (URISyntaxException e) {
                aeK = str;
                C4990ab.m7413e("MicroMsg.WebViewCacheUtils", "getFormattedHttpURL URISyntaxException : %s", e.getMessage());
                AppMethodBeat.m2505o(6868);
                return aeK;
            } catch (Exception e2) {
                aeK = str;
                C4990ab.m7413e("MicroMsg.WebViewCacheUtils", "getFormattedHttpURL normal : %s", e2.getMessage());
                AppMethodBeat.m2505o(6868);
                return aeK;
            }
        }
        AppMethodBeat.m2505o(6868);
        return null;
    }

    private static String aeK(String str) {
        AppMethodBeat.m2504i(6869);
        Uri parse = Uri.parse(str);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(parse.getScheme()).append("://");
        stringBuilder.append(parse.getHost()).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(parse.getPort());
        if (C5046bo.m7548ek(parse.getPathSegments())) {
            stringBuilder.append("/");
        } else {
            for (String append : parse.getPathSegments()) {
                stringBuilder.append("/").append(append);
            }
        }
        if (!C5046bo.isNullOrNil(parse.getQuery())) {
            stringBuilder.append("?").append(parse.getQuery());
        }
        if (!C5046bo.isNullOrNil(parse.getFragment())) {
            stringBuilder.append("#").append(parse.getFragment());
        }
        if (str.endsWith("/")) {
            stringBuilder.append("/");
        }
        String append2 = stringBuilder.toString();
        AppMethodBeat.m2505o(6869);
        return append2;
    }

    public static String aeL(String str) {
        AppMethodBeat.m2504i(6870);
        String aeJ = C14525q.aeJ(str);
        if (C5046bo.isNullOrNil(aeJ)) {
            AppMethodBeat.m2505o(6870);
            return null;
        }
        aeJ = Uri.parse(aeJ).getHost();
        AppMethodBeat.m2505o(6870);
        return aeJ;
    }

    public static String aeM(String str) {
        AppMethodBeat.m2504i(6871);
        String aeN = C14525q.aeN(str);
        if (C5046bo.isNullOrNil(aeN)) {
            AppMethodBeat.m2505o(6871);
            return null;
        }
        aeN = aeN.replaceAll("http://", "").replaceAll("https://", "");
        AppMethodBeat.m2505o(6871);
        return aeN;
    }

    public static String aeN(String str) {
        AppMethodBeat.m2504i(6872);
        String aeJ = C14525q.aeJ(str);
        if (C5046bo.isNullOrNil(aeJ)) {
            C4990ab.m7413e("MicroMsg.WebViewCacheUtils", "evaluateResURLWithScheme, original url is invalid = %s", str);
            AppMethodBeat.m2505o(6872);
            return null;
        }
        Uri parse = Uri.parse(aeJ);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(parse.getScheme()).append("://").append(parse.getHost()).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(parse.getPort());
        if (!C5046bo.m7548ek(parse.getPathSegments())) {
            for (String aeJ2 : parse.getPathSegments()) {
                stringBuilder.append("/").append(C5046bo.nullAsNil(aeJ2));
            }
        }
        if (str.endsWith("/")) {
            stringBuilder.append("/");
        }
        aeJ2 = stringBuilder.toString();
        AppMethodBeat.m2505o(6872);
        return aeJ2;
    }

    public static byte[] aeO(String str) {
        Exception e;
        Throwable th;
        AppMethodBeat.m2504i(6873);
        Closeable byteArrayOutputStream;
        Closeable inputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setRequestMethod("GET");
                int responseCode = httpURLConnection.getResponseCode();
                int contentLength = httpURLConnection.getContentLength();
                C4990ab.m7411d("MicroMsg.WebViewCacheUtils", "getBytesFromURL, url = %s, statusCode = %d, contentLength = %d", str, Integer.valueOf(responseCode), Integer.valueOf(contentLength));
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
                                C5046bo.m7527b(inputStream);
                                C5046bo.m7527b(byteArrayOutputStream);
                                AppMethodBeat.m2505o(6873);
                                return bArr;
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            C4990ab.m7413e("MicroMsg.WebViewCacheUtils", "getBytesFromURL, url = %s, e = %s", str, e);
                            C5046bo.m7527b(inputStream);
                            C5046bo.m7527b(byteArrayOutputStream);
                            AppMethodBeat.m2505o(6873);
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            C5046bo.m7527b(inputStream);
                            C5046bo.m7527b(byteArrayOutputStream);
                            AppMethodBeat.m2505o(6873);
                            throw th;
                        }
                    }
                }
                C5046bo.m7527b(inputStream);
                C5046bo.m7527b(byteArrayOutputStream);
                AppMethodBeat.m2505o(6873);
                return null;
            } catch (Exception e3) {
                e = e3;
                inputStream = null;
            } catch (Throwable th3) {
                th = th3;
                inputStream = null;
                C5046bo.m7527b(inputStream);
                C5046bo.m7527b(byteArrayOutputStream);
                AppMethodBeat.m2505o(6873);
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            byteArrayOutputStream = null;
            inputStream = null;
            C4990ab.m7413e("MicroMsg.WebViewCacheUtils", "getBytesFromURL, url = %s, e = %s", str, e);
            C5046bo.m7527b(inputStream);
            C5046bo.m7527b(byteArrayOutputStream);
            AppMethodBeat.m2505o(6873);
            return null;
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
            inputStream = null;
            C5046bo.m7527b(inputStream);
            C5046bo.m7527b(byteArrayOutputStream);
            AppMethodBeat.m2505o(6873);
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
        AppMethodBeat.m2504i(6874);
        if (C5730e.m8628ct(str)) {
            Closeable openRead;
            try {
                int asZ = (int) C5730e.asZ(str);
                openRead = C5730e.openRead(str);
                try {
                    str2 = C1178g.m2585b(openRead, asZ);
                    C5046bo.m7527b(openRead);
                    AppMethodBeat.m2505o(6874);
                } catch (FileNotFoundException e3) {
                    e = e3;
                    try {
                        C4990ab.m7413e("MicroMsg.WebViewCacheUtils", "getContentMd5, localPath = %s, exception = %s", str, e);
                        C5046bo.m7527b(openRead);
                        AppMethodBeat.m2505o(6874);
                        return str2;
                    } catch (Throwable th2) {
                        th = th2;
                        C5046bo.m7527b(openRead);
                        AppMethodBeat.m2505o(6874);
                        throw th;
                    }
                } catch (Exception e4) {
                    e2 = e4;
                    C4990ab.m7413e("MicroMsg.WebViewCacheUtils", "getContentMd5, localPath = %s, exception = %s", str, e2);
                    C5046bo.m7527b(openRead);
                    AppMethodBeat.m2505o(6874);
                    return str2;
                }
            } catch (FileNotFoundException e5) {
                e = e5;
                openRead = str2;
            } catch (Exception e6) {
                e2 = e6;
                openRead = str2;
                C4990ab.m7413e("MicroMsg.WebViewCacheUtils", "getContentMd5, localPath = %s, exception = %s", str, e2);
                C5046bo.m7527b(openRead);
                AppMethodBeat.m2505o(6874);
                return str2;
            } catch (Throwable th3) {
                th = th3;
                openRead = str2;
                C5046bo.m7527b(openRead);
                AppMethodBeat.m2505o(6874);
                throw th;
            }
        }
        AppMethodBeat.m2505o(6874);
        return str2;
    }

    /* renamed from: a */
    public static int m22729a(C29945i c29945i) {
        AppMethodBeat.m2504i(6875);
        if (!C5046bo.nullAsNil(c29945i.uIJ).equals("cache")) {
            AppMethodBeat.m2505o(6875);
            return -1;
        } else if (Boolean.parseBoolean((String) c29945i.puc.get("async")) && !C5046bo.isNullOrNil((String) c29945i.puc.get("src"))) {
            AppMethodBeat.m2505o(6875);
            return 2;
        } else if (C5046bo.isNullOrNil((String) c29945i.puc.get("resourceList"))) {
            AppMethodBeat.m2505o(6875);
            return -1;
        } else {
            AppMethodBeat.m2505o(6875);
            return 1;
        }
    }
}
