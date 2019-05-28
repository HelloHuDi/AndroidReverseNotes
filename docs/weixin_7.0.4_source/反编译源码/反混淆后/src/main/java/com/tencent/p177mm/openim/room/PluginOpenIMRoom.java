package com.tencent.p177mm.openim.room;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1706e.C1705c;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.bucket.C9562c;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.openim.p1211c.C18736a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6983p;
import com.tencent.p177mm.roomsdk.p1086a.C30262b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.openim.room.PluginOpenIMRoom */
public class PluginOpenIMRoom extends C7597f implements C9562c {
    private C18736a gfN = new C18736a();

    public PluginOpenIMRoom() {
        AppMethodBeat.m2504i(78964);
        AppMethodBeat.m2505o(78964);
    }

    public void onAccountInitialized(C1705c c1705c) {
        AppMethodBeat.m2504i(78965);
        C4990ab.m7416i("MicroMsg.PluginOpenIMRoom", "onAccountInitialized");
        C30262b.m48141a("@im.chatroom", new C24675a());
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14902a("NewXmlOpenIMChatRoomAddChatRoomMemberApplication", this.gfN);
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14902a("NewXmlOpenIMChatRoomAddChatRoomMemberApplicationApproved", this.gfN);
        AppMethodBeat.m2505o(78965);
    }

    public void onAccountRelease() {
        AppMethodBeat.m2504i(78966);
        C4990ab.m7416i("MicroMsg.PluginOpenIMRoom", "onAccountRelease");
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14905b("NewXmlOpenIMChatRoomAddChatRoomMemberApplication", this.gfN);
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14905b("NewXmlOpenIMChatRoomAddChatRoomMemberApplicationApproved", this.gfN);
        AppMethodBeat.m2505o(78966);
    }

    public void execute(C1681g c1681g) {
    }

    public void configure(C1681g c1681g) {
    }
}
