package com.tencent.p177mm.plugin.p1014q;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1207m.C1206b;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C46534dv;
import com.tencent.p177mm.protocal.protobuf.bwb;
import com.tencent.p177mm.protocal.protobuf.bwc;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.q.e */
public final class C39532e extends C1207m implements C1918k {
    private String aeskey;
    private String ecX;
    private C7472b ehh;
    private C1202f ehi;
    private String fileId;
    private int oFD;
    private String oFE;
    private String oFF;

    public C39532e(String str, String str2, int i, String str3, String str4, String str5) {
        AppMethodBeat.m2504i(22900);
        this.fileId = str;
        this.aeskey = str2;
        this.oFD = i;
        this.ecX = str3;
        this.oFE = str4;
        this.oFF = str5;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bwb();
        c1196a.fsK = new bwc();
        c1196a.uri = "/cgi-bin/micromsg-bin/sendappmsg";
        this.ehh = c1196a.acD();
        C4990ab.m7417i("MicroMsg.MsgSynchronizeSendAppMsgNetScene", "MsgSynchronizeSendAppMsgNetScene action[%s], messagaction[%s], fileId[%s], fileLen[%d], selfName[%s], stack[%s]", str4, this.oFE, str, Integer.valueOf(i), str3, C5046bo.dpG());
        AppMethodBeat.m2505o(22900);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(22901);
        this.ehi = c1202f;
        C8910b c8910b = new C8910b();
        c8910b.title = "ChatSync";
        c8910b.description = "ChatSync";
        c8910b.type = 35;
        c8910b.url = this.fileId;
        c8910b.eyr = this.aeskey;
        c8910b.fgK = this.aeskey;
        c8910b.fgo = this.oFD;
        c8910b.fgK = this.aeskey;
        c8910b.showType = 0;
        c8910b.action = "phone";
        c8910b.messageAction = this.oFE;
        c8910b.extInfo = "supportAfterSleep,supportGetMore";
        c8910b.content = this.oFF;
        bwb bwb = (bwb) this.ehh.fsG.fsP;
        C46534dv c46534dv = new C46534dv();
        c46534dv.ndG = this.ecX;
        c46534dv.vFE = c8910b.sdkVer;
        c46534dv.jCt = 35;
        c46534dv.ndF = this.ecX;
        c46534dv.ncM = C8910b.m16062a(c8910b, null, null, 0, 0);
        c46534dv.pcX = (int) C5046bo.anT();
        bwb.wWQ = c46534dv;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(22901);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(22902);
        C4990ab.m7417i("MicroMsg.MsgSynchronizeSendAppMsgNetScene", "msgSynchronize sendAppMsg onGYNetEnd. [%d,%d,%s]", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(22902);
    }

    public final int getType() {
        return 222;
    }

    /* renamed from: b */
    public final C1206b mo4468b(C1929q c1929q) {
        return C1206b.EOk;
    }
}
