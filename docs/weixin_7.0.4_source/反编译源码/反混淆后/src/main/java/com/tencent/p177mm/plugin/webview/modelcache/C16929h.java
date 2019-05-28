package com.tencent.p177mm.plugin.webview.modelcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C9531fl;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.webview.modelcache.h */
final class C16929h extends C9531fl {
    protected static C4924a ccO;

    C16929h() {
    }

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    public final String toString() {
        AppMethodBeat.m2504i(6839);
        StringBuilder stringBuilder = new StringBuilder(getClass().getSimpleName() + " {");
        try {
            for (Field field : getClass().getSuperclass().getDeclaredFields()) {
                if (field.getName().startsWith("field_")) {
                    field.setAccessible(true);
                    stringBuilder.append(field.getName().replaceFirst("field_", "")).append(" = ").append(field.get(this)).append(", ");
                }
            }
        } catch (IllegalAccessException e) {
            C4990ab.printErrStackTrace("MicroMsg.WebViewCacheResConfigMap", e, "", new Object[0]);
        }
        String stringBuilder2 = stringBuilder.append(" }").toString();
        AppMethodBeat.m2505o(6839);
        return stringBuilder2;
    }

    static {
        AppMethodBeat.m2504i(6840);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[6];
        c4924a.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "disable";
        c4924a.xDd.put("disable", "INTEGER default 'false' ");
        stringBuilder.append(" disable INTEGER default 'false' ");
        stringBuilder.append(", ");
        c4924a.columns[1] = "configId";
        c4924a.xDd.put("configId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" configId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "configId";
        c4924a.columns[2] = "configUrl";
        c4924a.xDd.put("configUrl", "TEXT");
        stringBuilder.append(" configUrl TEXT");
        stringBuilder.append(", ");
        c4924a.columns[3] = "configResources";
        c4924a.xDd.put("configResources", "TEXT");
        stringBuilder.append(" configResources TEXT");
        stringBuilder.append(", ");
        c4924a.columns[4] = "configCrc32";
        c4924a.xDd.put("configCrc32", "LONG");
        stringBuilder.append(" configCrc32 LONG");
        stringBuilder.append(", ");
        c4924a.columns[5] = "isFromXml";
        c4924a.xDd.put("isFromXml", "INTEGER default 'false' ");
        stringBuilder.append(" isFromXml INTEGER default 'false' ");
        c4924a.columns[6] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(6840);
    }
}
