package p000a.p010i.p011b.p012a.p015c.p018b.p019a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;

/* renamed from: a.i.b.a.c.b.a.e */
public enum C8039e {
    FIELD,
    FILE,
    PROPERTY,
    PROPERTY_GETTER("get"),
    PROPERTY_SETTER("set"),
    RECEIVER,
    CONSTRUCTOR_PARAMETER("param"),
    SETTER_PARAMETER("setparam"),
    PROPERTY_DELEGATE_FIELD("delegate");
    
    public final String BfB;

    private C8039e(String str) {
        AppMethodBeat.m2504i(119320);
        if (str == null) {
            String name = name();
            if (name == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.m2505o(119320);
                throw c44941v;
            }
            str = name.toLowerCase();
            C25052j.m39375o(str, "(this as java.lang.String).toLowerCase()");
        }
        this.BfB = str;
        AppMethodBeat.m2505o(119320);
    }

    static {
        AppMethodBeat.m2505o(119319);
    }
}
