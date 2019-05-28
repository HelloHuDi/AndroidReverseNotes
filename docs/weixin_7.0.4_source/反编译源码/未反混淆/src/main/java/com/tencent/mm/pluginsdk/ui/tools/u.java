package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Base64;
import android.webkit.URLUtil;
import android.widget.Toast;
import com.facebook.internal.Utility;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.luggage.a.e;
import com.tencent.luggage.g.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.e.y;
import com.tencent.mm.plugin.appbrand.r.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.xweb.WebView;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.JSEXECUTECHECK})
public final class u {
    private static az ghu = null;
    private static com.tencent.mm.plugin.appbrand.r.q.a ulv = null;
    private static final Pattern vvQ = Pattern.compile("data:(image|img)/\\S+;base64,\\S+");

    public interface a {
        void BX(String str);
    }

    static class c implements com.tencent.mm.sdk.platformtools.az.a {
        private static Pattern vvU = Pattern.compile("image/[A-Za-z0-9]+");
        private static Pattern vvV = Pattern.compile("filename=[A-Za-z0-9@.]+.[A-Za-z0-9]+");
        private Context context;
        private String ffl;
        private String imagePath;
        private boolean kuU;
        private int opType;
        private String vvW;
        private String vvX;
        private a vvY;

        static {
            AppMethodBeat.i(80466);
            AppMethodBeat.o(80466);
        }

        public c(Context context, String str, String str2, boolean z) {
            this(context, str, str2, z, 0, null);
        }

        public c(Context context, String str, String str2, boolean z, int i, a aVar) {
            this.context = context;
            this.ffl = str;
            this.vvX = str2;
            this.kuU = z;
            this.opType = i;
            this.vvY = aVar;
        }

        public final boolean acg() {
            AppMethodBeat.i(80461);
            if (1 == this.opType) {
                this.vvY.BX(this.imagePath);
                AppMethodBeat.o(80461);
            } else {
                if (bo.isNullOrNil(this.vvW)) {
                    Toast.makeText(this.context, this.context.getString(R.string.g2q), 1).show();
                } else {
                    Toast.makeText(this.context, this.vvW, 1).show();
                }
                AppMethodBeat.o(80461);
            }
            return true;
        }

