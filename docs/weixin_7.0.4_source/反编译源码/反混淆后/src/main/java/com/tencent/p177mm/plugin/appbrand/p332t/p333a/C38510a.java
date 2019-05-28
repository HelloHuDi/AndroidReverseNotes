package com.tencent.p177mm.plugin.appbrand.p332t.p333a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.appdownload.JsApiPauseDownloadTask;
import com.tencent.p177mm.plugin.appbrand.p332t.C33526a;
import com.tencent.p177mm.plugin.appbrand.p332t.C33530b;
import com.tencent.p177mm.plugin.appbrand.p332t.C36731c;
import com.tencent.p177mm.plugin.appbrand.p332t.p1232d.C33533d;
import com.tencent.p177mm.plugin.appbrand.p332t.p334b.C38512a;
import com.tencent.p177mm.plugin.appbrand.p332t.p335c.C2463d;
import com.tencent.p177mm.plugin.appbrand.p332t.p335c.C27301b;
import com.tencent.p177mm.plugin.appbrand.p332t.p914e.C10742f;
import com.tencent.p177mm.plugin.appbrand.p332t.p914e.C16696h;
import com.tencent.p177mm.plugin.appbrand.p332t.p914e.C42688d;
import com.tencent.p177mm.plugin.appbrand.p332t.p914e.C45692b;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Timer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLException;

/* renamed from: com.tencent.mm.plugin.appbrand.t.a.a */
public abstract class C38510a extends C33530b implements C33526a, Runnable {
    private Map<String, String> headers;
    private String hvr;
    private C38512a iSE;
    protected URI iSN = null;
    public C36731c iSO = null;
    private Socket iSP = null;
    private InputStream iSQ;
    OutputStream iSR;
    private Proxy iSS = Proxy.NO_PROXY;
    private Runnable iST;
    private CountDownLatch iSU = new CountDownLatch(1);
    private CountDownLatch iSV = new CountDownLatch(1);
    private int iSW = 0;
    private Timer mTimer = null;

    /* renamed from: com.tencent.mm.plugin.appbrand.t.a.a$a */
    class C2460a implements Runnable {
        volatile boolean isStop;

        private C2460a() {
            this.isStop = false;
        }

        /* synthetic */ C2460a(C38510a c38510a, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.m2504i(73226);
            while (!this.isStop && !Thread.interrupted()) {
                ByteBuffer byteBuffer;
                try {
                    Object obj;
                    if (C38510a.this.iSO.iSy.isEmpty()) {
                        obj = null;
                    } else {
                        obj = 1;
                    }
                    if (obj != null) {
                        byteBuffer = (ByteBuffer) C38510a.this.iSO.iSy.poll(1000, TimeUnit.MILLISECONDS);
                        if (byteBuffer != null) {
                            C38510a.this.iSR.write(byteBuffer.array(), 0, byteBuffer.limit());
                            C38510a.this.iSR.flush();
                        }
                    }
                } catch (InterruptedException e) {
                    try {
                        for (ByteBuffer byteBuffer2 : C38510a.this.iSO.iSy) {
                            C38510a.this.iSR.write(byteBuffer2.array(), 0, byteBuffer2.limit());
                            C38510a.this.iSR.flush();
                        }
                    } catch (IOException e2) {
                        C38510a.m65179a(C38510a.this, e2);
                        C4990ab.printErrStackTrace("MicroMsg.AppBrandNetWork.WebSocketClient", e2, "[WebsocketWriteThread] run IOException", new Object[0]);
                        try {
                            C38510a.this.iSR.close();
                        } catch (IOException e3) {
                        }
                        C38510a.m65178a(C38510a.this);
                        AppMethodBeat.m2505o(73226);
                        return;
                    } catch (Exception e4) {
                        C38510a.m65179a(C38510a.this, e4);
                        C4990ab.printErrStackTrace("MicroMsg.AppBrandNetWork.WebSocketClient", e4, "[WebsocketWriteThread] run Exception", new Object[0]);
                        try {
                            C38510a.this.iSR.close();
                        } catch (IOException e5) {
                        }
                        C38510a.m65178a(C38510a.this);
                        AppMethodBeat.m2505o(73226);
                        return;
                    } finally {
                        C4990ab.m7420w("MicroMsg.AppBrandNetWork.WebSocketClient", "[WebsocketWriteThread] closeSocket");
                        try {
                            C38510a.this.iSR.close();
                        } catch (IOException e6) {
                        }
                        C38510a.m65178a(C38510a.this);
                        AppMethodBeat.m2505o(73226);
                    }
                }
            }
            C4990ab.m7420w("MicroMsg.AppBrandNetWork.WebSocketClient", "[WebsocketWriteThread] closeSocket");
            try {
                C38510a.this.iSR.close();
            } catch (IOException e7) {
            }
            C38510a.m65178a(C38510a.this);
            AppMethodBeat.m2505o(73226);
        }
    }

