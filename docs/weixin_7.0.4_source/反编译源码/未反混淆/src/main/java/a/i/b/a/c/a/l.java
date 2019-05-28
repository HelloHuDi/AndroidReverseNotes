package a.i.b.a.c.a;

import a.f.b.j;
import a.i.b.a.c.f.a;
import a.i.b.a.c.f.f;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum l {
    UBYTE(r3),
    USHORT(r3),
    UINT(r3),
    ULONG(r3);
    
    final f BbZ;
    final a BcA;
    final a BcB;

    private l(a aVar) {
        j.p(aVar, "classId");
        AppMethodBeat.i(119116);
        this.BcB = aVar;
        f ehK = this.BcB.ByN.ByQ.ehK();
        j.o(ehK, "classId.shortClassName");
        this.BbZ = ehK;
        this.BcA = new a(this.BcB.BcW, f.avX(this.BbZ.name + "Array"));
        AppMethodBeat.o(119116);
    }

    static {
        AppMethodBeat.o(119115);
    }
}
