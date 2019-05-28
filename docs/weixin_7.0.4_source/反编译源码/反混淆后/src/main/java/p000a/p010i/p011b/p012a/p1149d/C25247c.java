package p000a.p010i.p011b.p012a.p1149d;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: a.i.b.a.d.c */
final class C25247c<V> {
    static final C25247c<Object> BND = new C25247c();
    private final C25247c<V> BNE;
    private final C25247c<V> BNF;
    private final long key;
    private final int size;
    private final V value;

    static {
        AppMethodBeat.m2504i(122999);
        AppMethodBeat.m2505o(122999);
    }

    private C25247c() {
        this.size = 0;
        this.key = 0;
        this.value = null;
        this.BNE = null;
        this.BNF = null;
    }

    private C25247c(long j, V v, C25247c<V> c25247c, C25247c<V> c25247c2) {
        AppMethodBeat.m2504i(122994);
        this.key = j;
        this.value = v;
        this.BNE = c25247c;
        this.BNF = c25247c2;
        this.size = (c25247c.size + 1) + c25247c2.size;
        AppMethodBeat.m2505o(122994);
    }

    /* renamed from: nX */
    private C25247c<V> m39821nX(long j) {
        AppMethodBeat.m2504i(122995);
        if (this.size == 0 || j == this.key) {
            AppMethodBeat.m2505o(122995);
            return this;
        }
        C25247c<V> thisR = new C25247c(j, this.value, this.BNE, this.BNF);
        AppMethodBeat.m2505o(122995);
        return thisR;
    }

    /* Access modifiers changed, original: final */
    public final V get(long j) {
        while (true) {
            long j2;
            C25247c c25247c;
            j -= j2;
            this = c25247c;
            if (this.size == 0) {
                return null;
            }
            if (j < this.key) {
                c25247c = this.BNE;
                j2 = this.key;
            } else if (j <= this.key) {
                return this.value;
            } else {
                c25247c = this.BNF;
                j2 = this.key;
            }
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final C25247c<V> mo42093b(long j, V v) {
        AppMethodBeat.m2504i(122996);
        C25247c<V> a;
        if (this.size == 0) {
            C25247c c25247c = new C25247c(j, v, this, this);
            AppMethodBeat.m2505o(122996);
            return c25247c;
        } else if (j < this.key) {
            a = m39820a(this.BNE.mo42093b(j - this.key, v), this.BNF);
            AppMethodBeat.m2505o(122996);
            return a;
        } else if (j > this.key) {
            a = m39820a(this.BNE, this.BNF.mo42093b(j - this.key, v));
            AppMethodBeat.m2505o(122996);
            return a;
        } else if (v == this.value) {
            AppMethodBeat.m2505o(122996);
            return this;
        } else {
            a = new C25247c(j, v, this.BNE, this.BNF);
            AppMethodBeat.m2505o(122996);
            return a;
        }
    }

    /* renamed from: a */
    private C25247c<V> m39820a(C25247c<V> c25247c, C25247c<V> c25247c2) {
        AppMethodBeat.m2504i(122997);
        if (c25247c == this.BNE && c25247c2 == this.BNF) {
            AppMethodBeat.m2505o(122997);
            return this;
        }
        C25247c<V> thisR = C25247c.m39819a(this.key, this.value, c25247c, c25247c2);
        AppMethodBeat.m2505o(122997);
        return thisR;
    }

    /* renamed from: a */
    private static <V> C25247c<V> m39819a(long j, V v, C25247c<V> c25247c, C25247c<V> c25247c2) {
        AppMethodBeat.m2504i(122998);
        if (c25247c.size + c25247c2.size > 1) {
            C25247c c25247c3;
            C25247c c25247c4;
            C25247c<V> c25247c5;
            if (c25247c.size >= c25247c2.size * 5) {
                c25247c3 = c25247c.BNE;
                c25247c4 = c25247c.BNF;
                if (c25247c4.size < c25247c3.size * 2) {
                    c25247c5 = new C25247c(c25247c.key + j, c25247c.value, c25247c3, new C25247c(-c25247c.key, v, c25247c4.m39821nX(c25247c4.key + c25247c.key), c25247c2));
                    AppMethodBeat.m2505o(122998);
                    return c25247c5;
                }
                C25247c c25247c6 = c25247c4.BNE;
                C25247c c25247c7 = c25247c4.BNF;
                C25247c<V> c25247c8 = new C25247c((c25247c4.key + c25247c.key) + j, c25247c4.value, new C25247c(-c25247c4.key, c25247c.value, c25247c3, c25247c6.m39821nX(c25247c6.key + c25247c4.key)), new C25247c((-c25247c.key) - c25247c4.key, v, c25247c7.m39821nX((c25247c4.key + c25247c7.key) + c25247c.key), c25247c2));
                AppMethodBeat.m2505o(122998);
                return c25247c8;
            } else if (c25247c2.size >= c25247c.size * 5) {
                c25247c3 = c25247c2.BNE;
                C25247c c25247c9 = c25247c2.BNF;
                if (c25247c3.size < c25247c9.size * 2) {
                    c25247c5 = new C25247c(c25247c2.key + j, c25247c2.value, new C25247c(-c25247c2.key, v, c25247c, c25247c3.m39821nX(c25247c3.key + c25247c2.key)), c25247c9);
                    AppMethodBeat.m2505o(122998);
                    return c25247c5;
                }
                C25247c c25247c10 = c25247c3.BNE;
                c25247c4 = c25247c3.BNF;
                C25247c<V> c25247c11 = new C25247c((c25247c3.key + c25247c2.key) + j, c25247c3.value, new C25247c((-c25247c2.key) - c25247c3.key, v, c25247c, c25247c10.m39821nX((c25247c10.key + c25247c3.key) + c25247c2.key)), new C25247c(-c25247c3.key, c25247c2.value, c25247c4.m39821nX(c25247c4.key + c25247c3.key), c25247c9));
                AppMethodBeat.m2505o(122998);
                return c25247c11;
            }
        }
        C25247c<V> c25247c12 = new C25247c(j, v, c25247c, c25247c2);
        AppMethodBeat.m2505o(122998);
        return c25247c12;
    }
}
