package com.tencent.p177mm.pluginsdk.p597ui.tools;

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
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.p802jg.EType;
import com.p802jg.JgClassChecked;
import com.tencent.luggage.p1170a.C37384e;
import com.tencent.luggage.p147g.C8874h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.p221e.C18172y;
import com.tencent.p177mm.plugin.appbrand.p328r.C10707q;
import com.tencent.p177mm.plugin.appbrand.p328r.C10707q.C10708a;
import com.tencent.p177mm.plugin.appbrand.p328r.C19679b;
import com.tencent.p177mm.sdk.p1574f.C44216b;
import com.tencent.p177mm.sdk.platformtools.C23498az;
import com.tencent.p177mm.sdk.platformtools.C23498az.C23499a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
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
/* renamed from: com.tencent.mm.pluginsdk.ui.tools.u */
public final class C30152u {
    private static C23498az ghu = null;
    private static C10708a ulv = null;
    private static final Pattern vvQ = Pattern.compile("data:(image|img)/\\S+;base64,\\S+");

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.u$a */
    public interface C23348a {
        /* renamed from: BX */
        void mo26720BX(String str);
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.u$c */
    static class C23349c implements C23499a {
        private static Pattern vvU = Pattern.compile("image/[A-Za-z0-9]+");
        private static Pattern vvV = Pattern.compile("filename=[A-Za-z0-9@.]+.[A-Za-z0-9]+");
        private Context context;
        private String ffl;
        private String imagePath;
        private boolean kuU;
        private int opType;
        private String vvW;
        private String vvX;
        private C23348a vvY;

        static {
            AppMethodBeat.m2504i(80466);
            AppMethodBeat.m2505o(80466);
        }

        public C23349c(Context context, String str, String str2, boolean z) {
            this(context, str, str2, z, 0, null);
        }

        public C23349c(Context context, String str, String str2, boolean z, int i, C23348a c23348a) {
            this.context = context;
            this.ffl = str;
            this.vvX = str2;
            this.kuU = z;
            this.opType = i;
            this.vvY = c23348a;
        }

        public final boolean acg() {
            AppMethodBeat.m2504i(80461);
            if (1 == this.opType) {
                this.vvY.mo26720BX(this.imagePath);
                AppMethodBeat.m2505o(80461);
            } else {
                if (C5046bo.isNullOrNil(this.vvW)) {
                    Toast.makeText(this.context, this.context.getString(C25738R.string.g2q), 1).show();
                } else {
                    Toast.makeText(this.context, this.vvW, 1).show();
                }
                AppMethodBeat.m2505o(80461);
            }
            return true;
        }

        private void dlF() {
            Exception e;
            HttpURLConnection httpURLConnection;
            Throwable th;
            AppMethodBeat.m2504i(80462);
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
                                headerField = httpURLConnection2.getHeaderField(C8741b.LOCATION);
                            }
                            C4990ab.m7417i("MicroMsg.WebViewUtil", "redirect url = %s", headerField);
                            if (!C5046bo.isNullOrNil(headerField)) {
                                this.ffl = headerField;
                                dlF();
                                C23349c.m35862a(httpURLConnection2, null);
                                AppMethodBeat.m2505o(80462);
                                return;
                            }
                        }
                        this.vvW = this.context.getString(C25738R.string.g2q);
                        C23349c.m35862a(httpURLConnection2, null);
                        AppMethodBeat.m2505o(80462);
                        return;
                    }
                    headerField = httpURLConnection2.getContentType();
                    inputStream = httpURLConnection2.getInputStream();
                    try {
                        m35861a(headerField, httpURLConnection2.getHeaderField("Content-Disposition"), inputStream);
                        C23349c.m35862a(httpURLConnection2, inputStream);
                        AppMethodBeat.m2505o(80462);
                    } catch (Exception e2) {
                        e = e2;
                        httpURLConnection = httpURLConnection2;
                        try {
                            C4990ab.m7413e("MicroMsg.WebViewUtil", "init http url connection failed : %s", e.getMessage());
                            C23349c.m35862a(httpURLConnection, inputStream);
                            AppMethodBeat.m2505o(80462);
                        } catch (Throwable th2) {
                            th = th2;
                            C23349c.m35862a(httpURLConnection, inputStream);
                            AppMethodBeat.m2505o(80462);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        httpURLConnection = httpURLConnection2;
                        C23349c.m35862a(httpURLConnection, inputStream);
                        AppMethodBeat.m2505o(80462);
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
                    C23349c.m35862a(httpURLConnection, inputStream);
                    AppMethodBeat.m2505o(80462);
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                inputStream = null;
                httpURLConnection = null;
                C4990ab.m7413e("MicroMsg.WebViewUtil", "init http url connection failed : %s", e.getMessage());
                C23349c.m35862a(httpURLConnection, inputStream);
                AppMethodBeat.m2505o(80462);
            } catch (Throwable th22) {
                th = th22;
                inputStream = null;
                httpURLConnection = null;
                C23349c.m35862a(httpURLConnection, inputStream);
                AppMethodBeat.m2505o(80462);
                throw th;
            }
        }

