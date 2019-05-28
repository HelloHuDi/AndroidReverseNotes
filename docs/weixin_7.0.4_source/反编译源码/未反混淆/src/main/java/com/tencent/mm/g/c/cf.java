package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.tencent.mm.sdk.e.c;

public abstract class cf extends c {
    private static final int dAG = Param.TIMESTAMP.hashCode();
    private static final int dFA = "liketips".hashCode();
    private static final int dFy = "rankID".hashCode();
    private static final int dFz = "appusername".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dlo = "username".hashCode();
    private boolean dAw = true;
    private boolean dFv = true;
    private boolean dFw = true;
    private boolean dFx = true;
    private boolean dlm = true;
    public String field_appusername;
    public String field_liketips;
    public String field_rankID;
    public int field_timestamp;
    public String field_username;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dFy == hashCode) {
                    this.field_rankID = cursor.getString(i);
                } else if (dFz == hashCode) {
                    this.field_appusername = cursor.getString(i);
                } else if (dlo == hashCode) {
                    this.field_username = cursor.getString(i);
                } else if (dAG == hashCode) {
                    this.field_timestamp = cursor.getInt(i);
                } else if (dFA == hashCode) {
                    this.field_liketips = cursor.getString(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dFv) {
            contentValues.put("rankID", this.field_rankID);
        }
        if (this.dFw) {
            contentValues.put("appusername", this.field_appusername);
        }
        if (this.dlm) {
            contentValues.put("username", this.field_username);
        }
        if (this.dAw) {
            contentValues.put(Param.TIMESTAMP, Integer.valueOf(this.field_timestamp));
        }
        if (this.field_liketips == null) {
            this.field_liketips = "";
        }
        if (this.dFx) {
            contentValues.put("liketips", this.field_liketips);
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
