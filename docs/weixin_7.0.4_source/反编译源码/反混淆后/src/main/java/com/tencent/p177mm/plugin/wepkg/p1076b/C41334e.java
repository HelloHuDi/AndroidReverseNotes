package com.tencent.p177mm.plugin.wepkg.p1076b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C37853fs;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.wepkg.b.e */
public final class C41334e extends C37853fs {
    public static final C4924a fjX;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return fjX;
    }

    static {
        AppMethodBeat.m2504i(63399);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[25];
        c4924a.columns = new String[26];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "pkgId";
        c4924a.xDd.put("pkgId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" pkgId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "pkgId";
        c4924a.columns[1] = "appId";
        c4924a.xDd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        c4924a.columns[2] = "version";
        c4924a.xDd.put("version", "TEXT");
        stringBuilder.append(" version TEXT");
        stringBuilder.append(", ");
        c4924a.columns[3] = "pkgPath";
        c4924a.xDd.put("pkgPath", "TEXT");
        stringBuilder.append(" pkgPath TEXT");
        stringBuilder.append(", ");
        c4924a.columns[4] = "disableWvCache";
        c4924a.xDd.put("disableWvCache", "INTEGER default 'true' ");
        stringBuilder.append(" disableWvCache INTEGER default 'true' ");
        stringBuilder.append(", ");
        c4924a.columns[5] = "clearPkgTime";
        c4924a.xDd.put("clearPkgTime", "LONG");
        stringBuilder.append(" clearPkgTime LONG");
        stringBuilder.append(", ");
        c4924a.columns[6] = "checkIntervalTime";
        c4924a.xDd.put("checkIntervalTime", "LONG");
        stringBuilder.append(" checkIntervalTime LONG");
        stringBuilder.append(", ");
        c4924a.columns[7] = "packMethod";
        c4924a.xDd.put("packMethod", "INTEGER");
        stringBuilder.append(" packMethod INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[8] = "domain";
        c4924a.xDd.put("domain", "TEXT");
        stringBuilder.append(" domain TEXT");
        stringBuilder.append(", ");
        c4924a.columns[9] = "md5";
        c4924a.xDd.put("md5", "TEXT");
        stringBuilder.append(" md5 TEXT");
        stringBuilder.append(", ");
        c4924a.columns[10] = "downloadUrl";
        c4924a.xDd.put("downloadUrl", "TEXT");
        stringBuilder.append(" downloadUrl TEXT");
        stringBuilder.append(", ");
        c4924a.columns[11] = "pkgSize";
        c4924a.xDd.put("pkgSize", "INTEGER");
        stringBuilder.append(" pkgSize INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[12] = "downloadNetType";
        c4924a.xDd.put("downloadNetType", "INTEGER");
        stringBuilder.append(" downloadNetType INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[13] = "nextCheckTime";
        c4924a.xDd.put("nextCheckTime", "LONG");
        stringBuilder.append(" nextCheckTime LONG");
        stringBuilder.append(", ");
        c4924a.columns[14] = "createTime";
        c4924a.xDd.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        stringBuilder.append(", ");
        c4924a.columns[15] = "accessTime";
        c4924a.xDd.put("accessTime", "LONG default '0' ");
        stringBuilder.append(" accessTime LONG default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[16] = "charset";
        c4924a.xDd.put("charset", "TEXT default 'UTF-8' ");
        stringBuilder.append(" charset TEXT default 'UTF-8' ");
        stringBuilder.append(", ");
        c4924a.columns[17] = "bigPackageReady";
        c4924a.xDd.put("bigPackageReady", "INTEGER default 'false' ");
        stringBuilder.append(" bigPackageReady INTEGER default 'false' ");
        stringBuilder.append(", ");
        c4924a.columns[18] = "preloadFilesReady";
        c4924a.xDd.put("preloadFilesReady", "INTEGER default 'false' ");
        stringBuilder.append(" preloadFilesReady INTEGER default 'false' ");
        stringBuilder.append(", ");
        c4924a.columns[19] = "preloadFilesAtomic";
        c4924a.xDd.put("preloadFilesAtomic", "INTEGER default 'false' ");
        stringBuilder.append(" preloadFilesAtomic INTEGER default 'false' ");
        stringBuilder.append(", ");
        c4924a.columns[20] = "autoDownloadCount";
        c4924a.xDd.put("autoDownloadCount", "INTEGER default '0' ");
        stringBuilder.append(" autoDownloadCount INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[21] = "disable";
        c4924a.xDd.put("disable", "INTEGER default 'false' ");
        stringBuilder.append(" disable INTEGER default 'false' ");
        stringBuilder.append(", ");
        c4924a.columns[22] = "totalDownloadCount";
        c4924a.xDd.put("totalDownloadCount", "INTEGER default '0' ");
        stringBuilder.append(" totalDownloadCount INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[23] = "packageDownloadCount";
        c4924a.xDd.put("packageDownloadCount", "INTEGER default '0' ");
        stringBuilder.append(" packageDownloadCount INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[24] = "downloadTriggerType";
        c4924a.xDd.put("downloadTriggerType", "INTEGER default '-1' ");
        stringBuilder.append(" downloadTriggerType INTEGER default '-1' ");
        c4924a.columns[25] = "rowid";
        c4924a.sql = stringBuilder.toString();
        fjX = c4924a;
        AppMethodBeat.m2505o(63399);
    }
}
