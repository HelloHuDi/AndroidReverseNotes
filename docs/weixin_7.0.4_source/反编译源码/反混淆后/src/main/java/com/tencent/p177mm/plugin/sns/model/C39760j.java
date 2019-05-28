package com.tencent.p177mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.beu;
import com.tencent.p177mm.protocal.protobuf.bev;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5128ac.C5127a;

/* renamed from: com.tencent.mm.plugin.sns.model.j */
public final class C39760j extends C1207m implements C1918k {
    private C7472b ehh;
    public C1202f ehi;
    private final int fhF = -1216949095;

    public C39760j() {
        AppMethodBeat.m2504i(36236);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new beu();
        c1196a.fsK = new bev();
        c1196a.uri = "/cgi-bin/mmbiz-bin/oauth_checkgrant";
        this.ehh = c1196a.acD();
        beu beu = (beu) this.ehh.fsG.fsP;
        C1720g.m3537RQ();
        C1720g.m3534RN();
        beu.wIP = C1668a.m3383QF();
        beu.wIQ = -1216949095;
        C4990ab.m7417i("MicroMsg.NetSceneOauthCheckGrant", "init useruin:%d, bizuin:%d", Integer.valueOf(beu.wIP), Integer.valueOf(beu.wIQ));
        AppMethodBeat.m2505o(36236);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(36237);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(36237);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(36238);
        C4990ab.m7416i("MicroMsg.NetSceneOauthCheckGrant", "onGYNetEnd netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            C4990ab.m7417i("MicroMsg.NetSceneOauthCheckGrant", "onGYNetEnd bizUin:%d, status:%d", Integer.valueOf(this.fhF), Integer.valueOf(((bev) ((C7472b) c1929q).fsH.fsP).status));
            if (this.fhF == -1216949095) {
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_SNS_OPEN_UPLOAD_WEISHI_BOOLEAN_SYNC, Boolean.valueOf(r0.status == 1));
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(36238);
    }

    public final int getType() {
        return 2842;
    }
}
