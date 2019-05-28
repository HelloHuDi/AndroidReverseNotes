package com.eclipsesource.p096a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.eclipsesource.a.b */
public final class C37205b extends C0803h implements Iterable<C0803h> {
    public final List<C0803h> aCy = new ArrayList();

    public C37205b() {
        AppMethodBeat.m2504i(70500);
        AppMethodBeat.m2505o(70500);
    }

    /* renamed from: ds */
    public final C37205b mo59306ds(int i) {
        AppMethodBeat.m2504i(70501);
        this.aCy.add(C25470a.m40252dr(i));
        AppMethodBeat.m2505o(70501);
        return this;
    }

    /* renamed from: u */
    public final C37205b mo59312u(long j) {
        AppMethodBeat.m2504i(70502);
        this.aCy.add(C25470a.m40254t(j));
        AppMethodBeat.m2505o(70502);
        return this;
    }

    /* renamed from: U */
    public final C37205b mo59299U(float f) {
        AppMethodBeat.m2504i(70503);
        this.aCy.add(C25470a.m40247T(f));
        AppMethodBeat.m2505o(70503);
        return this;
    }

    /* renamed from: n */
    public final C37205b mo59310n(double d) {
        AppMethodBeat.m2504i(70504);
        this.aCy.add(C25470a.m40253m(d));
        AppMethodBeat.m2505o(70504);
        return this;
    }

    /* renamed from: aC */
    public final C37205b mo59302aC(boolean z) {
        AppMethodBeat.m2504i(70505);
        this.aCy.add(C25470a.m40248aB(z));
        AppMethodBeat.m2505o(70505);
        return this;
    }

    /* renamed from: aj */
    public final C37205b mo59304aj(String str) {
        AppMethodBeat.m2504i(70506);
        this.aCy.add(C25470a.m40249ag(str));
        AppMethodBeat.m2505o(70506);
        return this;
    }

    /* renamed from: a */
    public final C37205b mo59301a(C0803h c0803h) {
        AppMethodBeat.m2504i(70507);
        if (c0803h == null) {
            NullPointerException nullPointerException = new NullPointerException("value is null");
            AppMethodBeat.m2505o(70507);
            throw nullPointerException;
        }
        this.aCy.add(c0803h);
        AppMethodBeat.m2505o(70507);
        return this;
    }

    /* renamed from: aX */
    public final C37205b mo59303aX(int i, int i2) {
        AppMethodBeat.m2504i(70508);
        this.aCy.set(i, C25470a.m40252dr(i2));
        AppMethodBeat.m2505o(70508);
        return this;
    }

    /* renamed from: f */
    public final C37205b mo59308f(int i, long j) {
        AppMethodBeat.m2504i(70509);
        this.aCy.set(i, C25470a.m40254t(j));
        AppMethodBeat.m2505o(70509);
        return this;
    }

    /* renamed from: b */
    public final C37205b mo59305b(int i, double d) {
        AppMethodBeat.m2504i(70510);
        this.aCy.set(i, C25470a.m40253m(d));
        AppMethodBeat.m2505o(70510);
        return this;
    }

    /* renamed from: p */
    public final C37205b mo59311p(int i, boolean z) {
        AppMethodBeat.m2504i(70511);
        this.aCy.set(i, C25470a.m40248aB(z));
        AppMethodBeat.m2505o(70511);
        return this;
    }

    /* renamed from: a */
    public final C37205b mo59300a(int i, C0803h c0803h) {
        AppMethodBeat.m2504i(70512);
        if (c0803h == null) {
            NullPointerException nullPointerException = new NullPointerException("value is null");
            AppMethodBeat.m2505o(70512);
            throw nullPointerException;
        }
        this.aCy.set(i, c0803h);
        AppMethodBeat.m2505o(70512);
        return this;
    }

    /* renamed from: dt */
    public final C0803h mo59307dt(int i) {
        AppMethodBeat.m2504i(70513);
        C0803h c0803h = (C0803h) this.aCy.get(i);
        AppMethodBeat.m2505o(70513);
        return c0803h;
    }

    public final Iterator<C0803h> iterator() {
        AppMethodBeat.m2504i(70514);
        final Iterator it = this.aCy.iterator();
        C372061 c372061 = new Iterator<C0803h>() {
            public final boolean hasNext() {
                AppMethodBeat.m2504i(70497);
                boolean hasNext = it.hasNext();
                AppMethodBeat.m2505o(70497);
                return hasNext;
            }

            public final void remove() {
                AppMethodBeat.m2504i(70498);
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
                AppMethodBeat.m2505o(70498);
                throw unsupportedOperationException;
            }

            public final /* bridge */ /* synthetic */ Object next() {
                AppMethodBeat.m2504i(70499);
                C0803h c0803h = (C0803h) it.next();
                AppMethodBeat.m2505o(70499);
                return c0803h;
            }
        };
        AppMethodBeat.m2505o(70514);
        return c372061;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo2353a(C0804i c0804i) {
        AppMethodBeat.m2504i(70515);
        c0804i.mo2372pr();
        Iterator it = iterator();
        Object obj = 1;
        while (it.hasNext()) {
            if (obj == null) {
                c0804i.mo2374pt();
            }
            ((C0803h) it.next()).mo2353a(c0804i);
            obj = null;
        }
        c0804i.mo2373ps();
        AppMethodBeat.m2505o(70515);
    }

    public final boolean isArray() {
        return true;
    }

    /* renamed from: oN */
    public final C37205b mo2361oN() {
        return this;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(70516);
        int hashCode = this.aCy.hashCode();
        AppMethodBeat.m2505o(70516);
        return hashCode;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(70517);
        if (this == obj) {
            AppMethodBeat.m2505o(70517);
            return true;
        } else if (obj == null) {
            AppMethodBeat.m2505o(70517);
            return false;
        } else if (getClass() != obj.getClass()) {
            AppMethodBeat.m2505o(70517);
            return false;
        } else {
            boolean equals = this.aCy.equals(((C37205b) obj).aCy);
            AppMethodBeat.m2505o(70517);
            return equals;
        }
    }
}
