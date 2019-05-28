package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class h extends c {
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int diX = "status".hashCode();
    private static final int dkV = "appId".hashCode();
    private static final int dkW = "sdkVer".hashCode();
    private static final int dkX = "mediaSvrId".hashCode();
    private static final int dkY = "mediaId".hashCode();
    private static final int dkZ = "clientAppDataId".hashCode();
    private static final int dkf = "createTime".hashCode();
    private static final int dki = "type".hashCode();
    private static final int dla = "totalLen".hashCode();
    private static final int dlb = "offset".hashCode();
    private static final int dlc = "isUpload".hashCode();
    private static final int dld = "lastModifyTime".hashCode();
    private static final int dle = "fileFullPath".hashCode();
    private static final int dlf = "fullXml".hashCode();
    private static final int dlg = "msgInfoId".hashCode();
    private static final int dlh = "netTimes".hashCode();
    private static final int dli = "isUseCdn".hashCode();
    private static final int dlj = "signature".hashCode();
    private static final int dlk = "fakeAeskey".hashCode();
    private static final int dll = "fakeSignature".hashCode();
    private boolean diU = true;
    private boolean djH = true;
    private boolean djK = true;
    private boolean dkE = true;
    private boolean dkF = true;
    private boolean dkG = true;
    private boolean dkH = true;
    private boolean dkI = true;
    private boolean dkJ = true;
    private boolean dkK = true;
    private boolean dkL = true;
    private boolean dkM = true;
    private boolean dkN = true;
    private boolean dkO = true;
    private boolean dkP = true;
    private boolean dkQ = true;
    private boolean dkR = true;
    private boolean dkS = true;
    private boolean dkT = true;
    private boolean dkU = true;
    public String field_appId;
    public String field_clientAppDataId;
    public long field_createTime;
    public String field_fakeAeskey;
    public String field_fakeSignature;
    public String field_fileFullPath;
    public String field_fullXml;
    public boolean field_isUpload;
    public int field_isUseCdn;
    public long field_lastModifyTime;
    public String field_mediaId;
    public String field_mediaSvrId;
    public long field_msgInfoId;
    public long field_netTimes;
    public long field_offset;
    public long field_sdkVer;
    public String field_signature;
    public long field_status;
    public long field_totalLen;
    public long field_type;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dkV == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (dkW == hashCode) {
                    this.field_sdkVer = cursor.getLong(i);
                } else if (dkX == hashCode) {
                    this.field_mediaSvrId = cursor.getString(i);
                } else if (dkY == hashCode) {
                    this.field_mediaId = cursor.getString(i);
                } else if (dkZ == hashCode) {
                    this.field_clientAppDataId = cursor.getString(i);
                } else if (dki == hashCode) {
                    this.field_type = cursor.getLong(i);
                } else if (dla == hashCode) {
                    this.field_totalLen = cursor.getLong(i);
                } else if (dlb == hashCode) {
                    this.field_offset = cursor.getLong(i);
                } else if (diX == hashCode) {
                    this.field_status = cursor.getLong(i);
                } else if (dlc == hashCode) {
                    this.field_isUpload = cursor.getInt(i) != 0;
                } else if (dkf == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (dld == hashCode) {
                    this.field_lastModifyTime = cursor.getLong(i);
                } else if (dle == hashCode) {
                    this.field_fileFullPath = cursor.getString(i);
                } else if (dlf == hashCode) {
                    this.field_fullXml = cursor.getString(i);
                } else if (dlg == hashCode) {
                    this.field_msgInfoId = cursor.getLong(i);
                } else if (dlh == hashCode) {
                    this.field_netTimes = cursor.getLong(i);
                } else if (dli == hashCode) {
                    this.field_isUseCdn = cursor.getInt(i);
                } else if (dlj == hashCode) {
                    this.field_signature = cursor.getString(i);
                } else if (dlk == hashCode) {
                    this.field_fakeAeskey = cursor.getString(i);
                } else if (dll == hashCode) {
                    this.field_fakeSignature = cursor.getString(i);
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
        if (this.dkF) {
            contentValues.put("sdkVer", Long.valueOf(this.field_sdkVer));
        }
        if (this.dkG) {
            contentValues.put("mediaSvrId", this.field_mediaSvrId);
        }
        if (this.dkH) {
            contentValues.put("mediaId", this.field_mediaId);
        }
        if (this.dkI) {
            contentValues.put("clientAppDataId", this.field_clientAppDataId);
        }
        if (this.djK) {
            contentValues.put("type", Long.valueOf(this.field_type));
        }
        if (this.dkJ) {
            contentValues.put("totalLen", Long.valueOf(this.field_totalLen));
        }
        if (this.dkK) {
            contentValues.put("offset", Long.valueOf(this.field_offset));
        }
        if (this.diU) {
            contentValues.put("status", Long.valueOf(this.field_status));
        }
        if (this.dkL) {
            contentValues.put("isUpload", Boolean.valueOf(this.field_isUpload));
        }
        if (this.djH) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.dkM) {
            contentValues.put("lastModifyTime", Long.valueOf(this.field_lastModifyTime));
        }
        if (this.dkN) {
            contentValues.put("fileFullPath", this.field_fileFullPath);
        }
        if (this.dkO) {
            contentValues.put("fullXml", this.field_fullXml);
        }
        if (this.dkP) {
            contentValues.put("msgInfoId", Long.valueOf(this.field_msgInfoId));
        }
        if (this.dkQ) {
            contentValues.put("netTimes", Long.valueOf(this.field_netTimes));
        }
        if (this.dkR) {
            contentValues.put("isUseCdn", Integer.valueOf(this.field_isUseCdn));
        }
        if (this.dkS) {
            contentValues.put("signature", this.field_signature);
        }
        if (this.dkT) {
            contentValues.put("fakeAeskey", this.field_fakeAeskey);
        }
        if (this.dkU) {
            contentValues.put("fakeSignature", this.field_fakeSignature);
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
