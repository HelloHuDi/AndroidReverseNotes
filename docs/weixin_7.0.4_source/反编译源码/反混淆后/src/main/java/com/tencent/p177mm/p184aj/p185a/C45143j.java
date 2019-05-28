package com.tencent.p177mm.p184aj.p185a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C6559ac;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.aj.a.j */
public final class C45143j extends C6559ac {
    protected static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    /* renamed from: lc */
    public final boolean mo73056lc(int i) {
        return (this.field_bitFlag & i) != 0;
    }

    public final boolean afh() {
        AppMethodBeat.m2504i(105496);
        if (this.field_needToUpdate) {
            AppMethodBeat.m2505o(105496);
            return true;
        } else if (C5046bo.isNullOrNil(this.field_profileUrl) && C5046bo.isNullOrNil(this.field_headImageUrl)) {
            AppMethodBeat.m2505o(105496);
            return true;
        } else if (!C5046bo.isNullOrNil(this.field_userNamePY) || C5046bo.isNullOrNil(this.field_userName)) {
            AppMethodBeat.m2505o(105496);
            return false;
        } else {
            AppMethodBeat.m2505o(105496);
            return true;
        }
    }

    static {
        AppMethodBeat.m2504i(105497);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[10];
        c4924a.columns = new String[11];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "userId";
        c4924a.xDd.put("userId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" userId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "userId";
        c4924a.columns[1] = "userName";
        c4924a.xDd.put("userName", "TEXT default '' ");
        stringBuilder.append(" userName TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[2] = "userNamePY";
        c4924a.xDd.put("userNamePY", "TEXT default '' ");
        stringBuilder.append(" userNamePY TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[3] = "brandUserName";
        c4924a.xDd.put("brandUserName", "TEXT default '' ");
        stringBuilder.append(" brandUserName TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[4] = "UserVersion";
        c4924a.xDd.put("UserVersion", "INTEGER default '-1' ");
        stringBuilder.append(" UserVersion INTEGER default '-1' ");
        stringBuilder.append(", ");
        c4924a.columns[5] = "needToUpdate";
        c4924a.xDd.put("needToUpdate", "INTEGER default 'true' ");
        stringBuilder.append(" needToUpdate INTEGER default 'true' ");
        stringBuilder.append(", ");
        c4924a.columns[6] = "headImageUrl";
        c4924a.xDd.put("headImageUrl", "TEXT");
        stringBuilder.append(" headImageUrl TEXT");
        stringBuilder.append(", ");
        c4924a.columns[7] = "profileUrl";
        c4924a.xDd.put("profileUrl", "TEXT");
        stringBuilder.append(" profileUrl TEXT");
        stringBuilder.append(", ");
        c4924a.columns[8] = "bitFlag";
        c4924a.xDd.put("bitFlag", "INTEGER default '0' ");
        stringBuilder.append(" bitFlag INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[9] = "addMemberUrl";
        c4924a.xDd.put("addMemberUrl", "TEXT");
        stringBuilder.append(" addMemberUrl TEXT");
        c4924a.columns[10] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(105497);
    }
}
