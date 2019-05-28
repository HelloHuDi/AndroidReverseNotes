package com.tencent.p177mm.memory.p259a.p260a.p261a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.memory.p259a.p260a.p261a.C1795b.C1793a;
import com.tencent.p177mm.memory.p259a.p260a.p261a.C1795b.C1794b;
import com.tencent.p177mm.p178a.C1177f.C1175b;
import com.tencent.p177mm.p178a.C1177f.C1176c;
import com.tencent.p177mm.p178a.C6294h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.wcdb.database.SQLiteGlobal;

/* renamed from: com.tencent.mm.memory.a.a.a.f */
public abstract class C6661f<T, V extends C1798c<T>> implements C1799d<T, V> {
    C6294h<T, V> feI;
    C1795b<T, V> feJ = null;
    C1175b<T, V> feK;
    C1176c<T, V> feL;
    C1792a fem = null;

    /* renamed from: com.tencent.mm.memory.a.a.a.f$1 */
    class C66571 implements C1175b<T, V> {
        C66571() {
        }

        /* renamed from: c */
        public final /* synthetic */ void mo4401c(Object obj, Object obj2, Object obj3) {
            AppMethodBeat.m2504i(115468);
            C1798c c1798c = (C1798c) obj2;
            C1798c c1798c2 = (C1798c) obj3;
            if (c1798c != null) {
                if (C6661f.this.feJ.mo5355q(c1798c.mo5356Xp(), c1798c.mo5357Xq())) {
                    if (C1792a.feq) {
                        C4990ab.m7417i("MicroMsg.UsageLruMap", "implMap RemoveCallback in extraLruMap businessKey:%s key:%s size:%s", r0, r1, C5046bo.m7565ga((long) C6661f.this.feI.size()));
                    }
                    AppMethodBeat.m2505o(115468);
                    return;
                }
            }
            if (C6661f.this.feK != null) {
                C4990ab.m7417i("MicroMsg.UsageLruMap", "implMap RemoveCallback not in extraLruMap key:%s size:%s", obj, C5046bo.m7565ga((long) C6661f.this.feI.size()));
                C6661f.this.feK.mo4401c(obj, c1798c, c1798c2);
            }
            AppMethodBeat.m2505o(115468);
        }
    }

    /* renamed from: com.tencent.mm.memory.a.a.a.f$2 */
    class C66582 implements C1176c<T, V> {
        C66582() {
        }

        /* renamed from: l */
        public final /* bridge */ /* synthetic */ int mo4402l(Object obj, Object obj2) {
            AppMethodBeat.m2504i(115469);
            C1798c c1798c = (C1798c) obj2;
            if (C6661f.this.feL != null) {
                int l = C6661f.this.feL.mo4402l(obj, c1798c);
                AppMethodBeat.m2505o(115469);
                return l;
            }
            AppMethodBeat.m2505o(115469);
            return SQLiteGlobal.journalSizeLimit;
        }
    }

    /* renamed from: com.tencent.mm.memory.a.a.a.f$3 */
    class C66593 implements C1793a<T, V> {
        C66593() {
        }

        /* renamed from: r */
        public final /* synthetic */ void mo5352r(Object obj, Object obj2) {
            AppMethodBeat.m2504i(115470);
            Object p = C6661f.this.mo5372p(obj, obj2);
            if (!C6661f.this.feI.mo10274aj(p)) {
                C6661f.this.feI.remove(p);
            }
            AppMethodBeat.m2505o(115470);
        }
    }

    /* renamed from: com.tencent.mm.memory.a.a.a.f$4 */
    class C66604 implements C1794b<T, V> {
        C66604() {
        }

        /* renamed from: d */
        public final /* synthetic */ int mo5353d(Object obj, Object obj2, Object obj3) {
            AppMethodBeat.m2504i(115471);
            C1798c c1798c = (C1798c) obj3;
            if (C6661f.this.feL != null) {
                int l = C6661f.this.feL.mo4402l(C6661f.this.mo5372p(obj, obj2), c1798c);
                AppMethodBeat.m2505o(115471);
                return l;
            }
            AppMethodBeat.m2505o(115471);
            return SQLiteGlobal.journalSizeLimit;
        }
    }

