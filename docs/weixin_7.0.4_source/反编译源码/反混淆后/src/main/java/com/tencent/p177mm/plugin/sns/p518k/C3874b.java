package com.tencent.p177mm.plugin.sns.p518k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.vending.p637c.C24135b;
import com.tencent.p177mm.vending.p642h.C7368e;
import com.tencent.p177mm.vending.p644j.C7641e;

/* renamed from: com.tencent.mm.plugin.sns.k.b */
public class C3874b implements C24135b<C34939a> {
    protected C34939a rNo;
    public final C3875a rNp;
    public final C3876b rNq;

    /* renamed from: com.tencent.mm.plugin.sns.k.b$a */
    public class C3875a implements C7368e<Void, C7641e<String, Boolean, Boolean, Integer>> {
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(40539);
            C7641e c7641e = (C7641e) obj;
            C34939a c34939a = C3874b.this.rNo;
            String str = (String) c7641e.get(0);
            ((Boolean) c7641e.get(1)).booleanValue();
            c34939a.mo55526f(str, ((Boolean) c7641e.get(2)).booleanValue(), ((Integer) c7641e.get(3)).intValue());
            Void voidR = zXH;
            AppMethodBeat.m2505o(40539);
            return voidR;
        }

        /* renamed from: HZ */
        public final String mo4644HZ() {
            return "Vending.LOGIC";
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.k.b$b */
    public class C3876b implements C7368e<Void, C7641e<String, Boolean, Boolean, Integer>> {
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(40540);
            C7641e c7641e = (C7641e) obj;
            C34939a c34939a = C3874b.this.rNo;
            String str = (String) c7641e.get(0);
            ((Boolean) c7641e.get(1)).booleanValue();
            c34939a.mo55527g(str, ((Boolean) c7641e.get(2)).booleanValue(), ((Integer) c7641e.get(3)).intValue());
            Void voidR = zXH;
            AppMethodBeat.m2505o(40540);
            return voidR;
        }

        /* renamed from: HZ */
        public final String mo4644HZ() {
            return "Vending.LOGIC";
        }
    }

    public C3874b() {
        this(new C34939a());
        AppMethodBeat.m2504i(40541);
        AppMethodBeat.m2505o(40541);
    }

    private C3874b(C34939a c34939a) {
        AppMethodBeat.m2504i(40542);
        this.rNp = new C3875a();
        this.rNq = new C3876b();
        this.rNo = c34939a;
        AppMethodBeat.m2505o(40542);
    }

    public final C34939a cvE() {
        return this.rNo;
    }

    public final /* bridge */ /* synthetic */ Object aog() {
        return this.rNo;
    }
}
