package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fr extends c {
    private static final int dXW = "pkgId".hashCode();
    private static final int dYQ = "rid".hashCode();
    private static final int dYR = "mimeType".hashCode();
    private static final int dYS = "completeDownload".hashCode();
    private static final int dYT = "autoDownloadCount".hashCode();
    private static final int dYU = "fileDownloadCount".hashCode();
    private static final int dYa = "downloadNetType".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int djA = "key".hashCode();
    private static final int dkf = "createTime".hashCode();
    private static final int dlB = "size".hashCode();
    private static final int dlS = "version".hashCode();
    private static final int drZ = "downloadUrl".hashCode();
    private static final int dsb = "filePath".hashCode();
    private static final int dxn = "md5".hashCode();
    private boolean dXR = true;
    private boolean dXV = true;
    private boolean dYL = true;
    private boolean dYM = true;
    private boolean dYN = true;
    private boolean dYO = true;
    private boolean dYP = true;
    private boolean djH = true;
    private boolean djw = true;
    private boolean dlM = true;
    private boolean dlz = true;
    private boolean drR = true;
    private boolean drT = true;
    private boolean dwB = true;
    public int field_autoDownloadCount;
    public boolean field_completeDownload;
    public long field_createTime;
    public int field_downloadNetType;
    public String field_downloadUrl;
    public int field_fileDownloadCount;
    public String field_filePath;
    public String field_key;
    public String field_md5;
    public String field_mimeType;
    public String field_pkgId;
    public String field_rid;
    public int field_size;
    public String field_version;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (djA == hashCode) {
                    this.field_key = cursor.getString(i);
                    this.djw = true;
                } else if (dXW == hashCode) {
                    this.field_pkgId = cursor.getString(i);
                } else if (dlS == hashCode) {
                    this.field_version = cursor.getString(i);
                } else if (dsb == hashCode) {
                    this.field_filePath = cursor.getString(i);
                } else if (dYQ == hashCode) {
                    this.field_rid = cursor.getString(i);
                } else if (dYR == hashCode) {
                    this.field_mimeType = cursor.getString(i);
                } else if (dxn == hashCode) {
                    this.field_md5 = cursor.getString(i);
                } else if (drZ == hashCode) {
                    this.field_downloadUrl = cursor.getString(i);
                } else if (dlB == hashCode) {
                    this.field_size = cursor.getInt(i);
                } else if (dYa == hashCode) {
                    this.field_downloadNetType = cursor.getInt(i);
                } else if (dYS == hashCode) {
                    this.field_completeDownload = cursor.getInt(i) != 0;
                } else if (dkf == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (dYT == hashCode) {
                    this.field_autoDownloadCount = cursor.getInt(i);
                } else if (dYU == hashCode) {
                    this.field_fileDownloadCount = cursor.getInt(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.djw) {
            contentValues.put("key", this.field_key);
        }
        if (this.dXR) {
            contentValues.put("pkgId", this.field_pkgId);
        }
        if (this.dlM) {
            contentValues.put("version", this.field_version);
        }
        if (this.drT) {
            contentValues.put("filePath", this.field_filePath);
        }
        if (this.dYL) {
            contentValues.put("rid", this.field_rid);
        }
        if (this.dYM) {
            contentValues.put("mimeType", this.field_mimeType);
        }
        if (this.dwB) {
            contentValues.put("md5", this.field_md5);
        }
        if (this.drR) {
            contentValues.put("downloadUrl", this.field_downloadUrl);
        }
        if (this.dlz) {
            contentValues.put("size", Integer.valueOf(this.field_size));
        }
        if (this.dXV) {
            contentValues.put("downloadNetType", Integer.valueOf(this.field_downloadNetType));
        }
        if (this.dYN) {
            contentValues.put("completeDownload", Boolean.valueOf(this.field_completeDownload));
        }
        if (this.djH) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.dYO) {
            contentValues.put("autoDownloadCount", Integer.valueOf(this.field_autoDownloadCount));
        }
        if (this.dYP) {
            contentValues.put("fileDownloadCount", Integer.valueOf(this.field_fileDownloadCount));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
