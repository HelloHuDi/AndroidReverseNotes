package com.tencent.p177mm.plugin.appbrand.p332t;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p332t.C33526a.C19740b;
import com.tencent.p177mm.plugin.appbrand.p332t.C33526a.C27300a;
import com.tencent.p177mm.plugin.appbrand.p332t.p1232d.C19741a;
import com.tencent.p177mm.plugin.appbrand.p332t.p1232d.C27302b;
import com.tencent.p177mm.plugin.appbrand.p332t.p1232d.C33533d;
import com.tencent.p177mm.plugin.appbrand.p332t.p1232d.C33533d.C33534a;
import com.tencent.p177mm.plugin.appbrand.p332t.p1539f.C42690b;
import com.tencent.p177mm.plugin.appbrand.p332t.p334b.C2461c;
import com.tencent.p177mm.plugin.appbrand.p332t.p334b.C33528b;
import com.tencent.p177mm.plugin.appbrand.p332t.p334b.C38512a;
import com.tencent.p177mm.plugin.appbrand.p332t.p334b.C38512a.C33527b;
import com.tencent.p177mm.plugin.appbrand.p332t.p334b.C38512a.C38511a;
import com.tencent.p177mm.plugin.appbrand.p332t.p334b.C6787d;
import com.tencent.p177mm.plugin.appbrand.p332t.p335c.C10741a;
import com.tencent.p177mm.plugin.appbrand.p332t.p335c.C2463d;
import com.tencent.p177mm.plugin.appbrand.p332t.p335c.C27301b;
import com.tencent.p177mm.plugin.appbrand.p332t.p335c.C33532f;
import com.tencent.p177mm.plugin.appbrand.p332t.p914e.C10742f;
import com.tencent.p177mm.plugin.appbrand.p332t.p914e.C16696h;
import com.tencent.p177mm.plugin.appbrand.p332t.p914e.C38514a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.tencent.mm.plugin.appbrand.t.c */
public final class C36731c implements C33526a {
    public static boolean DEBUG = false;
    public static int iSu = 16384;
    public static final List<C38512a> iSv;
    private volatile boolean iSA = false;
    private C27300a iSB = C27300a.NOT_YET_CONNECTED;
    public final C27303d iSC;
    private List<C38512a> iSD;
    public C38512a iSE = null;
    public C19740b iSF;
    private C33534a iSG = null;
    private ByteBuffer iSH = ByteBuffer.allocate(0);
    public C38514a iSI = null;
    private String iSJ = null;
    private Integer iSK = null;
    private Boolean iSL = null;
    public String iSM = null;
    public SelectionKey iSw;
    public ByteChannel iSx;
    public final BlockingQueue<ByteBuffer> iSy;
    public final BlockingQueue<ByteBuffer> iSz;

    static {
        AppMethodBeat.m2504i(73225);
        ArrayList arrayList = new ArrayList(4);
        iSv = arrayList;
        arrayList.add(new C2461c());
        iSv.add(new C33528b());
        iSv.add(new C6787d());
        AppMethodBeat.m2505o(73225);
    }

