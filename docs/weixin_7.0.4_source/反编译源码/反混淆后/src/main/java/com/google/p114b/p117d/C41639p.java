package com.google.p114b.p117d;

import com.facebook.appevents.AppEventsConstants;
import com.google.p114b.C25577g;
import com.google.p114b.C37292a;
import com.google.p114b.C41638c;
import com.google.p114b.p801b.C45061b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

/* renamed from: com.google.b.d.p */
public final class C41639p implements C25577g {
    private final C32084j bAB = new C32084j();

    public C41639p() {
        AppMethodBeat.m2504i(57328);
        AppMethodBeat.m2505o(57328);
    }

    /* renamed from: a */
    public final C45061b mo3688a(String str, C37292a c37292a, int i, int i2, Map<C41638c, ?> map) {
        AppMethodBeat.m2504i(57329);
        if (c37292a != C37292a.UPC_A) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can only encode UPC-A, but got ".concat(String.valueOf(c37292a)));
            AppMethodBeat.m2505o(57329);
            throw illegalArgumentException;
        }
        C45061b a = this.bAB.mo3688a(C41639p.m72998bk(str), C37292a.EAN_13, i, i2, map);
        AppMethodBeat.m2505o(57329);
        return a;
    }

    /* renamed from: bk */
    private static String m72998bk(String str) {
        Object str2;
        AppMethodBeat.m2504i(57330);
        int length = str2.length();
        if (length == 11) {
            int i = 0;
            for (length = 0; length < 11; length++) {
                i += (length % 2 == 0 ? 3 : 1) * (str2.charAt(length) - 48);
            }
            str2 = str2 + ((1000 - i) % 10);
        } else if (length != 12) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Requested contents should be 11 or 12 digits long, but got " + str2.length());
            AppMethodBeat.m2505o(57330);
            throw illegalArgumentException;
        }
        String concat = AppEventsConstants.EVENT_PARAM_VALUE_NO.concat(String.valueOf(str2));
        AppMethodBeat.m2505o(57330);
        return concat;
    }
}
