package com.tencent.p177mm.plugin.choosemsgfile.p358b.p722a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.choosemsgfile.compat.MsgFile;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.choosemsgfile.p358b.p359b.C11376a;
import com.tencent.p177mm.plugin.choosemsgfile.p358b.p359b.C17096j;
import com.tencent.p177mm.plugin.choosemsgfile.p358b.p359b.C33814e;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.vending.p639e.C5685b;

/* renamed from: com.tencent.mm.plugin.choosemsgfile.b.a.d */
public final class C11375d extends C6824c {
    /* renamed from: Lp */
    private int f2898Lp = 0;
    private int alq;
    private C7564ap gyS;

    /* renamed from: com.tencent.mm.plugin.choosemsgfile.b.a.d$1 */
    class C113741 implements C5015a {
        C113741() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(54256);
            C11375d.this.f2898Lp = C11375d.this.f2898Lp + 1048576;
            if (C11375d.this.f2898Lp > C11375d.this.alq) {
                C11375d.this.f2898Lp = C11375d.this.alq;
            }
            C11375d.this.mo15099dL(C11375d.this.f2898Lp, C11375d.this.alq);
            if (C11375d.this.f2898Lp == C11375d.this.alq) {
                C11375d.m19137c(C11375d.this);
                C11375d.this.gyS.stopTimer();
                C11375d.this.gyS = null;
            }
            AppMethodBeat.m2505o(54256);
            return true;
        }
    }

    /* renamed from: c */
    static /* synthetic */ void m19137c(C11375d c11375d) {
        AppMethodBeat.m2504i(54261);
        c11375d.m19140wM();
        AppMethodBeat.m2505o(54261);
    }

    public C11375d(C11376a c11376a, C11372a c11372a, C5685b c5685b) {
        super(c11376a, c11372a, c5685b);
        AppMethodBeat.m2504i(54257);
        this.alq = c11376a.bfp();
        AppMethodBeat.m2505o(54257);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean bfh() {
        AppMethodBeat.m2504i(54258);
        if (bfl()) {
            m19140wM();
        }
        boolean bfl = bfl();
        AppMethodBeat.m2505o(54258);
        return bfl;
    }

    private boolean bfl() {
        if (this.ktT instanceof C17096j) {
            return ((C17096j) this.ktT).kuq;
        }
        if (this.ktT instanceof C33814e) {
            return ((C33814e) this.ktT).kuq;
        }
        return false;
    }

    /* renamed from: wM */
    private void m19140wM() {
        AppMethodBeat.m2504i(54260);
        if (bfm()) {
            MsgFile msgFile = new MsgFile();
            msgFile.fileSize = this.ktT.bfp();
            msgFile.filePath = "only for test";
            msgFile.fileName = this.ktT.getFileName() + "." + msgFile.eov;
            msgFile.type = "file";
            msgFile.eov = this.ktT.bfo();
            msgFile.timeStamp = this.ktT.getTimeStamp();
            mo15093b(msgFile);
            AppMethodBeat.m2505o(54260);
            return;
        }
        bfk();
        AppMethodBeat.m2505o(54260);
    }

    private boolean bfm() {
        if (this.ktT instanceof C17096j) {
            return ((C17096j) this.ktT).kus;
        }
        if (this.ktT instanceof C33814e) {
            return ((C33814e) this.ktT).kus;
        }
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean checkValid() {
        if (this.ktT instanceof C17096j) {
            return ((C17096j) this.ktT).kup;
        }
        if (this.ktT instanceof C33814e) {
            return ((C33814e) this.ktT).kup;
        }
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final void bfi() {
        boolean z;
        AppMethodBeat.m2504i(54259);
        if (this.ktT instanceof C17096j) {
            z = ((C17096j) this.ktT).kur;
        } else if (this.ktT instanceof C33814e) {
            z = ((C33814e) this.ktT).kur;
        } else {
            z = false;
        }
        if (z) {
            long j;
            if (this.gyS == null) {
                this.gyS = new C7564ap(C1720g.m3539RS().oAl.getLooper(), new C113741(), true);
            }
            C7564ap c7564ap = this.gyS;
            if (this.ktT instanceof C17096j) {
                j = ((C17096j) this.ktT).kut;
            } else if (this.ktT instanceof C33814e) {
                j = ((C33814e) this.ktT).kut;
            } else {
                j = 1000;
            }
            c7564ap.mo16770ae(j, j);
            AppMethodBeat.m2505o(54259);
            return;
        }
        m19140wM();
        AppMethodBeat.m2505o(54259);
    }
}
