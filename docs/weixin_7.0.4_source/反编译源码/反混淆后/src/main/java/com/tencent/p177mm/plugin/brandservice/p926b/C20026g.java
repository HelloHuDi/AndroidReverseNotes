package com.tencent.p177mm.plugin.brandservice.p926b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C44138ks;
import com.tencent.p177mm.protocal.protobuf.brk;
import com.tencent.p177mm.protocal.protobuf.brl;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.brandservice.b.g */
public final class C20026g extends C1207m implements C1918k {
    private C7472b ehh;
    private C1202f ehi;

    public C20026g(LinkedList<C44138ks> linkedList, int i, int i2, int i3) {
        AppMethodBeat.m2504i(13843);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new brk();
        c1196a.fsK = new brl();
        c1196a.uri = "/cgi-bin/micromsg-bin/reportshow";
        c1196a.fsL = ErrorCode.NEEDDOWNLOAD_FALSE_6;
        c1196a.fsM = 1000000176;
        this.ehh = c1196a.acD();
        brk brk = (brk) this.ehh.fsG.fsP;
        brk.wTG = linkedList;
        brk.wTH = i;
        brk.wTI = i2;
        brk.vZZ = i3;
        C4990ab.m7417i("MicroMsg.NetSceneReportBizListShowInfo", "reportshow report_list size %d,enter_pos %d,exit_pos %d", Integer.valueOf(brk.wTG.size()), Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.m2505o(13843);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(13844);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(13844);
    }

    public final int getType() {
        return 2645;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(13845);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(13845);
        return a;
    }
}
