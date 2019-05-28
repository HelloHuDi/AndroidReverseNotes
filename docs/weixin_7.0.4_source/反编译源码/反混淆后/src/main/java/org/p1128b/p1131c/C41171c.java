package org.p1128b.p1131c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import org.p1128b.p1130b.C36912c;
import org.p1128b.p1132d.C16475e;
import org.p1128b.p1132d.C24599c;
import org.p1128b.p1134g.C36644c;
import org.p1128b.p1134g.C46862d;

/* renamed from: org.b.c.c */
public final class C41171c implements C44624b {
    /* renamed from: a */
    public final String mo65771a(C24599c c24599c) {
        AppMethodBeat.m2504i(77241);
        C46862d.m89100r(c24599c, "Cannot extract base string from null object");
        if (c24599c.BYN == null || c24599c.BYN.size() <= 0) {
            C36912c c36912c = new C36912c(c24599c);
            AppMethodBeat.m2505o(77241);
            throw c36912c;
        }
        String encode = C36644c.encode(c24599c.emZ().name());
        String encode2 = C36644c.encode(c24599c.enf());
        C16475e c16475e = new C16475e();
        c16475e.mo30363a(c24599c.emY());
        c16475e.mo30363a(c24599c.ene());
        c16475e.mo30363a(new C16475e(c24599c.BYN));
        C16475e c16475e2 = new C16475e(c16475e.BYO);
        Collections.sort(c16475e2.BYO);
        String encode3 = C36644c.encode(c16475e2.enh());
        encode = String.format("%s&%s&%s", new Object[]{encode, encode2, encode3});
        AppMethodBeat.m2505o(77241);
        return encode;
    }
}
