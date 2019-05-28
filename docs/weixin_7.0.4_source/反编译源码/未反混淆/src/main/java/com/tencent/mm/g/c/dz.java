package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dz extends c {
    private static final int dGw = "createtime".hashCode();
    private static final int dPb = "uid".hashCode();
    private static final int dPc = "devicetype".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dxs = "name".hashCode();
    private boolean dGr = true;
    private boolean dOZ = true;
    private boolean dPa = true;
    private boolean dwG = true;
    public long field_createtime;
    public String field_devicetype;
    public String field_name;
    public String field_uid;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dPb == hashCode) {
                    this.field_uid = cursor.getString(i);
                    this.dOZ = true;
                } else if (dxs == hashCode) {
                    this.field_name = cursor.getString(i);
                } else if (dPc == hashCode) {
                    this.field_devicetype = cursor.getString(i);
                } else if (dGw == hashCode) {
                    this.field_createtime = cursor.getLong(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.field_uid == null) {
            this.field_uid = "";
        }
        if (this.dOZ) {
            contentValues.put("uid", this.field_uid);
        }
        if (this.field_name == null) {
            this.field_name = "";
        }
        if (this.dwG) {
            contentValues.put("name", this.field_name);
        }
        if (this.field_devicetype == null) {
            this.field_devicetype = "";
        }
        if (this.dPa) {
            contentValues.put("devicetype", this.field_devicetype);
        }
        if (this.dGr) {
            contentValues.put("createtime", Long.valueOf(this.field_createtime));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
