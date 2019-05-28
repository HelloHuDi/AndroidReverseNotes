package a.i.b.a.c.i.d;

import a.i.b.a.c.f.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;

public final class b {
    private a.i.b.a.c.f.b BfP;
    public final String BrD;

    public static b awj(String str) {
        AppMethodBeat.i(122156);
        b bVar = new b(str);
        AppMethodBeat.o(122156);
        return bVar;
    }

    public static b o(a.i.b.a.c.f.b bVar) {
        AppMethodBeat.i(122158);
        b bVar2 = new b(bVar.ByQ.ByV.replace('.', IOUtils.DIR_SEPARATOR_UNIX));
        bVar2.BfP = bVar;
        AppMethodBeat.o(122158);
        return bVar2;
    }

    private b(String str) {
        this.BrD = str;
    }

    public final a.i.b.a.c.f.b ejz() {
        AppMethodBeat.i(122159);
        int lastIndexOf = this.BrD.lastIndexOf("/");
        a.i.b.a.c.f.b bVar;
        if (lastIndexOf == -1) {
            bVar = a.i.b.a.c.f.b.ByP;
            AppMethodBeat.o(122159);
            return bVar;
        }
        bVar = new a.i.b.a.c.f.b(this.BrD.substring(0, lastIndexOf).replace(IOUtils.DIR_SEPARATOR_UNIX, '.'));
        AppMethodBeat.o(122159);
        return bVar;
    }

    public final String toString() {
        return this.BrD;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(122160);
        if (this == obj) {
            AppMethodBeat.o(122160);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(122160);
            return false;
        } else {
            boolean equals = this.BrD.equals(((b) obj).BrD);
            AppMethodBeat.o(122160);
            return equals;
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(122161);
        int hashCode = this.BrD.hashCode();
        AppMethodBeat.o(122161);
        return hashCode;
    }

    public static b h(a aVar) {
        AppMethodBeat.i(122157);
        a.i.b.a.c.f.b bVar = aVar.BcW;
        String replace = aVar.ByN.ByQ.ByV.replace('.', '$');
        b bVar2;
        if (bVar.ehF()) {
            bVar2 = new b(replace);
            AppMethodBeat.o(122157);
            return bVar2;
        }
        bVar2 = new b(bVar.ByQ.ByV.replace('.', IOUtils.DIR_SEPARATOR_UNIX) + "/" + replace);
        AppMethodBeat.o(122157);
        return bVar2;
    }
}
