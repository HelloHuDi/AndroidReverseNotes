package com.tencent.p177mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bwf;
import com.tencent.p177mm.protocal.protobuf.bwg;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.xwalk.core.XWalkEnvironment;

/* renamed from: com.tencent.mm.plugin.setting.model.j */
public final class C7081j extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;

    public C7081j(String str, String str2) {
        this(str, str2, 0);
    }

    public C7081j(String str, String str2, int i) {
        AppMethodBeat.m2504i(126858);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bwf();
        c1196a.fsK = new bwg();
        c1196a.uri = "/cgi-bin/micromsg-bin/sendfeedback";
        c1196a.fsI = XWalkEnvironment.SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        bwf bwf = (bwf) this.ehh.fsG.fsP;
        bwf.wWV = str;
        bwf.ncM = str2;
        bwf.wBm = i;
        AppMethodBeat.m2505o(126858);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(126859);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(126859);
        return a;
    }

    public final int getType() {
        return XWalkEnvironment.SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(126860);
        C4990ab.m7410d("MicroMsg.NetSendSceneFeedBack", "onGYNetEnd type:" + i2 + " code:" + i3);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(126860);
    }
}
