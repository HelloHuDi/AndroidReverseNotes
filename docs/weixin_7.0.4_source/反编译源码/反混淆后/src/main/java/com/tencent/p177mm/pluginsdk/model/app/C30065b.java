package com.tencent.p177mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C32700h;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.pluginsdk.model.app.b */
public final class C30065b extends C32700h {
    protected static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    public C30065b() {
        this.field_netTimes = 0;
    }

    public final boolean bCR() {
        if (this.field_totalLen > 0 && this.field_offset == this.field_totalLen) {
            return true;
        }
        return false;
    }

    static {
        AppMethodBeat.m2504i(79230);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[20];
        c4924a.columns = new String[21];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "appId";
        c4924a.xDd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        c4924a.columns[1] = "sdkVer";
        c4924a.xDd.put("sdkVer", "LONG");
        stringBuilder.append(" sdkVer LONG");
        stringBuilder.append(", ");
        c4924a.columns[2] = "mediaSvrId";
        c4924a.xDd.put("mediaSvrId", "TEXT");
        stringBuilder.append(" mediaSvrId TEXT");
        stringBuilder.append(", ");
        c4924a.columns[3] = "mediaId";
        c4924a.xDd.put("mediaId", "TEXT");
        stringBuilder.append(" mediaId TEXT");
        stringBuilder.append(", ");
        c4924a.columns[4] = "clientAppDataId";
        c4924a.xDd.put("clientAppDataId", "TEXT");
        stringBuilder.append(" clientAppDataId TEXT");
        stringBuilder.append(", ");
        c4924a.columns[5] = "type";
        c4924a.xDd.put("type", "LONG");
        stringBuilder.append(" type LONG");
        stringBuilder.append(", ");
        c4924a.columns[6] = "totalLen";
        c4924a.xDd.put("totalLen", "LONG");
        stringBuilder.append(" totalLen LONG");
        stringBuilder.append(", ");
        c4924a.columns[7] = "offset";
        c4924a.xDd.put("offset", "LONG");
        stringBuilder.append(" offset LONG");
        stringBuilder.append(", ");
        c4924a.columns[8] = "status";
        c4924a.xDd.put("status", "LONG");
        stringBuilder.append(" status LONG");
        stringBuilder.append(", ");
        c4924a.columns[9] = "isUpload";
        c4924a.xDd.put("isUpload", "INTEGER");
        stringBuilder.append(" isUpload INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[10] = "createTime";
        c4924a.xDd.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        stringBuilder.append(", ");
        c4924a.columns[11] = "lastModifyTime";
        c4924a.xDd.put("lastModifyTime", "LONG");
        stringBuilder.append(" lastModifyTime LONG");
        stringBuilder.append(", ");
        c4924a.columns[12] = "fileFullPath";
        c4924a.xDd.put("fileFullPath", "TEXT");
        stringBuilder.append(" fileFullPath TEXT");
        stringBuilder.append(", ");
        c4924a.columns[13] = "fullXml";
        c4924a.xDd.put("fullXml", "TEXT");
        stringBuilder.append(" fullXml TEXT");
        stringBuilder.append(", ");
        c4924a.columns[14] = "msgInfoId";
        c4924a.xDd.put("msgInfoId", "LONG");
        stringBuilder.append(" msgInfoId LONG");
        stringBuilder.append(", ");
        c4924a.columns[15] = "netTimes";
        c4924a.xDd.put("netTimes", "LONG");
        stringBuilder.append(" netTimes LONG");
        stringBuilder.append(", ");
        c4924a.columns[16] = "isUseCdn";
        c4924a.xDd.put("isUseCdn", "INTEGER");
        stringBuilder.append(" isUseCdn INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[17] = "signature";
        c4924a.xDd.put("signature", "TEXT");
        stringBuilder.append(" signature TEXT");
        stringBuilder.append(", ");
        c4924a.columns[18] = "fakeAeskey";
        c4924a.xDd.put("fakeAeskey", "TEXT");
        stringBuilder.append(" fakeAeskey TEXT");
        stringBuilder.append(", ");
        c4924a.columns[19] = "fakeSignature";
        c4924a.xDd.put("fakeSignature", "TEXT");
        stringBuilder.append(" fakeSignature TEXT");
        c4924a.columns[20] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(79230);
    }
}
