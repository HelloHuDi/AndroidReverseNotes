package com.tencent.p177mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C23413lr;
import com.tencent.p177mm.protocal.protobuf.C44142lq;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.remittance.model.g */
public final class C21644g extends C1207m implements C1918k {
    private C1202f ehi;
    private C7472b gme;
    C44142lq pOK;
    public C23413lr pOL;
    public C43453c pOM;
    public C43454d pON;
    public boolean pOO = false;
    public String pOP = "";
    public boolean pOQ = false;
    public int pOR = 0;

    public C21644g(int i, int i2, int i3, String str, String str2, String str3, String str4, String str5, String str6, int i4, C43453c c43453c, C43454d c43454d) {
        AppMethodBeat.m2504i(44732);
        this.pOP = System.currentTimeMillis() + i;
        C1196a c1196a = new C1196a();
        this.pOR = i;
        c1196a.fsJ = new C44142lq();
        c1196a.fsK = new C23413lr();
        c1196a.fsI = 2677;
        c1196a.uri = "/cgi-bin/mmpay-bin/busif2fgetfavor";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.gme = c1196a.acD();
        this.pOK = (C44142lq) this.gme.fsG.fsP;
        this.pOK.nUf = i;
        this.pOK.cIb = i2;
        this.pOK.pOA = i3;
        this.pOK.vPl = str;
        this.pOK.pPW = str2;
        this.pOK.pOB = str3;
        this.pOK.pPZ = str4;
        this.pOK.vFf = str5;
        this.pOK.pOC = str6;
        this.pOK.vPm = i4;
        this.pOM = c43453c;
        this.pON = c43454d;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.format("request.amount %s", new Object[]{Integer.valueOf(this.pOK.nUf)}));
        stringBuffer.append(String.format("request.channel %s", new Object[]{Integer.valueOf(this.pOK.cIb)}));
        stringBuffer.append(String.format("request.scan_scene %s", new Object[]{Integer.valueOf(this.pOK.pOA)}));
        stringBuffer.append(String.format("request.receiver_desc %s", new Object[]{this.pOK.vPl}));
        stringBuffer.append(String.format("request.mch_name %s", new Object[]{this.pOK.pPW}));
        stringBuffer.append(String.format("request.favor_req_sign %s", new Object[]{this.pOK.pOB}));
        stringBuffer.append(String.format("request.receiver_openid %s", new Object[]{this.pOK.pPZ}));
        stringBuffer.append(String.format("request.receiver_username %s", new Object[]{this.pOK.vFf}));
        stringBuffer.append(String.format("request.favor_req_extend %s", new Object[]{this.pOK.pOC}));
        stringBuffer.append(String.format("request.fail_click_cell %s", new Object[]{Integer.valueOf(this.pOK.vPm)}));
        C4990ab.m7417i("MicroMsg.NetSceneBusiF2fGetFavor", "NetSceneBusiF2fGetFavor req %s", stringBuffer.toString());
        AppMethodBeat.m2505o(44732);
    }

    public final int getType() {
        return 2677;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(44733);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.gme, this);
        AppMethodBeat.m2505o(44733);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(44734);
        C4990ab.m7417i("MicroMsg.NetSceneBusiF2fGetFavor", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.pOL = (C23413lr) ((C7472b) c1929q).fsH.fsP;
        C4990ab.m7417i("MicroMsg.NetSceneBusiF2fGetFavor", "ret_code: %s, ret_msg: %s favor_comm_resp : %s", Integer.valueOf(this.pOL.kdT), this.pOL.kdU, C28868a.m45887a(this.pOL.pOE));
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(44734);
    }
}