    /* renamed from: p */
    public abstract T mo5372p(T t, T t2);

    /* renamed from: e */
    public final /* synthetic */ void mo5358e(Object obj, Object obj2, Object obj3) {
        C1798c c1798c = (C1798c) obj3;
        if (C1792a.feq) {
            C4990ab.m7417i("MicroMsg.UsageLruMap", "update businessKey:%s key:%s size:%s maxSize:%s", obj, obj2, C5046bo.m7565ga((long) this.feI.size()), C5046bo.m7565ga((long) this.feI.maxSize()));
        }
        this.feI.mo4412k(mo5372p(obj, obj2), c1798c);
        this.feJ.mo5354aY(obj).mo4412k(obj2, c1798c);
    }

    /* renamed from: f */
    public final /* synthetic */ Object mo5359f(Object obj, Object obj2, Object obj3) {
        C1798c c1798c = (C1798c) obj3;
        if (C1792a.feq) {
            C4990ab.m7417i("MicroMsg.UsageLruMap", "put businessKey:%s key:%s size:%s maxSize:%s", obj, obj2, C5046bo.m7565ga((long) this.feI.size()), C5046bo.m7565ga((long) this.feI.maxSize()));
        }
        C1798c c1798c2 = (C1798c) this.feI.put(mo5372p(obj, obj2), c1798c);
        C1798c c1798c3 = (C1798c) this.feJ.mo5354aY(obj).put(obj2, c1798c);
        if (c1798c2 == null) {
            return c1798c3;
        }
        return c1798c2;
    }

    public C6661f(C1792a c1792a, C1175b<T, V> c1175b, C1176c<T, V> c1176c) {
        this.fem = c1792a;
        this.feK = c1175b;
        this.feL = c1176c;
        this.feI = new C6294h(this.fem.fer, new C66571(), new C66582());
        this.feJ = new C1795b(this.fem, new C66593(), new C66604());
    }

    /* renamed from: q */
    public final boolean mo5360q(T t, T t2) {
        return this.feI.mo10274aj(mo5372p(t, t2)) || this.feJ.mo5355q(t, t2);
    }

    /* renamed from: v */
    public final boolean mo5366v(T t, T t2) {
        return this.feI.mo10275ak(mo5372p(t, t2)) || this.feJ.mo5354aY(t).mo4406ak(t2);
    }

    public final void trimToSize(int i) {
        this.feI.trimToSize(i);
    }

    public final int size() {
        return this.feI.size();
    }

    /* renamed from: u */
    public final /* synthetic */ Object mo5365u(Object obj, Object obj2) {
        C1798c c1798c = (C1798c) this.feI.mo4404ai(mo5372p(obj, obj2));
        C1798c c1798c2 = (C1798c) this.feJ.mo5354aY(obj).mo4404ai(obj2);
        if (c1798c == null) {
            return c1798c2;
        }
        return c1798c;
    }

    /* renamed from: t */
    public final /* synthetic */ Object mo5363t(Object obj, Object obj2) {
        C1798c c1798c = (C1798c) this.feI.get(mo5372p(obj, obj2));
        C1798c c1798c2 = (C1798c) this.feJ.mo5354aY(obj).get(obj2);
        if (c1798c == null) {
            return c1798c2;
        }
        return c1798c;
    }

    /* renamed from: s */
    public final /* synthetic */ Object mo5361s(Object obj, Object obj2) {
        C1798c c1798c = (C1798c) this.feI.remove(mo5372p(obj, obj2));
        C1798c c1798c2 = (C1798c) this.feJ.mo5354aY(obj).remove(obj2);
        if (c1798c == null) {
            return c1798c2;
        }
        return c1798c;
    }
}
