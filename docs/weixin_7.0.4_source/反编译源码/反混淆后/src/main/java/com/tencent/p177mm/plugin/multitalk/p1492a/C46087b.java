package com.tencent.p177mm.plugin.multitalk.p1492a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C37844da;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.multitalk.a.b */
public final class C46087b extends C37844da {
    protected static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.m2504i(54110);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[7];
        c4924a.columns = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "memberUuid";
        c4924a.xDd.put("memberUuid", "LONG");
        stringBuilder.append(" memberUuid LONG");
        stringBuilder.append(", ");
        c4924a.columns[1] = "wxGroupId";
        c4924a.xDd.put("wxGroupId", "TEXT");
        stringBuilder.append(" wxGroupId TEXT");
        stringBuilder.append(", ");
        c4924a.columns[2] = "userName";
        c4924a.xDd.put("userName", "TEXT");
        stringBuilder.append(" userName TEXT");
        stringBuilder.append(", ");
        c4924a.columns[3] = "inviteUserName";
        c4924a.xDd.put("inviteUserName", "TEXT");
        stringBuilder.append(" inviteUserName TEXT");
        stringBuilder.append(", ");
        c4924a.columns[4] = "memberId";
        c4924a.xDd.put("memberId", "LONG");
        stringBuilder.append(" memberId LONG");
        stringBuilder.append(", ");
        c4924a.columns[5] = "status";
        c4924a.xDd.put("status", "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[6] = "createTime";
        c4924a.xDd.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        c4924a.columns[7] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(54110);
    }
}
