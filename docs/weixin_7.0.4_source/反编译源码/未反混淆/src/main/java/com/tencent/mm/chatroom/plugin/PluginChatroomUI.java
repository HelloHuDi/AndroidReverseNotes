package com.tencent.mm.chatroom.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import org.xwalk.core.Log;

public class PluginChatroomUI extends f {
    public String name() {
        return "ui-chatroom";
    }

    public void execute(g gVar) {
        AppMethodBeat.i(103961);
        Log.i("MicroMsg.PluginChatroomUI", "[execute]");
        pin(a.JA());
        AppMethodBeat.o(103961);
    }
}
