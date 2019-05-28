package com.tencent.mm.am;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ai;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.s;

public final class c extends ai {
    public final boolean kw(int i) {
        return i != 0 && i < 637929471;
    }

    public final String getTag() {
        return "MicroMsg.BizTimeLineDataTransfer";
    }

    public final void transfer(int i) {
        AppMethodBeat.i(16431);
        ab.d("MicroMsg.BizTimeLineDataTransfer", "the previous version is %d", Integer.valueOf(i));
        if (i != 0 && i < 637929471) {
            boolean z;
            if ((((Integer) g.RP().Ry().get(a.USERINFO_BIZ_TIME_LINE_MIGRATE_DATA_INT_SYNC, Integer.valueOf(0))).intValue() & 2) > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                s.pp(true);
            }
            ab.i("MicroMsg.BizTimeLineDataTransfer", "transfer end %b", Boolean.valueOf(z));
        }
        AppMethodBeat.o(16431);
    }
}
