package org.p1128b.p1131c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import org.p1128b.p1130b.C36912c;
import org.p1128b.p1132d.C24599c;
import org.p1128b.p1134g.C36644c;
import org.p1128b.p1134g.C46862d;

/* renamed from: org.b.c.e */
public final class C16473e implements C46858d {
    /* renamed from: a */
    public final String mo30361a(C24599c c24599c) {
        AppMethodBeat.m2504i(77237);
        C46862d.m89100r(c24599c, "Cannot extract a header from a null object");
        if (c24599c.BYN == null || c24599c.BYN.size() <= 0) {
            C36912c c36912c = new C36912c(c24599c);
            AppMethodBeat.m2505o(77237);
            throw c36912c;
        }
        Map map = c24599c.BYN;
        StringBuffer stringBuffer = new StringBuffer(map.size() * 20);
        stringBuffer.append("OAuth ");
        for (String str : map.keySet()) {
            if (stringBuffer.length() > 6) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(String.format("%s=\"%s\"", new Object[]{str, C36644c.encode((String) map.get(str))}));
        }
        String str2 = stringBuffer.toString();
        AppMethodBeat.m2505o(77237);
        return str2;
    }
}
