package com.tencent.p177mm.plugin.p268aa.p269a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.vending.p637c.C24135b;
import com.tencent.p177mm.vending.p642h.C7368e;
import com.tencent.p177mm.vending.p644j.C7583c;
import com.tencent.p177mm.vending.p644j.C7625d;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.aa.a.l */
public final class C38004l implements C24135b<C45486k> {
    protected C45486k gma;
    public final C38005a gmb;
    public final C38006b gmc;

    /* renamed from: com.tencent.mm.plugin.aa.a.l$a */
    public class C38005a implements C7368e<Boolean, C7583c<Integer, Map<String, Object>>> {
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(40635);
            C7583c c7583c = (C7583c) obj;
            C38004l.this.gma.mo73276c(((Integer) c7583c.get(0)).intValue(), (Map) c7583c.get(1));
            AppMethodBeat.m2505o(40635);
            return null;
        }

        /* renamed from: HZ */
        public final String mo4644HZ() {
            return "Vending.LOGIC";
        }
    }

    /* renamed from: com.tencent.mm.plugin.aa.a.l$b */
    public class C38006b implements C7368e<C7625d<Boolean, String, Long>, Map<String, Object>> {
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(40636);
            C38004l.this.gma.mo73277r((Map) obj);
            AppMethodBeat.m2505o(40636);
            return null;
        }

        /* renamed from: HZ */
        public final String mo4644HZ() {
            return "Vending.LOGIC";
        }
    }

    public C38004l() {
        this(new C45486k());
        AppMethodBeat.m2504i(40637);
        AppMethodBeat.m2505o(40637);
    }

    private C38004l(C45486k c45486k) {
        AppMethodBeat.m2504i(40638);
        this.gmb = new C38005a();
        this.gmc = new C38006b();
        this.gma = c45486k;
        AppMethodBeat.m2505o(40638);
    }

    public final C45486k aop() {
        return this.gma;
    }

    public final /* bridge */ /* synthetic */ Object aog() {
        return this.gma;
    }
}
