package a.i.b.a.c.b.a;

import a.f.b.j;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum e {
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

    private e(String str) {
        AppMethodBeat.i(119320);
        if (str == null) {
            String name = name();
            if (name == null) {
                v vVar = new v("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(119320);
                throw vVar;
            }
            str = name.toLowerCase();
            j.o(str, "(this as java.lang.String).toLowerCase()");
        }
        this.BfB = str;
        AppMethodBeat.o(119320);
    }

    static {
        AppMethodBeat.o(119319);
    }
}
