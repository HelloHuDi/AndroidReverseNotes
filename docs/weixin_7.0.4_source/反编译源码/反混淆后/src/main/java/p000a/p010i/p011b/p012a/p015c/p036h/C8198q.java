package p000a.p010i.p011b.p012a.p015c.p036h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;
import p000a.p010i.p011b.p012a.p015c.p778f.C8175c;

/* renamed from: a.i.b.a.c.h.q */
public final class C8198q {
    /* renamed from: y */
    public static final String m14454y(C37022f c37022f) {
        AppMethodBeat.m2504i(121914);
        C25052j.m39376p(c37022f, "receiver$0");
        String stringBuilder;
        if (C8198q.m14455z(c37022f)) {
            StringBuilder stringBuilder2 = new StringBuilder();
            String str = c37022f.name;
            C25052j.m39375o(str, "asString()");
            stringBuilder = stringBuilder2.append("`".concat(String.valueOf(str))).append('`').toString();
            AppMethodBeat.m2505o(121914);
            return stringBuilder;
        }
        stringBuilder = c37022f.name;
        C25052j.m39375o(stringBuilder, "asString()");
        AppMethodBeat.m2505o(121914);
        return stringBuilder;
    }

    /* renamed from: g */
    public static final String m14453g(C8175c c8175c) {
        AppMethodBeat.m2504i(121916);
        C25052j.m39376p(c8175c, "receiver$0");
        List ehM = c8175c.ehM();
        C25052j.m39375o(ehM, "pathSegments()");
        String fZ = C8198q.m14452fZ(ehM);
        AppMethodBeat.m2505o(121916);
        return fZ;
    }

    /* renamed from: fZ */
    public static final String m14452fZ(List<C37022f> list) {
        AppMethodBeat.m2504i(121917);
        C25052j.m39376p(list, "pathSegments");
        StringBuilder stringBuilder = new StringBuilder();
        for (C37022f c37022f : list) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(".");
            }
            stringBuilder.append(C8198q.m14454y(c37022f));
        }
        String stringBuilder2 = stringBuilder.toString();
        C25052j.m39375o(stringBuilder2, "StringBuilder().apply(builderAction).toString()");
        AppMethodBeat.m2505o(121917);
        return stringBuilder2;
    }

    /* renamed from: z */
    private static final boolean m14455z(C37022f c37022f) {
        AppMethodBeat.m2504i(121915);
        if (c37022f.ByZ) {
            AppMethodBeat.m2505o(121915);
            return false;
        }
        String str = c37022f.name;
        C25052j.m39375o(str, "asString()");
        if (!C31735l.BDt.contains(str)) {
            boolean z;
            CharSequence charSequence = str;
            for (int i = 0; i < charSequence.length(); i++) {
                boolean z2;
                char charAt = charSequence.charAt(i);
                if (Character.isLetterOrDigit(charAt) || charAt == '_') {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (z2) {
                    z = true;
                    break;
                }
            }
            z = false;
            if (!z) {
                AppMethodBeat.m2505o(121915);
                return false;
            }
        }
        AppMethodBeat.m2505o(121915);
        return true;
    }
}
