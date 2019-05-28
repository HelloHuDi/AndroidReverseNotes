package a.i.b.a.c.d.a.c.b;

import a.f.b.j;
import a.i.b.a.c.b.ar;
import a.i.b.a.c.d.a.a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    final l BoW;
    final b BoX;
    final boolean BoY;
    final ar BoZ;

    /* JADX WARNING: Missing block: B:13:0x0035, code skipped:
            if (a.f.b.j.j(r5.BoZ, r6.BoZ) != false) goto L_0x0037;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(Object obj) {
        AppMethodBeat.i(120027);
        if (this != obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (j.j(this.BoW, aVar.BoW) && j.j(this.BoX, aVar.BoX)) {
                    if (this.BoY == aVar.BoY) {
                    }
                }
            }
            AppMethodBeat.o(120027);
            return false;
        }
        AppMethodBeat.o(120027);
        return true;
    }

    public final int hashCode() {
        int i = 0;
        AppMethodBeat.i(120026);
        l lVar = this.BoW;
        int hashCode = (lVar != null ? lVar.hashCode() : 0) * 31;
        b bVar = this.BoX;
        hashCode = ((bVar != null ? bVar.hashCode() : 0) + hashCode) * 31;
        int i2 = this.BoY;
        if (i2 != 0) {
            i2 = 1;
        }
        i2 = (i2 + hashCode) * 31;
        ar arVar = this.BoZ;
        if (arVar != null) {
            i = arVar.hashCode();
        }
        i2 += i;
        AppMethodBeat.o(120026);
        return i2;
    }

    public final String toString() {
        AppMethodBeat.i(120025);
        String str = "JavaTypeAttributes(howThisTypeIsUsed=" + this.BoW + ", flexibility=" + this.BoX + ", isForAnnotationParameter=" + this.BoY + ", upperBoundOfTypeParameter=" + this.BoZ + ")";
        AppMethodBeat.o(120025);
        return str;
    }

    private a(l lVar, b bVar, boolean z, ar arVar) {
        j.p(lVar, "howThisTypeIsUsed");
        j.p(bVar, "flexibility");
        AppMethodBeat.i(120023);
        this.BoW = lVar;
        this.BoX = bVar;
        this.BoY = z;
        this.BoZ = arVar;
        AppMethodBeat.o(120023);
    }

    public /* synthetic */ a(l lVar, boolean z, ar arVar) {
        this(lVar, b.INFLEXIBLE, z, arVar);
        AppMethodBeat.i(120024);
        AppMethodBeat.o(120024);
    }

    public final a a(b bVar) {
        AppMethodBeat.i(120022);
        j.p(bVar, "flexibility");
        l lVar = this.BoW;
        boolean z = this.BoY;
        ar arVar = this.BoZ;
        j.p(lVar, "howThisTypeIsUsed");
        j.p(bVar, "flexibility");
        a aVar = new a(lVar, bVar, z, arVar);
        AppMethodBeat.o(120022);
        return aVar;
    }
}
