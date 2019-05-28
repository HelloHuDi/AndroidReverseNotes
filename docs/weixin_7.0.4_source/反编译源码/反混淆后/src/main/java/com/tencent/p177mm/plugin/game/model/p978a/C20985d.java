package com.tencent.p177mm.plugin.game.model.p978a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C26302bz;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.game.model.a.d */
public final class C20985d extends C26302bz {
    protected static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.m2504i(111507);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[17];
        c4924a.columns = new String[18];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "appId";
        c4924a.xDd.put("appId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" appId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "appId";
        c4924a.columns[1] = "downloadUrl";
        c4924a.xDd.put("downloadUrl", "TEXT");
        stringBuilder.append(" downloadUrl TEXT");
        stringBuilder.append(", ");
        c4924a.columns[2] = "size";
        c4924a.xDd.put("size", "LONG default '0' ");
        stringBuilder.append(" size LONG default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[3] = "md5";
        c4924a.xDd.put("md5", "TEXT");
        stringBuilder.append(" md5 TEXT");
        stringBuilder.append(", ");
        c4924a.columns[4] = DownloadInfoColumns.PACKAGENAME;
        c4924a.xDd.put(DownloadInfoColumns.PACKAGENAME, "TEXT");
        stringBuilder.append(" packageName TEXT");
        stringBuilder.append(", ");
        c4924a.columns[5] = "expireTime";
        c4924a.xDd.put("expireTime", "LONG default '0' ");
        stringBuilder.append(" expireTime LONG default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[6] = "randomTime";
        c4924a.xDd.put("randomTime", "LONG default '0' ");
        stringBuilder.append(" randomTime LONG default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[7] = "isFirst";
        c4924a.xDd.put("isFirst", "INTEGER default 'true' ");
        stringBuilder.append(" isFirst INTEGER default 'true' ");
        stringBuilder.append(", ");
        c4924a.columns[8] = "nextCheckTime";
        c4924a.xDd.put("nextCheckTime", "LONG default '0' ");
        stringBuilder.append(" nextCheckTime LONG default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[9] = "isRunning";
        c4924a.xDd.put("isRunning", "INTEGER default 'false' ");
        stringBuilder.append(" isRunning INTEGER default 'false' ");
        stringBuilder.append(", ");
        c4924a.columns[10] = "noWifi";
        c4924a.xDd.put("noWifi", "INTEGER default 'true' ");
        stringBuilder.append(" noWifi INTEGER default 'true' ");
        stringBuilder.append(", ");
        c4924a.columns[11] = "noSdcard";
        c4924a.xDd.put("noSdcard", "INTEGER default 'true' ");
        stringBuilder.append(" noSdcard INTEGER default 'true' ");
        stringBuilder.append(", ");
        c4924a.columns[12] = "noEnoughSpace";
        c4924a.xDd.put("noEnoughSpace", "INTEGER default 'true' ");
        stringBuilder.append(" noEnoughSpace INTEGER default 'true' ");
        stringBuilder.append(", ");
        c4924a.columns[13] = "lowBattery";
        c4924a.xDd.put("lowBattery", "INTEGER default 'true' ");
        stringBuilder.append(" lowBattery INTEGER default 'true' ");
        stringBuilder.append(", ");
        c4924a.columns[14] = "continueDelay";
        c4924a.xDd.put("continueDelay", "INTEGER default 'true' ");
        stringBuilder.append(" continueDelay INTEGER default 'true' ");
        stringBuilder.append(", ");
        c4924a.columns[15] = "SecondaryUrl";
        c4924a.xDd.put("SecondaryUrl", "TEXT");
        stringBuilder.append(" SecondaryUrl TEXT");
        stringBuilder.append(", ");
        c4924a.columns[16] = "downloadInWidget";
        c4924a.xDd.put("downloadInWidget", "INTEGER");
        stringBuilder.append(" downloadInWidget INTEGER");
        c4924a.columns[17] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(111507);
    }
}
