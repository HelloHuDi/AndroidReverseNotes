package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.en;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.List;

public final class t extends en {
    protected static a ccO;
    public int rfJ;

    public final a Ag() {
        return ccO;
    }

    /* renamed from: do */
    public final void m8do(List<bts> list) {
        AppMethodBeat.i(38002);
        this.field_memberList = "";
        for (bts bts : list) {
            this.field_memberList += bts.wVI + ",";
        }
        AppMethodBeat.o(38002);
    }

    public final void d(Cursor cursor) {
        AppMethodBeat.i(38003);
        super.d(cursor);
        this.rfJ = (int) this.xDa;
        AppMethodBeat.o(38003);
    }

    static {
        AppMethodBeat.i(38004);
        a aVar = new a();
        aVar.xDb = new Field[4];
        aVar.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "tagId";
        aVar.xDd.put("tagId", "LONG default '0' ");
        stringBuilder.append(" tagId LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[1] = "tagName";
        aVar.xDd.put("tagName", "TEXT default '' ");
        stringBuilder.append(" tagName TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "count";
        aVar.xDd.put("count", "INTEGER default '0' ");
        stringBuilder.append(" count INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "memberList";
        aVar.xDd.put("memberList", "TEXT default '' ");
        stringBuilder.append(" memberList TEXT default '' ");
        aVar.columns[4] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(38004);
    }
}
