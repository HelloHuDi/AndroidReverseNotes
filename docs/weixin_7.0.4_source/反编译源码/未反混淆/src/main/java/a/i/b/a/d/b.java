package a.i.b.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b<K, V> {
    private static final b<Object, Object> BNB = new b(d.ekG(), 0);
    private final d<a<e<K, V>>> BNC;
    private final int size;

    static {
        AppMethodBeat.i(122993);
        AppMethodBeat.o(122993);
    }

    public static <K, V> b<K, V> ekF() {
        return BNB;
    }

    private b(d<a<e<K, V>>> dVar, int i) {
        this.BNC = dVar;
        this.size = i;
    }

    public final b<K, V> K(K k, V v) {
        AppMethodBeat.i(122990);
        a UV = UV(k.hashCode());
        int i = UV.size;
        int a = a(UV, k);
        if (a != -1) {
            UV = UV.UT(a);
        }
        UV = UV.dZ(new e(k, v));
        b bVar = new b(this.BNC.t(k.hashCode(), UV), UV.size + (this.size - i));
        AppMethodBeat.o(122990);
        return bVar;
    }

    public final a<e<K, V>> UV(int i) {
        AppMethodBeat.i(122991);
        a<e<K, V>> aVar = (a) this.BNC.get(i);
        if (aVar == null) {
            a ekE = a.ekE();
            AppMethodBeat.o(122991);
            return ekE;
        }
        AppMethodBeat.o(122991);
        return aVar;
    }

    private static <K, V> int a(a<e<K, V>> aVar, Object obj) {
        AppMethodBeat.i(122992);
        int i = 0;
        a aVar2;
        while (aVar2 != null && aVar2.size > 0) {
            if (((e) aVar2.first).aCx.equals(obj)) {
                AppMethodBeat.o(122992);
                return i;
            }
            aVar2 = aVar2.BNz;
            i++;
        }
        AppMethodBeat.o(122992);
        return -1;
    }
}
