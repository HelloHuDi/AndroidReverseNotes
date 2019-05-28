package org.b.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Random;

public final class d implements c {
    private a BZm = new a();

    static class a {
        a() {
        }
    }

    public d() {
        AppMethodBeat.i(77301);
        AppMethodBeat.o(77301);
    }

    public final String getNonce() {
        AppMethodBeat.i(77302);
        String valueOf = String.valueOf(enn().longValue() + ((long) new Random().nextInt()));
        AppMethodBeat.o(77302);
        return valueOf;
    }

    public final String enm() {
        AppMethodBeat.i(77303);
        String valueOf = String.valueOf(enn());
        AppMethodBeat.o(77303);
        return valueOf;
    }

    private static Long enn() {
        AppMethodBeat.i(77304);
        Long valueOf = Long.valueOf(System.currentTimeMillis() / 1000);
        AppMethodBeat.o(77304);
        return valueOf;
    }
}
