package com.tencent.p177mm.plugin.backup.p919e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.backup.p342b.C38634d;
import com.tencent.p177mm.protocal.protobuf.C30186gr;
import com.tencent.p177mm.protocal.protobuf.C30187gt;
import com.tencent.p177mm.protocal.protobuf.C7284ua;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.backup.e.b */
public final class C11148b extends C1207m implements C1918k {
    public C7472b ehh;
    protected C1202f ehi;

    public C11148b(LinkedList<C7284ua> linkedList, String str) {
        AppMethodBeat.m2504i(17315);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C30186gr();
        c1196a.fsK = new C30187gt();
        c1196a.uri = "/cgi-bin/micromsg-bin/bakchatcreateqrcode";
        this.ehh = c1196a.acD();
        C30186gr c30186gr = (C30186gr) this.ehh.fsG.fsP;
        c30186gr.vIN = linkedList.size();
        c30186gr.vIO = linkedList;
        c30186gr.vIQ = C1853r.m3846Yz();
        c30186gr.vIP = C1427q.getDeviceID(C4996ah.getContext());
        c30186gr.vIR = str;
        c30186gr.jBP = 0;
        c30186gr.Scene = 2;
        AppMethodBeat.m2505o(17315);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(17316);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(17316);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(17317);
        C4990ab.m7417i("MicroMsg.BackupCreateQRCodeScene", "err: %d, %d, %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            C4990ab.m7417i("MicroMsg.BackupCreateQRCodeScene", "onGYNetEnd QRCodeUrl:%s", ((C30187gt) this.ehh.fsH.fsP).vIU);
            C38634d.m65497ao(r0.vIn.getBuffer().f1226wR);
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(17317);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(17317);
    }

    public final int getType() {
        return 704;
    }
}
