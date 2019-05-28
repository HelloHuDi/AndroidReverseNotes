package a.i.b.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

public final class e<K, V> implements Serializable {
    public final K aCx;
    public final V value;

    public e(K k, V v) {
        this.aCx = k;
        this.value = v;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(123004);
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (this.aCx != null ? this.aCx.equals(eVar.aCx) : eVar.aCx == null) {
                if (this.value != null ? !this.value.equals(eVar.value) : eVar.value != null) {
                    AppMethodBeat.o(123004);
                    return true;
                }
            }
            AppMethodBeat.o(123004);
            return false;
        }
        AppMethodBeat.o(123004);
        return false;
    }

    public final int hashCode() {
        int i = 0;
        AppMethodBeat.i(123005);
        int hashCode = this.aCx == null ? 0 : this.aCx.hashCode();
        if (this.value != null) {
            i = this.value.hashCode();
        }
        hashCode ^= i;
        AppMethodBeat.o(123005);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.i(123006);
        String str = this.aCx + "=" + this.value;
        AppMethodBeat.o(123006);
        return str;
    }
}
