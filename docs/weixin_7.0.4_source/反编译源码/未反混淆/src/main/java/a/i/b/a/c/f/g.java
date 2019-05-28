package a.i.b.a.c.f;

import a.f.b.j;
import a.k.k;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g {
    private static final k Bza = new k("[^\\p{L}\\p{Digit}]");
    public static final g Bzb = new g();

    static {
        AppMethodBeat.i(121401);
        AppMethodBeat.o(121401);
    }

    private g() {
    }

    public static final String awb(String str) {
        AppMethodBeat.i(121400);
        j.p(str, "name");
        k kVar = Bza;
        CharSequence charSequence = str;
        String str2 = "_";
        j.p(charSequence, "input");
        j.p(str2, "replacement");
        String replaceAll = kVar.BPf.matcher(charSequence).replaceAll(str2);
        j.o(replaceAll, "nativePattern.matcher(in…).replaceAll(replacement)");
        AppMethodBeat.o(121400);
        return replaceAll;
    }
}
