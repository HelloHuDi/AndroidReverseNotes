package com.tencent.mm.plugin.appbrand.t.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiPauseDownloadTask;
import com.tencent.mm.plugin.appbrand.t.b;
import com.tencent.mm.plugin.appbrand.t.c;
import com.tencent.mm.plugin.appbrand.t.e.f;
import com.tencent.mm.plugin.appbrand.t.e.h;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
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

public abstract class a extends b implements com.tencent.mm.plugin.appbrand.t.a, Runnable {
    private Map<String, String> headers;
    private String hvr;
    private com.tencent.mm.plugin.appbrand.t.b.a iSE;
    protected URI iSN = null;
    public c iSO = null;
    private Socket iSP = null;
    private InputStream iSQ;
    OutputStream iSR;
    private Proxy iSS = Proxy.NO_PROXY;
    private Runnable iST;
    private CountDownLatch iSU = new CountDownLatch(1);
    private CountDownLatch iSV = new CountDownLatch(1);
    private int iSW = 0;
    private Timer mTimer = null;

    class a implements Runnable {
        volatile boolean isStop;

        private a() {
            this.isStop = false;
        }

        /* synthetic */ a(a aVar, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(73226);
            while (!this.isStop && !Thread.interrupted()) {
                ByteBuffer byteBuffer;
                try {
                    Object obj;
                    if (a.this.iSO.iSy.isEmpty()) {
                        obj = null;
                    } else {
                        obj = 1;
                    }
                    if (obj != null) {
                        byteBuffer = (ByteBuffer) a.this.iSO.iSy.poll(1000, TimeUnit.MILLISECONDS);
                        if (byteBuffer != null) {
                            a.this.iSR.write(byteBuffer.array(), 0, byteBuffer.limit());
                            a.this.iSR.flush();
                        }
                    }
                } catch (InterruptedException e) {
                    try {
                        for (ByteBuffer byteBuffer2 : a.this.iSO.iSy) {
                            a.this.iSR.write(byteBuffer2.array(), 0, byteBuffer2.limit());
                            a.this.iSR.flush();
                        }
                    } catch (IOException e2) {
                        a.a(a.this, e2);
                        ab.printErrStackTrace("MicroMsg.AppBrandNetWork.WebSocketClient", e2, "[WebsocketWriteThread] run IOException", new Object[0]);
                        try {
                            a.this.iSR.close();
                        } catch (IOException e3) {
                        }
                        a.a(a.this);
                        AppMethodBeat.o(73226);
                        return;
                    } catch (Exception e4) {
                        a.a(a.this, e4);
                        ab.printErrStackTrace("MicroMsg.AppBrandNetWork.WebSocketClient", e4, "[WebsocketWriteThread] run Exception", new Object[0]);
                        try {
                            a.this.iSR.close();
                        } catch (IOException e5) {
                        }
                        a.a(a.this);
                        AppMethodBeat.o(73226);
                        return;
                    } finally {
                        ab.w("MicroMsg.AppBrandNetWork.WebSocketClient", "[WebsocketWriteThread] closeSocket");
                        try {
                            a.this.iSR.close();
                        } catch (IOException e6) {
                        }
                        a.a(a.this);
                        AppMethodBeat.o(73226);
                    }
                }
            }
            ab.w("MicroMsg.AppBrandNetWork.WebSocketClient", "[WebsocketWriteThread] closeSocket");
            try {
                a.this.iSR.close();
            } catch (IOException e7) {
            }
            a.a(a.this);
            AppMethodBeat.o(73226);
        }
    }

    public abstract void N(int i, String str);

    public abstract void a(h hVar);

    public abstract void onError(Exception exception);

    public abstract void zO(String str);

    public a(URI uri, com.tencent.mm.plugin.appbrand.t.b.a aVar, Map<String, String> map, int i) {
        if (uri == null) {
            throw new IllegalArgumentException();
        } else if (aVar == null) {
            throw new IllegalArgumentException("null as draft is permitted for `WebSocketServer` only!");
        } else {
            this.iSN = uri;
            this.iSE = aVar;
            this.headers = map;
            this.iSW = i;
            this.iSO = new c(this, aVar);
            this.iSt = false;
        }
    }

    public final Socket getSocket() {
        return this.iSP;
    }

