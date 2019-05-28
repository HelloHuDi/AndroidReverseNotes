package com.tencent.p177mm.pluginsdk.p592g.p593a.p596c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C18472dx;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.pluginsdk.g.a.c.s */
public final class C44049s extends C18472dx {
    public static final C4924a ccO;

    public final String toString() {
        AppMethodBeat.m2504i(79627);
        StringBuilder stringBuilder = new StringBuilder("ResDownloaderRecord {");
        try {
            for (Field field : getClass().getSuperclass().getDeclaredFields()) {
                if (field.getName().startsWith("field_")) {
                    field.setAccessible(true);
                    stringBuilder.append(field.getName().replaceFirst("field_", "")).append(" = ").append(field.get(this)).append(", ");
                }
            }
        } catch (IllegalAccessException e) {
            C4990ab.printErrStackTrace("MicroMsg.ResDownloaderRecord", e, "", new Object[0]);
        }
        try {
            Field field2 = getClass().getSuperclass().getSuperclass().getField("systemRowid");
            field2.setAccessible(true);
            stringBuilder.append("systemRowid = ").append(field2.get(this));
        } catch (IllegalAccessException e2) {
            C4990ab.printErrStackTrace("MicroMsg.ResDownloaderRecord", e2, "", new Object[0]);
        } catch (NoSuchFieldException e3) {
            C4990ab.printErrStackTrace("MicroMsg.ResDownloaderRecord", e3, "", new Object[0]);
        }
        String stringBuilder2 = stringBuilder.append(" }").toString();
        AppMethodBeat.m2505o(79627);
        return stringBuilder2;
    }

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.m2504i(79628);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[34];
        c4924a.columns = new String[35];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "urlKey_hashcode";
        c4924a.xDd.put("urlKey_hashcode", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" urlKey_hashcode INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "urlKey_hashcode";
        c4924a.columns[1] = "urlKey";
        c4924a.xDd.put("urlKey", "TEXT");
        stringBuilder.append(" urlKey TEXT");
        stringBuilder.append(", ");
        c4924a.columns[2] = "url";
        c4924a.xDd.put("url", "TEXT");
        stringBuilder.append(" url TEXT");
        stringBuilder.append(", ");
        c4924a.columns[3] = "fileVersion";
        c4924a.xDd.put("fileVersion", "TEXT");
        stringBuilder.append(" fileVersion TEXT");
        stringBuilder.append(", ");
        c4924a.columns[4] = "networkType";
        c4924a.xDd.put("networkType", "INTEGER default '2' ");
        stringBuilder.append(" networkType INTEGER default '2' ");
        stringBuilder.append(", ");
        c4924a.columns[5] = "maxRetryTimes";
        c4924a.xDd.put("maxRetryTimes", "INTEGER default '3' ");
        stringBuilder.append(" maxRetryTimes INTEGER default '3' ");
        stringBuilder.append(", ");
        c4924a.columns[6] = "retryTimes";
        c4924a.xDd.put("retryTimes", "INTEGER default '3' ");
        stringBuilder.append(" retryTimes INTEGER default '3' ");
        stringBuilder.append(", ");
        c4924a.columns[7] = "filePath";
        c4924a.xDd.put("filePath", "TEXT");
        stringBuilder.append(" filePath TEXT");
        stringBuilder.append(", ");
        c4924a.columns[8] = "status";
        c4924a.xDd.put("status", "INTEGER default '0' ");
        stringBuilder.append(" status INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[9] = "contentLength";
        c4924a.xDd.put("contentLength", "LONG default '0' ");
        stringBuilder.append(" contentLength LONG default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[10] = DownloadInfo.CONTENTTYPE;
        c4924a.xDd.put(DownloadInfo.CONTENTTYPE, "TEXT");
        stringBuilder.append(" contentType TEXT");
        stringBuilder.append(", ");
        c4924a.columns[11] = "expireTime";
        c4924a.xDd.put("expireTime", "LONG default '0' ");
        stringBuilder.append(" expireTime LONG default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[12] = "md5";
        c4924a.xDd.put("md5", "TEXT");
        stringBuilder.append(" md5 TEXT");
        stringBuilder.append(", ");
        c4924a.columns[13] = "groupId1";
        c4924a.xDd.put("groupId1", "TEXT");
        stringBuilder.append(" groupId1 TEXT");
        stringBuilder.append(", ");
        c4924a.columns[14] = "groupId2";
        c4924a.xDd.put("groupId2", "TEXT");
        stringBuilder.append(" groupId2 TEXT");
        stringBuilder.append(", ");
        c4924a.columns[15] = DownloadInfo.PRIORITY;
        c4924a.xDd.put(DownloadInfo.PRIORITY, "INTEGER default '0' ");
        stringBuilder.append(" priority INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[16] = "fileUpdated";
        c4924a.xDd.put("fileUpdated", "INTEGER");
        stringBuilder.append(" fileUpdated INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[17] = "deleted";
        c4924a.xDd.put("deleted", "INTEGER default 'false' ");
        stringBuilder.append(" deleted INTEGER default 'false' ");
        stringBuilder.append(", ");
        c4924a.columns[18] = "resType";
        c4924a.xDd.put("resType", "INTEGER");
        stringBuilder.append(" resType INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[19] = "subType";
        c4924a.xDd.put("subType", "INTEGER");
        stringBuilder.append(" subType INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[20] = "reportId";
        c4924a.xDd.put("reportId", "LONG");
        stringBuilder.append(" reportId LONG");
        stringBuilder.append(", ");
        c4924a.columns[21] = "sampleId";
        c4924a.xDd.put("sampleId", "TEXT");
        stringBuilder.append(" sampleId TEXT");
        stringBuilder.append(", ");
        c4924a.columns[22] = "eccSignature";
        c4924a.xDd.put("eccSignature", "BLOB");
        stringBuilder.append(" eccSignature BLOB");
        stringBuilder.append(", ");
        c4924a.columns[23] = "originalMd5";
        c4924a.xDd.put("originalMd5", "TEXT");
        stringBuilder.append(" originalMd5 TEXT");
        stringBuilder.append(", ");
        c4924a.columns[24] = "fileCompress";
        c4924a.xDd.put("fileCompress", "INTEGER default 'false' ");
        stringBuilder.append(" fileCompress INTEGER default 'false' ");
        stringBuilder.append(", ");
        c4924a.columns[25] = "fileEncrypt";
        c4924a.xDd.put("fileEncrypt", "INTEGER default 'false' ");
        stringBuilder.append(" fileEncrypt INTEGER default 'false' ");
        stringBuilder.append(", ");
        c4924a.columns[26] = "encryptKey";
        c4924a.xDd.put("encryptKey", "TEXT");
        stringBuilder.append(" encryptKey TEXT");
        stringBuilder.append(", ");
        c4924a.columns[27] = "keyVersion";
        c4924a.xDd.put("keyVersion", "INTEGER default '0' ");
        stringBuilder.append(" keyVersion INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[28] = "EID";
        c4924a.xDd.put("EID", "INTEGER");
        stringBuilder.append(" EID INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[29] = "fileSize";
        c4924a.xDd.put("fileSize", "LONG");
        stringBuilder.append(" fileSize LONG");
        stringBuilder.append(", ");
        c4924a.columns[30] = "needRetry";
        c4924a.xDd.put("needRetry", "INTEGER default '1' ");
        stringBuilder.append(" needRetry INTEGER default '1' ");
        stringBuilder.append(", ");
        c4924a.columns[31] = "appId";
        c4924a.xDd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        c4924a.columns[32] = "wvCacheType";
        c4924a.xDd.put("wvCacheType", "INTEGER");
        stringBuilder.append(" wvCacheType INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[33] = "packageId";
        c4924a.xDd.put("packageId", "TEXT");
        stringBuilder.append(" packageId TEXT");
        c4924a.columns[34] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(79628);
    }
}
