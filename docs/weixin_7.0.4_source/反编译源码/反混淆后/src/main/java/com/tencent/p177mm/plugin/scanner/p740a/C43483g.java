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
import com.tencent.p177mm.protocal.protobuf.C23410kw;
import com.tencent.p177mm.protocal.protobuf.C30199kx;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.ttpic.FilterEnum4Shaka;

/* renamed from: com.tencent.mm.plugin.scanner.a.g */
public final class C43483g extends C1207m implements C1918k {
    public int cvn;
    public int cvo;
    private C7472b ehh;
    private C1202f ehi;
    public boolean pZG = false;

    public C43483g(int i, String str, int i2, int i3) {
        AppMethodBeat.m2504i(80843);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C23410kw();
        c1196a.fsK = new C30199kx();
        c1196a.uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscanbarcode";
        c1196a.fsI = FilterEnum4Shaka.MIC_WEISHI_QINSHUI;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        C23410kw c23410kw = (C23410kw) this.ehh.fsG.fsP;
        c23410kw.jCt = i;
        c23410kw.vOm = str;
        c23410kw.Scene = 1;
        this.cvn = i2;
        this.cvo = i3;
        C4990ab.m7411d("MicroMsg.scanner.NetSceneScanBarcode", "NetSceneScanBarcode, type: %s, barcode: %s, scene: %s, codetype: %s, codeVersion: %s", Integer.valueOf(i), str, Integer.valueOf(1), Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.m2505o(80843);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(80844);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(80844);
        return a;
    }

    /* renamed from: b */
    public final C1206b mo4468b(C1929q c1929q) {
        AppMethodBeat.m2504i(80845);
        C23410kw c23410kw = (C23410kw) ((C7472b) c1929q).fsG.fsP;
        C1206b c1206b;
        if (c23410kw.jCt < 0 || c23410kw.vOm == null || c23410kw.vOm.length() <= 0) {
            C4990ab.m7412e("MicroMsg.scanner.NetSceneScanBarcode", "securityVerificationChecked failed, Type = " + c23410kw.jCt + ", Barcode = %s" + c23410kw.vOm);
            c1206b = C1206b.EFailed;
            AppMethodBeat.m2505o(80845);
            return c1206b;
        }
        c1206b = C1206b.EOk;
        AppMethodBeat.m2505o(80845);
        return c1206b;
    }

    public final C30199kx cgG() {
        if (this.ehh == null || this.ehh.fsH.fsP == null) {
            return null;
        }
        return (C30199kx) this.ehh.fsH.fsP;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(80846);
        C4990ab.m7410d("MicroMsg.scanner.NetSceneScanBarcode", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(80846);
    }

    public final int getType() {
        return FilterEnum4Shaka.MIC_WEISHI_QINSHUI;
    }
}