    public final void connect() {
        if (this.iST != null) {
            ab.i("MicroMsg.AppBrandNetWork.WebSocketClient", "WebSocketClient objects are not reuseable");
            return;
        }
        this.iST = this;
        d.post(this.iST, "WebsocketWriteThread");
    }

    public final void close() {
        if (this.iST != null) {
            this.iSO.d(1000, "", false);
        }
    }

    public final void bk(String str, int i) {
        if (this.iST != null) {
            ah(i, str);
        }
    }

    public final void BU(String str) {
        this.iSO.BU(str);
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
            this.iST = new a(this, (byte) 0);
            d.post(this.iST, "WebsocketWriteThread");
            byte[] bArr = new byte[c.iSu];
            while (!this.iSO.aOj() && !this.iSO.isClosed()) {
                try {
                    int read = this.iSQ.read(bArr);
                    if (read != -1) {
                        this.iSO.r(ByteBuffer.wrap(bArr, 0, read));
                    }
                } catch (IOException e) {
                    this.iSO.aOi();
                    return;
                } catch (RuntimeException e2) {
                    onError(e2);
                    this.iSO.af(1006, e2.getMessage());
                    return;
                }
            }
            this.iSO.aOi();
        } catch (Exception e3) {
            this.iSO.af(-1, e3.getMessage());
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
        com.tencent.mm.plugin.appbrand.t.e.b dVar = new com.tencent.mm.plugin.appbrand.t.e.d();
        dVar.Eo(rawPath);
        dVar.put("Host", rawQuery);
        if (this.headers != null) {
            for (Entry entry : this.headers.entrySet()) {
                dVar.put((String) entry.getKey(), (String) entry.getValue());
            }
        }
        c cVar = this.iSO;
        cVar.iSI = cVar.iSE.a(dVar);
        cVar.iSM = dVar.aOu();
        if (cVar.iSM != null) {
            try {
                cVar.iSC.b(cVar.iSI);
                cVar.aQ(com.tencent.mm.plugin.appbrand.t.b.a.e(cVar.iSI));
            } catch (com.tencent.mm.plugin.appbrand.t.c.b e) {
                throw new com.tencent.mm.plugin.appbrand.t.c.d("Handshake data rejected by client.");
            } catch (RuntimeException e2) {
                cVar.iSC.f(e2);
                throw new com.tencent.mm.plugin.appbrand.t.c.d("rejected because of".concat(String.valueOf(e2)));
            }
        }
    }

    public final void Em(String str) {
        zO(str);
    }

    public final void v(ByteBuffer byteBuffer) {
        m(byteBuffer);
    }

    public final void c(com.tencent.mm.plugin.appbrand.t.d.d dVar) {
        a(dVar);
    }

    public final void d(f fVar) {
        this.iSU.countDown();
        a((h) fVar);
    }

    public final void ag(int i, String str) {
        this.iSU.countDown();
        this.iSV.countDown();
        d.xDG.remove(this.iST);
        if (this.iST != null && (this.iST instanceof a)) {
            ((a) this.iST).isStop = true;
        }
        try {
            if (this.iSP != null) {
                this.iSP.close();
            }
        } catch (IOException e) {
            onError(e);
        }
        N(i, str);
    }

    public final void f(Exception exception) {
        onError(exception);
    }

    public void m(ByteBuffer byteBuffer) {
    }

    public void a(com.tencent.mm.plugin.appbrand.t.d.d dVar) {
    }

    public final void a(Socket socket) {
        if (this.iSP != null) {
            ab.i("MicroMsg.AppBrandNetWork.WebSocketClient", "socket has already been set");
        } else {
            this.iSP = socket;
        }
    }

    public final boolean isOpen() {
        return this.iSO.isOpen();
    }

    public final void ah(int i, String str) {
        this.iSO.d(i, str, false);
    }

    public final void p(ByteBuffer byteBuffer) {
        this.iSO.p(byteBuffer);
    }

    public final void b(com.tencent.mm.plugin.appbrand.t.d.d dVar) {
        this.iSO.b(dVar);
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

    static /* synthetic */ void a(a aVar, Exception exception) {
        if (exception instanceof SSLException) {
            aVar.onError(exception);
        }
        aVar.iSO.aOi();
    }
}
