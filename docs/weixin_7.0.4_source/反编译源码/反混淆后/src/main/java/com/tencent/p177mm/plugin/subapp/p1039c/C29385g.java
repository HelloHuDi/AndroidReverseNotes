package com.tencent.p177mm.plugin.subapp.p1039c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C32694ez;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.subapp.c.g */
public final class C29385g extends C32694ez {
    protected static C4924a ccO;
    int bJt = -1;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    public final boolean ame() {
        if ((this.field_status <= 1 || this.field_status > 3) && this.field_status != 8) {
            return false;
        }
        return true;
    }

    static {
        AppMethodBeat.m2504i(25284);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[17];
        c4924a.columns = new String[18];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "filename";
        c4924a.xDd.put("filename", "TEXT");
        stringBuilder.append(" filename TEXT");
        stringBuilder.append(", ");
        c4924a.columns[1] = "user";
        c4924a.xDd.put("user", "TEXT");
        stringBuilder.append(" user TEXT");
        stringBuilder.append(", ");
        c4924a.columns[2] = "msgid";
        c4924a.xDd.put("msgid", "LONG");
        stringBuilder.append(" msgid LONG");
        stringBuilder.append(", ");
        c4924a.columns[3] = "offset";
        c4924a.xDd.put("offset", "INTEGER");
        stringBuilder.append(" offset INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[4] = "filenowsize";
        c4924a.xDd.put("filenowsize", "INTEGER");
        stringBuilder.append(" filenowsize INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[5] = "totallen";
        c4924a.xDd.put("totallen", "INTEGER");
        stringBuilder.append(" totallen INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[6] = "status";
        c4924a.xDd.put("status", "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[7] = "createtime";
        c4924a.xDd.put("createtime", "LONG");
        stringBuilder.append(" createtime LONG");
        stringBuilder.append(", ");
        c4924a.columns[8] = "lastmodifytime";
        c4924a.xDd.put("lastmodifytime", "LONG");
        stringBuilder.append(" lastmodifytime LONG");
        stringBuilder.append(", ");
        c4924a.columns[9] = "clientid";
        c4924a.xDd.put("clientid", "TEXT");
        stringBuilder.append(" clientid TEXT");
        stringBuilder.append(", ");
        c4924a.columns[10] = "voicelenght";
        c4924a.xDd.put("voicelenght", "INTEGER");
        stringBuilder.append(" voicelenght INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[11] = "msglocalid";
        c4924a.xDd.put("msglocalid", "INTEGER");
        stringBuilder.append(" msglocalid INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[12] = "human";
        c4924a.xDd.put("human", "TEXT");
        stringBuilder.append(" human TEXT");
        stringBuilder.append(", ");
        c4924a.columns[13] = "voiceformat";
        c4924a.xDd.put("voiceformat", "INTEGER");
        stringBuilder.append(" voiceformat INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[14] = "nettimes";
        c4924a.xDd.put("nettimes", "INTEGER");
        stringBuilder.append(" nettimes INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[15] = "reserved1";
        c4924a.xDd.put("reserved1", "INTEGER");
        stringBuilder.append(" reserved1 INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[16] = "reserved2";
        c4924a.xDd.put("reserved2", "TEXT");
        stringBuilder.append(" reserved2 TEXT");
        c4924a.columns[17] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(25284);
    }
}
