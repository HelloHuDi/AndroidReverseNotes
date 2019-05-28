package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.g.c.g */
public abstract class C37854g extends C4925c {
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dkC = "scene".hashCode();
    private static final int dkD = "ticket".hashCode();
    private static final int dkd = "userName".hashCode();
    private boolean djF = true;
    private boolean dkA = true;
    private boolean dkB = true;
    public int field_scene;
    public String field_ticket;
    public String field_userName;

    /* renamed from: Hm */
    public static C4924a m63864Hm() {
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[3];
        c4924a.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "userName";
        c4924a.xDd.put("userName", "TEXT");
        stringBuilder.append(" userName TEXT");
        stringBuilder.append(", ");
        c4924a.columns[1] = "scene";
        c4924a.xDd.put("scene", "INTEGER");
        stringBuilder.append(" scene INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[2] = "ticket";
        c4924a.xDd.put("ticket", "TEXT");
        stringBuilder.append(" ticket TEXT");
        c4924a.columns[3] = "rowid";
        c4924a.sql = stringBuilder.toString();
        return c4924a;
    }

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dkd == hashCode) {
                    this.field_userName = cursor.getString(i);
                } else if (dkC == hashCode) {
                    this.field_scene = cursor.getInt(i);
                } else if (dkD == hashCode) {
                    this.field_ticket = cursor.getString(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.djF) {
            contentValues.put("userName", this.field_userName);
        }
        if (this.dkA) {
            contentValues.put("scene", Integer.valueOf(this.field_scene));
        }
        if (this.dkB) {
            contentValues.put("ticket", this.field_ticket);
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
