package a;

import a.f.a.a;
import a.f.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\u001a*\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\u001a(\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004¨\u0006\t"}, dWq = {"lazy", "Lkotlin/Lazy;", "T", "initializer", "Lkotlin/Function0;", "lock", "", "mode", "Lkotlin/LazyThreadSafetyMode;", "kotlin-stdlib"}, dWr = 1)
public class i {
    public static final <T> f<T> g(a<? extends T> aVar) {
        AppMethodBeat.i(56365);
        j.p(aVar, "initializer");
        f sVar = new s(aVar, (byte) 0);
        AppMethodBeat.o(56365);
        return sVar;
    }

    public static final <T> f<T> a(k kVar, a<? extends T> aVar) {
        AppMethodBeat.i(56366);
        j.p(kVar, "mode");
        j.p(aVar, "initializer");
        f<T> rVar;
        switch (h.eQZ[kVar.ordinal()]) {
            case 1:
                f sVar = new s(aVar, (byte) 0);
                AppMethodBeat.o(56366);
                return sVar;
            case 2:
                rVar = new r(aVar);
                AppMethodBeat.o(56366);
                return rVar;
            case 3:
                rVar = new z(aVar);
                AppMethodBeat.o(56366);
                return rVar;
            default:
                m mVar = new m();
                AppMethodBeat.o(56366);
                throw mVar;
        }
    }
}
