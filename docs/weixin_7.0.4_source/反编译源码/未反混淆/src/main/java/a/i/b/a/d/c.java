package a.i.b.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class c<V> {
    static final c<Object> BND = new c();
    private final c<V> BNE;
    private final c<V> BNF;
    private final long key;
    private final int size;
    private final V value;

    static {
        AppMethodBeat.i(122999);
        AppMethodBeat.o(122999);
    }

    private c() {
        this.size = 0;
        this.key = 0;
        this.value = null;
        this.BNE = null;
        this.BNF = null;
    }

    private c(long j, V v, c<V> cVar, c<V> cVar2) {
        AppMethodBeat.i(122994);
        this.key = j;
        this.value = v;
        this.BNE = cVar;
        this.BNF = cVar2;
        this.size = (cVar.size + 1) + cVar2.size;
        AppMethodBeat.o(122994);
    }

    private c<V> nX(long j) {
        AppMethodBeat.i(122995);
        if (this.size == 0 || j == this.key) {
            AppMethodBeat.o(122995);
            return this;
        }
        c<V> thisR = new c(j, this.value, this.BNE, this.BNF);
        AppMethodBeat.o(122995);
        return thisR;
    }

    /* Access modifiers changed, original: final */
    public final V get(long j) {
        while (true) {
            long j2;
            c cVar;
            j -= j2;
            this = cVar;
            if (this.size == 0) {
                return null;
            }
            if (j < this.key) {
                cVar = this.BNE;
                j2 = this.key;
            } else if (j <= this.key) {
                return this.value;
            } else {
                cVar = this.BNF;
                j2 = this.key;
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final c<V> b(long j, V v) {
        AppMethodBeat.i(122996);
        c<V> a;
        if (this.size == 0) {
            c cVar = new c(j, v, this, this);
            AppMethodBeat.o(122996);
            return cVar;
        } else if (j < this.key) {
            a = a(this.BNE.b(j - this.key, v), this.BNF);
            AppMethodBeat.o(122996);
            return a;
        } else if (j > this.key) {
            a = a(this.BNE, this.BNF.b(j - this.key, v));
            AppMethodBeat.o(122996);
            return a;
        } else if (v == this.value) {
            AppMethodBeat.o(122996);
            return this;
        } else {
            a = new c(j, v, this.BNE, this.BNF);
            AppMethodBeat.o(122996);
            return a;
        }
    }

    private c<V> a(c<V> cVar, c<V> cVar2) {
        AppMethodBeat.i(122997);
        if (cVar == this.BNE && cVar2 == this.BNF) {
            AppMethodBeat.o(122997);
            return this;
        }
        c<V> thisR = a(this.key, this.value, cVar, cVar2);
        AppMethodBeat.o(122997);
        return thisR;
    }

    private static <V> c<V> a(long j, V v, c<V> cVar, c<V> cVar2) {
        AppMethodBeat.i(122998);
        if (cVar.size + cVar2.size > 1) {
            c cVar3;
            c cVar4;
            c<V> cVar5;
            if (cVar.size >= cVar2.size * 5) {
                cVar3 = cVar.BNE;
                cVar4 = cVar.BNF;
                if (cVar4.size < cVar3.size * 2) {
                    cVar5 = new c(cVar.key + j, cVar.value, cVar3, new c(-cVar.key, v, cVar4.nX(cVar4.key + cVar.key), cVar2));
                    AppMethodBeat.o(122998);
                    return cVar5;
                }
                c cVar6 = cVar4.BNE;
                c cVar7 = cVar4.BNF;
                c<V> cVar8 = new c((cVar4.key + cVar.key) + j, cVar4.value, new c(-cVar4.key, cVar.value, cVar3, cVar6.nX(cVar6.key + cVar4.key)), new c((-cVar.key) - cVar4.key, v, cVar7.nX((cVar4.key + cVar7.key) + cVar.key), cVar2));
                AppMethodBeat.o(122998);
                return cVar8;
            } else if (cVar2.size >= cVar.size * 5) {
                cVar3 = cVar2.BNE;
                c cVar9 = cVar2.BNF;
                if (cVar3.size < cVar9.size * 2) {
                    cVar5 = new c(cVar2.key + j, cVar2.value, new c(-cVar2.key, v, cVar, cVar3.nX(cVar3.key + cVar2.key)), cVar9);
                    AppMethodBeat.o(122998);
                    return cVar5;
                }
                c cVar10 = cVar3.BNE;
                cVar4 = cVar3.BNF;
                c<V> cVar11 = new c((cVar3.key + cVar2.key) + j, cVar3.value, new c((-cVar2.key) - cVar3.key, v, cVar, cVar10.nX((cVar10.key + cVar3.key) + cVar2.key)), new c(-cVar3.key, cVar2.value, cVar4.nX(cVar4.key + cVar3.key), cVar9));
                AppMethodBeat.o(122998);
                return cVar11;
            }
        }
        c<V> cVar12 = new c(j, v, cVar, cVar2);
        AppMethodBeat.o(122998);
        return cVar12;
    }
}
