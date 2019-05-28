package android.support.p057v4.p065f;

/* renamed from: android.support.v4.f.j */
public final class C0415j<F, S> {
    public final F first;
    public final S second;

    public C0415j(F f, S s) {
        this.first = f;
        this.second = s;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C0415j)) {
            return false;
        }
        C0415j c0415j = (C0415j) obj;
        if (C0415j.m709e(c0415j.first, this.first) && C0415j.m709e(c0415j.second, this.second)) {
            return true;
        }
        return false;
    }

    /* renamed from: e */
    private static boolean m709e(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = this.first == null ? 0 : this.first.hashCode();
        if (this.second != null) {
            i = this.second.hashCode();
        }
        return hashCode ^ i;
    }

    public final String toString() {
        return "Pair{" + String.valueOf(this.first) + " " + String.valueOf(this.second) + "}";
    }
}
