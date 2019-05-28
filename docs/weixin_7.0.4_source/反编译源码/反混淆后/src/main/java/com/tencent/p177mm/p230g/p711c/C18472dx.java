package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

/* renamed from: com.tencent.mm.g.c.dx */
public abstract class C18472dx extends C4925c {
    private static final int dBf = "fileSize".hashCode();
    private static final int dDp = "expireTime".hashCode();
    private static final int dMK = "retryTimes".hashCode();
    private static final int dMN = "networkType".hashCode();
    private static final int dOA = "deleted".hashCode();
    private static final int dOB = "resType".hashCode();
    private static final int dOC = "sampleId".hashCode();
    private static final int dOD = "eccSignature".hashCode();
    private static final int dOE = "originalMd5".hashCode();
    private static final int dOF = "fileCompress".hashCode();
    private static final int dOG = "fileEncrypt".hashCode();
    private static final int dOH = "encryptKey".hashCode();
    private static final int dOI = "keyVersion".hashCode();
    private static final int dOJ = "EID".hashCode();
    private static final int dOK = "needRetry".hashCode();
    private static final int dOL = "wvCacheType".hashCode();
    private static final int dOM = "packageId".hashCode();
    private static final int dOq = "urlKey_hashcode".hashCode();
    private static final int dOr = "urlKey".hashCode();
    private static final int dOs = "fileVersion".hashCode();
    private static final int dOt = "maxRetryTimes".hashCode();
    private static final int dOu = "contentLength".hashCode();
    private static final int dOv = DownloadInfo.CONTENTTYPE.hashCode();
    private static final int dOw = "groupId1".hashCode();
    private static final int dOx = "groupId2".hashCode();
    private static final int dOy = DownloadInfo.PRIORITY.hashCode();
    private static final int dOz = "fileUpdated".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int diX = "status".hashCode();
    private static final int dkV = "appId".hashCode();
    private static final int dkw = "subType".hashCode();
    private static final int dmd = "reportId".hashCode();
    private static final int dnT = "url".hashCode();
    private static final int dsb = "filePath".hashCode();
    private static final int dxn = "md5".hashCode();
    private boolean dAJ = true;
    private boolean dDh = true;
    private boolean dMD = true;
    private boolean dMG = true;
    private boolean dNT = true;
    private boolean dNU = true;
    private boolean dNV = true;
    private boolean dNW = true;
    private boolean dNX = true;
    private boolean dNY = true;
    private boolean dNZ = true;
    private boolean dOa = true;
    private boolean dOb = true;
    private boolean dOc = true;
    private boolean dOd = true;
    private boolean dOe = true;
    private boolean dOf = true;
    private boolean dOg = true;
    private boolean dOh = true;
    private boolean dOi = true;
    private boolean dOj = true;
    private boolean dOk = true;
    private boolean dOl = true;
    private boolean dOm = true;
    private boolean dOn = true;
    private boolean dOo = true;
    private boolean dOp = true;
    private boolean diU = true;
    private boolean djY = true;
    private boolean dkE = true;
    private boolean dma = true;
    private boolean dnP = true;
    private boolean drT = true;
    private boolean dwB = true;
    public int field_EID;
    public String field_appId;
    public long field_contentLength;
    public String field_contentType;
    public boolean field_deleted;
    public byte[] field_eccSignature;
    public String field_encryptKey;
    public long field_expireTime;
    public boolean field_fileCompress;
    public boolean field_fileEncrypt;
    public String field_filePath;
    public long field_fileSize;
    public boolean field_fileUpdated;
    public String field_fileVersion;
    public String field_groupId1;
    public String field_groupId2;
    public int field_keyVersion;
    public int field_maxRetryTimes;
    public String field_md5;
    public boolean field_needRetry;
    public int field_networkType;
    public String field_originalMd5;
    public String field_packageId;
    public int field_priority;
    public long field_reportId;
    public int field_resType;
    public int field_retryTimes;
    public String field_sampleId;
    public int field_status;
    public int field_subType;
    public String field_url;
    public String field_urlKey;
    public int field_urlKey_hashcode;
    public int field_wvCacheType;

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dOq == hashCode) {
                    this.field_urlKey_hashcode = cursor.getInt(i);
                    this.dNT = true;
                } else if (dOr == hashCode) {
                    this.field_urlKey = cursor.getString(i);
                } else if (dnT == hashCode) {
                    this.field_url = cursor.getString(i);
                } else if (dOs == hashCode) {
                    this.field_fileVersion = cursor.getString(i);
                } else if (dMN == hashCode) {
                    this.field_networkType = cursor.getInt(i);
                } else if (dOt == hashCode) {
                    this.field_maxRetryTimes = cursor.getInt(i);
                } else if (dMK == hashCode) {
                    this.field_retryTimes = cursor.getInt(i);
                } else if (dsb == hashCode) {
                    this.field_filePath = cursor.getString(i);
                } else if (diX == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (dOu == hashCode) {
                    this.field_contentLength = cursor.getLong(i);
                } else if (dOv == hashCode) {
                    this.field_contentType = cursor.getString(i);
                } else if (dDp == hashCode) {
                    this.field_expireTime = cursor.getLong(i);
                } else if (dxn == hashCode) {
                    this.field_md5 = cursor.getString(i);
                } else if (dOw == hashCode) {
                    this.field_groupId1 = cursor.getString(i);
                } else if (dOx == hashCode) {
                    this.field_groupId2 = cursor.getString(i);
                } else if (dOy == hashCode) {
                    this.field_priority = cursor.getInt(i);
                } else if (dOz == hashCode) {
                    this.field_fileUpdated = cursor.getInt(i) != 0;
                } else if (dOA == hashCode) {
                    this.field_deleted = cursor.getInt(i) != 0;
                } else if (dOB == hashCode) {
                    this.field_resType = cursor.getInt(i);
                } else if (dkw == hashCode) {
                    this.field_subType = cursor.getInt(i);
                } else if (dmd == hashCode) {
                    this.field_reportId = cursor.getLong(i);
                } else if (dOC == hashCode) {
                    this.field_sampleId = cursor.getString(i);
                } else if (dOD == hashCode) {
                    this.field_eccSignature = cursor.getBlob(i);
                } else if (dOE == hashCode) {
                    this.field_originalMd5 = cursor.getString(i);
                } else if (dOF == hashCode) {
                    this.field_fileCompress = cursor.getInt(i) != 0;
                } else if (dOG == hashCode) {
                    this.field_fileEncrypt = cursor.getInt(i) != 0;
                } else if (dOH == hashCode) {
                    this.field_encryptKey = cursor.getString(i);
                } else if (dOI == hashCode) {
                    this.field_keyVersion = cursor.getInt(i);
                } else if (dOJ == hashCode) {
                    this.field_EID = cursor.getInt(i);
                } else if (dBf == hashCode) {
                    this.field_fileSize = cursor.getLong(i);
                } else if (dOK == hashCode) {
                    this.field_needRetry = cursor.getInt(i) != 0;
                } else if (dkV == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (dOL == hashCode) {
                    this.field_wvCacheType = cursor.getInt(i);
                } else if (dOM == hashCode) {
                    this.field_packageId = cursor.getString(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dNT) {
            contentValues.put("urlKey_hashcode", Integer.valueOf(this.field_urlKey_hashcode));
        }
        if (this.dNU) {
            contentValues.put("urlKey", this.field_urlKey);
        }
        if (this.dnP) {
            contentValues.put("url", this.field_url);
        }
        if (this.dNV) {
            contentValues.put("fileVersion", this.field_fileVersion);
        }
        if (this.dMG) {
            contentValues.put("networkType", Integer.valueOf(this.field_networkType));
        }
        if (this.dNW) {
            contentValues.put("maxRetryTimes", Integer.valueOf(this.field_maxRetryTimes));
        }
        if (this.dMD) {
            contentValues.put("retryTimes", Integer.valueOf(this.field_retryTimes));
        }
        if (this.drT) {
            contentValues.put("filePath", this.field_filePath);
        }
        if (this.diU) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.dNX) {
            contentValues.put("contentLength", Long.valueOf(this.field_contentLength));
        }
        if (this.dNY) {
            contentValues.put(DownloadInfo.CONTENTTYPE, this.field_contentType);
        }
        if (this.dDh) {
            contentValues.put("expireTime", Long.valueOf(this.field_expireTime));
        }
        if (this.dwB) {
            contentValues.put("md5", this.field_md5);
        }
        if (this.dNZ) {
            contentValues.put("groupId1", this.field_groupId1);
        }
        if (this.dOa) {
            contentValues.put("groupId2", this.field_groupId2);
        }
        if (this.dOb) {
            contentValues.put(DownloadInfo.PRIORITY, Integer.valueOf(this.field_priority));
        }
        if (this.dOc) {
            contentValues.put("fileUpdated", Boolean.valueOf(this.field_fileUpdated));
        }
        if (this.dOd) {
            contentValues.put("deleted", Boolean.valueOf(this.field_deleted));
        }
        if (this.dOe) {
            contentValues.put("resType", Integer.valueOf(this.field_resType));
        }
        if (this.djY) {
            contentValues.put("subType", Integer.valueOf(this.field_subType));
        }
        if (this.dma) {
            contentValues.put("reportId", Long.valueOf(this.field_reportId));
        }
        if (this.dOf) {
            contentValues.put("sampleId", this.field_sampleId);
        }
        if (this.dOg) {
            contentValues.put("eccSignature", this.field_eccSignature);
        }
        if (this.dOh) {
            contentValues.put("originalMd5", this.field_originalMd5);
        }
        if (this.dOi) {
            contentValues.put("fileCompress", Boolean.valueOf(this.field_fileCompress));
        }
        if (this.dOj) {
            contentValues.put("fileEncrypt", Boolean.valueOf(this.field_fileEncrypt));
        }
        if (this.dOk) {
            contentValues.put("encryptKey", this.field_encryptKey);
        }
        if (this.dOl) {
            contentValues.put("keyVersion", Integer.valueOf(this.field_keyVersion));
        }
        if (this.dOm) {
            contentValues.put("EID", Integer.valueOf(this.field_EID));
        }
        if (this.dAJ) {
            contentValues.put("fileSize", Long.valueOf(this.field_fileSize));
        }
        if (this.dOn) {
            contentValues.put("needRetry", Boolean.valueOf(this.field_needRetry));
        }
        if (this.dkE) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.dOo) {
            contentValues.put("wvCacheType", Integer.valueOf(this.field_wvCacheType));
        }
        if (this.dOp) {
            contentValues.put("packageId", this.field_packageId);
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
