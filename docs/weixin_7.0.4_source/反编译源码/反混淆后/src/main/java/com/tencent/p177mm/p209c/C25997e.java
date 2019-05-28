package com.tencent.p177mm.p209c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

/* renamed from: com.tencent.mm.c.e */
public final class C25997e {
    /* renamed from: a */
    public static final boolean m41485a(InputStream inputStream, byte[] bArr, int i) {
        AppMethodBeat.m2504i(125683);
        int i2 = 0;
        while (i2 < i) {
            int read = inputStream.read(bArr, i2 + 0, i - i2);
            if (read < 0) {
                AppMethodBeat.m2505o(125683);
                return false;
            }
            i2 += read;
        }
        AppMethodBeat.m2505o(125683);
        return true;
    }
}
