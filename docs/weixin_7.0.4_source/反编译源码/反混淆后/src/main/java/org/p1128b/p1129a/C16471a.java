package org.p1128b.p1129a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.OutputStream;
import org.p1128b.p1129a.p1432a.C36640a;
import org.p1128b.p1130b.C36641b;
import org.p1128b.p1132d.C46859h;
import org.p1128b.p1134g.C46862d;

/* renamed from: org.b.a.a */
public final class C16471a {
    public String BYE;
    public String BYF;
    public String BYG = "oob";
    public C36640a BYH;
    public C46859h BYI = C46859h.Header;
    public OutputStream BYJ = null;
    public String scope;

    /* renamed from: bg */
    public static C36640a m25279bg(Class<? extends C36640a> cls) {
        AppMethodBeat.m2504i(77233);
        C46862d.m89100r(cls, "Api class cannot be null");
        try {
            C36640a c36640a = (C36640a) cls.newInstance();
            AppMethodBeat.m2505o(77233);
            return c36640a;
        } catch (Exception e) {
            C36641b c36641b = new C36641b("Error while creating the Api object", e);
            AppMethodBeat.m2505o(77233);
            throw c36641b;
        }
    }
}
