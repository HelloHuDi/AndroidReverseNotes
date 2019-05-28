package com.tencent.p177mm.p184aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C45384af;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.aj.g */
public final class C46874g extends C45384af {
    protected static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    public C46874g(String str, String str2, String str3, String str4, int i, long j) {
        this.field_openId = str;
        this.field_brandUsername = str2;
        this.field_headImgUrl = str3;
        this.field_nickname = str4;
        this.field_kfType = i;
        this.field_updateTime = j;
    }

    static {
        AppMethodBeat.m2504i(11384);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[6];
        c4924a.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "openId";
        c4924a.xDd.put("openId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" openId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "openId";
        c4924a.columns[1] = "brandUsername";
        c4924a.xDd.put("brandUsername", "TEXT default '' ");
        stringBuilder.append(" brandUsername TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[2] = "headImgUrl";
        c4924a.xDd.put("headImgUrl", "TEXT");
        stringBuilder.append(" headImgUrl TEXT");
        stringBuilder.append(", ");
        c4924a.columns[3] = "nickname";
        c4924a.xDd.put("nickname", "TEXT");
        stringBuilder.append(" nickname TEXT");
        stringBuilder.append(", ");
        c4924a.columns[4] = "kfType";
        c4924a.xDd.put("kfType", "INTEGER");
        stringBuilder.append(" kfType INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[5] = "updateTime";
        c4924a.xDd.put("updateTime", "LONG");
        stringBuilder.append(" updateTime LONG");
        c4924a.columns[6] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(11384);
    }
}
