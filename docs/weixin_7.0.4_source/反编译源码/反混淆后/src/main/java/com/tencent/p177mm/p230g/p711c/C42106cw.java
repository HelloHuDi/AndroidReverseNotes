package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.g.c.cw */
public abstract class C42106cw extends C4925c {
    private static final int dIY = FFmpegMetadataRetriever.METADATA_KEY_DATE.hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dwA = "count".hashCode();
    private boolean dIX = true;
    private boolean dwa = true;
    public int field_count;
    public String field_date;

    /* renamed from: Hm */
    public static C4924a m74227Hm() {
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[2];
        c4924a.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = FFmpegMetadataRetriever.METADATA_KEY_DATE;
        c4924a.xDd.put(FFmpegMetadataRetriever.METADATA_KEY_DATE, "TEXT");
        stringBuilder.append(" date TEXT");
        stringBuilder.append(", ");
        c4924a.columns[1] = "count";
        c4924a.xDd.put("count", "INTEGER");
        stringBuilder.append(" count INTEGER");
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

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
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
