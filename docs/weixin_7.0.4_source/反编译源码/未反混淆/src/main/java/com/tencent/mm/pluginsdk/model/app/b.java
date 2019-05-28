package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.h;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class b extends h {
    protected static a ccO;

    public final a Ag() {
        return ccO;
    }

    public b() {
        this.field_netTimes = 0;
    }

    public final boolean bCR() {
        if (this.field_totalLen > 0 && this.field_offset == this.field_totalLen) {
            return true;
        }
        return false;
    }

    static {
        AppMethodBeat.i(79230);
        a aVar = new a();
        aVar.xDb = new Field[20];
        aVar.columns = new String[21];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appId";
        aVar.xDd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "sdkVer";
        aVar.xDd.put("sdkVer", "LONG");
        stringBuilder.append(" sdkVer LONG");
        stringBuilder.append(", ");
        aVar.columns[2] = "mediaSvrId";
        aVar.xDd.put("mediaSvrId", "TEXT");
        stringBuilder.append(" mediaSvrId TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "mediaId";
        aVar.xDd.put("mediaId", "TEXT");
        stringBuilder.append(" mediaId TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "clientAppDataId";
        aVar.xDd.put("clientAppDataId", "TEXT");
        stringBuilder.append(" clientAppDataId TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "type";
        aVar.xDd.put("type", "LONG");
        stringBuilder.append(" type LONG");
        stringBuilder.append(", ");
        aVar.columns[6] = "totalLen";
        aVar.xDd.put("totalLen", "LONG");
        stringBuilder.append(" totalLen LONG");
        stringBuilder.append(", ");
        aVar.columns[7] = "offset";
        aVar.xDd.put("offset", "LONG");
        stringBuilder.append(" offset LONG");
        stringBuilder.append(", ");
        aVar.columns[8] = "status";
        aVar.xDd.put("status", "LONG");
        stringBuilder.append(" status LONG");
        stringBuilder.append(", ");
        aVar.columns[9] = "isUpload";
        aVar.xDd.put("isUpload", "INTEGER");
        stringBuilder.append(" isUpload INTEGER");
        stringBuilder.append(", ");
        aVar.columns[10] = "createTime";
        aVar.xDd.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        stringBuilder.append(", ");
        aVar.columns[11] = "lastModifyTime";
        aVar.xDd.put("lastModifyTime", "LONG");
        stringBuilder.append(" lastModifyTime LONG");
        stringBuilder.append(", ");
        aVar.columns[12] = "fileFullPath";
        aVar.xDd.put("fileFullPath", "TEXT");
        stringBuilder.append(" fileFullPath TEXT");
        stringBuilder.append(", ");
        aVar.columns[13] = "fullXml";
        aVar.xDd.put("fullXml", "TEXT");
        stringBuilder.append(" fullXml TEXT");
        stringBuilder.append(", ");
        aVar.columns[14] = "msgInfoId";
        aVar.xDd.put("msgInfoId", "LONG");
        stringBuilder.append(" msgInfoId LONG");
        stringBuilder.append(", ");
        aVar.columns[15] = "netTimes";
        aVar.xDd.put("netTimes", "LONG");
        stringBuilder.append(" netTimes LONG");
        stringBuilder.append(", ");
        aVar.columns[16] = "isUseCdn";
        aVar.xDd.put("isUseCdn", "INTEGER");
        stringBuilder.append(" isUseCdn INTEGER");
        stringBuilder.append(", ");
        aVar.columns[17] = "signature";
        aVar.xDd.put("signature", "TEXT");
        stringBuilder.append(" signature TEXT");
        stringBuilder.append(", ");
        aVar.columns[18] = "fakeAeskey";
        aVar.xDd.put("fakeAeskey", "TEXT");
        stringBuilder.append(" fakeAeskey TEXT");
        stringBuilder.append(", ");
        aVar.columns[19] = "fakeSignature";
        aVar.xDd.put("fakeSignature", "TEXT");
        stringBuilder.append(" fakeSignature TEXT");
        aVar.columns[20] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(79230);
    }
}
