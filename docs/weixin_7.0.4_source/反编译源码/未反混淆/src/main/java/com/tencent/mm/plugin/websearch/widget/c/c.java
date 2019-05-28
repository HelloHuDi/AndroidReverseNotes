package com.tencent.mm.plugin.websearch.widget.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.g.b.a.ae;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Arrays;

public final class c {
    public static void c(String str, String str2, String... strArr) {
        AppMethodBeat.i(91462);
        ab.e("WidgetPermissionUtil", "permissionFailed appid %s, api %s, args %s", str, str2, Arrays.toString(strArr));
        h.pYm.k(930, 0, 1);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <= 0; i++) {
            stringBuilder.append(q.encode(strArr[0])).append("&");
        }
        new ae().fd(str2).fc(str).aS(System.currentTimeMillis()).fe(stringBuilder.toString()).ajK();
        AppMethodBeat.o(91462);
    }

    public static boolean H(long j, int i) {
        return (((long) (1 << i)) & j) > 0;
    }
}
