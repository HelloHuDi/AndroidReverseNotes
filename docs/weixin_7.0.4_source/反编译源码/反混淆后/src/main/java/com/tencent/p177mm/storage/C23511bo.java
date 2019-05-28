package com.tencent.p177mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C42108dh;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.storage.bo */
public final class C23511bo extends C42108dh {
    protected static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.m2504i(29064);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[6];
        c4924a.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "appId";
        c4924a.xDd.put("appId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" appId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "appId";
        c4924a.columns[1] = DownloadInfoColumns.PACKAGENAME;
        c4924a.xDd.put(DownloadInfoColumns.PACKAGENAME, "TEXT");
        stringBuilder.append(" packageName TEXT");
        stringBuilder.append(", ");
        c4924a.columns[2] = "status";
        c4924a.xDd.put("status", "INTEGER default '0' ");
        stringBuilder.append(" status INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[3] = "sceneFlag";
        c4924a.xDd.put("sceneFlag", "INTEGER default '0' ");
        stringBuilder.append(" sceneFlag INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[4] = "msgTypeFlag";
        c4924a.xDd.put("msgTypeFlag", "INTEGER default '0' ");
        stringBuilder.append(" msgTypeFlag INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[5] = "msgState";
        c4924a.xDd.put("msgState", "INTEGER default '0' ");
        stringBuilder.append(" msgState INTEGER default '0' ");
        c4924a.columns[6] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(29064);
    }
}
