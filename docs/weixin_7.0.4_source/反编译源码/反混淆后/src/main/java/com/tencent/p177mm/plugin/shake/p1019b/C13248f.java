package com.tencent.p177mm.plugin.shake.p1019b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.shake.p1294a.p1295a.C43521a;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.shake.b.f */
public final class C13248f extends C43521a {
    protected static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.m2504i(24453);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[13];
        c4924a.columns = new String[14];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "svrid";
        c4924a.xDd.put("svrid", "LONG default '0'  PRIMARY KEY ");
        stringBuilder.append(" svrid LONG default '0'  PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "svrid";
        c4924a.columns[1] = "type";
        c4924a.xDd.put("type", "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[2] = "subtype";
        c4924a.xDd.put("subtype", "INTEGER default '0' ");
        stringBuilder.append(" subtype INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[3] = "createtime";
        c4924a.xDd.put("createtime", "LONG");
        stringBuilder.append(" createtime LONG");
        stringBuilder.append(", ");
        c4924a.columns[4] = "tag";
        c4924a.xDd.put("tag", "TEXT");
        stringBuilder.append(" tag TEXT");
        stringBuilder.append(", ");
        c4924a.columns[5] = "status";
        c4924a.xDd.put("status", "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[6] = "title";
        c4924a.xDd.put("title", "TEXT");
        stringBuilder.append(" title TEXT");
        stringBuilder.append(", ");
        c4924a.columns[7] = "desc";
        c4924a.xDd.put("desc", "TEXT");
        stringBuilder.append(" desc TEXT");
        stringBuilder.append(", ");
        c4924a.columns[8] = "thumburl";
        c4924a.xDd.put("thumburl", "TEXT");
        stringBuilder.append(" thumburl TEXT");
        stringBuilder.append(", ");
        c4924a.columns[9] = "reserved1";
        c4924a.xDd.put("reserved1", "TEXT");
        stringBuilder.append(" reserved1 TEXT");
        stringBuilder.append(", ");
        c4924a.columns[10] = "reserved2";
        c4924a.xDd.put("reserved2", "TEXT");
        stringBuilder.append(" reserved2 TEXT");
        stringBuilder.append(", ");
        c4924a.columns[11] = "reserved3";
        c4924a.xDd.put("reserved3", "INTEGER");
        stringBuilder.append(" reserved3 INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[12] = "reservedBuf";
        c4924a.xDd.put("reservedBuf", "BLOB");
        stringBuilder.append(" reservedBuf BLOB");
        c4924a.columns[13] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(24453);
    }
}
