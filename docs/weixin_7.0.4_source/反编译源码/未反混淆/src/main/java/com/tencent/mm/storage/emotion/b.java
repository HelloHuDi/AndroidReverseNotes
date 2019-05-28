package com.tencent.mm.storage.emotion;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class b extends bb {
    protected static a ccO;

    public final a Ag() {
        return null;
    }

    public final String Aq() {
        return this.field_md5 == null ? "" : this.field_md5;
    }

    static {
        AppMethodBeat.i(62793);
        a aVar = new a();
        aVar.xDb = new Field[7];
        aVar.columns = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "md5_lang";
        aVar.xDd.put("md5_lang", "TEXT PRIMARY KEY  COLLATE NOCASE ");
        stringBuilder.append(" md5_lang TEXT PRIMARY KEY  COLLATE NOCASE ");
        stringBuilder.append(", ");
        aVar.xDc = "md5_lang";
        aVar.columns[1] = "md5";
        aVar.xDd.put("md5", "TEXT COLLATE NOCASE ");
        stringBuilder.append(" md5 TEXT COLLATE NOCASE ");
        stringBuilder.append(", ");
        aVar.columns[2] = "lang";
        aVar.xDd.put("lang", "TEXT COLLATE NOCASE ");
        stringBuilder.append(" lang TEXT COLLATE NOCASE ");
        stringBuilder.append(", ");
        aVar.columns[3] = "desc";
        aVar.xDd.put("desc", "TEXT");
        stringBuilder.append(" desc TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "groupId";
        aVar.xDd.put("groupId", "TEXT default '' ");
        stringBuilder.append(" groupId TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[5] = "click_flag";
        aVar.xDd.put("click_flag", "INTEGER");
        stringBuilder.append(" click_flag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "download_flag";
        aVar.xDd.put("download_flag", "INTEGER");
        stringBuilder.append(" download_flag INTEGER");
        aVar.columns[7] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(62793);
    }
}
