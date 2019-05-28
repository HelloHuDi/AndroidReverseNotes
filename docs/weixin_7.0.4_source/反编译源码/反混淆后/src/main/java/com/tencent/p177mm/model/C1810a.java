package com.tencent.p177mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1898c;
import com.tencent.p177mm.p178a.C1179i;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.plugin.zero.p757b.C7234a;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.model.a */
public final class C1810a {
    public byte[] fka;
    public long fkb = -1;

    /* renamed from: com.tencent.mm.model.a$1 */
    class C18091 implements Runnable {
        C18091() {
        }

        public final void run() {
            AppMethodBeat.m2504i(58083);
            try {
                if (C1810a.m3717XF()) {
                    C7053e.pXa.mo8378a(226, 1, 1, false);
                }
                AppMethodBeat.m2505o(58083);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.AccInfoCacheInWorker", "init Exception:%s", C5046bo.m7574l(e));
                AppMethodBeat.m2505o(58083);
            }
        }
    }

    /* renamed from: XE */
    public final int mo5375XE() {
        return this.fka == null ? -1 : this.fka.length;
    }

    public C1810a() {
        AppMethodBeat.m2504i(58084);
        if (C1810a.m3717XF()) {
            C5004al.m7442n(new C18091(), 5000);
        }
        AppMethodBeat.m2505o(58084);
    }

    /* renamed from: XF */
    public static boolean m3717XF() {
        AppMethodBeat.m2504i(58085);
        if (C1668a.m3393QT() || !C1720g.m3531RK()) {
            AppMethodBeat.m2505o(58085);
            return false;
        }
        int i = C5046bo.getInt(((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("AndroidUseWorkerAuthCache"), 0);
        C1720g.m3537RQ();
        C1720g.m3534RN();
        int bL = C1179i.m2593bL(C1668a.m3383QF(), 100);
        boolean dnO = C4872b.dnO();
        r7 = new Object[5];
        C1720g.m3537RQ();
        C1720g.m3534RN();
        r7[2] = Integer.valueOf(C1668a.m3383QF());
        r7[3] = Integer.valueOf(bL);
        r7[4] = Boolean.valueOf(C1720g.m3534RN().mo5161QY());
        C4990ab.m7417i("MicroMsg.AccInfoCacheInWorker", "checkUse debug:%s dyVal:%s uin:%d  uinHash:%d init:%b", r7);
        if (dnO) {
            AppMethodBeat.m2505o(58085);
            return true;
        } else if (i > bL) {
            AppMethodBeat.m2505o(58085);
            return true;
        } else {
            AppMethodBeat.m2505o(58085);
            return false;
        }
    }

    /* renamed from: XG */
    public static void m3718XG() {
        AppMethodBeat.m2504i(58086);
        if (C1810a.m3717XF()) {
            try {
                C1720g.m3537RQ();
                C1810a c1810a = C1720g.m3534RN().eIQ;
                C1720g.m3537RQ();
                C1898c adg = C1720g.m3535RO().eJo.ftA.adg();
                long anU = C5046bo.anU();
                if (adg == null) {
                    C4990ab.m7412e("MicroMsg.AccInfoCacheInWorker", "backupToWorker  accinfo == null");
                    C7053e.pXa.mo8378a(226, 2, 1, false);
                    AppMethodBeat.m2505o(58086);
                    return;
                }
                C4990ab.m7417i("MicroMsg.AccInfoCacheInWorker", "backupToWorker islogin:%b cache:%s", Boolean.valueOf(adg.adb()), Integer.valueOf(c1810a.mo5375XE()));
                if (adg.adb()) {
                    c1810a.fka = adg.adf();
                    C7053e.pXa.mo8378a(226, c1810a.mo5375XE() > 0 ? 4 : 5, 1, false);
                    C4990ab.m7417i("MicroMsg.AccInfoCacheInWorker", "backupToWorker time:%s cache:%s useCacheCount:%s ", Long.valueOf(C5046bo.m7566gb(anU)), Integer.valueOf(c1810a.mo5375XE()), Long.valueOf(c1810a.fkb));
                    if (c1810a.mo5375XE() > 0) {
                        C7053e.pXa.mo8378a(226, 31 - (c1810a.fkb > 5 ? 5 : c1810a.fkb), 1, false);
                        C7053e.pXa.mo8381e(11098, Integer.valueOf(2000), Long.valueOf(c1810a.fkb));
                        c1810a.fkb = -1;
                    }
                    AppMethodBeat.m2505o(58086);
                    return;
                }
                C7053e.pXa.mo8378a(226, 3, 1, false);
                C4990ab.m7412e("MicroMsg.AccInfoCacheInWorker", "backupToWorker ERR: Is Not Login");
                AppMethodBeat.m2505o(58086);
                return;
            } catch (Throwable th) {
                C4990ab.m7413e("MicroMsg.AccInfoCacheInWorker", "tryBackupToWorker Exception:%s", C5046bo.m7574l(th));
                AppMethodBeat.m2505o(58086);
                return;
            }
        }
        AppMethodBeat.m2505o(58086);
    }
}
