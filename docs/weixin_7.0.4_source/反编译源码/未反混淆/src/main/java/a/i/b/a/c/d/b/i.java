package a.i.b.a.c.d.b;

import a.f.b.j;
import a.i.b.a.c.b.an;
import a.i.b.a.c.e.a.c;
import a.i.b.a.c.e.a.s;
import a.i.b.a.c.e.b.a.g;
import a.i.b.a.c.f.a;
import a.i.b.a.c.g.i.f;
import a.i.b.a.c.i.d.b;
import a.i.b.a.c.j.a.a.e;
import a.i.b.a.c.j.a.o;
import a.k.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;

public final class i implements e {
    private final boolean BrA;
    final n BrB;
    public final b Brx;
    public final b Bry;
    private final o<g> Brz;
    private final String gTy;

    /* JADX WARNING: Missing block: B:3:0x0041, code skipped:
            if (r0 == null) goto L_0x0043;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private i(b bVar, b bVar2, s sVar, c cVar, o<g> oVar, boolean z, n nVar) {
        String string;
        j.p(bVar, "className");
        j.p(sVar, "packageProto");
        j.p(cVar, "nameResolver");
        AppMethodBeat.i(120271);
        this.Brx = bVar;
        this.Bry = bVar2;
        this.Brz = oVar;
        this.BrA = z;
        this.BrB = nVar;
        a.i.b.a.c.g.i.c cVar2 = sVar;
        f fVar = a.i.b.a.c.e.b.b.BxK;
        j.o(fVar, "JvmProtoBuf.packageModuleName");
        Integer num = (Integer) a.i.b.a.c.e.a.f.a(cVar2, fVar);
        if (num != null) {
            string = cVar.getString(num.intValue());
        }
        string = "main";
        this.gTy = string;
        AppMethodBeat.o(120271);
    }

    public i(n nVar, s sVar, c cVar, o<g> oVar, boolean z) {
        b bVar;
        i iVar;
        b bVar2 = null;
        j.p(nVar, "kotlinClass");
        j.p(sVar, "packageProto");
        j.p(cVar, "nameResolver");
        b h = b.h(nVar.dWY());
        j.o(h, "JvmClassName.byClassId(kotlinClass.classId)");
        String ecv = nVar.dXA().ecv();
        if (ecv != null) {
            if ((((CharSequence) ecv).length() > 0 ? 1 : null) != null) {
                bVar2 = b.awj(ecv);
            }
            bVar = h;
            iVar = this;
        } else {
            bVar = h;
            iVar = this;
        }
        iVar = new i(bVar, bVar2, sVar, cVar, oVar, z, nVar);
        AppMethodBeat.o(120272);
    }

    public final a.i.b.a.c.f.f ect() {
        AppMethodBeat.i(120267);
        String str = this.Brx.BrD;
        j.o(str, "className.internalName");
        a.i.b.a.c.f.f avX = a.i.b.a.c.f.f.avX(v.a(str, (char) IOUtils.DIR_SEPARATOR_UNIX));
        j.o(avX, "Name.identifier(classNam….substringAfterLast('/'))");
        AppMethodBeat.o(120267);
        return avX;
    }

    public final a dWY() {
        AppMethodBeat.i(120268);
        a aVar = new a(this.Brx.ejz(), ect());
        AppMethodBeat.o(120268);
        return aVar;
    }

    public final String toString() {
        AppMethodBeat.i(120269);
        String str = getClass().getSimpleName() + ": " + this.Brx;
        AppMethodBeat.o(120269);
        return str;
    }

    public final an dXz() {
        AppMethodBeat.i(120270);
        an anVar = an.BeS;
        j.o(anVar, "SourceFile.NO_SOURCE_FILE");
        AppMethodBeat.o(120270);
        return anVar;
    }
}
