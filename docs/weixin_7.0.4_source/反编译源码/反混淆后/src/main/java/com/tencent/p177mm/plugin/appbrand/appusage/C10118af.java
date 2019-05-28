package com.tencent.p177mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.p241b.C1679e;
import com.tencent.p177mm.kernel.p242c.C1694a;
import com.tencent.p177mm.plugin.appbrand.p1468a.C38095c;
import com.tencent.p177mm.sdk.p603e.C4928g;
import java.util.List;

@C1679e(C38095c.class)
/* renamed from: com.tencent.mm.plugin.appbrand.appusage.af */
public interface C10118af extends C1694a, C4928g {

    /* renamed from: com.tencent.mm.plugin.appbrand.appusage.af$a */
    public enum C10117a {
        DESC,
        ASC,
        UPATE_TIME_DESC;

        static {
            AppMethodBeat.m2505o(114907);
        }
    }

    /* renamed from: a */
    List<LocalUsageInfo> mo21470a(int i, C10117a c10117a);

    /* renamed from: aB */
    boolean mo21471aB(String str, int i);

    /* renamed from: aC */
    int mo21472aC(String str, int i);

    /* renamed from: aD */
    boolean mo21473aD(String str, int i);

    void awX();

    int awY();

    /* renamed from: g */
    boolean mo21476g(List<LocalUsageInfo> list, int i);

    int getCount();
}
