package p000a.p010i.p011b.p012a.p015c.p018b.p020c;

import p000a.p010i.p011b.p012a.p015c.p018b.C17157ap;
import p000a.p010i.p011b.p012a.p015c.p018b.C31642l;
import p000a.p010i.p011b.p012a.p015c.p018b.C41398am;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g.C0027a;
import p000a.p010i.p011b.p012a.p015c.p044k.C25212i;
import p000a.p010i.p011b.p012a.p015c.p045l.C0163ba;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;

/* renamed from: a.i.b.a.c.b.c.b */
public abstract class C17165b extends C41403e {
    public C17165b(C25212i c25212i, C31642l c31642l, C37022f c37022f, C0163ba c0163ba, boolean z, int i, C41398am c41398am, C17157ap c17157ap) {
        C0027a c0027a = C0026g.BfJ;
        super(c25212i, c31642l, C0027a.eai(), c37022f, c0163ba, z, i, c41398am, c17157ap);
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
        if (this.Bhj == C0163ba.INVARIANT) {
            str = "";
        } else {
            str = this.Bhj + " ";
        }
        objArr[1] = str;
        objArr[2] = this.BgZ;
        return String.format(str2, objArr);
    }
}
