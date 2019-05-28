package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public abstract class et extends c {
    private static final int dBn = "totalSize".hashCode();
    private static final int dSf = "storyId".hashCode();
    private static final int dTg = "cacheSize".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dnT = "url".hashCode();
    private static final int dsb = "filePath".hashCode();
    private boolean dAR = true;
    private boolean dRZ = true;
    private boolean dTf = true;
    private boolean dnP = true;
    private boolean drT = true;
    public int field_cacheSize;
    public String field_filePath;
    public long field_storyId;
    public int field_totalSize;
    public String field_url;

    public static a Hm() {
        a aVar = new a();
        aVar.xDb = new Field[5];
        aVar.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "storyId";
        aVar.xDd.put("storyId", "LONG PRIMARY KEY ");
        stringBuilder.append(" storyId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "storyId";
        aVar.columns[1] = "url";
        aVar.xDd.put("url", "TEXT");
        stringBuilder.append(" url TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "filePath";
        aVar.xDd.put("filePath", "TEXT");
        stringBuilder.append(" filePath TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "totalSize";
        aVar.xDd.put("totalSize", "INTEGER");
        stringBuilder.append(" totalSize INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "cacheSize";
        aVar.xDd.put("cacheSize", "INTEGER");
        stringBuilder.append(" cacheSize INTEGER");
        aVar.columns[5] = "rowid";
        aVar.sql = stringBuilder.toString();
        return aVar;
    }

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dSf == hashCode) {
                    this.field_storyId = cursor.getLong(i);
                    this.dRZ = true;
                } else if (dnT == hashCode) {
                    this.field_url = cursor.getString(i);
                } else if (dsb == hashCode) {
                    this.field_filePath = cursor.getString(i);
                } else if (dBn == hashCode) {
                    this.field_totalSize = cursor.getInt(i);
                } else if (dTg == hashCode) {
                    this.field_cacheSize = cursor.getInt(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dRZ) {
            contentValues.put("storyId", Long.valueOf(this.field_storyId));
        }
        if (this.dnP) {
            contentValues.put("url", this.field_url);
        }
        if (this.drT) {
            contentValues.put("filePath", this.field_filePath);
        }
        if (this.dAR) {
            contentValues.put("totalSize", Integer.valueOf(this.field_totalSize));
        }
        if (this.dTf) {
            contentValues.put("cacheSize", Integer.valueOf(this.field_cacheSize));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
