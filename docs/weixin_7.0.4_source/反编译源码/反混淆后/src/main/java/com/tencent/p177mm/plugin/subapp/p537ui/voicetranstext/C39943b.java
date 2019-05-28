package com.tencent.p177mm.plugin.subapp.p537ui.voicetranstext;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.aqd;
import com.tencent.p177mm.protocal.protobuf.aqe;
import com.tencent.p177mm.protocal.protobuf.cof;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.subapp.ui.voicetranstext.b */
public final class C39943b extends C1207m implements C1918k {
    private final String TAG = "MicroMsg.NetSceneGetVoiceTransRes";
    private C7472b fsB;
    private C1202f oRe;
    private String svJ;
    public cof svR;
    public int svV = -1;

    public C39943b(String str) {
        boolean z;
        AppMethodBeat.m2504i(25580);
        if (C5046bo.isNullOrNil(str)) {
            z = false;
        } else {
            z = true;
        }
        Assert.assertTrue(z);
        this.svJ = str;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new aqd();
        c1196a.fsK = new aqe();
        c1196a.uri = "/cgi-bin/micromsg-bin/getvoicetransres";
        c1196a.fsI = 548;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.fsB = c1196a.acD();
        AppMethodBeat.m2505o(25580);
    }

    public final int getType() {
        return 548;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(25581);
        this.oRe = c1202f;
        ((aqd) this.fsB.fsG.fsP).vZx = this.svJ;
        int a = mo4457a(c1902e, this.fsB, this);
        AppMethodBeat.m2505o(25581);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(25582);
        if (i2 == 0 && i3 == 0) {
            aqe aqe = (aqe) this.fsB.fsH.fsP;
            if (aqe.vZB != null) {
                this.svV = aqe.vZB.wRe;
            }
            this.svR = aqe.vZz;
        } else {
            C4990ab.m7417i("MicroMsg.NetSceneGetVoiceTransRes", "error get: errType:%d, errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        }
        this.oRe.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(25582);
    }

    public final boolean isComplete() {
        return this.svR != null && this.svR.fJT == 1;
    }

    public final boolean cDR() {
        AppMethodBeat.m2504i(25583);
        if (this.svR == null || C5046bo.isNullOrNil(this.svR.xlH)) {
            AppMethodBeat.m2505o(25583);
            return false;
        }
        AppMethodBeat.m2505o(25583);
        return true;
    }
}
