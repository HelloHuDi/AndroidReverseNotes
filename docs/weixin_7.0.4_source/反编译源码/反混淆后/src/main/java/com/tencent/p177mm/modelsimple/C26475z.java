package com.tencent.p177mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C35913df;
import com.tencent.p177mm.protocal.protobuf.cip;
import com.tencent.p177mm.protocal.protobuf.ciq;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.rtmp.TXLivePushConfig;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.modelsimple.z */
public final class C26475z extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;

    public C26475z(String str, int i, LinkedList<C35913df> linkedList) {
        AppMethodBeat.m2504i(78609);
        C4990ab.m7416i("MicroMsg.NetSceneTranslateLink", "ticket link = " + str + "; scene = " + i);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cip();
        c1196a.fsK = new ciq();
        c1196a.uri = "/cgi-bin/mmbiz-bin/translatelink";
        c1196a.fsI = TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE;
        this.ehh = c1196a.acD();
        cip cip = (cip) this.ehh.fsG.fsP;
        cip.link = str;
        cip.scene = i;
        cip.xhw = linkedList;
        AppMethodBeat.m2505o(78609);
    }

    public final int getType() {
        return TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(78610);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(78610);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(78611);
        C4990ab.m7411d("MicroMsg.NetSceneTranslateLink", "swap deep link with ticket onGYNetEnd:[%d,%d,%s]", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(78611);
    }

    public final String ajD() {
        ciq ciq = (ciq) this.ehh.fsH.fsP;
        if (ciq == null) {
            return null;
        }
        return ciq.xhx;
    }

    public final ciq ajE() {
        if (this.ehh == null || this.ehh.fsH.fsP == null) {
            return null;
        }
        return (ciq) this.ehh.fsH.fsP;
    }
}
