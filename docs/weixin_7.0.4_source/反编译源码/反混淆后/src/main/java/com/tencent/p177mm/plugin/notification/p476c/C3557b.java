package com.tencent.p177mm.plugin.notification.p476c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.notification.c.b */
public final class C3557b {
    int currentIndex;
    public ArrayList<Long> oVR;

    public C3557b() {
        AppMethodBeat.m2504i(23111);
        this.currentIndex = 0;
        this.oVR = new ArrayList();
        this.currentIndex = 0;
        AppMethodBeat.m2505o(23111);
    }

    /* renamed from: js */
    public final void mo8115js(long j) {
        AppMethodBeat.m2504i(23112);
        C4990ab.m7411d("MicroMsg.FailMsglist", "addMsgId:%d, currentIndex:%d, size:%d", Long.valueOf(j), Integer.valueOf(this.currentIndex), Integer.valueOf(this.oVR.size()));
        this.oVR.add(Long.valueOf(j));
        AppMethodBeat.m2505o(23112);
    }

    public final long bWJ() {
        AppMethodBeat.m2504i(23113);
        long j = -1;
        if (this.oVR.size() > 0 && this.currentIndex < this.oVR.size()) {
            j = ((Long) this.oVR.get(this.currentIndex)).longValue();
        }
        C4990ab.m7411d("MicroMsg.FailMsglist", "getNextSendMsgId:%d, currentIndex:%d, msgIdList.size:%d", Long.valueOf(j), Integer.valueOf(this.currentIndex), Integer.valueOf(this.oVR.size()));
        this.currentIndex++;
        AppMethodBeat.m2505o(23113);
        return j;
    }

    public final boolean contains(long j) {
        AppMethodBeat.m2504i(23114);
        boolean contains = this.oVR.contains(Long.valueOf(j));
        AppMethodBeat.m2505o(23114);
        return contains;
    }

    public final void clear() {
        AppMethodBeat.m2504i(23115);
        this.oVR.clear();
        this.currentIndex = 0;
        AppMethodBeat.m2505o(23115);
    }

    public final long get(int i) {
        AppMethodBeat.m2504i(23116);
        long longValue = ((Long) this.oVR.get(i)).longValue();
        AppMethodBeat.m2505o(23116);
        return longValue;
    }

    public final void remove(long j) {
        AppMethodBeat.m2504i(23117);
        this.oVR.remove(Long.valueOf(j));
        AppMethodBeat.m2505o(23117);
    }
}
