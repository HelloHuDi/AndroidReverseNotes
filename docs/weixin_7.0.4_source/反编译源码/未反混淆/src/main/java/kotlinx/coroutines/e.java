package kotlinx.coroutines;

import a.c.c;
import a.f.a.m;
import a.f.b.j;
import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(dWo = {1, 1, 13}, dWp = {"kotlinx/coroutines/BuildersKt__BuildersKt", "kotlinx/coroutines/BuildersKt__Builders_commonKt"})
public final class e {
    public static final bc a(ac acVar, a.c.e eVar, ad adVar, m<? super ac, ? super c<? super y>, ? extends Object> mVar) {
        boolean z;
        bp biVar;
        AppMethodBeat.i(118288);
        j.p(acVar, "receiver$0");
        j.p(eVar, "context");
        j.p(adVar, "start");
        j.p(mVar, "block");
        a.c.e a = v.a(acVar, eVar);
        if (adVar == ad.LAZY) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            biVar = new bi(a, mVar);
        } else {
            biVar = new bp(a, true);
        }
        biVar.a(adVar, biVar, mVar);
        bc bcVar = biVar;
        AppMethodBeat.o(118288);
        return bcVar;
    }
}
