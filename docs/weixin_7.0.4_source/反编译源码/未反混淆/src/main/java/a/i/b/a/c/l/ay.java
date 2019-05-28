package a.i.b.a.c.l;

import a.f.b.j;
import a.i.b.a.c.i.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class ay extends o {
    public final String BKg;

    public final /* synthetic */ az rK(boolean z) {
        AppMethodBeat.i(122705);
        az rL = rL(z);
        AppMethodBeat.o(122705);
        return rL;
    }

    private ay(String str, an anVar, h hVar, List<? extends ap> list, boolean z) {
        j.p(str, "presentableName");
        j.p(anVar, "constructor");
        j.p(hVar, "memberScope");
        j.p(list, "arguments");
        super(anVar, hVar, list, z);
        AppMethodBeat.i(122706);
        this.BKg = str;
        AppMethodBeat.o(122706);
    }

    public final ad rL(boolean z) {
        AppMethodBeat.i(122704);
        ad ayVar = new ay(this.BKg, ejw(), dXR(), ejt(), z);
        AppMethodBeat.o(122704);
        return ayVar;
    }
}
