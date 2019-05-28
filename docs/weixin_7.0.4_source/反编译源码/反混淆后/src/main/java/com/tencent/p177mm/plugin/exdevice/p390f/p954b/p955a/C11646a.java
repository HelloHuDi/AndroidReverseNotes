package com.tencent.p177mm.plugin.exdevice.p390f.p954b.p955a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C18466cd;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.exdevice.f.b.a.a */
public final class C11646a extends C18466cd {
    public static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.m2504i(19483);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[3];
        c4924a.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "username";
        c4924a.xDd.put("username", "TEXT");
        stringBuilder.append(" username TEXT");
        stringBuilder.append(", ");
        c4924a.columns[1] = "championUrl";
        c4924a.xDd.put("championUrl", "TEXT");
        stringBuilder.append(" championUrl TEXT");
        stringBuilder.append(", ");
        c4924a.columns[2] = "championMotto";
        c4924a.xDd.put("championMotto", "TEXT");
        stringBuilder.append(" championMotto TEXT");
        c4924a.columns[3] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(19483);
    }
}
