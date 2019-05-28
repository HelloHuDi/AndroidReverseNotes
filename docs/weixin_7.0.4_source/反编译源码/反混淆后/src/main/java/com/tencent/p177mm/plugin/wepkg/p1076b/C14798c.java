package com.tencent.p177mm.plugin.wepkg.p1076b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C45401fr;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.wepkg.b.c */
public final class C14798c extends C45401fr {
    public static final C4924a fjX;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return fjX;
    }

    static {
        AppMethodBeat.m2504i(63391);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[14];
        c4924a.columns = new String[15];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "key";
        c4924a.xDd.put("key", "TEXT PRIMARY KEY ");
        stringBuilder.append(" key TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "key";
        c4924a.columns[1] = "pkgId";
        c4924a.xDd.put("pkgId", "TEXT");
        stringBuilder.append(" pkgId TEXT");
        stringBuilder.append(", ");
        c4924a.columns[2] = "version";
        c4924a.xDd.put("version", "TEXT");
        stringBuilder.append(" version TEXT");
        stringBuilder.append(", ");
        c4924a.columns[3] = "filePath";
        c4924a.xDd.put("filePath", "TEXT");
        stringBuilder.append(" filePath TEXT");
        stringBuilder.append(", ");
        c4924a.columns[4] = "rid";
        c4924a.xDd.put("rid", "TEXT");
        stringBuilder.append(" rid TEXT");
        stringBuilder.append(", ");
        c4924a.columns[5] = "mimeType";
        c4924a.xDd.put("mimeType", "TEXT");
        stringBuilder.append(" mimeType TEXT");
        stringBuilder.append(", ");
        c4924a.columns[6] = "md5";
        c4924a.xDd.put("md5", "TEXT");
        stringBuilder.append(" md5 TEXT");
        stringBuilder.append(", ");
        c4924a.columns[7] = "downloadUrl";
        c4924a.xDd.put("downloadUrl", "TEXT");
        stringBuilder.append(" downloadUrl TEXT");
        stringBuilder.append(", ");
        c4924a.columns[8] = "size";
        c4924a.xDd.put("size", "INTEGER");
        stringBuilder.append(" size INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[9] = "downloadNetType";
        c4924a.xDd.put("downloadNetType", "INTEGER");
        stringBuilder.append(" downloadNetType INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[10] = "completeDownload";
        c4924a.xDd.put("completeDownload", "INTEGER default 'false' ");
        stringBuilder.append(" completeDownload INTEGER default 'false' ");
        stringBuilder.append(", ");
        c4924a.columns[11] = "createTime";
        c4924a.xDd.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        stringBuilder.append(", ");
        c4924a.columns[12] = "autoDownloadCount";
        c4924a.xDd.put("autoDownloadCount", "INTEGER default '0' ");
        stringBuilder.append(" autoDownloadCount INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[13] = "fileDownloadCount";
        c4924a.xDd.put("fileDownloadCount", "INTEGER default '0' ");
        stringBuilder.append(" fileDownloadCount INTEGER default '0' ");
        c4924a.columns[14] = "rowid";
        c4924a.sql = stringBuilder.toString();
        fjX = c4924a;
        AppMethodBeat.m2505o(63391);
    }
}
