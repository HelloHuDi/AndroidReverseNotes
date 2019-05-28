package com.tencent.mm.plugin.appbrand.jsapi.websocket;

import com.tencent.luggage.a.e;
import com.tencent.mars.cdn.AndroidCertVerifyResult;
import com.tencent.mars.cdn.X509Util;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiPauseDownloadTask;
import com.tencent.mm.plugin.appbrand.l.j;
import com.tencent.mm.plugin.appbrand.t.e.d;
import com.tencent.mm.plugin.appbrand.t.e.f;
import com.tencent.mm.plugin.appbrand.t.e.h;
import com.tencent.mm.sdk.platformtools.ab;
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

public final class b implements e {
    private String hvr;
    private String ibQ;
    private URI ibR;
    private ArrayList ibS = new ArrayList();
    private ArrayList ibT = new ArrayList();
    private WssConfig ibU;
    private int ibV = -1;
    private ArrayList<String> ibW;
    private com.tencent.mm.plugin.appbrand.jsapi.websocket.e.a ibX;
    private com.tencent.mm.plugin.appbrand.jsapi.websocket.WcWss.a ibY;
    private a ibZ = a.NOT_YET_CONNECTED;
    private Map<String, String> mHeaders;
    private Timer mTimer = null;
    private X509TrustManager mTrustManager;
    private String mUrl;

    public enum a {
        NOT_YET_CONNECTED,
        CONNECTING,
        OPEN,
        CLOSING,
        CLOSED;

        static {
            AppMethodBeat.o(108106);
        }
    }

    public b(String str, String str2, URI uri, Map<String, String> map, WssConfig wssConfig, ArrayList<String> arrayList, com.tencent.mm.plugin.appbrand.l.a aVar) {
        AppMethodBeat.i(108107);
        this.ibQ = str;
        this.mUrl = str2;
        this.ibR = uri;
        this.mHeaders = map;
        this.ibU = wssConfig;
        this.ibW = arrayList;
        this.mTrustManager = j.b(aVar);
        if (this.mHeaders == null) {
            ab.e("MicroMsg.AppBrandWcWssSocket", "header is null");
            AppMethodBeat.o(108107);
            return;
        }
        for (Entry entry : this.mHeaders.entrySet()) {
            this.ibS.add(entry.getKey());
            this.ibT.add(entry.getValue());
        }
        AppMethodBeat.o(108107);
    }