        /* renamed from: a */
        private static void m35862a(HttpURLConnection httpURLConnection, InputStream inputStream) {
            AppMethodBeat.m2504i(80463);
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                    AppMethodBeat.m2505o(80463);
                    return;
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.WebViewUtil", e, "", new Object[0]);
                }
            }
            AppMethodBeat.m2505o(80463);
        }

        /* renamed from: a */
        private void m35861a(String str, String str2, InputStream inputStream) {
            Matcher matcher;
            AppMethodBeat.m2504i(80464);
            C4990ab.m7417i("MicroMsg.WebViewUtil", "contentType = %s, dispositionType = %s", str, str2);
            String str3 = null;
            if (!C5046bo.isNullOrNil(str)) {
                matcher = vvU.matcher(str);
                if (matcher.find()) {
                    str3 = matcher.group().substring(matcher.group().lastIndexOf(47) + 1);
                }
            }
            if (C5046bo.isNullOrNil(str3) && !C5046bo.isNullOrNil(str2)) {
                matcher = vvV.matcher(str2);
                if (matcher.find()) {
                    str3 = matcher.group().substring(matcher.group().lastIndexOf(46) + 1);
                }
            }
            if (C5046bo.isNullOrNil(str3)) {
                C46511s c46511s = new C46511s(this.ffl);
                int lastIndexOf = c46511s.mPath.lastIndexOf(46);
                if (lastIndexOf == -1) {
                    str3 = "jpg";
                } else {
                    str3 = c46511s.mPath.substring(lastIndexOf + 1);
                }
            }
            this.imagePath = C14987n.m23294RL(str3);
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
                        C4990ab.m7413e("MicroMsg.WebViewUtil", "close os failed : %s", e.getMessage());
                    }
                }
            }
            fileOutputStream.flush();
            fileOutputStream.close();
            if (this.opType == 0) {
                this.vvW = this.context.getString(C25738R.string.b3r, new Object[]{C14987n.dlz()});
                C14987n.m23300a(this.imagePath, this.context);
            }
            AppMethodBeat.m2505o(80464);
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
            AppMethodBeat.m2504i(80465);
            if (!this.kuU) {
                this.vvW = this.context.getString(C25738R.string.g2r);
                AppMethodBeat.m2505o(80465);
                return true;
            } else if (C5046bo.isNullOrNil(this.ffl)) {
                AppMethodBeat.m2505o(80465);
                return false;
            } else {
                int indexOf;
                if (URLUtil.isDataUrl(this.ffl)) {
                    this.imagePath = C14987n.m23294RL("jpg");
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
                            this.vvW = this.context.getString(C25738R.string.b3r, new Object[]{C14987n.dlz()});
                            C14987n.m23300a(this.imagePath, this.context);
                            try {
                                fileOutputStream2.close();
                            } catch (Exception e2) {
                                C4990ab.m7413e("MicroMsg.WebViewUtil", "close FileOutputStream failed : %s", e2.getMessage());
                            }
                        } catch (Exception e3) {
                            e2 = e3;
                            fileOutputStream = fileOutputStream2;
                            try {
                                C4990ab.m7413e("MicroMsg.WebViewUtil", "decode base64 pic failed : %s", e2.getMessage());
                                if (fileOutputStream != null) {
                                }
                                AppMethodBeat.m2505o(80465);
                                return true;
                            } catch (Throwable th3) {
                                th = th3;
                                if (fileOutputStream != null) {
                                }
                                AppMethodBeat.m2505o(80465);
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (Exception e4) {
                                    C4990ab.m7413e("MicroMsg.WebViewUtil", "close FileOutputStream failed : %s", e4.getMessage());
                                }
                            }
                            AppMethodBeat.m2505o(80465);
                            throw th;
                        }
                    } catch (Exception e5) {
                        e2 = e5;
                        C4990ab.m7413e("MicroMsg.WebViewUtil", "decode base64 pic failed : %s", e2.getMessage());
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e22) {
                                C4990ab.m7413e("MicroMsg.WebViewUtil", "close FileOutputStream failed : %s", e22.getMessage());
                            }
                        }
                        AppMethodBeat.m2505o(80465);
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
                                        headerField = httpURLConnection2.getHeaderField(C8741b.LOCATION);
                                    }
                                    C4990ab.m7417i("MicroMsg.WebViewUtil", "redirect url = %s", headerField);
                                    if (!C5046bo.isNullOrNil(headerField)) {
                                        this.ffl = headerField;
                                        dlF();
                                        C23349c.m35862a(httpURLConnection2, fileOutputStream);
                                    }
                                }
                                this.vvW = this.context.getString(C25738R.string.g2q);
                                C23349c.m35862a(httpURLConnection2, fileOutputStream);
                            } else {
                                headerField = httpURLConnection2.getContentType();
                                InputStream inputStream3 = httpURLConnection2.getInputStream();
                                try {
                                    m35861a(headerField, httpURLConnection2.getHeaderField("Content-Disposition"), inputStream3);
                                    C23349c.m35862a(httpURLConnection2, inputStream3);
                                } catch (Exception e6) {
                                    e22 = e6;
                                    inputStream2 = inputStream3;
                                    httpURLConnection = httpURLConnection2;
                                    try {
                                        C4990ab.m7413e("MicroMsg.WebViewUtil", "download https resource failed : %s", e22.getMessage());
                                        C23349c.m35862a(httpURLConnection, inputStream2);
                                        AppMethodBeat.m2505o(80465);
                                        return true;
                                    } catch (Throwable th5) {
                                        th2 = th5;
                                        C23349c.m35862a(httpURLConnection, inputStream2);
                                        AppMethodBeat.m2505o(80465);
                                        throw th2;
                                    }
                                } catch (Throwable th6) {
                                    th2 = th6;
                                    inputStream2 = inputStream3;
                                    httpURLConnection = httpURLConnection2;
                                    C23349c.m35862a(httpURLConnection, inputStream2);
                                    AppMethodBeat.m2505o(80465);
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
                            C23349c.m35862a(httpURLConnection, inputStream2);
                            AppMethodBeat.m2505o(80465);
                            throw th2;
                        }
                    } catch (Exception e8) {
                        e22 = e8;
                        inputStream2 = fileOutputStream;
                        httpURLConnection = fileOutputStream;
                        C4990ab.m7413e("MicroMsg.WebViewUtil", "download https resource failed : %s", e22.getMessage());
                        C23349c.m35862a(httpURLConnection, inputStream2);
                        AppMethodBeat.m2505o(80465);
                        return true;
                    } catch (Throwable th52) {
                        th2 = th52;
                        inputStream2 = fileOutputStream;
                        httpURLConnection = fileOutputStream;
                        C23349c.m35862a(httpURLConnection, inputStream2);
                        AppMethodBeat.m2505o(80465);
                        throw th2;
                    }
                } else {
                    dlF();
                }
                AppMethodBeat.m2505o(80465);
                return true;
            }
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.u$b */
    public interface C30151b {
        void akp(String str);
    }

    static {
        AppMethodBeat.m2504i(80489);
        AppMethodBeat.m2505o(80489);
    }

    @Deprecated
    /* renamed from: bh */
    public static String m47747bh(Context context, String str) {
        AppMethodBeat.m2504i(80467);
        String a = C10707q.m18380a(context, str, (C10708a) C37384e.m62985B(C10708a.class));
        AppMethodBeat.m2505o(80467);
        return a;
    }

    public static boolean akj(String str) {
        AppMethodBeat.m2504i(80468);
        if (str == null) {
            AppMethodBeat.m2505o(80468);
            return false;
        }
        boolean contains = str.toLowerCase().contains(" MicroMessenger/".trim().toLowerCase());
        AppMethodBeat.m2505o(80468);
        return contains;
    }

    /* renamed from: t */
    public static boolean m47751t(String str, String str2) {
        AppMethodBeat.m2504i(80469);
        boolean t = C8874h.m15849t(str, str2);
        AppMethodBeat.m2505o(80469);
        return t;
    }

    @Deprecated
    public static PackageInfo getPackageInfo(Context context, String str) {
        AppMethodBeat.m2504i(80470);
        PackageInfo packageInfo = C19679b.getPackageInfo(context, str);
        AppMethodBeat.m2505o(80470);
        return packageInfo;
    }

    /* renamed from: a */
    public static void m47740a(Context context, String str, String str2, boolean z) {
        AppMethodBeat.m2504i(80471);
        if (ghu == null) {
            ghu = new C23498az(1, "webview-save-image", 1);
        }
        ghu.mo39163e(new C23349c(context, str, str2, z));
        AppMethodBeat.m2505o(80471);
    }

    /* renamed from: a */
    public static void m47741a(Context context, String str, String str2, boolean z, C23348a c23348a) {
        AppMethodBeat.m2504i(80472);
        if (ghu == null) {
            ghu = new C23498az(1, "webview-save-image", 1);
        }
        ghu.mo39163e(new C23349c(context, str, str2, z, 1, c23348a));
        AppMethodBeat.m2505o(80472);
    }

    /* renamed from: d */
    public static void m47748d(final WebView webView) {
        AppMethodBeat.m2504i(80473);
        if (webView == null) {
            AppMethodBeat.m2505o(80473);
            return;
        }
        C30152u.m47742a(new C30151b() {
            public final void akp(String str) {
                AppMethodBeat.m2504i(80457);
                webView.evaluateJavascript(str, null);
                AppMethodBeat.m2505o(80457);
            }
        });
        AppMethodBeat.m2505o(80473);
    }

    /* renamed from: a */
    private static void m47742a(final C30151b c30151b) {
        AppMethodBeat.m2504i(80474);
        C4990ab.m7410d("MicroMsg.WebViewUtil", "initIFrame");
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(80458);
                c30151b.akp("javascript:var edw_iframe = document.getElementById('_edw_iframe_');if (edw_iframe === null) {edw_iframe = document.createElement('iframe');edw_iframe.id = '_edw_iframe_';edw_iframe.style.display = 'none';document.documentElement.appendChild(edw_iframe);}");
                AppMethodBeat.m2505o(80458);
            }
        });
        AppMethodBeat.m2505o(80474);
    }

    /* renamed from: a */
    public static void m47744a(WebView webView, String str, String str2) {
        AppMethodBeat.m2504i(80475);
        C30152u.m47745a(webView, str, str2, true);
        AppMethodBeat.m2505o(80475);
    }

    /* renamed from: a */
    public static void m47745a(final WebView webView, String str, String str2, boolean z) {
        AppMethodBeat.m2504i(80476);
        if (webView == null) {
            AppMethodBeat.m2505o(80476);
            return;
        }
        C30152u.m47743a(new C30151b() {
            public final void akp(String str) {
                AppMethodBeat.m2504i(80459);
                webView.evaluateJavascript(str, null);
                AppMethodBeat.m2505o(80459);
            }
        }, str, str2, z);
        AppMethodBeat.m2505o(80476);
    }

    /* renamed from: a */
    private static void m47743a(final C30151b c30151b, final String str, final String str2, final boolean z) {
        AppMethodBeat.m2504i(80477);
        if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2)) {
            C4990ab.m7413e("MicroMsg.WebViewUtil", "getJsResult fail, invalid argument, scheme = %s, jsCode = %s", str, str2);
            AppMethodBeat.m2505o(80477);
            return;
        }
        C4990ab.m7411d("MicroMsg.WebViewUtil", "getJsResult, scheme = %s, jsCode = %s", str, str2);
        C30152u.m47742a(c30151b);
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(80460);
                if (z) {
                    c30151b.akp("javascript:document.getElementById('_edw_iframe_').src = '" + str + "' + " + str2);
                    AppMethodBeat.m2505o(80460);
                    return;
                }
                c30151b.akp("javascript:console.log('" + str + "' + " + str2 + ")");
                AppMethodBeat.m2505o(80460);
            }
        });
        AppMethodBeat.m2505o(80477);
    }

    /* renamed from: hL */
    public static String m47750hL(String str, String str2) {
        AppMethodBeat.m2504i(80478);
        if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2)) {
            C4990ab.m7413e("MicroMsg.WebViewUtil", "genJsCode fail, invalid argument, scheme = %s, jsCode = %s", str, str2);
            AppMethodBeat.m2505o(80478);
            return null;
        }
        C4990ab.m7411d("MicroMsg.WebViewUtil", "genJsCode, scheme = %s, jsCode = %s", str, str2);
        String str3 = "document.getElementById('_edw_iframe_').src = '" + str + "' + " + str2;
        AppMethodBeat.m2505o(80478);
        return str3;
    }

    /* renamed from: aR */
    public static final String m47746aR(Map<String, Object> map) {
        AppMethodBeat.m2504i(80479);
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (!(C5046bo.isNullOrNil(str) || obj == null)) {
                if (!(obj instanceof String) || !C5046bo.isNullOrNil((String) obj)) {
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
        AppMethodBeat.m2505o(80479);
        return str2;
    }

    public static final String akk(String str) {
        AppMethodBeat.m2504i(80480);
        if (!C5046bo.isNullOrNil(str)) {
            try {
                str = URLEncoder.encode(str, ProtocolPackage.ServerEncoding);
                AppMethodBeat.m2505o(80480);
            } catch (UnsupportedEncodingException e) {
                C4990ab.m7413e("MicroMsg.WebViewUtil", "URLEncode fail, throw : %s", e.getMessage());
            }
            return str;
        }
        AppMethodBeat.m2505o(80480);
        return str;
    }

    public static final String akl(String str) {
        AppMethodBeat.m2504i(80481);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(80481);
            return str;
        }
        byte[] bytes;
        try {
            bytes = str.getBytes(ProtocolPackage.ServerEncoding);
        } catch (UnsupportedEncodingException e) {
            UnsupportedEncodingException unsupportedEncodingException = e;
            bytes = str.getBytes();
            C4990ab.m7413e("MicroMsg.WebViewUtil", "getBytes fail, throw : %s", unsupportedEncodingException.getMessage());
        }
        str = Base64.encodeToString(bytes, 2);
        AppMethodBeat.m2505o(80481);
        return str;
    }

    /* renamed from: fU */
    private static String m47749fU(Context context) {
        WifiInfo connectionInfo;
        AppMethodBeat.m2504i(80482);
        try {
            connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
        } catch (Exception e) {
            connectionInfo = null;
        }
        String str;
        if (connectionInfo == null) {
            str = "127.0.0.1";
            AppMethodBeat.m2505o(80482);
            return str;
        }
        int ipAddress = connectionInfo.getIpAddress();
        str = String.format("%d.%d.%d.%d", new Object[]{Integer.valueOf(ipAddress & 255), Integer.valueOf((ipAddress >> 8) & 255), Integer.valueOf((ipAddress >> 16) & 255), Integer.valueOf((ipAddress >> 24) & 255)});
        AppMethodBeat.m2505o(80482);
        return str;
    }

    public static String bOO() {
        int i = 0;
        AppMethodBeat.m2504i(80483);
        try {
            i = C18172y.m28611Me();
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.WebViewUtil", "getSelfIp, call NetworkDetailInfo.getNetType(), exp = %s", e);
        }
        String str;
        if (i == 0) {
            str = "127.0.0.1";
            AppMethodBeat.m2505o(80483);
            return str;
        } else if (i == 1) {
            str = C30152u.m47749fU(C4996ah.getContext());
            AppMethodBeat.m2505o(80483);
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
                                if (C5046bo.isNullOrNil(inetAddress.getHostAddress())) {
                                    str = "127.0.0.1";
                                    AppMethodBeat.m2505o(80483);
                                    return str;
                                }
                                str = inetAddress.getHostAddress();
                                AppMethodBeat.m2505o(80483);
                                return str;
                            }
                        }
                        continue;
                    }
                }
            } catch (Exception e2) {
            }
            str = "127.0.0.1";
            AppMethodBeat.m2505o(80483);
            return str;
        }
    }

    public static String akm(String str) {
        AppMethodBeat.m2504i(80484);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(80484);
            return null;
        } else if (vvQ.matcher(str).matches()) {
            String trim = str.substring(str.indexOf("base64,") + 7).trim();
            AppMethodBeat.m2505o(80484);
            return trim;
        } else {
            AppMethodBeat.m2505o(80484);
            return null;
        }
    }

    public static String cXS() {
        AppMethodBeat.m2504i(80485);
        ConnectivityManager connectivityManager = (ConnectivityManager) C4996ah.getContext().getSystemService("connectivity");
        String str;
        if (connectivityManager == null) {
            str = "no";
            AppMethodBeat.m2505o(80485);
            return str;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            str = "no";
            AppMethodBeat.m2505o(80485);
            return str;
        } else if (activeNetworkInfo.getType() == 1) {
            str = "WIFI";
            AppMethodBeat.m2505o(80485);
            return str;
        } else {
            C4990ab.m7411d("MicroMsg.WebViewUtil", "activeNetInfo extra=%s, type=%d, %s", activeNetworkInfo.getExtraInfo(), Integer.valueOf(activeNetworkInfo.getType()), activeNetworkInfo.getExtraInfo());
            if (activeNetworkInfo.getExtraInfo() != null) {
                str = activeNetworkInfo.getExtraInfo().toLowerCase();
                AppMethodBeat.m2505o(80485);
                return str;
            }
            str = "no";
            AppMethodBeat.m2505o(80485);
            return str;
        }
    }

    public static String akn(String str) {
        AppMethodBeat.m2504i(80486);
        String str2 = "";
        if (str != null && str.startsWith("Refused to frame")) {
            String[] split = str.split("'");
            if (split.length > 2) {
                str2 = split[1];
            }
        }
        AppMethodBeat.m2505o(80486);
        return str2;
    }

    @Deprecated
    public static String ako(String str) {
        AppMethodBeat.m2504i(80487);
        String ako = C44216b.ako(str);
        AppMethodBeat.m2505o(80487);
        return ako;
    }

    public static String aef(String str) {
        AppMethodBeat.m2504i(80488);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(80488);
            return str;
        }
        int indexOf = str.indexOf("#");
        if (indexOf < 0) {
            AppMethodBeat.m2505o(80488);
            return str;
        }
        str = str.substring(0, indexOf);
        AppMethodBeat.m2505o(80488);
        return str;
    }
}
