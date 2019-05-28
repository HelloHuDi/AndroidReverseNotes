package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dt extends c {
    private static final int dMO = "pkgMd5".hashCode();
    private static final int dNA = "decryptKey".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dkV = "appId".hashCode();
    private static final int dmF = "appVersion".hashCode();
    private static final int dmd = "reportId".hashCode();
    private boolean dMH = true;
    private boolean dNz = true;
    private boolean dkE = true;
    private boolean dma = true;
    private boolean dmi = true;
    public String field_appId;
    public int field_appVersion;
    public String field_decryptKey;
    public String field_pkgMd5;
    public int field_reportId;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dkV == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (dmF == hashCode) {
                    this.field_appVersion = cursor.getInt(i);
                } else if (dNA == hashCode) {
                    this.field_decryptKey = cursor.getString(i);
                } else if (dMO == hashCode) {
                    this.field_pkgMd5 = cursor.getString(i);
                } else if (dmd == hashCode) {
                    this.field_reportId = cursor.getInt(i);
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
        if (this.dmi) {
            contentValues.put("appVersion", Integer.valueOf(this.field_appVersion));
        }
        if (this.dNz) {
            contentValues.put("decryptKey", this.field_decryptKey);
        }
        if (this.dMH) {
            contentValues.put("pkgMd5", this.field_pkgMd5);
        }
        if (this.dma) {
            contentValues.put("reportId", Integer.valueOf(this.field_reportId));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
