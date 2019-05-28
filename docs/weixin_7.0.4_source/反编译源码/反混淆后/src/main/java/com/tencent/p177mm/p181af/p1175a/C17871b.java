package com.tencent.p177mm.p181af.p1175a;

import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C42119fx;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.af.a.b */
public final class C17871b extends C42119fx {
    public static C4924a fjX;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return fjX;
    }

    static {
        AppMethodBeat.m2504i(51123);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[6];
        c4924a.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "shareKeyHash";
        c4924a.xDd.put("shareKeyHash", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" shareKeyHash INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "shareKeyHash";
        c4924a.columns[1] = "btnState";
        c4924a.xDd.put("btnState", "INTEGER");
        stringBuilder.append(" btnState INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[2] = "msgState";
        c4924a.xDd.put("msgState", "INTEGER");
        stringBuilder.append(" msgState INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[3] = C8741b.CONTENT;
        c4924a.xDd.put(C8741b.CONTENT, "TEXT");
        stringBuilder.append(" content TEXT");
        stringBuilder.append(", ");
        c4924a.columns[4] = "contentColor";
        c4924a.xDd.put("contentColor", "TEXT");
        stringBuilder.append(" contentColor TEXT");
        stringBuilder.append(", ");
        c4924a.columns[5] = "updatePeroid";
        c4924a.xDd.put("updatePeroid", "INTEGER");
        stringBuilder.append(" updatePeroid INTEGER");
        c4924a.columns[6] = "rowid";
        c4924a.sql = stringBuilder.toString();
        fjX = c4924a;
        AppMethodBeat.m2505o(51123);
    }
}
