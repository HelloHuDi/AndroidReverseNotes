package p000a.p010i.p011b.p012a.p015c.p033e.p034b.p777a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import p000a.p001a.C25032am;
import p000a.p005f.p007b.C25052j;

/* renamed from: a.i.b.a.c.e.b.a.m */
public final class C17264m {
    private final LinkedHashMap<String, String> ByK = new LinkedHashMap();
    final Set<String> ByL = new LinkedHashSet();
    private final String ByM;

    public C17264m(String str) {
        C25052j.m39376p(str, "packageFqName");
        AppMethodBeat.m2504i(121347);
        this.ByM = str;
        AppMethodBeat.m2505o(121347);
    }

    public final Set<String> ehA() {
        AppMethodBeat.m2504i(121342);
        Set keySet = this.ByK.keySet();
        C25052j.m39375o(keySet, "packageParts.keys");
        AppMethodBeat.m2505o(121342);
        return keySet;
    }

    /* renamed from: iY */
    public final void mo31331iY(String str, String str2) {
        AppMethodBeat.m2504i(121343);
        C25052j.m39376p(str, "partInternalName");
        this.ByK.put(str, str2);
        AppMethodBeat.m2505o(121343);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(121344);
        if ((obj instanceof C17264m) && C25052j.m39373j(((C17264m) obj).ByM, this.ByM) && C25052j.m39373j(((C17264m) obj).ByK, this.ByK) && C25052j.m39373j(((C17264m) obj).ByL, this.ByL)) {
            AppMethodBeat.m2505o(121344);
            return true;
        }
        AppMethodBeat.m2505o(121344);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(121345);
        int hashCode = (((this.ByM.hashCode() * 31) + this.ByK.hashCode()) * 31) + this.ByL.hashCode();
        AppMethodBeat.m2505o(121345);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.m2504i(121346);
        String obj = C25032am.m39316a(ehA(), this.ByL).toString();
        AppMethodBeat.m2505o(121346);
        return obj;
    }
}
