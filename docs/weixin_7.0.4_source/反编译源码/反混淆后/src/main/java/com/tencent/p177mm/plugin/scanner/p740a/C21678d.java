package com.tencent.p177mm.plugin.scanner.p740a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1207m.C1206b;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C23409kp;
import com.tencent.p177mm.protocal.protobuf.C30198kq;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.ttpic.FilterEnum4Shaka;

/* renamed from: com.tencent.mm.plugin.scanner.a.d */
public final class C21678d extends C1207m implements C1918k {
    private String cwg;
    public C7472b ehh;
    private C1202f ehi;
    private String kES;
    private int scene;

    public C21678d(String str, int i, String str2) {
        this.cwg = str;
        this.scene = i;
        this.kES = str2;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(80834);
        this.ehi = c1202f;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C23409kp();
        c1196a.fsK = new C30198kq();
        c1196a.uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscangetproductinfo";
        c1196a.fsI = FilterEnum4Shaka.MIC_WEISHI_BAIXIANG;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        C23409kp c23409kp = (C23409kp) this.ehh.fsG.fsP;
        c23409kp.ProductID = this.cwg;
        c23409kp.Scene = this.scene;
        c23409kp.vNG = this.kES;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(80834);
        return a;
    }

    /* renamed from: b */
    public final C1206b mo4468b(C1929q c1929q) {
        AppMethodBeat.m2504i(80835);
        C23409kp c23409kp = (C23409kp) ((C7472b) c1929q).fsG.fsP;
        C1206b c1206b;
        if (c23409kp.Scene < 0 || c23409kp.ProductID == null || c23409kp.ProductID.length() <= 0) {
            C4990ab.m7413e("MicroMsg.scanner.NetSceneGetProductInfo", "ERR: Security Check Failed, Scene = %s", Integer.valueOf(c23409kp.Scene));
            c1206b = C1206b.EFailed;
            AppMethodBeat.m2505o(80835);
            return c1206b;
        }
        c1206b = C1206b.EOk;
        AppMethodBeat.m2505o(80835);
        return c1206b;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(80836);
        C4990ab.m7410d("MicroMsg.scanner.NetSceneGetProductInfo", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(80836);
    }

    public final int getType() {
        return FilterEnum4Shaka.MIC_WEISHI_BAIXIANG;
    }
}
