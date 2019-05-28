package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.sdk.p603e.C4925c;

/* renamed from: com.tencent.mm.g.c.r */
public abstract class C9538r extends C4925c {
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dkV = "appId".hashCode();
    private static final int dlS = "version".hashCode();
    private static final int dmb = "source".hashCode();
    private static final int dmc = "hitCount".hashCode();
    private static final int dmd = "reportId".hashCode();
    private boolean dkE = true;
    private boolean dlM = true;
    private boolean dlY = true;
    private boolean dlZ = true;
    private boolean dma = true;
    public String field_appId;
    public int field_hitCount;
    public int field_reportId;
    public int field_source;
    public int field_version;

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dkV == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (dlS == hashCode) {
                    this.field_version = cursor.getInt(i);
                } else if (dmb == hashCode) {
                    this.field_source = cursor.getInt(i);
                } else if (dmc == hashCode) {
                    this.field_hitCount = cursor.getInt(i);
                } else if (dmd == hashCode) {
                    this.field_reportId = cursor.getInt(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dkE) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.dlM) {
            contentValues.put("version", Integer.valueOf(this.field_version));
        }
        if (this.dlY) {
            contentValues.put("source", Integer.valueOf(this.field_source));
        }
        if (this.dlZ) {
            contentValues.put("hitCount", Integer.valueOf(this.field_hitCount));
        }
        if (this.dma) {
            contentValues.put("reportId", Integer.valueOf(this.field_reportId));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
