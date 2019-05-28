package com.tencent.p177mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.sns.storage.C13479t;
import com.tencent.p177mm.protocal.protobuf.cbz;
import com.tencent.p177mm.protocal.protobuf.cce;
import com.tencent.p177mm.protocal.protobuf.ccf;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.sns.model.x */
public final class C7110x extends C1207m implements C1918k {
    private int czE;
    private C7472b ehh;
    public C1202f ehi;
    private long qJQ = 0;

    public C7110x(long j, String str) {
        AppMethodBeat.m2504i(36333);
        C4990ab.m7410d("MicroMsg.NetSceneSnsTagOption", "opcode 3 snsTagId " + j + " tagName " + str);
        this.qJQ = j;
        this.czE = 3;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cce();
        c1196a.fsK = new ccf();
        c1196a.uri = "/cgi-bin/micromsg-bin/mmsnstagoption";
        c1196a.fsI = 290;
        c1196a.fsL = 114;
        c1196a.fsM = 1000000114;
        this.ehh = c1196a.acD();
        cce cce = (cce) this.ehh.fsG.fsP;
        cce.OpCode = 3;
        cce.xbt = j;
        cce.ncF = str;
        AppMethodBeat.m2505o(36333);
    }

    public final int getType() {
        return 290;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(36334);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(36334);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(36335);
        C4990ab.m7410d("MicroMsg.NetSceneSnsTagOption", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            cbz cbz = ((ccf) ((C7472b) c1929q).fsH.fsP).xbv;
            C4990ab.m7410d("MicroMsg.NetSceneSnsTagOption", cbz.toString());
            switch (this.czE) {
                case 1:
                case 2:
                    C13479t kF = C13373af.cnL().mo55579kF(cbz.xbt);
                    kF.field_tagId = cbz.xbt;
                    kF.field_tagName = C5046bo.m7532bc(cbz.ncF, "");
                    kF.field_count = cbz.jBv;
                    kF.mo25636do(cbz.jBw);
                    C13373af.cnL().mo55576a(kF);
                    break;
                case 3:
                    C4990ab.m7410d("MicroMsg.NetSceneSnsTagOption", "MM_SNS_TAG_DEL ".concat(String.valueOf(C13373af.cnL().mo55580kG(this.qJQ))));
                    break;
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(36335);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(36335);
    }
}
