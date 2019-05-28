package com.tencent.p177mm.plugin.record.p492b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p235i.C42129a;
import com.tencent.p177mm.plugin.p500s.C34832a;
import com.tencent.p177mm.pluginsdk.model.app.C30065b;
import com.tencent.p177mm.protocal.protobuf.C15376qk;
import com.tencent.p177mm.protocal.protobuf.C15377ql;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.record.b.c */
public final class C43430c extends C1207m implements C1918k {
    private C7472b ehh;
    private C1202f ehi;
    private final C30065b pJj;

    public C43430c(C30065b c30065b, String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.m2504i(135639);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C15376qk();
        c1196a.fsK = new C15377ql();
        c1196a.uri = "/cgi-bin/micromsg-bin/checkbigfiledownload";
        this.ehh = c1196a.acD();
        this.pJj = c30065b;
        C15376qk c15376qk = (C15376qk) this.ehh.fsG.fsP;
        c15376qk.vRw = str;
        c15376qk.vXv = c30065b.field_totalLen;
        c15376qk.vXw = str2;
        c15376qk.fMd = str3;
        c15376qk.vXx = str4;
        c15376qk.ndG = str5;
        c15376qk.ndF = (String) C1720g.m3536RP().mo5239Ry().get(2, (Object) "");
        c15376qk.vHo = C42129a.efE;
        C4990ab.m7417i("MicroMsg.NetSceneCheckBigFileDownload", "summerbig AESKey[%s] FileMd5[%s] FileName[%s] FileExt[%s] FileSize[%d] FileType[%d] stack[%s]", C5046bo.anv(c15376qk.vRw), c15376qk.vXw, c15376qk.fMd, c15376qk.vXx, Long.valueOf(c15376qk.vXv), Integer.valueOf(c15376qk.vHo), C5046bo.dpG());
        AppMethodBeat.m2505o(135639);
    }

    public final int getType() {
        return 728;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(135640);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(135640);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(135641);
        C4990ab.m7417i("MicroMsg.NetSceneCheckBigFileDownload", "summerbig onGYNetEnd [%d, %d, %s]", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            C15377ql c15377ql = (C15377ql) ((C7472b) c1929q).fsH.fsP;
            this.pJj.field_signature = c15377ql.guQ;
            this.pJj.field_fakeAeskey = c15377ql.vXz;
            this.pJj.field_fakeSignature = c15377ql.vXA;
            boolean a = C34832a.aUq().mo48326a(this.pJj, new String[0]);
            C4990ab.m7417i("MicroMsg.NetSceneCheckBigFileDownload", "summerbig onGYNetEnd field_signature[%s], field_fakeAeskey[%s], field_fakeSignature[%s], update[%b]", C5046bo.anv(this.pJj.field_signature), C5046bo.anv(this.pJj.field_fakeAeskey), C5046bo.anv(this.pJj.field_fakeSignature), Boolean.valueOf(a));
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(135641);
    }

    public final String getMediaId() {
        if (this.pJj != null) {
            return this.pJj.field_mediaSvrId;
        }
        return "";
    }
}
