package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public abstract class fk extends c {
    private static final int dYc = "occupation".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dkV = "appId".hashCode();
    private boolean dYb = true;
    private boolean dkE = true;
    public String field_appId;
    public long field_occupation;

    public static a Hm() {
        a aVar = new a();
        aVar.xDb = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appId";
        aVar.xDd.put("appId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" appId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "appId";
        aVar.columns[1] = "occupation";
        aVar.xDd.put("occupation", "LONG");
        stringBuilder.append(" occupation LONG");
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
                if (dkV == hashCode) {
                    this.field_appId = cursor.getString(i);
                    this.dkE = true;
                } else if (dYc == hashCode) {
                    this.field_occupation = cursor.getLong(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dkE) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.dYb) {
            contentValues.put("occupation", Long.valueOf(this.field_occupation));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
