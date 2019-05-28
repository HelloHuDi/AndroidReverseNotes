package com.tencent.mm.pluginsdk.g.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dx;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.lang.reflect.Field;

public final class s extends dx {
    public static final a ccO;

    public final String toString() {
        AppMethodBeat.i(79627);
        StringBuilder stringBuilder = new StringBuilder("ResDownloaderRecord {");
        try {
            for (Field field : getClass().getSuperclass().getDeclaredFields()) {
                if (field.getName().startsWith("field_")) {
                    field.setAccessible(true);
                    stringBuilder.append(field.getName().replaceFirst("field_", "")).append(" = ").append(field.get(this)).append(", ");
                }
            }
        } catch (IllegalAccessException e) {
            ab.printErrStackTrace("MicroMsg.ResDownloaderRecord", e, "", new Object[0]);
        }
        try {
            Field field2 = getClass().getSuperclass().getSuperclass().getField("systemRowid");
            field2.setAccessible(true);
            stringBuilder.append("systemRowid = ").append(field2.get(this));
        } catch (IllegalAccessException e2) {
            ab.printErrStackTrace("MicroMsg.ResDownloaderRecord", e2, "", new Object[0]);
        } catch (NoSuchFieldException e3) {
            ab.printErrStackTrace("MicroMsg.ResDownloaderRecord", e3, "", new Object[0]);
        }
        String stringBuilder2 = stringBuilder.append(" }").toString();
        AppMethodBeat.o(79627);
        return stringBuilder2;
    }

    public final a Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.i(79628);
        a aVar = new a();
        aVar.xDb = new Field[34];
        aVar.columns = new String[35];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "urlKey_hashcode";
        aVar.xDd.put("urlKey_hashcode", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" urlKey_hashcode INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "urlKey_hashcode";
        aVar.columns[1] = "urlKey";
        aVar.xDd.put("urlKey", "TEXT");
        stringBuilder.append(" urlKey TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "url";
        aVar.xDd.put("url", "TEXT");
        stringBuilder.append(" url TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "fileVersion";
        aVar.xDd.put("fileVersion", "TEXT");
        stringBuilder.append(" fileVersion TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "networkType";
        aVar.xDd.put("networkType", "INTEGER default '2' ");
        stringBuilder.append(" networkType INTEGER default '2' ");
        stringBuilder.append(", ");
        aVar.columns[5] = "maxRetryTimes";
        aVar.xDd.put("maxRetryTimes", "INTEGER default '3' ");
        stringBuilder.append(" maxRetryTimes INTEGER default '3' ");
        stringBuilder.append(", ");
        aVar.columns[6] = "retryTimes";
        aVar.xDd.put("retryTimes", "INTEGER default '3' ");
        stringBuilder.append(" retryTimes INTEGER default '3' ");
        stringBuilder.append(", ");
        aVar.columns[7] = "filePath";
        aVar.xDd.put("filePath", "TEXT");
        stringBuilder.append(" filePath TEXT");
        stringBuilder.append(", ");
        aVar.columns[8] = "status";
        aVar.xDd.put("status", "INTEGER default '0' ");
        stringBuilder.append(" status INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[9] = "contentLength";
        aVar.xDd.put("contentLength", "LONG default '0' ");
        stringBuilder.append(" contentLength LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[10] = DownloadInfo.CONTENTTYPE;
        aVar.xDd.put(DownloadInfo.CONTENTTYPE, "TEXT");
        stringBuilder.append(" contentType TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = "expireTime";
        aVar.xDd.put("expireTime", "LONG default '0' ");
        stringBuilder.append(" expireTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[12] = "md5";
        aVar.xDd.put("md5", "TEXT");
        stringBuilder.append(" md5 TEXT");
        stringBuilder.append(", ");
        aVar.columns[13] = "groupId1";
        aVar.xDd.put("groupId1", "TEXT");
        stringBuilder.append(" groupId1 TEXT");
        stringBuilder.append(", ");
        aVar.columns[14] = "groupId2";
        aVar.xDd.put("groupId2", "TEXT");
        stringBuilder.append(" groupId2 TEXT");
        stringBuilder.append(", ");
        aVar.columns[15] = DownloadInfo.PRIORITY;
        aVar.xDd.put(DownloadInfo.PRIORITY, "INTEGER default '0' ");
        stringBuilder.append(" priority INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[16] = "fileUpdated";
        aVar.xDd.put("fileUpdated", "INTEGER");
        stringBuilder.append(" fileUpdated INTEGER");
        stringBuilder.append(", ");
        aVar.columns[17] = "deleted";
        aVar.xDd.put("deleted", "INTEGER default 'false' ");
        stringBuilder.append(" deleted INTEGER default 'false' ");
        stringBuilder.append(", ");
        aVar.columns[18] = "resType";
        aVar.xDd.put("resType", "INTEGER");
        stringBuilder.append(" resType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[19] = "subType";
        aVar.xDd.put("subType", "INTEGER");
        stringBuilder.append(" subType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[20] = "reportId";
        aVar.xDd.put("reportId", "LONG");
        stringBuilder.append(" reportId LONG");
        stringBuilder.append(", ");
        aVar.columns[21] = "sampleId";
        aVar.xDd.put("sampleId", "TEXT");
        stringBuilder.append(" sampleId TEXT");
        stringBuilder.append(", ");
        aVar.columns[22] = "eccSignature";
        aVar.xDd.put("eccSignature", "BLOB");
        stringBuilder.append(" eccSignature BLOB");
        stringBuilder.append(", ");
        aVar.columns[23] = "originalMd5";
        aVar.xDd.put("originalMd5", "TEXT");
        stringBuilder.append(" originalMd5 TEXT");
        stringBuilder.append(", ");
        aVar.columns[24] = "fileCompress";
        aVar.xDd.put("fileCompress", "INTEGER default 'false' ");
        stringBuilder.append(" fileCompress INTEGER default 'false' ");
        stringBuilder.append(", ");
        aVar.columns[25] = "fileEncrypt";
        aVar.xDd.put("fileEncrypt", "INTEGER default 'false' ");
        stringBuilder.append(" fileEncrypt INTEGER default 'false' ");
        stringBuilder.append(", ");
        aVar.columns[26] = "encryptKey";
        aVar.xDd.put("encryptKey", "TEXT");
        stringBuilder.append(" encryptKey TEXT");
        stringBuilder.append(", ");
        aVar.columns[27] = "keyVersion";
        aVar.xDd.put("keyVersion", "INTEGER default '0' ");
        stringBuilder.append(" keyVersion INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[28] = "EID";
        aVar.xDd.put("EID", "INTEGER");
        stringBuilder.append(" EID INTEGER");
        stringBuilder.append(", ");
        aVar.columns[29] = "fileSize";
        aVar.xDd.put("fileSize", "LONG");
        stringBuilder.append(" fileSize LONG");
        stringBuilder.append(", ");
        aVar.columns[30] = "needRetry";
        aVar.xDd.put("needRetry", "INTEGER default '1' ");
        stringBuilder.append(" needRetry INTEGER default '1' ");
        stringBuilder.append(", ");
        aVar.columns[31] = "appId";
        aVar.xDd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[32] = "wvCacheType";
        aVar.xDd.put("wvCacheType", "INTEGER");
        stringBuilder.append(" wvCacheType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[33] = "packageId";
        aVar.xDd.put("packageId", "TEXT");
        stringBuilder.append(" packageId TEXT");
        aVar.columns[34] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(79628);
    }
}
