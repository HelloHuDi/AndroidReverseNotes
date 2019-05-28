package com.tencent.p177mm.p612ui.chatting.p616c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C37752ke;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;

/* renamed from: com.tencent.mm.ui.chatting.c.ac */
public class C36128ac extends C44291a implements C5326v {
    private C4884c hAA = new C237111();

    /* renamed from: com.tencent.mm.ui.chatting.c.ac$1 */
    class C237111 extends C4884c<C37752ke> {
        C237111() {
            AppMethodBeat.m2504i(31605);
            this.xxI = C37752ke.class.getName().hashCode();
            AppMethodBeat.m2505o(31605);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(31606);
            switch (((C37752ke) c4883b).cFH.action) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 7:
                    if (C36128ac.this.cgL != null) {
                        C36128ac.this.cgL.aWv();
                        break;
                    }
                    break;
            }
            AppMethodBeat.m2505o(31606);
            return false;
        }
    }

    public C36128ac() {
        AppMethodBeat.m2504i(31607);
        AppMethodBeat.m2505o(31607);
    }

    private void dDi() {
        AppMethodBeat.m2504i(31608);
        C4879a.xxA.mo10053d(this.hAA);
        AppMethodBeat.m2505o(31608);
    }

    public final void dxC() {
        AppMethodBeat.m2504i(31610);
        dDi();
        AppMethodBeat.m2505o(31610);
    }

    public final void dDh() {
        AppMethodBeat.m2504i(31611);
        super.dDh();
        dDi();
        AppMethodBeat.m2505o(31611);
    }

    public final void dxz() {
        AppMethodBeat.m2504i(31609);
        C4879a.xxA.mo10052c(this.hAA);
        AppMethodBeat.m2505o(31609);
    }
}
