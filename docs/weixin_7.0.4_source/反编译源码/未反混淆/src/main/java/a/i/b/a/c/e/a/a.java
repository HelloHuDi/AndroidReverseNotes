package a.i.b.a.c.e.a;

import a.a.h;
import a.a.i;
import a.a.t;
import a.a.v;
import a.f.b.j;
import java.util.ArrayList;
import java.util.List;

public abstract class a {
    public static final a Bws = new a();
    public final int Bwp;
    private final List<Integer> Bwq;
    private final int[] Bwr;
    public final int major;
    public final int minor;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public a(int... iArr) {
        int intValue;
        List m;
        int i = -1;
        j.p(iArr, "numbers");
        this.Bwr = iArr;
        Integer j = i.j(this.Bwr, 0);
        if (j != null) {
            intValue = j.intValue();
        } else {
            intValue = -1;
        }
        this.major = intValue;
        j = i.j(this.Bwr, 1);
        if (j != null) {
            intValue = j.intValue();
        } else {
            intValue = -1;
        }
        this.minor = intValue;
        j = i.j(this.Bwr, 2);
        if (j != null) {
            i = j.intValue();
        }
        this.Bwp = i;
        if (this.Bwr.length > 3) {
            m = t.m(h.I(this.Bwr).subList(3, this.Bwr.length));
        } else {
            m = v.AUP;
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
        return list.isEmpty() ? "unknown" : t.a((Iterable) list, (CharSequence) ".", null, null, 0, null, null, 62);
    }

    public boolean equals(Object obj) {
        return obj != null && j.j(getClass(), obj.getClass()) && this.major == ((a) obj).major && this.minor == ((a) obj).minor && this.Bwp == ((a) obj).Bwp && j.j(this.Bwq, ((a) obj).Bwq);
    }

    public int hashCode() {
        int i = this.major;
        i += (i * 31) + this.minor;
        i += (i * 31) + this.Bwp;
        return i + ((i * 31) + this.Bwq.hashCode());
    }
}
