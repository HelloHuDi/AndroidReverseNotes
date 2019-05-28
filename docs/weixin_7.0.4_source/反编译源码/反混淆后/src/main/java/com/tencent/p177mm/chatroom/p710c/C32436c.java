package com.tencent.p177mm.chatroom.p710c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C37440a;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C15339fm;
import com.tencent.p177mm.protocal.protobuf.C15340fn;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.chatroom.c.c */
public final class C32436c extends C37440a<C15340fn> {
    public C32436c(long j, String str, String str2, String str3, LinkedList<String> linkedList) {
        AppMethodBeat.m2504i(103908);
        C4990ab.m7411d("MicroMsg.CgiApproveAddChatRoomMember", "inviterusername%s,roomname:%s,ticket:%s,username:%s approvenewmsgid:%s", str, str2, C5046bo.anv(str3), linkedList, Long.valueOf(j));
        C15339fm c15339fm = new C15339fm();
        c15339fm.fLi = str;
        c15339fm.geY = str2;
        c15339fm.cxb = str3;
        c15339fm.vHv = linkedList;
        c15339fm.vHw = j;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = c15339fm;
        c1196a.fsK = new C15340fn();
        c1196a.uri = "/cgi-bin/micromsg-bin/approveaddchatroommember";
        this.ehh = c1196a.acD();
        AppMethodBeat.m2505o(103908);
    }
}
