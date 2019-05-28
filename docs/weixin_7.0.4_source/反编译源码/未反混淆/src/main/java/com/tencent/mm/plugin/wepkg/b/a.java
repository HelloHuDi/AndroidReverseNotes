package com.tencent.mm.plugin.wepkg.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fj;
import java.lang.reflect.Field;

public final class a extends fj {
    public static final com.tencent.mm.sdk.e.c.a fjX;

    public final com.tencent.mm.sdk.e.c.a Ag() {
        return fjX;
    }

    static {
        AppMethodBeat.i(63386);
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.xDb = new Field[8];
        aVar.columns = new String[9];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "pkgId";
        aVar.xDd.put("pkgId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" pkgId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "pkgId";
        aVar.columns[1] = "version";
        aVar.xDd.put("version", "TEXT");
        stringBuilder.append(" version TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "oldVersion";
        aVar.xDd.put("oldVersion", "TEXT");
        stringBuilder.append(" oldVersion TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "oldPath";
        aVar.xDd.put("oldPath", "TEXT");
        stringBuilder.append(" oldPath TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "md5";
        aVar.xDd.put("md5", "TEXT");
        stringBuilder.append(" md5 TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "downloadUrl";
        aVar.xDd.put("downloadUrl", "TEXT");
        stringBuilder.append(" downloadUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = "pkgSize";
        aVar.xDd.put("pkgSize", "INTEGER");
        stringBuilder.append(" pkgSize INTEGER");
        stringBuilder.append(", ");
        aVar.columns[7] = "downloadNetType";
        aVar.xDd.put("downloadNetType", "INTEGER");
        stringBuilder.append(" downloadNetType INTEGER");
        aVar.columns[8] = "rowid";
        aVar.sql = stringBuilder.toString();
        fjX = aVar;
        AppMethodBeat.o(63386);
    }
}
