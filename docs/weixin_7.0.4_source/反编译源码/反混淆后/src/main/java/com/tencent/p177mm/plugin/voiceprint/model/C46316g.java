package com.tencent.p177mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C18615ba.C18616a;
import com.tencent.p177mm.model.C18615ba.C18617b;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelsimple.C18674i;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1207m.C1205a;
import com.tencent.p177mm.p183ai.C1207m.C1206b;
import com.tencent.p177mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45580bd;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.voiceprint.model.g */
public final class C46316g extends C1207m implements C1918k {
    C1202f ehi;
    private final C1929q ftU = new C35341a();
    String sKW = "";
    int sKX = 0;
    private String sKY = "";

    public C46316g(String str) {
        AppMethodBeat.m2504i(26092);
        C18616a c18616a = (C18616a) this.ftU.acF();
        C4990ab.m7417i("MicroMsg.NetSceneRsaGetVoicePrintResource", "sceneType %d %s", Integer.valueOf(73), str);
        c18616a.flW.wub = 73;
        c18616a.flW.wuc = str;
        AppMethodBeat.m2505o(26092);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(26093);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ftU, this);
        AppMethodBeat.m2505o(26093);
        return a;
    }

    public final int getType() {
        return C45580bd.CTRL_INDEX;
    }

    public final int acn() {
        return 3;
    }

    /* renamed from: b */
    public final C1206b mo4468b(C1929q c1929q) {
        return C1206b.EOk;
    }

    /* renamed from: a */
    public final void mo4458a(C1205a c1205a) {
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(26094);
        C4990ab.m7410d("MicroMsg.NetSceneRsaGetVoicePrintResource", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        C18617b c18617b = (C18617b) c1929q.mo5618ZS();
        if (i2 == 4 && i3 == ZipJNI.UNZ_PARAMERROR) {
            final int i4 = c1929q.acF().vyj.ver;
            C4990ab.m7411d("MicroMsg.NetSceneRsaGetVoicePrintResource", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", Integer.valueOf(i4));
            C9638aw.m17180RS().mo10302aa(new Runnable() {

                /* renamed from: com.tencent.mm.plugin.voiceprint.model.g$1$1 */
                class C42661 implements C1202f {
                    C42661() {
                    }

                    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                        AppMethodBeat.m2504i(26090);
                        C4990ab.m7411d("MicroMsg.NetSceneRsaGetVoicePrintResource", "summerauth dkcert getcert type:%d ret [%d,%d]", Integer.valueOf(c1207m.getType()), Integer.valueOf(i), Integer.valueOf(i2));
                        if (i == 0 && i2 == 0) {
                            C46316g.this.mo4456a(C46316g.this.ftf, C46316g.this.ehi);
                            AppMethodBeat.m2505o(26090);
                            return;
                        }
                        C46316g.this.ehi.onSceneEnd(i, i2, "", C46316g.this);
                        AppMethodBeat.m2505o(26090);
                    }
                }

                public final void run() {
                    AppMethodBeat.m2504i(26091);
                    new C18674i().mo4456a(C46316g.this.ftf, new C42661());
                    AppMethodBeat.m2505o(26091);
                }
            });
            AppMethodBeat.m2505o(26094);
        } else if (i2 == 0 || i3 == 0) {
            if (c18617b.flX.wud != null) {
                this.sKW = new String(c18617b.flX.wud.wVc.getBufferToBytes());
                this.sKX = c18617b.flX.wud.wTu;
                C4990ab.m7411d("MicroMsg.NetSceneRsaGetVoicePrintResource", "resid %d mVertifyKey %s mtext %s", Integer.valueOf(this.sKX), this.sKY, this.sKW);
            } else {
                C4990ab.m7412e("MicroMsg.NetSceneRsaGetVoicePrintResource", "resp ResourceData null ");
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(26094);
        } else {
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(26094);
        }
    }
}