        private void dlF() {
            Exception e;
            HttpURLConnection httpURLConnection;
            Throwable th;
            AppMethodBeat.i(80462);
            InputStream inputStream;
            try {
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(this.ffl).openConnection();
                try {
                    httpURLConnection2.setRequestMethod("GET");
                    httpURLConnection2.setRequestProperty("Cookie", this.vvX);
                    httpURLConnection2.setAllowUserInteraction(true);
                    int responseCode = httpURLConnection2.getResponseCode();
                    String headerField;
                    if (responseCode != 200) {
                        if (responseCode == 301 || responseCode == 302) {
                            headerField = httpURLConnection2.getHeaderField("Location");
                            if (headerField == null) {
                                headerField = httpURLConnection2.getHeaderField(com.google.firebase.analytics.FirebaseAnalytics.b.LOCATION);
                            }
                            ab.i("MicroMsg.WebViewUtil", "redirect url = %s", headerField);
                            if (!bo.isNullOrNil(headerField)) {
                                this.ffl = headerField;
                                dlF();
                                a(httpURLConnection2, null);
                                AppMethodBeat.o(80462);
                                return;
                            }
                        }
                        this.vvW = this.context.getString(R.string.g2q);
                        a(httpURLConnection2, null);
                        AppMethodBeat.o(80462);
                        return;
                    }
                    headerField = httpURLConnection2.getContentType();
                    inputStream = httpURLConnection2.getInputStream();
                    try {
                        a(headerField, httpURLConnection2.getHeaderField("Content-Disposition"), inputStream);
                        a(httpURLConnection2, inputStream);
                        AppMethodBeat.o(80462);
                    } catch (Exception e2) {
                        e = e2;
                        httpURLConnection = httpURLConnection2;
                        try {
                            ab.e("MicroMsg.WebViewUtil", "init http url connection failed : %s", e.getMessage());
                            a(httpURLConnection, inputStream);
                            AppMethodBeat.o(80462);
                        } catch (Throwable th2) {
                            th = th2;
                            a(httpURLConnection, inputStream);
                            AppMethodBeat.o(80462);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        httpURLConnection = httpURLConnection2;
                        a(httpURLConnection, inputStream);
                        AppMethodBeat.o(80462);
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    inputStream = null;
                    httpURLConnection = httpURLConnection2;
                } catch (Throwable th4) {
                    th = th4;
                    inputStream = null;
                    httpURLConnection = httpURLConnection2;
                    a(httpURLConnection, inputStream);
                    AppMethodBeat.o(80462);
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                inputStream = null;
                httpURLConnection = null;
                ab.e("MicroMsg.WebViewUtil", "init http url connection failed : %s", e.getMessage());
                a(httpURLConnection, inputStream);
                AppMethodBeat.o(80462);
            } catch (Throwable th22) {
                th = th22;
                inputStream = null;
                httpURLConnection = null;
                a(httpURLConnection, inputStream);
                AppMethodBeat.o(80462);
                throw th;
            }
        }

        private static void a(HttpURLConnection httpURLConnection, InputStream inputStream) {
            AppMethodBeat.i(80463);
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                    AppMethodBeat.o(80463);
                    return;
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.WebViewUtil", e, "", new Object[0]);
                }
            }
            AppMethodBeat.o(80463);
        }

        private void a(String str, String str2, InputStream inputStream) {
            Matcher matcher;
            AppMethodBeat.i(80464);
            ab.i("MicroMsg.WebViewUtil", "contentType = %s, dispositionType = %s", str, str2);
            String str3 = null;
            if (!bo.isNullOrNil(str)) {
                matcher = vvU.matcher(str);
                if (matcher.find()) {
                    str3 = matcher.group().substring(matcher.group().lastIndexOf(47) + 1);
                }
            }
            if (bo.isNullOrNil(str3) && !bo.isNullOrNil(str2)) {
                matcher = vvV.matcher(str2);
                if (matcher.find()) {
                    str3 = matcher.group().substring(matcher.group().lastIndexOf(46) + 1);
                }
            }
            if (bo.isNullOrNil(str3)) {
                s sVar = new s(this.ffl);
                int lastIndexOf = sVar.mPath.lastIndexOf(46);
                if (lastIndexOf == -1) {
                    str3 = "jpg";
                } else {
                    str3 = sVar.mPath.substring(lastIndexOf + 1);
                }
            }
            this.imagePath = n.RL(str3);
            FileOutputStream fileOutputStream = new FileOutputStream(this.imagePath);
            byte[] bArr = new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    try {
                        break;
                    } catch (Exception e) {
                        ab.e("MicroMsg.WebViewUtil", "close os failed : %s", e.getMessage());
                    }
                }
            }
            fileOutputStream.flush();
            fileOutputStream.close();
            if (this.opType == 0) {
                this.vvW = this.context.getString(R.string.b3r, new Object[]{n.dlz()});
                n.a(this.imagePath, this.context);
            }
            AppMethodBeat.o(80464);
        }

