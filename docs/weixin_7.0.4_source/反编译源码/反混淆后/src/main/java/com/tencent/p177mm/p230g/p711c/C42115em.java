package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.p177mm.sdk.p603e.C4925c;

/* renamed from: com.tencent.mm.g.c.em */
public abstract class C42115em extends C4925c {
    private static final int dRQ = "logtime".hashCode();
    private static final int dRR = "logsize".hashCode();
    private static final int dRS = "errorcount".hashCode();
    public static final String[] diI = new String[]{"CREATE INDEX IF NOT EXISTS snsreport_kv_logtime ON SnsReportKv(logtime)"};
    private static final int diR = "rowid".hashCode();
    private static final int djh = "value".hashCode();
    private static final int dlb = "offset".hashCode();
    private boolean dRN = true;
    private boolean dRO = true;
    private boolean dRP = true;
    private boolean diZ = true;
    private boolean dkK = true;
    public int field_errorcount;
    public int field_logsize;
    public long field_logtime;
    public int field_offset;
    public byte[] field_value;

    /* renamed from: d */
    public void mo8995d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dRQ == hashCode) {
                    this.field_logtime = cursor.getLong(i);
                } else if (dlb == hashCode) {
                    this.field_offset = cursor.getInt(i);
                } else if (dRR == hashCode) {
                    this.field_logsize = cursor.getInt(i);
                } else if (dRS == hashCode) {
                    this.field_errorcount = cursor.getInt(i);
                } else if (djh == hashCode) {
                    this.field_value = cursor.getBlob(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dRN) {
            contentValues.put("logtime", Long.valueOf(this.field_logtime));
        }
        if (this.dkK) {
            contentValues.put("offset", Integer.valueOf(this.field_offset));
        }
        if (this.dRO) {
            contentValues.put("logsize", Integer.valueOf(this.field_logsize));
        }
        if (this.dRP) {
            contentValues.put("errorcount", Integer.valueOf(this.field_errorcount));
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
