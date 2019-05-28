package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.sdk.p603e.C4925c;

/* renamed from: com.tencent.mm.g.c.ch */
public abstract class C45391ch extends C4925c {
    private static final int dFE = "step".hashCode();
    private static final int dFy = "rankID".hashCode();
    private static final int dFz = "appusername".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dlo = "username".hashCode();
    private static final int dwo = "sort".hashCode();
    private boolean dFD = true;
    private boolean dFv = true;
    private boolean dFw = true;
    private boolean dlm = true;
    private boolean dvO = true;
    public String field_appusername;
    public String field_rankID;
    public int field_sort;
    public int field_step;
    public String field_username;

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dFz == hashCode) {
                    this.field_appusername = cursor.getString(i);
                } else if (dFy == hashCode) {
                    this.field_rankID = cursor.getString(i);
                } else if (dlo == hashCode) {
                    this.field_username = cursor.getString(i);
                } else if (dFE == hashCode) {
                    this.field_step = cursor.getInt(i);
                } else if (dwo == hashCode) {
                    this.field_sort = cursor.getInt(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dFw) {
            contentValues.put("appusername", this.field_appusername);
        }
        if (this.dFv) {
            contentValues.put("rankID", this.field_rankID);
        }
        if (this.dlm) {
            contentValues.put("username", this.field_username);
        }
        if (this.dFD) {
            contentValues.put("step", Integer.valueOf(this.field_step));
        }
        if (this.dvO) {
            contentValues.put("sort", Integer.valueOf(this.field_sort));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
