package com.tencent.p177mm.plugin.brandservice.p349ui.timeline;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C37752ke;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;

/* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.d */
public final class C33735d {
    C4884c hAA = new C112411();
    C2697h jNN;

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.d$1 */
    class C112411 extends C4884c<C37752ke> {
        C112411() {
            AppMethodBeat.m2504i(14144);
            this.xxI = C37752ke.class.getName().hashCode();
            AppMethodBeat.m2505o(14144);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(14145);
            switch (((C37752ke) c4883b).cFH.action) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 7:
                    C33735d.this.jNN.aWv();
                    break;
            }
            AppMethodBeat.m2505o(14145);
            return false;
        }
    }

    public C33735d(C2697h c2697h) {
        AppMethodBeat.m2504i(14146);
        this.jNN = c2697h;
        AppMethodBeat.m2505o(14146);
    }
}
