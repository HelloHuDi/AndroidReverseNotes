package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class ai {
    String lQD = "";
    int position = 0;
    long qMB = 0;
    long rmK = 0;
    String rmL = "";
    int rmM = 0;

    public final boolean csu() {
        AppMethodBeat.i(38545);
        ab.i("MicroMsg.ResumeSnsControl", "resume time %d", Long.valueOf(bo.az(this.rmK)));
        ab.i("MicroMsg.ResumeSnsControl", "lastSnsTime %s limitSeq %s respMinSeq %s timeLastId %s position %s topy %s", Long.valueOf(this.rmK), this.lQD, this.rmL, Long.valueOf(this.qMB), Integer.valueOf(this.position), Integer.valueOf(this.rmM));
        if (bo.az(this.rmK) >= 180000 || this.position <= 0) {
            AppMethodBeat.o(38545);
            return false;
        }
        ab.i("MicroMsg.ResumeSnsControl", "timeLastId is %d ", Long.valueOf(this.qMB));
        if (this.qMB == 0) {
            AppMethodBeat.o(38545);
            return false;
        }
        af.cnv().B(this.qMB, -1);
        AppMethodBeat.o(38545);
        return true;
    }
}
