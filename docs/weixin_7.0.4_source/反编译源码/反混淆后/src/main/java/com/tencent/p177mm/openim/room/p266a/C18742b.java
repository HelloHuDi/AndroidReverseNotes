package com.tencent.p177mm.openim.room.p266a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.protobuf.C7281qf;
import com.tencent.p177mm.protocal.protobuf.bgc;
import com.tencent.p177mm.protocal.protobuf.bgd;
import com.tencent.p177mm.protocal.protobuf.bge;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7616ad;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.openim.room.a.b */
public interface C18742b {

    /* renamed from: com.tencent.mm.openim.room.a.b$c */
    public static class C1938c {
        /* renamed from: a */
        public static C7616ad m4137a(C7616ad c7616ad, bgd bgd) {
            AppMethodBeat.m2504i(78978);
            c7616ad.setUsername(bgd.userName);
            c7616ad.mo14703iB(bgd.bCu);
            AppMethodBeat.m2505o(78978);
            return c7616ad;
        }

        /* renamed from: ao */
        public static LinkedList<C7281qf> m4138ao(List<bge> list) {
            AppMethodBeat.m2504i(78979);
            LinkedList<C7281qf> linkedList = new LinkedList();
            if (list == null) {
                AppMethodBeat.m2505o(78979);
                return linkedList;
            }
            for (bge bge : list) {
                C7281qf c7281qf = new C7281qf();
                c7281qf.jBB = bge.userName;
                c7281qf.jCH = bge.bCu;
                c7281qf.vXl = bge.eoz;
                c7281qf.vXm = bge.wcj;
                c7281qf.vXn = bge.wck;
                c7281qf.vXo = bge.wKg;
                c7281qf.vXp = bge.wKi;
                linkedList.add(c7281qf);
            }
            AppMethodBeat.m2505o(78979);
            return linkedList;
        }
    }

    /* renamed from: com.tencent.mm.openim.room.a.b$a */
    public static class C9777a {
        /* renamed from: an */
        public static LinkedList<bgc> m17415an(List<String> list) {
            AppMethodBeat.m2504i(78975);
            LinkedList linkedList = new LinkedList();
            for (String str : list) {
                bgc bgc = new bgc();
                bgc.userName = str;
                linkedList.add(bgc);
            }
            AppMethodBeat.m2505o(78975);
            return linkedList;
        }
    }

    /* renamed from: com.tencent.mm.openim.room.a.b$b */
    public static class C9778b {
        public final List<String> cGa = new ArrayList();
        public final List<String> cGc = new ArrayList();
        public final List<String> cGd = new ArrayList();
        public final List<String> ehj = new ArrayList();
        public final List<String> ehk = new ArrayList();
        public final List<String> ehl = new ArrayList();

        public C9778b() {
            AppMethodBeat.m2504i(78976);
            AppMethodBeat.m2505o(78976);
        }

        /* renamed from: q */
        public final void mo21130q(LinkedList<bgd> linkedList) {
            AppMethodBeat.m2504i(78977);
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                bgd bgd = (bgd) it.next();
                int i = bgd.status;
                if (i == 0) {
                    this.ehj.add(bgd.userName);
                } else if (i == 3) {
                    C4990ab.m7410d("OpenIMChatRoomMember.Classifier", " blacklist : " + bgd.userName);
                    this.ehk.add(bgd.userName);
                } else if (i == 1) {
                    C4990ab.m7410d("OpenIMChatRoomMember.Classifier", " not user : " + bgd.userName);
                    this.cGc.add(bgd.userName);
                } else if (i == 2) {
                    C4990ab.m7410d("OpenIMChatRoomMember.Classifier", " invalid username : " + bgd.userName);
                    this.cGa.add(bgd.userName);
                } else if (i == 4) {
                    C4990ab.m7410d("OpenIMChatRoomMember.Classifier", " verify user : " + bgd.userName);
                    this.cGd.add(bgd.userName);
                } else if (i != 5) {
                    if (i == 6) {
                        this.ehl.add(bgd.userName);
                    } else {
                        C4990ab.m7420w("OpenIMChatRoomMember.Classifier", "unknown member status : status = ".concat(String.valueOf(i)));
                    }
                }
            }
            AppMethodBeat.m2505o(78977);
        }
    }
}
