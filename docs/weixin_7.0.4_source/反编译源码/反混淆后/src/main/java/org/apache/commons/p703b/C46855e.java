package org.apache.commons.p703b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.apache.commons.p703b.p705b.C6123a;

/* renamed from: org.apache.commons.b.e */
public final class C46855e {
    /* renamed from: aa */
    public static String m89095aa(Object[] objArr) {
        int i;
        AppMethodBeat.m2504i(116957);
        if (objArr[0] == null) {
            i = 16;
        } else {
            i = objArr[0].toString().length();
        }
        C6123a c6123a = new C6123a((i + 1) * 3);
        for (i = 0; i < 3; i++) {
            if (i > 0) {
                c6123a.emU();
            }
            if (objArr[i] != null) {
                Object obj = objArr[i];
                if (obj == null) {
                    c6123a.emT();
                } else {
                    c6123a.awR(obj.toString());
                }
            }
        }
        String c6123a2 = c6123a.toString();
        AppMethodBeat.m2505o(116957);
        return c6123a2;
    }
}
