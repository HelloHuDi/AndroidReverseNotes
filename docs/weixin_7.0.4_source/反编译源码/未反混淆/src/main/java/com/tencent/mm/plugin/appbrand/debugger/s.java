package com.tencent.mm.plugin.appbrand.debugger;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.l.j;
import com.tencent.mm.plugin.appbrand.l.k.b;
import com.tencent.mm.plugin.appbrand.t.a.a;
import com.tencent.mm.plugin.appbrand.t.b.d;
import com.tencent.mm.plugin.appbrand.t.e.h;
import com.tencent.mm.protocal.protobuf.cqs;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.net.Proxy;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.HashMap;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

public final class s {
    a hkv;
    private SSLSocketFactory hkw;

    public s(com.tencent.mm.plugin.appbrand.l.a aVar) {
        AppMethodBeat.i(101902);
        SSLContext a = j.a(aVar);
        if (a != null) {
            this.hkw = a.getSocketFactory();
        }
        AppMethodBeat.o(101902);
    }

    public final void a(String str, b bVar) {
        AppMethodBeat.i(101903);
        ab.i("MicroMsg.RemoteDebugSocket", "connectSocket url is %s", str);
        try {
            URI uri = new URI(str);
            HashMap hashMap = new HashMap();
            if (str.startsWith("ws://localhost:")) {
                hashMap.put("Sec-WebSocket-Protocol", "client");
            }
            try {
                final b bVar2 = bVar;
                this.hkv = new a(uri, new d(), hashMap) {
                    private com.tencent.mm.plugin.appbrand.t.d.d hkx = null;

                    public final void a(h hVar) {
                        AppMethodBeat.i(101896);
                        ab.d("MicroMsg.RemoteDebugSocket", "onSocketOpen");
                        bVar2.azg();
                        AppMethodBeat.o(101896);
                    }

                    public final void zO(String str) {
                        AppMethodBeat.i(101897);
                        s.this.hkv.BU(str);
                        ab.d("MicroMsg.RemoteDebugSocket", "onSocketMessage, message: %s", str);
                        bVar2.azh();
                        AppMethodBeat.o(101897);
                    }

                    public final void N(int i, String str) {
                        AppMethodBeat.i(101898);
                        ab.i("MicroMsg.RemoteDebugSocket", "onClose,reason: %s, errCode = %d", str, Integer.valueOf(i));
                        if (i == -1 || i == -2 || i == -3) {
                            if (at.isConnected(ah.getContext())) {
                                bVar2.zJ(str);
                            } else {
                                bVar2.zJ("network is down");
                                i = 1006;
                            }
                            bVar2.K(i, str);
                            AppMethodBeat.o(101898);
                            return;
                        }
                        bVar2.K(i, str);
                        AppMethodBeat.o(101898);
                    }

                    public final void onError(Exception exception) {
                        AppMethodBeat.i(101899);
                        ab.e("MicroMsg.RemoteDebugSocket", "onSocketError, ex: " + exception.toString());
                        AppMethodBeat.o(101899);
                    }

                    public final void m(ByteBuffer byteBuffer) {
                        AppMethodBeat.i(101900);
                        bVar2.l(byteBuffer);
                        AppMethodBeat.o(101900);
                    }

                    public final void a(com.tencent.mm.plugin.appbrand.t.d.d dVar) {
                        AppMethodBeat.i(101901);
                        if (dVar.aOt() == com.tencent.mm.plugin.appbrand.t.d.d.a.CONTINUOUS || dVar.aOr()) {
                            if (dVar.aOt() == com.tencent.mm.plugin.appbrand.t.d.d.a.CONTINUOUS) {
                                if (this.hkx == null) {
                                    AppMethodBeat.o(101901);
                                    return;
                                } else if (this.hkx.aOq().position() > 10485760) {
                                    ab.e("MicroMsg.RemoteDebugSocket", "Pending Frame exploded");
                                    this.hkx = null;
                                    AppMethodBeat.o(101901);
                                    return;
                                } else {
                                    try {
                                        this.hkx.e(dVar);
                                    } catch (Exception e) {
                                        ab.e("MicroMsg.RemoteDebugSocket", e.getMessage());
                                    }
                                    if (dVar.aOr()) {
                                        if (this.hkx.aOt() == com.tencent.mm.plugin.appbrand.t.d.d.a.BINARY) {
                                            m(this.hkx.aOq());
                                        } else if (this.hkx.aOt() == com.tencent.mm.plugin.appbrand.t.d.d.a.TEXT) {
                                            try {
                                                zO(bo.nullAsNil(com.tencent.mm.plugin.appbrand.t.f.b.B(this.hkx.aOq())));
                                            } catch (Exception e2) {
                                                ab.e("MicroMsg.RemoteDebugSocket", e2.getMessage());
                                            }
                                        }
                                        this.hkx = null;
                                    } else {
                                        AppMethodBeat.o(101901);
                                        return;
                                    }
                                }
                            }
                            AppMethodBeat.o(101901);
                            return;
                        }
                        this.hkx = dVar;
                        AppMethodBeat.o(101901);
                    }
                };
                if (com.tencent.luggage.g.h.t(str, "ws://")) {
                    this.hkv.a(new Socket(Proxy.NO_PROXY));
                    this.hkv.connect();
                    AppMethodBeat.o(101903);
                    return;
                }
                SSLSocketFactory sSLSocketFactory;
                if (this.hkw != null) {
                    sSLSocketFactory = this.hkw;
                } else {
                    sSLSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
                }
                this.hkv.a(sSLSocketFactory.createSocket());
                this.hkv.connect();
                AppMethodBeat.o(101903);
            } catch (Exception e) {
                ab.e("MicroMsg.RemoteDebugSocket", "onSocketMessage %s", Log.getStackTraceString(e));
                AppMethodBeat.o(101903);
            }
        } catch (Exception e2) {
            ab.e("MicroMsg.RemoteDebugSocket", "connect fail : %s ", e2.toString());
            bVar.zK("url not well format");
            AppMethodBeat.o(101903);
        }
    }

    public final boolean isOpen() {
        AppMethodBeat.i(101904);
        if (this.hkv == null) {
            AppMethodBeat.o(101904);
            return false;
        }
        boolean isOpen = this.hkv.iSO.isOpen();
        AppMethodBeat.o(101904);
        return isOpen;
    }

    public final boolean a(cqs cqs) {
        AppMethodBeat.i(101905);
        ab.d("MicroMsg.RemoteDebugSocket", "sendSocketMsg");
        if (!isOpen()) {
            ab.w("MicroMsg.RemoteDebugSocket", "sendSocketMsg fail, not open");
            AppMethodBeat.o(101905);
            return false;
        } else if (cqs == null) {
            ab.w("MicroMsg.RemoteDebugSocket", "sendSocketMsg fail");
            AppMethodBeat.o(101905);
            return false;
        } else {
            this.hkv.p(t.c(cqs));
            AppMethodBeat.o(101905);
            return true;
        }
    }

    public final boolean zN(String str) {
        AppMethodBeat.i(101906);
        if (this.hkv == null) {
            ab.w("MicroMsg.RemoteDebugSocket", "client is null");
            AppMethodBeat.o(101906);
            return false;
        }
        this.hkv.ah(1000, str);
        ab.d("MicroMsg.RemoteDebugSocket", "closeSocket code %d, reason %s", Integer.valueOf(1000), str);
        AppMethodBeat.o(101906);
        return true;
    }
}
