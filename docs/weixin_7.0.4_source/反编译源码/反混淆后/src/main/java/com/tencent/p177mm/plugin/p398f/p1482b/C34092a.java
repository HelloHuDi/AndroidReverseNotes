package com.tencent.p177mm.plugin.p398f.p1482b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C9534fu;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.f.b.a */
public final class C34092a extends C9534fu {
    protected static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        AppMethodBeat.m2504i(18627);
        super.mo8995d(cursor);
        AppMethodBeat.m2505o(18627);
    }

    public final String toString() {
        AppMethodBeat.m2504i(18628);
        String str = "{  sys row id: " + this.xDa + " msg id : " + this.field_msgId + " msg talker: " + this.field_username + " msg type : " + this.field_msgType + " msg sub type : " + this.field_msgSubType + " path : " + this.field_path + " size : " + this.field_size + " msgtime : " + this.field_msgtime + " } ";
        AppMethodBeat.m2505o(18628);
        return str;
    }

    static {
        AppMethodBeat.m2504i(18629);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[7];
        c4924a.columns = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "msgId";
        c4924a.xDd.put("msgId", "LONG");
        stringBuilder.append(" msgId LONG");
        stringBuilder.append(", ");
        c4924a.columns[1] = "username";
        c4924a.xDd.put("username", "TEXT");
        stringBuilder.append(" username TEXT");
        stringBuilder.append(", ");
        c4924a.columns[2] = "msgType";
        c4924a.xDd.put("msgType", "INTEGER");
        stringBuilder.append(" msgType INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[3] = "msgSubType";
        c4924a.xDd.put("msgSubType", "INTEGER");
        stringBuilder.append(" msgSubType INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[4] = "path";
        c4924a.xDd.put("path", "TEXT");
        stringBuilder.append(" path TEXT");
        stringBuilder.append(", ");
        c4924a.columns[5] = "size";
        c4924a.xDd.put("size", "LONG");
        stringBuilder.append(" size LONG");
        stringBuilder.append(", ");
        c4924a.columns[6] = "msgtime";
        c4924a.xDd.put("msgtime", "LONG");
        stringBuilder.append(" msgtime LONG");
        c4924a.columns[7] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(18629);
    }
}
