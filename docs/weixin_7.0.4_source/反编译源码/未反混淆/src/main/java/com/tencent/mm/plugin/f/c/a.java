package com.tencent.mm.plugin.f.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.f.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;

public final class a implements Runnable {
    private bi csG;
    private int opType;

    public a(bi biVar, int i) {
        AppMethodBeat.i(18641);
        this.csG = biVar;
        this.opType = i;
        ab.d("MicroMsg.MsgEventTask", "%d msg id[%d %d] optype[%d]", Integer.valueOf(hashCode()), Long.valueOf(this.csG.field_msgId), Integer.valueOf(this.csG.getType()), Integer.valueOf(this.opType));
        AppMethodBeat.o(18641);
    }

    public final void run() {
        AppMethodBeat.i(18642);
        switch (this.opType) {
            case 1:
                b.aZc().O(this.csG);
                AppMethodBeat.o(18642);
                return;
            default:
                ab.w("MicroMsg.MsgEventTask", "%d unknow op type [%d]", Integer.valueOf(hashCode()), Integer.valueOf(this.opType));
                AppMethodBeat.o(18642);
                return;
        }
    }
}
