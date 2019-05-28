package com.tencent.p177mm.plugin.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.model.C36698o;
import com.tencent.p177mm.plugin.chatroom.p721a.C33811b;
import com.tencent.p177mm.plugin.chatroom.p721a.C6823d;

/* renamed from: com.tencent.mm.plugin.chatroom.PluginChatroom */
public class PluginChatroom extends C7597f implements C6823d {
    public String name() {
        return "plugin-chatroom";
    }

    public void execute(C1681g c1681g) {
        AppMethodBeat.m2504i(5560);
        if (c1681g.mo5181SG()) {
            C1720g.m3542a(C33811b.class, new C36698o());
        }
        AppMethodBeat.m2505o(5560);
    }
}
