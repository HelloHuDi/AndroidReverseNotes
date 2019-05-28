package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dh;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.lang.reflect.Field;

public final class bo extends dh {
    protected static a ccO;

    public final a Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.i(29064);
        a aVar = new a();
        aVar.xDb = new Field[6];
        aVar.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appId";
        aVar.xDd.put("appId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" appId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "appId";
        aVar.columns[1] = DownloadInfoColumns.PACKAGENAME;
        aVar.xDd.put(DownloadInfoColumns.PACKAGENAME, "TEXT");
        stringBuilder.append(" packageName TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "status";
        aVar.xDd.put("status", "INTEGER default '0' ");
        stringBuilder.append(" status INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "sceneFlag";
        aVar.xDd.put("sceneFlag", "INTEGER default '0' ");
        stringBuilder.append(" sceneFlag INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[4] = "msgTypeFlag";
        aVar.xDd.put("msgTypeFlag", "INTEGER default '0' ");
        stringBuilder.append(" msgTypeFlag INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[5] = "msgState";
        aVar.xDd.put("msgState", "INTEGER default '0' ");
        stringBuilder.append(" msgState INTEGER default '0' ");
        aVar.columns[6] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(29064);
    }
}
