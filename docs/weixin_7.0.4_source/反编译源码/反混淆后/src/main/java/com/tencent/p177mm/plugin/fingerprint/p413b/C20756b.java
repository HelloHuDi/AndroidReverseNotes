package com.tencent.p177mm.plugin.fingerprint.p413b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C26096bt;
import com.tencent.p177mm.p230g.p231a.C26096bt.C18230b;
import com.tencent.p177mm.plugin.fingerprint.p1261c.C43098d;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.fingerprint.b.b */
public final class C20756b extends C4884c<C26096bt> implements C1202f {
    private C26096bt mrt;
    private boolean mru;

    public C20756b() {
        AppMethodBeat.m2504i(41425);
        this.mru = false;
        this.xxI = C26096bt.class.getName().hashCode();
        AppMethodBeat.m2505o(41425);
    }

    /* renamed from: a */
    private boolean m31983a(C26096bt c26096bt) {
        AppMethodBeat.m2504i(41426);
        if (C1720g.m3531RK()) {
            this.mru = false;
            if (c26096bt instanceof C26096bt) {
                this.mrt = c26096bt;
                C4990ab.m7416i("MicroMsg.CloseFingerPrintEventListener", "handle CloseFingerPrintEvent");
                C1720g.m3537RQ();
                C1720g.m3535RO().eJo.mo14539a(385, (C1202f) this);
                C1207m c43098d = new C43098d(c26096bt.cuS.cuU);
                C1720g.m3537RQ();
                C1720g.m3535RO().eJo.mo14541a(c43098d, 0);
                AppMethodBeat.m2505o(41426);
                return true;
            }
            AppMethodBeat.m2505o(41426);
            return false;
        }
        C4990ab.m7412e("MicroMsg.CloseFingerPrintEventListener", "CloseFingerPrintEvent account is not ready");
        AppMethodBeat.m2505o(41426);
        return false;
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(41427);
        if (c1207m instanceof C43098d) {
            C18230b c18230b = new C18230b();
            C4990ab.m7416i("MicroMsg.CloseFingerPrintEventListener", "NetSceneTenpayCloseTouchPay doscene return errcode " + i2 + " errmsg" + str);
            if (i == 0 && i2 == 0) {
                C4990ab.m7416i("MicroMsg.CloseFingerPrintEventListener", "NetSceneTenpayCloseTouchPay doscene is success");
                c18230b.retCode = 0;
            } else {
                C4990ab.m7416i("MicroMsg.CloseFingerPrintEventListener", "NetSceneTenpayCloseTouchPay doscene is fail");
                c18230b.retCode = i2;
            }
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14546b(385, (C1202f) this);
            this.mrt.cuT = c18230b;
            this.mru = true;
            if (this.mrt.callback != null) {
                this.mrt.callback.run();
            }
            if (this.mru) {
                this.mrt = null;
            }
        }
        AppMethodBeat.m2505o(41427);
    }
}
