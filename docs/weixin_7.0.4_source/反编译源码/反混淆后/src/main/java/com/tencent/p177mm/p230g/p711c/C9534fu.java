package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.sdk.p603e.C4925c;

/* renamed from: com.tencent.mm.g.c.fu */
public abstract class C9534fu extends C4925c {
    private static final int dZB = "msgSubType".hashCode();
    private static final int dZC = "msgtime".hashCode();
    public static final String[] diI = new String[0];
    private static final int diQ = "msgId".hashCode();
    private static final int diR = "rowid".hashCode();
    private static final int dlB = "size".hashCode();
    private static final int dlo = "username".hashCode();
    private static final int dlv = "path".hashCode();
    private static final int dow = "msgType".hashCode();
    private boolean dZA = true;
    private boolean dZz = true;
    private boolean diM = true;
    private boolean dlm = true;
    private boolean dlr = true;
    private boolean dlz = true;
    private boolean doi = true;
    public long field_msgId;
    public int field_msgSubType;
    public int field_msgType;
    public long field_msgtime;
    public String field_path;
    public long field_size;
    public String field_username;

    /* renamed from: d */
    public void mo8995d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (diQ == hashCode) {
                    this.field_msgId = cursor.getLong(i);
                } else if (dlo == hashCode) {
                    this.field_username = cursor.getString(i);
                } else if (dow == hashCode) {
                    this.field_msgType = cursor.getInt(i);
                } else if (dZB == hashCode) {
                    this.field_msgSubType = cursor.getInt(i);
                } else if (dlv == hashCode) {
                    this.field_path = cursor.getString(i);
                } else if (dlB == hashCode) {
                    this.field_size = cursor.getLong(i);
                } else if (dZC == hashCode) {
                    this.field_msgtime = cursor.getLong(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.diM) {
            contentValues.put("msgId", Long.valueOf(this.field_msgId));
        }
        if (this.dlm) {
            contentValues.put("username", this.field_username);
        }
        if (this.doi) {
            contentValues.put("msgType", Integer.valueOf(this.field_msgType));
        }
        if (this.dZz) {
            contentValues.put("msgSubType", Integer.valueOf(this.field_msgSubType));
        }
        if (this.dlr) {
            contentValues.put("path", this.field_path);
        }
        if (this.dlz) {
            contentValues.put("size", Long.valueOf(this.field_size));
        }
        if (this.dZA) {
            contentValues.put("msgtime", Long.valueOf(this.field_msgtime));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
