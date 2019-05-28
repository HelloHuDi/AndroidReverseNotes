package com.tencent.p177mm.plugin.card.p352b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.card.model.C11293u;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.card.b.l */
public final class C6813l implements C1202f {
    public float ecs = -85.0f;
    public float ect = -1000.0f;
    private long updateTime = 0;

    /* renamed from: O */
    public final void mo15081O(float f, float f2) {
        AppMethodBeat.m2504i(87756);
        this.ecs = f;
        this.ect = f2;
        this.updateTime = System.currentTimeMillis() / 1000;
        AppMethodBeat.m2505o(87756);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(87758);
        C4990ab.m7417i("MicroMsg.CardReportLBSManager", "rplbs onGYNetEnd, errType = %d, errCode = %d", Integer.valueOf(i), Integer.valueOf(i2));
        C1720g.m3535RO().eJo.mo14546b(1253, (C1202f) this);
        AppMethodBeat.m2505o(87758);
    }

    /* renamed from: s */
    public final void mo15082s(String str, String str2, int i) {
        AppMethodBeat.m2504i(87757);
        if ((System.currentTimeMillis() / 1000) - this.updateTime > 1800) {
            this.ecs = -85.0f;
            this.ect = -1000.0f;
            C4990ab.m7416i("MicroMsg.CardReportLBSManager", "checkDataValid time is out");
        }
        if (this.ecs == -85.0f) {
            C4990ab.m7416i("MicroMsg.CardReportLBSManager", "checkDataValid lbsLatitude ==  LocationGeo.INVALID_LAT");
        }
        if (this.ect == -1000.0f) {
            C4990ab.m7416i("MicroMsg.CardReportLBSManager", "checkDataValid lbsLongitude ==  LocationGeo.INVALID_LNG");
        }
        C1720g.m3535RO().eJo.mo14539a(1253, (C1202f) this);
        C1720g.m3535RO().eJo.mo14541a(new C11293u(this.ecs, this.ect, str, str2, i), 0);
        AppMethodBeat.m2505o(87757);
    }
}
