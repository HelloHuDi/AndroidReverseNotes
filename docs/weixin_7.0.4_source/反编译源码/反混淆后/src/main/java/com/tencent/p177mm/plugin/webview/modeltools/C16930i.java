package com.tencent.p177mm.plugin.webview.modeltools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C9533fo;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.webview.modeltools.i */
public final class C16930i extends C9533fo {
    public static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.m2504i(7021);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[2];
        c4924a.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "host";
        c4924a.xDd.put("host", "TEXT");
        stringBuilder.append(" host TEXT");
        stringBuilder.append(", ");
        c4924a.columns[1] = "expireTime";
        c4924a.xDd.put("expireTime", "LONG");
        stringBuilder.append(" expireTime LONG");
        c4924a.columns[2] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(7021);
    }
}