        /* JADX WARNING: Removed duplicated region for block: B:28:0x00b5 A:{SYNTHETIC, Splitter:B:28:0x00b5} */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x00cf A:{SYNTHETIC, Splitter:B:34:0x00cf} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean acf() {
            Exception e;
            Throwable th;
            InputStream inputStream;
            HttpURLConnection httpURLConnection;
            Throwable th2;
            Object inputStream2;
            FileOutputStream fileOutputStream = null;
            AppMethodBeat.i(80465);
            if (!this.kuU) {
                this.vvW = this.context.getString(R.string.g2r);
                AppMethodBeat.o(80465);
                return true;
            } else if (bo.isNullOrNil(this.ffl)) {
                AppMethodBeat.o(80465);
                return false;
            } else {
                int indexOf;
                if (URLUtil.isDataUrl(this.ffl)) {
                    this.imagePath = n.RL("jpg");
                    try {
                        indexOf = this.ffl.indexOf("base64");
                        if (indexOf > 0) {
                            this.ffl = this.ffl.substring(indexOf + 7);
                        }
                        FileOutputStream fileOutputStream2 = new FileOutputStream(this.imagePath);
                        try {
                            byte[] decode = Base64.decode(this.ffl, 0);
                            if (decode != null) {
                                fileOutputStream2.write(decode);
                            }
                            fileOutputStream2.flush();
                            fileOutputStream2.close();
                            this.vvW = this.context.getString(R.string.b3r, new Object[]{n.dlz()});
                            n.a(this.imagePath, this.context);
                            try {
                                fileOutputStream2.close();
                            } catch (Exception e2) {
                                ab.e("MicroMsg.WebViewUtil", "close FileOutputStream failed : %s", e2.getMessage());
                            }
                        } catch (Exception e3) {
                            e2 = e3;
                            fileOutputStream = fileOutputStream2;
                            try {
                                ab.e("MicroMsg.WebViewUtil", "decode base64 pic failed : %s", e2.getMessage());
                                if (fileOutputStream != null) {
                                }
                                AppMethodBeat.o(80465);
                                return true;
                            } catch (Throwable th3) {
                                th = th3;
                                if (fileOutputStream != null) {
                                }
                                AppMethodBeat.o(80465);
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (Exception e4) {
                                    ab.e("MicroMsg.WebViewUtil", "close FileOutputStream failed : %s", e4.getMessage());
                                }
                            }
                            AppMethodBeat.o(80465);
                            throw th;
                        }
                    } catch (Exception e5) {
                        e2 = e5;
                        ab.e("MicroMsg.WebViewUtil", "decode base64 pic failed : %s", e2.getMessage());
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e22) {
                                ab.e("MicroMsg.WebViewUtil", "close FileOutputStream failed : %s", e22.getMessage());
                            }
                        }
                        AppMethodBeat.o(80465);
                        return true;
                    }
                } else if (URLUtil.isHttpsUrl(this.ffl)) {
                    try {
                        HttpURLConnection httpURLConnection2 = (HttpsURLConnection) new URL(this.ffl).openConnection();
                        try {
                            httpURLConnection2.setRequestMethod("GET");
                            httpURLConnection2.setRequestProperty("Cookie", this.vvX);
                            httpURLConnection2.setAllowUserInteraction(true);
                            indexOf = httpURLConnection2.getResponseCode();
                            String headerField;
                            if (indexOf != 200) {
                                if (indexOf == 301 || indexOf == 302) {
                                    headerField = httpURLConnection2.getHeaderField("Location");
                                    if (headerField == null) {
                                        headerField = httpURLConnection2.getHeaderField(com.google.firebase.analytics.FirebaseAnalytics.b.LOCATION);
                                    }
                                    ab.i("MicroMsg.WebViewUtil", "redirect url = %s", headerField);
                                    if (!bo.isNullOrNil(headerField)) {
                                        this.ffl = headerField;
                                        dlF();
                                        a(httpURLConnection2, fileOutputStream);
                                    }
                                }
                                this.vvW = this.context.getString(R.string.g2q);
                                a(httpURLConnection2, fileOutputStream);
                            } else {
                                headerField = httpURLConnection2.getContentType();
                                InputStream inputStream3 = httpURLConnection2.getInputStream();
                                try {
                                    a(headerField, httpURLConnection2.getHeaderField("Content-Disposition"), inputStream3);
                                    a(httpURLConnection2, inputStream3);
                                } catch (Exception e6) {
                                    e22 = e6;
                                    inputStream2 = inputStream3;
                                    httpURLConnection = httpURLConnection2;
                                    try {
                                        ab.e("MicroMsg.WebViewUtil", "download https resource failed : %s", e22.getMessage());
                                        a(httpURLConnection, inputStream2);
                                        AppMethodBeat.o(80465);
                                        return true;
                                    } catch (Throwable th5) {
                                        th2 = th5;
                                        a(httpURLConnection, inputStream2);
                                        AppMethodBeat.o(80465);
                                        throw th2;
                                    }
                                } catch (Throwable th6) {
                                    th2 = th6;
                                    inputStream2 = inputStream3;
                                    httpURLConnection = httpURLConnection2;
                                    a(httpURLConnection, inputStream2);
                                    AppMethodBeat.o(80465);
                                    throw th2;
                                }
                            }
                        } catch (Exception e7) {
                            e22 = e7;
                            inputStream2 = fileOutputStream;
                            httpURLConnection = httpURLConnection2;
                        } catch (Throwable th7) {
                            th2 = th7;
                            inputStream2 = fileOutputStream;
                            httpURLConnection = httpURLConnection2;
                            a(httpURLConnection, inputStream2);
                            AppMethodBeat.o(80465);
                            throw th2;
                        }
                    } catch (Exception e8) {
                        e22 = e8;
                        inputStream2 = fileOutputStream;
                        httpURLConnection = fileOutputStream;
                        ab.e("MicroMsg.WebViewUtil", "download https resource failed : %s", e22.getMessage());
                        a(httpURLConnection, inputStream2);
                        AppMethodBeat.o(80465);
                        return true;
                    } catch (Throwable th52) {
                        th2 = th52;
                        inputStream2 = fileOutputStream;
                        httpURLConnection = fileOutputStream;
                        a(httpURLConnection, inputStream2);
                        AppMethodBeat.o(80465);
                        throw th2;
                    }
                } else {
                    dlF();
                }
                AppMethodBeat.o(80465);
                return true;
            }
        }
    }

    public interface b {
        void akp(String str);
    }

    static {
        AppMethodBeat.i(80489);
        AppMethodBeat.o(80489);
    }

    @Deprecated
    public static String bh(Context context, String str) {
        AppMethodBeat.i(80467);
        String a = q.a(context, str, (com.tencent.mm.plugin.appbrand.r.q.a) e.B(com.tencent.mm.plugin.appbrand.r.q.a.class));
        AppMethodBeat.o(80467);
        return a;
    }

    public static boolean akj(String str) {
        AppMethodBeat.i(80468);
        if (str == null) {
            AppMethodBeat.o(80468);
            return false;
        }
        boolean contains = str.toLowerCase().contains(" MicroMessenger/".trim().toLowerCase());
        AppMethodBeat.o(80468);
        return contains;
    }

    public static boolean t(String str, String str2) {
        AppMethodBeat.i(80469);
        boolean t = h.t(str, str2);
        AppMethodBeat.o(80469);
        return t;
    }

    @Deprecated
    public static PackageInfo getPackageInfo(Context context, String str) {
        AppMethodBeat.i(80470);
        PackageInfo packageInfo = com.tencent.mm.plugin.appbrand.r.b.getPackageInfo(context, str);
        AppMethodBeat.o(80470);
        return packageInfo;
    }

    public static void a(Context context, String str, String str2, boolean z) {
        AppMethodBeat.i(80471);
        if (ghu == null) {
            ghu = new az(1, "webview-save-image", 1);
        }
        ghu.e(new c(context, str, str2, z));
        AppMethodBeat.o(80471);
    }

    public static void a(Context context, String str, String str2, boolean z, a aVar) {
        AppMethodBeat.i(80472);
        if (ghu == null) {
            ghu = new az(1, "webview-save-image", 1);
        }
        ghu.e(new c(context, str, str2, z, 1, aVar));
        AppMethodBeat.o(80472);
    }

    public static void d(final WebView webView) {
        AppMethodBeat.i(80473);
        if (webView == null) {
            AppMethodBeat.o(80473);
            return;
        }
        a(new b() {
            public final void akp(String str) {
                AppMethodBeat.i(80457);
                webView.evaluateJavascript(str, null);
                AppMethodBeat.o(80457);
            }
        });
        AppMethodBeat.o(80473);
    }

    private static void a(final b bVar) {
        AppMethodBeat.i(80474);
        ab.d("MicroMsg.WebViewUtil", "initIFrame");
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(80458);
                bVar.akp("javascript:var edw_iframe = document.getElementById('_edw_iframe_');if (edw_iframe === null) {edw_iframe = document.createElement('iframe');edw_iframe.id = '_edw_iframe_';edw_iframe.style.display = 'none';document.documentElement.appendChild(edw_iframe);}");
                AppMethodBeat.o(80458);
            }
        });
        AppMethodBeat.o(80474);
    }

    public static void a(WebView webView, String str, String str2) {
        AppMethodBeat.i(80475);
        a(webView, str, str2, true);
        AppMethodBeat.o(80475);
    }

    public static void a(final WebView webView, String str, String str2, boolean z) {
        AppMethodBeat.i(80476);
        if (webView == null) {
            AppMethodBeat.o(80476);
            return;
        }
        a(new b() {
            public final void akp(String str) {
                AppMethodBeat.i(80459);
                webView.evaluateJavascript(str, null);
                AppMethodBeat.o(80459);
            }
        }, str, str2, z);
        AppMethodBeat.o(80476);
    }

    private static void a(final b bVar, final String str, final String str2, final boolean z) {
        AppMethodBeat.i(80477);
        if (bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
            ab.e("MicroMsg.WebViewUtil", "getJsResult fail, invalid argument, scheme = %s, jsCode = %s", str, str2);
            AppMethodBeat.o(80477);
            return;
        }
        ab.d("MicroMsg.WebViewUtil", "getJsResult, scheme = %s, jsCode = %s", str, str2);
        a(bVar);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(80460);
                if (z) {
                    bVar.akp("javascript:document.getElementById('_edw_iframe_').src = '" + str + "' + " + str2);
                    AppMethodBeat.o(80460);
                    return;
                }
                bVar.akp("javascript:console.log('" + str + "' + " + str2 + ")");
                AppMethodBeat.o(80460);
            }
        });
        AppMethodBeat.o(80477);
    }

    public static String hL(String str, String str2) {
        AppMethodBeat.i(80478);
        if (bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
            ab.e("MicroMsg.WebViewUtil", "genJsCode fail, invalid argument, scheme = %s, jsCode = %s", str, str2);
            AppMethodBeat.o(80478);
            return null;
        }
        ab.d("MicroMsg.WebViewUtil", "genJsCode, scheme = %s, jsCode = %s", str, str2);
        String str3 = "document.getElementById('_edw_iframe_').src = '" + str + "' + " + str2;
        AppMethodBeat.o(80478);
        return str3;
    }

    public static final String aR(Map<String, Object> map) {
        AppMethodBeat.i(80479);
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (!(bo.isNullOrNil(str) || obj == null)) {
                if (!(obj instanceof String) || !bo.isNullOrNil((String) obj)) {
                    if (stringBuilder.length() > 0) {
                        stringBuilder.append("&");
                    }
                    stringBuilder.append(str);
                    stringBuilder.append("=");
                    stringBuilder.append(obj);
                }
            }
        }
        String str2 = stringBuilder.toString();
        AppMethodBeat.o(80479);
        return str2;
    }

    public static final String akk(String str) {
        AppMethodBeat.i(80480);
        if (!bo.isNullOrNil(str)) {
            try {
                str = URLEncoder.encode(str, ProtocolPackage.ServerEncoding);
                AppMethodBeat.o(80480);
            } catch (UnsupportedEncodingException e) {
                ab.e("MicroMsg.WebViewUtil", "URLEncode fail, throw : %s", e.getMessage());
            }
            return str;
        }
        AppMethodBeat.o(80480);
        return str;
    }

    public static final String akl(String str) {
        AppMethodBeat.i(80481);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(80481);
            return str;
        }
        byte[] bytes;
        try {
            bytes = str.getBytes(ProtocolPackage.ServerEncoding);
        } catch (UnsupportedEncodingException e) {
            UnsupportedEncodingException unsupportedEncodingException = e;
            bytes = str.getBytes();
            ab.e("MicroMsg.WebViewUtil", "getBytes fail, throw : %s", unsupportedEncodingException.getMessage());
        }
        str = Base64.encodeToString(bytes, 2);
        AppMethodBeat.o(80481);
        return str;
    }

    private static String fU(Context context) {
        WifiInfo connectionInfo;
        AppMethodBeat.i(80482);
        try {
            connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
        } catch (Exception e) {
            connectionInfo = null;
        }
        String str;
        if (connectionInfo == null) {
            str = "127.0.0.1";
            AppMethodBeat.o(80482);
            return str;
        }
        int ipAddress = connectionInfo.getIpAddress();
        str = String.format("%d.%d.%d.%d", new Object[]{Integer.valueOf(ipAddress & 255), Integer.valueOf((ipAddress >> 8) & 255), Integer.valueOf((ipAddress >> 16) & 255), Integer.valueOf((ipAddress >> 24) & 255)});
        AppMethodBeat.o(80482);
        return str;
    }

    public static String bOO() {
        int i = 0;
        AppMethodBeat.i(80483);
        try {
            i = y.Me();
        } catch (Exception e) {
            ab.e("MicroMsg.WebViewUtil", "getSelfIp, call NetworkDetailInfo.getNetType(), exp = %s", e);
        }
        String str;
        if (i == 0) {
            str = "127.0.0.1";
            AppMethodBeat.o(80483);
            return str;
        } else if (i == 1) {
            str = fU(ah.getContext());
            AppMethodBeat.o(80483);
            return str;
        } else {
            try {
                Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
                while (networkInterfaces.hasMoreElements()) {
                    NetworkInterface networkInterface = (NetworkInterface) networkInterfaces.nextElement();
                    if (networkInterface != null) {
                        Enumeration inetAddresses = networkInterface.getInetAddresses();
                        while (inetAddresses.hasMoreElements()) {
                            InetAddress inetAddress = (InetAddress) inetAddresses.nextElement();
                            if (inetAddress != null && !inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet4Address)) {
                                if (bo.isNullOrNil(inetAddress.getHostAddress())) {
                                    str = "127.0.0.1";
                                    AppMethodBeat.o(80483);
                                    return str;
                                }
                                str = inetAddress.getHostAddress();
                                AppMethodBeat.o(80483);
                                return str;
                            }
                        }
                        continue;
                    }
                }
            } catch (Exception e2) {
            }
            str = "127.0.0.1";
            AppMethodBeat.o(80483);
            return str;
        }
    }

    public static String akm(String str) {
        AppMethodBeat.i(80484);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(80484);
            return null;
        } else if (vvQ.matcher(str).matches()) {
            String trim = str.substring(str.indexOf("base64,") + 7).trim();
            AppMethodBeat.o(80484);
            return trim;
        } else {
            AppMethodBeat.o(80484);
            return null;
        }
    }

    public static String cXS() {
        AppMethodBeat.i(80485);
        ConnectivityManager connectivityManager = (ConnectivityManager) ah.getContext().getSystemService("connectivity");
        String str;
        if (connectivityManager == null) {
            str = "no";
            AppMethodBeat.o(80485);
            return str;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            str = "no";
            AppMethodBeat.o(80485);
            return str;
        } else if (activeNetworkInfo.getType() == 1) {
            str = "WIFI";
            AppMethodBeat.o(80485);
            return str;
        } else {
            ab.d("MicroMsg.WebViewUtil", "activeNetInfo extra=%s, type=%d, %s", activeNetworkInfo.getExtraInfo(), Integer.valueOf(activeNetworkInfo.getType()), activeNetworkInfo.getExtraInfo());
            if (activeNetworkInfo.getExtraInfo() != null) {
                str = activeNetworkInfo.getExtraInfo().toLowerCase();
                AppMethodBeat.o(80485);
                return str;
            }
            str = "no";
            AppMethodBeat.o(80485);
            return str;
        }
    }

    public static String akn(String str) {
        AppMethodBeat.i(80486);
        String str2 = "";
        if (str != null && str.startsWith("Refused to frame")) {
            String[] split = str.split("'");
            if (split.length > 2) {
                str2 = split[1];
            }
        }
        AppMethodBeat.o(80486);
        return str2;
    }

    @Deprecated
    public static String ako(String str) {
        AppMethodBeat.i(80487);
        String ako = com.tencent.mm.sdk.f.b.ako(str);
        AppMethodBeat.o(80487);
        return ako;
    }

    public static String aef(String str) {
        AppMethodBeat.i(80488);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(80488);
            return str;
        }
        int indexOf = str.indexOf("#");
        if (indexOf < 0) {
            AppMethodBeat.o(80488);
            return str;
        }
        str = str.substring(0, indexOf);
        AppMethodBeat.o(80488);
        return str;
    }
}
