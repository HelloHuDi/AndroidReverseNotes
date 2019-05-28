package com.tencent.p177mm.plugin.webview.p768b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C9532fn;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.webview.b.d */
public final class C16924d extends C9532fn {
    protected static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.m2504i(5645);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[6];
        c4924a.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "recordId";
        c4924a.xDd.put("recordId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" recordId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "recordId";
        c4924a.columns[1] = "link";
        c4924a.xDd.put("link", "TEXT");
        stringBuilder.append(" link TEXT");
        stringBuilder.append(", ");
        c4924a.columns[2] = "title";
        c4924a.xDd.put("title", "TEXT");
        stringBuilder.append(" title TEXT");
        stringBuilder.append(", ");
        c4924a.columns[3] = "source";
        c4924a.xDd.put("source", "TEXT");
        stringBuilder.append(" source TEXT");
        stringBuilder.append(", ");
        c4924a.columns[4] = "imgUrl";
        c4924a.xDd.put("imgUrl", "TEXT");
        stringBuilder.append(" imgUrl TEXT");
        stringBuilder.append(", ");
        c4924a.columns[5] = "timeStamp";
        c4924a.xDd.put("timeStamp", "LONG");
        stringBuilder.append(" timeStamp LONG");
        c4924a.columns[6] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(5645);
    }
}
