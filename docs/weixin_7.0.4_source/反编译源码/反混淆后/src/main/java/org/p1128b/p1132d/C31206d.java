package org.p1128b.p1132d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.p1128b.p1134g.C36644c;

/* renamed from: org.b.d.d */
public final class C31206d implements Comparable<C31206d> {
    private final String key;
    private final String value;

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        AppMethodBeat.m2504i(77274);
        C31206d c31206d = (C31206d) obj;
        int compareTo = this.key.compareTo(c31206d.key);
        if (compareTo != 0) {
            AppMethodBeat.m2505o(77274);
            return compareTo;
        }
        compareTo = this.value.compareTo(c31206d.value);
        AppMethodBeat.m2505o(77274);
        return compareTo;
    }

    public C31206d(String str, String str2) {
        this.key = str;
        this.value = str2;
    }

    public final String eng() {
        AppMethodBeat.m2504i(77271);
        String concat = C36644c.encode(this.key).concat("=").concat(C36644c.encode(this.value));
        AppMethodBeat.m2505o(77271);
        return concat;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(77272);
        if (obj == null) {
            AppMethodBeat.m2505o(77272);
            return false;
        } else if (obj == this) {
            AppMethodBeat.m2505o(77272);
            return true;
        } else if (obj instanceof C31206d) {
            C31206d c31206d = (C31206d) obj;
            if (c31206d.key.equals(this.key) && c31206d.value.equals(this.value)) {
                AppMethodBeat.m2505o(77272);
                return true;
            }
            AppMethodBeat.m2505o(77272);
            return false;
        } else {
            AppMethodBeat.m2505o(77272);
            return false;
        }
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(77273);
        int hashCode = this.key.hashCode() + this.value.hashCode();
        AppMethodBeat.m2505o(77273);
        return hashCode;
    }
}
