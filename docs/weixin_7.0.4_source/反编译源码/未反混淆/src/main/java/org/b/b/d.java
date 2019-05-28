package org.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d extends b {
    public d(String str, Exception exception) {
        super(String.format("Error while signing string: %s", new Object[]{str}), exception);
        AppMethodBeat.i(77236);
        AppMethodBeat.o(77236);
    }
}