    /* renamed from: N */
    public abstract void mo21586N(int i, String str);

    /* renamed from: a */
    public abstract void mo21588a(C16696h c16696h);

    public abstract void onError(Exception exception);

    /* renamed from: zO */
    public abstract void mo21591zO(String str);

    public C38510a(URI uri, C38512a c38512a, Map<String, String> map, int i) {
        if (uri == null) {
            throw new IllegalArgumentException();
        } else if (c38512a == null) {
            throw new IllegalArgumentException("null as draft is permitted for `WebSocketServer` only!");
        } else {
            this.iSN = uri;
            this.iSE = c38512a;
            this.headers = map;
            this.iSW = i;
            this.iSO = new C36731c(this, c38512a);
            this.iSt = false;
        }
    }

    public final Socket getSocket() {
        return this.iSP;
    }

    public final void connect() {
        if (this.iST != null) {
            C4990ab.m7416i("MicroMsg.AppBrandNetWork.WebSocketClient", "WebSocketClient objects are not reuseable");
            return;
        }
        this.iST = this;
        C7305d.post(this.iST, "WebsocketWriteThread");
    }

    public final void close() {
        if (this.iST != null) {
            this.iSO.mo58574d(1000, "", false);
        }
    }

    /* renamed from: bk */
    public final void mo61225bk(String str, int i) {
        if (this.iST != null) {
            mo61224ah(i, str);
        }
    }

    /* renamed from: BU */
    public final void mo61219BU(String str) {
        this.iSO.mo58569BU(str);
    }

    public void run() {
        try {
            if (this.iSP == null) {
                this.iSP = new Socket(this.iSS);
            } else if (this.iSP.isClosed()) {
                throw new IOException();
            }
            this.iSP.setTcpNoDelay(this.iSt);
            if (!this.iSP.isBound()) {
                this.iSP.connect(new InetSocketAddress(this.iSN.getHost(), getPort()), this.iSW);
            }
            this.iSQ = this.iSP.getInputStream();
            this.iSR = this.iSP.getOutputStream();
            aOk();
            this.iST = new C2460a(this, (byte) 0);
            C7305d.post(this.iST, "WebsocketWriteThread");
            byte[] bArr = new byte[C36731c.iSu];
            while (!this.iSO.aOj() && !this.iSO.isClosed()) {
                try {
                    int read = this.iSQ.read(bArr);
                    if (read != -1) {
                        this.iSO.mo58579r(ByteBuffer.wrap(bArr, 0, read));
                    }
                } catch (IOException e) {
                    this.iSO.aOi();
                    return;
                } catch (RuntimeException e2) {
                    onError(e2);
                    this.iSO.mo58573af(1006, e2.getMessage());
                    return;
                }
            }
            this.iSO.aOi();
        } catch (Exception e3) {
            this.iSO.mo58573af(-1, e3.getMessage());
        }
    }

    private int getPort() {
        int port = this.iSN.getPort();
        if (port != -1) {
            return port;
        }
        String scheme = this.iSN.getScheme();
        if (scheme.equals("wss")) {
            return JsApiPauseDownloadTask.CTRL_INDEX;
        }
        if (scheme.equals("ws")) {
            return 80;
        }
        throw new RuntimeException("unkonow scheme".concat(String.valueOf(scheme)));
    }

