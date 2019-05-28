package a.i.b.a.c.b.c;

import a.i.b.a.c.b.a.g;
import a.i.b.a.c.b.a.g.a;
import a.i.b.a.c.b.am;
import a.i.b.a.c.b.ap;
import a.i.b.a.c.b.l;
import a.i.b.a.c.f.f;
import a.i.b.a.c.k.i;
import a.i.b.a.c.l.ba;

public abstract class b extends e {
    public b(i iVar, l lVar, f fVar, ba baVar, boolean z, int i, am amVar, ap apVar) {
        a aVar = g.BfJ;
        super(iVar, lVar, a.eai(), fVar, baVar, z, i, amVar, apVar);
    }

    public String toString() {
        String str;
        String str2 = "%s%s%s";
        Object[] objArr = new Object[3];
        if (this.Bhk) {
            str = "reified ";
        } else {
            str = "";
        }
        objArr[0] = str;
        if (this.Bhj == ba.INVARIANT) {
            str = "";
        } else {
            str = this.Bhj + " ";
        }
        objArr[1] = str;
        objArr[2] = this.BgZ;
        return String.format(str2, objArr);
    }
}
