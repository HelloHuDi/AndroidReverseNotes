package android.support.v4.f;

public final class j<F, S> {
    public final F first;
    public final S second;

    public j(F f, S s) {
        this.first = f;
        this.second = s;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        if (e(jVar.first, this.first) && e(jVar.second, this.second)) {
            return true;
        }
        return false;
    }

    private static boolean e(Object obj, Object obj2) {
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
