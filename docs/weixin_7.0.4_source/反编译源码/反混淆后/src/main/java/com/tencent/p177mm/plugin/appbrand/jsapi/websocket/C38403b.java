package com.tencent.p177mm.plugin.appbrand.jsapi.websocket;

import com.tencent.luggage.p1170a.C37384e;
import com.tencent.mars.cdn.AndroidCertVerifyResult;
import com.tencent.mars.cdn.X509Util;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.appdownload.JsApiPauseDownloadTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.websocket.C27135e.C27134a;
import com.tencent.p177mm.plugin.appbrand.jsapi.websocket.WcWss.C2353a;
import com.tencent.p177mm.plugin.appbrand.p321l.C19538j;
import com.tencent.p177mm.plugin.appbrand.p321l.C38414a;
import com.tencent.p177mm.plugin.appbrand.p326n.C2402a;
import com.tencent.p177mm.plugin.appbrand.p332t.p914e.C10742f;
import com.tencent.p177mm.plugin.appbrand.p332t.p914e.C16696h;
import com.tencent.p177mm.plugin.appbrand.p332t.p914e.C38514a;
import com.tencent.p177mm.plugin.appbrand.p332t.p914e.C42688d;
import com.tencent.p177mm.plugin.appbrand.p332t.p914e.C42689e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Timer;
import javax.net.ssl.X509TrustManager;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.websocket.b */
public final class C38403b implements C27135e {
    private String hvr;
    private String ibQ;
    private URI ibR;
    private ArrayList ibS = new ArrayList();
    private ArrayList ibT = new ArrayList();
    private WssConfig ibU;
    private int ibV = -1;
    private ArrayList<String> ibW;
    private C27134a ibX;
    private C2353a ibY;
    private C38404a ibZ = C38404a.NOT_YET_CONNECTED;
    private Map<String, String> mHeaders;
    private Timer mTimer = null;
    private X509TrustManager mTrustManager;
    private String mUrl;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.websocket.b$1 */
    class C334191 implements C2353a {
        C334191() {
        }

        public final void onHandShake(String str, int i, String[] strArr, String[] strArr2) {
            AppMethodBeat.m2504i(108099);
            C4990ab.m7417i("MicroMsg.AppBrandWcWssSocket", "onHandShake group:%s, wssId:%s", str, Integer.valueOf(i));
            C38403b.this.ibX.mo44796a((C38514a) C38403b.m64978a(C38403b.this, 1, strArr, strArr2));
            AppMethodBeat.m2505o(108099);
        }

        public final void onOpen(String str, int i, boolean z, String[] strArr, String[] strArr2, int i2, String str2) {
            AppMethodBeat.m2504i(108100);
            C4990ab.m7417i("MicroMsg.AppBrandWcWssSocket", "onOpen group:%s,isSuc:%s, msg:%s, code:%s, wssId:%s", str, Boolean.valueOf(z), str2, Integer.valueOf(i2), Integer.valueOf(i));
            if (z) {
                C38403b.this.ibZ = C38404a.OPEN;
                C38403b.this.ibX.mo44797b((C16696h) C38403b.m64978a(C38403b.this, 2, strArr, strArr2));
                AppMethodBeat.m2505o(108100);
                return;
            }
            C38403b.this.ibX.mo44799zJ("onOpen fail code:" + i2 + ", msg:" + str2);
            AppMethodBeat.m2505o(108100);
        }

        public final void onMessage(String str, int i, byte[] bArr, boolean z) {
            AppMethodBeat.m2504i(108101);
            C4990ab.m7417i("MicroMsg.AppBrandWcWssSocket", "onMessage group:%s,wssId:%s,isText:%s", str, Integer.valueOf(i), Boolean.valueOf(z));
            if (z) {
                try {
                    C38403b.this.ibX.mo44794BB(new String(bArr, ProtocolPackage.ServerEncoding));
                    AppMethodBeat.m2505o(108101);
                    return;
                } catch (UnsupportedEncodingException e) {
                    C4990ab.printErrStackTrace("MicroMsg.AppBrandWcWssSocket", e, "onmessage unsupport encoding UnsupportedEncodingException", new Object[0]);
                    AppMethodBeat.m2505o(108101);
                    return;
                }
            }
            C38403b.this.ibX.mo44798l(ByteBuffer.wrap(bArr));
            AppMethodBeat.m2505o(108101);
        }

