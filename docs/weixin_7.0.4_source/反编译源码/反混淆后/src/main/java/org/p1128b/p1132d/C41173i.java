package org.p1128b.p1132d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import org.p1128b.p1134g.C46862d;

/* renamed from: org.b.d.i */
public final class C41173i implements Serializable {
    private final String rawResponse;
    public final String token;
    public final String wFn;

    public C41173i(String str, String str2) {
        this(str, str2, null);
    }

    public C41173i(String str, String str2, String str3) {
        AppMethodBeat.m2504i(77267);
        C46862d.m89100r(str, "Token can't be null");
        C46862d.m89100r(str2, "Secret can't be null");
        this.token = str;
        this.wFn = str2;
        this.rawResponse = str3;
        AppMethodBeat.m2505o(77267);
    }

    public final String toString() {
        AppMethodBeat.m2504i(77268);
        String format = String.format("Token[%s , %s]", new Object[]{this.token, this.wFn});
        AppMethodBeat.m2505o(77268);
        return format;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(77269);
        if (this == obj) {
            AppMethodBeat.m2505o(77269);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.m2505o(77269);
            return false;
        } else {
            C41173i c41173i = (C41173i) obj;
            if (this.token.equals(c41173i.token) && this.wFn.equals(c41173i.wFn)) {
                AppMethodBeat.m2505o(77269);
                return true;
            }
            AppMethodBeat.m2505o(77269);
            return false;
        }
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(77270);
        int hashCode = (this.token.hashCode() * 31) + this.wFn.hashCode();
        AppMethodBeat.m2505o(77270);
        return hashCode;
    }
}
