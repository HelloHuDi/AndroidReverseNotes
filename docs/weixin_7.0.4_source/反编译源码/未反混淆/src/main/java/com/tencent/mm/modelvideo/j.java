package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eg;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.lang.reflect.Field;

public final class j extends eg {
    protected static a ccO;

    public final a Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.i(50726);
        a aVar = new a();
        aVar.xDb = new Field[8];
        aVar.columns = new String[9];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "localId";
        aVar.xDd.put("localId", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" localId INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "localId";
        aVar.columns[1] = DownloadInfo.FILENAME;
        aVar.xDd.put(DownloadInfo.FILENAME, "TEXT");
        stringBuilder.append(" fileName TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "fileNameHash";
        aVar.xDd.put("fileNameHash", "INTEGER");
        stringBuilder.append(" fileNameHash INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "fileMd5";
        aVar.xDd.put("fileMd5", "TEXT default '' ");
        stringBuilder.append(" fileMd5 TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[4] = "fileLength";
        aVar.xDd.put("fileLength", "LONG default '0' ");
        stringBuilder.append(" fileLength LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[5] = "fileStatus";
        aVar.xDd.put("fileStatus", "INTEGER default '0' ");
        stringBuilder.append(" fileStatus INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[6] = "fileDuration";
        aVar.xDd.put("fileDuration", "INTEGER default '0' ");
        stringBuilder.append(" fileDuration INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[7] = "createTime";
        aVar.xDd.put("createTime", "LONG default '0' ");
        stringBuilder.append(" createTime LONG default '0' ");
        aVar.columns[8] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(50726);
    }
}
