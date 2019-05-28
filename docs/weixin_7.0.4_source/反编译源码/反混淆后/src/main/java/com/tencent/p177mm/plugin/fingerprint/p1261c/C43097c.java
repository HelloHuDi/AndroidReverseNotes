package com.tencent.p177mm.plugin.fingerprint.p1261c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.soter.p527b.C35149d;
import com.tencent.p177mm.plugin.soter.p528d.C13720d;
import com.tencent.p177mm.protocal.protobuf.ccu;
import com.tencent.p177mm.protocal.protobuf.ccv;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.soter.p663a.p1108f.C24291b;
import com.tencent.soter.p663a.p1108f.C30958e;
import com.tencent.soter.p663a.p1108f.C30958e.C16168a;
import com.tencent.soter.p663a.p1108f.C30958e.C30959b;
import com.tenpay.android.wechat.TenpayUtil;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.fingerprint.c.c */
public final class C43097c extends C35149d implements C1918k, C30958e {
    private int cOi;
    public C7472b ehh;
    private C1202f ehi;
    private String gHr = null;
    private int msp;
    private C24291b<C30959b> msq = null;

    /* renamed from: bR */
    public final /* synthetic */ void mo55795bR(Object obj) {
        AppMethodBeat.m2504i(41583);
        C16168a c16168a = (C16168a) obj;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new ccu();
        c1196a.fsK = new ccv();
        c1196a.uri = "/cgi-bin/mmpay-bin/soterupdateauthkey";
        c1196a.fsI = 1665;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        ccu ccu = (ccu) this.ehh.fsG.fsP;
        ccu.xcb = this.gHr;
        ccu.xcc = c16168a.AvZ;
        ccu.xcd = c16168a.Awa;
        ccu.cDo = TenpayUtil.signWith3Des("passwd=" + ccu.xcb);
        ccu.xbY = this.msp;
        ccu.xbZ = this.cOi;
        try {
            JSONObject jSONObject = new JSONObject(c16168a.AvZ);
            C13720d.m21910gu(jSONObject.getString("cpu_id"), jSONObject.getString("uid"));
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.NetSceneSoterPayUploadAuthKeyManually", e, "save device info exception", new Object[0]);
        }
        C4990ab.m7417i("MicroMsg.NetSceneSoterPayUploadAuthKeyManually", "json: %s, sign: %s", c16168a.AvZ, c16168a.Awa);
        AppMethodBeat.m2505o(41583);
    }

    public C43097c(String str, int i) {
        this.gHr = str;
        this.msp = i;
        this.cOi = i;
    }

    public final int getType() {
        return 1665;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(41578);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(41578);
        return a;
    }

    /* renamed from: d */
    public final void mo55792d(int i, int i2, String str, C1929q c1929q) {
        AppMethodBeat.m2504i(41579);
        C4990ab.m7411d("MicroMsg.NetSceneSoterPayUploadAuthKeyManually", "onGYNetEnd errType: %d , errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        if (this.msq != null) {
            if (i == 0 && i2 == 0) {
                this.msq.mo40382dd(new C30959b(true));
                AppMethodBeat.m2505o(41579);
                return;
            }
            this.msq.mo40382dd(new C30959b(false));
        }
        AppMethodBeat.m2505o(41579);
    }

    public final void bxO() {
        AppMethodBeat.m2504i(41580);
        C4990ab.m7416i("MicroMsg.NetSceneSoterPayUploadAuthKeyManually", "hy: authkey required");
        if (this.ehi != null) {
            this.ehi.onSceneEnd(4, -1, "", this);
        }
        if (this.msq != null) {
            C4990ab.m7412e("MicroMsg.NetSceneSoterPayUploadAuthKeyManually", "alvinluo pay auth key expired when upload pay auth key");
            this.msq.mo40382dd(new C30959b(false));
        }
        AppMethodBeat.m2505o(41580);
    }

    /* renamed from: vL */
    public final void mo55793vL(int i) {
        AppMethodBeat.m2504i(41581);
        C4990ab.m7417i("MicroMsg.NetSceneSoterPayUploadAuthKeyManually", "hy: onError: errType: %d, errcode: %d", Integer.valueOf(3), Integer.valueOf(i));
        if (this.ehi != null) {
            this.ehi.onSceneEnd(4, -1, "", this);
        }
        AppMethodBeat.m2505o(41581);
    }

    public final void execute() {
        AppMethodBeat.m2504i(41582);
        C1720g.m3540Rg().mo14541a((C1207m) this, 0);
        AppMethodBeat.m2505o(41582);
    }

    /* renamed from: a */
    public final void mo55794a(C24291b<C30959b> c24291b) {
        this.msq = c24291b;
    }
}
