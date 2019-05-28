package com.tencent.mm.plugin.notification.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;

public final class b {
    int currentIndex;
    public ArrayList<Long> oVR;

    public b() {
        AppMethodBeat.i(23111);
        this.currentIndex = 0;
        this.oVR = new ArrayList();
        this.currentIndex = 0;
        AppMethodBeat.o(23111);
    }

    public final void js(long j) {
        AppMethodBeat.i(23112);
        ab.d("MicroMsg.FailMsglist", "addMsgId:%d, currentIndex:%d, size:%d", Long.valueOf(j), Integer.valueOf(this.currentIndex), Integer.valueOf(this.oVR.size()));
        this.oVR.add(Long.valueOf(j));
        AppMethodBeat.o(23112);
    }

    public final long bWJ() {
        AppMethodBeat.i(23113);
        long j = -1;
        if (this.oVR.size() > 0 && this.currentIndex < this.oVR.size()) {
            j = ((Long) this.oVR.get(this.currentIndex)).longValue();
        }
        ab.d("MicroMsg.FailMsglist", "getNextSendMsgId:%d, currentIndex:%d, msgIdList.size:%d", Long.valueOf(j), Integer.valueOf(this.currentIndex), Integer.valueOf(this.oVR.size()));
        this.currentIndex++;
        AppMethodBeat.o(23113);
        return j;
    }

    public final boolean contains(long j) {
        AppMethodBeat.i(23114);
        boolean contains = this.oVR.contains(Long.valueOf(j));
        AppMethodBeat.o(23114);
        return contains;
    }

    public final void clear() {
        AppMethodBeat.i(23115);
        this.oVR.clear();
        this.currentIndex = 0;
        AppMethodBeat.o(23115);
    }

    public final long get(int i) {
        AppMethodBeat.i(23116);
        long longValue = ((Long) this.oVR.get(i)).longValue();
        AppMethodBeat.o(23116);
        return longValue;
    }

    public final void remove(long j) {
        AppMethodBeat.i(23117);
        this.oVR.remove(Long.valueOf(j));
        AppMethodBeat.o(23117);
    }
}
