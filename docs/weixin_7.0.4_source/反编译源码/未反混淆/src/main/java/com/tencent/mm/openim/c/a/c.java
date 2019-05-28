package com.tencent.mm.openim.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.util.Map;

public final class c extends a {
    public String gfv = null;
    public String gfw = null;

    public c(Map<String, String> map, bi biVar) {
        super(map, biVar);
    }

    public final boolean Yt() {
        AppMethodBeat.i(78920);
        if (this.values == null) {
            ab.e("MicroMsg.OpenIMChatRoomAddChatRoomMemberApprovedNewXmlMsg", "[parseXml] values == null ");
            AppMethodBeat.o(78920);
            return false;
        }
        ab.i("MicroMsg.OpenIMChatRoomAddChatRoomMemberApprovedNewXmlMsg", "[parseXml] type:%s, values size:%s", bo.nullAsNil(this.TYPE), Integer.valueOf(this.values.size()));
        if (bo.isNullOrNil(this.TYPE) || !this.TYPE.equalsIgnoreCase("NewXmlOpenIMChatRoomAddChatRoomMemberApplicationApproved")) {
            ab.e("MicroMsg.OpenIMChatRoomAddChatRoomMemberApprovedNewXmlMsg", "[parseXml] type err :%s", bo.nullAsNil(this.TYPE));
            AppMethodBeat.o(78920);
            return false;
        }
        String str = ".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplicationApproved.approver_username";
        String str2 = ".sysmsg.NewXmlOpenIMChatRoomAddChatRoomMemberApplicationApproved.application_climsgid";
        if (this.values.containsKey(str)) {
            this.gfv = bo.nullAsNil((String) this.values.get(str));
        }
        if (this.values.containsKey(str2)) {
            this.gfw = bo.nullAsNil((String) this.values.get(str2));
        }
        AppMethodBeat.o(78920);
        return true;
    }
}
