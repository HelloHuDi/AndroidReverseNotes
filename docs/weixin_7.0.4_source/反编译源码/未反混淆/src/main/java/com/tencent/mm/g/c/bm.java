package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public abstract class bm extends c {
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int djh = "value".hashCode();
    private static final int dzC = "configId".hashCode();
    private boolean diZ = true;
    private boolean dzB = true;
    public int field_configId;
    public String field_value;

    public static a Hm() {
        a aVar = new a();
        aVar.xDb = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "configId";
        aVar.xDd.put("configId", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" configId INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "configId";
        aVar.columns[1] = "value";
        aVar.xDd.put("value", "TEXT");
        stringBuilder.append(" value TEXT");
        aVar.columns[2] = "rowid";
        aVar.sql = stringBuilder.toString();
        return aVar;
    }

    public final void d(Cursor cursor) {
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

    public final ContentValues Hl() {
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