        public final void onClose(String str, int i, int i2, String str2) {
            AppMethodBeat.m2504i(108102);
            C4990ab.m7417i("MicroMsg.AppBrandWcWssSocket", "onClose group:%s,id:%s, reason:%s, code:%s", str, Integer.valueOf(i), str2, Integer.valueOf(i2));
            C38403b.this.ibZ = C38404a.CLOSED;
            C38403b.this.ibX.mo44795K(i2, str2);
            AppMethodBeat.m2505o(108102);
        }

        public final int doCertificateVerify(String str, byte[][] bArr) {
            AppMethodBeat.m2504i(108103);
            C4990ab.m7416i("MicroMsg.AppBrandWcWssSocket", "certifivate verify for ".concat(String.valueOf(str)));
            try {
                AndroidCertVerifyResult verifyServerCertificates = X509Util.verifyServerCertificates(bArr, "RSA", str, 1, C38403b.this.mTrustManager);
                C4990ab.m7417i("MicroMsg.AppBrandWcWssSocket", "host %s rsa verify result %d, isknownroots %b, ishostmatched %b", str, Integer.valueOf(verifyServerCertificates.getStatus()), Boolean.valueOf(verifyServerCertificates.isIssuedByKnownRoot()), Boolean.valueOf(verifyServerCertificates.isIssuedByHostMatched()));
                if (verifyServerCertificates.getStatus() != 0) {
                    verifyServerCertificates = X509Util.verifyServerCertificates(bArr, "ECDSA", str, 1, C38403b.this.mTrustManager);
                    C4990ab.m7417i("MicroMsg.AppBrandWcWssSocket", "host %s ecdsa verify result %d, isknownroots %b, ishostmatched %b", str, Integer.valueOf(verifyServerCertificates.getStatus()), Boolean.valueOf(verifyServerCertificates.isIssuedByKnownRoot()), Boolean.valueOf(verifyServerCertificates.isIssuedByHostMatched()));
                }
                AndroidCertVerifyResult androidCertVerifyResult = verifyServerCertificates;
                if (androidCertVerifyResult.getStatus() != 0) {
                    ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(972, 7, 1);
                }
                if (androidCertVerifyResult.getStatus() == 0 && !androidCertVerifyResult.isIssuedByHostMatched()) {
                    ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(972, 8, 1);
                }
                if (androidCertVerifyResult.getStatus() == 0 && !androidCertVerifyResult.isIssuedByKnownRoot()) {
                    ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(972, 9, 1);
                }
                if (androidCertVerifyResult.getStatus() == 0 && androidCertVerifyResult.isIssuedByKnownRoot()) {
                    AppMethodBeat.m2505o(108103);
                    return 0;
                }
                AppMethodBeat.m2505o(108103);
                return -1;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.AppBrandWcWssSocket", e, "doCertificateVerify Exception", new Object[0]);
                AppMethodBeat.m2505o(108103);
                return -1;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.websocket.b$a */
    public enum C38404a {
        NOT_YET_CONNECTED,
        CONNECTING,
        OPEN,
        CLOSING,
        CLOSED;

        static {
            AppMethodBeat.m2505o(108106);
        }
    }

    public C38403b(String str, String str2, URI uri, Map<String, String> map, WssConfig wssConfig, ArrayList<String> arrayList, C38414a c38414a) {
        AppMethodBeat.m2504i(108107);
        this.ibQ = str;
        this.mUrl = str2;
        this.ibR = uri;
        this.mHeaders = map;
        this.ibU = wssConfig;
        this.ibW = arrayList;
        this.mTrustManager = C19538j.m30271b(c38414a);
        if (this.mHeaders == null) {
            C4990ab.m7412e("MicroMsg.AppBrandWcWssSocket", "header is null");
            AppMethodBeat.m2505o(108107);
            return;
        }
        for (Entry entry : this.mHeaders.entrySet()) {
            this.ibS.add(entry.getKey());
            this.ibT.add(entry.getValue());
        }
        AppMethodBeat.m2505o(108107);
    }

    /* renamed from: a */
    public final void mo34732a(C27134a c27134a) {
        AppMethodBeat.m2504i(108108);
        C4990ab.m7416i("MicroMsg.AppBrandWcWssSocket", "setCallBack");
        this.ibX = c27134a;
        this.ibY = new C334191();
        AppMethodBeat.m2505o(108108);
    }

    public final String aBA() {
        return this.hvr;
    }

    /* renamed from: BT */
    public final void mo44800BT(String str) {
        this.hvr = str;
    }

    public final Timer aGo() {
        return this.mTimer;
    }

    /* renamed from: a */
    public final void mo44803a(Timer timer) {
        this.mTimer = timer;
    }

    public final void close() {
        AppMethodBeat.m2504i(108109);
        C4990ab.m7416i("MicroMsg.AppBrandWcWssSocket", "close");
        mo44806bk("default_close", 1000);
        AppMethodBeat.m2505o(108109);
    }

    /* renamed from: bk */
    public final void mo44806bk(String str, int i) {
        AppMethodBeat.m2504i(108110);
        C4990ab.m7417i("MicroMsg.AppBrandWcWssSocket", "close reason:%s,code:%s", str, Integer.valueOf(i));
        if (this.ibV < 0) {
            this.ibX.mo44799zJ("error socket id");
            AppMethodBeat.m2505o(108110);
            return;
        }
        if (!(this.ibZ == C38404a.CLOSING || this.ibZ == C38404a.CLOSED)) {
            this.ibZ = C38404a.CLOSING;
        }
        WcWss.closeSocket(this.ibQ, this.ibV, i, str);
        AppMethodBeat.m2505o(108110);
    }

    public final boolean isOpen() {
        return this.ibZ == C38404a.OPEN;
    }

    /* renamed from: BU */
    public final void mo44801BU(String str) {
        AppMethodBeat.m2504i(108111);
        C4990ab.m7416i("MicroMsg.AppBrandWcWssSocket", "send text");
        if (this.ibV < 0) {
            this.ibX.mo44799zJ("error socket id");
            AppMethodBeat.m2505o(108111);
            return;
        }
        try {
            ByteBuffer wrap = ByteBuffer.wrap(str.getBytes("UTF8"));
            byte[] bArr = new byte[wrap.remaining()];
            wrap.get(bArr);
            WcWss.sendBuffer(this.ibQ, this.ibV, bArr, true);
            AppMethodBeat.m2505o(108111);
        } catch (UnsupportedEncodingException e) {
            C4990ab.printErrStackTrace("MicroMsg.AppBrandWcWssSocket", e, "unsupport encoding UnsupportedEncodingException", new Object[0]);
            this.ibX.mo44799zJ("unsupport encoding");
            AppMethodBeat.m2505o(108111);
        }
    }

    /* renamed from: p */
    public final void mo44811p(ByteBuffer byteBuffer) {
        AppMethodBeat.m2504i(108112);
        C4990ab.m7416i("MicroMsg.AppBrandWcWssSocket", "send bytes");
        if (this.ibV < 0) {
            this.ibX.mo44799zJ("error socket id");
            AppMethodBeat.m2505o(108112);
            return;
        }
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr);
        WcWss.sendBuffer(this.ibQ, this.ibV, bArr, false);
        AppMethodBeat.m2505o(108112);
    }

    public final void connect() {
        AppMethodBeat.m2504i(108113);
        C4990ab.m7416i("MicroMsg.AppBrandWcWssSocket", "connect");
        if (this.mHeaders == null) {
            this.ibX.mo44799zJ("header is null");
            AppMethodBeat.m2505o(108113);
            return;
        }
        this.ibV = WcWss.m75411a(this.ibY, this.ibQ, this.mUrl, this.ibS.toArray(), this.ibT.toArray(), this.ibU, this.ibW.toArray());
        if (this.ibV < 0) {
            this.ibX.mo44799zJ("call connect fail code:" + this.ibV);
        }
        C4990ab.m7417i("MicroMsg.AppBrandWcWssSocket", "connect mWcWssId:%s", Integer.valueOf(this.ibV));
        AppMethodBeat.m2505o(108113);
    }

    public final void setTcpNoDelay(boolean z) {
    }

    /* renamed from: a */
    public final void mo44802a(Socket socket) {
    }

    public final Socket getSocket() {
        return null;
    }

    /* renamed from: a */
    static /* synthetic */ C10742f m64978a(C38403b c38403b, int i, String[] strArr, String[] strArr2) {
        int i2 = 0;
        AppMethodBeat.m2504i(108114);
        if (i == 1) {
            String path = c38403b.ibR.getPath();
            String query = c38403b.ibR.getQuery();
            if (path == null || path.length() == 0) {
                path = "/";
            }
            if (query != null) {
                path = path + "?" + query;
            }
            int port = c38403b.ibR.getPort();
            if (port == -1) {
                String scheme = c38403b.ibR.getScheme();
                if (scheme.equals("wss")) {
                    port = JsApiPauseDownloadTask.CTRL_INDEX;
                } else if (scheme.equals("ws")) {
                    port = 80;
                } else {
                    C4990ab.m7413e("MicroMsg.AppBrandWcWssSocket", "getPort unkonow scheme:%s", scheme);
                }
            }
            if (port == -1 || port == 80) {
                query = c38403b.ibR.getHost();
            } else {
                query = c38403b.ibR.getHost() + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + port;
            }
            C42688d c42688d = new C42688d();
            c42688d.mo68091Eo(path);
            c42688d.put("Host", query);
            if (strArr == null || strArr2 == null) {
                C4990ab.m7417i("MicroMsg.AppBrandWcWssSocket", "buildHandshake header args is null type:%s", Integer.valueOf(i));
                if (c38403b.mHeaders != null) {
                    for (Entry entry : c38403b.mHeaders.entrySet()) {
                        c42688d.put((String) entry.getKey(), (String) entry.getValue());
                    }
                } else {
                    C4990ab.m7421w("MicroMsg.AppBrandWcWssSocket", "buildHandshake mHeaders is null type:%s", Integer.valueOf(i));
                }
            } else if (strArr.length == strArr2.length) {
                for (int i3 = 0; i3 < strArr.length; i3++) {
                    c42688d.put(strArr[i3], strArr2[i3]);
                }
                C4990ab.m7417i("MicroMsg.AppBrandWcWssSocket", "buildHandshake headerKey.length:%s, type:%s", Integer.valueOf(strArr.length), Integer.valueOf(i));
            } else {
                C4990ab.m7421w("MicroMsg.AppBrandWcWssSocket", "buildHandshake headerKey != headerValue type:%s", Integer.valueOf(i));
            }
            AppMethodBeat.m2505o(108114);
            return c42688d;
        } else if (i == 2) {
            C10742f c42689e = new C42689e();
            if (strArr == null || strArr2 == null) {
                C4990ab.m7421w("MicroMsg.AppBrandWcWssSocket", "buildHandshake header args is null type:%s", Integer.valueOf(i));
            } else if (strArr.length == strArr2.length) {
                while (i2 < strArr.length) {
                    c42689e.put(strArr[i2], strArr2[i2]);
                    i2++;
                }
            } else {
                C4990ab.m7421w("MicroMsg.AppBrandWcWssSocket", "buildHandshake headerKey != headerValue type:%s", Integer.valueOf(i));
            }
            AppMethodBeat.m2505o(108114);
            return c42689e;
        } else {
            C4990ab.m7421w("MicroMsg.AppBrandWcWssSocket", "buildHandshake unknow type:%s", Integer.valueOf(i));
            AppMethodBeat.m2505o(108114);
            return null;
        }
    }
}
