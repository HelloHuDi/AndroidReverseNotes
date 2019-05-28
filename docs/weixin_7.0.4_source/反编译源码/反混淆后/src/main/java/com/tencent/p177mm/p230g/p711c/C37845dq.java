package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.sdk.p603e.C4925c;

/* renamed from: com.tencent.mm.g.c.dq */
public abstract class C37845dq extends C4925c {
    private static final int dMO = "pkgMd5".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dkV = "appId".hashCode();
    private static final int dki = "type".hashCode();
    private static final int dlS = "version".hashCode();
    private static final int dlV = "pkgPath".hashCode();
    private boolean dMH = true;
    private boolean djK = true;
    private boolean dkE = true;
    private boolean dlM = true;
    private boolean dlP = true;
    public String field_appId;
    public String field_pkgMd5;
    public String field_pkgPath;
    public int field_type;
    public int field_version;

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dkV == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (dlS == hashCode) {
                    this.field_version = cursor.getInt(i);
                } else if (dki == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (dMO == hashCode) {
                    this.field_pkgMd5 = cursor.getString(i);
                } else if (dlV == hashCode) {
                    this.field_pkgPath = cursor.getString(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dkE) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.dlM) {
            contentValues.put("version", Integer.valueOf(this.field_version));
        }
        if (this.djK) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.dMH) {
            contentValues.put("pkgMd5", this.field_pkgMd5);
        }
        if (this.dlP) {
            contentValues.put("pkgPath", this.field_pkgPath);
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
