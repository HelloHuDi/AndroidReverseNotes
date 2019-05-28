package com.tencent.p177mm.openim.p1211c.p1212a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C37440a;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C15341fp;
import com.tencent.p177mm.protocal.protobuf.C30184fo;
import com.tencent.p177mm.protocal.protobuf.bgc;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.openim.c.a.a */
public final class C42241a extends C37440a<C15341fp> {
    public C42241a(String str, String str2, String str3, LinkedList<String> linkedList) {
        AppMethodBeat.m2504i(78917);
        C4990ab.m7411d("MicroMsg.CgiOpenImApproveAddRoomMember", "CgiOpenImApproveAddRoomMember() inviterusername%s, roomname:%s, ticket:%s, username:%s", str, str2, C5046bo.anv(str3), linkedList);
        C30184fo c30184fo = new C30184fo();
        c30184fo.cxb = str3;
        c30184fo.geY = str2;
        bgc bgc = new bgc();
        bgc.userName = str;
        c30184fo.vHx = bgc;
        LinkedList linkedList2 = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            String str4 = (String) it.next();
            bgc bgc2 = new bgc();
            bgc2.userName = str4;
            linkedList2.add(bgc2);
        }
        c30184fo.vHy = linkedList2;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = c30184fo;
        c1196a.fsK = new C15341fp();
        c1196a.uri = "/cgi-bin/micromsg-bin/approveaddopenimchatroommember";
        c1196a.fsI = 941;
        this.ehh = c1196a.acD();
        AppMethodBeat.m2505o(78917);
    }
}
