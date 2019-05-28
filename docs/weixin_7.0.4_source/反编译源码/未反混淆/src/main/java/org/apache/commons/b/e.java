package org.apache.commons.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.apache.commons.b.b.a;

public final class e {
    public static String aa(Object[] objArr) {
        int i;
        AppMethodBeat.i(116957);
        if (objArr[0] == null) {
            i = 16;
        } else {
            i = objArr[0].toString().length();
        }
        a aVar = new a((i + 1) * 3);
        for (i = 0; i < 3; i++) {
            if (i > 0) {
                aVar.emU();
            }
            if (objArr[i] != null) {
                Object obj = objArr[i];
                if (obj == null) {
                    aVar.emT();
                } else {
                    aVar.awR(obj.toString());
                }
            }
        }
        String aVar2 = aVar.toString();
        AppMethodBeat.o(116957);
        return aVar2;
    }
}
