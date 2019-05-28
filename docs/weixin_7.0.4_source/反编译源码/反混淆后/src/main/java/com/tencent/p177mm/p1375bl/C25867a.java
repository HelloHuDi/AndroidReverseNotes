package com.tencent.p177mm.p1375bl;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.api.C32248f;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.ajb;
import com.tencent.p177mm.protocal.protobuf.ajc;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.bl.a */
public final class C25867a extends C1207m implements C1918k {
    private C7472b ehh;
    private C1202f ehi = null;
    private ajb gcw;
    public ajc gcx;
    public C32248f gcy;
    private String gcz = null;

    public C25867a(C32248f c32248f) {
        AppMethodBeat.m2504i(35455);
        if (c32248f == null) {
            AppMethodBeat.m2505o(35455);
            return;
        }
        this.gcy = c32248f;
        C4990ab.m7417i("MicroMsg.NetSceneGetFuncMsg", "new NetSceneGetFuncMsg, cgi: %s, cmdId: %s, functionMsgId: %s", c32248f.field_cgi, Integer.valueOf(c32248f.field_cmdid), c32248f.field_functionmsgid);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new ajb();
        c1196a.fsK = new ajc();
        c1196a.fsI = 825;
        c1196a.uri = c32248f.field_cgi;
        c1196a.fsL = c32248f.field_cmdid;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        this.gcw = (ajb) this.ehh.fsG.fsP;
        this.gcw.woV = c32248f.field_functionmsgid;
        if (c32248f.field_custombuff != null) {
            this.gcw.woW = c32248f.field_custombuff;
        }
        this.gcw.woX = c32248f.field_businessInfo;
        AppMethodBeat.m2505o(35455);
    }

    public final int getType() {
        return 825;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(35456);
        if (this.gcy != null) {
            C4990ab.m7417i("MicroMsg.NetSceneGetFuncMsg", "doScene, functionMsgId: %s", this.gcy.field_functionmsgid);
            this.gcy.field_status = 1;
        }
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(35456);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(35457);
        this.gcx = (ajc) ((C7472b) c1929q).fsH.fsP;
        this.gcz = this.gcx.woW;
        C4990ab.m7417i("MicroMsg.NetSceneGetFuncMsg", "onGYNetEnd, errType: %s, errCode: %s, errMsg: %s, opCode: %s, responseCustomBuff==null: %s, response.version: %s", Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(this.gcx.OpCode), Boolean.valueOf(C5046bo.isNullOrNil(this.gcz)), Long.valueOf(this.gcx.woY));
        if (!C5046bo.isNullOrNil(this.gcz)) {
            this.gcw = (ajb) this.ehh.fsG.fsP;
            this.gcw.woW = this.gcz;
        }
        if (i2 == 0 || i3 == 0) {
            C7060h.pYm.mo8378a((long) this.gcy.field_reportid, (long) this.gcy.field_successkey, 1, false);
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(35457);
        } else if (i2 == 4) {
            C4990ab.m7416i("MicroMsg.NetSceneGetFuncMsg", "server error");
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(35457);
        } else {
            C4990ab.m7416i("MicroMsg.NetSceneGetFuncMsg", "onGYNetEnd, local error");
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(35457);
        }
    }
}