    public final void a(com.tencent.mm.plugin.appbrand.jsapi.websocket.e.a aVar) {
        AppMethodBeat.i(108108);
        ab.i("MicroMsg.AppBrandWcWssSocket", "setCallBack");
        this.ibX = aVar;
        this.ibY = new com.tencent.mm.plugin.appbrand.jsapi.websocket.WcWss.a() {
            public final void onHandShake(String str, int i, String[] strArr, String[] strArr2) {
                AppMethodBeat.i(108099);
                ab.i("MicroMsg.AppBrandWcWssSocket", "onHandShake group:%s, wssId:%s", str, Integer.valueOf(i));
                b.this.ibX.a((com.tencent.mm.plugin.appbrand.t.e.a) b.a(b.this, 1, strArr, strArr2));
                AppMethodBeat.o(108099);
            }

            public final void onOpen(String str, int i, boolean z, String[] strArr, String[] strArr2, int i2, String str2) {
                AppMethodBeat.i(108100);
                ab.i("MicroMsg.AppBrandWcWssSocket", "onOpen group:%s,isSuc:%s, msg:%s, code:%s, wssId:%s", str, Boolean.valueOf(z), str2, Integer.valueOf(i2), Integer.valueOf(i));
                if (z) {
                    b.this.ibZ = a.OPEN;
                    b.this.ibX.b((h) b.a(b.this, 2, strArr, strArr2));
                    AppMethodBeat.o(108100);
                    return;
                }
                b.this.ibX.zJ("onOpen fail code:" + i2 + ", msg:" + str2);
                AppMethodBeat.o(108100);
            }

            public final void onMessage(String str, int i, byte[] bArr, boolean z) {
                AppMethodBeat.i(108101);
                ab.i("MicroMsg.AppBrandWcWssSocket", "onMessage group:%s,wssId:%s,isText:%s", str, Integer.valueOf(i), Boolean.valueOf(z));
                if (z) {
                    try {
                        b.this.ibX.BB(new String(bArr, ProtocolPackage.ServerEncoding));
                        AppMethodBeat.o(108101);
                        return;
                    } catch (UnsupportedEncodingException e) {
                        ab.printErrStackTrace("MicroMsg.AppBrandWcWssSocket", e, "onmessage unsupport encoding UnsupportedEncodingException", new Object[0]);
                        AppMethodBeat.o(108101);
                        return;
                    }
                }
                b.this.ibX.l(ByteBuffer.wrap(bArr));
                AppMethodBeat.o(108101);
            }

            public final void onClose(String str, int i, int i2, String str2) {
                AppMethodBeat.i(108102);
                ab.i("MicroMsg.AppBrandWcWssSocket", "onClose group:%s,id:%s, reason:%s, code:%s", str, Integer.valueOf(i), str2, Integer.valueOf(i2));
                b.this.ibZ = a.CLOSED;
                b.this.ibX.K(i2, str2);
                AppMethodBeat.o(108102);
            }

            public final int doCertificateVerify(String str, byte[][] bArr) {
                AppMethodBeat.i(108103);
                ab.i("MicroMsg.AppBrandWcWssSocket", "certifivate verify for ".concat(String.valueOf(str)));
                try {
                    AndroidCertVerifyResult verifyServerCertificates = X509Util.verifyServerCertificates(bArr, "RSA", str, 1, b.this.mTrustManager);
                    ab.i("MicroMsg.AppBrandWcWssSocket", "host %s rsa verify result %d, isknownroots %b, ishostmatched %b", str, Integer.valueOf(verifyServerCertificates.getStatus()), Boolean.valueOf(verifyServerCertificates.isIssuedByKnownRoot()), Boolean.valueOf(verifyServerCertificates.isIssuedByHostMatched()));
                    if (verifyServerCertificates.getStatus() != 0) {
                        verifyServerCertificates = X509Util.verifyServerCertificates(bArr, "ECDSA", str, 1, b.this.mTrustManager);
                        ab.i("MicroMsg.AppBrandWcWssSocket", "host %s ecdsa verify result %d, isknownroots %b, ishostmatched %b", str, Integer.valueOf(verifyServerCertificates.getStatus()), Boolean.valueOf(verifyServerCertificates.isIssuedByKnownRoot()), Boolean.valueOf(verifyServerCertificates.isIssuedByHostMatched()));
                    }
                    AndroidCertVerifyResult androidCertVerifyResult = verifyServerCertificates;
                    if (androidCertVerifyResult.getStatus() != 0) {
                        ((com.tencent.mm.plugin.appbrand.n.a) e.C(com.tencent.mm.plugin.appbrand.n.a.class)).f(972, 7, 1);
                    }
                    if (androidCertVerifyResult.getStatus() == 0 && !androidCertVerifyResult.isIssuedByHostMatched()) {
                        ((com.tencent.mm.plugin.appbrand.n.a) e.C(com.tencent.mm.plugin.appbrand.n.a.class)).f(972, 8, 1);
                    }
                    if (androidCertVerifyResult.getStatus() == 0 && !androidCertVerifyResult.isIssuedByKnownRoot()) {
                        ((com.tencent.mm.plugin.appbrand.n.a) e.C(com.tencent.mm.plugin.appbrand.n.a.class)).f(972, 9, 1);
                    }
                    if (androidCertVerifyResult.getStatus() == 0 && androidCertVerifyResult.isIssuedByKnownRoot()) {
                        AppMethodBeat.o(108103);
                        return 0;
                    }
                    AppMethodBeat.o(108103);
                    return -1;
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.AppBrandWcWssSocket", e, "doCertificateVerify Exception", new Object[0]);
                    AppMethodBeat.o(108103);
                    return -1;
                }
            }
        };
        AppMethodBeat.o(108108);
    }

    public final String aBA() {
        return this.hvr;
    }

    public final void BT(String str) {
        this.hvr = str;
    }

    public final Timer aGo() {
        return this.mTimer;
    }

    public final void a(Timer timer) {
        this.mTimer = timer;
    }

    public final void close() {
        AppMethodBeat.i(108109);
        ab.i("MicroMsg.AppBrandWcWssSocket", "close");
        bk("default_close", 1000);
        AppMethodBeat.o(108109);
    }

    public final void bk(String str, int i) {
        AppMethodBeat.i(108110);
        ab.i("MicroMsg.AppBrandWcWssSocket", "close reason:%s,code:%s", str, Integer.valueOf(i));
        if (this.ibV < 0) {
            this.ibX.zJ("error socket id");
            AppMethodBeat.o(108110);
            return;
        }
        if (!(this.ibZ == a.CLOSING || this.ibZ == a.CLOSED)) {
            this.ibZ = a.CLOSING;
        }
        WcWss.closeSocket(this.ibQ, this.ibV, i, str);
        AppMethodBeat.o(108110);
    }

    public final boolean isOpen() {
        return this.ibZ == a.OPEN;
    }

    public final void BU(String str) {
        AppMethodBeat.i(108111);
        ab.i("MicroMsg.AppBrandWcWssSocket", "send text");
        if (this.ibV < 0) {
            this.ibX.zJ("error socket id");
            AppMethodBeat.o(108111);
            return;
        }
        try {
            ByteBuffer wrap = ByteBuffer.wrap(str.getBytes("UTF8"));
            byte[] bArr = new byte[wrap.remaining()];
            wrap.get(bArr);
            WcWss.sendBuffer(this.ibQ, this.ibV, bArr, true);
            AppMethodBeat.o(108111);
        } catch (UnsupportedEncodingException e) {
            ab.printErrStackTrace("MicroMsg.AppBrandWcWssSocket", e, "unsupport encoding UnsupportedEncodingException", new Object[0]);
            this.ibX.zJ("unsupport encoding");
            AppMethodBeat.o(108111);
        }
    }

