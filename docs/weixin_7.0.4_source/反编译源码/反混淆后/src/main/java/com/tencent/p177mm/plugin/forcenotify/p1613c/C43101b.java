package com.tencent.p177mm.plugin.forcenotify.p1613c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1839cb;
import com.tencent.p177mm.p230g.p711c.C45388bs;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import com.tencent.p177mm.storage.C7616ad;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.forcenotify.c.b */
public final class C43101b extends C45388bs {
    public static C4924a ccO;
    public C7616ad ehM = null;

    public final boolean bxX() {
        AppMethodBeat.m2504i(51015);
        if (C1839cb.aaD() >= this.field_ExpiredTime) {
            AppMethodBeat.m2505o(51015);
            return true;
        }
        AppMethodBeat.m2505o(51015);
        return false;
    }

    public final boolean isEnable() {
        return this.field_Status == 1;
    }

    public final String toString() {
        AppMethodBeat.m2504i(51016);
        String str = this.field_ForcePushId + " " + this.field_UserName + " " + this.field_CreateTime + " " + this.field_ExpiredTime + " " + this.field_Status;
        AppMethodBeat.m2505o(51016);
        return str;
    }

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.m2504i(51017);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[8];
        c4924a.columns = new String[9];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "ForcePushId";
        c4924a.xDd.put("ForcePushId", "TEXT");
        stringBuilder.append(" ForcePushId TEXT");
        stringBuilder.append(", ");
        c4924a.columns[1] = "CreateTime";
        c4924a.xDd.put("CreateTime", "LONG");
        stringBuilder.append(" CreateTime LONG");
        stringBuilder.append(", ");
        c4924a.columns[2] = "ExpiredTime";
        c4924a.xDd.put("ExpiredTime", "LONG");
        stringBuilder.append(" ExpiredTime LONG");
        stringBuilder.append(", ");
        c4924a.columns[3] = "Description";
        c4924a.xDd.put("Description", "TEXT");
        stringBuilder.append(" Description TEXT");
        stringBuilder.append(", ");
        c4924a.columns[4] = "UserIcon";
        c4924a.xDd.put("UserIcon", "TEXT");
        stringBuilder.append(" UserIcon TEXT");
        stringBuilder.append(", ");
        c4924a.columns[5] = "UserName";
        c4924a.xDd.put("UserName", "TEXT PRIMARY KEY ");
        stringBuilder.append(" UserName TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "UserName";
        c4924a.columns[6] = "Extinfo";
        c4924a.xDd.put("Extinfo", "TEXT");
        stringBuilder.append(" Extinfo TEXT");
        stringBuilder.append(", ");
        c4924a.columns[7] = "Status";
        c4924a.xDd.put("Status", "INTEGER default '0' ");
        stringBuilder.append(" Status INTEGER default '0' ");
        c4924a.columns[8] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(51017);
    }
}
