package org.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import org.b.g.d;

public final class i implements Serializable {
    private final String rawResponse;
    public final String token;
    public final String wFn;

    public i(String str, String str2) {
        this(str, str2, null);
    }

    public i(String str, String str2, String str3) {
        AppMethodBeat.i(77267);
        d.r(str, "Token can't be null");
        d.r(str2, "Secret can't be null");
        this.token = str;
        this.wFn = str2;
        this.rawResponse = str3;
        AppMethodBeat.o(77267);
    }

    public final String toString() {
        AppMethodBeat.i(77268);
        String format = String.format("Token[%s , %s]", new Object[]{this.token, this.wFn});
        AppMethodBeat.o(77268);
        return format;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(77269);
        if (this == obj) {
            AppMethodBeat.o(77269);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(77269);
            return false;
        } else {
            i iVar = (i) obj;
            if (this.token.equals(iVar.token) && this.wFn.equals(iVar.wFn)) {
                AppMethodBeat.o(77269);
                return true;
            }
            AppMethodBeat.o(77269);
            return false;
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(77270);
        int hashCode = (this.token.hashCode() * 31) + this.wFn.hashCode();
        AppMethodBeat.o(77270);
        return hashCode;
    }
}
