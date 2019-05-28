package p000a.p010i.p011b.p012a.p015c.p033e.p776a;

import java.util.ArrayList;
import java.util.List;
import p000a.p001a.C17115v;
import p000a.p001a.C25035t;
import p000a.p001a.C36646h;
import p000a.p001a.C36913i;
import p000a.p005f.p007b.C25052j;

/* renamed from: a.i.b.a.c.e.a.a */
public abstract class C31698a {
    public static final C17253a Bws = new C17253a();
    public final int Bwp;
    private final List<Integer> Bwq;
    private final int[] Bwr;
    public final int major;
    public final int minor;

    /* renamed from: a.i.b.a.c.e.a.a$a */
    public static final class C17253a {
        private C17253a() {
        }

        public /* synthetic */ C17253a(byte b) {
            this();
        }
    }

    public C31698a(int... iArr) {
        int intValue;
        List m;
        int i = -1;
        C25052j.m39376p(iArr, "numbers");
        this.Bwr = iArr;
        Integer j = C36913i.m61700j(this.Bwr, 0);
        if (j != null) {
            intValue = j.intValue();
        } else {
            intValue = -1;
        }
        this.major = intValue;
        j = C36913i.m61700j(this.Bwr, 1);
        if (j != null) {
            intValue = j.intValue();
        } else {
            intValue = -1;
        }
        this.minor = intValue;
        j = C36913i.m61700j(this.Bwr, 2);
        if (j != null) {
            i = j.intValue();
        }
        this.Bwp = i;
        if (this.Bwr.length > 3) {
            m = C25035t.m39352m(C36646h.m60744I(this.Bwr).subList(3, this.Bwr.length));
        } else {
            m = C17115v.AUP;
        }
        this.Bwq = m;
    }

    public String toString() {
        int[] iArr = this.Bwr;
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            int i2;
            if (i != -1) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (i2 == 0) {
                break;
            }
            arrayList.add(Integer.valueOf(i));
        }
        List list = arrayList;
        return list.isEmpty() ? "unknown" : C25035t.m39322a((Iterable) list, (CharSequence) ".", null, null, 0, null, null, 62);
    }

    public boolean equals(Object obj) {
        return obj != null && C25052j.m39373j(getClass(), obj.getClass()) && this.major == ((C31698a) obj).major && this.minor == ((C31698a) obj).minor && this.Bwp == ((C31698a) obj).Bwp && C25052j.m39373j(this.Bwq, ((C31698a) obj).Bwq);
    }

    public int hashCode() {
        int i = this.major;
        i += (i * 31) + this.minor;
        i += (i * 31) + this.Bwp;
        return i + ((i * 31) + this.Bwq.hashCode());
    }
}
