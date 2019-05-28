package org.apache.commons.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import java.io.Writer;

public final class b extends Writer implements Serializable {
    private final StringBuilder BWD;

    public b() {
        AppMethodBeat.i(136502);
        this.BWD = new StringBuilder();
        AppMethodBeat.o(136502);
    }

    public b(byte b) {
        AppMethodBeat.i(136503);
        this.BWD = new StringBuilder(4);
        AppMethodBeat.o(136503);
    }

    public final Writer append(char c) {
        AppMethodBeat.i(136504);
        this.BWD.append(c);
        AppMethodBeat.o(136504);
        return this;
    }

    public final Writer append(CharSequence charSequence) {
        AppMethodBeat.i(136505);
        this.BWD.append(charSequence);
        AppMethodBeat.o(136505);
        return this;
    }

    public final Writer append(CharSequence charSequence, int i, int i2) {
        AppMethodBeat.i(136506);
        this.BWD.append(charSequence, i, i2);
        AppMethodBeat.o(136506);
        return this;
    }

    public final void close() {
    }

    public final void flush() {
    }

    public final void write(String str) {
        AppMethodBeat.i(136507);
        if (str != null) {
            this.BWD.append(str);
        }
        AppMethodBeat.o(136507);
    }

    public final void write(char[] cArr, int i, int i2) {
        AppMethodBeat.i(136508);
        if (cArr != null) {
            this.BWD.append(cArr, i, i2);
        }
        AppMethodBeat.o(136508);
    }

    public final String toString() {
        AppMethodBeat.i(136509);
        String stringBuilder = this.BWD.toString();
        AppMethodBeat.o(136509);
        return stringBuilder;
    }
}
