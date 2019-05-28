package com.tencent.mm.plugin.appbrand.t;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.t.a.b;
import com.tencent.mm.plugin.appbrand.t.b.a;
import com.tencent.mm.plugin.appbrand.t.d.d;
import com.tencent.mm.plugin.appbrand.t.e.f;
import com.tencent.mm.plugin.appbrand.t.e.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public final class c implements a {
    public static boolean DEBUG = false;
    public static int iSu = 16384;
    public static final List<a> iSv;
    private volatile boolean iSA = false;
    private a.a iSB = a.a.NOT_YET_CONNECTED;
    public final d iSC;
    private List<a> iSD;
    public a iSE = null;
    public b iSF;
    private d.a iSG = null;
    private ByteBuffer iSH = ByteBuffer.allocate(0);
    public com.tencent.mm.plugin.appbrand.t.e.a iSI = null;
    private String iSJ = null;
    private Integer iSK = null;
    private Boolean iSL = null;
    public String iSM = null;
    public SelectionKey iSw;
    public ByteChannel iSx;
    public final BlockingQueue<ByteBuffer> iSy;
    public final BlockingQueue<ByteBuffer> iSz;

    static {
        AppMethodBeat.i(73225);
        ArrayList arrayList = new ArrayList(4);
        iSv = arrayList;
        arrayList.add(new com.tencent.mm.plugin.appbrand.t.b.c());
        iSv.add(new com.tencent.mm.plugin.appbrand.t.b.b());
        iSv.add(new com.tencent.mm.plugin.appbrand.t.b.d());
        AppMethodBeat.o(73225);
    }

    public c(d dVar, a aVar) {
        AppMethodBeat.i(73207);
        if (aVar == null && this.iSF == b.SERVER) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("parameters must not be null");
            AppMethodBeat.o(73207);
            throw illegalArgumentException;
        }
        this.iSy = new LinkedBlockingQueue();
        this.iSz = new LinkedBlockingQueue();
        this.iSC = dVar;
        this.iSF = b.CLIENT;
        if (aVar != null) {
            this.iSE = aVar.aOm();
        }
        AppMethodBeat.o(73207);
    }

    public final void r(ByteBuffer byteBuffer) {
        AppMethodBeat.i(73208);
        if (DEBUG) {
            ab.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "\"process(\" + socketBuffer.remaining() + \"): {\" + ( socketBuffer.remaining() > 1000 ? \"too big to display\" : new String( socketBuffer.array(), socketBuffer.position(), socketBuffer.remaining() ) ) + \"}\"");
        }
        if (this.iSB != a.a.NOT_YET_CONNECTED) {
            if (this.iSB == a.a.OPEN) {
                t(byteBuffer);
                AppMethodBeat.o(73208);
                return;
            }
        } else if (!(!s(byteBuffer) || aOj() || isClosed())) {
            if (byteBuffer.hasRemaining()) {
                t(byteBuffer);
                AppMethodBeat.o(73208);
                return;
            } else if (this.iSH.hasRemaining()) {
                t(this.iSH);
            }
        }
        AppMethodBeat.o(73208);
    }

    private boolean s(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        AppMethodBeat.i(73209);
        if (this.iSH.capacity() == 0) {
            byteBuffer2 = byteBuffer;
        } else {
            if (this.iSH.remaining() < byteBuffer.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(this.iSH.capacity() + byteBuffer.remaining());
                this.iSH.flip();
                allocate.put(this.iSH);
                this.iSH = allocate;
            }
            this.iSH.put(byteBuffer);
            this.iSH.flip();
            byteBuffer2 = this.iSH;
        }
        byteBuffer2.mark();
        try {
            f y;
            com.tencent.mm.plugin.appbrand.t.e.a aVar;
            if (this.iSF != b.SERVER) {
                if (this.iSF == b.CLIENT) {
                    this.iSE.a(this.iSF);
                    y = this.iSE.y(byteBuffer2);
                    if (y instanceof h) {
                        h hVar = (h) y;
                        if (this.iSE.a(this.iSI, hVar) == a.b.MATCHED) {
                            c(hVar);
                            AppMethodBeat.o(73209);
                            return true;
                        }
                        d(1002, "draft refuses handshake " + hVar.aOw() + " " + hVar.aOv(), false);
                    } else {
                        e(1002, "wrong http function", false);
                        AppMethodBeat.o(73209);
                        return false;
                    }
                }
                AppMethodBeat.o(73209);
                return false;
            } else if (this.iSE == null) {
                for (a aOm : this.iSD) {
                    a aOm2 = aOm.aOm();
                    try {
                        aOm2.a(this.iSF);
                        byteBuffer2.reset();
                        y = aOm2.y(byteBuffer2);
                        if (y instanceof com.tencent.mm.plugin.appbrand.t.e.a) {
                            aVar = (com.tencent.mm.plugin.appbrand.t.e.a) y;
                            if (aOm2.c(aVar) == a.b.MATCHED) {
                                this.iSM = aVar.aOu();
                                try {
                                    aQ(a.f(aOm2.a(aVar, this.iSC.aOh())));
                                    this.iSE = aOm2;
                                    c(aVar);
                                    AppMethodBeat.o(73209);
                                    return true;
                                } catch (com.tencent.mm.plugin.appbrand.t.c.b e) {
                                    e(e.iTp, e.getMessage(), false);
                                    AppMethodBeat.o(73209);
                                    return false;
                                } catch (RuntimeException e2) {
                                    this.iSC.f(e2);
                                    e(-1, e2.getMessage(), false);
                                    AppMethodBeat.o(73209);
                                    return false;
                                }
                            }
                            continue;
                        } else {
                            e(1002, "wrong http function", false);
                            AppMethodBeat.o(73209);
                            return false;
                        }
                    } catch (com.tencent.mm.plugin.appbrand.t.c.d e3) {
                        ab.e("MicroMsg.AppBrandNetWork.WebSocketImpl", "InvalidHandshakeException e: " + e3.toString());
                    }
                }
                if (this.iSE == null) {
                    d(1002, "no draft matches", false);
                }
                AppMethodBeat.o(73209);
                return false;
            } else {
                y = this.iSE.y(byteBuffer2);
                if (y instanceof com.tencent.mm.plugin.appbrand.t.e.a) {
                    aVar = (com.tencent.mm.plugin.appbrand.t.e.a) y;
                    if (this.iSE.c(aVar) == a.b.MATCHED) {
                        c(aVar);
                        AppMethodBeat.o(73209);
                        return true;
                    }
                    d(1002, "the handshake did finaly not match", false);
                    AppMethodBeat.o(73209);
                    return false;
                }
                e(1002, "wrong http function", false);
                AppMethodBeat.o(73209);
                return false;
            }
        } catch (com.tencent.mm.plugin.appbrand.t.c.d e32) {
            try {
                ab.e("MicroMsg.AppBrandNetWork.WebSocketImpl", "decodeHandshake: " + e32.toString());
                a(e32);
            } catch (com.tencent.mm.plugin.appbrand.t.c.a e4) {
                ab.e("MicroMsg.AppBrandNetWork.WebSocketImpl", "decodeHandshake: " + e4.toString());
                if (this.iSH.capacity() == 0) {
                    byteBuffer2.reset();
                    int i = e4.iTo;
                    if (i == 0) {
                        i = byteBuffer2.capacity() + 16;
                    }
                    this.iSH = ByteBuffer.allocate(i);
                    this.iSH.put(byteBuffer);
                } else {
                    this.iSH.position(this.iSH.limit());
                    this.iSH.limit(this.iSH.capacity());
                }
            }
        }
    }

    private void t(ByteBuffer byteBuffer) {
        AppMethodBeat.i(73210);
        com.tencent.mm.plugin.appbrand.t.c.b bVar;
        try {
            for (d dVar : this.iSE.x(byteBuffer)) {
                if (DEBUG) {
                    ab.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "matched frame: ".concat(String.valueOf(dVar)));
                }
                d.a aOt = dVar.aOt();
                boolean aOr = dVar.aOr();
                if (aOt == d.a.CLOSING) {
                    String message;
                    int i = 1005;
                    String str = "";
                    if (dVar instanceof com.tencent.mm.plugin.appbrand.t.d.a) {
                        com.tencent.mm.plugin.appbrand.t.d.a aVar = (com.tencent.mm.plugin.appbrand.t.d.a) dVar;
                        int aOn = aVar.aOn();
                        message = aVar.getMessage();
                        i = aOn;
                    } else {
                        message = str;
                    }
                    if (this.iSB == a.a.CLOSING) {
                        af(i, message);
                    } else if (this.iSE.aOl() == a.a.TWOWAY) {
                        d(i, message, true);
                    } else {
                        e(i, message, false);
                    }
                } else if (aOt == d.a.PING) {
                    this.iSC.a(this, dVar);
                } else if (aOt == d.a.PONG) {
                    continue;
                } else if (!aOr || aOt == d.a.CONTINUOUS) {
                    if (aOt != d.a.CONTINUOUS) {
                        if (this.iSG != null) {
                            bVar = new com.tencent.mm.plugin.appbrand.t.c.b("Previous continuous frame sequence not completed.");
                            AppMethodBeat.o(73210);
                            throw bVar;
                        }
                        this.iSG = aOt;
                    } else if (aOr) {
                        if (this.iSG == null) {
                            bVar = new com.tencent.mm.plugin.appbrand.t.c.b("Continuous frame sequence was not started.");
                            AppMethodBeat.o(73210);
                            throw bVar;
                        }
                        this.iSG = null;
                    } else if (this.iSG == null) {
                        bVar = new com.tencent.mm.plugin.appbrand.t.c.b("Continuous frame sequence was not started.");
                        AppMethodBeat.o(73210);
                        throw bVar;
                    }
                    try {
                        this.iSC.c(dVar);
                    } catch (RuntimeException e) {
                        this.iSC.f(e);
                    }
                } else if (this.iSG != null) {
                    bVar = new com.tencent.mm.plugin.appbrand.t.c.b("Continuous frame sequence not completed.");
                    AppMethodBeat.o(73210);
                    throw bVar;
                } else if (aOt == d.a.TEXT) {
                    try {
                        this.iSC.Em(com.tencent.mm.plugin.appbrand.t.f.b.B(dVar.aOq()));
                    } catch (RuntimeException e2) {
                        this.iSC.f(e2);
                    }
                } else if (aOt == d.a.BINARY) {
                    try {
                        this.iSC.v(dVar.aOq());
                    } catch (RuntimeException e22) {
                        this.iSC.f(e22);
                    }
                } else {
                    bVar = new com.tencent.mm.plugin.appbrand.t.c.b("non control or continious frame expected");
                    AppMethodBeat.o(73210);
                    throw bVar;
                }
            }
            AppMethodBeat.o(73210);
        } catch (com.tencent.mm.plugin.appbrand.t.c.b bVar2) {
            ab.e("MicroMsg.AppBrandNetWork.WebSocketImpl", "decodeFrames: " + bVar2.toString());
            this.iSC.f(bVar2);
            a(bVar2);
            AppMethodBeat.o(73210);
        }
    }

    public final void d(int i, String str, boolean z) {
        AppMethodBeat.i(73211);
        if (this.iSB == a.a.CLOSING || this.iSB == a.a.CLOSED) {
            AppMethodBeat.o(73211);
            return;
        }
        if (this.iSB == a.a.OPEN) {
            if (i == 1006) {
                this.iSB = a.a.CLOSING;
                e(i, str, false);
                AppMethodBeat.o(73211);
                return;
            }
            if (this.iSE.aOl() != a.a.NONE) {
                try {
                    b(new com.tencent.mm.plugin.appbrand.t.d.b(i, str));
                } catch (com.tencent.mm.plugin.appbrand.t.c.b e) {
                    ab.e("MicroMsg.AppBrandNetWork.WebSocketImpl", "close: " + e.toString());
                    this.iSC.f(e);
                    e(1006, "generated frame is invalid", false);
                }
            }
            e(i, str, z);
        } else if (i == -3) {
            e(-3, str, true);
        } else {
            e(-1, str, false);
        }
        if (i == 1002) {
            e(i, str, z);
        }
        this.iSB = a.a.CLOSING;
        this.iSH = null;
        AppMethodBeat.o(73211);
    }

    public final synchronized void af(int i, String str) {
        AppMethodBeat.i(73212);
        if (this.iSB == a.a.CLOSED) {
            AppMethodBeat.o(73212);
        } else {
            if (this.iSw != null) {
                this.iSw.cancel();
            }
            if (this.iSx != null) {
                try {
                    this.iSx.close();
                } catch (IOException e) {
                    this.iSC.f(e);
                }
            }
            try {
                this.iSC.ag(i, str);
            } catch (RuntimeException e2) {
                this.iSC.f(e2);
            }
            if (this.iSE != null) {
                this.iSE.reset();
            }
            this.iSI = null;
            this.iSB = a.a.CLOSED;
            this.iSy.clear();
            AppMethodBeat.o(73212);
        }
    }

    private synchronized void e(int i, String str, boolean z) {
        AppMethodBeat.i(73213);
        if (this.iSA) {
            AppMethodBeat.o(73213);
        } else {
            this.iSK = Integer.valueOf(i);
            this.iSJ = str;
            this.iSL = Boolean.valueOf(z);
            this.iSA = true;
            if (this.iSE != null) {
                this.iSE.reset();
            }
            this.iSI = null;
            AppMethodBeat.o(73213);
        }
    }

    public final void BU(String str) {
        AppMethodBeat.i(73216);
        if (str == null) {
            ab.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "Cannot send 'null' data to a WebSocketImpl.");
            AppMethodBeat.o(73216);
            return;
        }
        f(this.iSE.ar(str, this.iSF == b.CLIENT));
        AppMethodBeat.o(73216);
    }

    public final void p(ByteBuffer byteBuffer) {
        AppMethodBeat.i(73217);
        if (byteBuffer == null) {
            ab.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "Cannot send 'null' data to a WebSocketImpl.");
            AppMethodBeat.o(73217);
            return;
        }
        f(this.iSE.a(byteBuffer, this.iSF == b.CLIENT));
        AppMethodBeat.o(73217);
    }

    private void f(Collection<d> collection) {
        AppMethodBeat.i(73218);
        if (isOpen()) {
            for (d b : collection) {
                b(b);
            }
            AppMethodBeat.o(73218);
            return;
        }
        com.tencent.mm.plugin.appbrand.t.c.f fVar = new com.tencent.mm.plugin.appbrand.t.c.f();
        AppMethodBeat.o(73218);
        throw fVar;
    }

    public final void b(d dVar) {
        AppMethodBeat.i(73219);
        if (DEBUG) {
            ab.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "\"send frame: \" + framedata ");
        }
        u(this.iSE.d(dVar));
        AppMethodBeat.o(73219);
    }

    private void u(ByteBuffer byteBuffer) {
        AppMethodBeat.i(73220);
        if (DEBUG) {
            ab.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "write(\" + buf.remaining() + \"): {\" + ( buf.remaining() > 1000 ? \"too big to display\" : new String( buf.array() ) ) + \"}");
        }
        this.iSy.add(byteBuffer);
        AppMethodBeat.o(73220);
    }

    public final void aQ(List<ByteBuffer> list) {
        AppMethodBeat.i(73221);
        for (ByteBuffer u : list) {
            u(u);
        }
        AppMethodBeat.o(73221);
    }

    private void c(f fVar) {
        AppMethodBeat.i(73222);
        if (DEBUG) {
            ab.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "open using draft: " + this.iSE.getClass().getSimpleName());
        }
        this.iSB = a.a.OPEN;
        try {
            this.iSC.d(fVar);
            AppMethodBeat.o(73222);
        } catch (RuntimeException e) {
            this.iSC.f(e);
            AppMethodBeat.o(73222);
        }
    }

    public final boolean isOpen() {
        return this.iSB == a.a.OPEN;
    }

    public final boolean aOj() {
        return this.iSB == a.a.CLOSING;
    }

    public final boolean isClosed() {
        return this.iSB == a.a.CLOSED;
    }

    public final int hashCode() {
        AppMethodBeat.i(73223);
        int hashCode = super.hashCode();
        AppMethodBeat.o(73223);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.i(73224);
        String obj = super.toString();
        AppMethodBeat.o(73224);
        return obj;
    }

    public final void aOi() {
        AppMethodBeat.i(73214);
        if (this.iSB == a.a.NOT_YET_CONNECTED) {
            af(-1, "");
            AppMethodBeat.o(73214);
        } else if (this.iSA) {
            int intValue = this.iSK.intValue();
            String str = this.iSJ;
            this.iSL.booleanValue();
            af(intValue, str);
            AppMethodBeat.o(73214);
        } else if (this.iSE.aOl() == a.a.NONE) {
            af(1000, "");
            AppMethodBeat.o(73214);
        } else if (this.iSE.aOl() != a.a.ONEWAY || this.iSF == b.SERVER) {
            af(1006, "");
            AppMethodBeat.o(73214);
        } else {
            af(1000, "");
            AppMethodBeat.o(73214);
        }
    }

    private void a(com.tencent.mm.plugin.appbrand.t.c.b bVar) {
        AppMethodBeat.i(73215);
        d(bVar.iTp, bVar.getMessage(), false);
        AppMethodBeat.o(73215);
    }
}
