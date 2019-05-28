package com.tencent.p177mm.plugin.report.p498a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C6564ax;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.report.a.a */
public final class C7511a extends C6564ax {
    protected static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.m2504i(72663);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[2];
        c4924a.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "bakLogId";
        c4924a.xDd.put("bakLogId", "INTEGER");
        stringBuilder.append(" bakLogId INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[1] = "valueStr";
        c4924a.xDd.put("valueStr", "TEXT");
        stringBuilder.append(" valueStr TEXT");
        c4924a.columns[2] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(72663);
    }
}
