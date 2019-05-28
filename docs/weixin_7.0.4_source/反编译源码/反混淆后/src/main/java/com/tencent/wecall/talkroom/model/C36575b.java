package com.tencent.wecall.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.multi.talk;
import com.tencent.p659pb.common.p1102c.C44443c;
import com.tencent.p659pb.common.p1631a.C44437a;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.tencent.wecall.talkroom.model.b */
public final class C36575b {
    talk AIV = new talk();

    public C36575b() {
        AppMethodBeat.m2504i(127789);
        C44443c.m80391i("simon:TalkRoomContext", "construct engine:", this.AIV);
        AppMethodBeat.m2505o(127789);
    }

    public final int uninitLive() {
        AppMethodBeat.m2504i(127790);
        if (C44437a.Alr) {
            int uninit;
            try {
                if (this.AIV != null) {
                    uninit = this.AIV.uninit();
                    C44443c.m80391i("simon:TalkRoomContext", "uninitLive ret: ", Integer.valueOf(uninit));
                    AppMethodBeat.m2505o(127790);
                    return uninit;
                }
            } catch (Throwable th) {
                C44443c.m80392w("simon:TalkRoomContext", "uninitLive ", th);
            }
            uninit = 0;
            C44443c.m80391i("simon:TalkRoomContext", "uninitLive ret: ", Integer.valueOf(uninit));
            AppMethodBeat.m2505o(127790);
            return uninit;
        }
        AppMethodBeat.m2505o(127790);
        return 0;
    }

    public final int Close() {
        AppMethodBeat.m2504i(127791);
        if (C44437a.Alr) {
            int close;
            try {
                if (this.AIV != null) {
                    close = this.AIV.close();
                    C44443c.m80391i("simon:TalkRoomContext", "Close ret: ", Integer.valueOf(close));
                    AppMethodBeat.m2505o(127791);
                    return close;
                }
            } catch (Throwable th) {
                C44443c.m80392w("simon:TalkRoomContext", "Close ", th);
            }
            close = 0;
            C44443c.m80391i("simon:TalkRoomContext", "Close ret: ", Integer.valueOf(close));
            AppMethodBeat.m2505o(127791);
            return close;
        }
        AppMethodBeat.m2505o(127791);
        return 0;
    }

    public final void OnMembersChanged(int[] iArr) {
        AppMethodBeat.m2504i(127792);
        if (!C44437a.Alr || this.AIV == null) {
            AppMethodBeat.m2505o(127792);
            return;
        }
        this.AIV.OnMembersChanged(iArr);
        AppMethodBeat.m2505o(127792);
    }

    public final byte[] dTd() {
        if (!C44437a.Alr || this.AIV == null) {
            return new byte[0];
        }
        return this.AIV.field_capInfo;
    }

    public final void dTe() {
        if (C44437a.Alr && this.AIV != null) {
            this.AIV.field_capInfo = null;
        }
    }

    public final int dTf() {
        int i = 0;
        AppMethodBeat.m2504i(127793);
        try {
            if (!C44437a.Alr || this.AIV == null) {
                AppMethodBeat.m2505o(127793);
                return i;
            }
            AtomicInteger atomicInteger = new AtomicInteger();
            AtomicInteger atomicInteger2 = new AtomicInteger();
            this.AIV.getChannelBytes(atomicInteger, atomicInteger2);
            i = atomicInteger2.get();
            AppMethodBeat.m2505o(127793);
            return i;
        } catch (Throwable th) {
            C44443c.m80392w("simon:TalkRoomContext", "getTotalWWANBytes: ", th);
            AppMethodBeat.m2505o(127793);
        }
    }
}
