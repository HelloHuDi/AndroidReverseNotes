package com.tencent.p177mm.plugin.scanner.history.p503a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C32692ea;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.scanner.history.a.a */
public final class C3755a extends C32692ea {
    public static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.m2504i(80799);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[6];
        c4924a.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "productId";
        c4924a.xDd.put("productId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" productId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "productId";
        c4924a.columns[1] = "xmlContent";
        c4924a.xDd.put("xmlContent", "TEXT");
        stringBuilder.append(" xmlContent TEXT");
        stringBuilder.append(", ");
        c4924a.columns[2] = "ScanTime";
        c4924a.xDd.put("ScanTime", "LONG");
        stringBuilder.append(" ScanTime LONG");
        stringBuilder.append(", ");
        c4924a.columns[3] = "funcType";
        c4924a.xDd.put("funcType", "INTEGER");
        stringBuilder.append(" funcType INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[4] = "qrcodeUrl";
        c4924a.xDd.put("qrcodeUrl", "TEXT");
        stringBuilder.append(" qrcodeUrl TEXT");
        stringBuilder.append(", ");
        c4924a.columns[5] = "scene";
        c4924a.xDd.put("scene", "INTEGER");
        stringBuilder.append(" scene INTEGER");
        c4924a.columns[6] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(80799);
    }
}
