package org.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.OutputStream;
import org.b.b.b;
import org.b.d.h;
import org.b.g.d;

public final class a {
    public String BYE;
    public String BYF;
    public String BYG = "oob";
    public org.b.a.a.a BYH;
    public h BYI = h.Header;
    public OutputStream BYJ = null;
    public String scope;

    public static org.b.a.a.a bg(Class<? extends org.b.a.a.a> cls) {
        AppMethodBeat.i(77233);
        d.r(cls, "Api class cannot be null");
        try {
            org.b.a.a.a aVar = (org.b.a.a.a) cls.newInstance();
            AppMethodBeat.o(77233);
            return aVar;
        } catch (Exception e) {
            b bVar = new b("Error while creating the Api object", e);
            AppMethodBeat.o(77233);
            throw bVar;
        }
    }
}
