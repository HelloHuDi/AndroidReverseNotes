package com.tencent.p177mm.p1178ap;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1207m.C1206b;
import com.tencent.p177mm.plugin.appbrand.jsapi.storage.C19482c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C7620bi;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.ap.a */
public final class C17913a extends C1207m implements C1918k {
    private C7620bi csG = new C7620bi();
    private C1202f ehi;
    private C7306ak handler = new C179141();

    /* renamed from: com.tencent.mm.ap.a$1 */
    class C179141 extends C7306ak {
        C179141() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(16437);
            C17913a.this.mo4498a(999, 0, 0, "", null, null);
            AppMethodBeat.m2505o(16437);
        }
    }

    public C17913a(String str, String str2) {
        boolean z = true;
        AppMethodBeat.m2504i(16438);
        this.csG.setStatus(1);
        this.csG.mo14794ju(str);
        this.csG.mo14775eJ(C1829bf.m3756oC(str));
        this.csG.mo14781hO(1);
        this.csG.setContent(str2);
        this.csG.setType(C1855t.m3925nK(str));
        C9638aw.m17190ZK();
        long Z = C18628c.m29080XO().mo15281Z(this.csG);
        if (Z == -1) {
            z = false;
        }
        Assert.assertTrue(z);
        C4990ab.m7416i("MicroMsg.NetSceneSendMsgFake", "new msg inserted to db , local id = ".concat(String.valueOf(Z)));
        AppMethodBeat.m2505o(16438);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(16439);
        this.ehi = c1202f;
        C4990ab.m7416i("MicroMsg.NetSceneSendMsgFake", "send local msg, msgId = " + this.csG.field_msgId);
        this.handler.sendEmptyMessageDelayed(0, 500);
        AppMethodBeat.m2505o(16439);
        return 999;
    }

    public final int getType() {
        return C19482c.CTRL_INDEX;
    }

    /* renamed from: b */
    public final C1206b mo4468b(C1929q c1929q) {
        return C1206b.EOk;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(16440);
        C4990ab.m7416i("MicroMsg.NetSceneSendMsgFake", "recv local msg, msgId = " + this.csG.field_msgId);
        this.csG.setStatus(2);
        this.csG.mo14775eJ(C1829bf.m3764q(this.csG.field_talker, System.currentTimeMillis() / 1000));
        C9638aw.m17190ZK();
        C18628c.m29080XO().mo15284a(this.csG.field_msgId, this.csG);
        this.ehi.onSceneEnd(0, 0, str, this);
        AppMethodBeat.m2505o(16440);
    }
}
