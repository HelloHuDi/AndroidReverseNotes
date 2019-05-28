package com.tencent.mm.plugin.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.ai.e.b;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.cgm;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ad;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class d implements e {
    public final b b(a aVar) {
        int i = 1;
        AppMethodBeat.i(25774);
        cm cmVar = aVar.eAB;
        if (cmVar == null) {
            ab.e("MicroMsg.TalkRoomExtension", "onPreAddMessage cmdAM is null");
            AppMethodBeat.o(25774);
        } else if (cmVar.nao != 56) {
            ab.e("MicroMsg.TalkRoomExtension", "onPreAddMessage cmdAM.type:%d", Integer.valueOf(cmVar.nao));
            AppMethodBeat.o(25774);
        } else {
            String a = aa.a(cmVar.vEB);
            String a2 = aa.a(cmVar.vEC);
            aw.ZK();
            if (!((String) c.Ry().get(2, null)).equals(a)) {
                a2 = a;
            }
            aw.ZK();
            ad aoO = c.XM().aoO(a2);
            if (aoO == null || ((int) aoO.ewQ) == 0) {
                aw.ZK();
                c.XM().Z(new ad(a2));
            }
            String a3 = aa.a(cmVar.vED);
            ab.d("MicroMsg.TalkRoomExtension", "talkroom xml:".concat(String.valueOf(a3)));
            Map z = br.z(a3, "talkroominfo");
            if (z != null) {
                try {
                    int i2;
                    String str;
                    String ch;
                    if (abu((String) z.get(".talkroominfo.tracksysmsgtype")) == 0) {
                        abu((String) z.get(".talkroominfo.sysmsgtype"));
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    LinkedList linkedList = new LinkedList();
                    abu((String) z.get(".talkroominfo.membersize"));
                    int i3 = 0;
                    while (true) {
                        str = ".talkroominfo.memberlist.member" + (i3 == 0 ? "" : Integer.valueOf(i3));
                        a3 = (String) z.get(str + ".username");
                        if (bo.isNullOrNil(a3)) {
                            break;
                        }
                        int abu = abu((String) z.get(str + ".memberid"));
                        cgm cgm = new cgm();
                        cgm.jBB = a3;
                        cgm.xft = abu;
                        linkedList.add(cgm);
                        i3++;
                    }
                    if (a2.equals(b.cEh().syD)) {
                        str = cg(linkedList);
                        ch = bo.isNullOrNil(str) ? ch(linkedList) : null;
                    } else {
                        ch = null;
                        str = null;
                    }
                    e cEi = b.cEi();
                    if (i2 != 0) {
                        i = 0;
                    }
                    cEi.a(a2, linkedList, str, ch, i);
                    AppMethodBeat.o(25774);
                } catch (Exception e) {
                    ab.e("MicroMsg.TalkRoomExtension", "parsing memList xml failed");
                    ab.printErrStackTrace("MicroMsg.TalkRoomExtension", e, "", new Object[0]);
                }
            }
            AppMethodBeat.o(25774);
        }
        return null;
    }

    public final void a(e.c cVar) {
    }

    private static int abu(String str) {
        int i = 0;
        AppMethodBeat.i(25775);
        if (!bo.isNullOrNil(str)) {
            try {
                i = Integer.valueOf(str).intValue();
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.TalkRoomExtension", e, "", new Object[i]);
            }
        }
        AppMethodBeat.o(25775);
        return i;
    }

    private static String cg(List<cgm> list) {
        AppMethodBeat.i(25776);
        List<cgm> bJF = b.cEh().bJF();
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
            AppMethodBeat.o(25776);
            return null;
        }
        int i = 0;
        while (i < linkedList.size()) {
            String str = (String) linkedList.get(i);
            if (str.equals(r.Yz())) {
                i++;
            } else {
                AppMethodBeat.o(25776);
                return str;
            }
        }
        AppMethodBeat.o(25776);
        return null;
    }

    private static String ch(List<cgm> list) {
        AppMethodBeat.i(25777);
        List<cgm> bJF = b.cEh().bJF();
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
            AppMethodBeat.o(25777);
            return null;
        }
        int i = 0;
        while (i < linkedList.size()) {
            String str = (String) linkedList.get(i);
            if (str.equals(r.Yz())) {
                i++;
            } else {
                AppMethodBeat.o(25777);
                return str;
            }
        }
        AppMethodBeat.o(25777);
        return null;
    }
}
