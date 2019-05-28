package com.tencent.p177mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C45393cv;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.luckymoney.model.n */
public final class C43260n extends C45393cv {
    public static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.m2504i(42334);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[5];
        c4924a.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "subtype";
        c4924a.xDd.put("subtype", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" subtype INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "subtype";
        c4924a.columns[1] = "bubbleMd5";
        c4924a.xDd.put("bubbleMd5", "TEXT");
        stringBuilder.append(" bubbleMd5 TEXT");
        stringBuilder.append(", ");
        c4924a.columns[2] = "coverMd5";
        c4924a.xDd.put("coverMd5", "TEXT");
        stringBuilder.append(" coverMd5 TEXT");
        stringBuilder.append(", ");
        c4924a.columns[3] = "minilogoMd5";
        c4924a.xDd.put("minilogoMd5", "TEXT");
        stringBuilder.append(" minilogoMd5 TEXT");
        stringBuilder.append(", ");
        c4924a.columns[4] = "version";
        c4924a.xDd.put("version", "INTEGER");
        stringBuilder.append(" version INTEGER");
        c4924a.columns[5] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(42334);
    }
}
