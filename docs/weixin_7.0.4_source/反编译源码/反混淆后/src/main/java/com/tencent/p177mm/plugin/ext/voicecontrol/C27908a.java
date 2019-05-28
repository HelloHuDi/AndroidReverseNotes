package com.tencent.p177mm.plugin.ext.voicecontrol;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.protocal.protobuf.C30183fh;
import com.tencent.p177mm.protocal.protobuf.C44117fb;
import com.tencent.p177mm.protocal.protobuf.C44118fc;
import com.tencent.p177mm.protocal.protobuf.C44119fd;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.ext.voicecontrol.a */
public final class C27908a extends C1207m implements C1918k {
    /* renamed from: JJ */
    public int f13689JJ;
    public String appId;
    public int coc;
    public int czE = 1;
    C7472b ehh;
    private C1202f ehi;
    public int frO;
    public C30183fh lRA;
    public C44117fb lRB;
    int lRC = 5000;
    long lRD = 0;
    public int lRx;
    public C1332b lRy;
    public String lRz;

    public C27908a(int i, String str, int i2, String str2, C30183fh c30183fh) {
        boolean z = true;
        AppMethodBeat.m2504i(20457);
        this.appId = str;
        this.lRx = i;
        this.f13689JJ = 1;
        this.frO = i2;
        this.lRA = c30183fh;
        this.lRB = null;
        this.lRz = str2;
        String str3 = "MicroMsg.ext.NetSceneAppVoiceControl";
        String str4 = "[voiceControl] new NetSceneAppVoiceControl, opCode=%s, appId=%s, voiceId=%s, totalLen=%s, controlType=%s, %s, %s";
        Object[] objArr = new Object[7];
        objArr[0] = Integer.valueOf(1);
        objArr[1] = str;
        objArr[2] = Integer.valueOf(i);
        objArr[3] = Integer.valueOf(i2);
        objArr[4] = Integer.valueOf(1);
        if (c30183fh == null) {
            z = false;
        }
        objArr[5] = Boolean.valueOf(z);
        objArr[6] = Boolean.FALSE;
        C4990ab.m7417i(str3, str4, objArr);
        AppMethodBeat.m2505o(20457);
    }

    public C27908a(int i, String str, C44117fb c44117fb, long j) {
        AppMethodBeat.m2504i(20458);
        this.appId = str;
        this.lRx = i;
        this.f13689JJ = 1;
        this.lRA = null;
        this.lRB = c44117fb;
        this.lRD = j;
        C4990ab.m7417i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] new NetSceneAppVoiceControl, opCode=%s, appId=%s, voiceId=%s, controlType=%s, %s, %s", Integer.valueOf(2), str, Integer.valueOf(i), Integer.valueOf(1), Boolean.FALSE, Boolean.TRUE);
        AppMethodBeat.m2505o(20458);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(20459);
        if (i2 == 0 && i3 == 0 && c1929q != null) {
            C4990ab.m7417i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] onGYNetEnd netId %d , errType %d, errCode %d, %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        } else {
            C4990ab.m7413e("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] onGYNetEnd netId %d , errType %d, errCode %d, %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(20459);
            return;
        }
        C4990ab.m7412e("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] callback null");
        AppMethodBeat.m2505o(20459);
    }

    public final int getType() {
        return 985;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(20460);
        this.ehi = c1202f;
        C1196a c1196a = new C1196a();
        c1196a.fsI = 985;
        c1196a.uri = "/cgi-bin/micromsg-bin/appvoicecontrol";
        c1196a.fsJ = new C44118fc();
        c1196a.fsK = new C44119fd();
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        C44118fc c44118fc = (C44118fc) this.ehh.fsG.fsP;
        c44118fc.OpCode = this.czE;
        c44118fc.fKh = this.appId;
        c44118fc.vHa = this.lRx;
        c44118fc.vHb = this.f13689JJ;
        c44118fc.vHc = this.lRA;
        c44118fc.vHd = this.lRB;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(20460);
        return a;
    }
}
