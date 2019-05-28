package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.sdk.p603e.C4925c;

/* renamed from: com.tencent.mm.g.c.dm */
public abstract class C18470dm extends C4925c {
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int djA = "key".hashCode();
    private static final int dkC = "scene".hashCode();
    private static final int dlS = "version".hashCode();
    private static final int dlp = "updateTime".hashCode();
    private boolean djw = true;
    private boolean dkA = true;
    private boolean dlM = true;
    private boolean dln = true;
    public String field_key;
    public int field_scene;
    public long field_updateTime;
    public int field_version;

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (djA == hashCode) {
                    this.field_key = cursor.getString(i);
                } else if (dlS == hashCode) {
                    this.field_version = cursor.getInt(i);
                } else if (dkC == hashCode) {
                    this.field_scene = cursor.getInt(i);
                } else if (dlp == hashCode) {
                    this.field_updateTime = cursor.getLong(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.djw) {
            contentValues.put("key", this.field_key);
        }
        if (this.dlM) {
            contentValues.put("version", Integer.valueOf(this.field_version));
        }
        if (this.dkA) {
            contentValues.put("scene", Integer.valueOf(this.field_scene));
        }
        if (this.dln) {
            contentValues.put("updateTime", Long.valueOf(this.field_updateTime));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
