package com.tencent.mm.plugin.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.o;
import com.tencent.mm.plugin.chatroom.a.b;
import com.tencent.mm.plugin.chatroom.a.d;

public class PluginChatroom extends f implements d {
    public String name() {
        return "plugin-chatroom";
    }

    public void execute(g gVar) {
        AppMethodBeat.i(5560);
        if (gVar.SG()) {
            com.tencent.mm.kernel.g.a(b.class, new o());
        }
        AppMethodBeat.o(5560);
    }
}