    public final void p(ByteBuffer byteBuffer) {
        AppMethodBeat.i(108112);
        ab.i("MicroMsg.AppBrandWcWssSocket", "send bytes");
        if (this.ibV < 0) {
            this.ibX.zJ("error socket id");
            AppMethodBeat.o(108112);
            return;
        }
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr);
        WcWss.sendBuffer(this.ibQ, this.ibV, bArr, false);
        AppMethodBeat.o(108112);
    }

    public final void connect() {
        AppMethodBeat.i(108113);
        ab.i("MicroMsg.AppBrandWcWssSocket", "connect");
        if (this.mHeaders == null) {
            this.ibX.zJ("header is null");
            AppMethodBeat.o(108113);
            return;
        }
        this.ibV = WcWss.a(this.ibY, this.ibQ, this.mUrl, this.ibS.toArray(), this.ibT.toArray(), this.ibU, this.ibW.toArray());
        if (this.ibV < 0) {
            this.ibX.zJ("call connect fail code:" + this.ibV);
        }
        ab.i("MicroMsg.AppBrandWcWssSocket", "connect mWcWssId:%s", Integer.valueOf(this.ibV));
        AppMethodBeat.o(108113);
    }

    public final void setTcpNoDelay(boolean z) {
    }

    public final void a(Socket socket) {
    }

    public final Socket getSocket() {
        return null;
    }

    static /* synthetic */ f a(b bVar, int i, String[] strArr, String[] strArr2) {
        int i2 = 0;
        AppMethodBeat.i(108114);
        if (i == 1) {
            String path = bVar.ibR.getPath();
            String query = bVar.ibR.getQuery();
            if (path == null || path.length() == 0) {
                path = "/";
            }
            if (query != null) {
                path = path + "?" + query;
            }
            int port = bVar.ibR.getPort();
            if (port == -1) {
                String scheme = bVar.ibR.getScheme();
                if (scheme.equals("wss")) {
                    port = JsApiPauseDownloadTask.CTRL_INDEX;
                } else if (scheme.equals("ws")) {
                    port = 80;
                } else {
                    ab.e("MicroMsg.AppBrandWcWssSocket", "getPort unkonow scheme:%s", scheme);
                }
            }
            if (port == -1 || port == 80) {
                query = bVar.ibR.getHost();
            } else {
                query = bVar.ibR.getHost() + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + port;
            }
            d dVar = new d();
            dVar.Eo(path);
            dVar.put("Host", query);
            if (strArr == null || strArr2 == null) {
                ab.i("MicroMsg.AppBrandWcWssSocket", "buildHandshake header args is null type:%s", Integer.valueOf(i));
                if (bVar.mHeaders != null) {
                    for (Entry entry : bVar.mHeaders.entrySet()) {
                        dVar.put((String) entry.getKey(), (String) entry.getValue());
                    }
                } else {
                    ab.w("MicroMsg.AppBrandWcWssSocket", "buildHandshake mHeaders is null type:%s", Integer.valueOf(i));
                }
            } else if (strArr.length == strArr2.length) {
                for (int i3 = 0; i3 < strArr.length; i3++) {
                    dVar.put(strArr[i3], strArr2[i3]);
                }
                ab.i("MicroMsg.AppBrandWcWssSocket", "buildHandshake headerKey.length:%s, type:%s", Integer.valueOf(strArr.length), Integer.valueOf(i));
            } else {
                ab.w("MicroMsg.AppBrandWcWssSocket", "buildHandshake headerKey != headerValue type:%s", Integer.valueOf(i));
            }
            AppMethodBeat.o(108114);
            return dVar;
        } else if (i == 2) {
            f eVar = new com.tencent.mm.plugin.appbrand.t.e.e();
            if (strArr == null || strArr2 == null) {
                ab.w("MicroMsg.AppBrandWcWssSocket", "buildHandshake header args is null type:%s", Integer.valueOf(i));
            } else if (strArr.length == strArr2.length) {
                while (i2 < strArr.length) {
                    eVar.put(strArr[i2], strArr2[i2]);
                    i2++;
                }
            } else {
                ab.w("MicroMsg.AppBrandWcWssSocket", "buildHandshake headerKey != headerValue type:%s", Integer.valueOf(i));
            }
            AppMethodBeat.o(108114);
            return eVar;
        } else {
            ab.w("MicroMsg.AppBrandWcWssSocket", "buildHandshake unknow type:%s", Integer.valueOf(i));
            AppMethodBeat.o(108114);
            return null;
        }
    }
}
