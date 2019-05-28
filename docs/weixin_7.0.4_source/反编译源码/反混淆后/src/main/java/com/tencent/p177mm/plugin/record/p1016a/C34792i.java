package com.tencent.p177mm.plugin.record.p1016a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C9527du;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.record.a.i */
public final class C34792i extends C9527du implements C21594c {
    public static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    public final int cez() {
        return this.field_localId;
    }

    public final String toString() {
        AppMethodBeat.m2504i(57134);
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
        AppMethodBeat.m2505o(57134);
        return stringBuilder2;
    }

    static {
        AppMethodBeat.m2504i(57135);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[18];
        c4924a.columns = new String[19];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "localId";
        c4924a.xDd.put("localId", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" localId INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "localId";
        c4924a.columns[1] = "recordLocalId";
        c4924a.xDd.put("recordLocalId", "INTEGER");
        stringBuilder.append(" recordLocalId INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[2] = "toUser";
        c4924a.xDd.put("toUser", "TEXT default '' ");
        stringBuilder.append(" toUser TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[3] = "dataId";
        c4924a.xDd.put("dataId", "TEXT");
        stringBuilder.append(" dataId TEXT");
        stringBuilder.append(", ");
        c4924a.columns[4] = "mediaId";
        c4924a.xDd.put("mediaId", "TEXT");
        stringBuilder.append(" mediaId TEXT");
        stringBuilder.append(", ");
        c4924a.columns[5] = "path";
        c4924a.xDd.put("path", "TEXT");
        stringBuilder.append(" path TEXT");
        stringBuilder.append(", ");
        c4924a.columns[6] = "cdnUrl";
        c4924a.xDd.put("cdnUrl", "TEXT");
        stringBuilder.append(" cdnUrl TEXT");
        stringBuilder.append(", ");
        c4924a.columns[7] = "cdnKey";
        c4924a.xDd.put("cdnKey", "TEXT");
        stringBuilder.append(" cdnKey TEXT");
        stringBuilder.append(", ");
        c4924a.columns[8] = "totalLen";
        c4924a.xDd.put("totalLen", "INTEGER default '0' ");
        stringBuilder.append(" totalLen INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[9] = "isThumb";
        c4924a.xDd.put("isThumb", "INTEGER default 'false' ");
        stringBuilder.append(" isThumb INTEGER default 'false' ");
        stringBuilder.append(", ");
        c4924a.columns[10] = "offset";
        c4924a.xDd.put("offset", "INTEGER default '0' ");
        stringBuilder.append(" offset INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[11] = "type";
        c4924a.xDd.put("type", "INTEGER default '0' ");
        stringBuilder.append(" type INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[12] = "fileType";
        c4924a.xDd.put("fileType", "INTEGER default '5' ");
        stringBuilder.append(" fileType INTEGER default '5' ");
        stringBuilder.append(", ");
        c4924a.columns[13] = "status";
        c4924a.xDd.put("status", "INTEGER default '0' ");
        stringBuilder.append(" status INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[14] = "errCode";
        c4924a.xDd.put("errCode", "INTEGER default '0' ");
        stringBuilder.append(" errCode INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[15] = "tpaeskey";
        c4924a.xDd.put("tpaeskey", "TEXT");
        stringBuilder.append(" tpaeskey TEXT");
        stringBuilder.append(", ");
        c4924a.columns[16] = "tpauthkey";
        c4924a.xDd.put("tpauthkey", "TEXT");
        stringBuilder.append(" tpauthkey TEXT");
        stringBuilder.append(", ");
        c4924a.columns[17] = "tpdataurl";
        c4924a.xDd.put("tpdataurl", "TEXT");
        stringBuilder.append(" tpdataurl TEXT");
        c4924a.columns[18] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(57135);
    }
}
