package com.tencent.p177mm.plugin.chatroom.p721a;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.chatroom.a.a */
public final class C33810a {
    public final int gag;
    public final String ktN;
    public final int ktO;
    public final int ktP;
    public final int ktQ;

    public C33810a(String str, int i, int i2, int i3, int i4) {
        this.ktN = str;
        this.ktO = i;
        this.gag = i2;
        this.ktP = i3;
        this.ktQ = i4;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(128346);
        if (hashCode() == obj.hashCode()) {
            AppMethodBeat.m2505o(128346);
            return true;
        } else if (obj instanceof C33810a) {
            C33810a c33810a = (C33810a) obj;
            if (this.ktO == c33810a.ktO && this.gag == c33810a.gag && this.ktP == c33810a.ktP && this.ktQ == c33810a.ktQ && this.ktN.equals(c33810a.ktN)) {
                AppMethodBeat.m2505o(128346);
                return true;
            }
            AppMethodBeat.m2505o(128346);
            return false;
        } else {
            AppMethodBeat.m2505o(128346);
            return false;
        }
    }

    public final String toString() {
        AppMethodBeat.m2504i(128347);
        String str = "GetChatRoomMsgInfo chatroomId[" + this.ktN + "], filterSeq[" + this.ktO + "], msgSeq[" + this.gag + "], needCount[" + this.ktP + "], upDownFlag[" + this.ktQ + "], hash[" + hashCode() + "]";
        AppMethodBeat.m2505o(128347);
        return str;
    }
}
