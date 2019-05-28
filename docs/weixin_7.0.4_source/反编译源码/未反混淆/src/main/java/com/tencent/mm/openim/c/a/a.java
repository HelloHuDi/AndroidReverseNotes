package com.tencent.mm.openim.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bgc;
import com.tencent.mm.protocal.protobuf.fo;
import com.tencent.mm.protocal.protobuf.fp;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;

public final class a extends com.tencent.mm.ai.a<fp> {
    public a(String str, String str2, String str3, LinkedList<String> linkedList) {
        AppMethodBeat.i(78917);
        ab.d("MicroMsg.CgiOpenImApproveAddRoomMember", "CgiOpenImApproveAddRoomMember() inviterusername%s, roomname:%s, ticket:%s, username:%s", str, str2, bo.anv(str3), linkedList);
        fo foVar = new fo();
        foVar.cxb = str3;
        foVar.geY = str2;
        bgc bgc = new bgc();
        bgc.userName = str;
        foVar.vHx = bgc;
        LinkedList linkedList2 = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            String str4 = (String) it.next();
            bgc bgc2 = new bgc();
            bgc2.userName = str4;
            linkedList2.add(bgc2);
        }
        foVar.vHy = linkedList2;
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = foVar;
        aVar.fsK = new fp();
        aVar.uri = "/cgi-bin/micromsg-bin/approveaddopenimchatroommember";
        aVar.fsI = 941;
        this.ehh = aVar.acD();
        AppMethodBeat.o(78917);
    }
}
