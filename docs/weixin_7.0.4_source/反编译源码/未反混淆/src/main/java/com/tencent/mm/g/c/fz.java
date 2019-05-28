package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fz extends c {
    private static final int dBM = "UserName".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dkf = "createTime".hashCode();
    private static final int dlW = "debugType".hashCode();
    private static final int eat = "RecordId".hashCode();
    private static final int eau = "AppId".hashCode();
    private static final int eav = "AppName".hashCode();
    private static final int eaw = "IconUrl".hashCode();
    private static final int eax = "BriefIntro".hashCode();
    private static final int eay = "isSync".hashCode();
    private boolean dBE = true;
    private boolean djH = true;
    private boolean dlQ = true;
    private boolean ean = true;
    private boolean eao = true;
    private boolean eap = true;
    private boolean eaq = true;
    private boolean ear = true;
    private boolean eas = true;
    public String field_AppId;
    public String field_AppName;
    public String field_BriefIntro;
    public String field_IconUrl;
    public String field_RecordId;
    public String field_UserName;
    public long field_createTime;
    public int field_debugType;
    public boolean field_isSync;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (eat == hashCode) {
                    this.field_RecordId = cursor.getString(i);
                    this.ean = true;
                } else if (eau == hashCode) {
                    this.field_AppId = cursor.getString(i);
                } else if (eav == hashCode) {
                    this.field_AppName = cursor.getString(i);
                } else if (dBM == hashCode) {
                    this.field_UserName = cursor.getString(i);
                } else if (eaw == hashCode) {
                    this.field_IconUrl = cursor.getString(i);
                } else if (eax == hashCode) {
                    this.field_BriefIntro = cursor.getString(i);
                } else if (eay == hashCode) {
                    this.field_isSync = cursor.getInt(i) != 0;
                } else if (dlW == hashCode) {
                    this.field_debugType = cursor.getInt(i);
                } else if (dkf == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.ean) {
            contentValues.put("RecordId", this.field_RecordId);
        }
        if (this.eao) {
            contentValues.put("AppId", this.field_AppId);
        }
        if (this.eap) {
            contentValues.put("AppName", this.field_AppName);
        }
        if (this.dBE) {
            contentValues.put("UserName", this.field_UserName);
        }
        if (this.eaq) {
            contentValues.put("IconUrl", this.field_IconUrl);
        }
        if (this.ear) {
            contentValues.put("BriefIntro", this.field_BriefIntro);
        }
        if (this.eas) {
            contentValues.put("isSync", Boolean.valueOf(this.field_isSync));
        }
        if (this.dlQ) {
            contentValues.put("debugType", Integer.valueOf(this.field_debugType));
        }
        if (this.djH) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