    private void aOk() {
        String rawPath = this.iSN.getRawPath();
        String rawQuery = this.iSN.getRawQuery();
        if (rawPath == null || rawPath.length() == 0) {
            rawPath = "/";
        }
        if (rawQuery != null) {
            rawPath = rawPath + "?" + rawQuery;
        }
        int port = getPort();
        rawQuery = this.iSN.getHost() + (port != 80 ? VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D.concat(String.valueOf(port)) : "");
        C45692b c42688d = new C42688d();
        c42688d.mo68091Eo(rawPath);
        c42688d.put("Host", rawQuery);
        if (this.headers != null) {
            for (Entry entry : this.headers.entrySet()) {
                c42688d.put((String) entry.getKey(), (String) entry.getValue());
            }
        }
        C36731c c36731c = this.iSO;
        c36731c.iSI = c36731c.iSE.mo6380a(c42688d);
        c36731c.iSM = c42688d.aOu();
        if (c36731c.iSM != null) {
            try {
                c36731c.iSC.mo34733b(c36731c.iSI);
                c36731c.mo58572aQ(C38512a.m65199e(c36731c.iSI));
            } catch (C27301b e) {
                throw new C2463d("Handshake data rejected by client.");
            } catch (RuntimeException e2) {
                c36731c.iSC.mo45000f(e2);
                throw new C2463d("rejected because of".concat(String.valueOf(e2)));
            }
        }
    }

    /* renamed from: Em */
    public final void mo44994Em(String str) {
        mo21591zO(str);
    }

    /* renamed from: v */
    public final void mo45001v(ByteBuffer byteBuffer) {
        mo21589m(byteBuffer);
    }

    /* renamed from: c */
    public final void mo44998c(C33533d c33533d) {
        mo21587a(c33533d);
    }

    /* renamed from: d */
    public final void mo44999d(C10742f c10742f) {
        this.iSU.countDown();
        mo21588a((C16696h) c10742f);
    }

    /* renamed from: ag */
    public final void mo44997ag(int i, String str) {
        this.iSU.countDown();
        this.iSV.countDown();
        C7305d.xDG.remove(this.iST);
        if (this.iST != null && (this.iST instanceof C2460a)) {
            ((C2460a) this.iST).isStop = true;
        }
        try {
            if (this.iSP != null) {
                this.iSP.close();
            }
        } catch (IOException e) {
            onError(e);
        }
        mo21586N(i, str);
    }

    /* renamed from: f */
    public final void mo45000f(Exception exception) {
        onError(exception);
    }

    /* renamed from: m */
    public void mo21589m(ByteBuffer byteBuffer) {
    }

    /* renamed from: a */
    public void mo21587a(C33533d c33533d) {
    }

    /* renamed from: a */
    public final void mo61220a(Socket socket) {
        if (this.iSP != null) {
            C4990ab.m7416i("MicroMsg.AppBrandNetWork.WebSocketClient", "socket has already been set");
        } else {
            this.iSP = socket;
        }
    }

    public final boolean isOpen() {
        return this.iSO.isOpen();
    }

    /* renamed from: ah */
    public final void mo61224ah(int i, String str) {
        this.iSO.mo58574d(i, str, false);
    }

    /* renamed from: p */
    public final void mo61230p(ByteBuffer byteBuffer) {
        this.iSO.mo58578p(byteBuffer);
    }

    /* renamed from: b */
    public final void mo54002b(C33533d c33533d) {
        this.iSO.mo54002b(c33533d);
    }

    public final String aBA() {
        return this.hvr;
    }

    /* renamed from: BT */
    public final void mo61218BT(String str) {
        this.hvr = str;
    }

    public final Timer aGo() {
        return this.mTimer;
    }

    /* renamed from: a */
    public final void mo61221a(Timer timer) {
        this.mTimer = timer;
    }

    /* renamed from: a */
    static /* synthetic */ void m65179a(C38510a c38510a, Exception exception) {
        if (exception instanceof SSLException) {
            c38510a.onError(exception);
        }
        c38510a.iSO.aOi();
    }
}
