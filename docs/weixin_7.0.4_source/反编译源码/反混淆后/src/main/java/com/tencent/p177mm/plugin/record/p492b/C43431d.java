package com.tencent.p177mm.plugin.record.p492b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C30220rh;
import com.tencent.p177mm.protocal.protobuf.C40566ri;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.record.b.d */
public final class C43431d extends C1207m implements C1918k {
    private C7472b ehh;
    private C1202f ehi;
    private C34794a pJk;

    /* renamed from: com.tencent.mm.plugin.record.b.d$a */
    public interface C34794a {
        /* renamed from: ae */
        void mo25043ae(String str, int i, int i2);
    }

    public C43431d(String str, String str2, String str3, int i, C34794a c34794a) {
        AppMethodBeat.m2504i(135642);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C30220rh();
        c1196a.fsK = new C40566ri();
        c1196a.uri = "/cgi-bin/micromsg-bin/checkmd5";
        this.ehh = c1196a.acD();
        C30220rh c30220rh = (C30220rh) this.ehh.fsG.fsP;
        c30220rh.fileid = str;
        c30220rh.cvZ = str2;
        c30220rh.vYy = str3;
        c30220rh.vYz = i;
        this.pJk = c34794a;
        C4990ab.m7417i("MicroMsg.NetSceneCheckMd5", "summersafecdn NetSceneCheckMd5 fileid[%s], md5[%s], newmd5[%s], crc[%d], stack[%s]", c30220rh.fileid, c30220rh.cvZ, c30220rh.vYy, Integer.valueOf(c30220rh.vYz), C5046bo.dpG());
        AppMethodBeat.m2505o(135642);
    }

    public final int getType() {
        return 939;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(135643);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(135643);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(135644);
        C4990ab.m7417i("MicroMsg.NetSceneCheckMd5", "summersafecdn onGYNetEnd [%d, %d, %s]", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        if (this.pJk != null) {
            String str2;
            C34794a c34794a;
            C34794a c34794a2;
            if (i2 == 0 && i3 == 0) {
                C40566ri c40566ri = (C40566ri) ((C7472b) c1929q).fsH.fsP;
                C34794a c34794a3 = this.pJk;
                if (c40566ri != null) {
                    str2 = c40566ri.aeskey;
                    c34794a = c34794a3;
                    c34794a.mo25043ae(str2, i2, i3);
                } else {
                    c34794a2 = c34794a3;
                }
            } else {
                c34794a2 = this.pJk;
            }
            str2 = "";
            c34794a = c34794a2;
            c34794a.mo25043ae(str2, i2, i3);
        }
        AppMethodBeat.m2505o(135644);
    }
}
