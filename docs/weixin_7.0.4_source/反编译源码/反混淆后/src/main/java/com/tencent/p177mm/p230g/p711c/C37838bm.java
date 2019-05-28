package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.g.c.bm */
public abstract class C37838bm extends C4925c {
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int djh = "value".hashCode();
    private static final int dzC = "configId".hashCode();
    private boolean diZ = true;
    private boolean dzB = true;
    public int field_configId;
    public String field_value;

    /* renamed from: Hm */
    public static C4924a m63818Hm() {
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[2];
        c4924a.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "configId";
        c4924a.xDd.put("configId", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" configId INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "configId";
        c4924a.columns[1] = "value";
        c4924a.xDd.put("value", "TEXT");
        stringBuilder.append(" value TEXT");
        c4924a.columns[2] = "rowid";
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
                if (dzC == hashCode) {
                    this.field_configId = cursor.getInt(i);
                    this.dzB = true;
                } else if (djh == hashCode) {
                    this.field_value = cursor.getString(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dzB) {
            contentValues.put("configId", Integer.valueOf(this.field_configId));
        }
        if (this.diZ) {
            contentValues.put("value", this.field_value);
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
