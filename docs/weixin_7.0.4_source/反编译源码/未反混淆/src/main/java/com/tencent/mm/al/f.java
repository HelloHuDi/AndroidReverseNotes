package com.tencent.mm.al;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.mw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.vfs.b;
import java.util.HashMap;
import java.util.Random;

public class f implements at {
    private long fzA = 0;
    private ak fzB = new ak(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(78075);
            if (message.what != 1) {
                AppMethodBeat.o(78075);
            } else if (f.this.fzA == 0) {
                AppMethodBeat.o(78075);
            } else {
                ab.i("MicroMsg.SubCoreCdnTransport", "try get dns again scene[%d] lastGetDnsErrorTime[%d]  diff[%d]", Integer.valueOf(message.arg1), Long.valueOf(f.this.fzA), Long.valueOf(bo.gb(f.this.fzA)));
                g.Rg().a(new d(r0), 0);
                AppMethodBeat.o(78075);
            }
        }
    };
    private com.tencent.mm.ai.f fzC = new com.tencent.mm.ai.f() {
        public final void onSceneEnd(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(78076);
            if (mVar instanceof d) {
                ab.i("MicroMsg.SubCoreCdnTransport", "%d get cdn dns on scene end errType[%d] errCode[%d] errMsg[%s] lastGetDnsErrorTime[%d]", Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(i2), str, Long.valueOf(f.this.fzA));
                if ("doScene failed".equals(str)) {
                    ab.d("MicroMsg.SubCoreCdnTransport", "%d get cdn dns cache do nothing.", Integer.valueOf(hashCode()));
                    AppMethodBeat.o(78076);
                    return;
                }
                h.pYm.a(546, (long) (i + 10), 1, true);
                if (i == 0) {
                    if (f.this.fzA > 0) {
                        h.pYm.a(546, 52, 1, true);
                        f.this.fzA = 0;
                    }
                    AppMethodBeat.o(78076);
                    return;
                } else if (i == 4) {
                    AppMethodBeat.o(78076);
                    return;
                } else if (f.this.fzA == 0) {
                    int i3 = ((d) mVar).scene;
                    f.this.fzA = bo.anU();
                    f.this.fzB.removeMessages(1);
                    f.this.fzB.sendMessageDelayed(f.this.fzB.obtainMessage(1, i3, 0), 30000);
                    h.pYm.a(546, 50, 1, true);
                    AppMethodBeat.o(78076);
                    return;
                } else {
                    f.this.fzA = 0;
                    h.pYm.a(546, 51, 1, true);
                    AppMethodBeat.o(78076);
                    return;
                }
            }
            ab.w("MicroMsg.SubCoreCdnTransport", "get cdn dns on scene end but is not [NetSceneGetCdnDns]");
            AppMethodBeat.o(78076);
        }
    };
    private a fzx = null;
    private b fzy = null;
    private c fzz;

    public f() {
        AppMethodBeat.i(78077);
        AppMethodBeat.o(78077);
    }

    public static synchronized f afu() {
        f fVar;
        synchronized (f.class) {
            AppMethodBeat.i(78078);
            fVar = (f) q.Y(f.class);
            AppMethodBeat.o(78078);
        }
        return fVar;
    }

    public final HashMap<Integer, d> Jx() {
        return null;
    }

    public final void iy(int i) {
    }

    public static String afv() {
        AppMethodBeat.i(78079);
        g.RN().QU();
        String str = g.RP().cachePath + "cdndnsinfo/";
        AppMethodBeat.o(78079);
        return str;
    }

    public final void bA(boolean z) {
    }

    public static c afw() {
        AppMethodBeat.i(78080);
        c cVar = afu().fzz;
        AppMethodBeat.o(78080);
        return cVar;
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(78081);
        onAccountRelease();
        g.RN().QU();
        if (afu().fzy == null) {
            afu().fzy = new b();
            ab.i("MicroMsg.SubCoreCdnTransport", "summersafecdn onAccountPostReset new CdnTransportService hash[%s]", Integer.valueOf(afu().fzy.hashCode()));
        }
        b bVar = new b(afv());
        if (!bVar.exists()) {
            bVar.mkdirs();
        }
        this.fzz = new c() {
            public final void a(mw mwVar, mw mwVar2, mw mwVar3) {
                AppMethodBeat.i(78074);
                ab.d("MicroMsg.SubCoreCdnTransport", "cdntra infoUpdate dns info " + mwVar.toString() + " getCore().engine:" + f.afy());
                if (f.afy() != null) {
                    f.afy().a(mwVar, mwVar2, mwVar3, null, null, null);
                    g.RS().aa(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(78072);
                            if (f.afx() != null) {
                                f.afx().cK(false);
                            }
                            AppMethodBeat.o(78072);
                        }

                        public final String toString() {
                            AppMethodBeat.i(78073);
                            String str = super.toString() + "|infoUpdate";
                            AppMethodBeat.o(78073);
                            return str;
                        }
                    });
                }
                AppMethodBeat.o(78074);
            }
        };
        g.Rg().a(379, this.fzC);
        ab.i("MicroMsg.SubCoreCdnTransport", "onAccountPostReset, tryToGetCdnDns");
        li(1);
        AppMethodBeat.o(78081);
    }

    public static b afx() {
        AppMethodBeat.i(78082);
        if (afu().fzy == null) {
            synchronized (f.class) {
                try {
                    if (afu().fzy == null) {
                        afu().fzy = new b();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(78082);
                    }
                }
            }
        }
        b bVar = afu().fzy;
        AppMethodBeat.o(78082);
        return bVar;
    }

    public static synchronized a afy() {
        a aVar;
        synchronized (f.class) {
            AppMethodBeat.i(78083);
            if (afu().fzx == null) {
                g.RN();
                if (a.QX()) {
                    afu().fzx = new a(g.RP().cachePath, afx());
                } else {
                    ab.v("MicroMsg.SubCoreCdnTransport", "hy: cdn temp path: %s", ac.eSj + com.tencent.mm.a.g.x(("mm" + new Random().nextLong()).getBytes()) + "/");
                    afu().fzx = new a(r0, afx());
                }
            }
            aVar = afu().fzx;
            AppMethodBeat.o(78083);
        }
        return aVar;
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(78084);
        this.fzz = null;
        if (this.fzx != null) {
            this.fzx.release();
            this.fzx = null;
        }
        if (this.fzy != null) {
            this.fzy.release();
            this.fzy = null;
        }
        this.fzA = 0;
        this.fzB.removeCallbacksAndMessages(null);
        g.Rg().b(379, this.fzC);
        AppMethodBeat.o(78084);
    }

    public final void li(int i) {
        AppMethodBeat.i(78085);
        this.fzA = 0;
        this.fzB.removeMessages(1);
        g.Rg().a(new d(i), 0);
        AppMethodBeat.o(78085);
    }
}
