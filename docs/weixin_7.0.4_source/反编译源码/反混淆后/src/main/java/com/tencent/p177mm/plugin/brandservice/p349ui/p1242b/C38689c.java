package com.tencent.p177mm.plugin.brandservice.p349ui.p1242b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p181af.C32223o;
import com.tencent.p177mm.p181af.C32224p;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p198aw.C37494a;
import com.tencent.p177mm.p198aw.C9058e;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.plugin.biz.p1395a.C27500a;
import com.tencent.p177mm.plugin.brandservice.C33720b;
import com.tencent.p177mm.plugin.brandservice.p926b.C42796l;
import com.tencent.p177mm.protocal.protobuf.C35930jy;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C40635r;
import com.tencent.p177mm.storage.C46627q;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.brandservice.ui.b.c */
public final class C38689c {
    private static Map<Long, Integer> jZe = new HashMap();

    static {
        AppMethodBeat.m2504i(14458);
        AppMethodBeat.m2505o(14458);
    }

    public static String aYR() {
        AppMethodBeat.m2504i(14452);
        String str = null;
        C9058e aih = C37494a.aih();
        if (aih != null && aih.fJU != null && aih.fJS == 0 && C37494a.aie()) {
            str = aih.fJU;
        }
        AppMethodBeat.m2505o(14452);
        return str;
    }

    /* renamed from: sH */
    public static boolean m65628sH(int i) {
        AppMethodBeat.m2504i(14453);
        if ((System.currentTimeMillis() / 1000) - ((long) i) > ((long) C42808a.jYZ)) {
            AppMethodBeat.m2505o(14453);
            return true;
        }
        AppMethodBeat.m2505o(14453);
        return false;
    }

    /* renamed from: f */
    public static void m65627f(final C46627q c46627q) {
        AppMethodBeat.m2504i(14454);
        if (c46627q == null || !c46627q.drC()) {
            AppMethodBeat.m2505o(14454);
            return;
        }
        C33720b.m55105a("BrandServiceWorkerThread", new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(14450);
                if (!C38689c.jZe.containsKey(Long.valueOf(c46627q.field_msgId)) || C38689c.m65628sH(((Integer) C38689c.jZe.get(Long.valueOf(c46627q.field_msgId))).intValue())) {
                    List ah = C41747z.aeX().mo64102ah(5, c46627q.field_orderFlag);
                    C40635r aeX = C41747z.aeX();
                    long j = c46627q.field_orderFlag;
                    List p = C40635r.m70177p(aeX.fni.query("BizTimeLineInfo", null, "orderFlag>?", new String[]{String.valueOf(j)}, null, null, "orderFlag DESC limit 5"));
                    LinkedList linkedList = new LinkedList();
                    linkedList.addAll(ah);
                    linkedList.add(c46627q);
                    linkedList.addAll(p);
                    C38689c.m65626bc(linkedList);
                    AppMethodBeat.m2505o(14450);
                    return;
                }
                AppMethodBeat.m2505o(14450);
            }
        }, 0);
        AppMethodBeat.m2505o(14454);
    }

    /* renamed from: bc */
    public static void m65626bc(List<C46627q> list) {
        AppMethodBeat.m2504i(14455);
        if (C5046bo.m7548ek(list)) {
            AppMethodBeat.m2505o(14455);
            return;
        }
        LinkedList linkedList = new LinkedList();
        for (C46627q c46627q : list) {
            if ((!jZe.containsKey(Long.valueOf(c46627q.field_msgId)) || C38689c.m65628sH(((Integer) jZe.get(Long.valueOf(c46627q.field_msgId))).intValue())) && c46627q.drC()) {
                C32223o b = ((C27500a) C1720g.m3528K(C27500a.class)).mo35246b(c46627q.field_msgId, c46627q.field_content);
                if (!(b == null || C5046bo.m7548ek(b.fjr))) {
                    try {
                        Iterator it = b.fjr.iterator();
                        while (it.hasNext()) {
                            C32224p c32224p = (C32224p) it.next();
                            C35930jy c35930jy = new C35930jy();
                            c35930jy.vGE = c46627q.field_talker;
                            c35930jy.vGH = c46627q.field_msgId;
                            if (!C5046bo.isNullOrNil(c32224p.url)) {
                                c35930jy.url = c32224p.url;
                                linkedList.add(c35930jy);
                                jZe.put(Long.valueOf(c46627q.field_msgId), Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
                            }
                        }
                    } catch (UnsupportedOperationException e) {
                        C4990ab.m7421w("MicroMsg.ConversationAdapter", "postDoGetCommentReward exp %s", e.getMessage());
                    } catch (Exception e2) {
                        C4990ab.m7421w("MicroMsg.ConversationAdapter", "postDoGetCommentReward exp %s", e2.getMessage());
                    }
                }
            }
        }
        if (C5046bo.m7548ek(linkedList)) {
            AppMethodBeat.m2505o(14455);
            return;
        }
        C1720g.m3535RO().eJo.mo14541a(new C42796l(linkedList), 0);
        AppMethodBeat.m2505o(14455);
    }

    /* renamed from: aX */
    public static void m65624aX(final List<C46627q> list) {
        AppMethodBeat.m2504i(14456);
        C33720b.m55105a("BrandServiceWorkerThread", new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(14451);
                for (C46627q c46627q : list) {
                    if (c46627q.drC()) {
                        ((C27500a) C1720g.m3528K(C27500a.class)).mo35246b(c46627q.field_msgId, c46627q.field_content);
                    }
                }
                AppMethodBeat.m2505o(14451);
            }
        }, 0);
        AppMethodBeat.m2505o(14456);
    }

    /* renamed from: b */
    public static boolean m65625b(C1331a c1331a, C1331a c1331a2) {
        int i = 1;
        AppMethodBeat.m2504i(14457);
        if (c1331a == null && c1331a2 == null) {
            AppMethodBeat.m2505o(14457);
            return i;
        } else if (c1331a == null || c1331a2 == null) {
            AppMethodBeat.m2505o(14457);
            return 0;
        } else {
            try {
                i = C5046bo.isEqual(c1331a.toByteArray(), c1331a2.toByteArray());
                AppMethodBeat.m2505o(14457);
                return i;
            } catch (IOException e) {
                Object[] objArr = new Object[i];
                objArr[0] = e.getMessage();
                C4990ab.m7417i("MicroMsg.ConversationAdapter", "isMsgStatInfoProtoEqual exp %s", objArr);
                AppMethodBeat.m2505o(14457);
                return 0;
            }
        }
    }
}
