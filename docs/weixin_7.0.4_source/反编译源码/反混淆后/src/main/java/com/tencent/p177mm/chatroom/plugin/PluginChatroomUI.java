package com.tencent.p177mm.chatroom.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import org.xwalk.core.Log;

/* renamed from: com.tencent.mm.chatroom.plugin.PluginChatroomUI */
public class PluginChatroomUI extends C7597f {
    public String name() {
        return "ui-chatroom";
    }

    public void execute(C1681g c1681g) {
        AppMethodBeat.m2504i(103961);
        Log.m81049i("MicroMsg.PluginChatroomUI", "[execute]");
        pin(C32443a.m53115JA());
        AppMethodBeat.m2505o(103961);
    }
}
