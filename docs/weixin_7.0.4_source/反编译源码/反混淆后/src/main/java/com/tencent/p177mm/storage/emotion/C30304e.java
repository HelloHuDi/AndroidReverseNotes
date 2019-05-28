package com.tencent.p177mm.storage.emotion;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C45386bc;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.storage.emotion.e */
public final class C30304e extends C45386bc {
    protected static C4924a ccO;

    public C30304e(String str, String str2) {
        this.field_groupID = str;
        this.field_desc = str2;
    }

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return null;
    }

    static {
        AppMethodBeat.m2504i(62846);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[2];
        c4924a.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "groupID";
        c4924a.xDd.put("groupID", "TEXT");
        stringBuilder.append(" groupID TEXT");
        stringBuilder.append(", ");
        c4924a.columns[1] = "desc";
        c4924a.xDd.put("desc", "TEXT");
        stringBuilder.append(" desc TEXT");
        c4924a.columns[2] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(62846);
    }
}
