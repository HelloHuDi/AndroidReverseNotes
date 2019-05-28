package org.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import org.b.d.c;
import org.b.g.d;

public final class e implements d {
    public final String a(c cVar) {
        AppMethodBeat.i(77237);
        d.r(cVar, "Cannot extract a header from a null object");
        if (cVar.BYN == null || cVar.BYN.size() <= 0) {
            org.b.b.c cVar2 = new org.b.b.c(cVar);
            AppMethodBeat.o(77237);
            throw cVar2;
        }
        Map map = cVar.BYN;
        StringBuffer stringBuffer = new StringBuffer(map.size() * 20);
        stringBuffer.append("OAuth ");
        for (String str : map.keySet()) {
            if (stringBuffer.length() > 6) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(String.format("%s=\"%s\"", new Object[]{str, org.b.g.c.encode((String) map.get(str))}));
        }
        String str2 = stringBuffer.toString();
        AppMethodBeat.o(77237);
        return str2;
    }
}
