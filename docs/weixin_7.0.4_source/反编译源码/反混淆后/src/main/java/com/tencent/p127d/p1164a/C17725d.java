package com.tencent.p127d.p1164a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p127d.p132e.p133a.C25602c;
import com.tencent.p127d.p132e.p133a.p1165b.C17729a;
import com.tencent.p127d.p132e.p133a.p1165b.C41663c;
import com.tencent.p127d.p132e.p133a.p1165b.C41664d;
import com.tencent.p127d.p807b.C8760c;

/* renamed from: com.tencent.d.a.d */
public final class C17725d {

    /* renamed from: com.tencent.d.a.d$1 */
    public static class C177241 implements C25602c {
        final /* synthetic */ C41660b ArF;
        final /* synthetic */ C8760c ArG;

        public C177241(C41660b c41660b, C8760c c8760c) {
            this.ArF = c41660b;
            this.ArG = c8760c;
        }

        public final void asv() {
            AppMethodBeat.m2504i(114465);
            this.ArF.mo8081m(-10, new byte[0]);
            AppMethodBeat.m2505o(114465);
        }

        /* renamed from: a */
        public final C41664d mo32830a(String str, String str2, C17729a c17729a) {
            AppMethodBeat.m2504i(114466);
            boolean a = C17725d.m27649a(this.ArG, this.ArF, str, str2, c17729a);
            C41664d c41664d = new C41664d();
            if (!a) {
                c41664d.errorCode = -1;
            }
            AppMethodBeat.m2505o(114466);
            return c41664d;
        }

        /* renamed from: b */
        public final C41663c mo32832b(String str, String str2, C17729a c17729a) {
            AppMethodBeat.m2504i(114467);
            boolean a = C17725d.m27649a(this.ArG, this.ArF, str, str2, c17729a);
            C41663c c41663c = new C41663c();
            if (!a) {
                c41663c.errCode = -1;
            }
            AppMethodBeat.m2505o(114467);
            return c41663c;
        }
    }

    /* renamed from: a */
    static /* synthetic */ boolean m27649a(C8760c c8760c, C41660b c41660b, String str, String str2, C17729a c17729a) {
        boolean z = false;
        AppMethodBeat.m2504i(114468);
        byte[] c = c8760c.mo19821c(str, str2, c17729a);
        if (c == null || c.length == 0) {
            c41660b.mo8081m(-20, new byte[0]);
        } else {
            z = c41660b.mo8081m(0, c);
        }
        AppMethodBeat.m2505o(114468);
        return z;
    }
}
