package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class q extends c {
    public static final String[] diI = new String[]{"CREATE INDEX IF NOT EXISTS AppBrandWxaPkgManifestRecordPkgPathIndex ON AppBrandWxaPkgManifestRecord(pkgPath)"};
    private static final int diR = "rowid".hashCode();
    private static final int djl = "startTime".hashCode();
    private static final int djm = "endTime".hashCode();
    private static final int dkV = "appId".hashCode();
    private static final int dkf = "createTime".hashCode();
    private static final int dlS = "version".hashCode();
    private static final int dlT = "versionMd5".hashCode();
    private static final int dlU = "versionState".hashCode();
    private static final int dlV = "pkgPath".hashCode();
    private static final int dlW = "debugType".hashCode();
    private static final int dlX = "downloadURL".hashCode();
    private boolean djH = true;
    private boolean djd = true;
    private boolean dje = true;
    private boolean dkE = true;
    private boolean dlM = true;
    private boolean dlN = true;
    private boolean dlO = true;
    private boolean dlP = true;
    private boolean dlQ = true;
    private boolean dlR = true;
    public String field_appId;
    public long field_createTime;
    public int field_debugType;
    public String field_downloadURL;
    public long field_endTime;
    public String field_pkgPath;
    public long field_startTime;
    public int field_version;
    public String field_versionMd5;
    public int field_versionState;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dkV == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (dlS == hashCode) {
                    this.field_version = cursor.getInt(i);
                } else if (dlT == hashCode) {
                    this.field_versionMd5 = cursor.getString(i);
                } else if (dlU == hashCode) {
                    this.field_versionState = cursor.getInt(i);
                } else if (dlV == hashCode) {
                    this.field_pkgPath = cursor.getString(i);
                } else if (dkf == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (dlW == hashCode) {
                    this.field_debugType = cursor.getInt(i);
                } else if (dlX == hashCode) {
                    this.field_downloadURL = cursor.getString(i);
                } else if (djl == hashCode) {
                    this.field_startTime = cursor.getLong(i);
                } else if (djm == hashCode) {
                    this.field_endTime = cursor.getLong(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dkE) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.dlM) {
            contentValues.put("version", Integer.valueOf(this.field_version));
        }
        if (this.dlN) {
            contentValues.put("versionMd5", this.field_versionMd5);
        }
        if (this.dlO) {
            contentValues.put("versionState", Integer.valueOf(this.field_versionState));
        }
        if (this.dlP) {
            contentValues.put("pkgPath", this.field_pkgPath);
        }
        if (this.djH) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.dlQ) {
            contentValues.put("debugType", Integer.valueOf(this.field_debugType));
        }
        if (this.dlR) {
            contentValues.put("downloadURL", this.field_downloadURL);
        }
        if (this.djd) {
            contentValues.put("startTime", Long.valueOf(this.field_startTime));
        }
        if (this.dje) {
            contentValues.put("endTime", Long.valueOf(this.field_endTime));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
