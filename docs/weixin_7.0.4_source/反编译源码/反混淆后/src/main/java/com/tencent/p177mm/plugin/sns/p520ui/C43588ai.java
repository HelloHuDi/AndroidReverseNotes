package com.tencent.p177mm.plugin.sns.p520ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.sns.ui.ai */
public final class C43588ai {
    String lQD = "";
    int position = 0;
    long qMB = 0;
    long rmK = 0;
    String rmL = "";
    int rmM = 0;

    public final boolean csu() {
        AppMethodBeat.m2504i(38545);
        C4990ab.m7417i("MicroMsg.ResumeSnsControl", "resume time %d", Long.valueOf(C5046bo.m7525az(this.rmK)));
        C4990ab.m7417i("MicroMsg.ResumeSnsControl", "lastSnsTime %s limitSeq %s respMinSeq %s timeLastId %s position %s topy %s", Long.valueOf(this.rmK), this.lQD, this.rmL, Long.valueOf(this.qMB), Integer.valueOf(this.position), Integer.valueOf(this.rmM));
        if (C5046bo.m7525az(this.rmK) >= 180000 || this.position <= 0) {
            AppMethodBeat.m2505o(38545);
            return false;
        }
        C4990ab.m7417i("MicroMsg.ResumeSnsControl", "timeLastId is %d ", Long.valueOf(this.qMB));
        if (this.qMB == 0) {
            AppMethodBeat.m2505o(38545);
            return false;
        }
        C13373af.cnv().mo8613B(this.qMB, -1);
        AppMethodBeat.m2505o(38545);
        return true;
    }
}
