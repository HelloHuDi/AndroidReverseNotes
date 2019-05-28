package a.i.b.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class d<V> {
    private static final d<Object> BNG = new d(c.BND);
    private final c<V> BNH;

    static {
        AppMethodBeat.i(123003);
        AppMethodBeat.o(123003);
    }

    public static <V> d<V> ekG() {
        return BNG;
    }

    private d(c<V> cVar) {
        this.BNH = cVar;
    }

    private d<V> a(c<V> cVar) {
        AppMethodBeat.i(123000);
        if (cVar == this.BNH) {
            AppMethodBeat.o(123000);
            return this;
        }
        d<V> thisR = new d(cVar);
        AppMethodBeat.o(123000);
        return thisR;
    }

    public final V get(int i) {
        AppMethodBeat.i(123001);
        Object obj = this.BNH.get((long) i);
        AppMethodBeat.o(123001);
        return obj;
    }

    public final d<V> t(int i, V v) {
        AppMethodBeat.i(123002);
        d a = a(this.BNH.b((long) i, v));
        AppMethodBeat.o(123002);
        return a;
    }
}
