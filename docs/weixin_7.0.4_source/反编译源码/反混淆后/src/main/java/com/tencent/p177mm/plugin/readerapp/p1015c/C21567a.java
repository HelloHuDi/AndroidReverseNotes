package com.tencent.p177mm.plugin.readerapp.p1015c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p201az.C6335k;
import com.tencent.p177mm.p201az.C9064g;
import com.tencent.p177mm.p230g.p231a.C18211ag;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3465a;
import com.tencent.p177mm.plugin.readerapp.p1015c.C39565g.C12945a;
import com.tencent.p177mm.protocal.protobuf.bko;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.readerapp.c.a */
final class C21567a extends C4884c<C18211ag> {

    /* renamed from: com.tencent.mm.plugin.readerapp.c.a$1 */
    class C215661 implements C12945a {
        C215661() {
        }

        public final void cdW() {
        }
    }

    C21567a() {
        AppMethodBeat.m2504i(76752);
        this.xxI = C18211ag.class.getName().hashCode();
        AppMethodBeat.m2505o(76752);
    }

    /* renamed from: a */
    private boolean m33019a(C18211ag c18211ag) {
        AppMethodBeat.m2504i(76753);
        if (c18211ag instanceof C18211ag) {
            if (c18211ag.ctc.cte == 0) {
                try {
                    int YK = C1853r.m3829YK() | 262144;
                    C1720g.m3536RP().mo5239Ry().set(34, Integer.valueOf(YK));
                    bko bko = new bko();
                    bko.vCi = 262144;
                    bko.wNJ = 1;
                    ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C3465a(39, bko));
                    ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C6335k("", "", "", "", "", "", "", "", YK, "", ""));
                    C39565g.m67623b(new C215661());
                    C1720g.m3536RP().mo5239Ry().set(40, Integer.valueOf(C1853r.m3824YF() & -33));
                    ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C9064g(21, 2));
                    C4990ab.m7410d("MicroMsg.ReaderAppBindQQ.EventListener", "doClearReaderAppWeiboHelper succ ");
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.ReaderAppBindQQ.EventListener", e, "", new Object[0]);
                }
            }
            AppMethodBeat.m2505o(76753);
            return false;
        }
        C4990ab.m7414f("MicroMsg.ReaderAppBindQQ.EventListener", "not bind qq event");
        AppMethodBeat.m2505o(76753);
        return false;
    }
}
