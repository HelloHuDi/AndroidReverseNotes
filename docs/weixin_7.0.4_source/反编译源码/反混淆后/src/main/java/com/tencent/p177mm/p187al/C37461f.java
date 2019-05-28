package com.tencent.p177mm.p187al;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C45141c;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.C7273mw;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C5128ac;
import com.tencent.p177mm.vfs.C5728b;
import java.util.HashMap;
import java.util.Random;

/* renamed from: com.tencent.mm.al.f */
public class C37461f implements C1816at {
    private long fzA = 0;
    private C7306ak fzB = new C7306ak(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(78075);
            if (message.what != 1) {
                AppMethodBeat.m2505o(78075);
            } else if (C37461f.this.fzA == 0) {
                AppMethodBeat.m2505o(78075);
            } else {
                C4990ab.m7417i("MicroMsg.SubCoreCdnTransport", "try get dns again scene[%d] lastGetDnsErrorTime[%d]  diff[%d]", Integer.valueOf(message.arg1), Long.valueOf(C37461f.this.fzA), Long.valueOf(C5046bo.m7566gb(C37461f.this.fzA)));
                C1720g.m3540Rg().mo14541a(new C32243d(r0), 0);
                AppMethodBeat.m2505o(78075);
            }
        }
    };
    private C1202f fzC = new C322453();
    private C8941a fzx = null;
    private C31259b fzy = null;
    private C45141c fzz;

    /* renamed from: com.tencent.mm.al.f$1 */
    class C12371 implements C45141c {

        /* renamed from: com.tencent.mm.al.f$1$1 */
        class C12381 implements Runnable {
            C12381() {
            }

            public final void run() {
                AppMethodBeat.m2504i(78072);
                if (C37461f.afx() != null) {
                    C37461f.afx().mo51223cK(false);
                }
                AppMethodBeat.m2505o(78072);
            }

            public final String toString() {
                AppMethodBeat.m2504i(78073);
                String str = super.toString() + "|infoUpdate";
                AppMethodBeat.m2505o(78073);
                return str;
            }
        }

        C12371() {
        }

        /* renamed from: a */
        public final void mo4512a(C7273mw c7273mw, C7273mw c7273mw2, C7273mw c7273mw3) {
            AppMethodBeat.m2504i(78074);
            C4990ab.m7410d("MicroMsg.SubCoreCdnTransport", "cdntra infoUpdate dns info " + c7273mw.toString() + " getCore().engine:" + C37461f.afy());
            if (C37461f.afy() != null) {
                C37461f.afy().mo20369a(c7273mw, c7273mw2, c7273mw3, null, null, null);
                C1720g.m3539RS().mo10302aa(new C12381());
            }
            AppMethodBeat.m2505o(78074);
        }
    }

    /* renamed from: com.tencent.mm.al.f$3 */
    class C322453 implements C1202f {
        C322453() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(78076);
            if (c1207m instanceof C32243d) {
                C4990ab.m7417i("MicroMsg.SubCoreCdnTransport", "%d get cdn dns on scene end errType[%d] errCode[%d] errMsg[%s] lastGetDnsErrorTime[%d]", Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(i2), str, Long.valueOf(C37461f.this.fzA));
                if ("doScene failed".equals(str)) {
                    C4990ab.m7411d("MicroMsg.SubCoreCdnTransport", "%d get cdn dns cache do nothing.", Integer.valueOf(hashCode()));
                    AppMethodBeat.m2505o(78076);
                    return;
                }
                C7060h.pYm.mo8378a(546, (long) (i + 10), 1, true);
                if (i == 0) {
                    if (C37461f.this.fzA > 0) {
                        C7060h.pYm.mo8378a(546, 52, 1, true);
                        C37461f.this.fzA = 0;
                    }
                    AppMethodBeat.m2505o(78076);
                    return;
                } else if (i == 4) {
                    AppMethodBeat.m2505o(78076);
                    return;
                } else if (C37461f.this.fzA == 0) {
                    int i3 = ((C32243d) c1207m).scene;
                    C37461f.this.fzA = C5046bo.anU();
                    C37461f.this.fzB.removeMessages(1);
                    C37461f.this.fzB.sendMessageDelayed(C37461f.this.fzB.obtainMessage(1, i3, 0), 30000);
                    C7060h.pYm.mo8378a(546, 50, 1, true);
                    AppMethodBeat.m2505o(78076);
                    return;
                } else {
                    C37461f.this.fzA = 0;
                    C7060h.pYm.mo8378a(546, 51, 1, true);
                    AppMethodBeat.m2505o(78076);
                    return;
                }
            }
            C4990ab.m7420w("MicroMsg.SubCoreCdnTransport", "get cdn dns on scene end but is not [NetSceneGetCdnDns]");
            AppMethodBeat.m2505o(78076);
        }
    }

    public C37461f() {
        AppMethodBeat.m2504i(78077);
        AppMethodBeat.m2505o(78077);
    }

    public static synchronized C37461f afu() {
        C37461f c37461f;
        synchronized (C37461f.class) {
            AppMethodBeat.m2504i(78078);
            c37461f = (C37461f) C7485q.m12925Y(C37461f.class);
            AppMethodBeat.m2505o(78078);
        }
        return c37461f;
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return null;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    public static String afv() {
        AppMethodBeat.m2504i(78079);
        C1720g.m3534RN().mo5159QU();
        String str = C1720g.m3536RP().cachePath + "cdndnsinfo/";
        AppMethodBeat.m2505o(78079);
        return str;
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    public static C45141c afw() {
        AppMethodBeat.m2504i(78080);
        C45141c c45141c = C37461f.afu().fzz;
        AppMethodBeat.m2505o(78080);
        return c45141c;
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(78081);
        onAccountRelease();
        C1720g.m3534RN().mo5159QU();
        if (C37461f.afu().fzy == null) {
            C37461f.afu().fzy = new C31259b();
            C4990ab.m7417i("MicroMsg.SubCoreCdnTransport", "summersafecdn onAccountPostReset new CdnTransportService hash[%s]", Integer.valueOf(C37461f.afu().fzy.hashCode()));
        }
        C5728b c5728b = new C5728b(C37461f.afv());
        if (!c5728b.exists()) {
            c5728b.mkdirs();
        }
        this.fzz = new C12371();
        C1720g.m3540Rg().mo14539a(379, this.fzC);
        C4990ab.m7416i("MicroMsg.SubCoreCdnTransport", "onAccountPostReset, tryToGetCdnDns");
        mo60373li(1);
        AppMethodBeat.m2505o(78081);
    }

    public static C31259b afx() {
        AppMethodBeat.m2504i(78082);
        if (C37461f.afu().fzy == null) {
            synchronized (C37461f.class) {
                try {
                    if (C37461f.afu().fzy == null) {
                        C37461f.afu().fzy = new C31259b();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(78082);
                    }
                }
            }
        }
        C31259b c31259b = C37461f.afu().fzy;
        AppMethodBeat.m2505o(78082);
        return c31259b;
    }

    public static synchronized C8941a afy() {
        C8941a c8941a;
        synchronized (C37461f.class) {
            AppMethodBeat.m2504i(78083);
            if (C37461f.afu().fzx == null) {
                C1720g.m3534RN();
                if (C1668a.m3395QX()) {
                    C37461f.afu().fzx = new C8941a(C1720g.m3536RP().cachePath, C37461f.afx());
                } else {
                    C4990ab.m7419v("MicroMsg.SubCoreCdnTransport", "hy: cdn temp path: %s", C5128ac.eSj + C1178g.m2591x(("mm" + new Random().nextLong()).getBytes()) + "/");
                    C37461f.afu().fzx = new C8941a(r0, C37461f.afx());
                }
            }
            c8941a = C37461f.afu().fzx;
            AppMethodBeat.m2505o(78083);
        }
        return c8941a;
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(78084);
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
        C1720g.m3540Rg().mo14546b(379, this.fzC);
        AppMethodBeat.m2505o(78084);
    }

    /* renamed from: li */
    public final void mo60373li(int i) {
        AppMethodBeat.m2504i(78085);
        this.fzA = 0;
        this.fzB.removeMessages(1);
        C1720g.m3540Rg().mo14541a(new C32243d(i), 0);
        AppMethodBeat.m2505o(78085);
    }
}
