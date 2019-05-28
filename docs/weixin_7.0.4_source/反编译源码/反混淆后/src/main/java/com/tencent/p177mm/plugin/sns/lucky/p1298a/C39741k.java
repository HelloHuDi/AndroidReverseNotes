package com.tencent.p177mm.plugin.sns.lucky.p1298a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.sns.p1025h.C29037i;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.nio.charset.Charset;

/* renamed from: com.tencent.mm.plugin.sns.lucky.a.k */
public final class C39741k {
    /* JADX WARNING: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x004d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: h */
    public static C29037i m67966h(C5127a c5127a) {
        Exception exception;
        C29037i c29037i;
        AppMethodBeat.m2504i(35889);
        C29037i c29037i2 = new C29037i();
        C1720g.m3537RQ();
        String str = (String) C1720g.m3536RP().mo5239Ry().get(c5127a, null);
        if (str == null) {
            C4990ab.m7416i("MicroMsg.RedDotUtil", "load: redDotList data empty");
            AppMethodBeat.m2505o(35889);
            return c29037i2;
        }
        C29037i c29037i3;
        try {
            c29037i3 = (C29037i) new C29037i().parseFrom(str.getBytes(Charset.forName("ISO-8859-1")));
            if (c29037i3 == null) {
                try {
                    c29037i3 = new C29037i();
                } catch (Exception e) {
                    exception = e;
                    c29037i = c29037i3;
                    C4990ab.m7412e("MicroMsg.RedDotUtil", "getRedDotList " + exception.getMessage());
                    c29037i3 = c29037i;
                    if (c29037i3 == null) {
                    }
                    AppMethodBeat.m2505o(35889);
                    return c29037i3;
                }
            }
        } catch (Exception e2) {
            exception = e2;
            c29037i = c29037i2;
            C4990ab.m7412e("MicroMsg.RedDotUtil", "getRedDotList " + exception.getMessage());
            c29037i3 = c29037i;
            if (c29037i3 == null) {
            }
            AppMethodBeat.m2505o(35889);
            return c29037i3;
        }
        if (c29037i3 == null) {
            c29037i3 = new C29037i();
        }
        AppMethodBeat.m2505o(35889);
        return c29037i3;
    }
}
