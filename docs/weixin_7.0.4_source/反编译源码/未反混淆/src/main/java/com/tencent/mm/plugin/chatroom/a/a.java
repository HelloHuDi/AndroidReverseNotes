package com.tencent.mm.plugin.chatroom.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    public final int gag;
    public final String ktN;
    public final int ktO;
    public final int ktP;
    public final int ktQ;

    public a(String str, int i, int i2, int i3, int i4) {
        this.ktN = str;
        this.ktO = i;
        this.gag = i2;
        this.ktP = i3;
        this.ktQ = i4;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(128346);
        if (hashCode() == obj.hashCode()) {
            AppMethodBeat.o(128346);
            return true;
        } else if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.ktO == aVar.ktO && this.gag == aVar.gag && this.ktP == aVar.ktP && this.ktQ == aVar.ktQ && this.ktN.equals(aVar.ktN)) {
                AppMethodBeat.o(128346);
                return true;
            }
            AppMethodBeat.o(128346);
            return false;
        } else {
            AppMethodBeat.o(128346);
            return false;
        }
    }

    public final String toString() {
        AppMethodBeat.i(128347);
        String str = "GetChatRoomMsgInfo chatroomId[" + this.ktN + "], filterSeq[" + this.ktO + "], msgSeq[" + this.gag + "], needCount[" + this.ktP + "], upDownFlag[" + this.ktQ + "], hash[" + hashCode() + "]";
        AppMethodBeat.o(128347);
        return str;
    }
}
