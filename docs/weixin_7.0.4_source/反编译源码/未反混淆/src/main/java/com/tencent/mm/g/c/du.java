package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class du extends c {
    private static final int dAb = "toUser".hashCode();
    private static final int dBh = "fileType".hashCode();
    private static final int dBq = "errCode".hashCode();
    private static final int dNF = "recordLocalId".hashCode();
    private static final int dNG = "isThumb".hashCode();
    private static final int dNH = "tpaeskey".hashCode();
    private static final int dNI = "tpdataurl".hashCode();
    public static final String[] diI = new String[]{"CREATE INDEX IF NOT EXISTS record_localid_index ON RecordCDNInfo(recordLocalId)"};
    private static final int diR = "rowid".hashCode();
    private static final int diX = "status".hashCode();
    private static final int dkY = "mediaId".hashCode();
    private static final int dki = "type".hashCode();
    private static final int dla = "totalLen".hashCode();
    private static final int dlb = "offset".hashCode();
    private static final int dlv = "path".hashCode();
    private static final int dxE = "cdnUrl".hashCode();
    private static final int dxN = "tpauthkey".hashCode();
    private static final int dzF = "localId".hashCode();
    private static final int dzw = "dataId".hashCode();
    private static final int dzy = "cdnKey".hashCode();
    private boolean dAL = true;
    private boolean dAU = true;
    private boolean dNB = true;
    private boolean dNC = true;
    private boolean dND = true;
    private boolean dNE = true;
    private boolean diU = true;
    private boolean djK = true;
    private boolean dkH = true;
    private boolean dkJ = true;
    private boolean dkK = true;
    private boolean dlr = true;
    private boolean dwS = true;
    private boolean dxb = true;
    private boolean dzD = true;
    private boolean dzN = true;
    private boolean dzr = true;
    private boolean dzt = true;
    public String field_cdnKey;
    public String field_cdnUrl;
    public String field_dataId;
    public int field_errCode;
    public int field_fileType;
    public boolean field_isThumb;
    public int field_localId;
    public String field_mediaId;
    public int field_offset;
    public String field_path;
    public int field_recordLocalId;
    public int field_status;
    public String field_toUser;
    public int field_totalLen;
    public String field_tpaeskey;
    public String field_tpauthkey;
    public String field_tpdataurl;
    public int field_type;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dzF == hashCode) {
                    this.field_localId = cursor.getInt(i);
                    this.dzD = true;
                } else if (dNF == hashCode) {
                    this.field_recordLocalId = cursor.getInt(i);
                } else if (dAb == hashCode) {
                    this.field_toUser = cursor.getString(i);
                } else if (dzw == hashCode) {
                    this.field_dataId = cursor.getString(i);
                } else if (dkY == hashCode) {
                    this.field_mediaId = cursor.getString(i);
                } else if (dlv == hashCode) {
                    this.field_path = cursor.getString(i);
                } else if (dxE == hashCode) {
                    this.field_cdnUrl = cursor.getString(i);
                } else if (dzy == hashCode) {
                    this.field_cdnKey = cursor.getString(i);
                } else if (dla == hashCode) {
                    this.field_totalLen = cursor.getInt(i);
                } else if (dNG == hashCode) {
                    this.field_isThumb = cursor.getInt(i) != 0;
                } else if (dlb == hashCode) {
                    this.field_offset = cursor.getInt(i);
                } else if (dki == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (dBh == hashCode) {
                    this.field_fileType = cursor.getInt(i);
                } else if (diX == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (dBq == hashCode) {
                    this.field_errCode = cursor.getInt(i);
                } else if (dNH == hashCode) {
                    this.field_tpaeskey = cursor.getString(i);
                } else if (dxN == hashCode) {
                    this.field_tpauthkey = cursor.getString(i);
                } else if (dNI == hashCode) {
                    this.field_tpdataurl = cursor.getString(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dzD) {
            contentValues.put("localId", Integer.valueOf(this.field_localId));
        }
        if (this.dNB) {
            contentValues.put("recordLocalId", Integer.valueOf(this.field_recordLocalId));
        }
        if (this.field_toUser == null) {
            this.field_toUser = "";
        }
        if (this.dzN) {
            contentValues.put("toUser", this.field_toUser);
        }
        if (this.dzr) {
            contentValues.put("dataId", this.field_dataId);
        }
        if (this.dkH) {
            contentValues.put("mediaId", this.field_mediaId);
        }
        if (this.dlr) {
            contentValues.put("path", this.field_path);
        }
        if (this.dwS) {
            contentValues.put("cdnUrl", this.field_cdnUrl);
        }
        if (this.dzt) {
            contentValues.put("cdnKey", this.field_cdnKey);
        }
        if (this.dkJ) {
            contentValues.put("totalLen", Integer.valueOf(this.field_totalLen));
        }
        if (this.dNC) {
            contentValues.put("isThumb", Boolean.valueOf(this.field_isThumb));
        }
        if (this.dkK) {
            contentValues.put("offset", Integer.valueOf(this.field_offset));
        }
        if (this.djK) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.dAL) {
            contentValues.put("fileType", Integer.valueOf(this.field_fileType));
        }
        if (this.diU) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.dAU) {
            contentValues.put("errCode", Integer.valueOf(this.field_errCode));
        }
        if (this.dND) {
            contentValues.put("tpaeskey", this.field_tpaeskey);
        }
        if (this.dxb) {
            contentValues.put("tpauthkey", this.field_tpauthkey);
        }
        if (this.dNE) {
            contentValues.put("tpdataurl", this.field_tpdataurl);
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
