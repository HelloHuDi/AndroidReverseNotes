package com.tencent.p177mm.openim.p1211c.p1212a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p200ay.C1304a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;
import java.util.Map;

/* renamed from: com.tencent.mm.openim.c.a.c */
public final class C18735c extends C1304a {
    public String gfv = null;
    public String gfw = null;

    public C18735c(Map<String, String> map, C7620bi c7620bi) {
        super(map, c7620bi);
    }

    /* renamed from: Yt */
    public final boolean mo4614Yt() {
        AppMethodBeat.m2504i(78920);
        if (this.values == null) {
            C4990ab.m7412e("MicroMsg.OpenIMChatRoomAddChatRoomMemberApprovedNewXmlMsg", "[parseXml] values == null ");
            AppMethodBeat.m2505o(78920);
            return false;
        }
        C4990ab.m7417i("MicroMsg.OpenIMChatRoomAddChatRoomMemberApprovedNewXmlMsg", "[parseXml] type:%s, values size:%s", C5046bo.nullAsNil(this.TYPE), Integer.valueOf(this.values.size()));
        if (C5046bo.isNullOrNil(this.TYPE) || !this.TYPE.equalsIgnoreCase("NewXmlOpenIMChatRoomAddChatRoomMemberApplicationApproved")) {
            C4990ab.m7413e("MicroMsg.OpenIMChatRoomAddChatRoomMemberApprovedNewXmlMsg", "[parseXml] type err :%s", C5046bo.nullAsNil(this.TYPE));
            AppMethodBeat.m2505o(78920);
            return false;
        }
        String str = ".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplicationApproved.approver_username";
        String str2 = ".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplicationApproved.application_climsgid";
        if (this.values.containsKey(str)) {
            this.gfv = C5046bo.nullAsNil((String) this.values.get(str));
        }
        if (this.values.containsKey(str2)) {
            this.gfw = C5046bo.nullAsNil((String) this.values.get(str2));
        }
        AppMethodBeat.m2505o(78920);
        return true;
    }
}
