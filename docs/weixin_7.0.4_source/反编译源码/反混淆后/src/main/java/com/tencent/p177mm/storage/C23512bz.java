package com.tencent.p177mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C45398ex;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.storage.bz */
public final class C23512bz extends C45398ex {
    protected static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    public C23512bz(String str, String str2, String str3) {
        this.field_appId = str;
        this.field_username = str2;
        this.field_openId = str3;
    }

    static {
        AppMethodBeat.m2504i(29070);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[3];
        c4924a.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "openId";
        c4924a.xDd.put("openId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" openId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "openId";
        c4924a.columns[1] = "appId";
        c4924a.xDd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        c4924a.columns[2] = "username";
        c4924a.xDd.put("username", "TEXT");
        stringBuilder.append(" username TEXT");
        c4924a.columns[3] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(29070);
    }
}
