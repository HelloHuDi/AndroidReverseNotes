package com.tencent.mm.plugin.record.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.du;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class i extends du implements c {
    public static a ccO;

    public final a Ag() {
        return ccO;
    }

    public final int cez() {
        return this.field_localId;
    }

    public final String toString() {
        AppMethodBeat.i(57134);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("localid[").append(this.field_localId).append("]\n");
        stringBuilder.append("recordId[").append(this.field_recordLocalId).append("]\n");
        stringBuilder.append("mediaId[").append(this.field_mediaId).append("]\n");
        stringBuilder.append("dataId[").append(this.field_dataId).append("]\n");
        stringBuilder.append("path[").append(this.field_path).append("]\n");
        stringBuilder.append("cdnurl[").append(this.field_cdnUrl).append("]\n");
        stringBuilder.append("cdnkey[").append(this.field_cdnKey).append("]\n");
        stringBuilder.append("type[").append(this.field_type).append("]\n");
        stringBuilder.append("errCode[").append(this.field_errCode).append("]\n");
        stringBuilder.append("fileType[").append(this.field_fileType).append("]\n");
        stringBuilder.append("isThumb[").append(this.field_isThumb).append("]\n");
        stringBuilder.append("status[").append(this.field_status).append("]\n");
        stringBuilder.append("totalLen[").append(this.field_totalLen).append("]\n");
        stringBuilder.append("offset[").append(this.field_offset).append("]\n");
        stringBuilder.append("toUser[").append(this.field_toUser).append("]\n");
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(57134);
        return stringBuilder2;
    }

    static {
        AppMethodBeat.i(57135);
        a aVar = new a();
        aVar.xDb = new Field[18];
        aVar.columns = new String[19];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "localId";
        aVar.xDd.put("localId", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" localId INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "localId";
        aVar.columns[1] = "recordLocalId";
        aVar.xDd.put("recordLocalId", "INTEGER");
        stringBuilder.append(" recordLocalId INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "toUser";
        aVar.xDd.put("toUser", "TEXT default '' ");
        stringBuilder.append(" toUser TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "dataId";
        aVar.xDd.put("dataId", "TEXT");
        stringBuilder.append(" dataId TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "mediaId";
        aVar.xDd.put("mediaId", "TEXT");
        stringBuilder.append(" mediaId TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "path";
        aVar.xDd.put("path", "TEXT");
        stringBuilder.append(" path TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = "cdnUrl";
        aVar.xDd.put("cdnUrl", "TEXT");
        stringBuilder.append(" cdnUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "cdnKey";
        aVar.xDd.put("cdnKey", "TEXT");
        stringBuilder.append(" cdnKey TEXT");
        stringBuilder.append(", ");
        aVar.columns[8] = "totalLen";
        aVar.xDd.put("totalLen", "INTEGER default '0' ");
        stringBuilder.append(" totalLen INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[9] = "isThumb";
        aVar.xDd.put("isThumb", "INTEGER default 'false' ");
        stringBuilder.append(" isThumb INTEGER default 'false' ");
        stringBuilder.append(", ");
        aVar.columns[10] = "offset";
        aVar.xDd.put("offset", "INTEGER default '0' ");
        stringBuilder.append(" offset INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[11] = "type";
        aVar.xDd.put("type", "INTEGER default '0' ");
        stringBuilder.append(" type INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[12] = "fileType";
        aVar.xDd.put("fileType", "INTEGER default '5' ");
        stringBuilder.append(" fileType INTEGER default '5' ");
        stringBuilder.append(", ");
        aVar.columns[13] = "status";
        aVar.xDd.put("status", "INTEGER default '0' ");
        stringBuilder.append(" status INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[14] = "errCode";
        aVar.xDd.put("errCode", "INTEGER default '0' ");
        stringBuilder.append(" errCode INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[15] = "tpaeskey";
        aVar.xDd.put("tpaeskey", "TEXT");
        stringBuilder.append(" tpaeskey TEXT");
        stringBuilder.append(", ");
        aVar.columns[16] = "tpauthkey";
        aVar.xDd.put("tpauthkey", "TEXT");
        stringBuilder.append(" tpauthkey TEXT");
        stringBuilder.append(", ");
        aVar.columns[17] = "tpdataurl";
        aVar.xDd.put("tpdataurl", "TEXT");
        stringBuilder.append(" tpdataurl TEXT");
        aVar.columns[18] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(57135);
    }
}
