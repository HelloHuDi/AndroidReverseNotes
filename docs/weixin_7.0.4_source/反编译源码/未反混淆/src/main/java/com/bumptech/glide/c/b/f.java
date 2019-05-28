package com.bumptech.glide.c.b;

import com.bumptech.glide.c.c.n;
import com.bumptech.glide.c.c.n.a;
import com.bumptech.glide.c.d.b;
import com.bumptech.glide.c.h;
import com.bumptech.glide.c.j;
import com.bumptech.glide.c.m;
import com.bumptech.glide.e;
import com.bumptech.glide.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

final class f<Transcode> {
    h aAb;
    j aAd;
    private final List<a<?>> aAe = new ArrayList();
    Class<?> aAf;
    d aAg;
    Map<Class<?>, m<?>> aAh;
    private boolean aAi;
    private boolean aAj;
    g aAk;
    i aAl;
    boolean aAm;
    boolean aAn;
    Class<Transcode> awY;
    e awi;
    Object axb;
    private final List<h> azS = new ArrayList();
    int height;
    int width;

    f() {
        AppMethodBeat.i(91763);
        AppMethodBeat.o(91763);
    }

    /* Access modifiers changed, original: final */
    public final void clear() {
        AppMethodBeat.i(91764);
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
        AppMethodBeat.o(91764);
    }

    /* Access modifiers changed, original: final */
    public final com.bumptech.glide.c.b.b.a mn() {
        AppMethodBeat.i(91765);
        com.bumptech.glide.c.b.b.a mn = this.aAg.mn();
        AppMethodBeat.o(91765);
        return mn;
    }

    /* Access modifiers changed, original: final */
    public final boolean l(Class<?> cls) {
        AppMethodBeat.i(91766);
        if (m(cls) != null) {
            AppMethodBeat.o(91766);
            return true;
        }
        AppMethodBeat.o(91766);
        return false;
    }

    /* Access modifiers changed, original: final */
    public final <Data> s<Data, ?, Transcode> m(Class<Data> cls) {
        AppMethodBeat.i(91767);
        s a = this.awi.awj.a((Class) cls, this.aAf, this.awY);
        AppMethodBeat.o(91767);
        return a;
    }

    /* Access modifiers changed, original: final */
    public final <Z> m<Z> n(Class<Z> cls) {
        AppMethodBeat.i(91768);
        m<Z> mVar = (m) this.aAh.get(cls);
        if (mVar == null) {
            for (Entry entry : this.aAh.entrySet()) {
                if (((Class) entry.getKey()).isAssignableFrom(cls)) {
                    mVar = (m) entry.getValue();
                    break;
                }
            }
        }
        if (mVar != null) {
            AppMethodBeat.o(91768);
            return mVar;
        } else if (this.aAh.isEmpty() && this.aAm) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
            AppMethodBeat.o(91768);
            throw illegalArgumentException;
        } else {
            b nm = b.nm();
            AppMethodBeat.o(91768);
            return nm;
        }
    }

    /* Access modifiers changed, original: final */
    public final List<n<File, ?>> n(File file) {
        AppMethodBeat.i(91769);
        List P = this.awi.awj.P(file);
        AppMethodBeat.o(91769);
        return P;
    }

    /* Access modifiers changed, original: final */
    public final List<a<?>> mo() {
        AppMethodBeat.i(91770);
        if (!this.aAi) {
            this.aAi = true;
            this.aAe.clear();
            List P = this.awi.awj.P(this.axb);
            int size = P.size();
            for (int i = 0; i < size; i++) {
                a b = ((n) P.get(i)).b(this.axb, this.width, this.height, this.aAd);
                if (b != null) {
                    this.aAe.add(b);
                }
            }
        }
        List list = this.aAe;
        AppMethodBeat.o(91770);
        return list;
    }

    /* Access modifiers changed, original: final */
    public final List<h> mp() {
        AppMethodBeat.i(91771);
        if (!this.aAj) {
            this.aAj = true;
            this.azS.clear();
            List mo = mo();
            int size = mo.size();
            for (int i = 0; i < size; i++) {
                a aVar = (a) mo.get(i);
                if (!this.azS.contains(aVar.azW)) {
                    this.azS.add(aVar.azW);
                }
                for (int i2 = 0; i2 < aVar.aEp.size(); i2++) {
                    if (!this.azS.contains(aVar.aEp.get(i2))) {
                        this.azS.add(aVar.aEp.get(i2));
                    }
                }
            }
        }
        List list = this.azS;
        AppMethodBeat.o(91771);
        return list;
    }
}
