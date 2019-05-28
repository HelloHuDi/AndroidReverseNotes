package p000a.p010i.p011b.p012a.p1149d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

/* renamed from: a.i.b.a.d.e */
public final class C31789e<K, V> implements Serializable {
    public final K aCx;
    public final V value;

    public C31789e(K k, V v) {
        this.aCx = k;
        this.value = v;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(123004);
        if (obj instanceof C31789e) {
            C31789e c31789e = (C31789e) obj;
            if (this.aCx != null ? this.aCx.equals(c31789e.aCx) : c31789e.aCx == null) {
                if (this.value != null ? !this.value.equals(c31789e.value) : c31789e.value != null) {
                    AppMethodBeat.m2505o(123004);
                    return true;
                }
            }
            AppMethodBeat.m2505o(123004);
            return false;
        }
        AppMethodBeat.m2505o(123004);
        return false;
    }

    public final int hashCode() {
        int i = 0;
        AppMethodBeat.m2504i(123005);
        int hashCode = this.aCx == null ? 0 : this.aCx.hashCode();
        if (this.value != null) {
            i = this.value.hashCode();
        }
        hashCode ^= i;
        AppMethodBeat.m2505o(123005);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.m2504i(123006);
        String str = this.aCx + "=" + this.value;
        AppMethodBeat.m2505o(123006);
        return str;
    }
}
