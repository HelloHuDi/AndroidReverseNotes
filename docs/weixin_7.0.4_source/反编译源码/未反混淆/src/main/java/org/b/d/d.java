package org.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.b.g.c;

public final class d implements Comparable<d> {
    private final String key;
    private final String value;

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        AppMethodBeat.i(77274);
        d dVar = (d) obj;
        int compareTo = this.key.compareTo(dVar.key);
        if (compareTo != 0) {
            AppMethodBeat.o(77274);
            return compareTo;
        }
        compareTo = this.value.compareTo(dVar.value);
        AppMethodBeat.o(77274);
        return compareTo;
    }

    public d(String str, String str2) {
        this.key = str;
        this.value = str2;
    }

    public final String eng() {
        AppMethodBeat.i(77271);
        String concat = c.encode(this.key).concat("=").concat(c.encode(this.value));
        AppMethodBeat.o(77271);
        return concat;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(77272);
        if (obj == null) {
            AppMethodBeat.o(77272);
            return false;
        } else if (obj == this) {
            AppMethodBeat.o(77272);
            return true;
        } else if (obj instanceof d) {
            d dVar = (d) obj;
            if (dVar.key.equals(this.key) && dVar.value.equals(this.value)) {
                AppMethodBeat.o(77272);
                return true;
            }
            AppMethodBeat.o(77272);
            return false;
        } else {
            AppMethodBeat.o(77272);
            return false;
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(77273);
        int hashCode = this.key.hashCode() + this.value.hashCode();
        AppMethodBeat.o(77273);
        return hashCode;
    }
}
