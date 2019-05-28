package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public abstract class bp extends c {
    private static final int dAl = "tagContent".hashCode();
    private static final int dAm = "subtype".hashCode();
    public static final String[] diI = new String[]{"CREATE INDEX IF NOT EXISTS FavSearchInfo_Content_Index ON FavSearchInfo(content)", "CREATE INDEX IF NOT EXISTS FavSearchInfo_TagContent_Index ON FavSearchInfo(tagContent)", "CREATE INDEX IF NOT EXISTS FavSearchInfo_SubType_Index ON FavSearchInfo(subtype)"};
    private static final int diR = "rowid".hashCode();
    private static final int dki = "type".hashCode();
    private static final int dkn = b.CONTENT.hashCode();
    private static final int drj = "time".hashCode();
    private static final int dzF = "localId".hashCode();
    private boolean dAj = true;
    private boolean dAk = true;
    private boolean djK = true;
    private boolean djP = true;
    private boolean dqQ = true;
    private boolean dzD = true;
    public String field_content;
    public long field_localId;
    public int field_subtype;
    public String field_tagContent;
    public long field_time;
    public int field_type;

    public static a Hm() {
        a aVar = new a();
        aVar.xDb = new Field[6];
        aVar.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "localId";
        aVar.xDd.put("localId", "LONG PRIMARY KEY ");
        stringBuilder.append(" localId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "localId";
        aVar.columns[1] = b.CONTENT;
        aVar.xDd.put(b.CONTENT, "TEXT");
        stringBuilder.append(" content TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "tagContent";
        aVar.xDd.put("tagContent", "TEXT");
        stringBuilder.append(" tagContent TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "time";
        aVar.xDd.put("time", "LONG");
        stringBuilder.append(" time LONG");
        stringBuilder.append(", ");
        aVar.columns[4] = "type";
        aVar.xDd.put("type", "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "subtype";
        aVar.xDd.put("subtype", "INTEGER default '0' ");
        stringBuilder.append(" subtype INTEGER default '0' ");
        aVar.columns[6] = "rowid";
        aVar.sql = stringBuilder.toString();
        return aVar;
    }

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dzF == hashCode) {
                    this.field_localId = cursor.getLong(i);
                    this.dzD = true;
                } else if (dkn == hashCode) {
                    this.field_content = cursor.getString(i);
                } else if (dAl == hashCode) {
                    this.field_tagContent = cursor.getString(i);
                } else if (drj == hashCode) {
                    this.field_time = cursor.getLong(i);
                } else if (dki == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (dAm == hashCode) {
                    this.field_subtype = cursor.getInt(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dzD) {
            contentValues.put("localId", Long.valueOf(this.field_localId));
        }
        if (this.djP) {
            contentValues.put(b.CONTENT, this.field_content);
        }
        if (this.dAj) {
            contentValues.put("tagContent", this.field_tagContent);
        }
        if (this.dqQ) {
            contentValues.put("time", Long.valueOf(this.field_time));
        }
        if (this.djK) {
            contentValues.put("type", Integer.valueOf(this.field_type));
        }
        if (this.dAk) {
            contentValues.put("subtype", Integer.valueOf(this.field_subtype));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
