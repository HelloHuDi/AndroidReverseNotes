package com.tencent.mm.ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.g.a.mp;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bv;
import com.tencent.mm.protocal.protobuf.axd;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;

public final class p extends c<mp> {
    public p() {
        AppMethodBeat.i(78501);
        this.xxI = mp.class.getName().hashCode();
        AppMethodBeat.o(78501);
    }

    public final /* synthetic */ boolean a(b bVar) {
        AppMethodBeat.i(78503);
        boolean aiv = aiv();
        AppMethodBeat.o(78503);
        return aiv;
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean aiv() {
        int i;
        AppMethodBeat.i(78502);
        if (g.RN().QY()) {
            g.RN();
            if (!a.QT()) {
                i = 1;
                if (i != 0) {
                    if (bo.fp(bo.a((Long) g.RP().Ry().get(68097, null), 0)) * 1000 > 3600000) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    if (i != 0) {
                        LinkedList linkedList = new LinkedList();
                        byte[] f = e.f(g.RP().cachePath + "eggresult.rep", 0, -1);
                        if (f == null) {
                            AppMethodBeat.o(78502);
                            return false;
                        }
                        try {
                            Iterator it = ((h) new h().parseFrom(f)).fMm.iterator();
                            while (it.hasNext()) {
                                axd axd;
                                g gVar = (g) it.next();
                                if (gVar.fMk != 0) {
                                    axd = new axd();
                                    axd.pXC = 17;
                                    axd.pXM = gVar.cKB + "," + gVar.fMk;
                                    linkedList.add(axd);
                                }
                                if (gVar.fMl != 0) {
                                    axd = new axd();
                                    axd.pXC = 18;
                                    axd.pXM = gVar.cKB + "," + gVar.fMl;
                                    linkedList.add(axd);
                                }
                            }
                            e.deleteFile(g.RP().cachePath + "eggresult.rep");
                        } catch (Exception e) {
                            ab.e("MicroMsg.PostTaskReportEgg", "exception:%s", bo.l(e));
                        }
                        if (!linkedList.isEmpty()) {
                            bv.b(linkedList);
                            g.RP().Ry().set(68097, Long.valueOf(bo.anT()));
                        }
                    }
                }
                ab.d("MicroMsg.PostTaskReportEgg", "report egg done");
                AppMethodBeat.o(78502);
                return false;
            }
        }
        i = 0;
        if (i != 0) {
        }
        ab.d("MicroMsg.PostTaskReportEgg", "report egg done");
        AppMethodBeat.o(78502);
        return false;
    }
}
