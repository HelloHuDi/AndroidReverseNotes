package com.tencent.p177mm.plugin.sport.model;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.protocal.protobuf.ctf;
import com.tencent.p177mm.protocal.protobuf.ctg;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.p177mm.storage.C7574bs;

/* renamed from: com.tencent.mm.plugin.sport.model.e */
public final class C22165e extends C1207m implements C1918k {
    private C1202f ehi;
    private C7472b fAT;
    ctg rPu;

    public C22165e() {
        AppMethodBeat.m2504i(93660);
        C1196a c1196a = new C1196a();
        c1196a.uri = "/cgi-bin/mmoc-bin/hardware/getwxsportconfig";
        c1196a.fsJ = new ctf();
        c1196a.fsK = new ctg();
        this.fAT = c1196a.acD();
        ctf ctf = (ctf) this.fAT.fsG.fsP;
        ctf.jBF = C7243d.DEVICE_NAME;
        ctf.vIk = C7574bs.dut();
        ctf.vOA = Build.BRAND;
        ctf.vOz = Build.MODEL;
        ctf.xqm = C7243d.vxk;
        ctf.vOB = C7243d.vxl;
        ctf.vOC = C7243d.vxm;
        ctf.xqn = C5058f.CLIENT_VERSION;
        ctf.xqo = Build.MANUFACTURER;
        C4990ab.m7417i("MicroMsg.Sport.NetSceneGetWeSportConfig", "request params=[%s, %s, %s, %s, %s, %s, %s, %s, %s]", ctf.vIk, ctf.vOA, ctf.vOz, ctf.jBF, ctf.vOC, ctf.vOB, ctf.vOC, ctf.xqn, ctf.xqo);
        AppMethodBeat.m2505o(93660);
    }

    public final int getType() {
        return 1947;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(93661);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.fAT, this);
        AppMethodBeat.m2505o(93661);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(93662);
        C4990ab.m7417i("MicroMsg.Sport.NetSceneGetWeSportConfig", "onGYNetEnd %d %d %d %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            this.rPu = (ctg) this.fAT.fsH.fsP;
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(93662);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(93662);
    }
}
