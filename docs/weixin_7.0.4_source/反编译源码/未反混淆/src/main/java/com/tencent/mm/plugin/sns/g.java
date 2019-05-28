package com.tencent.mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.h;
import com.tencent.mm.g.a.mp;
import com.tencent.mm.kernel.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public final class g extends c<mp> {
    public g() {
        AppMethodBeat.i(35620);
        this.xxI = mp.class.getName().hashCode();
        AppMethodBeat.o(35620);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0073  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ boolean a(b bVar) {
        AppMethodBeat.i(35621);
        if (!(((mp) bVar) instanceof mp)) {
            ab.f("MicroMsg.PostSnsAsyncTaskListener", "mismatched event");
            AppMethodBeat.o(35621);
            return false;
        } else if (af.cnn()) {
            AppMethodBeat.o(35621);
            return false;
        } else {
            int i;
            ab.d("MicroMsg.PostSnsAsyncTask", "check PostTaskSnsPost ");
            if (af.cnB() != null) {
                af.cnB().cmp();
            }
            ab.d("MicroMsg.PostSnsAsyncTask", "check AsyncQueue");
            if (af.cnv() != null) {
                af.cnE().cnf();
            }
            com.tencent.mm.kernel.g.RQ();
            if (com.tencent.mm.kernel.g.RN().QY()) {
                com.tencent.mm.kernel.g.RQ();
                com.tencent.mm.kernel.g.RN();
                if (!a.QT()) {
                    i = 1;
                    if (i != 0) {
                        com.tencent.mm.kernel.g.RQ();
                        if (bo.fp(bo.a((Long) com.tencent.mm.kernel.g.RP().Ry().get(68390, null), 0)) * 1000 > 3600000) {
                            i = 1;
                        } else {
                            i = 0;
                        }
                        if (i != 0) {
                            LinkedList linkedList = new LinkedList();
                            com.tencent.mm.kernel.g.RQ();
                            int a = bo.a((Integer) com.tencent.mm.kernel.g.RP().Ry().get(68388, null), 0);
                            com.tencent.mm.kernel.g.RQ();
                            i = bo.a((Integer) com.tencent.mm.kernel.g.RP().Ry().get(68389, null), 0);
                            if (a > 0 || i > 0) {
                                linkedList.add(new h.a(10077, a + "," + i));
                                com.tencent.mm.kernel.g.RQ();
                                com.tencent.mm.kernel.g.RP().Ry().set(68388, Integer.valueOf(0));
                                com.tencent.mm.kernel.g.RQ();
                                com.tencent.mm.kernel.g.RP().Ry().set(68389, Integer.valueOf(0));
                            }
                            com.tencent.mm.kernel.g.RQ();
                            i = bo.a((Integer) com.tencent.mm.kernel.g.RP().Ry().get(68391, null), 0);
                            if (i > 0) {
                                linkedList.add(new h.a(28, String.valueOf(i)));
                                com.tencent.mm.kernel.g.RQ();
                                com.tencent.mm.kernel.g.RP().Ry().set(68391, Integer.valueOf(0));
                            }
                            com.tencent.mm.kernel.g.RQ();
                            a = bo.a((Integer) com.tencent.mm.kernel.g.RP().Ry().get(68392, null), 0);
                            com.tencent.mm.kernel.g.RQ();
                            i = bo.a((Integer) com.tencent.mm.kernel.g.RP().Ry().get(68393, null), 0);
                            if (a > 0 || i > 0) {
                                linkedList.add(new h.a(10072, a + "," + i));
                                com.tencent.mm.kernel.g.RQ();
                                com.tencent.mm.kernel.g.RP().Ry().set(68392, Integer.valueOf(0));
                                com.tencent.mm.kernel.g.RQ();
                                com.tencent.mm.kernel.g.RP().Ry().set(68393, Integer.valueOf(0));
                            }
                            if (!linkedList.isEmpty()) {
                                com.tencent.mm.kernel.g.RQ();
                                ((j) com.tencent.mm.kernel.g.K(j.class)).XL().c(new h(linkedList));
                                com.tencent.mm.kernel.g.RQ();
                                com.tencent.mm.kernel.g.RP().Ry().set(68390, Long.valueOf(bo.anT()));
                            }
                        }
                    }
                    AppMethodBeat.o(35621);
                    return true;
                }
            }
            i = 0;
            if (i != 0) {
            }
            AppMethodBeat.o(35621);
            return true;
        }
    }
}
