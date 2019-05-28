package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.sdk.p603e.C4925c;

/* renamed from: com.tencent.mm.g.c.eo */
public abstract class C42117eo extends C4925c {
    private static final int dAG = Param.TIMESTAMP.hashCode();
    private static final int dFE = "step".hashCode();
    private static final int dIY = FFmpegMetadataRetriever.METADATA_KEY_DATE.hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dvy = "id".hashCode();
    private boolean dAw = true;
    private boolean dFD = true;
    private boolean dIX = true;
    private boolean dvv = true;
    public String field_date;
    public int field_id;
    public int field_step;
    public long field_timestamp;

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dvy == hashCode) {
                    this.field_id = cursor.getInt(i);
                    this.dvv = true;
                } else if (dIY == hashCode) {
                    this.field_date = cursor.getString(i);
                } else if (dFE == hashCode) {
                    this.field_step = cursor.getInt(i);
                } else if (dAG == hashCode) {
                    this.field_timestamp = cursor.getLong(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dvv) {
            contentValues.put("id", Integer.valueOf(this.field_id));
        }
        if (this.dIX) {
            contentValues.put(FFmpegMetadataRetriever.METADATA_KEY_DATE, this.field_date);
        }
        if (this.dFD) {
            contentValues.put("step", Integer.valueOf(this.field_step));
        }
        if (this.dAw) {
            contentValues.put(Param.TIMESTAMP, Long.valueOf(this.field_timestamp));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
