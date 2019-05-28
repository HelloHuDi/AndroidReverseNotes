package com.tencent.mm.openim.room.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bgc;
import com.tencent.mm.protocal.protobuf.bgd;
import com.tencent.mm.protocal.protobuf.bge;
import com.tencent.mm.protocal.protobuf.qf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public interface b {

    public static class c {
        public static ad a(ad adVar, bgd bgd) {
            AppMethodBeat.i(78978);
            adVar.setUsername(bgd.userName);
            adVar.iB(bgd.bCu);
            AppMethodBeat.o(78978);
            return adVar;
        }

        public static LinkedList<qf> ao(List<bge> list) {
            AppMethodBeat.i(78979);
            LinkedList<qf> linkedList = new LinkedList();
            if (list == null) {
                AppMethodBeat.o(78979);
                return linkedList;
            }
            for (bge bge : list) {
                qf qfVar = new qf();
                qfVar.jBB = bge.userName;
                qfVar.jCH = bge.bCu;
                qfVar.vXl = bge.eoz;
                qfVar.vXm = bge.wcj;
                qfVar.vXn = bge.wck;
                qfVar.vXo = bge.wKg;
                qfVar.vXp = bge.wKi;
                linkedList.add(qfVar);
            }
            AppMethodBeat.o(78979);
            return linkedList;
        }
    }

    public static class a {
        public static LinkedList<bgc> an(List<String> list) {
            AppMethodBeat.i(78975);
            LinkedList linkedList = new LinkedList();
            for (String str : list) {
                bgc bgc = new bgc();
                bgc.userName = str;
                linkedList.add(bgc);
            }
            AppMethodBeat.o(78975);
            return linkedList;
        }
    }

    public static class b {
        public final List<String> cGa = new ArrayList();
        public final List<String> cGc = new ArrayList();
        public final List<String> cGd = new ArrayList();
        public final List<String> ehj = new ArrayList();
        public final List<String> ehk = new ArrayList();
        public final List<String> ehl = new ArrayList();

        public b() {
            AppMethodBeat.i(78976);
            AppMethodBeat.o(78976);
        }

        public final void q(LinkedList<bgd> linkedList) {
            AppMethodBeat.i(78977);
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                bgd bgd = (bgd) it.next();
                int i = bgd.status;
                if (i == 0) {
                    this.ehj.add(bgd.userName);
                } else if (i == 3) {
                    ab.d("OpenIMChatRoomMember.Classifier", " blacklist : " + bgd.userName);
                    this.ehk.add(bgd.userName);
                } else if (i == 1) {
                    ab.d("OpenIMChatRoomMember.Classifier", " not user : " + bgd.userName);
                    this.cGc.add(bgd.userName);
                } else if (i == 2) {
                    ab.d("OpenIMChatRoomMember.Classifier", " invalid username : " + bgd.userName);
                    this.cGa.add(bgd.userName);
                } else if (i == 4) {
                    ab.d("OpenIMChatRoomMember.Classifier", " verify user : " + bgd.userName);
                    this.cGd.add(bgd.userName);
                } else if (i != 5) {
                    if (i == 6) {
                        this.ehl.add(bgd.userName);
                    } else {
                        ab.w("OpenIMChatRoomMember.Classifier", "unknown member status : status = ".concat(String.valueOf(i)));
                    }
                }
            }
            AppMethodBeat.o(78977);
        }
    }
}
