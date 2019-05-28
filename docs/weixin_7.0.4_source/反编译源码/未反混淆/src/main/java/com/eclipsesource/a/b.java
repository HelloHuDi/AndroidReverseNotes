package com.eclipsesource.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b extends h implements Iterable<h> {
    public final List<h> aCy = new ArrayList();

    public b() {
        AppMethodBeat.i(70500);
        AppMethodBeat.o(70500);
    }

    public final b ds(int i) {
        AppMethodBeat.i(70501);
        this.aCy.add(a.dr(i));
        AppMethodBeat.o(70501);
        return this;
    }

    public final b u(long j) {
        AppMethodBeat.i(70502);
        this.aCy.add(a.t(j));
        AppMethodBeat.o(70502);
        return this;
    }

    public final b U(float f) {
        AppMethodBeat.i(70503);
        this.aCy.add(a.T(f));
        AppMethodBeat.o(70503);
        return this;
    }

    public final b n(double d) {
        AppMethodBeat.i(70504);
        this.aCy.add(a.m(d));
        AppMethodBeat.o(70504);
        return this;
    }

    public final b aC(boolean z) {
        AppMethodBeat.i(70505);
        this.aCy.add(a.aB(z));
        AppMethodBeat.o(70505);
        return this;
    }

    public final b aj(String str) {
        AppMethodBeat.i(70506);
        this.aCy.add(a.ag(str));
        AppMethodBeat.o(70506);
        return this;
    }

    public final b a(h hVar) {
        AppMethodBeat.i(70507);
        if (hVar == null) {
            NullPointerException nullPointerException = new NullPointerException("value is null");
            AppMethodBeat.o(70507);
            throw nullPointerException;
        }
        this.aCy.add(hVar);
        AppMethodBeat.o(70507);
        return this;
    }

    public final b aX(int i, int i2) {
        AppMethodBeat.i(70508);
        this.aCy.set(i, a.dr(i2));
        AppMethodBeat.o(70508);
        return this;
    }

    public final b f(int i, long j) {
        AppMethodBeat.i(70509);
        this.aCy.set(i, a.t(j));
        AppMethodBeat.o(70509);
        return this;
    }

    public final b b(int i, double d) {
        AppMethodBeat.i(70510);
        this.aCy.set(i, a.m(d));
        AppMethodBeat.o(70510);
        return this;
    }

    public final b p(int i, boolean z) {
        AppMethodBeat.i(70511);
        this.aCy.set(i, a.aB(z));
        AppMethodBeat.o(70511);
        return this;
    }

    public final b a(int i, h hVar) {
        AppMethodBeat.i(70512);
        if (hVar == null) {
            NullPointerException nullPointerException = new NullPointerException("value is null");
            AppMethodBeat.o(70512);
            throw nullPointerException;
        }
        this.aCy.set(i, hVar);
        AppMethodBeat.o(70512);
        return this;
    }

    public final h dt(int i) {
        AppMethodBeat.i(70513);
        h hVar = (h) this.aCy.get(i);
        AppMethodBeat.o(70513);
        return hVar;
    }

    public final Iterator<h> iterator() {
        AppMethodBeat.i(70514);
        final Iterator it = this.aCy.iterator();
        AnonymousClass1 anonymousClass1 = new Iterator<h>() {
            public final boolean hasNext() {
                AppMethodBeat.i(70497);
                boolean hasNext = it.hasNext();
                AppMethodBeat.o(70497);
                return hasNext;
            }

            public final void remove() {
                AppMethodBeat.i(70498);
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
                AppMethodBeat.o(70498);
                throw unsupportedOperationException;
            }

            public final /* bridge */ /* synthetic */ Object next() {
                AppMethodBeat.i(70499);
                h hVar = (h) it.next();
                AppMethodBeat.o(70499);
                return hVar;
            }
        };
        AppMethodBeat.o(70514);
        return anonymousClass1;
    }

    /* Access modifiers changed, original: final */
    public final void a(i iVar) {
        AppMethodBeat.i(70515);
        iVar.pr();
        Iterator it = iterator();
        Object obj = 1;
        while (it.hasNext()) {
            if (obj == null) {
                iVar.pt();
            }
            ((h) it.next()).a(iVar);
            obj = null;
        }
        iVar.ps();
        AppMethodBeat.o(70515);
    }

    public final boolean isArray() {
        return true;
    }

    public final b oN() {
        return this;
    }

    public final int hashCode() {
        AppMethodBeat.i(70516);
        int hashCode = this.aCy.hashCode();
        AppMethodBeat.o(70516);
        return hashCode;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(70517);
        if (this == obj) {
            AppMethodBeat.o(70517);
            return true;
        } else if (obj == null) {
            AppMethodBeat.o(70517);
            return false;
        } else if (getClass() != obj.getClass()) {
            AppMethodBeat.o(70517);
            return false;
        } else {
            boolean equals = this.aCy.equals(((b) obj).aCy);
            AppMethodBeat.o(70517);
            return equals;
        }
    }
}
