package com.tencent.p177mm.plugin.p268aa.p269a.p717c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.p268aa.p269a.C32894d;
import com.tencent.p177mm.plugin.p268aa.p269a.C45486k;
import com.tencent.p177mm.vending.p637c.C24135b;
import com.tencent.p177mm.vending.p641g.C5698f;
import com.tencent.p177mm.vending.p642h.C7368e;
import com.tencent.p177mm.vending.p644j.C7583c;
import com.tencent.p177mm.vending.p644j.C7625d;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.aa.a.c.e */
public class C45485e implements C24135b<C37994d> {
    protected C37994d gmI;
    public final C45484b gmJ;
    public final C9796c gmK;
    public final C37995a gmL;

    /* renamed from: com.tencent.mm.plugin.aa.a.c.e$c */
    public class C9796c implements C7368e<C7625d<Boolean, String, Long>, Map<String, Object>> {
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(40689);
            Map map = (Map) obj;
            C37994d c37994d = C45485e.this.gmI;
            map.put(C45486k.glU, Integer.valueOf(c37994d.zXe.getIntExtra("enter_scene", 1)));
            C5698f.m8557a(C5698f.m8559cU(map).mo15892c(c37994d.gmG.gmc));
            AppMethodBeat.m2505o(40689);
            return null;
        }

        /* renamed from: HZ */
        public final String mo4644HZ() {
            return "Vending.LOGIC";
        }
    }

    /* renamed from: com.tencent.mm.plugin.aa.a.c.e$a */
    public class C37995a implements C7368e<C32894d, Void> {
        /* renamed from: HZ */
        public final String mo4644HZ() {
            return "Vending.LOGIC";
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(40687);
            C5698f.m8557a(C5698f.dMn().mo15892c(C45485e.this.gmI.gmH.glF));
            AppMethodBeat.m2505o(40687);
            return null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.aa.a.c.e$b */
    public class C45484b implements C7368e<Boolean, C7583c<Integer, Map<String, Object>>> {
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(40688);
            C7583c c7583c = (C7583c) obj;
            C37994d c37994d = C45485e.this.gmI;
            int intValue = ((Integer) c7583c.get(0)).intValue();
            Map map = (Map) c7583c.get(1);
            map.put(C45486k.glU, Integer.valueOf(c37994d.zXe.getIntExtra("enter_scene", 1)));
            C5698f.m8557a(C5698f.m8551D(Integer.valueOf(intValue), map).mo15892c(c37994d.gmG.gmb));
            AppMethodBeat.m2505o(40688);
            return null;
        }

        /* renamed from: HZ */
        public final String mo4644HZ() {
            return "Vending.LOGIC";
        }
    }

    public C45485e() {
        this(new C37994d());
        AppMethodBeat.m2504i(40690);
        AppMethodBeat.m2505o(40690);
    }

    private C45485e(C37994d c37994d) {
        AppMethodBeat.m2504i(40691);
        this.gmJ = new C45484b();
        this.gmK = new C9796c();
        this.gmL = new C37995a();
        this.gmI = c37994d;
        AppMethodBeat.m2505o(40691);
    }

    public final /* bridge */ /* synthetic */ Object aog() {
        return this.gmI;
    }
}
