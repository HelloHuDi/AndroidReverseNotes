package com.tencent.p177mm.chatroom.p710c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C37440a;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C35960vh;
import com.tencent.p177mm.protocal.protobuf.C35961vi;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.view.C31128d;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.chatroom.c.d */
public final class C41206d extends C37440a<C35961vi> {
    public C41206d(String str, LinkedList<String> linkedList) {
        AppMethodBeat.m2504i(103909);
        C4990ab.m7411d("MicroMsg.CgiAddChatRoomAdmin", "roomName:%s,username:%s", str, C5046bo.m7536c((List) linkedList, ";"));
        C35960vh c35960vh = new C35960vh();
        c35960vh.vEf = str;
        c35960vh.vEg = linkedList;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = c35960vh;
        c1196a.fsK = new C35961vi();
        c1196a.uri = "/cgi-bin/micromsg-bin/delchatroomadmin";
        c1196a.fsI = C31128d.MIC_PTU_ZIPAI_MEDSEA;
        this.ehh = c1196a.acD();
        AppMethodBeat.m2505o(103909);
    }
}
