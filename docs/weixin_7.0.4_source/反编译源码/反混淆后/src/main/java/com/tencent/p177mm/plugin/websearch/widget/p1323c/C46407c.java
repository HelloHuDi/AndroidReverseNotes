package com.tencent.p177mm.plugin.websearch.widget.p1323c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C18178q;
import com.tencent.p177mm.p230g.p232b.p233a.C37820ae;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.Arrays;

/* renamed from: com.tencent.mm.plugin.websearch.widget.c.c */
public final class C46407c {
    /* renamed from: c */
    public static void m87353c(String str, String str2, String... strArr) {
        AppMethodBeat.m2504i(91462);
        C4990ab.m7413e("WidgetPermissionUtil", "permissionFailed appid %s, api %s, args %s", str, str2, Arrays.toString(strArr));
        C7060h.pYm.mo15419k(930, 0, 1);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <= 0; i++) {
            stringBuilder.append(C18178q.encode(strArr[0])).append("&");
        }
        new C37820ae().mo60515fd(str2).mo60514fc(str).mo60513aS(System.currentTimeMillis()).mo60516fe(stringBuilder.toString()).ajK();
        AppMethodBeat.m2505o(91462);
    }

    /* renamed from: H */
    public static boolean m87352H(long j, int i) {
        return (((long) (1 << i)) & j) > 0;
    }
}
