package p000a.p010i.p011b.p012a.p015c.p778f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.p005f.p007b.C25052j;
import p000a.p051k.C25274k;

/* renamed from: a.i.b.a.c.f.g */
public final class C44901g {
    private static final C25274k Bza = new C25274k("[^\\p{L}\\p{Digit}]");
    public static final C44901g Bzb = new C44901g();

    static {
        AppMethodBeat.m2504i(121401);
        AppMethodBeat.m2505o(121401);
    }

    private C44901g() {
    }

    public static final String awb(String str) {
        AppMethodBeat.m2504i(121400);
        C25052j.m39376p(str, "name");
        C25274k c25274k = Bza;
        CharSequence charSequence = str;
        String str2 = "_";
        C25052j.m39376p(charSequence, "input");
        C25052j.m39376p(str2, "replacement");
        String replaceAll = c25274k.BPf.matcher(charSequence).replaceAll(str2);
        C25052j.m39375o(replaceAll, "nativePattern.matcher(in…).replaceAll(replacement)");
        AppMethodBeat.m2505o(121400);
        return replaceAll;
    }
}
