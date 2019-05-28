package com.tencent.mm.plugin.brandservice.ui.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.o;
import com.tencent.mm.af.p;
import com.tencent.mm.aj.z;
import com.tencent.mm.aw.a;
import com.tencent.mm.aw.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.b;
import com.tencent.mm.plugin.brandservice.b.l;
import com.tencent.mm.protocal.protobuf.jy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.r;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class c {
    private static Map<Long, Integer> jZe = new HashMap();

    static {
        AppMethodBeat.i(14458);
        AppMethodBeat.o(14458);
    }

    public static String aYR() {
        AppMethodBeat.i(14452);
        String str = null;
        e aih = a.aih();
        if (aih != null && aih.fJU != null && aih.fJS == 0 && a.aie()) {
            str = aih.fJU;
        }
        AppMethodBeat.o(14452);
        return str;
    }

    public static boolean sH(int i) {
        AppMethodBeat.i(14453);
        if ((System.currentTimeMillis() / 1000) - ((long) i) > ((long) a.jYZ)) {
            AppMethodBeat.o(14453);
            return true;
        }
        AppMethodBeat.o(14453);
        return false;
    }

    public static void f(final q qVar) {
        AppMethodBeat.i(14454);
        if (qVar == null || !qVar.drC()) {
            AppMethodBeat.o(14454);
            return;
        }
        b.a("BrandServiceWorkerThread", new Runnable() {
            public final void run() {
                AppMethodBeat.i(14450);
                if (!c.jZe.containsKey(Long.valueOf(qVar.field_msgId)) || c.sH(((Integer) c.jZe.get(Long.valueOf(qVar.field_msgId))).intValue())) {
                    List ah = z.aeX().ah(5, qVar.field_orderFlag);
                    r aeX = z.aeX();
                    long j = qVar.field_orderFlag;
                    List p = r.p(aeX.fni.query("BizTimeLineInfo", null, "orderFlag>?", new String[]{String.valueOf(j)}, null, null, "orderFlag DESC limit 5"));
                    LinkedList linkedList = new LinkedList();
                    linkedList.addAll(ah);
                    linkedList.add(qVar);
                    linkedList.addAll(p);
                    c.bc(linkedList);
                    AppMethodBeat.o(14450);
                    return;
                }
                AppMethodBeat.o(14450);
            }
        }, 0);
        AppMethodBeat.o(14454);
    }

    public static void bc(List<q> list) {
        AppMethodBeat.i(14455);
        if (bo.ek(list)) {
            AppMethodBeat.o(14455);
            return;
        }
        LinkedList linkedList = new LinkedList();
        for (q qVar : list) {
            if ((!jZe.containsKey(Long.valueOf(qVar.field_msgId)) || sH(((Integer) jZe.get(Long.valueOf(qVar.field_msgId))).intValue())) && qVar.drC()) {
                o b = ((com.tencent.mm.plugin.biz.a.a) g.K(com.tencent.mm.plugin.biz.a.a.class)).b(qVar.field_msgId, qVar.field_content);
                if (!(b == null || bo.ek(b.fjr))) {
                    try {
                        Iterator it = b.fjr.iterator();
                        while (it.hasNext()) {
                            p pVar = (p) it.next();
                            jy jyVar = new jy();
                            jyVar.vGE = qVar.field_talker;
                            jyVar.vGH = qVar.field_msgId;
                            if (!bo.isNullOrNil(pVar.url)) {
                                jyVar.url = pVar.url;
                                linkedList.add(jyVar);
                                jZe.put(Long.valueOf(qVar.field_msgId), Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
                            }
                        }
                    } catch (UnsupportedOperationException e) {
                        ab.w("MicroMsg.ConversationAdapter", "postDoGetCommentReward exp %s", e.getMessage());
                    } catch (Exception e2) {
                        ab.w("MicroMsg.ConversationAdapter", "postDoGetCommentReward exp %s", e2.getMessage());
                    }
                }
            }
        }
        if (bo.ek(linkedList)) {
            AppMethodBeat.o(14455);
            return;
        }
        g.RO().eJo.a(new l(linkedList), 0);
        AppMethodBeat.o(14455);
    }

    public static void aX(final List<q> list) {
        AppMethodBeat.i(14456);
        b.a("BrandServiceWorkerThread", new Runnable() {
            public final void run() {
                AppMethodBeat.i(14451);
                for (q qVar : list) {
                    if (qVar.drC()) {
                        ((com.tencent.mm.plugin.biz.a.a) g.K(com.tencent.mm.plugin.biz.a.a.class)).b(qVar.field_msgId, qVar.field_content);
                    }
                }
                AppMethodBeat.o(14451);
            }
        }, 0);
        AppMethodBeat.o(14456);
    }

    public static boolean b(com.tencent.mm.bt.a aVar, com.tencent.mm.bt.a aVar2) {
        int i = 1;
        AppMethodBeat.i(14457);
        if (aVar == null && aVar2 == null) {
            AppMethodBeat.o(14457);
            return i;
        } else if (aVar == null || aVar2 == null) {
            AppMethodBeat.o(14457);
            return 0;
        } else {
            try {
                i = bo.isEqual(aVar.toByteArray(), aVar2.toByteArray());
                AppMethodBeat.o(14457);
                return i;
            } catch (IOException e) {
                Object[] objArr = new Object[i];
                objArr[0] = e.getMessage();
                ab.i("MicroMsg.ConversationAdapter", "isMsgStatInfoProtoEqual exp %s", objArr);
                AppMethodBeat.o(14457);
                return 0;
            }
        }
    }
}
