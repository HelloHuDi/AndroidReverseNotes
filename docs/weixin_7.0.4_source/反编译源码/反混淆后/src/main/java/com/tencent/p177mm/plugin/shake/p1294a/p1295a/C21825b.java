package com.tencent.p177mm.plugin.shake.p1294a.p1295a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.sdk.p603e.C4925c;

/* renamed from: com.tencent.mm.plugin.shake.a.a.b */
public abstract class C21825b extends C4925c {
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dlo = "username".hashCode();
    private static final int qrx = "lastshaketime".hashCode();
    private static final int qry = "isshowed".hashCode();
    private boolean dlm;
    public boolean field_isshowed;
    public int field_lastshaketime;
    public String field_username;
    private boolean qrv;
    private boolean qrw;

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dlo == hashCode) {
                    this.field_username = cursor.getString(i);
                    this.dlm = true;
                } else if (qrx == hashCode) {
                    this.field_lastshaketime = cursor.getInt(i);
                } else if (qry == hashCode) {
                    this.field_isshowed = cursor.getInt(i) != 0;
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.field_username == null) {
            this.field_username = "";
        }
        if (this.dlm) {
            contentValues.put("username", this.field_username);
        }
        if (this.qrv) {
            contentValues.put("lastshaketime", Integer.valueOf(this.field_lastshaketime));
        }
        if (this.qrw) {
            contentValues.put("isshowed", Boolean.valueOf(this.field_isshowed));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
