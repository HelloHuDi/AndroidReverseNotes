package com.tencent.mm.plugin.webview.modelcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fl;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.reflect.Field;

final class h extends fl {
    protected static a ccO;

    h() {
    }

    public final a Ag() {
        return ccO;
    }

    public final String toString() {
        AppMethodBeat.i(6839);
        StringBuilder stringBuilder = new StringBuilder(getClass().getSimpleName() + " {");
        try {
            for (Field field : getClass().getSuperclass().getDeclaredFields()) {
                if (field.getName().startsWith("field_")) {
                    field.setAccessible(true);
                    stringBuilder.append(field.getName().replaceFirst("field_", "")).append(" = ").append(field.get(this)).append(", ");
                }
            }
        } catch (IllegalAccessException e) {
            ab.printErrStackTrace("MicroMsg.WebViewCacheResConfigMap", e, "", new Object[0]);
        }
        String stringBuilder2 = stringBuilder.append(" }").toString();
        AppMethodBeat.o(6839);
        return stringBuilder2;
    }

    static {
        AppMethodBeat.i(6840);
        a aVar = new a();
        aVar.xDb = new Field[6];
        aVar.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "disable";
        aVar.xDd.put("disable", "INTEGER default 'false' ");
        stringBuilder.append(" disable INTEGER default 'false' ");
        stringBuilder.append(", ");
        aVar.columns[1] = "configId";
        aVar.xDd.put("configId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" configId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "configId";
        aVar.columns[2] = "configUrl";
        aVar.xDd.put("configUrl", "TEXT");
        stringBuilder.append(" configUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "configResources";
        aVar.xDd.put("configResources", "TEXT");
        stringBuilder.append(" configResources TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "configCrc32";
        aVar.xDd.put("configCrc32", "LONG");
        stringBuilder.append(" configCrc32 LONG");
        stringBuilder.append(", ");
        aVar.columns[5] = "isFromXml";
        aVar.xDd.put("isFromXml", "INTEGER default 'false' ");
        stringBuilder.append(" isFromXml INTEGER default 'false' ");
        aVar.columns[6] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(6840);
    }
}
