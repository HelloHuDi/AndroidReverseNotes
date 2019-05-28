package org.apache.commons.p1431a.p1581a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import java.io.Writer;

/* renamed from: org.apache.commons.a.a.b */
public final class C41167b extends Writer implements Serializable {
    private final StringBuilder BWD;

    public C41167b() {
        AppMethodBeat.m2504i(136502);
        this.BWD = new StringBuilder();
        AppMethodBeat.m2505o(136502);
    }

    public C41167b(byte b) {
        AppMethodBeat.m2504i(136503);
        this.BWD = new StringBuilder(4);
        AppMethodBeat.m2505o(136503);
    }

    public final Writer append(char c) {
        AppMethodBeat.m2504i(136504);
        this.BWD.append(c);
        AppMethodBeat.m2505o(136504);
        return this;
    }

    public final Writer append(CharSequence charSequence) {
        AppMethodBeat.m2504i(136505);
        this.BWD.append(charSequence);
        AppMethodBeat.m2505o(136505);
        return this;
    }

    public final Writer append(CharSequence charSequence, int i, int i2) {
        AppMethodBeat.m2504i(136506);
        this.BWD.append(charSequence, i, i2);
        AppMethodBeat.m2505o(136506);
        return this;
    }

    public final void close() {
    }

    public final void flush() {
    }

    public final void write(String str) {
        AppMethodBeat.m2504i(136507);
        if (str != null) {
            this.BWD.append(str);
        }
        AppMethodBeat.m2505o(136507);
    }

    public final void write(char[] cArr, int i, int i2) {
        AppMethodBeat.m2504i(136508);
        if (cArr != null) {
            this.BWD.append(cArr, i, i2);
        }
        AppMethodBeat.m2505o(136508);
    }

    public final String toString() {
        AppMethodBeat.m2504i(136509);
        String stringBuilder = this.BWD.toString();
        AppMethodBeat.m2505o(136509);
        return stringBuilder;
    }
}
