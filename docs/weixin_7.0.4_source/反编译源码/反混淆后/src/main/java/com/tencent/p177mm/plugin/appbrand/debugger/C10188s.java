package com.tencent.p177mm.plugin.appbrand.debugger;

import android.util.Log;
import com.tencent.luggage.p147g.C8874h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p321l.C19538j;
import com.tencent.p177mm.plugin.appbrand.p321l.C19541k.C19543b;
import com.tencent.p177mm.plugin.appbrand.p321l.C38414a;
import com.tencent.p177mm.plugin.appbrand.p332t.p1232d.C33533d;
import com.tencent.p177mm.plugin.appbrand.p332t.p1232d.C33533d.C33534a;
import com.tencent.p177mm.plugin.appbrand.p332t.p1539f.C42690b;
import com.tencent.p177mm.plugin.appbrand.p332t.p333a.C38510a;
import com.tencent.p177mm.plugin.appbrand.p332t.p334b.C6787d;
import com.tencent.p177mm.plugin.appbrand.p332t.p914e.C16696h;
import com.tencent.p177mm.protocal.protobuf.cqs;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.net.Proxy;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.HashMap;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

/* renamed from: com.tencent.mm.plugin.appbrand.debugger.s */
public final class C10188s {
    C38510a hkv;
    private SSLSocketFactory hkw;

    public C10188s(C38414a c38414a) {
        AppMethodBeat.m2504i(101902);
        SSLContext a = C19538j.m30268a(c38414a);
        if (a != null) {
            this.hkw = a.getSocketFactory();
        }
        AppMethodBeat.m2505o(101902);
    }

    /* renamed from: a */
    public final void mo21582a(String str, C19543b c19543b) {
        AppMethodBeat.m2504i(101903);
        C4990ab.m7417i("MicroMsg.RemoteDebugSocket", "connectSocket url is %s", str);
        try {
            URI uri = new URI(str);
            HashMap hashMap = new HashMap();
            if (str.startsWith("ws://localhost:")) {
                hashMap.put("Sec-WebSocket-Protocol", "client");
            }
            try {
                final C19543b c19543b2 = c19543b;
                this.hkv = new C38510a(uri, new C6787d(), hashMap) {
                    private C33533d hkx = null;

                    /* renamed from: a */
                    public final void mo21588a(C16696h c16696h) {
                        AppMethodBeat.m2504i(101896);
                        C4990ab.m7410d("MicroMsg.RemoteDebugSocket", "onSocketOpen");
                        c19543b2.azg();
                        AppMethodBeat.m2505o(101896);
                    }

                    /* renamed from: zO */
                    public final void mo21591zO(String str) {
                        AppMethodBeat.m2504i(101897);
                        C10188s.this.hkv.mo61219BU(str);
                        C4990ab.m7411d("MicroMsg.RemoteDebugSocket", "onSocketMessage, message: %s", str);
                        c19543b2.azh();
                        AppMethodBeat.m2505o(101897);
                    }

                    /* renamed from: N */
                    public final void mo21586N(int i, String str) {
                        AppMethodBeat.m2504i(101898);
                        C4990ab.m7417i("MicroMsg.RemoteDebugSocket", "onClose,reason: %s, errCode = %d", str, Integer.valueOf(i));
                        if (i == -1 || i == -2 || i == -3) {
                            if (C5023at.isConnected(C4996ah.getContext())) {
                                c19543b2.mo34738zJ(str);
                            } else {
                                c19543b2.mo34738zJ("network is down");
                                i = 1006;
                            }
                            c19543b2.mo34734K(i, str);
                            AppMethodBeat.m2505o(101898);
                            return;
                        }
                        c19543b2.mo34734K(i, str);
                        AppMethodBeat.m2505o(101898);
                    }

                    public final void onError(Exception exception) {
                        AppMethodBeat.m2504i(101899);
                        C4990ab.m7412e("MicroMsg.RemoteDebugSocket", "onSocketError, ex: " + exception.toString());
                        AppMethodBeat.m2505o(101899);
                    }

                    /* renamed from: m */
                    public final void mo21589m(ByteBuffer byteBuffer) {
                        AppMethodBeat.m2504i(101900);
                        c19543b2.mo34737l(byteBuffer);
                        AppMethodBeat.m2505o(101900);
                    }

                    /* renamed from: a */
                    public final void mo21587a(C33533d c33533d) {
                        AppMethodBeat.m2504i(101901);
                        if (c33533d.aOt() == C33534a.CONTINUOUS || c33533d.aOr()) {
                            if (c33533d.aOt() == C33534a.CONTINUOUS) {
                                if (this.hkx == null) {
                                    AppMethodBeat.m2505o(101901);
                                    return;
                                } else if (this.hkx.aOq().position() > 10485760) {
                                    C4990ab.m7412e("MicroMsg.RemoteDebugSocket", "Pending Frame exploded");
                                    this.hkx = null;
                                    AppMethodBeat.m2505o(101901);
                                    return;
                                } else {
                                    try {
                                        this.hkx.mo54014e(c33533d);
                                    } catch (Exception e) {
                                        C4990ab.m7412e("MicroMsg.RemoteDebugSocket", e.getMessage());
                                    }
                                    if (c33533d.aOr()) {
                                        if (this.hkx.aOt() == C33534a.BINARY) {
                                            mo21589m(this.hkx.aOq());
                                        } else if (this.hkx.aOt() == C33534a.TEXT) {
                                            try {
                                                mo21591zO(C5046bo.nullAsNil(C42690b.m75607B(this.hkx.aOq())));
                                            } catch (Exception e2) {
                                                C4990ab.m7412e("MicroMsg.RemoteDebugSocket", e2.getMessage());
                                            }
                                        }
                                        this.hkx = null;
                                    } else {
                                        AppMethodBeat.m2505o(101901);
                                        return;
                                    }
                                }
                            }
                            AppMethodBeat.m2505o(101901);
                            return;
                        }
                        this.hkx = c33533d;
                        AppMethodBeat.m2505o(101901);
                    }
                };
                if (C8874h.m15849t(str, "ws://")) {
                    this.hkv.mo61220a(new Socket(Proxy.NO_PROXY));
                    this.hkv.connect();
                    AppMethodBeat.m2505o(101903);
                    return;
                }
                SSLSocketFactory sSLSocketFactory;
                if (this.hkw != null) {
                    sSLSocketFactory = this.hkw;
                } else {
                    sSLSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
                }
                this.hkv.mo61220a(sSLSocketFactory.createSocket());
                this.hkv.connect();
                AppMethodBeat.m2505o(101903);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.RemoteDebugSocket", "onSocketMessage %s", Log.getStackTraceString(e));
                AppMethodBeat.m2505o(101903);
            }
        } catch (Exception e2) {
            C4990ab.m7413e("MicroMsg.RemoteDebugSocket", "connect fail : %s ", e2.toString());
            c19543b.mo34739zK("url not well format");
            AppMethodBeat.m2505o(101903);
        }
    }

