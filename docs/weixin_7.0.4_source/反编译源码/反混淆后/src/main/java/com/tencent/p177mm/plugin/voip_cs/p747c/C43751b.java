package com.tencent.p177mm.plugin.voip_cs.p747c;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;

/* renamed from: com.tencent.mm.plugin.voip_cs.c.b */
public final class C43751b {
    public C7564ap gyS = new C7564ap(new C71721(), true);
    /* renamed from: sW */
    public TextView f17227sW;
    public int[] sWC;
    public int sWD;
    public int sWE;

    /* renamed from: com.tencent.mm.plugin.voip_cs.c.b$1 */
    class C71721 implements C5015a {
        C71721() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(135437);
            int i = C43751b.this.sWC[C43751b.this.sWE % C43751b.this.sWC.length];
            if (C43751b.this.f17227sW != null) {
                if (-1 == i) {
                    C43751b.this.f17227sW.setText(null);
                } else {
                    C43751b.this.f17227sW.setText(i);
                }
            }
            C43751b c43751b = C43751b.this;
            c43751b.sWE++;
            AppMethodBeat.m2505o(135437);
            return true;
        }
    }

    public C43751b() {
        AppMethodBeat.m2504i(135438);
        AppMethodBeat.m2505o(135438);
    }

    public final void cLc() {
        AppMethodBeat.m2504i(135439);
        if (this.gyS != null) {
            this.gyS.stopTimer();
        }
        C4990ab.m7408b("MicroMsg.DynamicTextWrap", "stop textview: " + this.f17227sW, new Object[0]);
        this.f17227sW = null;
        AppMethodBeat.m2505o(135439);
    }
}
