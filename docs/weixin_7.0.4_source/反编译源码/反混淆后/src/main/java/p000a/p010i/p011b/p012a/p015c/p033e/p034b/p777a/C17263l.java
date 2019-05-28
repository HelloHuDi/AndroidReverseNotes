package p000a.p010i.p011b.p012a.p015c.p033e.p034b.p777a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import p000a.p051k.C6163u;

/* renamed from: a.i.b.a.c.e.b.a.l */
public final class C17263l {
    /* renamed from: iX */
    static final String m26731iX(String str, String str2) {
        AppMethodBeat.m2504i(121341);
        if ((((CharSequence) str).length() == 0 ? 1 : null) != null) {
            AppMethodBeat.m2505o(121341);
            return str2;
        }
        str2 = C6163u.m9834a(str, '.', IOUtils.DIR_SEPARATOR_UNIX) + "/" + str2;
        AppMethodBeat.m2505o(121341);
        return str2;
    }
}
