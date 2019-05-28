package com.tencent.mm.plugin.shake.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.shake.a.a.a;
import com.tencent.mm.sdk.e.c;
import java.lang.reflect.Field;

public final class f extends a {
    protected static c.a ccO;

    public final c.a Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.i(24453);
        c.a aVar = new c.a();
        aVar.xDb = new Field[13];
        aVar.columns = new String[14];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "svrid";
        aVar.xDd.put("svrid", "LONG default '0'  PRIMARY KEY ");
        stringBuilder.append(" svrid LONG default '0'  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "svrid";
        aVar.columns[1] = "type";
        aVar.xDd.put("type", "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "subtype";
        aVar.xDd.put("subtype", "INTEGER default '0' ");
        stringBuilder.append(" subtype INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "createtime";
        aVar.xDd.put("createtime", "LONG");
        stringBuilder.append(" createtime LONG");
        stringBuilder.append(", ");
        aVar.columns[4] = "tag";
        aVar.xDd.put("tag", "TEXT");
        stringBuilder.append(" tag TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "status";
        aVar.xDd.put("status", "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "title";
        aVar.xDd.put("title", "TEXT");
        stringBuilder.append(" title TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "desc";
        aVar.xDd.put("desc", "TEXT");
        stringBuilder.append(" desc TEXT");
        stringBuilder.append(", ");
        aVar.columns[8] = "thumburl";
        aVar.xDd.put("thumburl", "TEXT");
        stringBuilder.append(" thumburl TEXT");
        stringBuilder.append(", ");
        aVar.columns[9] = "reserved1";
        aVar.xDd.put("reserved1", "TEXT");
        stringBuilder.append(" reserved1 TEXT");
        stringBuilder.append(", ");
        aVar.columns[10] = "reserved2";
        aVar.xDd.put("reserved2", "TEXT");
        stringBuilder.append(" reserved2 TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = "reserved3";
        aVar.xDd.put("reserved3", "INTEGER");
        stringBuilder.append(" reserved3 INTEGER");
        stringBuilder.append(", ");
        aVar.columns[12] = "reservedBuf";
        aVar.xDd.put("reservedBuf", "BLOB");
        stringBuilder.append(" reservedBuf BLOB");
        aVar.columns[13] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(24453);
    }
}
