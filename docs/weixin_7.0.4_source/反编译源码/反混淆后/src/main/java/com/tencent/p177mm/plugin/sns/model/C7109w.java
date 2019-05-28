package com.tencent.p177mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.sns.storage.C13479t;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.protocal.protobuf.cbz;
import com.tencent.p177mm.protocal.protobuf.ccc;
import com.tencent.p177mm.protocal.protobuf.ccd;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.sns.model.w */
public final class C7109w extends C1207m implements C1918k {
    private int czE;
    private C7472b ehh;
    public C1202f ehi;
    private long qJP;
    private int scene = 0;

    public C7109w(int i, long j, String str, int i2, List<String> list, int i3) {
        AppMethodBeat.m2504i(36330);
        C4990ab.m7410d("MicroMsg.NetSceneSnsTagMemberOption", "opCode " + i + " tagName " + str + " memberList " + list.size() + " scene " + i3);
        this.czE = i;
        this.qJP = j;
        this.scene = i3;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new ccc();
        c1196a.fsK = new ccd();
        c1196a.uri = "/cgi-bin/micromsg-bin/mmsnstagmemberoption";
        c1196a.fsI = 291;
        c1196a.fsL = 115;
        c1196a.fsM = 1000000115;
        this.ehh = c1196a.acD();
        ccc ccc = (ccc) this.ehh.fsG.fsP;
        ccc.OpCode = i;
        ccc.xbt = j;
        ccc.ncF = str;
        ccc.jBv = i2;
        ccc.Scene = this.scene;
        LinkedList linkedList = new LinkedList();
        for (String alV : list) {
            linkedList.add(new bts().alV(alV));
        }
        ccc.jBw = linkedList;
        C4990ab.m7410d("MicroMsg.NetSceneSnsTagMemberOption", "rr.req.rImpl " + ccc.toString());
        AppMethodBeat.m2505o(36330);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(36331);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(36331);
        return a;
    }

    public final int getType() {
        return 291;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(36332);
        C4990ab.m7410d("MicroMsg.NetSceneSnsTagMemberOption", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            cbz cbz = ((ccd) ((C7472b) c1929q).fsH.fsP).xbv;
            C4990ab.m7410d("MicroMsg.NetSceneSnsTagMemberOption", "Resp.rImpl " + cbz.toString());
            C13479t kF = C13373af.cnL().mo55579kF(cbz.xbt);
            kF.field_tagId = cbz.xbt;
            kF.field_tagName = C5046bo.m7532bc(cbz.ncF, "");
            switch (this.czE) {
                case 1:
                case 2:
                case 3:
                    kF.field_count = cbz.jBv;
                    kF.mo25636do(cbz.jBw);
                    break;
            }
            C13373af.cnL().mo55576a(kF);
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(36332);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(36332);
    }
}
