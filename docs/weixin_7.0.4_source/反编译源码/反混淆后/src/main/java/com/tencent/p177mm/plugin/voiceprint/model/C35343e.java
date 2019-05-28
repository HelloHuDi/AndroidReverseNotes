package com.tencent.p177mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C7484ax;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.model.C9647bb.C9648a;
import com.tencent.p177mm.model.C9647bb.C9649b;
import com.tencent.p177mm.modelsimple.C18674i;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1207m.C1205a;
import com.tencent.p177mm.p183ai.C1207m.C1206b;
import com.tencent.p177mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45579bb;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.voiceprint.model.e */
public final class C35343e extends C1207m implements C1918k {
    C1202f ehi;
    String elr = "";
    private final C1929q ftU = new C40015b();
    private int ftx = 2;

    public C35343e(String str) {
        AppMethodBeat.m2504i(26083);
        C9648a c9648a = (C9648a) this.ftU.acF();
        c9648a.flY.jBB = str;
        c9648a.flY.wue = 1;
        C4990ab.m7417i("MicroMsg.NetSceneGetVoiceprintTicketRsa", "sceneType %d %s", Integer.valueOf(1), str);
        AppMethodBeat.m2505o(26083);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(26084);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ftU, this);
        AppMethodBeat.m2505o(26084);
        return a;
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

    public final int getType() {
        return C45579bb.CTRL_INDEX;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(26085);
        C9649b c9649b = (C9649b) c1929q.mo5618ZS();
        this.elr = c9649b.flZ.wuf;
        C4990ab.m7410d("MicroMsg.NetSceneGetVoiceprintTicketRsa", "onGYNetEnd  errType:" + i2 + " errCode:" + i3 + " mTicket: " + this.elr);
        if (i2 == 4 && i3 == -301) {
            C7484ax.m12918a(true, c9649b.flZ.vLL, c9649b.flZ.vLM, c9649b.flZ.vLK);
            this.ftx--;
            if (this.ftx <= 0) {
                C4990ab.m7410d("MicroMsg.NetSceneGetVoiceprintTicketRsa", "reach redirect limit, invoke callback");
                this.ehi.onSceneEnd(3, -1, "", this);
                AppMethodBeat.m2505o(26085);
                return;
            }
            C4990ab.m7410d("MicroMsg.NetSceneGetVoiceprintTicketRsa", "redirect IDC");
            mo4456a(this.ftf, this.ehi);
            AppMethodBeat.m2505o(26085);
        } else if (i2 == 4 && i3 == ZipJNI.UNZ_PARAMERROR) {
            final int i4 = c1929q.acF().vyj.ver;
            C4990ab.m7411d("MicroMsg.NetSceneGetVoiceprintTicketRsa", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", Integer.valueOf(i4));
            C9638aw.m17180RS().mo10302aa(new Runnable() {

                /* renamed from: com.tencent.mm.plugin.voiceprint.model.e$1$1 */
                class C353421 implements C1202f {
                    C353421() {
                    }

                    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                        AppMethodBeat.m2504i(26081);
                        C4990ab.m7411d("MicroMsg.NetSceneGetVoiceprintTicketRsa", "summerauth dkcert getcert type:%d ret [%d,%d]", Integer.valueOf(c1207m.getType()), Integer.valueOf(i), Integer.valueOf(i2));
                        if (i == 0 && i2 == 0) {
                            C35343e.this.mo4456a(C35343e.this.ftf, C35343e.this.ehi);
                            AppMethodBeat.m2505o(26081);
                            return;
                        }
                        C35343e.this.ehi.onSceneEnd(i, i2, "", C35343e.this);
                        AppMethodBeat.m2505o(26081);
                    }
                }

                public final void run() {
                    AppMethodBeat.m2504i(26082);
                    new C18674i().mo4456a(C35343e.this.ftf, new C353421());
                    AppMethodBeat.m2505o(26082);
                }
            });
            AppMethodBeat.m2505o(26085);
        } else if (i2 == 0 || i3 == 0) {
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(26085);
        } else {
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(26085);
        }
    }
}
