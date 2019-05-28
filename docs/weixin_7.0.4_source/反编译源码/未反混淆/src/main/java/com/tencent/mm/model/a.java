package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.c;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

public final class a {
    public byte[] fka;
    public long fkb = -1;

    public final int XE() {
        return this.fka == null ? -1 : this.fka.length;
    }

    public a() {
        AppMethodBeat.i(58084);
        if (XF()) {
            al.n(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(58083);
                    try {
                        if (a.XF()) {
                            e.pXa.a(226, 1, 1, false);
                        }
                        AppMethodBeat.o(58083);
                    } catch (Exception e) {
                        ab.e("MicroMsg.AccInfoCacheInWorker", "init Exception:%s", bo.l(e));
                        AppMethodBeat.o(58083);
                    }
                }
            }, 5000);
        }
        AppMethodBeat.o(58084);
    }

    public static boolean XF() {
        AppMethodBeat.i(58085);
        if (com.tencent.mm.kernel.a.QT() || !g.RK()) {
            AppMethodBeat.o(58085);
            return false;
        }
        int i = bo.getInt(((com.tencent.mm.plugin.zero.b.a) g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getValue("AndroidUseWorkerAuthCache"), 0);
        g.RQ();
        g.RN();
        int bL = i.bL(com.tencent.mm.kernel.a.QF(), 100);
        boolean dnO = b.dnO();
        r7 = new Object[5];
        g.RQ();
        g.RN();
        r7[2] = Integer.valueOf(com.tencent.mm.kernel.a.QF());
        r7[3] = Integer.valueOf(bL);
        r7[4] = Boolean.valueOf(g.RN().QY());
        ab.i("MicroMsg.AccInfoCacheInWorker", "checkUse debug:%s dyVal:%s uin:%d  uinHash:%d init:%b", r7);
        if (dnO) {
            AppMethodBeat.o(58085);
            return true;
        } else if (i > bL) {
            AppMethodBeat.o(58085);
            return true;
        } else {
            AppMethodBeat.o(58085);
            return false;
        }
    }

    public static void XG() {
        AppMethodBeat.i(58086);
        if (XF()) {
            try {
                g.RQ();
                a aVar = g.RN().eIQ;
                g.RQ();
                c adg = g.RO().eJo.ftA.adg();
                long anU = bo.anU();
                if (adg == null) {
                    ab.e("MicroMsg.AccInfoCacheInWorker", "backupToWorker  accinfo == null");
                    e.pXa.a(226, 2, 1, false);
                    AppMethodBeat.o(58086);
                    return;
                }
                ab.i("MicroMsg.AccInfoCacheInWorker", "backupToWorker islogin:%b cache:%s", Boolean.valueOf(adg.adb()), Integer.valueOf(aVar.XE()));
                if (adg.adb()) {
                    aVar.fka = adg.adf();
                    e.pXa.a(226, aVar.XE() > 0 ? 4 : 5, 1, false);
                    ab.i("MicroMsg.AccInfoCacheInWorker", "backupToWorker time:%s cache:%s useCacheCount:%s ", Long.valueOf(bo.gb(anU)), Integer.valueOf(aVar.XE()), Long.valueOf(aVar.fkb));
                    if (aVar.XE() > 0) {
                        e.pXa.a(226, 31 - (aVar.fkb > 5 ? 5 : aVar.fkb), 1, false);
                        e.pXa.e(11098, Integer.valueOf(2000), Long.valueOf(aVar.fkb));
                        aVar.fkb = -1;
                    }
                    AppMethodBeat.o(58086);
                    return;
                }
                e.pXa.a(226, 3, 1, false);
                ab.e("MicroMsg.AccInfoCacheInWorker", "backupToWorker ERR: Is Not Login");
                AppMethodBeat.o(58086);
                return;
            } catch (Throwable th) {
                ab.e("MicroMsg.AccInfoCacheInWorker", "tryBackupToWorker Exception:%s", bo.l(th));
                AppMethodBeat.o(58086);
                return;
            }
        }
        AppMethodBeat.o(58086);
    }
}
