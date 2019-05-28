package com.tencent.p177mm.plugin.exdevice.p390f.p954b.p955a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C45391ch;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.exdevice.f.b.a.c */
public final class C34028c extends C45391ch {
    public static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    public final String toString() {
        AppMethodBeat.m2504i(19485);
        String str = ("{" + "username: " + this.field_username + " step: " + this.field_step + " rankId: " + this.field_rankID + " appname: " + this.field_appusername) + "}";
        AppMethodBeat.m2505o(19485);
        return str;
    }

    static {
        AppMethodBeat.m2504i(19486);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[5];
        c4924a.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "appusername";
        c4924a.xDd.put("appusername", "TEXT");
        stringBuilder.append(" appusername TEXT");
        stringBuilder.append(", ");
        c4924a.columns[1] = "rankID";
        c4924a.xDd.put("rankID", "TEXT");
        stringBuilder.append(" rankID TEXT");
        stringBuilder.append(", ");
        c4924a.columns[2] = "username";
        c4924a.xDd.put("username", "TEXT");
        stringBuilder.append(" username TEXT");
        stringBuilder.append(", ");
        c4924a.columns[3] = "step";
        c4924a.xDd.put("step", "INTEGER");
        stringBuilder.append(" step INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[4] = "sort";
        c4924a.xDd.put("sort", "INTEGER default '0' ");
        stringBuilder.append(" sort INTEGER default '0' ");
        c4924a.columns[5] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(19486);
    }
}
