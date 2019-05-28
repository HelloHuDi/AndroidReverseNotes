package com.tencent.mm.plugin.wepkg.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fr;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class c extends fr {
    public static final a fjX;

    public final a Ag() {
        return fjX;
    }

    static {
        AppMethodBeat.i(63391);
        a aVar = new a();
        aVar.xDb = new Field[14];
        aVar.columns = new String[15];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "key";
        aVar.xDd.put("key", "TEXT PRIMARY KEY ");
        stringBuilder.append(" key TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "key";
        aVar.columns[1] = "pkgId";
        aVar.xDd.put("pkgId", "TEXT");
        stringBuilder.append(" pkgId TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "version";
        aVar.xDd.put("version", "TEXT");
        stringBuilder.append(" version TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "filePath";
        aVar.xDd.put("filePath", "TEXT");
        stringBuilder.append(" filePath TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "rid";
        aVar.xDd.put("rid", "TEXT");
        stringBuilder.append(" rid TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "mimeType";
        aVar.xDd.put("mimeType", "TEXT");
        stringBuilder.append(" mimeType TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = "md5";
        aVar.xDd.put("md5", "TEXT");
        stringBuilder.append(" md5 TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "downloadUrl";
        aVar.xDd.put("downloadUrl", "TEXT");
        stringBuilder.append(" downloadUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[8] = "size";
        aVar.xDd.put("size", "INTEGER");
        stringBuilder.append(" size INTEGER");
        stringBuilder.append(", ");
        aVar.columns[9] = "downloadNetType";
        aVar.xDd.put("downloadNetType", "INTEGER");
        stringBuilder.append(" downloadNetType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[10] = "completeDownload";
        aVar.xDd.put("completeDownload", "INTEGER default 'false' ");
        stringBuilder.append(" completeDownload INTEGER default 'false' ");
        stringBuilder.append(", ");
        aVar.columns[11] = "createTime";
        aVar.xDd.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        stringBuilder.append(", ");
        aVar.columns[12] = "autoDownloadCount";
        aVar.xDd.put("autoDownloadCount", "INTEGER default '0' ");
        stringBuilder.append(" autoDownloadCount INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[13] = "fileDownloadCount";
        aVar.xDd.put("fileDownloadCount", "INTEGER default '0' ");
        stringBuilder.append(" fileDownloadCount INTEGER default '0' ");
        aVar.columns[14] = "rowid";
        aVar.sql = stringBuilder.toString();
        fjX = aVar;
        AppMethodBeat.o(63391);
    }
}