    public C36731c(C27303d c27303d, C38512a c38512a) {
        AppMethodBeat.m2504i(73207);
        if (c38512a == null && this.iSF == C19740b.SERVER) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("parameters must not be null");
            AppMethodBeat.m2505o(73207);
            throw illegalArgumentException;
        }
        this.iSy = new LinkedBlockingQueue();
        this.iSz = new LinkedBlockingQueue();
        this.iSC = c27303d;
        this.iSF = C19740b.CLIENT;
        if (c38512a != null) {
            this.iSE = c38512a.aOm();
        }
        AppMethodBeat.m2505o(73207);
    }

    /* renamed from: r */
    public final void mo58579r(ByteBuffer byteBuffer) {
        AppMethodBeat.m2504i(73208);
        if (DEBUG) {
            C4990ab.m7416i("MicroMsg.AppBrandNetWork.WebSocketImpl", "\"process(\" + socketBuffer.remaining() + \"): {\" + ( socketBuffer.remaining() > 1000 ? \"too big to display\" : new String( socketBuffer.array(), socketBuffer.position(), socketBuffer.remaining() ) ) + \"}\"");
        }
        if (this.iSB != C27300a.NOT_YET_CONNECTED) {
            if (this.iSB == C27300a.OPEN) {
                m60933t(byteBuffer);
                AppMethodBeat.m2505o(73208);
                return;
            }
        } else if (!(!m60932s(byteBuffer) || aOj() || isClosed())) {
            if (byteBuffer.hasRemaining()) {
                m60933t(byteBuffer);
                AppMethodBeat.m2505o(73208);
                return;
            } else if (this.iSH.hasRemaining()) {
                m60933t(this.iSH);
            }
        }
        AppMethodBeat.m2505o(73208);
    }

    /* renamed from: s */
    private boolean m60932s(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        AppMethodBeat.m2504i(73209);
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
            C10742f y;
            C38514a c38514a;
            if (this.iSF != C19740b.SERVER) {
                if (this.iSF == C19740b.CLIENT) {
                    this.iSE.mo61232a(this.iSF);
                    y = this.iSE.mo61233y(byteBuffer2);
                    if (y instanceof C16696h) {
                        C16696h c16696h = (C16696h) y;
                        if (this.iSE.mo54003a(this.iSI, c16696h) == C33527b.MATCHED) {
                            m60929c(c16696h);
                            AppMethodBeat.m2505o(73209);
                            return true;
                        }
                        mo58574d(1002, "draft refuses handshake " + c16696h.aOw() + " " + c16696h.aOv(), false);
                    } else {
                        m60930e(1002, "wrong http function", false);
                        AppMethodBeat.m2505o(73209);
                        return false;
                    }
                }
                AppMethodBeat.m2505o(73209);
                return false;
            } else if (this.iSE == null) {
                for (C38512a aOm : this.iSD) {
                    C38512a aOm2 = aOm.aOm();
                    try {
                        aOm2.mo61232a(this.iSF);
                        byteBuffer2.reset();
                        y = aOm2.mo61233y(byteBuffer2);
                        if (y instanceof C38514a) {
                            c38514a = (C38514a) y;
                            if (aOm2.mo6382c(c38514a) == C33527b.MATCHED) {
                                this.iSM = c38514a.aOu();
                                try {
                                    mo58572aQ(C38512a.m65200f(aOm2.mo15057a(c38514a, this.iSC.aOh())));
                                    this.iSE = aOm2;
                                    m60929c(c38514a);
                                    AppMethodBeat.m2505o(73209);
                                    return true;
                                } catch (C27301b e) {
                                    m60930e(e.iTp, e.getMessage(), false);
                                    AppMethodBeat.m2505o(73209);
                                    return false;
                                } catch (RuntimeException e2) {
                                    this.iSC.mo45000f(e2);
                                    m60930e(-1, e2.getMessage(), false);
                                    AppMethodBeat.m2505o(73209);
                                    return false;
                                }
                            }
                            continue;
                        } else {
                            m60930e(1002, "wrong http function", false);
                            AppMethodBeat.m2505o(73209);
                            return false;
                        }
                    } catch (C2463d e3) {
                        C4990ab.m7412e("MicroMsg.AppBrandNetWork.WebSocketImpl", "InvalidHandshakeException e: " + e3.toString());
                    }
                }
                if (this.iSE == null) {
                    mo58574d(1002, "no draft matches", false);
                }
                AppMethodBeat.m2505o(73209);
                return false;
            } else {
                y = this.iSE.mo61233y(byteBuffer2);
                if (y instanceof C38514a) {
                    c38514a = (C38514a) y;
                    if (this.iSE.mo6382c(c38514a) == C33527b.MATCHED) {
                        m60929c(c38514a);
                        AppMethodBeat.m2505o(73209);
                        return true;
                    }
                    mo58574d(1002, "the handshake did finaly not match", false);
                    AppMethodBeat.m2505o(73209);
                    return false;
                }
                m60930e(1002, "wrong http function", false);
                AppMethodBeat.m2505o(73209);
                return false;
            }
        } catch (C2463d e32) {
            try {
                C4990ab.m7412e("MicroMsg.AppBrandNetWork.WebSocketImpl", "decodeHandshake: " + e32.toString());
                m60928a(e32);
            } catch (C10741a e4) {
                C4990ab.m7412e("MicroMsg.AppBrandNetWork.WebSocketImpl", "decodeHandshake: " + e4.toString());
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

    /* renamed from: t */
    private void m60933t(ByteBuffer byteBuffer) {
        AppMethodBeat.m2504i(73210);
        C27301b c27301b;
        try {
            for (C33533d c33533d : this.iSE.mo54009x(byteBuffer)) {
                if (DEBUG) {
                    C4990ab.m7416i("MicroMsg.AppBrandNetWork.WebSocketImpl", "matched frame: ".concat(String.valueOf(c33533d)));
                }
                C33534a aOt = c33533d.aOt();
                boolean aOr = c33533d.aOr();
                if (aOt == C33534a.CLOSING) {
                    String message;
                    int i = 1005;
                    String str = "";
                    if (c33533d instanceof C19741a) {
                        C19741a c19741a = (C19741a) c33533d;
                        int aOn = c19741a.aOn();
                        message = c19741a.getMessage();
                        i = aOn;
                    } else {
                        message = str;
                    }
                    if (this.iSB == C27300a.CLOSING) {
                        mo58573af(i, message);
                    } else if (this.iSE.aOl() == C38511a.TWOWAY) {
                        mo58574d(i, message, true);
                    } else {
                        m60930e(i, message, false);
                    }
                } else if (aOt == C33534a.PING) {
                    this.iSC.mo44995a(this, c33533d);
                } else if (aOt == C33534a.PONG) {
                    continue;
                } else if (!aOr || aOt == C33534a.CONTINUOUS) {
                    if (aOt != C33534a.CONTINUOUS) {
                        if (this.iSG != null) {
                            c27301b = new C27301b("Previous continuous frame sequence not completed.");
                            AppMethodBeat.m2505o(73210);
                            throw c27301b;
                        }
                        this.iSG = aOt;
                    } else if (aOr) {
                        if (this.iSG == null) {
                            c27301b = new C27301b("Continuous frame sequence was not started.");
                            AppMethodBeat.m2505o(73210);
                            throw c27301b;
                        }
                        this.iSG = null;
                    } else if (this.iSG == null) {
                        c27301b = new C27301b("Continuous frame sequence was not started.");
                        AppMethodBeat.m2505o(73210);
                        throw c27301b;
                    }
                    try {
                        this.iSC.mo44998c(c33533d);
                    } catch (RuntimeException e) {
                        this.iSC.mo45000f(e);
                    }
                } else if (this.iSG != null) {
                    c27301b = new C27301b("Continuous frame sequence not completed.");
                    AppMethodBeat.m2505o(73210);
                    throw c27301b;
                } else if (aOt == C33534a.TEXT) {
                    try {
                        this.iSC.mo44994Em(C42690b.m75607B(c33533d.aOq()));
                    } catch (RuntimeException e2) {
                        this.iSC.mo45000f(e2);
                    }
                } else if (aOt == C33534a.BINARY) {
                    try {
                        this.iSC.mo45001v(c33533d.aOq());
                    } catch (RuntimeException e22) {
                        this.iSC.mo45000f(e22);
                    }
                } else {
                    c27301b = new C27301b("non control or continious frame expected");
                    AppMethodBeat.m2505o(73210);
                    throw c27301b;
                }
            }
            AppMethodBeat.m2505o(73210);
        } catch (C27301b c27301b2) {
            C4990ab.m7412e("MicroMsg.AppBrandNetWork.WebSocketImpl", "decodeFrames: " + c27301b2.toString());
            this.iSC.mo45000f(c27301b2);
            m60928a(c27301b2);
            AppMethodBeat.m2505o(73210);
        }
    }

    /* renamed from: d */
    public final void mo58574d(int i, String str, boolean z) {
        AppMethodBeat.m2504i(73211);
        if (this.iSB == C27300a.CLOSING || this.iSB == C27300a.CLOSED) {
            AppMethodBeat.m2505o(73211);
            return;
        }
        if (this.iSB == C27300a.OPEN) {
            if (i == 1006) {
                this.iSB = C27300a.CLOSING;
                m60930e(i, str, false);
                AppMethodBeat.m2505o(73211);
                return;
            }
            if (this.iSE.aOl() != C38511a.NONE) {
                try {
                    mo54002b(new C27302b(i, str));
                } catch (C27301b e) {
                    C4990ab.m7412e("MicroMsg.AppBrandNetWork.WebSocketImpl", "close: " + e.toString());
                    this.iSC.mo45000f(e);
                    m60930e(1006, "generated frame is invalid", false);
                }
            }
            m60930e(i, str, z);
        } else if (i == -3) {
            m60930e(-3, str, true);
        } else {
            m60930e(-1, str, false);
        }
        if (i == 1002) {
            m60930e(i, str, z);
        }
        this.iSB = C27300a.CLOSING;
        this.iSH = null;
        AppMethodBeat.m2505o(73211);
    }

    /* renamed from: af */
    public final synchronized void mo58573af(int i, String str) {
        AppMethodBeat.m2504i(73212);
        if (this.iSB == C27300a.CLOSED) {
            AppMethodBeat.m2505o(73212);
        } else {
            if (this.iSw != null) {
                this.iSw.cancel();
            }
            if (this.iSx != null) {
                try {
                    this.iSx.close();
                } catch (IOException e) {
                    this.iSC.mo45000f(e);
                }
            }
            try {
                this.iSC.mo44997ag(i, str);
            } catch (RuntimeException e2) {
                this.iSC.mo45000f(e2);
            }
            if (this.iSE != null) {
                this.iSE.reset();
            }
            this.iSI = null;
            this.iSB = C27300a.CLOSED;
            this.iSy.clear();
            AppMethodBeat.m2505o(73212);
        }
    }

    /* renamed from: e */
    private synchronized void m60930e(int i, String str, boolean z) {
        AppMethodBeat.m2504i(73213);
        if (this.iSA) {
            AppMethodBeat.m2505o(73213);
        } else {
            this.iSK = Integer.valueOf(i);
            this.iSJ = str;
            this.iSL = Boolean.valueOf(z);
            this.iSA = true;
            if (this.iSE != null) {
                this.iSE.reset();
            }
            this.iSI = null;
            AppMethodBeat.m2505o(73213);
        }
    }

    /* renamed from: BU */
    public final void mo58569BU(String str) {
        AppMethodBeat.m2504i(73216);
        if (str == null) {
            C4990ab.m7416i("MicroMsg.AppBrandNetWork.WebSocketImpl", "Cannot send 'null' data to a WebSocketImpl.");
            AppMethodBeat.m2505o(73216);
            return;
        }
        m60931f(this.iSE.mo54006ar(str, this.iSF == C19740b.CLIENT));
        AppMethodBeat.m2505o(73216);
    }

    /* renamed from: p */
    public final void mo58578p(ByteBuffer byteBuffer) {
        AppMethodBeat.m2504i(73217);
        if (byteBuffer == null) {
            C4990ab.m7416i("MicroMsg.AppBrandNetWork.WebSocketImpl", "Cannot send 'null' data to a WebSocketImpl.");
            AppMethodBeat.m2505o(73217);
            return;
        }
        m60931f(this.iSE.mo54004a(byteBuffer, this.iSF == C19740b.CLIENT));
        AppMethodBeat.m2505o(73217);
    }

    /* renamed from: f */
    private void m60931f(Collection<C33533d> collection) {
        AppMethodBeat.m2504i(73218);
        if (isOpen()) {
            for (C33533d b : collection) {
                mo54002b(b);
            }
            AppMethodBeat.m2505o(73218);
            return;
        }
        C33532f c33532f = new C33532f();
        AppMethodBeat.m2505o(73218);
        throw c33532f;
    }

    /* renamed from: b */
    public final void mo54002b(C33533d c33533d) {
        AppMethodBeat.m2504i(73219);
        if (DEBUG) {
            C4990ab.m7416i("MicroMsg.AppBrandNetWork.WebSocketImpl", "\"send frame: \" + framedata ");
        }
        m60934u(this.iSE.mo54007d(c33533d));
        AppMethodBeat.m2505o(73219);
    }

    /* renamed from: u */
    private void m60934u(ByteBuffer byteBuffer) {
        AppMethodBeat.m2504i(73220);
        if (DEBUG) {
            C4990ab.m7416i("MicroMsg.AppBrandNetWork.WebSocketImpl", "write(\" + buf.remaining() + \"): {\" + ( buf.remaining() > 1000 ? \"too big to display\" : new String( buf.array() ) ) + \"}");
        }
        this.iSy.add(byteBuffer);
        AppMethodBeat.m2505o(73220);
    }

    /* renamed from: aQ */
    public final void mo58572aQ(List<ByteBuffer> list) {
        AppMethodBeat.m2504i(73221);
        for (ByteBuffer u : list) {
            m60934u(u);
        }
        AppMethodBeat.m2505o(73221);
    }

    /* renamed from: c */
    private void m60929c(C10742f c10742f) {
        AppMethodBeat.m2504i(73222);
        if (DEBUG) {
            C4990ab.m7416i("MicroMsg.AppBrandNetWork.WebSocketImpl", "open using draft: " + this.iSE.getClass().getSimpleName());
        }
        this.iSB = C27300a.OPEN;
        try {
            this.iSC.mo44999d(c10742f);
            AppMethodBeat.m2505o(73222);
        } catch (RuntimeException e) {
            this.iSC.mo45000f(e);
            AppMethodBeat.m2505o(73222);
        }
    }

    public final boolean isOpen() {
        return this.iSB == C27300a.OPEN;
    }

    public final boolean aOj() {
        return this.iSB == C27300a.CLOSING;
    }

    public final boolean isClosed() {
        return this.iSB == C27300a.CLOSED;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(73223);
        int hashCode = super.hashCode();
        AppMethodBeat.m2505o(73223);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.m2504i(73224);
        String obj = super.toString();
        AppMethodBeat.m2505o(73224);
        return obj;
    }

    public final void aOi() {
        AppMethodBeat.m2504i(73214);
        if (this.iSB == C27300a.NOT_YET_CONNECTED) {
            mo58573af(-1, "");
            AppMethodBeat.m2505o(73214);
        } else if (this.iSA) {
            int intValue = this.iSK.intValue();
            String str = this.iSJ;
            this.iSL.booleanValue();
            mo58573af(intValue, str);
            AppMethodBeat.m2505o(73214);
        } else if (this.iSE.aOl() == C38511a.NONE) {
            mo58573af(1000, "");
            AppMethodBeat.m2505o(73214);
        } else if (this.iSE.aOl() != C38511a.ONEWAY || this.iSF == C19740b.SERVER) {
            mo58573af(1006, "");
            AppMethodBeat.m2505o(73214);
        } else {
            mo58573af(1000, "");
            AppMethodBeat.m2505o(73214);
        }
    }

    /* renamed from: a */
    private void m60928a(C27301b c27301b) {
        AppMethodBeat.m2504i(73215);
        mo58574d(c27301b.iTp, c27301b.getMessage(), false);
        AppMethodBeat.m2505o(73215);
    }
}
