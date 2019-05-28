package a.i.b.a.c.l;

import a.aa;
import a.f.b.j;
import a.i.b.a.c.b.ar;
import a.i.b.a.c.b.h;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class u extends as {
    public final ar[] BJE;
    public final ap[] BJF;
    private final boolean BJG;

    public u(ar[] arVarArr, ap[] apVarArr, boolean z) {
        j.p(arVarArr, "parameters");
        j.p(apVarArr, "arguments");
        AppMethodBeat.i(122596);
        this.BJE = arVarArr;
        this.BJF = apVarArr;
        this.BJG = z;
        Object obj = this.BJE.length <= this.BJF.length ? 1 : null;
        if (aa.AUz && obj == null) {
            Throwable assertionError = new AssertionError("Number of arguments should not be less then number of parameters, but: parameters=" + this.BJE.length + ", args=" + this.BJF.length);
            AppMethodBeat.o(122596);
            throw assertionError;
        }
        AppMethodBeat.o(122596);
    }

    public u(List<? extends ar> list, List<? extends ap> list2) {
        j.p(list, "parameters");
        j.p(list2, "argumentsList");
        Object[] toArray = list.toArray(new ar[0]);
        v vVar;
        if (toArray == null) {
            vVar = new v("null cannot be cast to non-null type kotlin.Array<T>");
            AppMethodBeat.o(122597);
            throw vVar;
        }
        ar[] arVarArr = (ar[]) toArray;
        Object[] toArray2 = list2.toArray(new ap[0]);
        if (toArray2 == null) {
            vVar = new v("null cannot be cast to non-null type kotlin.Array<T>");
            AppMethodBeat.o(122597);
            throw vVar;
        }
        this(arVarArr, (ap[]) toArray2);
        AppMethodBeat.o(122597);
    }

    public final boolean isEmpty() {
        return this.BJF.length == 0;
    }

    public final boolean ejx() {
        return this.BJG;
    }

    public final ap O(w wVar) {
        AppMethodBeat.i(122595);
        j.p(wVar, "key");
        h dYs = wVar.ejw().dYs();
        if (!(dYs instanceof ar)) {
            dYs = null;
        }
        ar arVar = (ar) dYs;
        if (arVar == null) {
            AppMethodBeat.o(122595);
            return null;
        }
        int index = arVar.getIndex();
        if (index >= this.BJE.length || !j.j(this.BJE[index].dXY(), arVar.dXY())) {
            AppMethodBeat.o(122595);
            return null;
        }
        ap apVar = this.BJF[index];
        AppMethodBeat.o(122595);
        return apVar;
    }
}
