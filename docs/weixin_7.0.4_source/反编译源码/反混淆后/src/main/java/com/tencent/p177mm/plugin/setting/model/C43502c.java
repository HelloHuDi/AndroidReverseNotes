package com.tencent.p177mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C23456wg;
import com.tencent.p177mm.protocal.protobuf.C30237wf;

/* renamed from: com.tencent.mm.plugin.setting.model.c */
public final class C43502c extends C1207m implements C1918k {
    public final String appId;
    private C1202f ehi;
    private final int scene;

    public C43502c(String str, int i) {
        this.appId = str;
        this.scene = i;
    }

    public final int getType() {
        return 1127;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(126842);
        this.ehi = c1202f;
        C1196a c1196a = new C1196a();
        C30237wf c30237wf = new C30237wf();
        c30237wf.csB = this.appId;
        c30237wf.cME = this.scene;
        c1196a.fsJ = c30237wf;
        c1196a.uri = "/cgi-bin/mmbiz-bin/deluserauth";
        c1196a.fsK = new C23456wg();
        c1196a.fsI = 1127;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        int a = mo4457a(c1902e, c1196a.acD(), this);
        AppMethodBeat.m2505o(126842);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(126843);
        C23456wg c23456wg = (C23456wg) ((C7472b) c1929q).fsH.fsP;
        this.ehi.onSceneEnd(i2, c23456wg.wcK.cyE, c23456wg.wcK.cyF, this);
        AppMethodBeat.m2505o(126843);
    }
}
