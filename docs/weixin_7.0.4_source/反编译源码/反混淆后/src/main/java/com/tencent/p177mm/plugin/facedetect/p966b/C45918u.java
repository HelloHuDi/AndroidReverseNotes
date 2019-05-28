package com.tencent.p177mm.plugin.facedetect.p966b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.afj;
import com.tencent.p177mm.protocal.protobuf.afk;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.tmassistantsdk.common.TMAssistantDownloadSDKErrorCode;

/* renamed from: com.tencent.mm.plugin.facedetect.b.u */
public final class C45918u extends C1207m implements C1918k, C39006b {
    private C7472b ehh;
    private C1202f ehi;
    private long lTa = -1;
    private byte[] lTb = null;

    public final long bse() {
        return this.lTa;
    }

    public final byte[] bsf() {
        return this.lTb;
    }

    public C45918u(int i, int i2) {
        AppMethodBeat.m2504i(109);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new afj();
        c1196a.fsK = new afk();
        c1196a.uri = "/cgi-bin/micromsg-bin/getbioconfig";
        c1196a.fsI = TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_CLIENT_PROTOCOL_EXCEPTION;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        afj afj = (afj) this.ehh.fsG.fsP;
        afj.jCt = 1;
        afj.Scene = i;
        afj.wmN = i2;
        C4990ab.m7416i("MicroMsg.NetSceneGetBioConfig", "carson logic ");
        C4990ab.m7416i("MicroMsg.NetSceneGetBioConfig", "mChechLiveFlag is ".concat(String.valueOf(i2)));
        AppMethodBeat.m2505o(109);
    }

    public final int getType() {
        return TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_CLIENT_PROTOCOL_EXCEPTION;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(110);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(110);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(111);
        afk afk = (afk) ((C7472b) c1929q).fsH.fsP;
        if (i2 == 0 && i3 == 0) {
            this.lTa = afk.wmO;
            this.lTb = afk.wmP.f1226wR;
            C4990ab.m7416i("MicroMsg.NetSceneGetBioConfig", "carson logic ");
            C4990ab.m7416i("MicroMsg.NetSceneGetBioConfig", "Config is " + this.lTb);
            String str2 = "MicroMsg.NetSceneGetBioConfig";
            String str3 = "hy: get bio config: bioId: %s, bioConfigSize: %d";
            Object[] objArr = new Object[2];
            objArr[0] = Long.valueOf(this.lTa);
            objArr[1] = Integer.valueOf(this.lTb == null ? 0 : this.lTb.length);
            C4990ab.m7417i(str2, str3, objArr);
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(111);
    }
}
