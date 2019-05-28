package com.tencent.mm.plugin.game.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bz;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.lang.reflect.Field;

public final class d extends bz {
    protected static a ccO;

    public final a Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.i(111507);
        a aVar = new a();
        aVar.xDb = new Field[17];
        aVar.columns = new String[18];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appId";
        aVar.xDd.put("appId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" appId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "appId";
        aVar.columns[1] = "downloadUrl";
        aVar.xDd.put("downloadUrl", "TEXT");
        stringBuilder.append(" downloadUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "size";
        aVar.xDd.put("size", "LONG default '0' ");
        stringBuilder.append(" size LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "md5";
        aVar.xDd.put("md5", "TEXT");
        stringBuilder.append(" md5 TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = DownloadInfoColumns.PACKAGENAME;
        aVar.xDd.put(DownloadInfoColumns.PACKAGENAME, "TEXT");
        stringBuilder.append(" packageName TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "expireTime";
        aVar.xDd.put("expireTime", "LONG default '0' ");
        stringBuilder.append(" expireTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[6] = "randomTime";
        aVar.xDd.put("randomTime", "LONG default '0' ");
        stringBuilder.append(" randomTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[7] = "isFirst";
        aVar.xDd.put("isFirst", "INTEGER default 'true' ");
        stringBuilder.append(" isFirst INTEGER default 'true' ");
        stringBuilder.append(", ");
        aVar.columns[8] = "nextCheckTime";
        aVar.xDd.put("nextCheckTime", "LONG default '0' ");
        stringBuilder.append(" nextCheckTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[9] = "isRunning";
        aVar.xDd.put("isRunning", "INTEGER default 'false' ");
        stringBuilder.append(" isRunning INTEGER default 'false' ");
        stringBuilder.append(", ");
        aVar.columns[10] = "noWifi";
        aVar.xDd.put("noWifi", "INTEGER default 'true' ");
        stringBuilder.append(" noWifi INTEGER default 'true' ");
        stringBuilder.append(", ");
        aVar.columns[11] = "noSdcard";
        aVar.xDd.put("noSdcard", "INTEGER default 'true' ");
        stringBuilder.append(" noSdcard INTEGER default 'true' ");
        stringBuilder.append(", ");
        aVar.columns[12] = "noEnoughSpace";
        aVar.xDd.put("noEnoughSpace", "INTEGER default 'true' ");
        stringBuilder.append(" noEnoughSpace INTEGER default 'true' ");
        stringBuilder.append(", ");
        aVar.columns[13] = "lowBattery";
        aVar.xDd.put("lowBattery", "INTEGER default 'true' ");
        stringBuilder.append(" lowBattery INTEGER default 'true' ");
        stringBuilder.append(", ");
        aVar.columns[14] = "continueDelay";
        aVar.xDd.put("continueDelay", "INTEGER default 'true' ");
        stringBuilder.append(" continueDelay INTEGER default 'true' ");
        stringBuilder.append(", ");
        aVar.columns[15] = "SecondaryUrl";
        aVar.xDd.put("SecondaryUrl", "TEXT");
        stringBuilder.append(" SecondaryUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[16] = "downloadInWidget";
        aVar.xDd.put("downloadInWidget", "INTEGER");
        stringBuilder.append(" downloadInWidget INTEGER");
        aVar.columns[17] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(111507);
    }
}
