package com.tencent.p177mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.protocal.protobuf.apk;
import com.tencent.p177mm.protocal.protobuf.apl;

/* renamed from: com.tencent.mm.plugin.setting.model.f */
public final class C46191f extends C1207m implements C1918k {
    private C1202f ehi;
    public apl qjE;
    public byte[] qjF;

    public C46191f(byte[] bArr) {
        this.qjF = bArr;
    }

    public final int getType() {
        return 1146;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(126849);
        this.ehi = c1202f;
        C1196a c1196a = new C1196a();
        apk apk = new apk();
        if (this.qjF != null) {
            apk.wtt = C1946aa.m4152ad(this.qjF).getBuffer();
        }
        c1196a.fsJ = apk;
        this.qjE = new apl();
        c1196a.fsK = this.qjE;
        c1196a.uri = "/cgi-bin/mmbiz-bin/getuserauthlist";
        c1196a.fsI = 1146;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        int a = mo4457a(c1902e, c1196a.acD(), this);
        AppMethodBeat.m2505o(126849);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(126850);
        this.qjE = (apl) ((C7472b) c1929q).fsH.fsP;
        if (this.qjE.wcK != null) {
            i3 = this.qjE.wcK.cyE;
            str = this.qjE.wcK.cyF;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(126850);
    }
}
