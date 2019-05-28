package com.tencent.p177mm.plugin.webview.modelcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C45400fp;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.webview.modelcache.g */
public final class C46935g extends C45400fp {
    protected static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    public final String toString() {
        AppMethodBeat.m2504i(6837);
        StringBuilder stringBuilder = new StringBuilder(getClass().getSimpleName() + " {");
        try {
            for (Field field : getClass().getSuperclass().getDeclaredFields()) {
                if (field.getName().startsWith("field_")) {
                    field.setAccessible(true);
                    stringBuilder.append(field.getName().replaceFirst("field_", "")).append(" = ").append(field.get(this)).append(", ");
                }
            }
        } catch (IllegalAccessException e) {
            C4990ab.printErrStackTrace("MicroMsg.WebViewCacheRes", e, "", new Object[0]);
        }
        String stringBuilder2 = stringBuilder.append(" }").toString();
        AppMethodBeat.m2505o(6837);
        return stringBuilder2;
    }

    static {
        AppMethodBeat.m2504i(6838);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[17];
        c4924a.columns = new String[18];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "urlMd5Hashcode";
        c4924a.xDd.put("urlMd5Hashcode", "INTEGER");
        stringBuilder.append(" urlMd5Hashcode INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[1] = "url";
        c4924a.xDd.put("url", "TEXT");
        stringBuilder.append(" url TEXT");
        stringBuilder.append(", ");
        c4924a.columns[2] = "appId";
        c4924a.xDd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        c4924a.columns[3] = "domain";
        c4924a.xDd.put("domain", "TEXT");
        stringBuilder.append(" domain TEXT");
        stringBuilder.append(", ");
        c4924a.columns[4] = "version";
        c4924a.xDd.put("version", "TEXT");
        stringBuilder.append(" version TEXT");
        stringBuilder.append(", ");
        c4924a.columns[5] = "localPath";
        c4924a.xDd.put("localPath", "TEXT");
        stringBuilder.append(" localPath TEXT");
        stringBuilder.append(", ");
        c4924a.columns[6] = DownloadInfo.CONTENTTYPE;
        c4924a.xDd.put(DownloadInfo.CONTENTTYPE, "TEXT");
        stringBuilder.append(" contentType TEXT");
        stringBuilder.append(", ");
        c4924a.columns[7] = "contentLength";
        c4924a.xDd.put("contentLength", "LONG");
        stringBuilder.append(" contentLength LONG");
        stringBuilder.append(", ");
        c4924a.columns[8] = "isLatestVersion";
        c4924a.xDd.put("isLatestVersion", "INTEGER");
        stringBuilder.append(" isLatestVersion INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[9] = "createTime";
        c4924a.xDd.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        stringBuilder.append(", ");
        c4924a.columns[10] = "accessTime";
        c4924a.xDd.put("accessTime", "LONG");
        stringBuilder.append(" accessTime LONG");
        stringBuilder.append(", ");
        c4924a.columns[11] = "expireTime";
        c4924a.xDd.put("expireTime", "LONG default '0' ");
        stringBuilder.append(" expireTime LONG default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[12] = "cacheType";
        c4924a.xDd.put("cacheType", "INTEGER");
        stringBuilder.append(" cacheType INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[13] = "configId";
        c4924a.xDd.put("configId", "TEXT");
        stringBuilder.append(" configId TEXT");
        stringBuilder.append(", ");
        c4924a.columns[14] = "protocol";
        c4924a.xDd.put("protocol", "INTEGER");
        stringBuilder.append(" protocol INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[15] = "packageId";
        c4924a.xDd.put("packageId", "TEXT");
        stringBuilder.append(" packageId TEXT");
        stringBuilder.append(", ");
        c4924a.columns[16] = "contentMd5";
        c4924a.xDd.put("contentMd5", "TEXT");
        stringBuilder.append(" contentMd5 TEXT");
        c4924a.columns[17] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(6838);
    }
}
