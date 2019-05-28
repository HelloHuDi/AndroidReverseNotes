package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dq;
import com.tencent.mm.plugin.appbrand.q.b;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Locale;

public final class ae extends dq implements b {
    static final a fjX;
    static final String[] gSr = new String[]{"appId", "type", "version"};

    public final String[] getKeys() {
        return gSr;
    }

    public final a Ag() {
        return fjX;
    }

    static {
        int i = 0;
        AppMethodBeat.i(59446);
        a aVar = new a();
        aVar.xDb = new Field[5];
        aVar.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appId";
        aVar.xDd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "version";
        aVar.xDd.put("version", "INTEGER");
        stringBuilder.append(" version INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "type";
        aVar.xDd.put("type", "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "pkgMd5";
        aVar.xDd.put("pkgMd5", "TEXT");
        stringBuilder.append(" pkgMd5 TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "pkgPath";
        aVar.xDd.put("pkgPath", "TEXT");
        stringBuilder.append(" pkgPath TEXT");
        aVar.columns[5] = "rowid";
        aVar.sql = stringBuilder.toString();
        fjX = aVar;
        String str = " PRIMARY KEY ( ";
        String[] strArr = gSr;
        int length = strArr.length;
        while (i < length) {
            str = str + ", " + strArr[i];
            i++;
        }
        String str2 = str.replaceFirst(",", "") + " )";
        StringBuilder stringBuilder2 = new StringBuilder();
        a aVar2 = fjX;
        aVar2.sql = stringBuilder2.append(aVar2.sql).append(",").append(str2).toString();
        AppMethodBeat.o(59446);
    }

    public final String toShortString() {
        AppMethodBeat.i(59445);
        String format = String.format(Locale.US, "EncryptPkgInfo[%s %d %d]", new Object[]{this.field_appId, Integer.valueOf(this.field_type), Integer.valueOf(this.field_version)});
        AppMethodBeat.o(59445);
        return format;
    }
}
