package com.tencent.mm.plugin.webview.modelcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fp;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.lang.reflect.Field;

public final class g extends fp {
    protected static a ccO;

    public final a Ag() {
        return ccO;
    }

    public final String toString() {
        AppMethodBeat.i(6837);
        StringBuilder stringBuilder = new StringBuilder(getClass().getSimpleName() + " {");
        try {
            for (Field field : getClass().getSuperclass().getDeclaredFields()) {
                if (field.getName().startsWith("field_")) {
                    field.setAccessible(true);
                    stringBuilder.append(field.getName().replaceFirst("field_", "")).append(" = ").append(field.get(this)).append(", ");
                }
            }
        } catch (IllegalAccessException e) {
            ab.printErrStackTrace("MicroMsg.WebViewCacheRes", e, "", new Object[0]);
        }
        String stringBuilder2 = stringBuilder.append(" }").toString();
        AppMethodBeat.o(6837);
        return stringBuilder2;
    }

    static {
        AppMethodBeat.i(6838);
        a aVar = new a();
        aVar.xDb = new Field[17];
        aVar.columns = new String[18];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "urlMd5Hashcode";
        aVar.xDd.put("urlMd5Hashcode", "INTEGER");
        stringBuilder.append(" urlMd5Hashcode INTEGER");
        stringBuilder.append(", ");
        aVar.columns[1] = "url";
        aVar.xDd.put("url", "TEXT");
        stringBuilder.append(" url TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "appId";
        aVar.xDd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "domain";
        aVar.xDd.put("domain", "TEXT");
        stringBuilder.append(" domain TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "version";
        aVar.xDd.put("version", "TEXT");
        stringBuilder.append(" version TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "localPath";
        aVar.xDd.put("localPath", "TEXT");
        stringBuilder.append(" localPath TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = DownloadInfo.CONTENTTYPE;
        aVar.xDd.put(DownloadInfo.CONTENTTYPE, "TEXT");
        stringBuilder.append(" contentType TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "contentLength";
        aVar.xDd.put("contentLength", "LONG");
        stringBuilder.append(" contentLength LONG");
        stringBuilder.append(", ");
        aVar.columns[8] = "isLatestVersion";
        aVar.xDd.put("isLatestVersion", "INTEGER");
        stringBuilder.append(" isLatestVersion INTEGER");
        stringBuilder.append(", ");
        aVar.columns[9] = "createTime";
        aVar.xDd.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        stringBuilder.append(", ");
        aVar.columns[10] = "accessTime";
        aVar.xDd.put("accessTime", "LONG");
        stringBuilder.append(" accessTime LONG");
        stringBuilder.append(", ");
        aVar.columns[11] = "expireTime";
        aVar.xDd.put("expireTime", "LONG default '0' ");
        stringBuilder.append(" expireTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[12] = "cacheType";
        aVar.xDd.put("cacheType", "INTEGER");
        stringBuilder.append(" cacheType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[13] = "configId";
        aVar.xDd.put("configId", "TEXT");
        stringBuilder.append(" configId TEXT");
        stringBuilder.append(", ");
        aVar.columns[14] = "protocol";
        aVar.xDd.put("protocol", "INTEGER");
        stringBuilder.append(" protocol INTEGER");
        stringBuilder.append(", ");
        aVar.columns[15] = "packageId";
        aVar.xDd.put("packageId", "TEXT");
        stringBuilder.append(" packageId TEXT");
        stringBuilder.append(", ");
        aVar.columns[16] = "contentMd5";
        aVar.xDd.put("contentMd5", "TEXT");
        stringBuilder.append(" contentMd5 TEXT");
        aVar.columns[17] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(6838);
    }
}
