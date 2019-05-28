package com.tencent.mm.plugin.cdndownloader.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.al;
import java.lang.reflect.Field;

public final class a extends al {
    protected static com.tencent.mm.sdk.e.c.a ccO;

    public final com.tencent.mm.sdk.e.c.a Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.i(958);
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.xDb = new Field[9];
        aVar.columns = new String[10];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "mediaId";
        aVar.xDd.put("mediaId", "TEXT");
        stringBuilder.append(" mediaId TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "downloadUrlHashCode";
        aVar.xDd.put("downloadUrlHashCode", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" downloadUrlHashCode INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "downloadUrlHashCode";
        aVar.columns[2] = "downloadUrl";
        aVar.xDd.put("downloadUrl", "TEXT");
        stringBuilder.append(" downloadUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "httpsUrl";
        aVar.xDd.put("httpsUrl", "TEXT");
        stringBuilder.append(" httpsUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "filePath";
        aVar.xDd.put("filePath", "TEXT");
        stringBuilder.append(" filePath TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "verifyHeaders";
        aVar.xDd.put("verifyHeaders", "TEXT");
        stringBuilder.append(" verifyHeaders TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = "game_package_download";
        aVar.xDd.put("game_package_download", "INTEGER");
        stringBuilder.append(" game_package_download INTEGER");
        stringBuilder.append(", ");
        aVar.columns[7] = "allowMobileNetDownload";
        aVar.xDd.put("allowMobileNetDownload", "INTEGER");
        stringBuilder.append(" allowMobileNetDownload INTEGER");
        stringBuilder.append(", ");
        aVar.columns[8] = "wifiAutoDownload";
        aVar.xDd.put("wifiAutoDownload", "INTEGER");
        stringBuilder.append(" wifiAutoDownload INTEGER");
        aVar.columns[9] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(958);
    }
}
