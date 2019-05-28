package com.tencent.p177mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C37849eg;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.modelvideo.j */
public final class C9716j extends C37849eg {
    protected static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.m2504i(50726);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[8];
        c4924a.columns = new String[9];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "localId";
        c4924a.xDd.put("localId", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" localId INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "localId";
        c4924a.columns[1] = DownloadInfo.FILENAME;
        c4924a.xDd.put(DownloadInfo.FILENAME, "TEXT");
        stringBuilder.append(" fileName TEXT");
        stringBuilder.append(", ");
        c4924a.columns[2] = "fileNameHash";
        c4924a.xDd.put("fileNameHash", "INTEGER");
        stringBuilder.append(" fileNameHash INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[3] = "fileMd5";
        c4924a.xDd.put("fileMd5", "TEXT default '' ");
        stringBuilder.append(" fileMd5 TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[4] = "fileLength";
        c4924a.xDd.put("fileLength", "LONG default '0' ");
        stringBuilder.append(" fileLength LONG default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[5] = "fileStatus";
        c4924a.xDd.put("fileStatus", "INTEGER default '0' ");
        stringBuilder.append(" fileStatus INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[6] = "fileDuration";
        c4924a.xDd.put("fileDuration", "INTEGER default '0' ");
        stringBuilder.append(" fileDuration INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[7] = "createTime";
        c4924a.xDd.put("createTime", "LONG default '0' ");
        stringBuilder.append(" createTime LONG default '0' ");
        c4924a.columns[8] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(50726);
    }
}
