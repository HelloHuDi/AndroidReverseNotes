package com.tencent.p177mm.plugin.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1201e;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p183ai.C1201e.C1198b;
import com.tencent.p177mm.p183ai.C1201e.C1199c;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.protocal.protobuf.C7254cm;
import com.tencent.p177mm.protocal.protobuf.cgm;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.storage.C7616ad;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.talkroom.model.d */
public final class C13933d implements C1201e {
    /* renamed from: b */
    public final C1198b mo4453b(C1197a c1197a) {
        int i = 1;
        AppMethodBeat.m2504i(25774);
        C7254cm c7254cm = c1197a.eAB;
        if (c7254cm == null) {
            C4990ab.m7412e("MicroMsg.TalkRoomExtension", "onPreAddMessage cmdAM is null");
            AppMethodBeat.m2505o(25774);
        } else if (c7254cm.nao != 56) {
            C4990ab.m7413e("MicroMsg.TalkRoomExtension", "onPreAddMessage cmdAM.type:%d", Integer.valueOf(c7254cm.nao));
            AppMethodBeat.m2505o(25774);
        } else {
            String a = C1946aa.m4148a(c7254cm.vEB);
            String a2 = C1946aa.m4148a(c7254cm.vEC);
            C9638aw.m17190ZK();
            if (!((String) C18628c.m29072Ry().get(2, null)).equals(a)) {
                a2 = a;
            }
            C9638aw.m17190ZK();
            C7616ad aoO = C18628c.m29078XM().aoO(a2);
            if (aoO == null || ((int) aoO.ewQ) == 0) {
                C9638aw.m17190ZK();
                C18628c.m29078XM().mo15702Z(new C7616ad(a2));
            }
            String a3 = C1946aa.m4148a(c7254cm.vED);
            C4990ab.m7410d("MicroMsg.TalkRoomExtension", "talkroom xml:".concat(String.valueOf(a3)));
            Map z = C5049br.m7595z(a3, "talkroominfo");
            if (z != null) {
                try {
                    int i2;
                    String str;
                    String ch;
                    if (C13933d.abu((String) z.get(".talkroominfo.tracksysmsgtype")) == 0) {
                        C13933d.abu((String) z.get(".talkroominfo.sysmsgtype"));
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    LinkedList linkedList = new LinkedList();
                    C13933d.abu((String) z.get(".talkroominfo.membersize"));
                    int i3 = 0;
                    while (true) {
                        str = ".talkroominfo.memberlist.member" + (i3 == 0 ? "" : Integer.valueOf(i3));
                        a3 = (String) z.get(str + ".username");
                        if (C5046bo.isNullOrNil(a3)) {
                            break;
                        }
                        int abu = C13933d.abu((String) z.get(str + ".memberid"));
                        cgm cgm = new cgm();
                        cgm.jBB = a3;
                        cgm.xft = abu;
                        linkedList.add(cgm);
                        i3++;
                    }
                    if (a2.equals(C39952b.cEh().syD)) {
                        str = C13933d.m22083cg(linkedList);
                        ch = C5046bo.isNullOrNil(str) ? C13933d.m22084ch(linkedList) : null;
                    } else {
                        ch = null;
                        str = null;
                    }
                    C29419e cEi = C39952b.cEi();
                    if (i2 != 0) {
                        i = 0;
                    }
                    cEi.mo4621a(a2, linkedList, str, ch, i);
                    AppMethodBeat.m2505o(25774);
                } catch (Exception e) {
                    C4990ab.m7412e("MicroMsg.TalkRoomExtension", "parsing memList xml failed");
                    C4990ab.printErrStackTrace("MicroMsg.TalkRoomExtension", e, "", new Object[0]);
                }
            }
            AppMethodBeat.m2505o(25774);
        }
        return null;
    }

    /* renamed from: a */
    public final void mo4452a(C1199c c1199c) {
    }

    private static int abu(String str) {
        int i = 0;
        AppMethodBeat.m2504i(25775);
        if (!C5046bo.isNullOrNil(str)) {
            try {
                i = Integer.valueOf(str).intValue();
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.TalkRoomExtension", e, "", new Object[i]);
            }
        }
        AppMethodBeat.m2505o(25775);
        return i;
    }

    /* renamed from: cg */
    private static String m22083cg(List<cgm> list) {
        AppMethodBeat.m2504i(25776);
        List<cgm> bJF = C39952b.cEh().bJF();
        LinkedList linkedList = new LinkedList();
        for (cgm cgm : list) {
            Object obj;
            for (cgm cgm2 : bJF) {
                if (cgm2.jBB.equals(cgm.jBB)) {
                    obj = 1;
                    break;
                }
            }
            obj = null;
            if (obj == null) {
                linkedList.add(cgm.jBB);
            }
        }
        if (linkedList.isEmpty()) {
            AppMethodBeat.m2505o(25776);
            return null;
        }
        int i = 0;
        while (i < linkedList.size()) {
            String str = (String) linkedList.get(i);
            if (str.equals(C1853r.m3846Yz())) {
                i++;
            } else {
                AppMethodBeat.m2505o(25776);
                return str;
            }
        }
        AppMethodBeat.m2505o(25776);
        return null;
    }

    /* renamed from: ch */
    private static String m22084ch(List<cgm> list) {
        AppMethodBeat.m2504i(25777);
        List<cgm> bJF = C39952b.cEh().bJF();
        LinkedList linkedList = new LinkedList();
        for (cgm cgm : bJF) {
            Object obj;
            for (cgm cgm2 : list) {
                if (cgm2.jBB.equals(cgm.jBB)) {
                    obj = 1;
                    break;
                }
            }
            obj = null;
            if (obj == null) {
                linkedList.add(cgm.jBB);
            }
        }
        if (linkedList.isEmpty()) {
            AppMethodBeat.m2505o(25777);
            return null;
        }
        int i = 0;
        while (i < linkedList.size()) {
            String str = (String) linkedList.get(i);
            if (str.equals(C1853r.m3846Yz())) {
                i++;
            } else {
                AppMethodBeat.m2505o(25777);
                return str;
            }
        }
        AppMethodBeat.m2505o(25777);
        return null;
    }
}
