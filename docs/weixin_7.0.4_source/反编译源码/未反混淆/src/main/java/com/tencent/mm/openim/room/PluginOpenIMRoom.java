package com.tencent.mm.openim.room;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.openim.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.roomsdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;

public class PluginOpenIMRoom extends f implements c {
    private a gfN = new a();

    public PluginOpenIMRoom() {
        AppMethodBeat.i(78964);
        AppMethodBeat.o(78964);
    }

    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(78965);
        ab.i("MicroMsg.PluginOpenIMRoom", "onAccountInitialized");
        b.a("@im.chatroom", new a());
        ((p) g.M(p.class)).getSysCmdMsgExtension().a("NewXmlOpenIMChatRoomAddChatRoomMemberApplication", this.gfN);
        ((p) g.M(p.class)).getSysCmdMsgExtension().a("NewXmlOpenIMChatRoomAddChatRoomMemberApplicationApproved", this.gfN);
        AppMethodBeat.o(78965);
    }

    public void onAccountRelease() {
        AppMethodBeat.i(78966);
        ab.i("MicroMsg.PluginOpenIMRoom", "onAccountRelease");
        ((p) g.M(p.class)).getSysCmdMsgExtension().b("NewXmlOpenIMChatRoomAddChatRoomMemberApplication", this.gfN);
        ((p) g.M(p.class)).getSysCmdMsgExtension().b("NewXmlOpenIMChatRoomAddChatRoomMemberApplicationApproved", this.gfN);
        AppMethodBeat.o(78966);
    }

    public void execute(com.tencent.mm.kernel.b.g gVar) {
    }

    public void configure(com.tencent.mm.kernel.b.g gVar) {
    }
}
