package com.tencent.p177mm.plugin.cdndownloader.p935f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C18457al;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.cdndownloader.f.a */
public final class C38783a extends C18457al {
    protected static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.m2504i(958);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[9];
        c4924a.columns = new String[10];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "mediaId";
        c4924a.xDd.put("mediaId", "TEXT");
        stringBuilder.append(" mediaId TEXT");
        stringBuilder.append(", ");
        c4924a.columns[1] = "downloadUrlHashCode";
        c4924a.xDd.put("downloadUrlHashCode", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" downloadUrlHashCode INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "downloadUrlHashCode";
        c4924a.columns[2] = "downloadUrl";
        c4924a.xDd.put("downloadUrl", "TEXT");
        stringBuilder.append(" downloadUrl TEXT");
        stringBuilder.append(", ");
        c4924a.columns[3] = "httpsUrl";
        c4924a.xDd.put("httpsUrl", "TEXT");
        stringBuilder.append(" httpsUrl TEXT");
        stringBuilder.append(", ");
        c4924a.columns[4] = "filePath";
        c4924a.xDd.put("filePath", "TEXT");
        stringBuilder.append(" filePath TEXT");
        stringBuilder.append(", ");
        c4924a.columns[5] = "verifyHeaders";
        c4924a.xDd.put("verifyHeaders", "TEXT");
        stringBuilder.append(" verifyHeaders TEXT");
        stringBuilder.append(", ");
        c4924a.columns[6] = "game_package_download";
        c4924a.xDd.put("game_package_download", "INTEGER");
        stringBuilder.append(" game_package_download INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[7] = "allowMobileNetDownload";
        c4924a.xDd.put("allowMobileNetDownload", "INTEGER");
        stringBuilder.append(" allowMobileNetDownload INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[8] = "wifiAutoDownload";
        c4924a.xDd.put("wifiAutoDownload", "INTEGER");
        stringBuilder.append(" wifiAutoDownload INTEGER");
        c4924a.columns[9] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(958);
    }
}
