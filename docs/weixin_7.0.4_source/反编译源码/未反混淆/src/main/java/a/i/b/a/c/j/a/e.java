package a.i.b.a.c.j.a;

import a.f.b.j;
import a.i.b.a.c.b.am;
import a.i.b.a.c.e.a;
import a.i.b.a.c.e.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e {
    final c AWq;
    final a.c BGD;
    final a.i.b.a.c.e.a.a BGE;
    final am BGF;

    /* JADX WARNING: Missing block: B:11:0x0034, code skipped:
            if (a.f.b.j.j(r3.BGF, r4.BGF) != false) goto L_0x0036;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(Object obj) {
        AppMethodBeat.i(122251);
        if (this != obj) {
            if (obj instanceof e) {
                e eVar = (e) obj;
                if (j.j(this.AWq, eVar.AWq)) {
                    if (j.j(this.BGD, eVar.BGD)) {
                        if (j.j(this.BGE, eVar.BGE)) {
                        }
                    }
                }
            }
            AppMethodBeat.o(122251);
            return false;
        }
        AppMethodBeat.o(122251);
        return true;
    }

    public final int hashCode() {
        int i = 0;
        AppMethodBeat.i(122250);
        c cVar = this.AWq;
        int hashCode = (cVar != null ? cVar.hashCode() : 0) * 31;
        a.c cVar2 = this.BGD;
        hashCode = ((cVar2 != null ? cVar2.hashCode() : 0) + hashCode) * 31;
        a.i.b.a.c.e.a.a aVar = this.BGE;
        int hashCode2 = ((aVar != null ? aVar.hashCode() : 0) + hashCode) * 31;
        am amVar = this.BGF;
        if (amVar != null) {
            i = amVar.hashCode();
        }
        hashCode2 += i;
        AppMethodBeat.o(122250);
        return hashCode2;
    }

    public final String toString() {
        AppMethodBeat.i(122249);
        String str = "ClassData(nameResolver=" + this.AWq + ", classProto=" + this.BGD + ", metadataVersion=" + this.BGE + ", sourceElement=" + this.BGF + ")";
        AppMethodBeat.o(122249);
        return str;
    }

    public e(c cVar, a.c cVar2, a.i.b.a.c.e.a.a aVar, am amVar) {
        j.p(cVar, "nameResolver");
        j.p(cVar2, "classProto");
        j.p(aVar, "metadataVersion");
        j.p(amVar, "sourceElement");
        AppMethodBeat.i(122248);
        this.AWq = cVar;
        this.BGD = cVar2;
        this.BGE = aVar;
        this.BGF = amVar;
        AppMethodBeat.o(122248);
    }
}
