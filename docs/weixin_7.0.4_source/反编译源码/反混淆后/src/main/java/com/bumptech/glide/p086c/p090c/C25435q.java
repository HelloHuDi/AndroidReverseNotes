package com.bumptech.glide.p086c.p090c;

import android.support.p057v4.p065f.C37122k.C8387a;
import com.bumptech.glide.C37192g;
import com.bumptech.glide.p086c.C0779h;
import com.bumptech.glide.p086c.C25405a;
import com.bumptech.glide.p086c.C31967j;
import com.bumptech.glide.p086c.p087a.C0742d;
import com.bumptech.glide.p086c.p087a.C0742d.C0743a;
import com.bumptech.glide.p086c.p088b.C37169p;
import com.bumptech.glide.p086c.p090c.C37175n.C37176a;
import com.bumptech.glide.p095h.C8561i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.bumptech.glide.c.c.q */
final class C25435q<Model, Data> implements C37175n<Model, Data> {
    private final C8387a<List<Throwable>> aEv;
    private final List<C37175n<Model, Data>> azX;

    /* renamed from: com.bumptech.glide.c.c.q$a */
    static class C25436a<Data> implements C0742d<Data>, C0743a<Data> {
        private C37192g aAk;
        private final List<C0742d<Data>> aEw;
        private C0743a<? super Data> aEx;
        private List<Throwable> aEy;
        private final C8387a<List<Throwable>> awV;
        private int currentIndex = 0;

        C25436a(List<C0742d<Data>> list, C8387a<List<Throwable>> c8387a) {
            AppMethodBeat.m2504i(92106);
            this.awV = c8387a;
            C8561i.m15216c(list);
            this.aEw = list;
            AppMethodBeat.m2505o(92106);
        }

        /* renamed from: a */
        public final void mo2184a(C37192g c37192g, C0743a<? super Data> c0743a) {
            AppMethodBeat.m2504i(92107);
            this.aAk = c37192g;
            this.aEx = c0743a;
            this.aEy = (List) this.awV.mo6364aA();
            ((C0742d) this.aEw.get(this.currentIndex)).mo2184a(c37192g, this);
            AppMethodBeat.m2505o(92107);
        }

        public final void cleanup() {
            AppMethodBeat.m2504i(92108);
            if (this.aEy != null) {
                this.awV.release(this.aEy);
            }
            this.aEy = null;
            for (C0742d cleanup : this.aEw) {
                cleanup.cleanup();
            }
            AppMethodBeat.m2505o(92108);
        }

        public final void cancel() {
            AppMethodBeat.m2504i(92109);
            for (C0742d cancel : this.aEw) {
                cancel.cancel();
            }
            AppMethodBeat.m2505o(92109);
        }

        /* renamed from: mg */
        public final Class<Data> mo2187mg() {
            AppMethodBeat.m2504i(92110);
            Class mg = ((C0742d) this.aEw.get(0)).mo2187mg();
            AppMethodBeat.m2505o(92110);
            return mg;
        }

        /* renamed from: mh */
        public final C25405a mo2188mh() {
            AppMethodBeat.m2504i(92111);
            C25405a mh = ((C0742d) this.aEw.get(0)).mo2188mh();
            AppMethodBeat.m2505o(92111);
            return mh;
        }

        /* renamed from: S */
        public final void mo2189S(Data data) {
            AppMethodBeat.m2504i(92112);
            if (data != null) {
                this.aEx.mo2189S(data);
                AppMethodBeat.m2505o(92112);
                return;
            }
            m40196nj();
            AppMethodBeat.m2505o(92112);
        }

        /* renamed from: b */
        public final void mo2190b(Exception exception) {
            AppMethodBeat.m2504i(92113);
            ((List) C8561i.m15217d(this.aEy, "Argument must not be null")).add(exception);
            m40196nj();
            AppMethodBeat.m2505o(92113);
        }

        /* renamed from: nj */
        private void m40196nj() {
            AppMethodBeat.m2504i(92114);
            if (this.currentIndex < this.aEw.size() - 1) {
                this.currentIndex++;
                mo2184a(this.aAk, this.aEx);
                AppMethodBeat.m2505o(92114);
                return;
            }
            C8561i.m15217d(this.aEy, "Argument must not be null");
            this.aEx.mo2190b(new C37169p("Fetch failed", new ArrayList(this.aEy)));
            AppMethodBeat.m2505o(92114);
        }
    }

    C25435q(List<C37175n<Model, Data>> list, C8387a<List<Throwable>> c8387a) {
        this.azX = list;
        this.aEv = c8387a;
    }

    /* renamed from: b */
    public final C37176a<Data> mo2225b(Model model, int i, int i2, C31967j c31967j) {
        AppMethodBeat.m2504i(92115);
        int size = this.azX.size();
        ArrayList arrayList = new ArrayList(size);
        int i3 = 0;
        C0779h c0779h = null;
        while (i3 < size) {
            C0779h c0779h2;
            C37175n c37175n = (C37175n) this.azX.get(i3);
            if (c37175n.mo2224X(model)) {
                C37176a b = c37175n.mo2225b(model, i, i2, c31967j);
                if (b != null) {
                    c0779h2 = b.azW;
                    arrayList.add(b.aEq);
                    i3++;
                    c0779h = c0779h2;
                }
            }
            c0779h2 = c0779h;
            i3++;
            c0779h = c0779h2;
        }
        if (arrayList.isEmpty() || c0779h == null) {
            AppMethodBeat.m2505o(92115);
            return null;
        }
        C37176a c37176a = new C37176a(c0779h, new C25436a(arrayList, this.aEv));
        AppMethodBeat.m2505o(92115);
        return c37176a;
    }

    /* renamed from: X */
    public final boolean mo2224X(Model model) {
        AppMethodBeat.m2504i(92116);
        for (C37175n X : this.azX) {
            if (X.mo2224X(model)) {
                AppMethodBeat.m2505o(92116);
                return true;
            }
        }
        AppMethodBeat.m2505o(92116);
        return false;
    }

    public final String toString() {
        AppMethodBeat.m2504i(92117);
        String str = "MultiModelLoader{modelLoaders=" + Arrays.toString(this.azX.toArray()) + '}';
        AppMethodBeat.m2505o(92117);
        return str;
    }
}
