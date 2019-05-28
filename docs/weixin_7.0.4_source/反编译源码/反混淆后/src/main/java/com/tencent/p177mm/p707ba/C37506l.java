package com.tencent.p177mm.p707ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C32648tu;
import com.tencent.p177mm.p230g.p231a.C37699ci;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.ba.l */
public final class C37506l {
    Map<Integer, Object<?>> fMp = new ConcurrentHashMap();
    public C4884c fMq = new C375071();
    public C4884c fMr = new C375052();

    /* renamed from: com.tencent.mm.ba.l$2 */
    class C375052 extends C4884c<C37699ci> {
        C375052() {
            AppMethodBeat.m2504i(78477);
            this.xxI = C37699ci.class.getName().hashCode();
            AppMethodBeat.m2505o(78477);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(78478);
            C37506l.this.fMp.get(Integer.valueOf(((C37699ci) c4883b).cvy.cvz));
            AppMethodBeat.m2505o(78478);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ba.l$1 */
    class C375071 extends C4884c<C32648tu> {
        C375071() {
            AppMethodBeat.m2504i(78475);
            this.xxI = C32648tu.class.getName().hashCode();
            AppMethodBeat.m2505o(78475);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(78476);
            C37506l.this.fMp.get(Integer.valueOf(((C32648tu) c4883b).cPV.cvz));
            AppMethodBeat.m2505o(78476);
            return false;
        }
    }

    public C37506l() {
        AppMethodBeat.m2504i(78479);
        AppMethodBeat.m2505o(78479);
    }
}
