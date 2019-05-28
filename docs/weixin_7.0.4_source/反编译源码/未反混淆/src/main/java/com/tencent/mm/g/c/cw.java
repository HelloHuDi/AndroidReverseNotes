package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public abstract class cw extends c {
    private static final int dIY = FFmpegMetadataRetriever.METADATA_KEY_DATE.hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dwA = "count".hashCode();
    private boolean dIX = true;
    private boolean dwa = true;
    public int field_count;
    public String field_date;

    public static a Hm() {
        a aVar = new a();
        aVar.xDb = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = FFmpegMetadataRetriever.METADATA_KEY_DATE;
        aVar.xDd.put(FFmpegMetadataRetriever.METADATA_KEY_DATE, "TEXT");
        stringBuilder.append(" date TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "count";
        aVar.xDd.put("count", "INTEGER");
        stringBuilder.append(" count INTEGER");
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
                if (dIY == hashCode) {
                    this.field_date = cursor.getString(i);
                } else if (dwA == hashCode) {
                    this.field_count = cursor.getInt(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dIX) {
            contentValues.put(FFmpegMetadataRetriever.METADATA_KEY_DATE, this.field_date);
        }
        if (this.dwa) {
            contentValues.put("count", Integer.valueOf(this.field_count));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
