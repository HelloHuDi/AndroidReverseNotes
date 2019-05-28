package com.tencent.p177mm.plugin.scanner.p740a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C9529eb;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.scanner.a.p */
public final class C46181p extends C9529eb {
    public static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.m2504i(80885);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[4];
        c4924a.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "originMD5";
        c4924a.xDd.put("originMD5", "TEXT PRIMARY KEY ");
        stringBuilder.append(" originMD5 TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "originMD5";
        c4924a.columns[1] = "resultFile";
        c4924a.xDd.put("resultFile", "TEXT");
        stringBuilder.append(" resultFile TEXT");
        stringBuilder.append(", ");
        c4924a.columns[2] = "fromLang";
        c4924a.xDd.put("fromLang", "TEXT");
        stringBuilder.append(" fromLang TEXT");
        stringBuilder.append(", ");
        c4924a.columns[3] = "toLang";
        c4924a.xDd.put("toLang", "TEXT");
        stringBuilder.append(" toLang TEXT");
        c4924a.columns[4] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(80885);
    }
}