    public final boolean isOpen() {
        AppMethodBeat.m2504i(101904);
        if (this.hkv == null) {
            AppMethodBeat.m2505o(101904);
            return false;
        }
        boolean isOpen = this.hkv.iSO.isOpen();
        AppMethodBeat.m2505o(101904);
        return isOpen;
    }

    /* renamed from: a */
    public final boolean mo21583a(cqs cqs) {
        AppMethodBeat.m2504i(101905);
        C4990ab.m7410d("MicroMsg.RemoteDebugSocket", "sendSocketMsg");
        if (!isOpen()) {
            C4990ab.m7420w("MicroMsg.RemoteDebugSocket", "sendSocketMsg fail, not open");
            AppMethodBeat.m2505o(101905);
            return false;
        } else if (cqs == null) {
            C4990ab.m7420w("MicroMsg.RemoteDebugSocket", "sendSocketMsg fail");
            AppMethodBeat.m2505o(101905);
            return false;
        } else {
            this.hkv.mo61230p(C26852t.m42765c(cqs));
            AppMethodBeat.m2505o(101905);
            return true;
        }
    }

    /* renamed from: zN */
    public final boolean mo21585zN(String str) {
        AppMethodBeat.m2504i(101906);
        if (this.hkv == null) {
            C4990ab.m7420w("MicroMsg.RemoteDebugSocket", "client is null");
            AppMethodBeat.m2505o(101906);
            return false;
        }
        this.hkv.mo61224ah(1000, str);
        C4990ab.m7411d("MicroMsg.RemoteDebugSocket", "closeSocket code %d, reason %s", Integer.valueOf(1000), str);
        AppMethodBeat.m2505o(101906);
        return true;
    }
}
