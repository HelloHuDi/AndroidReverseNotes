package com.tencent.p177mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.ajm;
import com.tencent.p177mm.protocal.protobuf.ajn;
import com.tencent.p177mm.protocal.protobuf.ajo;
import com.tencent.p177mm.protocal.protobuf.ajp;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.exdevice.model.z */
public final class C42999z extends C1207m implements C1918k {
    private C1202f eIc = null;
    private String ltK = "";
    C7472b lty = null;

    public C42999z(LinkedList<ajn> linkedList, String str, String str2) {
        AppMethodBeat.m2504i(19355);
        this.ltK = str2;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new ajo();
        c1196a.fsK = new ajp();
        c1196a.uri = "/cgi-bin/micromsg-bin/getharddeviceoperticket";
        c1196a.fsI = 543;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.lty = c1196a.acD();
        ajo ajo = (ajo) this.lty.fsG.fsP;
        if (!C5046bo.isNullOrNil(str)) {
            ajm ajm = new ajm();
            ajm.vKE = str;
            ajo.wpn = ajm;
        }
        ajo.wpm = linkedList;
        AppMethodBeat.m2505o(19355);
    }

    public final int getType() {
        return 543;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(19356);
        this.eIc = c1202f;
        int a = mo4457a(c1902e, this.lty, this);
        AppMethodBeat.m2505o(19356);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(19357);
        C4990ab.m7417i("MicroMsg.exdevice.NetsceneGetHardDeviceOperTicket", "GetHardDeviceOperTicket onGYNetEnd netId = %s, errType = %s, errCode = %s, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.eIc != null) {
            this.eIc.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(19357);
    }
}
