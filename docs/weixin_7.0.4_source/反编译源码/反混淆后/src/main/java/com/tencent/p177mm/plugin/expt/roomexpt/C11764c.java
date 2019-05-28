package com.tencent.p177mm.plugin.expt.roomexpt;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.expt.roomexpt.c */
final class C11764c implements Comparable<C11764c> {
    String cuP;
    float lOE;
    String nickname;

    C11764c() {
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        C11764c c11764c = (C11764c) obj;
        if (this.lOE > c11764c.lOE) {
            return -1;
        }
        if (this.lOE < c11764c.lOE) {
            return 1;
        }
        return 0;
    }

    public final String toString() {
        AppMethodBeat.m2504i(73588);
        String format = String.format("chatroom[%s %s] score[%f]", new Object[]{this.cuP, this.nickname, Float.valueOf(this.lOE)});
        AppMethodBeat.m2505o(73588);
        return format;
    }
}
