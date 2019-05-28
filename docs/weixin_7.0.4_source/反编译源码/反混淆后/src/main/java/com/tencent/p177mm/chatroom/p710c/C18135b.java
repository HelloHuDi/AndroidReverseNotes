package com.tencent.p177mm.chatroom.p710c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C37440a;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C7533by;
import com.tencent.p177mm.protocal.protobuf.C7534bz;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.chatroom.c.b */
public final class C18135b extends C37440a<C7534bz> {
    public C18135b(String str, LinkedList<String> linkedList) {
        AppMethodBeat.m2504i(103907);
        C4990ab.m7411d("MicroMsg.CgiAddChatRoomAdmin", "roomName:%s,username:%s", str, C5046bo.m7536c((List) linkedList, ";"));
        C7533by c7533by = new C7533by();
        c7533by.vEf = str;
        c7533by.vEg = linkedList;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = c7533by;
        c1196a.fsK = new C7534bz();
        c1196a.uri = "/cgi-bin/micromsg-bin/addchatroomadmin";
        this.ehh = c1196a.acD();
        AppMethodBeat.m2505o(103907);
    }
}
