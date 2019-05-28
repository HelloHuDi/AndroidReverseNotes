package com.tencent.p177mm.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C45293b;
import com.tencent.p177mm.compatible.util.C45293b.C32474a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.model.d */
public final class C42192d {
    /* renamed from: Gn */
    private Context f17168Gn = C4996ah.getContext();
    private C45293b cqx;
    private C32474a fko;
    C42190a fkp;
    private boolean fkq = false;

    /* renamed from: com.tencent.mm.model.d$a */
    public interface C42190a {
    }

    /* renamed from: com.tencent.mm.model.d$b */
    class C42191b implements C32474a {
        private C42191b() {
        }

        /* synthetic */ C42191b(C42192d c42192d, byte b) {
            this();
        }

        /* renamed from: gF */
        public final void mo4587gF(int i) {
            AppMethodBeat.m2504i(77794);
            switch (i) {
                case -3:
                    C4990ab.m7418v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK");
                    if (C42192d.this.fkp != null) {
                        AppMethodBeat.m2505o(77794);
                        return;
                    }
                    break;
                case -2:
                    C4990ab.m7418v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS_TRANSIENT");
                    if (C42192d.this.fkp != null) {
                        AppMethodBeat.m2505o(77794);
                        return;
                    }
                    break;
                case -1:
                    C4990ab.m7418v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS");
                    if (C42192d.this.fkp != null) {
                        AppMethodBeat.m2505o(77794);
                        return;
                    }
                    break;
                case 1:
                    C4990ab.m7418v("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_GAIN");
                    if (C42192d.this.fkp != null) {
                        AppMethodBeat.m2505o(77794);
                        return;
                    }
                    break;
                default:
                    C4990ab.m7418v("MicroMsg.AudioHelperTool", "jacks UNKNOW_AUDIOFOCUS_LOSS DEFAULT");
                    break;
            }
            AppMethodBeat.m2505o(77794);
        }
    }

    public C42192d() {
        AppMethodBeat.m2504i(77795);
        AppMethodBeat.m2505o(77795);
    }

    /* renamed from: a */
    public final boolean mo67732a(C42190a c42190a) {
        AppMethodBeat.m2504i(77796);
        this.fkp = c42190a;
        C32474a c42191b = new C42191b(this, (byte) 0);
        if (this.cqx == null) {
            this.cqx = new C45293b(this.f17168Gn);
        }
        if (this.fko != c42191b) {
            this.fko = c42191b;
        }
        this.cqx.mo73179a(this.fko);
        if (this.cqx == null) {
            AppMethodBeat.m2505o(77796);
            return false;
        } else if (this.fkq) {
            AppMethodBeat.m2505o(77796);
            return false;
        } else {
            this.cqx.requestFocus();
            this.fkq = true;
            boolean z = this.fkq;
            AppMethodBeat.m2505o(77796);
            return z;
        }
    }

    /* renamed from: cy */
    public final boolean mo67733cy(boolean z) {
        boolean Mm;
        AppMethodBeat.m2504i(77797);
        if (this.cqx != null) {
            Mm = this.cqx.mo73178Mm();
        } else {
            Mm = false;
        }
        this.fkq = false;
        if (z) {
            this.cqx = null;
            this.fko = null;
            this.fkp = null;
        }
        AppMethodBeat.m2505o(77797);
        return Mm;
    }
}
