package com.tencent.mm.plugin.expt.roomexpt;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class c implements Comparable<c> {
    String cuP;
    float lOE;
    String nickname;

    c() {
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        c cVar = (c) obj;
        if (this.lOE > cVar.lOE) {
            return -1;
        }
        if (this.lOE < cVar.lOE) {
            return 1;
        }
        return 0;
    }

    public final String toString() {
        AppMethodBeat.i(73588);
        String format = String.format("chatroom[%s %s] score[%f]", new Object[]{this.cuP, this.nickname, Float.valueOf(this.lOE)});
        AppMethodBeat.o(73588);
        return format;
    }
}
