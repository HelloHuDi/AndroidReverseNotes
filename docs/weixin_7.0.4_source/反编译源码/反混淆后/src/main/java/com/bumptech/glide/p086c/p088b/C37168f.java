package com.bumptech.glide.p086c.p088b;

import com.bumptech.glide.C37191e;
import com.bumptech.glide.C37192g;
import com.bumptech.glide.p086c.C0779h;
import com.bumptech.glide.p086c.C31967j;
import com.bumptech.glide.p086c.C31970m;
import com.bumptech.glide.p086c.p088b.C36671g.C31936d;
import com.bumptech.glide.p086c.p088b.p785b.C31932a;
import com.bumptech.glide.p086c.p090c.C37175n;
import com.bumptech.glide.p086c.p090c.C37175n.C37176a;
import com.bumptech.glide.p086c.p092d.C37182b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.bumptech.glide.c.b.f */
final class C37168f<Transcode> {
    C0779h aAb;
    C31967j aAd;
    private final List<C37176a<?>> aAe = new ArrayList();
    Class<?> aAf;
    C31936d aAg;
    Map<Class<?>, C31970m<?>> aAh;
    private boolean aAi;
    private boolean aAj;
    C37192g aAk;
    C31938i aAl;
    boolean aAm;
    boolean aAn;
    Class<Transcode> awY;
    C37191e awi;
    Object axb;
    private final List<C0779h> azS = new ArrayList();
    int height;
    int width;

    C37168f() {
        AppMethodBeat.m2504i(91763);
        AppMethodBeat.m2505o(91763);
    }

    /* Access modifiers changed, original: final */
    public final void clear() {
        AppMethodBeat.m2504i(91764);
        this.awi = null;
        this.axb = null;
        this.aAb = null;
        this.aAf = null;
        this.awY = null;
        this.aAd = null;
        this.aAk = null;
        this.aAh = null;
        this.aAl = null;
        this.aAe.clear();
        this.aAi = false;
        this.azS.clear();
        this.aAj = false;
        AppMethodBeat.m2505o(91764);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: mn */
    public final C31932a mo59247mn() {
        AppMethodBeat.m2504i(91765);
        C31932a mn = this.aAg.mo52051mn();
        AppMethodBeat.m2505o(91765);
        return mn;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: l */
    public final boolean mo59245l(Class<?> cls) {
        AppMethodBeat.m2504i(91766);
        if (mo59246m(cls) != null) {
            AppMethodBeat.m2505o(91766);
            return true;
        }
        AppMethodBeat.m2505o(91766);
        return false;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: m */
    public final <Data> C25424s<Data, ?, Transcode> mo59246m(Class<Data> cls) {
        AppMethodBeat.m2504i(91767);
        C25424s a = this.awi.awj.mo52073a((Class) cls, this.aAf, this.awY);
        AppMethodBeat.m2505o(91767);
        return a;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: n */
    public final <Z> C31970m<Z> mo59250n(Class<Z> cls) {
        AppMethodBeat.m2504i(91768);
        C31970m<Z> c31970m = (C31970m) this.aAh.get(cls);
        if (c31970m == null) {
            for (Entry entry : this.aAh.entrySet()) {
                if (((Class) entry.getKey()).isAssignableFrom(cls)) {
                    c31970m = (C31970m) entry.getValue();
                    break;
                }
            }
        }
        if (c31970m != null) {
            AppMethodBeat.m2505o(91768);
            return c31970m;
        } else if (this.aAh.isEmpty() && this.aAm) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
            AppMethodBeat.m2505o(91768);
            throw illegalArgumentException;
        } else {
            C37182b nm = C37182b.m62320nm();
            AppMethodBeat.m2505o(91768);
            return nm;
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: n */
    public final List<C37175n<File, ?>> mo59251n(File file) {
        AppMethodBeat.m2504i(91769);
        List P = this.awi.awj.mo52072P(file);
        AppMethodBeat.m2505o(91769);
        return P;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: mo */
    public final List<C37176a<?>> mo59248mo() {
        AppMethodBeat.m2504i(91770);
        if (!this.aAi) {
            this.aAi = true;
            this.aAe.clear();
            List P = this.awi.awj.mo52072P(this.axb);
            int size = P.size();
            for (int i = 0; i < size; i++) {
                C37176a b = ((C37175n) P.get(i)).mo2225b(this.axb, this.width, this.height, this.aAd);
                if (b != null) {
                    this.aAe.add(b);
                }
            }
        }
        List list = this.aAe;
        AppMethodBeat.m2505o(91770);
        return list;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: mp */
    public final List<C0779h> mo59249mp() {
        AppMethodBeat.m2504i(91771);
        if (!this.aAj) {
            this.aAj = true;
            this.azS.clear();
            List mo = mo59248mo();
            int size = mo.size();
            for (int i = 0; i < size; i++) {
                C37176a c37176a = (C37176a) mo.get(i);
                if (!this.azS.contains(c37176a.azW)) {
                    this.azS.add(c37176a.azW);
                }
                for (int i2 = 0; i2 < c37176a.aEp.size(); i2++) {
                    if (!this.azS.contains(c37176a.aEp.get(i2))) {
                        this.azS.add(c37176a.aEp.get(i2));
                    }
                }
            }
        }
        List list = this.azS;
        AppMethodBeat.m2505o(91771);
        return list;
    }
}
