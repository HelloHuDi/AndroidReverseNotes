package com.tencent.p177mm.plugin.qqmail.p486b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1207m.C1205a;
import com.tencent.p177mm.p183ai.C1207m.C1206b;
import com.tencent.p177mm.p183ai.C32231g;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Random;

/* renamed from: com.tencent.mm.plugin.qqmail.b.s */
public final class C28743s extends C1207m implements C1918k {
    private String cEV;
    private String clientId = null;
    private int coc = 0;
    private C7472b ehh;
    private C1202f ehi;
    private C32231g fEW;
    private int frO = 0;
    private String puA;
    private int puB = 0;
    private String puz = null;

    public C28743s(String str, String str2, String[] strArr, int i, C32231g c32231g) {
        AppMethodBeat.m2504i(67981);
        this.puz = str;
        this.puB = i;
        this.fEW = c32231g;
        if (!C5046bo.isNullOrNil(str)) {
            this.clientId = C1178g.m2591x(str.getBytes()) + "_" + System.nanoTime() + "_" + new Random().nextInt();
            this.frO = str.getBytes().length;
            this.coc = 0;
        }
        if (!C5046bo.isNullOrNil(str2)) {
            this.cEV = str2;
        }
        if (strArr != null) {
            this.puA = "";
            for (String str3 : strArr) {
                this.puA += str3 + ",";
            }
            this.puA = this.puA.substring(0, this.puA.length() - 1);
        }
        C4990ab.m7417i("MicroMsg.NetSceneComposeSend", "NetSceneComposeSend, clientId: %s, totalLen: %d", this.clientId, Integer.valueOf(this.frO));
        AppMethodBeat.m2505o(67981);
    }

    public final int acn() {
        return 100;
    }

    /* renamed from: b */
    public final C1206b mo4468b(C1929q c1929q) {
        AppMethodBeat.m2504i(67982);
        C1206b c1206b;
        if (C5046bo.isNullOrNil(this.puz)) {
            C4990ab.m7412e("MicroMsg.NetSceneComposeSend", "securityVerificationChecked failed, content is null");
            c1206b = C1206b.EFailed;
            AppMethodBeat.m2505o(67982);
            return c1206b;
        }
        c1206b = C1206b.EOk;
        AppMethodBeat.m2505o(67982);
        return c1206b;
    }

    /* renamed from: a */
    public final void mo4458a(C1205a c1205a) {
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(67983);
        C4990ab.m7417i("MicroMsg.NetSceneComposeSend", "onGYNetEnd, netId: %d, errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            this.coc = ((C39536f) ((C7472b) c1929q).fsH.fsP).ptx;
            if (this.ehi != null) {
                this.ehi.onSceneEnd(i2, i3, str, this);
            }
            if (this.fEW != null) {
                this.fEW.mo8280a(this.coc, this.frO, this);
            }
            if (this.coc < this.frO) {
                C4990ab.m7417i("MicroMsg.NetSceneComposeSend", "onGYNetEnd, startPos: %d, totalLen: %d, continue to upload", Integer.valueOf(this.coc), Integer.valueOf(this.frO));
                if (mo4456a(this.ftf, this.ehi) < 0) {
                    C4990ab.m7412e("MicroMsg.NetSceneComposeSend", "continue to upload fail");
                    AppMethodBeat.m2505o(67983);
                    return;
                }
            }
            C4990ab.m7416i("MicroMsg.NetSceneComposeSend", "finished upload");
            AppMethodBeat.m2505o(67983);
            return;
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(67983);
    }

    public final int getType() {
        return 485;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(67984);
        this.ehi = c1202f;
        if (C5046bo.isNullOrNil(this.puz)) {
            C4990ab.m7412e("MicroMsg.NetSceneComposeSend", "doScene, sendContent is null");
            AppMethodBeat.m2505o(67984);
            return -1;
        }
        int min = Math.min(this.frO - this.coc, 32768);
        C4990ab.m7417i("MicroMsg.NetSceneComposeSend", "doScene, dataLen: %d", Integer.valueOf(min));
        byte[] bArr = new byte[min];
        byte[] bytes = this.puz.getBytes();
        int i = 0;
        for (int i2 = this.coc; i2 < this.coc + min; i2++) {
            bArr[i] = bytes[i2];
            i++;
        }
        if (C5046bo.m7540cb(bArr)) {
            C4990ab.m7412e("MicroMsg.NetSceneComposeSend", "doScene, sendData is null");
            AppMethodBeat.m2505o(67984);
            return -1;
        }
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C46147e();
        c1196a.fsK = new C39536f();
        c1196a.uri = "/cgi-bin/micromsg-bin/composesend";
        c1196a.fsI = 485;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        C46147e c46147e = (C46147e) this.ehh.fsG.fsP;
        c46147e.ptv = this.clientId;
        c46147e.ptw = this.frO;
        c46147e.ptx = this.coc;
        c46147e.pty = min;
        c46147e.ptA = this.cEV;
        c46147e.ptB = this.puA;
        c46147e.ptC = (int) (((float) this.frO) + (((float) this.puB) * 1.3333334f));
        C4990ab.m7417i("MicroMsg.NetSceneComposeSend", "doScene, realSize: %d", Integer.valueOf(c46147e.ptC));
        c46147e.ptz = C1946aa.m4152ad(bArr);
        C4990ab.m7417i("MicroMsg.NetSceneComposeSend", "doScene, ret: %d", Integer.valueOf(mo4457a(c1902e, this.ehh, this)));
        AppMethodBeat.m2505o(67984);
        return mo4457a(c1902e, this.ehh, this);
    }
}
