package com.tencent.wecall.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multi.talk;
import com.tencent.pb.common.a.a;
import com.tencent.pb.common.c.c;
import java.util.concurrent.atomic.AtomicInteger;

public final class b {
    talk AIV = new talk();

    public b() {
        AppMethodBeat.i(127789);
        c.i("simon:TalkRoomContext", "construct engine:", this.AIV);
        AppMethodBeat.o(127789);
    }

    public final int uninitLive() {
        AppMethodBeat.i(127790);
        if (a.Alr) {
            int uninit;
            try {
                if (this.AIV != null) {
                    uninit = this.AIV.uninit();
                    c.i("simon:TalkRoomContext", "uninitLive ret: ", Integer.valueOf(uninit));
                    AppMethodBeat.o(127790);
                    return uninit;
                }
            } catch (Throwable th) {
                c.w("simon:TalkRoomContext", "uninitLive ", th);
            }
            uninit = 0;
            c.i("simon:TalkRoomContext", "uninitLive ret: ", Integer.valueOf(uninit));
            AppMethodBeat.o(127790);
            return uninit;
        }
        AppMethodBeat.o(127790);
        return 0;
    }

    public final int Close() {
        AppMethodBeat.i(127791);
        if (a.Alr) {
            int close;
            try {
                if (this.AIV != null) {
                    close = this.AIV.close();
                    c.i("simon:TalkRoomContext", "Close ret: ", Integer.valueOf(close));
                    AppMethodBeat.o(127791);
                    return close;
                }
            } catch (Throwable th) {
                c.w("simon:TalkRoomContext", "Close ", th);
            }
            close = 0;
            c.i("simon:TalkRoomContext", "Close ret: ", Integer.valueOf(close));
            AppMethodBeat.o(127791);
            return close;
        }
        AppMethodBeat.o(127791);
        return 0;
    }

    public final void OnMembersChanged(int[] iArr) {
        AppMethodBeat.i(127792);
        if (!a.Alr || this.AIV == null) {
            AppMethodBeat.o(127792);
            return;
        }
        this.AIV.OnMembersChanged(iArr);
        AppMethodBeat.o(127792);
    }

    public final byte[] dTd() {
        if (!a.Alr || this.AIV == null) {
            return new byte[0];
        }
        return this.AIV.field_capInfo;
    }

    public final void dTe() {
        if (a.Alr && this.AIV != null) {
            this.AIV.field_capInfo = null;
        }
    }

    public final int dTf() {
        int i = 0;
        AppMethodBeat.i(127793);
        try {
            if (!a.Alr || this.AIV == null) {
                AppMethodBeat.o(127793);
                return i;
            }
            AtomicInteger atomicInteger = new AtomicInteger();
            AtomicInteger atomicInteger2 = new AtomicInteger();
            this.AIV.getChannelBytes(atomicInteger, atomicInteger2);
            i = atomicInteger2.get();
            AppMethodBeat.o(127793);
            return i;
        } catch (Throwable th) {
            c.w("simon:TalkRoomContext", "getTotalWWANBytes: ", th);
            AppMethodBeat.o(127793);
        }
    }
}
