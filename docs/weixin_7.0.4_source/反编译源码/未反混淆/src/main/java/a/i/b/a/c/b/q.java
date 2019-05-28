package a.i.b.a.c.b;

import a.f.b.j;
import a.i.b.a.c.c.a.a;
import a.i.b.a.c.f.b;
import a.i.b.a.c.f.f;
import a.i.b.a.c.i.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class q {
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0081  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final e a(y yVar, b bVar, a aVar) {
        AppMethodBeat.i(119267);
        j.p(yVar, "receiver$0");
        j.p(bVar, "fqName");
        j.p(aVar, "lookupLocation");
        if (bVar.ByQ.ByV.isEmpty()) {
            AppMethodBeat.o(119267);
            return null;
        }
        b ehG = bVar.ehG();
        j.o(ehG, "fqName.parent()");
        h dXR = yVar.g(ehG).dXR();
        f ehK = bVar.ByQ.ehK();
        j.o(ehK, "fqName.shortName()");
        h c = dXR.c(ehK, aVar);
        if (!(c instanceof e)) {
            c = null;
        }
        e eVar = (e) c;
        if (eVar != null) {
            AppMethodBeat.o(119267);
            return eVar;
        }
        ehG = bVar.ehG();
        j.o(ehG, "fqName.parent()");
        eVar = a(yVar, ehG, aVar);
        if (eVar != null) {
            dXR = eVar.dZk();
            if (dXR != null) {
                ehK = bVar.ByQ.ehK();
                j.o(ehK, "fqName.shortName()");
                c = dXR.c(ehK, aVar);
                if (!(c instanceof e)) {
                    c = null;
                }
                eVar = (e) c;
                AppMethodBeat.o(119267);
                return eVar;
            }
        }
        c = null;
        if (c instanceof e) {
        }
        eVar = (e) c;
        AppMethodBeat.o(119267);
        return eVar;
    }
}
